package frames;

import database.DBOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RateFrame extends JFrame {
    public RateFrame(JFrame loginFrame, int userId) {

        // Create the frame for the login window.
        setTitle("Rate Retailers");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the retailer name panel
        JPanel retailerNamePanel = new JPanel();
        JLabel retailerNameLabel = new JLabel("Retailer Name: ");
        JTextField enterRetailerName = new JTextField(10);

        // Create the rate panel
        JPanel ratePanel = new JPanel();
        JLabel rateLabel = new JLabel("Rating: ");
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
                // Sends the user from Rate Retailers to Consumer/Char Organization
                String retailerName = enterRetailerName.getText().trim();
                String ratingStr = enterRate.getText().trim();

                boolean retailerIsGood = true;
                boolean ratingIsGood = true;

                List<String> allRetailers = DBOperations.getRetailers();
                if (!allRetailers.contains(retailerName)) {
                    JOptionPane.showMessageDialog(RateFrame.this, "Retailer does not exist. Please enter a real retailer.");
                    retailerIsGood = false;
                    return;
                }

                int rating;

                try {
                    rating = Integer.parseInt(ratingStr);
                    if (rating < 1 || rating > 5) {
                        ratingIsGood = false;
                    }
                } catch (NumberFormatException ex) {
                    ratingIsGood = false;
                }

                if (retailerIsGood && ratingIsGood) {
                    setVisible(false);

                    String userType = DBOperations.getUserType(userId);

                    if ("consumer".equalsIgnoreCase(userType)) {
                        ConsumerFrame consumerFrame = new ConsumerFrame(loginFrame, userId);
                        consumerFrame.setVisible(true);
                    } else if ("charitable organization".equalsIgnoreCase(userType)) {
                        CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame, userId);
                        charOrganizationFrame.setVisible(true);
                    }
                }
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Rate Retailers to Consumer/Char Organization
                setVisible(false);

                String userType = DBOperations.getUserType(userId);

                if ("consumer".equalsIgnoreCase(userType)) {
                    ConsumerFrame consumerFrame = new ConsumerFrame(loginFrame, userId);
                    consumerFrame.setVisible(true);
                } else if ("charitable organization".equalsIgnoreCase(userType)) {
                    CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame, userId);
                    charOrganizationFrame.setVisible(true);
                }
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
