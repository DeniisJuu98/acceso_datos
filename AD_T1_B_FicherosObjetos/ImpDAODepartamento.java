/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_B_FicherosObjetos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpDAODepartamento implements IDAODepartamento {

    private static final String nomFichero = "DepartamentosV2.dat";

    @Override
    public boolean Alta(Departamento d) {
        Departamento depart;
        // permite escribir
        File ficheroEscritura = null;
        FileOutputStream fileout;
        //objeto de escritura
        ObjectOutputStream temporal = null;
        //----------------------------------------------------
        // permite leer
        File ficheroLectura = null;
        FileInputStream filein;
        //objeto de lectura
        ObjectInputStream original = null;
        //----------------------------------------------------

        try {
            
            // Cuando lo abra se borraran todo el contenido creando lo nuevo
            // Se abre el flijo para escribir y se crea un nuevo fichero
            ficheroEscritura = new File("auxiliarV2.dat");
            fileout = new FileOutputStream(ficheroEscritura, true);
            temporal = new ObjectOutputStream(fileout);

            //Se abre el flijo para leer
            ficheroLectura = new File(nomFichero);
            filein = new FileInputStream(ficheroLectura);
            original = new ObjectInputStream(filein);

            //fichero creado
            while (true) {
                //metemos en el objeto lo leido en el fichero
                depart = (Departamento) original.readObject();
                //comprobamos si el departamento ya existe
                if (depart.equals(d)) {
                    //cerramos los ficheros
                    temporal.close();
                    original.close();
                    ficheroEscritura.delete();
                    return false;
                }
                //escribe los departamento ya existentes en el archivo de lectura
                temporal.writeObject(depart);
            }
        } catch (EOFException eo) {//FIN DE LECTURA
            try {
                //escriimos el nuevo objeto
                temporal.writeObject(d);
                //cerramos todo
                temporal.close();
                original.close();
                //borramos el fichero de lectura
                ficheroLectura.delete();
                //renombramos el dichero de escritura "auxiliar" en el de lectura
                ficheroEscritura.renameTo(ficheroLectura);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            //Si no existe el archivo lo crea nuevo y mete el nuevo departamento.
            try {
                temporal.writeObject(d);
                temporal.close();
                ficheroEscritura.renameTo(ficheroLectura);
                return true;
            } catch (IOException ex1) {
                Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Baja(Departamento d) {
        Departamento depart;
        // permite escribir
        File ficheroEscritura = null;
        FileOutputStream fileout;
        //objeto de escritura
        ObjectOutputStream temporal = null;
        //----------------------------------------------------
        // permite leer
        File ficheroLectura = null;
        FileInputStream filein;
        //objeto de lectura
        ObjectInputStream original = null;
        //----------------------------------------------------

        try {
            // Cuando lo abra se borraran todo el contenido creando lo nuevo
            // Se abre el flijo para escribir y se crea un nuevo fichero
            ficheroEscritura = new File("auxiliar.dat");
            fileout = new FileOutputStream(ficheroEscritura, true);
            temporal = new ObjectOutputStream(fileout);

            //Se abre el flijo para leer
            ficheroLectura = new File(nomFichero);
            filein = new FileInputStream(ficheroLectura);
            original = new ObjectInputStream(filein);

            //fichero creado
            while (true) {
                //metemos en el objeto lo leido en el fichero
                depart = (Departamento) original.readObject();
                //va leyendo y escribiendo hasta que encuentra el departamento
                if (!depart.equals(d)) {
                    temporal.writeObject(depart);
                }
            }
        } catch (EOFException eo) {//FIN DE LECTURA
            System.out.println("Fin del archivo");
            try {
                //cerramos todo
                temporal.close();
                original.close();
                //borramos el fichero de lectura
                ficheroLectura.delete();
                //renombramos el dichero de escritura "auxiliar" en el de lectura
                ficheroEscritura.renameTo(ficheroLectura);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void verTodos() {
        Departamento d;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream(this.nomFichero));
            while (true) {
                d = (Departamento) ois.readObject();
                System.out.println(d.toString());
            }

        } catch (EOFException ex) {
            System.out.println("FIN DE FICHERO");
            try {
                ois.close();
            } catch (IOException ex1) {
                System.out.println("No hay datos");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImpDAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
