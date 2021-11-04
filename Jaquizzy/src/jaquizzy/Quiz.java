package jaquizzy;
import javax.swing.*;
import java.awt.*;

public class Quiz extends JFrame{

    JButton next, submit;
    JLabel qno, question;
    Quiz(){
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(20, 160, 200));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1280,200);
        add(l1);

        qno = new JLabel("1.");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setBounds(100, 250, 40, 30);
        add(qno);
        question = new JLabel("Question 1 placeholder");
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(150, 250, 700, 30);
        add(question);

        JRadioButton opt1 = new JRadioButton("Option 1");
        opt1.setBounds(170, 320, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(new Color(20, 160, 200));
        add(opt1);
        JRadioButton opt2 = new JRadioButton("Option 2");
        opt2.setBounds(170, 360, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(new Color(20, 160, 200));
        add(opt2);
        JRadioButton opt3 = new JRadioButton("Option 3");
        opt3.setBounds(170, 400, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(new Color(20, 160, 200));
        add(opt3);
        JRadioButton opt4 = new JRadioButton("Option 4");
        opt4.setBounds(170, 440, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(new Color(20, 160, 200));
        add(opt4);

        ButtonGroup options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton ("Next");
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(200, 200, 200));
        next.setBounds(550, 650, 200, 40);
        add(next);

        submit = new JButton ("Submit");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(200, 200, 200));
        submit.setBounds(1000, 650, 200, 40);
        add(submit);
    }
    public static void main(String args[]) {
        new Quiz().setVisible(true);
    }
}
