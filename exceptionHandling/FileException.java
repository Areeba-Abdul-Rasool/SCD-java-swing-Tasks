package exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileException {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("enter the file name: ");
        String fn = s.nextLine();

        try {
            File file = new File(fn);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + fn);
        } finally {
            s.close();
        }
    }
}
