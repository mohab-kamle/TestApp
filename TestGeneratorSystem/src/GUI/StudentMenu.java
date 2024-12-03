/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class StudentMenu extends JPanel {

    public StudentMenu(CardLayout cardLayout, JPanel container) {
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 247)); // Background color

        JButton SignUpButton = new JButton("SignUp");
        JButton LoginButton = new JButton("Login");

        JButton resetButton = new JButton("Reset Password");

        JButton BackButton = new JButton("Back To Main Menu");
        SignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up clicked");
                cardLayout.show(container, "SignUp");
            }

        });
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login clicked");
                cardLayout.show(container, "Login");
            }

        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reset Password clicked");
                cardLayout.show(container, "ResetPanel");
            }

        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to Main Menu clicked");
                cardLayout.show(container, "Welcome");
            }

        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Padding between buttons

        // Add buttons to the panel
        add(SignUpButton, gbc);
        gbc.gridy++;
        add(LoginButton, gbc);
        gbc.gridy++;
        add(resetButton, gbc);
        gbc.gridy++;
        add(BackButton, gbc);

    }

}
