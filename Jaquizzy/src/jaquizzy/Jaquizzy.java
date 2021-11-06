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
public class Jaquizzy extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1;

    Jaquizzy() {
        this.setTitle("Jaquizzy!");
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 400, 300);
        add(l1);
        JLabel l2 = new JLabel("Jaquizzy!");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Century Gothic", Font.BOLD, 46));
        l2.setBounds(690, 40, 350, 80);
        add(l2);

        JLabel l3 = new JLabel("Enter your name:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Serif", Font.PLAIN, 22));
        l3.setBounds(710, 130, 300, 40);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(630, 200, 310, 25);
        t1.setFont(new Font("Serif", Font.PLAIN, 22));
        add(t1);

        b1 = new JButton("Rules");
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(630, 270, 120, 30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(820, 270, 120, 30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        } else {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Jaquizzy();
    }

}
