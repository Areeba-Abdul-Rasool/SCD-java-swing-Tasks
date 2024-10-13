package exceptionHandling;


import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter amount : ");
            int x = sc.nextInt();
            CustomException account = new CustomException(x);

            System.out.println("enter amount to withdraw : ");
            int w = sc.nextInt();
            account.withdraw(w);
            System.out.println("New balance: " + account.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    private double balance;

    public CustomException(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        checkBalance(amount);
        balance -= amount;
    }

    private void checkBalance(double amount) throws InsufficientBalanceException {
        if (balance - amount < 100) {
            throw new InsufficientBalanceException("insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msgg) {
        super(msgg);
    }
}