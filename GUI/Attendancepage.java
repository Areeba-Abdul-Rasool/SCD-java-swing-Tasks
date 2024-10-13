package GUI;

import javax.swing.*;

public class Attendancepage extends  JFrame{
    private JComboBox comboBox1;
    private JProgressBar progressBar1;
    private JPanel attendance;
    private JPanel registeredCourses;

    public Attendancepage() {
        setContentPane(attendance);
        setTitle(" Attendance page");
        setSize(300,325);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Attendancepage attendancepage = new Attendancepage();
    }
}