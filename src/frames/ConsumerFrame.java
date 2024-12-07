package frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsumerFrame extends JFrame {
    public ConsumerFrame(JFrame loginFrame) {

        // Create the frame for the login window.
        setTitle("Consumer Dashboard");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the subscribe panel
        JPanel subscribePanel = new JPanel();
        JButton subscribeButton = new JButton("Subscribe to Alerts");

        // Create the rate panel
        JPanel ratePanel = new JPanel();
        JButton rateButton = new JButton("Rate Retailer");

        // Create the claim panel
        JPanel purchasePanel = new JPanel();
        JButton purchaseButton = new JButton("Claim Food");

        // Create the back panel
        JPanel logoutPanel = new JPanel();
        JButton logoutButton = new JButton("Logout");

        // Add all the details to the panels
        subscribePanel.add(subscribeButton);
        ratePanel.add(rateButton);
        purchasePanel.add(purchaseButton);
        logoutPanel.add(logoutButton);

        // Allow the Subscribe button to open the Subscribe page
        subscribeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                SubscribeFrame subscribeFrame = new SubscribeFrame(loginFrame);
                subscribeFrame.setVisible(true);
            }
        });

        // Allow the Rate button to open the Rate page
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                RateFrame rateFrame = new RateFrame(loginFrame);
                rateFrame.setVisible(true);
            }
        });

        // Allow the Claim button to open the Claim page
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                PurchaseFrame purchaseFrame = new PurchaseFrame(loginFrame);
                purchaseFrame.setVisible(true);
            }
        });

        // Allows the back button to send the user to the previous page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sends the user from Consumer to Login
                // TODO: Add code to logout the user
                setVisible(false);
                loginFrame.setVisible(true);
            }
        });

        // Add the panels to the JFrame
        add(subscribePanel);
        add(ratePanel);
        add(purchasePanel);
        add(logoutPanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
