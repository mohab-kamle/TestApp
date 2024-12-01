/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Dell
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpPanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel container;

    public SignUpPanel(CardLayout cardLayout, JPanel container) {
        this.cardLayout = cardLayout;
        this.container = container;

        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 247)); // Background color

        // Create components for the Sign-Up form
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);

        JButton signUpButton = new JButton("Sign Up");
        JButton cancelButton = new JButton("Cancel");

        // Action listeners
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call sign up logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();

                // Perform sign-up logic (you would call your backend logic here)
                System.out.println("Sign Up clicked with Username: " + username + ", Email: " + email);
                // For example, you could call a method like Admin.signUp(username, password, email);

                // After successful sign-up, navigate back to the main menu or another panel
                cardLayout.show(container, "Welcome");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the main menu
                cardLayout.show(container, "Welcome");
            }
        });

        // Layout for components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Padding between components

        // Add components to the panel
        add(titleLabel, gbc);
        gbc.gridy++;
        add(usernameLabel, gbc);
        gbc.gridy++;
        add(usernameField, gbc);
        gbc.gridy++;
        add(passwordLabel, gbc);
        gbc.gridy++;
        add(passwordField, gbc);
        gbc.gridy++;
        add(emailLabel, gbc);
        gbc.gridy++;
        add(emailField, gbc);
        gbc.gridy++;
        add(signUpButton, gbc);
        gbc.gridy++;
        add(cancelButton, gbc);
    }
}
