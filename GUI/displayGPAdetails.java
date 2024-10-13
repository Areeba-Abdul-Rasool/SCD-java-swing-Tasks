package GUI;

import javax.swing.*;

public class displayGPAdetails extends JFrame {
    private JLabel summary;
    private JLabel s1;
    private JPanel panel;
    private JLabel s3;
    private JLabel s4;
    private JLabel s5;
    private JLabel s2;
    private JLabel s6;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private JLabel h4;
    private JLabel h5;
    private JLabel h6;
    private JLabel g1;
    private JLabel g2;
    private JLabel g3;
    private JLabel g4;
    private JLabel g5;
    private JLabel g6;
    private JLabel gpa1;
    private JLabel gpa2;
    private JLabel gpa3;
    private JLabel gpa4;
    private JLabel gpa5;
    private JLabel gpa6;



    private JLabel[] subjectLabels = {s1, s2, s3, s4, s5, s6};
    private JLabel[] creditHourLabels = {h1, h2, h3, h4, h5, h6};
    private JLabel[] gradeLabels = {g1, g2, g3, g4, g5, g6};
    private JLabel[] gpaLabels = {gpa1, gpa2, gpa3, gpa4, gpa5, gpa6};

    public displayGPAdetails(String[] subjects, double[] creditHours, String[] grades, double[] gpas) {

        setTitle("student details");
        setContentPane(panel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        for (int i = 0; i < subjects.length; i++) {
            subjectLabels[i].setText(subjects[i]);
            creditHourLabels[i].setText(String.valueOf(creditHours[i]));
            gradeLabels[i].setText(grades[i]);
            gpaLabels[i].setText(String.valueOf(gpas[i]));}
    }
}

