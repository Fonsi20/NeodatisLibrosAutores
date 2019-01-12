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
public class Validaciones {

    public static int validarDNI(String dni) {

        String letraMayuscula = "";
        if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            return 1;
        }

        letraMayuscula = (dni.substring(8)).toUpperCase();
        if (soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static boolean soloNumeros(String dni) {

        int i, j = 0;
        String numero = "";
        String miDNI = "";
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (i = 0; i < dni.length() - 1; i++) {
            numero = dni.substring(i, i + 1);

            for (j = 0; j < unoNueve.length; j++) {
                if (numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }

        if (miDNI.length() != 8) {
            return false;
        } else {
            return true;
        }
    }

    public static String letraDNI(String dni) {
        int miDNI = Integer.parseInt(dni.substring(0, 8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }

    public static void titulosAutor() throws IOException {

        ODB odb = ODBFactory.openClient("localhost", 8000, "LibrosAutores");
        int opc = 0;

        do {
            System.out.println("\nVer los libros de un autor.\nIntroduce el nombre del autor:\n");
            Visualizar.AutorNombre();
            System.out.println("> ");
            String nombre = read.readLine();

            IQuery query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre));
            Objects<Autores> objects = odb.getObjects(query);

            if (objects.isEmpty()) {

                opc = 1;
                System.err.println("'ERROR' - No existe ningun autor con ese Nombre.");

            } else {
                opc = 0;
                Autores auto = (Autores) odb.getObjects(query).getFirst();
                Visualizar.LibrosAutor(auto);
            }
        } while (opc != 0);

        odb.close();

    }
}
