/*
Realiza un programa en Java que desde los argumentos del main(), reciba el nombre
de un directorio. El programa debe eliminar el directorio y todos los ficheros
contenidos en él.
 */
package AD_T1_A_File_FicherosTexto;

import java.io.File;

public class Ejercicio2 {

    public static void main(String[] args) {
        //comprobacion de datos pasados por "args"
        if (args.length != 1) {
            System.out.println("Error faltan argumentos");
        } else {
            try {
                //Creacion de File, en el que le pasamos el nombre del directorio
                //Desde "args"
                File f = new File(args[0]);
                //compruebas que "f" es un directorio, para entrar dentro de el.
                if (f.isDirectory()) {
                    //Guardas en un array de File todos los archivos dentro del
                    //del directorio pasado anteriormente
                    File[] archivos = f.listFiles();
                    //recorres todo el array y borras cada archivo, con . delete
                    for (int i = 0; i < archivos.length; i++) {
                        archivos[i].delete();
                    }
                    System.out.println("Se ha borrado con exito todos los ficheros");
                    //una vez borrados todos los archivos del directorio borras la carpeta.
                    f.delete();
                    System.out.println("Se ha borrado el directorio con exito");
                } else {
                    System.out.println("No se ha podido borrar");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
