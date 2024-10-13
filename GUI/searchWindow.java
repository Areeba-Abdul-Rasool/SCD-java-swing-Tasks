package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchWindow extends JFrame {
    private JPanel panel2;
    private JLabel bookName;
    private JTextField bookname;
    private JTextField author;
    private JButton searchButton;
    private JComboBox comboBox1;

    public searchWindow() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(searchButton,"book "+bookname.getText()+ " found.");
            }
        });
    }

    public static void main(String[] args) {
        searchWindow form = new searchWindow();
        form.setContentPane(form.panel2);
        form.setTitle("search");
        form.setSize(400,200);
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
