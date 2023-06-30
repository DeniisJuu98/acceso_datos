/*
Realiza un programa en JAVA que dado un fichero de texto recibido como argumento
del main,muestre el número de veces que aparece una vocal determinada(tambien 
se enviara por el main), haciendo uso de los tres metodos read()de la clase 
FileReader
 */
package AD_T1_A_File_FicherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //comprobacion de datos pasados por "args"
        if (args.length != 2) {
            System.out.println("Error faltan argumentos");
            System.exit(0);
        } else {
            //Guarda en file el archivo pasado por parametro
            File fichero = new File(args[0]);
            //guarda la letra pasada por parametro
            String vocal = args[1];
            //convierte de string a char
            char letra = vocal.charAt(0);
            //declarar fichero reader, para leer el archivo de texto
            FileReader fic = new FileReader(fichero); //crear el flujo de entrada  
            int i;
            char aux;
            int contador=0;
            //va leyendo caracter a caracter dentro del fichero de texto.
            while ((i = fic.read()) != -1) //se va leyendo un car�cter
                
            {
                aux = (char) i;
                if (aux==Character.toLowerCase(letra)||aux==Character.toUpperCase(letra)) {
                    contador ++;
                }
            }
            //muestra las veces que se ha encontrado con la letra, 
            //tanto minuscula como mayuscla.
            System.out.println("El numero de letras es: "+contador);
            //importante cerrar el fichero despues.
            fic.close(); //cerrar fichero  
        }
    }

}
