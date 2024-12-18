package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static database.DBOperations.addFood;

public class AddFrame extends JFrame {
    public AddFrame(JFrame loginFrame, int userId) {

        // Create the frame for the login window.
        setTitle("Add Items");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: ");
        JTextField enterItemName = new JTextField(10);

        // Create the item quantity panel
        JPanel itemQuantityPanel = new JPanel();
        JLabel itemQuantityLabel = new JLabel("Item Quantity: "); //TODO: Verify that value entered is an integer
        JTextField enterItemQuantity = new JTextField(10);

        // Create the item expiration date panel
        JPanel itemExpPanel = new JPanel();
        JLabel itemExpLabel = new JLabel("Item Expiration Date: "); //TODO: Verify that value entered is a date
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
        itemQuantityPanel.add(itemQuantityLabel);
        itemQuantityPanel.add(enterItemQuantity);
        itemExpPanel.add(itemExpLabel);
        itemExpPanel.add(enterItemExp);
        submitPanel.add(submitButton);
        backPanel.add(backButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                int itemQuantity;

                Date expDate = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    itemQuantity = Integer.parseInt(enterItemQuantity.getText());
                } catch (NumberFormatException ex) {
                    // Handle the case where the input is not a valid integer
                    JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
                    return; // Exit if invalid
                }

                try {
                    String expDateString = enterItemExp.getText().trim();
                    expDate = new Date(dateFormat.parse(expDateString).getTime());
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }

                addFood(userId, enterItemName.toString(), itemQuantity, expDate);
                ManageFrame manageFrame = new ManageFrame(loginFrame, userId);
                manageFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Add Items to Manage Items
                setVisible(false);

                ManageFrame manageFrame = new ManageFrame(loginFrame, userId);
                manageFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(itemNamePanel);
        add(itemQuantityPanel);
        add(itemExpPanel);
        add(submitPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
