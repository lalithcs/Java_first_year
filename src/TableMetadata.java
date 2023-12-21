/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-12-2023
 * Project: Fibonacci.java
 */
import java.sql.*;

public class TableMetadata {

    private static final String URL = "jdbc:mysql://localhost:3306/phone";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lalith1.";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Database connection successful

            String tableName = "phone_records"; // Replace with your table name
            DatabaseMetaData metaData = conn.getMetaData();

            try (ResultSet rs = metaData.getColumns(null, null, tableName, null)) {
                System.out.println("Metadata for table: " + tableName);
                System.out.println("-----------------------------------------------------");
                System.out.printf("%-15s %-15s %-15s %-15s%n", "Column Name", "Data Type", "Nullable", "Is AutoIncr");

                while (rs.next()) {
                    String columnName = rs.getString("COLUMN_NAME");
                    String dataType = rs.getString("TYPE_NAME");
                    String nullable = rs.getString("IS_NULLABLE");
                    String isAutoIncrement = rs.getString("IS_AUTOINCREMENT");

                    System.out.printf("%-15s %-15s %-15s %-15s%n", columnName, dataType, nullable, isAutoIncrement);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
