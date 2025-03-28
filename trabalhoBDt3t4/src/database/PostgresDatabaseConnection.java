package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/trabbd2";
    private static String USER;
    private static String PASSWORD;

    private static Connection connection;

    private PostgresDatabaseConnection() {}

    // Método para definir as credenciais dinamicamente
    public static void setCredentials(String user, String password) {
        USER = user;
        PASSWORD = password;
        closeConnection(); // Fechar a conexão atual, se houver, para usar as novas credenciais
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Falha ao conectar ao banco de dados: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Falha ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
