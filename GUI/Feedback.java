package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Feedback extends  JFrame {

    private JPanel panel;
    private JTextField usernamefield;
    private JPasswordField passwordField1;
    private JButton LOGINButton;

    public Feedback() {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernamefield.getText();
                String password = passwordField1.getText();

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null,
                            "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "areeba abdul rasool 22k 4821");

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    public static void main(String[] args) {
        Feedback form = new Feedback();
        form.setContentPane(form.panel);
        form.setTitle("login form");
        form.setSize(300,300);
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
