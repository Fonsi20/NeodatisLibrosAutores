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
public class Modificaciones {

    public static void modDirec() throws IOException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int opc = 0;
        String nuevaDireccion;

        do {
            Visualizar.AutorDNI();
            System.out.println("\nIntroduce el DNI del autor del cual desea modificar la direccion.");
            String dni = read.readLine();

            IQuery query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
            Objects<Autores> objects = odb.getObjects(query);

            if (objects.isEmpty()) {

                opc = 1;
                System.err.println("'ERROR' - No existe ningun autor con ese DNI.");

            } else {

                opc = 0;

                Autores auto = (Autores) odb.getObjects(query).getFirst();
                System.out.println("La dirección actual de " + auto.getNombre() + " es: \t" + auto.getDireccion() + "\n"
                        + "Introduce una nueva dirección:");
                nuevaDireccion = read.readLine();

                auto.setDireccion(nuevaDireccion);
                odb.store(auto);

            }
        } while (opc != 0);

        odb.close();

    }

    public static void modPrecio() throws IOException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int opc = 0, opc2 = 0;
        float newPrice;

        do {
            System.out.println("\nCambiador de precios de libros.\nEscoge a un autor, escribe su nombre completo:\n");
            Visualizar.AutorNombre();
            String nombre = read.readLine();

            IQuery query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre));
            Objects<Autores> objects = odb.getObjects(query);

            if (objects.isEmpty()) {

                opc = 1;
                System.err.println("'ERROR' - No existe ningun autor con ese Nombre.");

            } else {

                do {
                    Autores auto = (Autores) odb.getObjects(query).getFirst();
                    System.out.println("\nEscoge a un Libro por su Titulo:");
                    Visualizar.LibrosAutor(auto);
                    System.out.print("> ");
                    String Titulo = read.readLine();

                    IQuery query2 = new CriteriaQuery(Libros.class, Where.equal("Titulo", Titulo));
                    Objects<Libros> objects2 = odb.getObjects(query2);

                    if (objects2.isEmpty()) {
                        opc = 1;
                        System.err.println("'ERROR' - No existe ningun Libro con ese Titulo.");
                    } else {
                        opc = 0;
                        Libros lib = (Libros) odb.getObjects(query2).getFirst();
                        System.out.println("El precio actual de " + lib.getTitulo() + " es: \t" + lib.getPrecio() + "\n"
                                + "Introduce una nuevo precio:");
                        newPrice = Float.parseFloat(read.readLine());

                        lib.setPrecio(newPrice);
                        odb.store(lib);
                    }
                } while (opc2 != 0);
            }
        } while (opc != 0);

        odb.close();

    }

}
