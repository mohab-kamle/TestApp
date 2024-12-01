package GUI;

import java.awt.*;
import javax.swing.*;

public class TestAPP extends javax.swing.JFrame {
    private static final Color BACKGROUND_COLOR = new Color(245, 245, 247);
    private CardLayout cardLayout;
    private JPanel container;

    public TestAPP() {
        // Set up the frame first
        setTitle("Test Generator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make it fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Set the layout to BorderLayout for proper component arrangement
        setLayout(new BorderLayout());
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Customize global component properties
            UIManager.put("TextField.background", Color.WHITE);
            UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 18));
            UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 18));
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 18));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize CardLayout and container
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);
        container.setBackground(BACKGROUND_COLOR);

        // Add container to the frame
        add(container, BorderLayout.CENTER);

        // Set up the panels
        setupPanels();
    }

    private void setupPanels() {
        StudentMenu studentMenu = new StudentMenu(cardLayout, container);
        WelcomePage welcomePage = new WelcomePage(cardLayout, container);
        SignUpPanel signUpPanel = new SignUpPanel(cardLayout, container);
        // Create and set up Sign Up Panel
        //JPanel signUpPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for better component arrangement
        signUpPanel.setBackground(BACKGROUND_COLOR);
        
        JLabel signUpLabel = new JLabel("Sign Up Page");
        signUpLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        JButton goToProfileButton = new JButton("Go to Profile");
        
        // Add components with some vertical spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0); // Add some padding
        signUpPanel.add(signUpLabel, gbc);
        
        gbc.gridy = 1;
        signUpPanel.add(goToProfileButton, gbc);

        // Create and set up Profile Panel
        JPanel profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setBackground(BACKGROUND_COLOR);
        
        JLabel profileLabel = new JLabel("Profile Page");
        profileLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        JButton goToSignUpButton = new JButton("Go to Sign Up");
        
        // Add components with same layout constraints
        gbc.gridy = 0;
        profilePanel.add(profileLabel, gbc);
        
        gbc.gridy = 1;
        profilePanel.add(goToSignUpButton, gbc);

        // Add panels to the container
        container.add(welcomePage, "Welcome");
        container.add(studentMenu, "StudentMenu");
        container.add(signUpPanel, "SignUp");
        container.add(profilePanel, "Profile");
        

        // Add action listeners
        goToProfileButton.addActionListener(e -> cardLayout.show(container, "Profile"));
        goToSignUpButton.addActionListener(e -> cardLayout.show(container, "SignUp"));

        // Show initial panel
        cardLayout.show(container, "Welcome");
        
        
        
        
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            TestAPP app = new TestAPP();
            app.setVisible(true);
        });
    }
}