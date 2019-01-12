package librosautores;

import Metodos.Altas;
import Metodos.Borrados;
import Metodos.Modificaciones;
import Metodos.Validaciones;
import Metodos.Visualizar;
import java.io.IOException;
import java.text.ParseException;
import static librosautores.EntradaTeclado.read;

/**
 *
 * @author a16alfonsofa
 */
class Menu {

    public static void MenuPrincipal() throws IOException, ParseException {

        int opc = 0;

        do {

            System.out.println("\n\nBienvenido al programa encargado de Libros y Autores.\n"
                    + "Propiedad de: Alfonso Fernández Álvarez\n"
                    + "----------------------------------------------------------------------------------------\n"
                    + "  1  /  Altas de un Autor con todos sus Libros.\n"
                    + "  2  /  Alta de un libro nuevo, añadiendo un Autor.\n"
                    + "\n"
                    + "  3  /  Modificar la direccion de un Autor buscando por DNI.\n"
                    + "  4  /  Modificar el precio de un libro, buscando por Titulo y Autor.\n"
                    + "\n"
                    + "  5  /  Borrado de libros, dando el nombre de un autor y codigo del libro.\n"
                    + "\n"
                    + "  6  /  Consulta de todos los autores de nacionalidad ITALIANA.\n"
                    + "  7  /  Consulta de los libros escritos por un autor determinado entre dos fechas.\n"
                    + "\n"
                    + "  8  /  Visualizar todos los autores SPAIN menores de 60 años.\n"
                    + "  9  /  Viusalizar por Nacionalidad el numero de autores.\n"
                    + "\n"
                    + "  10 /  Dando el nombre del autor que nos visualice todos los titulos.\n"
                    + "\n"
                    + "  11 /  SALIR DEL PROGRAMA\n"
                    + "----------------------------------------------------------------------------------------\n");

            opc = Integer.parseInt(read.readLine());

            switch (opc) {

                case 1:
                    Altas.Autor();
                    break;
                case 2:
                    Altas.Libro();
                    break;
                case 3:
                    Modificaciones.modDirec();
                    break;
                case 4:
                    Modificaciones.modPrecio();
                    break;
                case 5:
                    Borrados.borrarLibro();
                    break;
                case 6:
                    Visualizar.verItalianos();
                    break;
                case 7:
                    Visualizar.librosAutorFechas();
                    break;
                case 8:
                    Visualizar.spainMenos60();
                    break;
                case 9:
                    Visualizar.nacionalidadCantidad();
                    break;
                case 10:
                    Validaciones.titulosAutor();
                    break;
                case 11:
                    System.err.println("Adios!");
                    break;
                default:
                    System.err.println("'Error', elija una opción porfavor");
                    break;

            }

        } while (opc != 11);

    }

}
