package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RateFrame extends JFrame {
    public RateFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Rate Retailers");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the retailer name panel
        JPanel retailerNamePanel = new JPanel();
        JLabel retailerNameLabel = new JLabel("Retailer Name: "); //TODO: Verify that the retailer exists
        JTextField enterRetailerName = new JTextField(10);

        // Create the rate panel
        JPanel ratePanel = new JPanel();
        JLabel rateLabel = new JLabel("Rating: "); //TODO: Verify that the rating is between 1 and 5
        JTextField enterRate = new JTextField(10);

        // Create the submit panel
        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        retailerNamePanel.add(retailerNameLabel);
        retailerNamePanel.add(enterRetailerName);
        ratePanel.add(rateLabel);
        ratePanel.add(enterRate);
        submitPanel.add(submitButton);
        backPanel.add(backButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Add rating to database
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Rate Retailers to Consumer/Char Organization
                setVisible(false);

                //TODO: If user == consumer:
                ConsumerFrame consumerFrame = new ConsumerFrame(loginFrame);
                consumerFrame.setVisible(true);
                //TODO: Else if user == charOrganization:
                //frames.CharOrganizationFrame charOrganizationFrame = new frames.CharOrganizationFrame(loginFrame);
                //charOrganizationFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(retailerNamePanel);
        add(ratePanel);
        add(submitPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
