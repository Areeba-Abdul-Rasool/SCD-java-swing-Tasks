package exceptionHandling;
import java.util.Scanner;

public class task1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            String input = sc.nextLine();

            try {
                int x = Integer.parseInt(input);
                System.out.println("Input : " +x);
            } catch (NumberFormatException e) {
                System.out.println("invalid input. please enter an integer value <1,2,3,4,...> .");
            }
        }
    }
