package jaquizzy;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class Categories{
    String category;
    static int cno = 0;
    int index = 0;
    LinkedList<Questions> containedQuestions = new LinkedList<Questions>();
    Categories(String category){
        this.category = category;
        this.index = cno;
        cno++;
    }
}
class Questions{
    String question;
    int index = 0;
    static int qno = 0;
    String options[] = new String[4];
    int correct = 0;

    Questions(String question, String opt1, String opt2, String opt3, String opt4, int correct){
        this.question = question;
        this.options[0] = opt1;
        this.options[1] = opt2;
        this.options[2] = opt3;
        this.options[3] = opt4;
        this.correct = correct % 4;
        this.index = qno;
        qno++;
    }
    public final String toString(){
        return this.question;
    }
}
public class Quiz extends JFrame{
    LinkedList<Questions> quizQuestions = new LinkedList<Questions>();
    JButton next, submit;
    public static int count = 0;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    Quiz(){
        this.setList();
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(20, 160, 200));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1280,200);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setBounds(100, 250, 50, 30);
        add(qno);
        question = new JLabel("");
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(150, 250, 700, 30);
        add(question);

        opt1 = new JRadioButton("");
        opt1.setBounds(170, 320, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(new Color(20, 160, 200));
        add(opt1);
        opt2 = new JRadioButton("");
        opt2.setBounds(170, 360, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(new Color(20, 160, 200));
        add(opt2);
        opt3 = new JRadioButton("");
        opt3.setBounds(170, 400, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(new Color(20, 160, 200));
        add(opt3);
        opt4 = new JRadioButton("");
        opt4.setBounds(170, 440, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(new Color(20, 160, 200));
        add(opt4);

        options = new ButtonGroup();
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

        start(0);
    }

    public int setList(){
        Questions q1 = new Questions("Placeholder Question here","Option1","Option2","Option3","Option4",2);
        this.quizQuestions.add(q1);
        return this.quizQuestions.size();
    }

    public void start(int count){
        qno.setText(""+this.quizQuestions.get(count).index +1+"] ");
        question.setText(this.quizQuestions.get(count).question);
        opt1.setText(this.quizQuestions.get(count).options[0]);
        opt2.setText(this.quizQuestions.get(count).options[1]);
        opt3.setText(this.quizQuestions.get(count).options[2]);
        opt4.setText(this.quizQuestions.get(count).options[3]);
        options.clearSelection();
    }
    public static void main(String args[]) {
        new Quiz().setVisible(true);
    }
}
