import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsumerFrame extends JFrame {
    public ConsumerFrame(JFrame loginFrame) {

        //TODO: Display username in the title of the frame

        // Create the frame for the login window.
        setTitle("Home - [USER_NAME_HERE]");
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

        // Add all the details to the panels
        subscribePanel.add(subscribeButton);
        ratePanel.add(rateButton);
        purchasePanel.add(purchaseButton);

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

        // Add the panels to the JFrame
        add(subscribePanel);
        add(ratePanel);
        add(purchasePanel);

        setSize(800, 400); // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Make the window visible.
        setVisible(true);
    }
}
