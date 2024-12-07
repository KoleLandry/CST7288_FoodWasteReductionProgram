import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    public RegisterFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Food Waste Reduction Platform");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

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
                //TODO: Show error popup if multiple user types are selected
                //TODO: If all user input is valid, create the new user
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
