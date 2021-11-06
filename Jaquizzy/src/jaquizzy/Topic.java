package jaquizzy;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Topic extends JFrame implements ActionListener {
    public static String type;
    ButtonGroup topic;
    JRadioButton b1, b2, b3, b4, b5, b6;
    JButton back, start;

    Topic(String username, String type) {
        this.type = type;
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        JLabel l0 = new JLabel("Welcome " + username + "!");
        l0.setBounds(250, 20, 700, 30);
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l0);
        JLabel l1 = new JLabel("Select Topic: ");
        l1.setBounds(250, 60, 700, 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l1);
        if (type.equals("Education Quiz")) {
            b1 = new JRadioButton("Science");
            b1.setActionCommand("Science");
            b2 = new JRadioButton("GK");
            b2.setActionCommand("GK");
            b3 = new JRadioButton("Tech");
            b3.setActionCommand("Tech");
            b4 = new JRadioButton("Maths");
            b4.setActionCommand("Maths");
            b5 = new JRadioButton("Logic");
            b5.setActionCommand("Logic");
            b6 = new JRadioButton("English");
            b6.setActionCommand("English");
        } else if (type.equals("Entertainment Quiz")) {
            b1 = new JRadioButton("Sports");
            b1.setActionCommand("Sports");
            b2 = new JRadioButton("Movies");
            b2.setActionCommand("Movies");
            b3 = new JRadioButton("Brands");
            b3.setActionCommand("Brands");
            b4 = new JRadioButton("Music");
            b4.setActionCommand("Muisc");
            b5 = new JRadioButton("Gaming");
            b5.setActionCommand("Gaming");
            b6 = new JRadioButton("Food");
            b6.setActionCommand("Food");

        }
        // b1
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(250, 150, 120, 30);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        // b2
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(250, 200, 120, 30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        // b3
        b3.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b3.setBounds(250, 250, 120, 30);
        b3.setBackground(Color.RED);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);
        // b4
        b4.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b4.setBounds(400, 150, 120, 30);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        add(b4);
        // b5
        b5.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b5.setBounds(400, 200, 120, 30);
        b5.setBackground(Color.RED);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        add(b5);
        // b6
        b6.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b6.setBounds(400, 250, 120, 30);
        b6.setBackground(Color.RED);
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        add(b6);
        topic = new ButtonGroup();
        topic.add(b1);
        topic.add(b2);
        topic.add(b3);
        topic.add(b4);
        topic.add(b5);
        topic.add(b6);
        back = new JButton("Back");
        back.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        back.setBounds(425, 600, 120, 25);
        back.setBackground(Color.RED);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        start.setBounds(250, 600, 120, 25);
        start.setBackground(new Color(30, 144, 255));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        start.setEnabled(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            this.setVisible(false);
            new Rules(username).setVisible(true);
        }
        else if (ae.getSource()== start){

            new Quiz(username, qType, new File("")).setVisible(true);   
        }

    }
}