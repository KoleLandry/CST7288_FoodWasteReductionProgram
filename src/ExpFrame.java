import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpFrame extends JFrame {
    public ExpFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Set Expiration Dates - [USER_NAME_HERE]");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the item name panel
        JPanel itemNamePanel = new JPanel();
        JLabel itemNameLabel = new JLabel("Item Name: "); //TODO: Verify item exists
        JTextField enterItemName = new JTextField(10);

        // Create the item expiration date panel
        JPanel itemExpPanel = new JPanel();
        JLabel itemExpLabel = new JLabel("Item Expiration Date: "); //TODO: Verify that value entered is a date
        JTextField enterItemExp = new JTextField(10);

        // Create the submit panel
        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        // Add all the details to the panels
        itemNamePanel.add(itemNameLabel);
        itemNamePanel.add(enterItemName);
        itemExpPanel.add(itemExpLabel);
        itemExpPanel.add(enterItemExp);
        submitPanel.add(submitButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                //TODO: Update item in the database

                ManageFrame manageFrame = new ManageFrame(loginFrame);
                manageFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(itemNamePanel);
        add(itemExpPanel);
        add(submitPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
