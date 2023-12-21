/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-12-2023
 * Project: Fibonacci.java
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileToDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/phone";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lalith1.";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Database connection successful

            // Reading data from text file and inserting into database
            String filePath = "C:/Users/pc/OneDrive/Desktop/JAVA/Java_first_year/src/records.txt";
            String query = "INSERT INTO phone_records (name, phone_number) VALUES (?, ?)";

            try (BufferedReader br = new BufferedReader(new FileReader(filePath));
                 PreparedStatement statement = conn.prepareStatement(query)) {

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\t");

                    if (parts.length >= 2) {
                        statement.setString(1, parts[0]); // Assuming the first part is for column1
                        statement.setString(2, parts[1]); // Assuming the second part is for column2
                        statement.executeUpdate();
                    } else {
                        // Handle incomplete records
                        System.err.println("Incomplete record: " + line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
