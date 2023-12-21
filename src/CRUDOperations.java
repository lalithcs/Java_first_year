/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-12-2023
 * Project: Fibonacci.java
 */
import java.sql.*;

public class CRUDOperations {

    private static final String URL = "jdbc:mysql://localhost:3306/phone";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lalith1.";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Database connection successful

            // Create table if not exists
            createTable(conn);

            // Insert data
            addData(conn, 1, "Alice", 50000);
            addData(conn, 2, "Bob", 60000);

            // Retrieve data
            retrieveData(conn);

            // Update data
            modifyData(conn, 2, "Bob", 65000);

            // Retrieve data after modification
            retrieveData(conn);

            // Delete data
            deleteData(conn, 1);

            // Retrieve data after deletion
            retrieveData(conn);
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "salary DECIMAL(10, 2)" +
                ")";
        try (Statement statement = conn.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        }
    }

    private static void addData(Connection conn, int id, String name, double salary) throws SQLException {
        String insertSQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(insertSQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, salary);
            statement.executeUpdate();
            System.out.println("Data inserted successfully.");
        }
    }

    private static void retrieveData(Connection conn) throws SQLException {
        String retrieveSQL = "SELECT * FROM employees";
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(retrieveSQL)) {
            System.out.println("Retrieving data from table:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }
        }
    }

    private static void modifyData(Connection conn, int id, String name, double newSalary) throws SQLException {
        String updateSQL = "UPDATE employees SET name = ?, salary = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(updateSQL)) {
            statement.setString(1, name);
            statement.setDouble(2, newSalary);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Data updated successfully.");
        }
    }

    private static void deleteData(Connection conn, int id) throws SQLException {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Data deleted successfully.");
        }
    }
}
