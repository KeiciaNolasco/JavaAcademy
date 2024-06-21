package academiajava.locacaofilme.configs;

import java.sql.*;

public class DatabaseConfig {

    private static final String url = "jdbc:postgresql://localhost:5432/locacaofilme";
    private static final String user = "postgres";
    private static final String password = "Enigma45#";
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to connect to database");
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Disconnected from PostgreSQL database");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException e) {
                throw new RuntimeException("Could not close statement", e);
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            }
            catch (SQLException e) {
                throw new RuntimeException("Could not close result set", e);
            }
        }
    }

}