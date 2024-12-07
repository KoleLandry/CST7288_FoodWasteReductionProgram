package database;

import java.sql.*;

public class DBOperations {
    public static void createUser(String name, String email, String password, String userType) {
        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO Users (name, email, password, user_type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, userType);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getUserType(String email, String password) {
        Connection connection = DBConnection.getConnection();

        String query = "SELECT user_type FROM Users WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getString("user_type"); // Return the user type
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static int getUserId(String email, String password) {
        Connection connection = DBConnection.getConnection();

        String query = "SELECT user_id FROM Users WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getInt("user_id"); // Return the user type
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void addFood(Integer retailerId, String foodName, Integer quantity, Date expirationDate) {
        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO FoodInventory (retailer_id, food_name, quantity, expiration_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, retailerId);
            stmt.setString(2, foodName);
            stmt.setInt(3, quantity);
            stmt.setDate(4, expirationDate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateQuantity(Integer itemId, String foodName, Integer quantity) {
        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO FoodInventory (inventory_id, food_name, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            stmt.setString(2, foodName);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateExpDate(Integer itemId, String foodName, Date expirationDate) {
        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO FoodInventory (invantory_id, food_name, expiration_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            stmt.setString(2, foodName);
            stmt.setDate(3, expirationDate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addRating(Integer targetId, Integer userId, Integer ratingValue) {
        Connection connection = DBConnection.getConnection();

        String query = "INSERT INTO Ratings (retailer_id, rater_id, rating_value) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, targetId);
            stmt.setInt(2, userId);
            stmt.setInt(3, ratingValue);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /*

-- 3) Transactions Table
    CREATE TABLE Transactions (
            transaction_id INT PRIMARY KEY AUTO_INCREMENT,
            user_id INT NOT NULL,
            food_item_id INT NOT NULL,
            transaction_type ENUM('Purchase', 'Donation') NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) DEFAULT 0.00,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (food_item_id) REFERENCES FoodInventory(inventory_id) ON DELETE CASCADE
);

-- 5) Notifications Table
    CREATE TABLE Notifications (
            notification_id INT PRIMARY KEY AUTO_INCREMENT,
            user_id INT NOT NULL,
            message TEXT NOT NULL,
            is_read BOOLEAN DEFAULT FALSE,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- 6) Categories Table
    CREATE TABLE Categories (
            category_id INT PRIMARY KEY AUTO_INCREMENT,
            category_name VARCHAR(50) UNIQUE NOT NULL
);

-- 7) FoodInventory_Categories Table (Many-to-Many)
    CREATE TABLE FoodInventory_Categories (
            inventory_id INT NOT NULL,
            category_id INT NOT NULL,
            PRIMARY KEY (inventory_id, category_id),
    FOREIGN KEY (inventory_id) REFERENCES FoodInventory(inventory_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE CASCADE
);*/
}
