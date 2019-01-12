package Metodos;

import Objetos.Autores;
import Objetos.Libros;
import java.io.IOException;
import static librosautores.EntradaTeclado.read;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author mallo
 */
public class Borrados {

    public static void borrarLibro() throws IOException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int opc = 0, opc2 = 0;

        do {
            System.out.println("\nBorrar un libro de un autor.\nEscoge a un autor, escribe su nombre completo:\n");
            Visualizar.AutorNombre();
            System.out.print("> ");
            String nombre = read.readLine();

            IQuery query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre));
            Objects<Autores> objects = odb.getObjects(query);

            if (objects.isEmpty()) {
                opc = 1;
                System.err.println("'ERROR' - No existe ningun autor con ese Nombre.");

            } else {
                do {
                    Autores auto = (Autores) odb.getObjects(query).getFirst();
                    System.out.println("\nEscoge a un Libro por su código:");
                    Visualizar.LibrosAutor(auto);
                    System.out.print("> ");
                    String cod = read.readLine();

                    IQuery query2 = new CriteriaQuery(Libros.class, Where.equal("cod", cod));
                    Objects<Libros> objects2 = odb.getObjects(query2);

                    if (objects2.isEmpty()) {
                        opc = 1;
                        System.err.println("'ERROR' - No existe ningun Libro con ese Codigo.");
                    } else {
                        opc = 0;
                        Libros lib = (Libros) odb.getObjects(query2).getFirst();
                        odb.delete(lib);
                    }
                } while (opc2 != 0);
            }
        } while (opc != 0);

        odb.close();

    }

}
