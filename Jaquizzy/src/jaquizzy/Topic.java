package jaquizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Topic extends JFrame implements ActionListener {
    public String type;
    public String qtopic;
    ButtonGroup topic;
    JRadioButton b0, b1, b2, b3, b4, b5, b6;
    JButton back, start;
    String username;

    Topic(String username, String type) {
        URL iconURL = getClass().getClassLoader().getResource("jaquizzy/Assets/JLogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.type = type;
        this.username = username;
        this.setTitle("Jaquizzy! Topic");
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
        l0.setBounds(300, 100, 700, 30);
        l0.setForeground(Color.BLACK);
        l0.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l0);
        JLabel l1 = new JLabel("Select Topic: ");
        l1.setBounds(300, 150, 700, 30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Century Gothic", Font.BOLD, 28));
        add(l1);
        b0 = new JRadioButton("");
        b0.setActionCommand("");
        b1 = new JRadioButton("");
        b1.setActionCommand("");
        b2 = new JRadioButton("");
        b2.setActionCommand("");
        b3 = new JRadioButton("");
        b3.setActionCommand("");
        b4 = new JRadioButton("");
        b4.setActionCommand("");
        b5 = new JRadioButton("");
        b5.setActionCommand("");
        b6 = new JRadioButton("");
        b6.setActionCommand("");

        if (type.equals("Education Quiz")) {
            b0.setText("Java");
            b0.setActionCommand("JavaQ");
            b1.setText("Science");
            b1.setActionCommand("Science");
            b2.setText("GK");
            b2.setActionCommand("GK");
            b3.setText("Tech");
            b3.setActionCommand("Tech");
            b4.setText("Maths");
            b4.setActionCommand("Maths");
            b5.setText("Logic");
            b5.setActionCommand("Logic");
            b6.setText("English");
            b6.setActionCommand("English");
        } else if (type.equals("Entertainment Quiz")) {
            b0.setText("GK");
            b0.setActionCommand("GK");
            b1.setText("Sports");
            b1.setActionCommand("Sports");
            b2.setText("Movies");
            b2.setActionCommand("Movies");
            b3.setText("Brands");
            b3.setActionCommand("Brands");
            b4.setText("Music");
            b4.setActionCommand("Music");
            b5.setText("Gaming");
            b5.setActionCommand("Gaming");
            b6.setText("Food");
            b6.setActionCommand("Food");

        }
        // b0
        b0.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b0.setBounds(300, 400, 120, 30);
        b0.setBackground(new Color(210, 210, 255));
        b0.setForeground(Color.BLACK);
        b0.addActionListener(this);
        add(b0);
        // b1
        b1.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b1.setBounds(300, 250, 120, 30);
        b1.setBackground(new Color(210, 210, 255));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        // b2
        b2.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b2.setBounds(300, 300, 120, 30);
        b2.setBackground(new Color(210, 210, 255));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        // b3
        b3.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b3.setBounds(300, 350, 120, 30);
        b3.setBackground(new Color(210, 210, 255));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);
        // b4
        b4.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b4.setBounds(500, 250, 120, 30);
        b4.setBackground(new Color(210, 210, 255));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        add(b4);
        // b5
        b5.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b5.setBounds(500, 300, 120, 30);
        b5.setBackground(new Color(210, 210, 255));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        add(b5);
        // b6
        b6.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        b6.setBounds(500, 350, 120, 30);
        b6.setBackground(new Color(210, 210, 255));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        add(b6);
        topic = new ButtonGroup();
        topic.add(b0);
        topic.add(b1);
        topic.add(b2);
        topic.add(b3);
        topic.add(b4);
        topic.add(b5);
        topic.add(b6);
        back = new JButton("Back");
        back.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        back.setBounds(300, 600, 120, 25);
        back.setBackground(new Color(254, 100, 100));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        start.setBounds(500, 600, 120, 25);
        start.setBackground(new Color(100, 205, 10));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        start.setEnabled(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            repaint();
            this.setVisible(false);
            new Rules(username).setVisible(true);
        } else if (ae.getSource() == start) {
            repaint();
            this.setVisible(false);
            System.out.println(qtopic);
            new Quiz(username, topic.getSelection().getActionCommand()).setVisible(true);
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (topic.getSelection() != null) {
            start.setEnabled(true);
            qtopic = topic.getSelection().getActionCommand();
        } else {
            repaint();
        }

    }
    public static void main(String args[]) {
        new Topic("", "");
    }
}
