package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookSearchSystem extends JFrame {
    private JPanel panel;
    private JLabel hello;
    private JLabel visitors;
    private JLabel borrowedBooks;
    private JLabel newMembers;
    private JLabel nVisitors;
    private JLabel nborrowBooks;
    private JLabel nMembers;
    private JToolBar toolbar;
    private JLabel home;
    private JLabel search;
    private JLabel profile;
    private JLabel settings;

    public BookSearchSystem() {
        System.out.println("AREEBA ABDUL RASOOL 22K-4821 :) ");
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                searchWindow sw= new searchWindow();
                sw.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        BookSearchSystem form = new BookSearchSystem();
        form.setContentPane(form.panel);
        form.setTitle("Book Search form");
        form.setSize(600,300);
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
