package exceptionHandling;

import java.io.IOException;

public class Task6 {
    public static void readFile(String fn) throws IOException {
        if (fn.equals("xyz.txt")) {
            throw new IOException("File " +fn+ " not found.");
        } else {
            System.out.println("Reading file: " + fn);
        }
    }
    public static void main(String[] args) {
        try {
            readFile("data.txt");
            readFile("xyz.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
