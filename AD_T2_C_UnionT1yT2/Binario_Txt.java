/*
 A partir del fichero de objetos binarios creado en ejercicios anteriores. Realiza un
programa que lea dicho archivo y cree un fichero de texto (con FileWriter) que
almacene dichos registros, separando los campos de cada registro con �#�. El nombre
del fichero de texto a crear se parar� desde el int�rprete de comandos. La clase la
llamaremos ObjBinToTextFile
 */
package AD_T2_C_UnionT1yT2;

import AD_T1_B_FicherosObjetos.Departamento;
import AD_T1_B_FicherosObjetos.Empleado;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Vespertino
 */
public class Binario_Txt {

    //ARREGLAR!!!
    
    //CONVERTIR FICHERO BINARIO A TXT
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String nFichero;
        System.out.println("Como quieres llamar al fichero ? --> ");
        nFichero = sc.nextLine();

        //se crea el fichero txt con el nombre que le pasamos por terminal
        FileWriter fw = new FileWriter(nFichero);

        //creamos el objeto empleado que es lo que contiende el fichero binario
        Empleado em;
        //creamos el objeto departamento que es lo que contiende el fichero binario
        Departamento dep;
        //abre el fichero de objetos
        File fichero = new File("Departamentos.dat");
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

        try {
            while (true) { // lectura del fichero
                //le pasamos los datos leidos en el fichero de objeros al objeto departamento
                dep = (Departamento) dataIS.readObject();
                String txt;
                //agregamos contenido a la variable txt
                txt = (dep.getDept_no() + "#" + dep.getDnombre() + "#"
                        + dep.getLoc());

                //hacemos un iterator para leer una collecion de varios objetos
                Iterator itr = dep.getEmpleados().iterator();

                while (itr.hasNext()) {
                    //metemos los datps en la variable txt y lo escribimos en el fichero txt
                    fw.write(txt + itr.next() +"#");
                }
            }
        } catch (EOFException eo) {
            fw.close(); //cerramos el archivo
            System.out.println("\n" + "FIN DE LECTURA.");
        } catch (StreamCorruptedException x) {
        }
        //cerramos la lectura del fichero de objetos
        dataIS.close(); // cerrar stream de entrada
    }

}
