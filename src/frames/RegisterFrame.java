package frames;

import validation.ValidateUser;

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
                // Count how many user types are selected
                int userTypeNum = 0;
                if (retailerCheckBox.isSelected()) userTypeNum++;
                if (charOrganizationCheckBox.isSelected()) userTypeNum++;
                if (consumerCheckBox.isSelected()) userTypeNum++;

                String userType = "";

                // Display an error if more than one user type is selected
                if (userTypeNum > 1) {
                    JOptionPane.showMessageDialog(null, "Please select only one user type.", "User Type Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean userValid = ValidateUser.validateLogin(enterEmail.getText().trim(), enterPass.getText().trim());

                if (userValid && userTypeNum == 1) {
                    setVisible(false);

                    // Determine what type of user they are
                    if (retailerCheckBox.isSelected()) {
                        userType = "Retailer";
                    } else if (charOrganizationCheckBox.isSelected()) {
                        userType = "Charitable Organization";
                    } else if (consumerCheckBox.isSelected()) {
                        userType = "Consumer";
                    }

                    // Create a user and send back to login page
                    createUser(enterName.getText(), enterEmail.getText(), new String(enterPass.getPassword()), userType);
                    loginFrame.setVisible(true);
                }
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
