package AD_T1_C_Xml;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXmlPrueba {

    public static void main(String args[]) throws IOException {
     
     
        //variables para crear 
        
        int  dep=0;        
        String nombre="finanzas",loc="logroño",empleado="pepe",prueba="1",apellido="martinez";
        
        //comienza el codigo
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //el padre sera departamentos
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Departamentos", null);
            document.setXmlVersion("1.0");
            //departamento envuelve a cada registro suelto
            Element raiz =document.createElement("departamento");
            
            //empleado es hijo de departamento
            Element raiz1 =document.createElement("empleado");
           // document.getDocumentElement().appendChild(raiz);
            
            for (int i = 0; i < 2; i++) {
                document.getDocumentElement().appendChild(raiz);
            raiz.appendChild(raiz1);
            
            
            crearElemento("dep", i+"", raiz, document);
            crearElemento("nombre", nombre, raiz, document);
            crearElemento("loc", loc, raiz, document);
            //crearElemento("empleado",empleado,raiz,document);
            crearElemento("emp",prueba,raiz1,document);
            crearElemento("apellido",apellido,raiz1,document);
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Prueba3.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

      //  file.close();  //cerrar fichero 	
    }//fin de main

    //Inserci�n de los datos del empleado
    static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
}//fin de la clase

