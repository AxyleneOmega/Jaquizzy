package jaquizzy;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Advaith Karnad : AxyleneOmega
 * @author Fiza Sameer : bbq-sauce
 * @author Palak Gupta : plk
 */
public class Jaquizzy extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1;
    Jaquizzy(){
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 400, 300);
        add(l1);
        JLabel l2 = new JLabel("Jaquizzy");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Montez", Font.BOLD, 46));
        l2.setBounds(700, 40, 350, 80); 
        add(l2);
        
        JLabel l3 = new JLabel("Enter your name.");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        l3.setBounds(700, 130, 300, 20); 
        add(l3);

         t1= new JTextField();
        t1.setBounds(630,200,310,25);
        t1.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(t1);

         b1 = new JButton("Rules");
        b1.setBounds(630,270,120,25);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

         b2 = new JButton("Exit");
        b2.setBounds(820,270,120,25);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name = t1.getText();
            new Rules(name);

        }else{
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Jaquizzy();
    }
    
}
