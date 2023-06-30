/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Vespertino
 */
public class Ventana extends JFrame {

    ///propiedades
    private JLabel jl1, jl2, jl3, jl4, jl5,j16;
    private JTextField t1, t2;
    private JComboBox<String> comb;
    private JButton cal, lim;
    private GridLayout gl;
    private DefaultComboBoxModel<String> dcx;

    private JFrame v;

    public Ventana() {
        //instanciando
        gl = new GridLayout(5, 2, 5, 5);
        jl1 = new JLabel();
        jl2 = new JLabel();
        jl3 = new JLabel();
        jl4 = new JLabel();
        jl5 = new JLabel();
        j16 = new JLabel();
        v= new JFrame();

        dcx = new DefaultComboBoxModel();
        t1 = new JTextField();
        t2 = new JTextField();
        cal = new JButton();
        lim = new JButton();

        dcx = new DefaultComboBoxModel();
        dcx.addElement("+");
        dcx.addElement("-");
        dcx.addElement("/");
        dcx.addElement("x");
        dcx.addElement("mod");
        comb = new JComboBox<>(dcx);

        jl1.setText("Dato1");
        jl2.setText("Operador");
        jl3.setText("Dato2");
        jl4.setText("Resultado");
        j16.setText("Hola");
        cal.setText("Calcular");
        lim.setText("Limpiar");

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.setVisible(true);
            }
        });
        lim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                t1.setText("");
                t2.setText("");
                jl5.setText("");

            }
        });

        getContentPane().setLayout(gl);
        getContentPane().add(jl1);
        getContentPane().add(t1);
        getContentPane().add(jl2);
        getContentPane().add(comb);
        getContentPane().add(jl3);
        getContentPane().add(t2);
        getContentPane().add(jl4);
        getContentPane().add(jl5);
        getContentPane().add(cal);
        getContentPane().add(lim);
        v.add(j16);

        //propiedades
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        pack();

    }

    
}
