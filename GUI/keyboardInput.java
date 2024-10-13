package GUI;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyboardInput extends  JFrame{
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton SPACERButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button1;
    private JTextField ACIITF;
    private JLabel input;
    private JLabel ascii;
    private JTextField textField1;
    private JPanel main;
    private JPanel keyboard;

    public keyboardInput() {

        setTitle("Keyboard Input");
        setContentPane(main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char keyChar = e.getKeyChar();
                int asciiValue = (int) keyChar;

                if (Character.isLetter(keyChar) ) {
                    String uppercaseChar = Character.toUpperCase(keyChar) + "";
                    ACIITF.setText(String.valueOf(asciiValue));
                } else if (Character.isDigit(keyChar)) {
                    ACIITF.setText(String.valueOf(asciiValue));
                } else if (keyChar == ' ') {
                    ACIITF.setText("32");
                }
                else {
                    JOptionPane.showMessageDialog(null, "invalid key", "Error", JOptionPane.ERROR_MESSAGE);
                    ACIITF.setText("invalid Key");
                    textField1.setText("");
                }
            }
        });
    }
    public static void main(String[] args) {
        keyboardInput keyboardInput = new keyboardInput();
    }
}
