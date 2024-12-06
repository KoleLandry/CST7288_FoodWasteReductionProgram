import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RateFrame extends JFrame {
    public RateFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Rate Retailers - [USER_NAME_HERE]");
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

        // Add all the details to the panels
        retailerNamePanel.add(retailerNameLabel);
        retailerNamePanel.add(enterRetailerName);
        ratePanel.add(rateLabel);
        ratePanel.add(enterRate);
        submitPanel.add(submitButton);

        // Submit item to the database and take user back to the manage items frame
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Add rating to database
            }
        });

        // Add the panels to the JFrame
        add(retailerNamePanel);
        add(ratePanel);
        add(submitButton);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
