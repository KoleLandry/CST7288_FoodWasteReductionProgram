import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseFrame extends JFrame {
    public PurchaseFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Purchase Items - [USER_NAME_HERE]");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: "); //TODO: Verify item exists
        JTextField enterItemName = new JTextField(10);

        // Create the item quantity panel
        JPanel itemQuantityPanel = new JPanel();
        JLabel itemQuantityLabel = new JLabel("Item Quantity: "); //TODO: Verify that value entered is an integer
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
                    return;
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

                    //TODO: Update item in the database

                    ManageFrame manageFrame = new ManageFrame(loginFrame);
                    manageFrame.setVisible(true);
                }
            }
        });

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Purchase Items to Consumer
                setVisible(false);

                PurchaseFrame purchaseFrame = new PurchaseFrame(loginFrame);
                purchaseFrame.setVisible(true);
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
