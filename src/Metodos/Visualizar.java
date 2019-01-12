package Metodos;

import Objetos.Autores;
import Objetos.Libros;
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

    static void LibrosAutor(Objects<Autores> objects) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int i = 1;
        
        if (objects.isEmpty()) {
            System.err.println("'ERROR' - Este autor no tiene ningun libro.");
        } else {
            while (objects.hasNext()) {
                Autores autor = objects.next();
            }
        }

        odb.close();
    }

    public static void verItalianos() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        int i = 1;

        IQuery query = new CriteriaQuery(Autores.class, Where.equal("nacionalidad", "Italia"));
        Objects<Autores> objects2 = odb.getObjects(query);

        if (objects2.isEmpty()) {
            System.err.println("'ERROR' - No hay ningun autor Italiano.");
        } else {
            while (objects2.hasNext()) {
                Autores autor = objects2.next();
                System.out.println((i++) + "\t: " + autor.getDni() + " * " + autor.getNombre());
            }
        }
        odb.close();
    }

    public static void librosAutorFechas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
