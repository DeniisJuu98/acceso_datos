/*
Siguiendo la estructura de los ficheros del ejercicio anterior del fichero de objetos
binario, realizar un programa que solicite lo datos de varios departamentos (hasta
que el usuario introduzca -1 en el código del departamento) y cree un fichero XML
haciendo uso de DOM con los datos de ese departamento. En esta primera versión
básica, haremos que la colección de empleados sólo un único empleado por
departamento. Fijate en el resultado siguiente como ejemplo:
 */
package AD_T1_C_Xml;

import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Datos_Xml {

    //DATOS A XML
    public static void main(String[] args) throws IOException {
        
        //con la clase faker introducimos los datos en el array
        Faker f = new Faker();

        String nombre[] = new String[10];
        String localidad[] = new String[10];

        int emp_num[] = new int[10];
        String apellido[] = new String[10];
        int num = 1;

        //Como en este caso los datos se introducen de manera automatica y no leemos
        //un fichero, no hace falta la clase File para leer.
        
        //Creamos la Factoria
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            //Creamos un documento DOM en memoria con nodo Departamentos
            Document document = implementation.createDocument(null, "Departamentos", null);
            document.setXmlVersion("1.0");
            
            //Como se quiere introducir 10 empleados se meten los datos
            for (int i = 0; i < 10; i++) {
                
                nombre[i] = f.job().title();
                localidad[i] = f.address().city();

                emp_num[i] = f.number().numberBetween(1, 1000);
                apellido[i] = f.name().lastName();

                //Creamos el nodo raiz
                Element raiz = document.createElement("Departamento"); //nodo raiz Departamento
                document.getDocumentElement().appendChild(raiz);//append - raiz

                //a�adir dept_no //los metemos en el nodo raiz anterior                    
                crearElemento("dept_no", Integer.toString(num), raiz, document);
                //nombre
                crearElemento("nombre", nombre[i], raiz, document);
                //a�adir loca
                crearElemento("localidad", localidad[i], raiz, document);

                //Creamos un nuevo nodo subraiz
                Element subRaiz1 = document.createElement("empleados"); //nodo subraiz empleados
                //IMPORTANTE!!! EMPEZAMOS PONIENDO RAIZ Y LUEGO LO AÑADIMOS COMO SUBRAIZ
                raiz.appendChild(subRaiz1);
                
                Element subRaiz2 = document.createElement("empleado"); //nodo empleado
                //IMPORTANTE!!! EMPEZAMOS PONIENDO SUBRAIZ1 Y LUEGO LO AÑADIMOS COMO SUBRAIZ
                subRaiz1.appendChild(subRaiz2);

                //añadimos los datos en la subraiz 2
                //a�adir emp_num                      
                crearElemento("emp_num", Integer.toString(emp_num[i]), subRaiz2, document);
                //Apellido
                crearElemento("apellido", apellido[i], subRaiz2, document);
                num++;
            }
            
            //añade y crea un fichero xml, y añade los datos guardados en memoria
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Departamentos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    //CLASE PARA CREAR LOS ELEMENTOS
    static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }

}
