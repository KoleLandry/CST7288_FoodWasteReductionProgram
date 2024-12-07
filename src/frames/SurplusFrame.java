package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurplusFrame extends JFrame {
    public SurplusFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Manage Surplus Items");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the surplus items panel
        JPanel surplusPanel = new JPanel();
        JLabel surplusTitleLabel = new JLabel("Surplus Items: ");
        JLabel surplusItemsLabel = new JLabel(); //TODO: List array of surplus items here

        // Create the title panel
        JPanel listPanel = new JPanel();
        JLabel listTitleLabel = new JLabel("List for donation or sale: ");

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: ");
        JTextField enterItemName = new JTextField(10); //TODO: Verify that item exists, and that it is in surplus

        //TODO: Add ability to choose to set for donation or sale
        //TODO: Add ability to set price if for sale

        // Create the submit panel
        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        surplusPanel.add(surplusTitleLabel);
        surplusPanel.add(surplusItemsLabel);
        listPanel.add(listTitleLabel);
        itemNamePanel.add(itemNameLabel);
        itemNamePanel.add(enterItemName);
        submitPanel.add(submitButton);
        backPanel.add(backButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                //TODO: Add logic to modify item in the database

                ManageFrame manageFrame = new ManageFrame(loginFrame);
                manageFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Purchase Items to Consumer
                setVisible(false);

                RetailerFrame retailerFrame = new RetailerFrame(loginFrame);
                retailerFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(surplusPanel);
        add(listPanel);
        add(itemNamePanel);
        add(submitPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
