package frames;

import database.DBOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExpFrame extends JFrame {
    public ExpFrame(JFrame loginFrame, int userId) {

        // Create the frame for the login window.
        setTitle("Set Expiration Dates");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: ");
        JTextField enterItemName = new JTextField(10);

        // Create the item expiration date panel
        JPanel itemExpPanel = new JPanel();
        JLabel itemExpLabel = new JLabel("Item Expiration Date: ");
        JTextField enterItemExp = new JTextField(10);

        // Create the submit panel
        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        itemNamePanel.add(itemNameLabel);
        itemNamePanel.add(enterItemName);
        itemExpPanel.add(itemExpLabel);
        itemExpPanel.add(enterItemExp);
        submitPanel.add(submitButton);
        backPanel.add(backButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                // get the itemId
                int itemId = DBOperations.getItemId(enterItemName.getText().trim());
                Date expDate = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


                try {
                    String expDateString = enterItemExp.getText().trim();
                    expDate = new Date(dateFormat.parse(expDateString).getTime());
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }

                DBOperations.updateExpDate(itemId, expDate);

                ManageFrame manageFrame = new ManageFrame(loginFrame, userId);
                manageFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Set Expiration Dates to Manage Inventory
                setVisible(false);

                ManageFrame manageFrame = new ManageFrame(loginFrame, userId);
                manageFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(itemNamePanel);
        add(itemExpPanel);
        add(submitPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
