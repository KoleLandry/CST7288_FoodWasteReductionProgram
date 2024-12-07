import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetailerFrame extends JFrame {
    private String token;

    public RetailerFrame(JFrame parentFrame, String token) {
        this.token = token;

        // Set up the RetailerFrame
        setTitle("Retailer Dashboard");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add UI components
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the Retailer Dashboard");
        JButton backButton = new JButton("Back");

        panel.add(label);
        panel.add(backButton);

        add(panel);

        // Add back button functionality
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parentFrame.setVisible(true);
            }
        });

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
