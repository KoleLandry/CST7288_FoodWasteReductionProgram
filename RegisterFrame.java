import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {
    public RegisterFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Food Waste Reduction Platform - Register");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the email panel
        JPanel emailPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField enterEmail = new JTextField(10);

        // Create the password panel
        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("Password: ");
        JPasswordField enterPass = new JPasswordField(10);

        // Create the register panel
        JPanel registerPanel = new JPanel();
        JButton registerButton = new JButton("Register");

        // Add all the details to the panels
        emailPanel.add(emailLabel);
        emailPanel.add(enterEmail);
        passPanel.add(passLabel);
        passPanel.add(enterPass);
        registerPanel.add(registerButton);

        // The ability to choose which type of user you are
        // Create the user type panel
        JPanel userTypePanel = new JPanel();
        JLabel userTypeLabel = new JLabel("User Type: ");
        String[] userTypes = {"Admin", "Regular User"}; // Options for user types
        JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);

        // Add the label and combo box to the panel
        userTypePanel.add(userTypeLabel);
        userTypePanel.add(userTypeComboBox);


        // Add the panels to the JFrame
        add(emailPanel);
        add(passPanel);
        add(registerPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
