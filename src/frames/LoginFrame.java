package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static database.DBOperations.getUserId;
import static database.DBOperations.getUserType;

public class LoginFrame {
    public LoginFrame() {
        // Create the frame for the login window.
        JFrame loginFrame = new JFrame("Food Waste Reduction Platform");
        loginFrame.setLayout(new BoxLayout(loginFrame.getContentPane(), BoxLayout.Y_AXIS));

        // Create the email panel
        JPanel emailPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField enterEmail = new JTextField(10);

        // Create the password panel
        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password: ");
        JPasswordField enterPass = new JPasswordField(10);

        // Create the login and register panel
        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JPanel registerPanel = new JPanel();
        JButton registerButton = new JButton("Register");

        // Allow the Register button to open the Register page
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(false);

                new RegisterFrame(loginFrame);
            }
        });

        // Allow the Register button to open the Register page
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate user login input
                boolean userValid = validation.ValidateUser.validateLogin(enterEmail.getText().trim(), enterPass.getText().trim());

                if (userValid) {// Method to get the user's type
                    int userId = getUserId(enterEmail.getText().trim(), enterPass.getText().trim()); // Method to get the user's id
                    String userType = getUserType(userId);

                    if (userType != null) {
                        loginFrame.setVisible(false);

                        if ("retailer".equalsIgnoreCase(userType)) {
                            RetailerFrame retailerFrame = new RetailerFrame(loginFrame, userId);
                            retailerFrame.setVisible(true);
                        } else if ("consumer".equalsIgnoreCase(userType)) {
                            ConsumerFrame consumerFrame = new ConsumerFrame(loginFrame, userId);
                            consumerFrame.setVisible(true);
                        } else if ("charitable organization".equalsIgnoreCase(userType)) {
                            CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame, userId);
                            charOrganizationFrame.setVisible(true);
                        }
                    }
                }
            }
        });

        // Add all the details to the panels
        emailPanel.add(emailLabel);
        emailPanel.add(enterEmail);
        passPanel.add(passLabel);
        passPanel.add(enterPass);
        loginPanel.add(loginButton);
        registerPanel.add(registerButton);

        // Add the panels to the JFrame
        loginFrame.add(emailPanel);
        loginFrame.add(passPanel);
        loginFrame.add(loginPanel);
        loginFrame.add(registerPanel);

        loginFrame.setSize(800, 400); // Set the size of the window.
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
