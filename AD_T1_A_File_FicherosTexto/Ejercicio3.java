/*
Escribe un programa que reciba desde los argumentos del main(), el nombre de un
directorio y una extensión (“txt”, “pdf”, “docx” ..) y localice y muestre por pantalla
SOLO, los nombres de los archivos con esa extensión que se encuentran en ese
directorio recibido.
 */
package AD_T1_A_File_FicherosTexto;

import java.io.File;

public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println();
        //comprobacion de datos pasados por "args"
        if (args.length != 2) {
            System.out.println("Error faltan argumentos");
        } else {
            //Guardas en file el nombre del directorio
            //Guardas la extension
            File f = new File(args[0]);
            String f1 = args[1];
            //Guardas en el interior del array todos los archivos del directorio
            File[] archivos = f.listFiles();
            
            System.out.println("Ficheros en el directorio actual:");
            //muestras los archivos acabados en esa extension
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].getName().contains(".") && archivos[i].getName().substring(archivos[i].getName().lastIndexOf("."), archivos[i].getName().length()).equals(f1)) {
                    System.out.println(archivos[i].getName());
                }
            }
        }
    }

}
