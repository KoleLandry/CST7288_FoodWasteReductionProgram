USE food_distribution_system;

-- 1. Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    user_type ENUM('Retailer', 'Consumer', 'Charitable Organization') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2) Food Inventory Table
CREATE TABLE FoodInventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    retailer_id INT NOT NULL,
    food_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(50) NOT NULL,
    expiration_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (retailer_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

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

-- 4) Ratings Table
CREATE TABLE Ratings (
    rating_id INT PRIMARY KEY AUTO_INCREMENT,
    retailer_id INT NOT NULL,
    rater_id INT NOT NULL,
    rating_value INT CHECK (rating_value BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (retailer_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (rater_id) REFERENCES Users(user_id) ON DELETE CASCADE
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
);

-- 8) Logs Table
CREATE TABLE Logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    action VARCHAR(255) NOT NULL,
    log_message TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE SET NULL
);
