package Metodos;

import Objetos.Autores;
import Objetos.Libros;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static librosautores.EntradaTeclado.read;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
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

    public static void librosAutorFechas() throws IOException, ParseException {
        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        
        int i = 1;
        
        String fechaInicio, fechaFin;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Consulta los libros publicados por un autor entre dos fecha.\n"
                + "Introduce el DNI del autor a consultar:");

        AutorNombre();

        System.out.print("> ");
        String dni = read.readLine();

        System.out.print("Introduce la fecha de INICIO:\n> ");
        fechaInicio = read.readLine();
        Date fechaPublicacion = sdf.parse(fechaInicio);

        System.out.print("Introduce la fecha de FIN:\n> ");
        fechaFin = read.readLine();
        Date fechaPublicacionFIN = sdf.parse(fechaFin);

        ICriterion criterio = new And().add(Where.gt("fechaPublicacion", fechaPublicacion)).add(Where.le("fechaPublicacion", fechaPublicacionFIN));
        CriteriaQuery query = new CriteriaQuery(Libros.class, criterio);

        Objects<Libros> objects2 = odb.getObjects(query);

        if (objects2.isEmpty()) {
            System.err.println("'ERROR' - No hay ningun autor español por debajo de los 60 Años.");
        } else {
            while (objects2.hasNext()) {
                Libros lib = objects2.next();
                System.out.println((i++) + "\t: " + lib.getCod() + " * " + lib.getTitulo() + " * " + lib.getFechaPublicacion());
            }
        }
        odb.close();

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
