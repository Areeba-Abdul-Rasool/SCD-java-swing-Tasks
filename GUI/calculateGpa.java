package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculateGpa extends  JFrame{
    private JTextField s1;

    private JTextField s3;
    private JTextField s4;
    private JTextField s5;
    private JTextField s6;
    private JTextField crd1;
    private JTextField crd2;
    private JTextField crd3;
    private JTextField crd4;
    private JTextField crd5;
    private JTextField crd6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JLabel subj;
    private JLabel crdhrs;
    private JLabel grade;
    private JButton CALCULATEGPAButton;
    private JButton RESETButton;
    private JButton SUMMARYButton;
    private JButton calculateGPAButton;
    private JPanel panel;
    private JLabel totalGpais;
    private JLabel title;
    private JTextField s2;


    public calculateGpa() {

        setTitle("gpa calculator");
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,600);


        calculateGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalcrd = Integer.parseInt(crd1.getText()) + Integer.parseInt(crd2.getText()) + Integer.parseInt(crd3.getText()) + Integer.parseInt(crd4.getText()) + Integer.parseInt(crd5.getText()) + Integer.parseInt(crd6.getText());

                double grade1 = getGradePoints(comboBox1.getSelectedItem().toString());
                double grade2 = getGradePoints(comboBox2.getSelectedItem().toString());
                double grade3 = getGradePoints(comboBox3.getSelectedItem().toString());
                double grade4 = getGradePoints(comboBox4.getSelectedItem().toString());
                double grade5 = getGradePoints(comboBox5.getSelectedItem().toString());
                double grade6 = getGradePoints(comboBox6.getSelectedItem().toString());

                double gpa = grade1 * Double.parseDouble(crd1.getText()) + grade2 * Double.parseDouble(crd2.getText())
                        + grade3 * Double.parseDouble(crd3.getText()) + grade4 * Double.parseDouble(crd4.getText())
                        + grade5 * Double.parseDouble(crd5.getText()) + grade6 * Double.parseDouble(crd6.getText());

                double sgpa = gpa / totalcrd;
                totalGpais.setFont(new Font("Arial", Font.BOLD,14));
                totalGpais.setText("Your SGPA is: " + sgpa);
            }
        });
        RESETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : panel.getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("");
                    } else if (component instanceof JComboBox) {
                        JComboBox<?> comboBox = (JComboBox<?>) component;
                        comboBox.setSelectedIndex(0);
                    }
                }
            }
        });

        SUMMARYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] subjects = {s1.getText(), s2.getText(), s3.getText(), s4.getText(), s5.getText(), s6.getText()};
                double[] creditHours = {Double.parseDouble(crd1.getText()), Double.parseDouble(crd2.getText()), Double.parseDouble(crd3.getText()), Double.parseDouble(crd4.getText()), Double.parseDouble(crd5.getText()), Double.parseDouble(crd6.getText())};
                String[] grades = {comboBox1.getSelectedItem().toString(), comboBox2.getSelectedItem().toString(), comboBox3.getSelectedItem().toString(), comboBox4.getSelectedItem().toString(), comboBox5.getSelectedItem().toString(), comboBox6.getSelectedItem().toString()};

                double grade1 = getGradePoints(comboBox1.getSelectedItem().toString());
                double grade2 = getGradePoints(comboBox2.getSelectedItem().toString());
                double grade3 = getGradePoints(comboBox3.getSelectedItem().toString());
                double grade4 = getGradePoints(comboBox4.getSelectedItem().toString());
                double grade5 = getGradePoints(comboBox5.getSelectedItem().toString());
                double grade6 = getGradePoints(comboBox6.getSelectedItem().toString());

                double[] gpas = {grade1, grade2, grade3, grade4, grade5, grade6};

                displayGPAdetails detailsForm = new displayGPAdetails(subjects, creditHours, grades, gpas);
                detailsForm.setVisible(true);
                setVisible(false);
            }
        });
    }

    private double getGradePoints(String grade) {
        switch (grade) {
            case "A+":
                return 4.0;
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        calculateGpa gpa = new calculateGpa();

    }
}
