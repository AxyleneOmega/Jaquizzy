package jaquizzy;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Advaith Karnad : AxyleneOmega
 * @author Fiza Sameer : bbq-sauce
 * @author Palak Gupta : plk
 */
public class Jaquizzy extends JFrame{
    Jaquizzy(){
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 400, 300);
        add(l1);
        JLabel l2 = new JLabel("Jaquizzy");
        l2.setForeground(Color.WHITE);;
        l2.setBounds(700, 40, 300, 20); 
        add(l2);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Jaquizzy();
    }
    
}
