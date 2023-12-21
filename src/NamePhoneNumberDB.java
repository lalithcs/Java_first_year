/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-12-2023
 * Project: Fibonacci.java
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NamePhoneNumberDB {

    private static final String URL = "jdbc:mysql://localhost:3306/phone";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lalith1.";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Database connection successful

            // User input and retrieval
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a name or phone number: ");
            String input = scanner.nextLine();

            String query = "SELECT name, phone_number FROM phone_records WHERE name = ? OR phone_number = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, input);
                statement.setString(2, input);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String phoneNumber = resultSet.getString("phone_number");
                        System.out.println("Corresponding value: " + (name.equals(input) ? phoneNumber : name));
                    } else {
                        System.out.println("No corresponding value found.");
                    }
                }
            }
            scanner.close();
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
