import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscribeFrame extends JFrame {
    public SubscribeFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Subscribe to Alerts - [USER_NAME_HERE]");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //TODO: Add the ability to set alert options
        //TODO: Allow the user to choose retailers they will be alerted by

        // Create the back panel
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");

        // Add all the details to the panels
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
        add(backPanel);


        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
