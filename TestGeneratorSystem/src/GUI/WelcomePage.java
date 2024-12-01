package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage extends JPanel {

    public WelcomePage(CardLayout cardLayout, JPanel container) {
        // Set up the layout for the panel
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 247)); // Background color

        // Create buttons for Student Portal and Admin Portal
        JButton studentPortalButton = new JButton("Student Portal");
        JButton adminPortalButton = new JButton("Admin Portal");

        // Action listener for Student Portal Button
        studentPortalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student Portal clicked");
                cardLayout.show(container, "StudentMenu");
            }
        });

        // Action listener for Admin Portal Button
        adminPortalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(container, "AdminMenu");
                System.out.println("Admin Portal clicked");

            }
        });

        // Set up GridBagConstraints for button positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0); // Padding between buttons

        // Add Student Portal Button
        add(studentPortalButton, gbc);

        // Move to the next row (vertical positioning)
        gbc.gridy = 1;

        // Add Admin Portal Button
        add(adminPortalButton, gbc);
    }
}
