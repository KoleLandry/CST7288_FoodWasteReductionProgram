import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscribeFrame extends JFrame {
    public SubscribeFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Subscribe to Alerts");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the alert options panel
        JPanel alertPanel = new JPanel();
        JCheckBox notificationCheckBox = new JCheckBox("Notification");
        JCheckBox emailCheckBox = new JCheckBox("Email");
        JCheckBox textCheckBox = new JCheckBox("Text Message");

        // Create the retailer panel
        JPanel retailerPanel = new JPanel();
        JLabel retailerLabel = new JLabel("Retailer: "); //TODO: Verify that the Retailer exists
        JTextField enterRetailer = new JTextField(10);

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
        alertPanel.add(notificationCheckBox);
        alertPanel.add(emailCheckBox);
        alertPanel.add(textCheckBox);
        retailerPanel.add(retailerLabel);
        retailerPanel.add(enterRetailer);
        backPanel.add(backButton);

        // Allows the back button to send the user to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Subscribe to Alerts to Consumer/Char Organization
                setVisible(false);

                //TODO: If user == consumer:
                ConsumerFrame consumerFrame = new ConsumerFrame(loginFrame);
                consumerFrame.setVisible(true);
                //TODO: Else if user == charOrganization:
                //CharOrganizationFrame charOrganizationFrame = new CharOrganizationFrame(loginFrame);
                //charOrganizationFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(alertPanel);
        add(retailerPanel);
        add(backPanel);


        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
