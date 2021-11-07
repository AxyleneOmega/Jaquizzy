package jaquizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Score extends JFrame implements ActionListener {
    Score(String username, int score) {
        URL iconURL = getClass().getClassLoader().getResource("jaquizzy/Assets/JLogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.setTitle("Jaquizzy! Score");
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(82, 113, 255));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/JaquizzyLogo.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(50, 10, 400, 300);
        add(l1);

        JLabel l2 = new JLabel("Jaquizzy!");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Century Gothic", Font.BOLD, 46));
        l2.setBounds(690, 40, 350, 80);
        add(l2);

        JLabel l3 = new JLabel("Thank you for playing, " + username);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Serif", Font.PLAIN, 22));
        l3.setBounds(690, 130, 300, 40);
        add(l3);

        JLabel l4 = new JLabel("Your score:");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Serif", Font.PLAIN, 22));
        l4.setBounds(690, 180, 300, 40);
        add(l4);

        JLabel l5 = new JLabel("" + score + "");
        l5.setBounds(700, 240, 310, 25);
        l5.setFont(new Font("Century Gothic", Font.BOLD, 30));
        add(l5);

        JButton b1 = new JButton("Play Again");
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBackground(new Color(254, 205, 0));
        b1.addActionListener(this);
        b1.setBounds(700, 650, 200, 40);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new Jaquizzy().setVisible(true);
    }

    public static void main(String args[]) {
        new Score("", 0).setVisible(true);
    }
}
