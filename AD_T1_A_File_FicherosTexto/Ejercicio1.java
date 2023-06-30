/*
Realizar un programa en Java que muestre los ficheros de un directorio. El nombre
del directorio se pasará desde los argumentos del main(). Si el directorio no existe se
debe mostrar un mensaje indicándolo.
 */
package AD_T1_A_File_FicherosTexto;

import java.io.File;
import java.nio.file.Files;

public class Ejercicio1 {

    public static void main(String[] args) {
        //comprobacion de datos pasados por "args"
        if (args.length != 1) {
            System.out.println("Error faltan argumentos");
        } else {
            //Creacion de File, en el que le pasamos el nombre del directorio
            //Desde "args"
            File f = new File(args[0]);
            //Guardas en un array de Files, todos los archivos y directorios, del 
            //file paso anteriormente. "variable = f"
            File[] archivos = f.listFiles();
            System.out.printf("Ficheros en el directorio actual:");
            // Saca por pantalla el nombre de los ficheros / directorios del array.
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i].getName());
            }
        }
    }
}
