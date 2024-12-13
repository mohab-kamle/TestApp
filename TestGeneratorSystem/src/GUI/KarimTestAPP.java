package GUI;

import DataBaseManagment.AdminDAO;
import java.awt.*;
import javax.swing.*;


public class KarimTestAPP extends javax.swing.JFrame {
    private static final Color BACKGROUND_COLOR = new Color(244, 242, 226);
    private CardLayout cardLayout;
    private JPanel container;

    public KarimTestAPP() {
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
        SignUpPanell signUpPanel = new SignUpPanell(cardLayout, container);
        LoginPanel LoginPanel = new LoginPanel(cardLayout, container);
        ResetPasswordPanel resetPasswordPanel = new ResetPasswordPanel(cardLayout,container);
        // Create and set up Sign Up Panel

        // Add panels to the container
        container.add(welcomePanel, "Welcome");
        container.add(MenuPanel, "MenuPanel");
        container.add(signUpPanel, "SignUp");
        container.add(LoginPanel, "Login");
        container.add(resetPasswordPanel, "ResetPass");
//        container.add(profilePanel, "Profile");
        

        // Add action listeners

        // Show initial panel
        //cardLayout.show(container, "Welcome");    
        
       
        
//        ModifyCategoryPanel1 modifyCategoryPanel1 = new ModifyCategoryPanel1(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(modifyCategoryPanel1, "modifyCategory1");
//        cardLayout.show(container, "modifyCategory1");  
        
        
//        CreateCategoryPanel createCategoryPanel = new CreateCategoryPanel(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(createCategoryPanel, "createCategory");
//        cardLayout.show(container, "createCategory");          
        

//        DeleteCategoryPanel deleteCategoryPanel = new DeleteCategoryPanel(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(deleteCategoryPanel, "deleteCategory");
//        cardLayout.show(container, "deleteCategory");    


//        DeleteQuestionPanel1 deleteQuestionPanel1 = new DeleteQuestionPanel1(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(deleteQuestionPanel1, "deleteQuestion1");
//        cardLayout.show(container, "deleteQuestion1"); 
        

//        AddQuestionPanel1 addQuestionPanel1 = new AddQuestionPanel1(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(addQuestionPanel1, "addQuestion1");
//        cardLayout.show(container, "addQuestion1");  


//        UpdateQuestionPanel1 updateQuestionPanel1 = new UpdateQuestionPanel1(cardLayout,container,new AdminDAO().searchAdmin("SomeOne","123456789@MMm"));
//        container.add(updateQuestionPanel1, "updateQuestion1");
//        cardLayout.show(container, "updateQuestion1");  
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            KarimTestAPP app = new KarimTestAPP();
            app.setVisible(true);
        });
    }
}