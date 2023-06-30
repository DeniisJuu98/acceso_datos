/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_Swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaAmano extends JFrame {

    private JLabel jLabelNombre = new JLabel();
    private JButton jButtonPulsa = new JButton();
    private JTextField jTextFieldNombre = new JTextField();
    private JLabel jLabelSalida = new JLabel();

    public VentanaAmano() {
        jLabelNombre.setText("Dime tu edad:");
        jTextFieldNombre.setText("Escribe aqui tu edad");
        jButtonPulsa.setText("Calcular");
        jLabelSalida.setText("Hola");

        getContentPane().setLayout(new FlowLayout());

        //Metemos los componenetes creados
        add(jLabelNombre);
        add(jTextFieldNombre);
        add(jButtonPulsa);
        add(jLabelSalida);

        //programar el evento del click del boton
       jButtonPulsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                  int edad;
                edad = Integer.parseInt(jTextFieldNombre.getText());
                        
                if (edad > 17) {
                    jLabelSalida.setText("Usted es mayor de edad");
                } else {
                    jLabelSalida.setText("Usted deberia esatr en grado medio");
                }
            }
       });

        //propiedades de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//poder cerrar la ventana
        setVisible(true);//mostrar la ventana
        setVisible(true); //mostrar la ventana
        pack(); //reducir al minimo tamaño pero que se vean los componentes
    }

    public static void main(String[] args) {
        VentanaAmano v2 = new VentanaAmano();
    }

}
