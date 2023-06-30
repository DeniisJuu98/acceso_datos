/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T2_C_UnionT1yT2;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Ej1MySQL_a_XML {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.209.128:3306/ejemplo", "USUARIO", "curso2122");

            // construir orden INSERT
            String sql = "select e.* ,d.dnombre from empleados e inner join departamentos d on (d.dept_no=e.dept_no); ";

            ResultSet rs;
            rs = sacarConsulta(conexion, sql);//saca la consulta

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument(null, "Empleados", null);
                document.setXmlVersion("1.0");

                while (rs.next()) {
                    // System.out.println(rs.getString("apellido") + " " + rs.getFloat("salario") + " " + rs.getString("oficio"));

                    Element raiz = document.createElement("Empleado"); //nodo raiz Departamento
                    document.getDocumentElement().appendChild(raiz);

                    //a�adir dept_no                     
                    crearElemento("emp_no", rs.getString(1), raiz, document);
                    //nombre
                    crearElemento("apellido", rs.getString(2), raiz, document);
                    //a�adir loca
                    crearElemento("oficio", rs.getString(3), raiz, document);

                    crearElemento("dir", rs.getString(4), raiz, document);

                    crearElemento("fecha_alt", rs.getString(5), raiz, document);

                    crearElemento("salario", rs.getString(6), raiz, document);

                    crearElemento("comision", rs.getString(7), raiz, document);

                    crearElemento("dept_no", rs.getString(8), raiz, document);

                    crearElemento("dnombre", rs.getString(9), raiz, document);

                }
                rs.close();
                //añade y crea un fichero xml, y añade los datos guardados en memoria
                Source source = new DOMSource(document);
                Result result = new StreamResult(new java.io.File("Empleados.xml"));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);

            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }// fin de main

    private static ResultSet sacarConsulta(Connection conexion, String sql) throws SQLException {
        System.out.println(sql);
        PreparedStatement sentencia
                = conexion.prepareStatement(sql);

        try {
            ResultSet rs = sentencia.executeQuery(); //es Query es para hacer consultas select
            // Nos recoremos los objetos de la coleccion
           
            return rs;

        } catch (SQLException e) {
            System.out.println("HA OCURRIDO UNA EXCEPCI�N:");
            System.out.println("Mensaje:    " + e.getMessage());
            System.out.println("SQL estado: " + e.getSQLState());
            System.out.println("C�d error:  " + e.getErrorCode());
        }

        sentencia.close(); // Cerrar Statement
        conexion.close(); // Cerrar conexi�n
        return null;
    }

    static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }

}
