/*
 Realiza una ventana que contenga un label, una caja de texto y un botón.Cuando
se pulse el botón aparecerán a continuación en la ventana toantos labels como el
número que haya puesto el usuario en la caja de texto.

NOTA: El mensaje que tiene que aparecer en los labels es un " * ".
 */
package AD_Swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ejercicio2 extends JFrame {

    private JLabel jLabelNombre = new JLabel();
    private JButton jButtonPulsa = new JButton();
    private JTextField jTextFieldNombre = new JTextField();
    private JLabel jLabelSalida = new JLabel();

    public Ejercicio2() {
        jLabelNombre.setText("Número de veces: ");
        jTextFieldNombre.setText("Veces a repetir");
        jButtonPulsa.setText("Calcular");
        jLabelSalida.setText("");

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
                for (int i = 0; i < Integer.parseInt(jTextFieldNombre.getText()); i++) {
                    JLabel salida2 = new JLabel();
                    salida2.setText("*");
                    add(salida2);
                }
                pack();
            }
        });

        //propiedades de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//poder cerrar la ventana
        setVisible(true);//mostrar la ventana
        setVisible(true); //mostrar la ventana
        pack(); //reducir al minimo tamaño pero que se vean los componentes
    }

    public static void main(String[] args) {
        Ejercicio2 v2 = new Ejercicio2();
    }

}
