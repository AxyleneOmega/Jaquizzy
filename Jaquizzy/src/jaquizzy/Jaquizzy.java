package jaquizzy;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Advaith Karnad : AxyleneOmega
 * @author Fiza Sameer : bbq-sauce
 */
public class Jaquizzy extends JFrame{
    Jaquizzy(){
        setBounds(200, 100, 800, 600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 400, 300);
        add(l1);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Jaquizzy();
    }
    
}
