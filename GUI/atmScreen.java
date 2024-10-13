package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atmScreen extends JFrame {
    public static void main(String[] args) {
        atmScreen screen = new atmScreen();
    }

    private JPanel main;
    private JPanel title;
    private JTextField accTF;
    private JTextField PINtf;
    private JLabel acc;
    private JLabel pin;
    private JLabel login;
    private JButton OKButton;
    private int balance = 100000;

    public atmScreen() {
        setTitle("ATM SCREEN");
        setContentPane(main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateData()) {
                    atmoptionsform form = new atmoptionsform();
                    setVisible(false);
                    form.setVisible(true);
                }
            }
        });
    }

    private boolean validateData() {
        boolean isValid = true;
        String password = PINtf.getText();
        String accNo = accTF.getText();

        if (!password.equals("0900") || !accNo.equals("4567")) {
            isValid = false;
            JOptionPane.showMessageDialog(null, "invalid PIN code.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    public class atmoptionsform extends JFrame {
        private JButton sendCashButton;
        private JButton depositCashButton;
        private JButton billPaymentsButton;
        private JButton printStatementButton;
        private JButton changePinButton;
        private JPanel form;
        private JLabel heading;
        private JButton withdraw;

        public atmoptionsform() {
            setTitle("ATM option form ");
            setContentPane(form);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(400, 300);
            setVisible(true);
            setLocationRelativeTo(null);

            withdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    withdraw withdraw = new withdraw();
                    setVisible(false);
                    withdraw.setVisible(true);
                }
            });

            depositCashButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deposit deposit = new deposit();
                    setVisible(false);
                    deposit.setVisible(true);
                }
            });
        }
    }

    public class deposit extends JFrame {
        private JPanel deposit;
        private JTextField textField1;
        private JButton depositButton;

        public deposit() {
            setTitle("Deposit");
            setContentPane(deposit);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(200, 200);
            setVisible(true);
            setLocationRelativeTo(null);

            depositButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int amount = Integer.parseInt(textField1.getText());
                    balance += amount;
                    JOptionPane.showMessageDialog(null, amount + " deposited to your account successfully!");

                    atmoptionsform form = new atmoptionsform();
                    setVisible(false);
                    form.setVisible(true);
                }
            });
        }
    }

    public class withdraw extends JFrame {
        private JPanel withdraw;
        private JTextField textField1;
        private JButton withdrawButton;

        public withdraw() {
            setTitle("Withdraw");
            setContentPane(withdraw);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(200, 200);
            setVisible(true);
            setLocationRelativeTo(null);

            withdrawButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int amount = Integer.parseInt(textField1.getText());
                    if (amount <= balance) {
                        balance -= amount;
                        JOptionPane.showMessageDialog(null,amount + " withdrawn successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "insufficient amount in accountry!");
                    }

                    atmoptionsform form = new atmoptionsform();
                    setVisible(false);
                    form.setVisible(true);
                }
            });
        }
    }
}