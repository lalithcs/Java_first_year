/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-12-2023
 * Project: Fibonacci.java
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class NamePhoneNumber {

    public static void main(String[] args) {
        Hashtable<String, String> records = new Hashtable<>();

        // Load data from the text file
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/pc/OneDrive/Desktop/JAVA/Java_first_year/src/records.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                records.put(parts[0], parts[1]); // Assuming the first part is name and second is phone number
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // User input and retrieval
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name or phone number: ");
        String input = scanner.nextLine();

        if (records.containsKey(input)) {
            System.out.println("Corresponding value: " + records.get(input));
        } else {
            boolean found = false;
            for (String key : records.keySet()) {
                if (records.get(key).equals(input)) {
                    System.out.println("Corresponding value: " + key);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No corresponding value found.");
            }
        }
        scanner.close();
    }
}

