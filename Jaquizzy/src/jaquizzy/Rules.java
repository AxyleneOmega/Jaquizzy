package jaquizzy;

//import java.io.File;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String username;
    JButton b1, b2;
    ButtonGroup type;
    JRadioButton edu, ent;
    public static String qType;

    Rules(String username) {
        this.username = username;
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        JLabel l0 = new JLabel("Welcome " + username + "!");
        l0.setBounds(250, 20, 700, 30);
        l0.setForeground(Color.WHITE);
        l0.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l0);
        JLabel l1 = new JLabel("Rules of Jaquizzy!");
        l1.setBounds(250, 60, 700, 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setBounds(250, 80, 800, 450);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        l2.setText("<html>" +

                "1.Only one person can attempt the quiz at said time " + "<br>" +

                "2.There are 3 levels of questions involved that being beginner, intermediate and advanced. You have to pick one level of difficulty according to your preference. The level of difficulty of the questions increases in the respective order mentioned above. THIS CANNOT BE CHANGED LATER ON, SO, PICK WISELY. "
                + "<br>" +

                "3.The beginner level will have 20 questions while both intermediate and hardcore will contain 15 questions each. "
                + "<br>" +

                "4.The question on your screen is the one that you have to attempt" + "<br>" +

                "5.Each question will have 4 options along with it " + "<br>" +

                "6.Out of the four options, one will be correct and the other 3 options will be wrong." + "<br>" +

                "7.One right answer will carry 4 marks and the wrong answer will have 0 marks. There will be no negative marking. "
                + "<br>" +

                "8.You have the option of skipping a question for the time being and returning back to answer it later."
                + "<br>" +

                "<html>");
        add(l2);

        edu = new JRadioButton("Education Quiz");
        edu.setBounds(250, 520, 300, 30);
        edu.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        edu.setBackground(new Color(220, 200, 50));
        edu.setActionCommand("Education Quiz");
        add(edu);
        ent = new JRadioButton("Entertainment Quiz");
        ent.setBounds(600, 520, 300, 30);
        ent.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        ent.setBackground(new Color(220, 70, 200));
        ent.setActionCommand("Entertainment Quiz");
        add(ent);
        type = new ButtonGroup();
        type.add(edu);
        type.add(ent);

        b1 = new JButton("Back");
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(425, 600, 120, 25);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Next");
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(250, 600, 120, 25);
        b2.setBackground(new Color(30, 144, 255));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        b2.setEnabled(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            repaint();
            this.setVisible(false);
            new Jaquizzy().setVisible(true);
        } else if (ae.getSource() == b2) {
            if (type.getSelection() != null) {
                this.setVisible(false);
                new Topic(username, qType).setVisible(true);
            } else {
                repaint();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (type.getSelection() != null) {
            qType = type.getSelection().getActionCommand();
            b2.setEnabled(true);
        }
        try {
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Rules("");
    }
}
