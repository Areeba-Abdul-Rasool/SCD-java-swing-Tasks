package GUI;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends JFrame{
    private JLabel FlexIcon;
    private JTextField textField1;
    private JLabel proficon;
    private JCheckBox rememberMeCheckBox;
    private JButton signInButton;
    private JPanel home;
    private JPasswordField passwordField1;

    public LogInPage() {

        setContentPane(home);
        setTitle("flex logIn page");
        setSize(500,550);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, " areeba abdul 22k-4821");
                studentPortal sp = new studentPortal();
                sp.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        LogInPage logInPage = new LogInPage();
    }
}
