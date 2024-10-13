package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class displayRegData extends JFrame {
    private JTable table;
    private JPanel maindisppanel;

    public displayRegData(String name, String fatherName, String cnic, String phone, String password,String gender) {
        String[] columnNames = {"Name", "Father's Name", "CNIC", "Phone", "Gender", "Password"};
        int numberOfColumns = columnNames.length;
        int numberOfRows = 0;
        table.setModel(new DefaultTableModel(new Object[numberOfRows][numberOfColumns], columnNames));

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{name,fatherName,cnic,phone,gender,password});

        maindisppanel = new JPanel();
        maindisppanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        maindisppanel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(maindisppanel);

        setTitle("Registration Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        displayRegData data = new displayRegData("Areeba", "Abdul Rasool", "4210192468299", "09007801", "1234",  "Female");
    }
}