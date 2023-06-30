/*
Realizar un programa en Java que muestre los ficheros de un directorio. El nombre
del directorio se pasará desde los argumentos del main(). Si el directorio no existe se
debe mostrar un mensaje indicándolo.  
 */
package AD_T1_A_File_FicherosTexto;

/**
 *
 * @author Vespertino
 */
public class Prueba1Args {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error faltan argumentos");
        }else{
            System.out.println(args.length);
            System.out.println(args[0]);
            System.out.println(args[1]);
        }   
    }
    
}
