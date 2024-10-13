package exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("enter numerator: ");
            if (!sc.hasNextFloat()) {
                throw new InputMismatchException("invalid input format.");
            } int n = sc.nextInt();

            System.out.print("enter a denominator: ");
            if (!sc.hasNextFloat()) {
                throw new InputMismatchException("invalid input format.");
            } int d = sc.nextInt();

            try{
                int result = n/d;
                System.out.println("result: " + result);
            }catch (ArithmeticException e) {
                System.out.println("division by zero is not allowed." +e.getMessage());
            }

            System.out.print("enter array size: ");
            int size = sc.nextInt();
            String[] array = new String[size];

            for (int i =0; i<size; i++) {
                System.out.print("element " + (i+1) + ": ");
                array[i] = sc.next();
            }

            System.out.print("enter the index to swap: ");
            int idx1 = sc.nextInt();
            System.out.print("enter the index to swap with: ");
            int idx2 = sc.nextInt();

            if (idx1 < 0 || idx1 >= size || idx2 < 0 || idx2 >=size) {
                throw new ArrayIndexOutOfBoundsException("invalid array index values...");
            }
            String temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
            System.out.println("updated array : " + java.util.Arrays.toString(array));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid array index values...");
        } catch (InputMismatchException e) {
            System.out.println("invalid input format.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
