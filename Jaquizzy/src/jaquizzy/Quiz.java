package jaquizzy;
import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
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
public class Quiz extends JFrame implements ActionListener{
    LinkedList<Questions> quizQuestions = new LinkedList<Questions>();
    LinkedList<String> answers = new LinkedList<String>();
    String username;
    public static int count = 0;
    public static int timer = 30;
    public static int score = 0;
    public static boolean quizOn = true;
    public static boolean answered = false;
    JButton next, submit;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    Quiz(String username, String qtopic, File f){
        this.username = username;
        this.setTitle("Jaquizzy! Quiztime");
        this.setList();
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(20, 160, 200));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/Placeholder.png"));
        Image i2 = i1.getImage().getScaledInstance(1280,200, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1280,200);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Serif", Font.PLAIN, 24));
        qno.setBounds(100, 250, 50, 30);
        add(qno);
        question = new JLabel("");
        question.setFont(new Font("Serif", Font.PLAIN, 24));
        question.setBounds(150, 250, 700, 30);
        add(question);

        opt1 = new JRadioButton("");
        opt1.setBounds(170, 320, 700, 30);
        opt1.setFont(new Font("Serif", Font.PLAIN, 20));
        opt1.setBackground(new Color(20, 160, 200));
        add(opt1);
        opt2 = new JRadioButton("");
        opt2.setBounds(170, 360, 700, 30);
        opt2.setFont(new Font("Serif", Font.PLAIN, 20));
        opt2.setBackground(new Color(20, 160, 200));
        add(opt2);
        opt3 = new JRadioButton("");
        opt3.setBounds(170, 400, 700, 30);
        opt3.setFont(new Font("Serif", Font.PLAIN, 20));
        opt3.setBackground(new Color(20, 160, 200));
        add(opt3);
        opt4 = new JRadioButton("");
        opt4.setBounds(170, 440, 700, 30);
        opt4.setFont(new Font("Serif", Font.PLAIN, 20));
        opt4.setBackground(new Color(20, 160, 200));
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton ("Next");
        next.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        next.setBackground(new Color(200, 200, 200));
        next.addActionListener(this);
        next.setBounds(550, 650, 200, 40);
        add(next);

        submit = new JButton ("Submit");
        submit.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        submit.setEnabled(false);
        submit.setBackground(new Color(200, 200, 200));
        submit.addActionListener(this);
        submit.setBounds(1000, 650, 200, 40);
        add(submit);

        start(0);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            answered = true;
            if(options.getSelection() == null){
                answers.add("");
            }else{
                answers.add(options.getSelection().getActionCommand());
            }
            count++;
            if(count < this.quizQuestions.size()){
                start(count);
            }
            if(count == this.quizQuestions.size()){
                quizOn = false;
            }
            System.out.println(answers);
        }
        else if(ae.getSource() == submit){
            if(options.getSelection() == null){
                answers.add("");
            }else{
                answers.add(options.getSelection().getActionCommand());
            };
            for(int i=0; i<answers.size(); i++){
                if(answers.get(i).equals(this.quizQuestions.get(i).options[this.quizQuestions.get(i).correct])){
                    score +=10;
                };
            }
            System.out.println(answers);
            this.setVisible(false);
            quizOn = false;
            count = 0;
            new Score(username,score).setVisible(true);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time left : "+ timer+" seconds...";
        g.setColor(new Color(0, 100, 100));
        g.setFont(new Font("Century Gothic", Font.BOLD, 25));
        
        if(timer > 0){
            g.drawString(time, 900, 270);
        }else{
            g.drawString("Time's Up!", 900, 270);
        }
        if(quizOn){
            timer --;
        }
        
        try{
            Thread.sleep(1000);
            if(quizOn){
                repaint();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(answered){
            timer = 30;
            answered = false;
        }
        if(count == this.quizQuestions.size()-1){
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        if(timer < 0){
            timer = 30;
            if(options.getSelection() == null){
                answers.add("");
            }else{
                answers.add(options.getSelection().getActionCommand());
            };
            quizOn = true;
            if(count == this.quizQuestions.size()){
                for(int i=0; i<answers.size(); i++){
                    if(answers.get(i).equals(this.quizQuestions.get(i).options[this.quizQuestions.get(i).correct])){
                        score +=10;
                    };
                }
                System.out.println(answers);
                this.setVisible(false);
                quizOn = false;
                count = 0;
                //new Score(username).setVisible(true);
            }
            else{
                count++;
                if(count < this.quizQuestions.size()){
                    start(count);
                }
                System.out.println(answers);
            }
        }
    }
    public int setList(){
        Questions q1 = new Questions("Placeholder Question 1 here","Option1","Option2","Option3","Option4",2);
        Questions q2 = new Questions("Placeholder Question 2 here","Option1","Option2","Option3","Option4",2);
        Questions q3 = new Questions("Placeholder Question 3 here","Option1","Option2","Option3","Option4",2);
        this.quizQuestions.add(q1);
        this.quizQuestions.add(q2);
        this.quizQuestions.add(q3);
        return this.quizQuestions.size();
    }

    public void start(int count){
        qno.setText(""+(this.quizQuestions.get(count).index+1)+"] ");
        question.setText(this.quizQuestions.get(count).question);
        opt1.setText(this.quizQuestions.get(count).options[0]);
        opt1.setActionCommand(this.quizQuestions.get(count).options[0]);
        opt2.setText(this.quizQuestions.get(count).options[1]);
        opt2.setActionCommand(this.quizQuestions.get(count).options[1]);
        opt3.setText(this.quizQuestions.get(count).options[2]);
        opt3.setActionCommand(this.quizQuestions.get(count).options[2]);
        opt4.setText(this.quizQuestions.get(count).options[3]);
        opt4.setActionCommand(this.quizQuestions.get(count).options[3]);
        options.clearSelection();
    }
    public static void main(String args[]) {
        new Quiz("","",new File("")).setVisible(true);
    }
}
