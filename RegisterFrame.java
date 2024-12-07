package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static database.DBOperations.createUser;

public class RegisterFrame extends JFrame {
    public RegisterFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Food Waste Reduction Platform");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the name panel
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        JTextField enterName = new JTextField(10);

        // Create the email panel
        JPanel emailPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField enterEmail = new JTextField(10);

        // Create the password panel
        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password: ");
        JPasswordField enterPass = new JPasswordField(10);

        // Create the user type panel
        JPanel userTypePanel = new JPanel();
        JCheckBox retailerCheckBox = new JCheckBox("Retailer");
        JCheckBox charOrganizationCheckBox = new JCheckBox("Charitable Organization");
        JCheckBox consumerCheckBox = new JCheckBox("Consumer");

        // Create the register panel
        JPanel registerPanel = new JPanel();
        JButton registerButton = new JButton("Register");

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        namePanel.add(nameLabel);
        namePanel.add(enterName);
        emailPanel.add(emailLabel);
        emailPanel.add(enterEmail);
        passPanel.add(passLabel);
        passPanel.add(enterPass);
        userTypePanel.add(retailerCheckBox);
        userTypePanel.add(charOrganizationCheckBox);
        userTypePanel.add(consumerCheckBox);
        registerPanel.add(registerButton);
        backPanel.add(backButton);

        // Allow the register button to create users
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show error popup if multiple user types are selected
                int selectedCount = 0;
                if (retailerCheckBox.isSelected()) selectedCount++;
                if (charOrganizationCheckBox.isSelected()) selectedCount++;
                if (consumerCheckBox.isSelected()) selectedCount++;
                if (selectedCount > 1) {
                    JOptionPane.showMessageDialog(null, "Please select only one user type.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate user input
                String name = enterName.getText().trim();
                String email = enterEmail.getText().trim();
                String password = new String(enterPass.getPassword()).trim();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (password.isEmpty() || password.length() < 6) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Set userType to the type of user selected
                String userType = "";
                if (retailerCheckBox.isSelected()) userType = "Retailer";
                if (charOrganizationCheckBox.isSelected()) userType = "Charitable Organization";
                if (consumerCheckBox.isSelected()) userType = "Consumer";

                if (userType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user type.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create the new user
                createUser(name, email, password, userType);
                JOptionPane.showMessageDialog(null, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                setVisible(false);
                loginFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Register to Login
                setVisible(false);
                loginFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(namePanel);
        add(emailPanel);
        add(passPanel);
        add(userTypePanel);
        add(registerPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
