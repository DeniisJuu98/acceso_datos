/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml;

import java.io.FileReader;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class Txt_Xml {

    FileReader read;
    String nombreFichero;
    Departamento dep;
    String cadena;
    EscribirXml es;
    ArrayList<Departamento> prue;

    //CONSTRUCTOR
    public Txt_Xml() {
        //POR SI QUIERES PEDIR EL NOMBRE DEL FICHERO AL USUARIO
        // Scanner sc = new Scanner(System.in);
        //System.out.println("Intrroduce el nombre del fichero+.txt");
        //nombreFichero=sc.next();

        //INICIAMOS EL ARRAY DE DEPARTAMENTOS 
        prue = new ArrayList<>();
        nombreFichero = "prueba3.txt";
        cadena = "";
        //LLAMAMOS A LA CLASE ESCRIBIR XML PARA QUE ESCRIBA EL XML CON LOS DATOS OBTENIDOS
        //DENIS !! AÑADIR MI CODIGO
        es = new EscribirXml();
        es.setMombreXml("txttoxml.xml");
        es.setXmlPadre("Departamentos");
        //LEE EL FICHERO DE TEXTO
        leerFichero();
    }

    private void leerFichero() {
        int valor = 0;
        try {
            //INICIAS LA LECTURA DEL FICHERO
            read = new FileReader(nombreFichero);
            //PARA CUANDO DEVUELVE MENOS UNO
            while (valor != -1) {

                valor = read.read();

                System.out.print((char) valor);
                //AÑADE LOS CARACTARES A LA CADENA VACIA
                cadena = cadena + (char) valor;
                if ((char) valor == '#') {
                    //LLAMA AL METODO CREAR DEPARTAMENTO||METE LOS DATOS EN UN 
                    //OBJETO DEPARTAMENTO
                    creaDepartamento();
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Txt_Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Txt_Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < prue.size(); i++) {
            System.out.println(prue.get(i));
        }
        try {
            //es.IntroducirDatos(prue);
            //SE CREARIA LOS DATOS DEL XML LLAMANDO AL METODO DE LA CLASE
            es.crearXml();
        } catch (IOException ex) {
            Logger.getLogger(Txt_Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void creaDepartamento() {
        System.out.println("\n");
        //System.out.println("cadena= "+cadena);
        //System.out.println("\n");
        //System.out.println("llega");
        //TE CREAS LAS VARIABLES CON EL TEXTO DE LOS DEPARTAMENTOS Y EMPLEADOS
        String departamento, empleados;
        //CREAS UNA ARRAY DE STRINGS
        String array[];
       
        //DECLARAS LOS OBJETOS
        Departamento d = new Departamento();
        Empleado e = new Empleado();
       
        departamento = cadena.substring(0, cadena.indexOf(", empleados="));
        empleados = cadena.substring(cadena.indexOf("[") + 1, cadena.indexOf("]") - 1);
        System.out.println(departamento);
        System.out.println(empleados);
        this.cadena = "";
        array = departamento.split(",");

        
        d.setDept_no(Integer.parseInt(array[0]));
        d.setNombre(array[1]);
        d.setLoc(array[2]);
       
        array = empleados.split(",");

        
        e.setEmp_no(Integer.parseInt(array[0]));
        e.setNombre(array[1]);
        e.setNombre(array[2]);
        e.setOficio(array[3].substring(0, array[3].length() - 1));
        d.setEmpleados(e);

        
        es.IntroducirDatos(d);
    }

    //MAIN
    public static void main(String[] args) {
        Txt_Xml a = new Txt_Xml();
    }

}
