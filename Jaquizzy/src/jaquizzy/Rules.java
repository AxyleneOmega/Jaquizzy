package jaquizzy;


import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame {
    
    Rules(String username){
        setBounds(600, 200,800, 650);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1= new JLabel("WELCOME TO JAQUIZZY"+ username);
        l1.setBounds(50,20,700,30);
        
        
        
        setVisible(true);

    }

     public static void main(String[] args) {
        new Rules("");
    }
}
