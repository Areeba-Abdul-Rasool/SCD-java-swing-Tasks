package CollectionFrameWork_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class LibraryMS  extends  JFrame{

    public static void main(String[] args) {
        LibraryMS lms = new LibraryMS();
    }

    private JPanel main;
    private JButton ADDButton;
    private JButton REMOVEButton;
    private JButton SEARCHButton;
    private JButton VIEWALLButton;
    private JLabel WELCOME;
    private JLabel LMS;
    private JTextField tfAddtitle;
    private JTextField tfaddauthor;
    private JTextField tfremoveIsbn;
    private JLabel TITLE;
    private JLabel author;
    private JLabel isbn;
    private JTextField tfAddIsbn;
    private JTextField tfseachtitle;
    private JTextField tfsearchIsbn;
    private JLabel searchTitle;
    private JLabel ISBN;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Books> bookList = new ArrayList<>();


    public LibraryMS() {

        setContentPane(main);
        setTitle("LMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,350);
        setVisible(true);


        model = new DefaultTableModel(new String[]{"Title", "Author", "ISBN"}, 0);
        table.setModel(model);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfAddtitle.getText();
                String author = tfaddauthor.getText();
                String isbn = tfAddIsbn.getText();

                tfAddtitle.setText("");
                tfaddauthor.setText("");
                tfAddIsbn.setText("");

                Books book = new Books(title, author, isbn);
                bookList.add(book);
                model.addRow(new Object[]{title, author, isbn});


            }
        });

        REMOVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String isbnToRemove = tfremoveIsbn.getText();
                if (isbnToRemove != null) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (bookList.get(i).getIsbn().equalsIgnoreCase(isbnToRemove)) {
                            bookList.remove(i);
                            model.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Book removed.");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            }
        });

        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchedISBN = tfsearchIsbn.getText();
                if (searchedISBN != null) {
                    for (Books book : bookList) {
                        if (book.getIsbn().equalsIgnoreCase(searchedISBN) || book.getTitle().equalsIgnoreCase(searchedISBN)) {
                            JOptionPane.showMessageDialog(null, "Book found:\n" +
                                    "Title: " + book.getTitle() + "\n" +
                                    "Author: " + book.getAuthor() + "\n" +
                                    "ISBN: " + book.getIsbn());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            }
        });

        VIEWALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);

                for (Books book : bookList) {
                    model.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn()});
                }
                if (bookList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No books in the collection.");
                }
            }
        });
    }

    public class Books {
        private String title;
        private String author;
        private String isbn;

        public Books(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }
}
