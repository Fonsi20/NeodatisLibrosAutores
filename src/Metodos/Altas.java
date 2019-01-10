package Metodos;

import ComprobacionesErrores.Comprobaciones;
import Objetos.Autores;
import Objetos.Libros;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static void Autor() throws IOException, ParseException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        Autores autor = null;
        String dni, nombre, direccion, nacionalidad;
        int edad, opc = 0;

        IQuery query;

        System.out.println("\nNombre:");
        nombre = read.readLine();

        System.out.println("DNI:");
        dni = read.readLine();

        System.out.println("Direccion:");
        direccion = read.readLine();

        System.out.println("Nacionalidad:");
        nacionalidad = read.readLine();

        System.out.println("Edad:");
        edad = Integer.parseInt(read.readLine());

        query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
        Objects<Autores> objects = odb.getObjects(query);

        if (objects.isEmpty()) {

            autor = new Autores(dni, nombre, direccion, edad, nacionalidad);

            System.err.println("----------------------------------------------"
                    + "\nAñade libros del autor " + nombre + ": \n");
            do {
                AñadirLibro(autor);
                opc = Comprobaciones.PreguntaSiNO();
            } while (opc != 1);

        } else {
            System.err.println("Ya existe ese autor en la BBDD.");
        }
        odb.store(autor);
        odb.close();

    }

    public static void Libro() throws IOException, ParseException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        Libros libro = null;
        String Titulo, Categoria, fecha;
        Date fechaPublicacion;
        float Precio;
        int cod, opc = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        IQuery query;

        System.out.println("\nTitulo:");
        Titulo = read.readLine();

        System.out.println("Codigo:");
        cod = Integer.parseInt(read.readLine());

        System.out.println("Categoria:");
        Categoria = read.readLine();

        System.out.println("Fecha Publicacion: (dd/MM/yyyy)");
        fecha = read.readLine();
        fechaPublicacion = sdf.parse(fecha);

        System.out.println("Precio:");
        Precio = Float.parseFloat(read.readLine());

        query = new CriteriaQuery(Libros.class, Where.equal("cod", cod));
        Objects<Libros> objects = odb.getObjects(query);

        if (objects.isEmpty()) {

            libro = new Libros(cod, Titulo, Categoria, Precio, fechaPublicacion);

            System.err.println("----------------------------------------------"
                    + "\nAñade un autor al libro " + Titulo + ": \n");
            do {
                AñadirAutor();
                opc = Comprobaciones.PreguntaSiNO();
            } while (opc != 1);

        } else {
            System.err.println("Ya existe ese libro con ese codigo en la BBDD.");
        }
        odb.store(libro);
        odb.close();
    }

    private static void AñadirLibro(Autores autor) throws IOException, ParseException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");

        String Titulo, Categoria, fecha;
        Date fechaPublicacion;
        float Precio;
        int cod;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        IQuery query;

        System.out.println("\nTitulo:");
        Titulo = read.readLine();

        System.out.println("Codigo:");
        cod = Integer.parseInt(read.readLine());

        System.out.println("Categoria:");
        Categoria = read.readLine();

        System.out.println("Fecha Publicacion: (dd/MM/yyyy)");
        fecha = read.readLine();
        fechaPublicacion = sdf.parse(fecha);

        System.out.println("Precio:");
        Precio = Float.parseFloat(read.readLine());

        query = new CriteriaQuery(Libros.class, Where.equal("cod", cod));
        Objects<Libros> objects = odb.getObjects(query);

        if (objects.isEmpty()) {

            Libros libro = new Libros(cod, Titulo, Categoria, Precio, fechaPublicacion);
            autor.getLibro().add(libro);
            System.out.println(autor.getLibro());

        } else {
            System.err.println("Ya existe ese libro con ese codigo en la BBDD.");
        }
        odb.close();
    }

    private static void AñadirAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
