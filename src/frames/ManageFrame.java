package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageFrame extends JFrame {
    public ManageFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Manage Inventory");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the add items panel
        JPanel addPanel = new JPanel();
        JButton addButton = new JButton("Add Items");

        // Create the update quantity panel
        JPanel updatePanel = new JPanel();
        JButton updateButton = new JButton("Update Quantity");

        // Create the set expiration date panel
        JPanel expirationPanel = new JPanel();
        JButton expirationButton = new JButton("Set Expiration Date");

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        addPanel.add(addButton);
        updatePanel.add(updateButton);
        expirationPanel.add(expirationButton);
        backPanel.add(backButton);

        //TODO: Display the current inventory on the bottom of the window maybe?

        // Allow the Add Items button to open the Add Items page
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                AddFrame addFrame = new AddFrame(loginFrame);
                addFrame.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                UpdateFrame updateFrame = new UpdateFrame(loginFrame);
                updateFrame.setVisible(true);
            }
        });

        expirationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                ExpFrame expFrame = new ExpFrame(loginFrame);
                expFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Manage Inventory to Retailer
                setVisible(false);

                RetailerFrame retailerFrame = new RetailerFrame(loginFrame);
                retailerFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(addPanel);
        add(updatePanel);
        add(expirationPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
