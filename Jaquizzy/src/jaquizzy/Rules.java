package jaquizzy;


import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame {
    
    Rules(String username){
        setBounds(600, 200,800, 650);
        getContentPane().setBackground(Color.BLACK);

        JLabel l3= new JLabel("WELCOME TO JAQUIZZY "+username);
        l3.setBounds(700, 40, 350, 80);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Montez", Font.BOLD, 46));
        add(l3);
        
        
        
        setVisible(true);

    }

     public static void main(String[] args) {
        new Rules("");
    }
}
