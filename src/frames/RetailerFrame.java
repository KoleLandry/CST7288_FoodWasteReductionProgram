package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetailerFrame extends JFrame {
    public RetailerFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Home");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the surplus panel
        JPanel surplusPanel = new JPanel();
        JButton surplusButton = new JButton("Manage Surplus Items");

        // Create the manage inventory panel
        JPanel managePanel = new JPanel();
        JButton manageButton = new JButton("Manage Inventory");

        // Create the back panel
        JPanel logoutPanel = new JPanel();
        JButton logoutButton = new JButton("Back");

        // Add all the details to the panels
        surplusPanel.add(surplusButton);
        managePanel.add(manageButton);
        logoutPanel.add(logoutButton);

        //TODO: Display the current inventory on the bottom of the window maybe?

        // Allow the Manage Inventory button to open the Manage Inventory page
        surplusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                SurplusFrame surplusFrame = new SurplusFrame(loginFrame);
                surplusFrame.setVisible(true);
            }
        });

        // Allow the Manage Inventory button to open the Manage Inventory page
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                ManageFrame manageFrame = new ManageFrame(loginFrame);
                manageFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Retailer to Login
                // TODO: Add code to logout the user
                setVisible(false);
                loginFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(surplusPanel);
        add(managePanel);
        add(logoutPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
