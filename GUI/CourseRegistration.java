package GUI;

import javax.swing.*;

public class CourseRegistration extends  JFrame{
    private JPanel courseRegPanel;
    private JPanel MenuBar;
    private JCheckBox enrollCheckBox;
    private JCheckBox enrollCheckBox1;
    private JCheckBox enrollCheckBox2;
    private JCheckBox enrollCheckBox3;
    private JLabel Attendance;
    private JLabel trans;
    private JLabel feedet;
    private JLabel settings;
    private JLabel home;
    private JLabel crsReg;

    public CourseRegistration() {
        setContentPane(courseRegPanel);
        setSize(700,400);
        setTitle("register");

        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentPortal studentPortal = new studentPortal();
                studentPortal.setVisible(true);
                dispose();
            }
        });

        Attendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Attendancepage attendancepage = new Attendancepage();
                attendancepage.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        CourseRegistration cg = new CourseRegistration();
        cg.setVisible(true);
    }
}
