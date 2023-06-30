/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml;


import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

/**
 *
 * @author Guiller
 */
public class EscribirXml {
    String mombreXml;
    String xmlPadre;
    ArrayList<Departamento> lista;

    public EscribirXml() {
        lista= new ArrayList<>();
    }

    public void setMombreXml(String mombreXml) {
        this.mombreXml = mombreXml;
    }

    public void setXmlPadre(String xmlPadre) {
        this.xmlPadre = xmlPadre;
    }
    
    
    
     public void crearXml() throws IOException {
        //variables para crear 
        
        //int  dep=0;        
        //String nombre="finanzas",loc="logroño",empleado="pepe",prueba="1",apellido="martinez";
        
        //comienza el codigo
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //el padre sera departamentos
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, xmlPadre, null);
            document.setXmlVersion("1.0");
            
            for (int i = 0; i < lista.size(); i++) {
                
            
            //departamento envuelve a cada registro suelto
            Element raiz =document.createElement("departamento");
            document.getDocumentElement().appendChild(raiz);
            //empleado es hijo de departamento
            Element raiz1 =document.createElement("empleado");
           // document.getDocumentElement().appendChild(raiz);
            raiz.appendChild(raiz1);
            
            crearElemento("dep", lista.get(i).getDept_no()+"", raiz, document);
            crearElemento("nombre", lista.get(i).getNombre(), raiz, document);
            crearElemento("loc", lista.get(i).getLoc(), raiz, document);
            crearElemento("emp",lista.get(i).getEmpleados().get(0).getEmp_no()+"",raiz1,document);
            crearElemento("apellido",lista.get(i).getEmpleados().get(0).getNombre(),raiz1,document);
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(mombreXml));
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
    
    public void IntroducirDatos(Departamento d){
        lista.add(d);
    }
}
