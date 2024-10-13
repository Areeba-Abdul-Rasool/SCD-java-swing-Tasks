package GUI;
import javax.swing.*;

public class studentPortal extends JFrame{
    private JPanel portal;
    private JPanel studentOpetions;
    private JLabel crsRegistration;
    private JLabel Home;
    private JLabel transcript;
    private JLabel Attendance;
    private JLabel settings;
    private JLabel Feedet;

    public studentPortal() {
        setContentPane(portal);
        setTitle("Student Portal");
        setSize(1200,455);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crsRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseRegistration crs = new CourseRegistration();
                crs.setVisible(true);
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

        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentPortal studentPortal = new studentPortal();
                studentPortal.setVisible(true);
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        studentPortal studentPortal = new studentPortal();
    }
}

