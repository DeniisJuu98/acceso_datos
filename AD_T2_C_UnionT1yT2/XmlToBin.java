package AD_T2_C_UnionT1yT2;


import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlToBin {

    public static void main(String[] args) {
        //HACEMOS UN ARRAY DE DEPARTAMENTOS
        ArrayList<Departamento> deps;
        //CREAMOS LOS OBJETOS
        Departamento dep;
        Empleado emp;
        //INICIAMOS EL ARRAY
        deps= new ArrayList<>();

        //LLAMAMOS A LA FACTORIA
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //INICIAMOS LOS METODOS DE LECTURA DE XML
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("txttoxml.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            //crea una lista con todos los nodos empleado  
            NodeList empleados = document.getElementsByTagName("departamento");
            System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());

            //recorrer la lista  
            for (int i = 0; i < empleados.getLength(); i++) {
                //INICIAMOS LOS OBJETOS NUEVOS 
                dep = new Departamento();
                emp = new Empleado();
                Node emple = empleados.item(i); //obtener un nodo empleado
                if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo           
                    Element elemento = (Element) emple;
                    //MOSTRAMOS LOS DATOS
                    // if(elemento.getElementsByTagName("dep").item(0).getTextContent().equals(dato)){
                    System.out.printf("Dep = %s %n", elemento.getElementsByTagName("dep").item(0).getTextContent());
                    System.out.printf(" * nombre = %s %n", elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.printf(" * localizacion = %s %n", elemento.getElementsByTagName("loc").item(0).getTextContent());
                    System.out.printf(" * empleado = %s %n", elemento.getElementsByTagName("empleado").item(0).getTextContent());
                    //INTRODUCIMOS LOS DATOS EN DEPARTAMENTO
                    dep.setDept_no(Integer.parseInt(elemento.getElementsByTagName("dep").item(0).getTextContent()));
                    dep.setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    dep.setLoc(elemento.getElementsByTagName("loc").item(0).getTextContent());
                    //INTRODUCIMOS LOS DATOS EN EMPLEADO
                    emp.setMep_no(Integer.parseInt(elemento.getElementsByTagName("empleado").item(0).getChildNodes().item(1).getTextContent()));
                    emp.setApellido(elemento.getElementsByTagName("empleado").item(0).getChildNodes().item(3).getTextContent());

                    //SETEAMOS LOS EMPLEADOS EN EL DEPARTAMENTO
                    dep.setEmpleados(emp);
                    //AÑADIMOS EL DEPARTAMENTO AL ARRAY!!
                    deps.add(dep);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //CREAMOS EL FICHERO DE OBJETOS, PASANDOLE LA COLLECION DE DEPARTAMENTOS
        crearBin(deps);

    }//fin de main 

    private static void crearBin(ArrayList<Departamento> deps) {
        ObjectOutputStream w;
        //CREAMOS EL FICHERO
        try{
        w= new ObjectOutputStream(new FileOutputStream("xmlToBin2.dat",true));
        //INTRODUCIMOS LOS DATOS
            for (int i = 0; i < deps.size(); i++) {
                w.writeObject(deps.get(i));
            }
            //CERRAMOS
        w.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlToBin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlToBin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//fin de la clase

