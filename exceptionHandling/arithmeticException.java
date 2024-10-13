package exceptionHandling;


import java.util.Scanner;

public class arithmeticException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a numerator: ");
        String n = scanner.nextLine();
        System.out.print("enter a denominator: ");
        String d = scanner.nextLine();

        try {
            int denominator = Integer.parseInt(d);
            int numerator = Integer.parseInt(n);

            try {
                float result = (float) numerator /denominator;
                System.out.println("result is " + result);

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            } catch (ArithmeticException e) {
                System.out.println("division by zero is not allowed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
