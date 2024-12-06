import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetailerFrame extends JFrame {
    public RetailerFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Home - [USER_NAME_HERE]");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the surplus panel
        JPanel surplusPanel = new JPanel();
        JButton surplusButton = new JButton("Manage Surplus Items");

        // Create the manage inventory panel
        JPanel managePanel = new JPanel();
        JButton manageButton = new JButton("Manage Inventory");

        // Add all the details to the panels
        surplusPanel.add(surplusButton);
        managePanel.add(manageButton);

        //TODO: Display the current inventory on the bottom of the window maybe?

        // Allow the Manage Inventory button to open the Manage Inventory page
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(false);

                ManageFrame manageFrame = new ManageFrame(loginFrame);
                manageFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(surplusPanel);
        add(managePanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
