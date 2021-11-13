package jaquizzy;

import javax.swing.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Questions {
    String question;
    String resource;
    int multiplier = 0;
    int index = 0;
    static int qno = 0;
    String options[] = new String[4];
    int correct = 0;

    Questions(String question, String resource, int m, String opt1, String opt2, String opt3, String opt4,
            int correct) {
        this.question = question;
        this.resource = resource;
        this.multiplier = m;
        this.options[0] = opt1;
        this.options[1] = opt2;
        this.options[2] = opt3;
        this.options[3] = opt4;
        this.correct = correct % 4;
        this.index = qno;
        qno++;
    }

    public final String toString() {
        return this.question;
    }
}

public class Quiz extends JFrame implements ActionListener {

    LinkedList<Questions> quizQuestions = new LinkedList<Questions>();
    LinkedList<String> answers = new LinkedList<String>();
    String username;
    public static int count = 0;
    public static int timer = 30;
    public static int score = 0;
    public static boolean quizOn = true;
    public static boolean answered = false;
    JButton next, submit;
    JLabel qno, question, qIm;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    BufferedImage img = null;

    Quiz(String username, String qtopic) {
        URL iconURL = getClass().getClassLoader().getResource("jaquizzy/Assets/JLogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.username = username;
        this.setTitle("Jaquizzy! Quiz is on...");
        this.setList(qtopic);
        setBounds(100, 50, 1280, 750);
        getContentPane().setBackground(new Color(82, 113, 255));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jaquizzy/Assets/JaquizzyLogo.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1280, 200);
        add(l1);

        qIm = new JLabel();
        qIm.setBounds(900, 320, 300, 300);
        add(qIm);

        qno = new JLabel("");
        qno.setForeground(Color.BLACK);
        qno.setFont(new Font("Serif", Font.PLAIN, 24));
        qno.setBounds(100, 250, 50, 30);
        add(qno);
        question = new JLabel("");
        question.setForeground(Color.BLACK);
        question.setFont(new Font("Serif", Font.PLAIN, 24));
        question.setBounds(150, 250, 700, 30);
        add(question);

        opt1 = new JRadioButton("");
        opt1.setForeground(Color.BLACK);
        opt1.setBounds(170, 320, 700, 30);
        opt1.setFont(new Font("Serif", Font.PLAIN, 20));
        opt1.setBackground(new Color(210, 210, 255));
        add(opt1);
        opt2 = new JRadioButton("");
        opt2.setForeground(Color.BLACK);
        opt2.setBounds(170, 360, 700, 30);
        opt2.setFont(new Font("Serif", Font.PLAIN, 20));
        opt2.setBackground(new Color(210, 210, 255));
        add(opt2);
        opt3 = new JRadioButton("");
        opt3.setForeground(Color.BLACK);
        opt3.setBounds(170, 400, 700, 30);
        opt3.setFont(new Font("Serif", Font.PLAIN, 20));
        opt3.setBackground(new Color(210, 210, 255));
        add(opt3);
        opt4 = new JRadioButton("");
        opt4.setForeground(Color.BLACK);
        opt4.setBounds(170, 440, 700, 30);
        opt4.setFont(new Font("Serif", Font.PLAIN, 20));
        opt4.setBackground(new Color(210, 210, 255));
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton("Next");
        next.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        next.setBackground(new Color(254, 205, 0));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setBounds(550, 650, 200, 40);
        add(next);

        submit = new JButton("Submit");
        submit.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        submit.setEnabled(false);
        submit.setBackground(new Color(254, 205, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setBounds(1000, 650, 200, 40);
        add(submit);

        start(0);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            answered = true;
            if (options.getSelection() == null) {
                answers.add("");
            } else {
                answers.add(options.getSelection().getActionCommand());
            }
            count++;
            if (count < this.quizQuestions.size()) {
                start(count);
            }
            if (count == this.quizQuestions.size()) {
                quizOn = false;
            }
            System.out.println(answers);
        } else if (ae.getSource() == submit) {
            if (options.getSelection() == null) {
                answers.add("");
            } else {
                answers.add(options.getSelection().getActionCommand());
            }
            ;
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).equals(this.quizQuestions.get(i).options[this.quizQuestions.get(i).correct])) {
                    score += 10 * (1 + this.quizQuestions.get(i).multiplier);
                }
            }
            System.out.println(answers);
            this.setVisible(false);
            quizOn = false;
            count = 0;
            new Score(username, score).setVisible(true);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left : " + timer + " seconds...";
        g.setColor(new Color(210, 210, 255));
        g.setFont(new Font("Century Gothic", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 900, 270);
        } else {
            g.drawString("Time's Up!", 900, 270);
        }
        if (quizOn) {
            timer--;
        }

        try {
            Thread.sleep(1000);
            if (quizOn) {
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (answered) {
            timer = 30;
            answered = false;
        }
        if (count == this.quizQuestions.size() - 1) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        if (timer < 0) {
            if (options.getSelection() == null) {
                answers.add("");
            } else {
                answers.add(options.getSelection().getActionCommand());
            }
            quizOn = true;
            if (count == this.quizQuestions.size()-1) {
                for (int i = 0; i < answers.size(); i++) {
                    if (answers.get(i).equals(this.quizQuestions.get(i).options[this.quizQuestions.get(i).correct])) {
                        score += 10;
                    }
                    ;
                }
                System.out.println(answers);
                this.setVisible(false);
                quizOn = false;
                count = 0;
                new Score(username, score).setVisible(true);    
            } else {
                count++;
                if (count < this.quizQuestions.size()) {
                    start(count);
                }
                System.out.println(answers);
            }
            timer = 30;
        }
    }

    public int setList(String topic) {
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        String filePath = new File("Jaquizzy/src/jaquizzy/Files/" + topic + ".txt").getAbsolutePath();
        System.out.println(filePath);
        File f = new File(filePath);
        boolean fExists = true;
        if (!f.exists()) {
            fExists = false;
        }
        System.out.println(fExists);
        if (!f.canRead()) {
            f.setReadable(true);
        }
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
            int line = 0;
            String q = "";
            String r = "";
            int d = 0;
            String o1 = "";
            String o2 = "";
            String o3 = "";
            String o4 = "";
            int cI = 0;
            String dot = "";

            while (sc.hasNextLine()) {
                line %= 9;
                switch (line) {
                case 0: {
                    // Question
                    try {
                        q = sc.nextLine().toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -1;
                    }
                    break;
                }
                case 1: {
                    // Image
                    r = sc.nextLine().toString();
                    break;
                }
                case 2: {
                    // Difficulty
                    d = Integer.parseInt(sc.nextLine().toString());
                    break;
                }
                case 3: {
                    // Option1
                    o1 = sc.nextLine().toString();
                    break;
                }
                case 4: {
                    // Option2
                    o2 = sc.nextLine().toString();
                    break;
                }
                case 5: {
                    // Option3
                    o3 = sc.nextLine().toString();
                    break;
                }
                case 6: {
                    // Option4
                    o4 = sc.nextLine().toString();
                    break;
                }
                case 7: {
                    // Correct Option Index
                    cI = Integer.parseInt(sc.nextLine().toString());
                    break;
                }
                case 8: {
                    dot = sc.nextLine().toString();
                    if (dot == ".") {
                        System.out.println(". found.");
                    }
                    this.quizQuestions.add(new Questions(q, r, d, o1, o2, o3, o4, cI));
                    break;
                }
                }
                line++;
            }
            sc.close();
        } catch (IOException ei) {
            ei.printStackTrace();
            return -1;
        }
        return this.quizQuestions.size();
    }

    public void start(int count) {
        qno.setText("" + (this.quizQuestions.get(count).index + 1) + "] ");
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
        System.out.println(">>" + this.quizQuestions.get(count).resource + "<<");
        try {
            String imgPath = new File("Jaquizzy/src/jaquizzy/Images/" + this.quizQuestions.get(count).resource + ".jpg")
                    .getAbsolutePath();
            System.out.println(imgPath);
            File f = new File(imgPath);
            if (f.exists()) {
                img = ImageIO.read(new File(imgPath));
                qIm.setIcon(new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
            } else {
                String logoPath = new File("Jaquizzy/src/jaquizzy/Assets/JLogo.png").getAbsolutePath();
                img = ImageIO.read(new File(logoPath));
                qIm.setIcon(new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
            }
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        new Quiz("", "").setVisible(true);
    }
}
