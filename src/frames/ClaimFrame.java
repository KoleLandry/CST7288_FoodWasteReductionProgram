package frames;

import database.DBOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaimFrame extends JFrame {
    public ClaimFrame(JFrame loginFrame, int userId) {

        // Create the frame for the login window.
        setTitle("Claim Items");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: ");
        JTextField enterItemName = new JTextField(10);

        // Create the item quantity panel
        JPanel itemQuantityPanel = new JPanel();
        JLabel itemQuantityLabel = new JLabel("Item Quantity: ");
        JTextField enterItemQuantity = new JTextField(10);

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
        submitPanel.add(submitButton);
        backPanel.add(backButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean itemNameGood = true;
                boolean itemQuantityGood = true;

                // Verify item exists
                if (enterItemName.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Item Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    itemNameGood = false;
                    return; // Stop further execution
                }

                // Verify that value entered is an integer
                try {
                    int quantity = Integer.parseInt(enterItemQuantity.getText().trim());
                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(null, "Quantity must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
                        itemQuantityGood = false;
                        return; // Stop further execution
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for quantity!", "Error", JOptionPane.ERROR_MESSAGE);
                    itemQuantityGood = false;
                    return; // Stop further execution
                }

                if (itemNameGood == true && itemQuantityGood == true) {
                    setVisible(false);

                    // get the itemId
                    int itemId = DBOperations.getItemId(enterItemName.getText().trim());

                    int quantity = Integer.parseInt(enterItemQuantity.getText().trim());
                    DBOperations.updateQuantity(itemId, quantity);

                    CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame, userId);
                    charOrganizationFrame.setVisible(true);
                }
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Claim Items to Charitable Organization
                setVisible(false);

                CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame, userId);
                charOrganizationFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(itemNamePanel);
        add(itemQuantityPanel);
        add(submitPanel);
        add(backPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
