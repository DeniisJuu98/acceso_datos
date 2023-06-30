/*
 Haciendo uso del layout null, realiza una ventana con una etiqueta y dos botones.
La etiqueta contendrá la pregunta. ¿Te gusta la informática? y los botones tendrán
el texto &quot;Si&quot; y &quot;No&quot;. El ejercicio consiste en programar los eventos del ratón para
que cuando se posicione encima del botón &quot;No&quot; este se desplace a otro punto
dentro de la ventana y nunca pueda ser pulsado.
 */
package AD_Swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.module.ModuleDescriptor;
import javax.swing.*;

//import misFunciones.Matematicas;

public class Ejercicio3 extends JFrame {

    private JLabel jLabelNombre = new JLabel();
    private JButton jButtonPulsa1 = new JButton();
    private JButton jButtonPulsa2 = new JButton();

    public Ejercicio3() {
        jLabelNombre.setText("Te gusta la Informatica?");
        jButtonPulsa1.setText("Si");
        jButtonPulsa2.setText("No");

        getContentPane().setLayout(null);

        //Metemos los componenetes creados
        add(jLabelNombre);
        add(jButtonPulsa1);
        add(jButtonPulsa2);

        //programar el evento del click del boton
        jButtonPulsa2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                int    x = Matematicas.numeroAleatorio(0, 100);
//                int    y = Matematicas.numeroAleatorio(0, 100);
//                jButtonPulsa2.setLocation(x, y);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        // Lo añadimos en la ventana
        getContentPane().setLayout(null);
        jLabelNombre.setBounds(130, 20, 500, 20);
        jButtonPulsa1.setBounds(50, 80, 100, 20);
        jButtonPulsa2.setBounds(250, 80, 100, 20);

        getContentPane().add(jLabelNombre);
        getContentPane().add(jButtonPulsa1);
        getContentPane().add(jButtonPulsa2);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejercicio3 ventana = new Ejercicio3();
    }

}
