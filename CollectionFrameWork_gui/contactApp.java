package CollectionFrameWork_gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class contactApp extends JFrame {

    private Set<Contact> contacts;
    private DefaultListModel<Contact> contactListModel;
    private JList<Contact> list;

    private JTextField nametf;
    private JTextField phonetf;
    private JTextField emailtf;
    private JButton addToContactListButton;
    private JLabel Name;
    private JLabel phone;
    private JLabel email;
    private JLabel sname;
    private JLabel sPhone;
    private JTextField searchname;
    private JTextField searchphoen;
    private JButton viewAllContactsButton;
    private JButton searchButton;
    private JPanel panel;

    public contactApp() {
        contacts = new HashSet<>();
        contactListModel = new DefaultListModel<>();
        list.setModel(contactListModel);


        setTitle("k22 4821 Areebaa Contact List Application");
        setContentPane(panel);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addToContactListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametf.getText();
                String phone = phonetf.getText();
                String email = emailtf.getText();

                if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(contactApp.this, "*all fields are required*","error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Contact contact=new Contact(name,phone,email);


                if (contacts.add(contact)) {
                    contactListModel.addElement(contact);
                    JOptionPane.showMessageDialog(contactApp.this, "Added successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(contactApp.this, "Duplicate contact found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            private void clearFields() {
                nametf.setText("");
                phonetf.setText("");
                emailtf.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchname.getText();
                String pno = searchphoen.getText();

                boolean found = false;

                list.clearSelection();
                contactListModel.clear();


                for (Contact contact : contacts) {
                    if (contact.getName().equalsIgnoreCase(name)  ||contact.getPhoneNumber().equals(pno)) {
                        contactListModel.addElement(contact);
                        found =
                                true;
                    }
                }

                         if (!found) {
                    JOptionPane.showMessageDialog(contactApp.this, "cont not found.", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewAllContactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clearSelection();
                contactListModel.clear();
                for (Contact contact : contacts) {
                    contactListModel.addElement(contact);}
            }
        });
    }

    public static void main(String[] args)
    {
        contactApp c = new contactApp();

    }}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
