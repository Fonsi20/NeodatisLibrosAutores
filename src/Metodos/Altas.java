package Metodos;

import ComprobacionesErrores.Comprobaciones;
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
 * @author a16alfonsofa
 */
public class Altas {

    public static void Autor() throws IOException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        String dni, nombre, direccion, nacionalidad;
        int edad, opc = 0;

        IQuery query;
        System.out.println("\nNombre:");
        nombre = read.readLine();

        System.out.println("Deporte:");
        dni = read.readLine();

        System.out.println("Ciudad:");
        direccion = read.readLine();

        System.out.println("Ciudad:");
        nacionalidad = read.readLine();

        System.out.println("Edad:");
        edad = Integer.parseInt(read.readLine());

        query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
        Objects<Autores> objects = odb.getObjects(query);

        if (objects.isEmpty()) {

            Autores autor = new Autores(dni, nombre, direccion, edad, nacionalidad);
            odb.store(autor);
            
            System.err.println("----------------------------------------------"
                    + "\nAñade libros del autor " + nombre + ": \n");
            do {
                Libro();
                opc = Comprobaciones.PreguntaSiNO();
            } while (opc != 1);

        } else {
            System.err.println("Ya existe ese autor en la BBDD.");
        }
        odb.close();

    }

    public static void Libro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
