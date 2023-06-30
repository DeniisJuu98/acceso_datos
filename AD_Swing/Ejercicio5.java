/*
 Ahora realiza el ejemplo de la siguiente ventana.En ella es posible seleccionar 
mas de un item:
 */
package AD_Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ejercicio5 extends JFrame {

    private JPanel p1, p2;
    private JCheckBox check1, check2, check3, check4;
//    private ButtonGroup bg = new ButtonGroup(); 
    private JLabel imagen;
//    private JRadioButton b1, b2, b3;

    public Ejercicio5() {
        check1 = new JCheckBox("Chin");
        check2 = new JCheckBox("Glasses");
        check3 = new JCheckBox("Hair");
        check4 = new JCheckBox("Teeth");
        imagen = new JLabel();

        ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek-----.gif"));
        imagen.setIcon(ii);

        check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check1.isSelected()) {
                    ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek-c---.gif"));
                    imagen.setIcon(ii);
                } else {
                    ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek-----.gif"));
                }
            }
        });

        check2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek--g--.gif"));
                imagen.setIcon(ii);
            }
        });

        check3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek---h-.gif"));
                imagen.setIcon(ii);
            }
        });

        check4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon ii = new ImageIcon(getClass().getResource("/gfx/geek----t.gif"));
                imagen.setIcon(ii);
            }
        });

        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
        getContentPane().setLayout(bl);
        getContentPane().add(p1);
        getContentPane().add(p2);

        p1.add(check1);
        p1.add(check2);
        p1.add(check3);
        p1.add(check4);

        p2.add(imagen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio5();
    }

}
