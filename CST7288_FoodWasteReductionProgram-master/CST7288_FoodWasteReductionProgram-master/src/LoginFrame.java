import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        // Create the frame for the login window
        setTitle("Food Waste Reduction Platform - Login");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

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

        // Add Register button functionality
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame

                // Open the RegisterFrame
                RegisterFrame registerFrame = new RegisterFrame(LoginFrame.this);
                registerFrame.setVisible(true);
            }
        });

        // Add Login button functionality
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame

                // Mock token for demonstration (replace with actual logic)
                String token = "exampleToken";

                // Open the RetailerFrame
                RetailerFrame retailerFrame = new RetailerFrame(LoginFrame.this, token);
                retailerFrame.setVisible(true);
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
        add(emailPanel);
        add(passPanel);
        add(loginPanel);
        add(registerPanel);

        // Frame settings
        setSize(800, 400); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application on close
        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
