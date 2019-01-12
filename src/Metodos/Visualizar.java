package Metodos;

import Objetos.Autores;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 *
 * @author mallo
 */
public class Visualizar {

    static void AutorDNI() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        Objects<Autores> objects = odb.getObjects(Autores.class);
        int i = 1;

        while (objects.hasNext()) {
            Autores autor = objects.next();
            System.out.println((i++) + "\t: " + autor.getDni() + " * " + autor.getNombre());
        }
        odb.close();
    }

    static void AutorNombre() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        Objects<Autores> objects = odb.getObjects(Autores.class);
        int i = 1;

        while (objects.hasNext()) {
            Autores autor = objects.next();
            System.out.println((i++) + "\t: " + autor.getDni() + " * " + autor.getNombre());
        }
        odb.close();
    }

    static void LibrosAutor(Autores auto) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        int tamaño = auto.getLibro().size();
        int i = 0;

 
        odb.close();
    }

}
