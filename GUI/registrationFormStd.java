package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrationFormStd extends  JFrame {
    private JPanel mainpanel;
    private JLabel registrationtitle;
    private JTextField nametf;
    private JTextField fathernametf;
    private JTextField cnictf;
    private JTextField pno_tf;
    private JPasswordField passTf;
    private JPasswordField confirmTf;
    private JLabel stdName;
    private JLabel fatherName;
    private JLabel CNIC;
    private JLabel Pno;
    private JLabel gender;
    private JLabel pass;
    private JLabel confirm;
    private JButton registerButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;

    public registrationFormStd() {

        System.out.println(" areeba 22k-4821 ");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateData()) {
                    String name = nametf.getText();
                    String fatherName = fathernametf.getText();
                    String cnic = cnictf.getText();
                    String phone = pno_tf.getText();
                    String password = new String(passTf.getPassword());
                    String confirmPassword = new String(confirmTf.getPassword());
                    String gender = getSelectedGender();

                    displayRegData displayForm = new displayRegData(name,fatherName, cnic, phone,password, gender);
                    displayForm.setVisible(true);
                    dispose();
                }
            }
        });
    }

    private boolean validateData() {
        boolean isValid = true;
        String password = new String(passTf.getPassword());
        String confirmPassword = new String(confirmTf.getPassword());

        if (!password.equals(confirmPassword)) {
            isValid = false;
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);}

        return isValid;
    }

    private String getSelectedGender() {
        if (maleRadioButton.isSelected()) {
            return "Male";}
        else if (femaleRadioButton.isSelected()) {
            return "Female"; }
        else{ return "Other"; }
    }

    public static void main(String[] args) {
        registrationFormStd registrationForm = new registrationFormStd();

        registrationForm.setTitle("Registration Form");
        registrationForm.setContentPane(registrationForm.mainpanel);
        registrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrationForm.setSize(500, 500);
        registrationForm.setLocationRelativeTo(null);
        registrationForm.setVisible(true);
    }
    }
