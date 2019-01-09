package ComprobacionesErrores;

import java.io.IOException;
import static librosautores.EntradaTeclado.read;

/**
 *
 * @author a16alfonsofa
 */
public class Comprobaciones {

    public static int PreguntaSiNO() throws IOException {
        int resul = 0;
        System.out.println("Desea continuar?  (0 - SI / 1 - NO):\n");
        resul = Integer.parseInt(read.readLine());
        if (resul > 1 && resul < 0) {
            System.err.println("'Error' No se introdujo un valor válido.");
            resul = 1;
        }
        return resul;
    }

}
