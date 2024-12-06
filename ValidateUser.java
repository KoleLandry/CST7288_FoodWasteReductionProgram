public class ValidateUser {

    // Method to validate user input (email and password)
    public static boolean validateLogin(String email, String password) {
        // Check if email is empty
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email is required.");
            return false;
        }

        // Check if password is empty
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password is required.");
            return false;
        }

        // Validate email format (basic check)
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.println("Invalid email format.");
            return false;
        }

        // Validate password length (for example, at least 6 characters)
        if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            return false;
        }

        // If all validations pass
        System.out.println("Validation successful!");
        return true;
    }
}
