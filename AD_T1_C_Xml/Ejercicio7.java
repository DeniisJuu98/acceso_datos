/*
Realizar un programa que pida un dept_no al usuario y tras pulsar un botón, muestre
en un JTextArea el contenido con los datos de ese departamento, tras leer el fichero
XML del ejercicio anterior. En el caso de no existir mostrará el mensaje “EL INDICADO
DEPARTAMENTO NO EXISTE”
 */
package AD_T1_C_Xml;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Vespertino
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Scanner sc = new Scanner(System.in);
        String dep_num ;

        System.out.println("Introduce un numero de departamento: ");
        dep_num = sc.nextLine();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Departamentos"));

            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            //crea una lista con todos los nodos empleado  
            NodeList departamentos = document.getElementsByTagName("Departamentos");
            System.out.printf("Nodos empleado a recorrer: %d %n", departamentos.getLength());

            //recorrer la lista  
            for (int i = 0; i < departamentos.getLength(); i++) {
                Node depart = departamentos.item(i); //obtener un nodo departamento
                Node emple = departamentos.item(i); //obtener un nodo empleado
                if (depart.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo           
                    Element elemento = (Element) depart;
                    if (elemento.getElementsByTagName("dept_no").item(0).getTextContent().equals(dep_num)) {
                        System.out.printf("Dept_no = %s %n", elemento.getElementsByTagName("dept_no").item(0).getTextContent());
                        System.out.printf(" * Nombre = %s %n", elemento.getElementsByTagName("nombre").item(0).getTextContent());
                        System.out.printf(" * Localidad = %s %n", elemento.getElementsByTagName("localidad").item(0).getTextContent());
                        if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                            //obtener los elementos del nodo           
                            Element elemento2 = (Element) emple;
                            System.out.printf("Emp_num = %s %n", elemento2.getElementsByTagName("emp_num").item(0).getTextContent());
                            System.out.printf(" * Apellido = %s %n", elemento2.getElementsByTagName("apellido").item(0).getTextContent());
                        }
                    } else {
                        System.out.println("EL INDICADO DEPARTAMENTO NO EXISTE");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//fin de main 
}//fin de la clase

