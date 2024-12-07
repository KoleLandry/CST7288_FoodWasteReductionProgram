import javax.swing.*;

public class ManageFrame extends JFrame {
    private final JFrame parentFrame;

    public ManageFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        // Frame setup
        setTitle("Manage Items");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Example UI components
        JLabel manageLabel = new JLabel("Manage Items Here");
        JButton backButton = new JButton("Back");

        // Navigate back to the parent frame
        backButton.addActionListener(e -> {
            setVisible(false);
            parentFrame.setVisible(true);
        });

        // Add components
        add(manageLabel);
        add(backButton);
        setVisible(true);
    }
}
