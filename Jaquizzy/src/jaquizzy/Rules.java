package jaquizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class Rules extends JFrame implements ActionListener {
    String username;
    JButton b1, b2;
    ButtonGroup type;
    JRadioButton edu, ent;
    public static String qType;

    Rules(String username) {
        URL iconURL = getClass().getClassLoader().getResource("jaquizzy/Assets/JLogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.username = username;
        this.setTitle("Jaquizzy! Rules");
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(82, 113, 255));
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/JLogo.png"));
        Image i = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        i1.setImage(i);
        JLabel lx = new JLabel(i1);
        lx.setBounds(50, 50, 200, 200);
        add(lx);
        JLabel l0 = new JLabel("Welcome " + username + "!");
        l0.setBounds(300, 50, 700, 30);
        l0.setForeground(Color.BLACK);
        l0.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l0);
        JLabel l1 = new JLabel("Rules of Jaquizzy!");
        l1.setBounds(300, 100, 700, 30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setForeground(Color.BLACK);
        l2.setBounds(300, 100, 800, 450);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        l2.setText("<html>" + "1. Only one person can attempt the quiz at said time " + "<br>" +

                "2. The levels of questions increases progressively for each topic, but the reward increases too!"
                + "<br>" +

                "3. Each topic will have upto 10 question, 3-4 of beginner level, 2-3 of intermediate level, 2-3 of advanced level."
                + "<br>" +

                "4. Each question will have 4 options along with it, only ONE is correct" + "<br>" +

                "5. You will have 30 Seconds to answer for each question." + "<br>" +

                "6. One right answer will carry 10 marks and will be multiplied by the difficulty level to get your score"
                + "<br>" +

                "7. The wrong answer will have 0 marks. There will be no negative marking. " + "<br>" +

                "8. If the timer were to run out, the option selected last will be taken into account." + "<br>" +

                "<html>");
        add(l2);

        edu = new JRadioButton("Education Quiz");
        edu.setBounds(300, 520, 300, 30);
        edu.setForeground(Color.BLACK);
        edu.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        edu.setBackground(new Color(100, 200, 50));
        edu.setActionCommand("Education Quiz");
        add(edu);
        ent = new JRadioButton("Entertainment Quiz");
        ent.setForeground(Color.BLACK);
        ent.setBounds(650, 520, 300, 30);
        ent.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        ent.setBackground(new Color(220, 70, 200));
        ent.setActionCommand("Entertainment Quiz");
        add(ent);
        type = new ButtonGroup();
        type.add(edu);
        type.add(ent);

        b1 = new JButton("Back");
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(300, 600, 120, 25);
        b1.setBackground(new Color(254, 100, 100));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Next");
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(500, 600, 120, 25);
        b2.setBackground(new Color(254, 205, 0));
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
