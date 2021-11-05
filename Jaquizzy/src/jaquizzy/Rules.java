package jaquizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JButton b1,b2;
    
    Rules(String username){
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel l1= new JLabel("Rules of Jaquizzy! "+username);
        l1.setBounds(250, 20, 700, 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l1);

        JLabel l2= new JLabel("");
        l2.setBounds(250, 90, 600, 350);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Serif", Font.PLAIN, 22));
        l2.setText(
        "<html>"+
        "Here are the rules to the game."+"<br><br>"+

        "<html>"
        );
        add(l2);

        b1 = new JButton("Back");
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(400,270,120,25);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(250,270,120,25);
        b2.setBackground(new Color(30,144,255));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
            new Jaquizzy().setVisible(true);
        }else if(ae.getSource()==b2){
            this.setVisible(false);
               
        }

    }

     public static void main(String[] args) {
        new Rules("");
    }
}
