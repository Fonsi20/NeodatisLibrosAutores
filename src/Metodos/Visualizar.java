package Metodos;

import Objetos.Autores;
import Objetos.Libros;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
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

    static void LibrosAutor(Autores auto) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int i = 1;

        if (auto.getLibro().isEmpty()) {
            System.err.println("'ERROR' - Este autor no tiene ningun libro.");
        } else {
            for (Libros o : auto.getLibro()) {
                System.out.println((i++) + "\t: " + o.getCod() + " * " + o.getTitulo());
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

    public static void nacionalidadCantidad() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        Set<String> hs = new HashSet<>();
        IQuery query = new CriteriaQuery(Autores.class);

        Objects<Autores> objects2 = odb.getObjects(query);

        if (objects2.isEmpty()) {
            System.err.println("'ERROR' - No hay autores.");
        } else {
            while (objects2.hasNext()) {
                Autores autor = objects2.next();
                hs.add(autor.getNacionalidad());
            }
            for (String s : hs) {
                int contador = 0;

                IQuery query2 = new CriteriaQuery(Autores.class, Where.equal("nacionalidad", s));
                Objects<Autores> objects = odb.getObjects(query2);

                if (objects.isEmpty()) {
                    System.err.println(s + " No tiene autores.");
                } else {
                    while (objects.hasNext()) {
                        contador++;
                    }
                    System.out.println(s + " tiene tantos autores: " + contador);
                }
            }
        }
        odb.close();
    }

    public static void spainMenos60() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        int i = 1;

        ICriterion criterio = new And().add(Where.equal("nacionalidad", "Spain")).add(Where.le("edad", 60));
        CriteriaQuery query = new CriteriaQuery(Autores.class, criterio);

        Objects<Autores> objects2 = odb.getObjects(query);

        if (objects2.isEmpty()) {
            System.err.println("'ERROR' - No hay ningun autor español por debajo de los 60 Años.");
        } else {
            while (objects2.hasNext()) {
                Autores autor = objects2.next();
                System.out.println((i++) + "\t: " + autor.getDni() + " * " + autor.getNombre());
            }
        }
        odb.close();

    }

}
