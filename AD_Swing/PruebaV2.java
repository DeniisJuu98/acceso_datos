/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_Swing;

import javax.swing.*;

public class PruebaV2 extends JFrame{
    private JPanel p1, p2;
    private JCheckBox check1, check2, check3;
    private ButtonGroup bg = new ButtonGroup();            
    private JRadioButton b1, b2, b3;

    public PruebaV2() {
        check1 = new JCheckBox("moto");
        check2 = new JCheckBox("coche");
        check3 = new JCheckBox("bici"); 
        b1= new JRadioButton("op1");
        b2= new JRadioButton("op2");
        b3= new JRadioButton("op3");
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
        getContentPane().setLayout(bl);
        getContentPane().add(p1);
        getContentPane().add(p2);
        p1.add(b1);        
        p1.add(b2);
        p1.add(b3);        
        p2.add(check1);
        p2.add(check2);
        p2.add(check3);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new PruebaV2();
    }
    
    
    
    
}