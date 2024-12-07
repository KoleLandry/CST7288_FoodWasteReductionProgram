package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static DBConnection connectionInstance;

    public static DBConnection getInstance() {
        if (connectionInstance == null) {
            connectionInstance = new DBConnection();
        }
        return connectionInstance;
    }

    public static Connection getConnection() {
        // If there is no connection...
        if (connection == null) {
            try {
                String serverUrl = "jdbc:mysql://localhost:3306/food_distribution_system";
                String userString = "***";
                String passwordString = "***";

                // Attempt to connect using url, user, and password
                connection = DriverManager.getConnection(serverUrl, userString, passwordString);
            } catch (SQLException e) {
                //
            }

        }
        return connection;
    }

}
