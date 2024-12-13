package GUI;import DataBaseManagment.AdminDAO;
import java.awt.*;
import javax.swing.*;


public class TestAPP extends javax.swing.JFrame {
    private static final Color BACKGROUND_COLOR = new Color(244, 242, 226);
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
        
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Customize global component properties
            UIManager.put("TextField.background", Color.decode("#F4F2E2"));
            UIManager.put("TextField.font", new Font("Consolas", Font.PLAIN, 18));
            UIManager.put("Label.font", new Font("Consolas", Font.PLAIN, 18));
            UIManager.put("Button.font", new Font("Consolas", Font.BOLD, 18));


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
        
        MenuPanel MenuPanel = new MenuPanel(cardLayout, container);
        WelcomePanel welcomePanel = new WelcomePanel(cardLayout, container);
        
        LoginPanel LoginPanel = new LoginPanel(cardLayout, container);
        ResetPasswordPanel resetPasswordPanel = new ResetPasswordPanel(cardLayout,container);
        // Create and set up Sign Up Panel

        // Add panels to the container
        container.add(welcomePanel, "Welcome");
        container.add(MenuPanel, "MenuPanel");
        
        container.add(LoginPanel, "Login");
        container.add(resetPasswordPanel, "ResetPass");
//        container.add(profilePanel, "Profile");
//        StudentDashboardMenuP sd = new StudentDashboardMenuP(new Student(), cardLayout, container);
//        container.add(sd, "sd");
        // Add action listeners

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
