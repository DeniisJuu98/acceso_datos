/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml_Victor_Txt_xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Victor
 */
public class Convert {
    // Varaibles para el XML, globales ya que las uso en mas de un metodo
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static DOMImplementation implementation;
    private static Document document;
    private static Element raizArchivo, raizPokemon, raizTipoP, raizTipoM, raizTipoS;
    
    public static void main(String[] args) {
        conversor();
    }

    private static void conversor() {
        Pokemon p = null;
        FileReader fr = null;
        try {
            // Creo el File Reader y preparo las variables auxiliares que necesito
            fr = new FileReader(new File("./pokemon.txt"));
            int c; //Para revisar que no sea -1
            StringBuilder sb; //Para hacer un String con la linea entera
            char ch; //Para añadir los caracteres
            
            // Construyo la cabecera del XML, con la raiz principal
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "pokemones", null);
            document.setXmlVersion("1.0");
            raizArchivo = document.createElement("pokemones");

            // El primer bucle lee el primer caracter tras el \n y revisa si es -1 para salir si ha leido todo
            //Tambien convierte el valor entero al char e instancia el StringBuilder
                while ((c = fr.read())!=-1) {
                    ch = (char) c;
                    sb = new StringBuilder();
                    //El segundo bucle lee el resto de la linea hasta el \n
                    while (ch!='\n' ) {      
                        //Este if es porque al final del fichero me mete este caracter (seguramente por editarlo a mano), no deberia ser necesario
                        if (ch=='\uffff') {
                            break;
                        }
                        //Añadimos un nuevo caracter
                        sb.append(ch);
                        ch = (char) fr.read();
                    }
                    //Cada linea corresponde a un registro, por lo que convertimos el texto
                    // al objeto en ram, y luego a XML
                    p = textoAPokemon(sb.toString());
                    pokemonAXML(p);
                }
                
            // Hacemos las cosas para guardar el xml en disco    
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./pokemon.xml"));
            Transformer transformer;
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result); 
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static Pokemon textoAPokemon(String cadena) { 
        Pokemon p = new Pokemon();
        Tipos t;
        // Spliteamos la cadena y segun la posicion del dato lo seteamos en el parametro del objeto
        String[] tokens = cadena.split("#");
        p.setIdPokemon(Integer.parseInt(tokens[0]));
        p.setNombrePokemon(tokens[1]);
        
        // Los tipos los hago asi porque son objetos con varias propiedades y uno puede ser null
        t = new Tipos(Integer.parseInt(tokens[2]));
        t.setNombreTipo(tokens[3]);
        p.setTiposByTipoPrimario(t);
        if (tokens[4].equals("null")) {
            p.setTiposByTipoSecundario(null);
        } else {
            t = new Tipos(Integer.parseInt(tokens[4]));
            t.setNombreTipo(tokens[5]);
            p.setTiposByTipoSecundario(t); 
        }
        p.setVida(Integer.parseInt(tokens[6]));
        p.setVelocidad(Integer.parseInt(tokens[7]));
        p.setAtaque(Integer.parseInt(tokens[8]));
        p.setDefensa(Integer.parseInt(tokens[9]));
        p.setRutaSprite(tokens[10]);
        p.setDescripcion(tokens[11]);
        return p;
    }

    private static void pokemonAXML(Pokemon p) {
        //Cada vez que llamamos a este metodo creamos la raiz "Pokemon" que dentro tiene todos
        //los datos de uno de ellos. Y hacemos append de la raiz principal del documento
        raizPokemon = document.createElement("pokemon");
        document.getDocumentElement().appendChild(raizPokemon);
        //Creamos los elementos que solo tienen el nodo que indica su valor
        crearElemento("id", String.valueOf(p.getIdPokemon()), raizPokemon, document);
        crearElemento("nombre", p.getNombrePokemon(), raizPokemon, document);
        crearElemento("descripcion", p.getDescripcion(), raizPokemon, document);
        crearElemento("vida", String.valueOf(p.getVida()), raizPokemon, document);
        crearElemento("velocidad", String.valueOf(p.getVelocidad()), raizPokemon, document);
        crearElemento("ataque", String.valueOf(p.getAtaque()), raizPokemon, document);
        crearElemento("defensa", String.valueOf(p.getDefensa()), raizPokemon, document);
        crearElemento("rutaSprite", p.getRutaSprite(), raizPokemon, document);
        
        //Para cada pokemon creamos un nodo raiz por cada tipo, los hacemos hijos
        //del nodo del propio pokemon. Y metemos sus etiquetas internas
        raizTipoP = document.createElement("tipoPrimario");  
        raizPokemon.appendChild(raizTipoP);
        añadirTipoP(p);
        raizTipoS = document.createElement("tipoSecundario");
        raizPokemon.appendChild(raizTipoS);
        añadirTipoS(p);      
        }  
    
    //Mete las etiquetas internas del tipo en su propio nodo
    private static void añadirTipoP(Pokemon p) {
        crearElemento("idTip1",String.valueOf(p.getTiposByTipoPrimario().getIdTipo()), raizTipoP, document);
        crearElemento("nombreTip1",String.valueOf(p.getTiposByTipoPrimario().getNombreTipo()), raizTipoP, document);
    }
    
    //Mete las etiquetas internas del tipo en su propio nodo. Si el tipo es null, añadimos null
    private static void añadirTipoS(Pokemon p) {
        if (p.getTiposByTipoSecundario()==null){
            crearElemento("idTip2","null", raizTipoS, document);
            crearElemento("nombreTip2","null", raizTipoS, document);
        } else {
            crearElemento("idTip2",String.valueOf(p.getTiposByTipoSecundario().getIdTipo()), raizTipoS, document);
            crearElemento("nombreTip2",String.valueOf(p.getTiposByTipoSecundario().getNombreTipo()), raizTipoS, document);
        }
    }
    
    
    // El metodo crear elemento que usamos siempre
    private static void crearElemento(String tag, String valor, Element raiz, Document document) {
        Element elem = document.createElement(tag);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }

}
