/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.AdminPanels;

import DataBaseManagment.CategoryDAO;
import EndUser.Admin;
import EndUser.User;
import UserDefinedFunctionalities.Checker;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author karim mamdouh
 */
public class CreateCategoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateCategoryPanel
     */
    
    private CardLayout cardLayout;
    private JPanel container;
    private Admin admin;
    public CreateCategoryPanel(CardLayout cardLayout, JPanel container, Admin admin) {
        this.cardLayout = cardLayout;
        this.container = container;
        this.admin = admin;
        initComponents();
        categoryNameError.setVisible(false);
        categoryDescError.setVisible(false);
        createCategoryMsg.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryNameTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryDescTA = new javax.swing.JTextArea();
        createCategoryButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        categoryNameError = new javax.swing.JLabel();
        categoryDescError = new javax.swing.JLabel();
        createCategoryMsg = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 70), new java.awt.Dimension(0, 70), new java.awt.Dimension(32767, 70));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 120), new java.awt.Dimension(0, 120), new java.awt.Dimension(32767, 120));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));

        setBackground(new java.awt.Color(255, 250, 206));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(13870, 762));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(255, 250, 206));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Category Page");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        add(jLabel1, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(255, 250, 206));
        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Category Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel2, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(255, 250, 206));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Category Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        add(jLabel3, gridBagConstraints);

        categoryNameTF.setBackground(new java.awt.Color(255, 255, 255));
        categoryNameTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryNameTF.setForeground(new java.awt.Color(0, 0, 0));
        categoryNameTF.setText("");
        categoryNameTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 3, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 712;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(categoryNameTF, gridBagConstraints);

        categoryDescTA.setBackground(new java.awt.Color(255, 255, 255));
        categoryDescTA.setColumns(20);
        categoryDescTA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryDescTA.setForeground(new java.awt.Color(0, 0, 0));
        categoryDescTA.setRows(5);
        categoryDescTA.setText("");
        categoryDescTA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 3, true));
        categoryDescTA.setMinimumSize(new java.awt.Dimension(326, 131));
        jScrollPane1.setViewportView(categoryDescTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 139;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        add(jScrollPane1, gridBagConstraints);

        createCategoryButton.setBackground(new java.awt.Color(74, 25, 72));
        createCategoryButton.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        createCategoryButton.setForeground(new java.awt.Color(244, 242, 226));
        createCategoryButton.setText("Create Category");
        createCategoryButton.setBorderPainted(false);
        createCategoryButton.setFocusable(false);
        createCategoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createCategoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createCategoryButtonMouseExited(evt);
            }
        });
        createCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCategoryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(createCategoryButton, gridBagConstraints);

        backButton.setBackground(new java.awt.Color(74, 25, 72));
        backButton.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/turnback-40.png"))); // NOI18N
        backButton.setToolTipText("Click to go back");
        backButton.setBorderPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFocusable(false);
        backButton.setMaximumSize(new java.awt.Dimension(145, 60));
        backButton.setMinimumSize(new java.awt.Dimension(145, 60));
        backButton.setPreferredSize(new java.awt.Dimension(145, 60));
        backButton.setRequestFocusEnabled(false);
        backButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                backButtonFocusGained(evt);
            }
        });
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(backButton, gridBagConstraints);

        categoryNameError.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        categoryNameError.setForeground(new java.awt.Color(204, 0, 0));
        categoryNameError.setText("Error");
        categoryNameError.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 4);
        add(categoryNameError, gridBagConstraints);

        categoryDescError.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        categoryDescError.setForeground(new java.awt.Color(204, 0, 0));
        categoryDescError.setText("Error");
        categoryDescError.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 4);
        add(categoryDescError, gridBagConstraints);

        createCategoryMsg.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        createCategoryMsg.setForeground(new java.awt.Color(0, 204, 0));
        createCategoryMsg.setText("Category created successfully");
        createCategoryMsg.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(createCategoryMsg, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        add(filler4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(filler3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(filler5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(filler6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(filler7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        add(filler8, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backButtonFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonFocusGained

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        categoryNameError.setVisible(false);
        categoryDescError.setVisible(false);
        createCategoryMsg.setVisible(false);
        //cardLayout.show(container, "selectModifyCat");
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
                URL iconURL = getClass().getResource("/lib/turn-back.png");
        if (iconURL != null) {
            backButton.setIcon(new javax.swing.ImageIcon(iconURL));
        } else {
// Handle the error, e.g., log it or show a default icon 
            System.err.println("Resource not found: /lib/turn-back.png");
        }
        backButton.setBackground(Color.decode("#F4F2E2"));
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        backButton.setBorderPainted(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
            URL iconURL = getClass().getResource("/lib/turnback-40.png");
    if (iconURL != null) {
        backButton.setIcon(new javax.swing.ImageIcon(iconURL));
    } else {
        // Handle the error, e.g., log it or show a default icon
        System.err.println("Resource not found: /lib/turnback-40.png");
    }
    backButton.setBackground(Color.decode("#4A1948"));
    backButton.setBorderPainted(false);
    backButton.setForeground(Color.decode("#F4F2E2"));

    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        
        cardLayout.show(container, "adminDashboard");
    }//GEN-LAST:event_backButtonActionPerformed

    private void createCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCategoryButtonActionPerformed
        // TODO add your handling code here:
         Checker check = new Checker();
        CategoryDAO CDB = new CategoryDAO();
        String categoryName = categoryNameTF.getText().trim();
        String categoryDesc = categoryDescTA.getText().trim();
        boolean error = false;
        createCategoryMsg.setVisible(false);
        categoryNameError.setVisible(false);
        categoryDescError.setVisible(false);

        
         if(categoryName.isEmpty()){  // FIRST IF WAS COMMENTED OUT
            // => This Field is required
            categoryNameError.setText("This Field is required");
            categoryNameError.setVisible(true);
            error = true;
        } else if(!User.validateInput(check, categoryName, Checker.StringType.LETTERS_NUMS_UNDERSCORE)){
            categoryNameError.setText("Wrong name , try again");
            error = true;
        } else if(CDB.searchCategoryByName(categoryName) != null) {
            // => This category already exists
            categoryNameError.setText("This category already exists");
            categoryNameError.setVisible(true);
            error = true;
        }
        if(!User.validateInput(check,categoryDesc, Checker.StringType.LETTERS_NUMS_UNDERSCORE)){
            // => Invalid Characters Exist , try again
            categoryDescError.setText("Invalid Characters Exist , try again");
            categoryDescError.setVisible(true);
            error = true;
        }
        if(!error){
            if(new Admin().createCategory(CDB, categoryName, categoryDesc)){
                // => Category Created succesfully !!
                createCategoryMsg.setForeground(Color.green);
                createCategoryMsg.setText("Category Created succesfully");
                createCategoryMsg.setVisible(true);

            } else {
                // => Category couldn't be created
                createCategoryMsg.setForeground(Color.red);
                createCategoryMsg.setText("Category Created succesfully"); 
                createCategoryMsg.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_createCategoryButtonActionPerformed

    private void createCategoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createCategoryButtonMouseEntered
        // TODO add your handling code here:
        createCategoryButton.setBackground(Color.decode("#F4F2E2"));
        createCategoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        createCategoryButton.setBorderPainted(true);
        createCategoryButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_createCategoryButtonMouseEntered

    private void createCategoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createCategoryButtonMouseExited
        // TODO add your handling code here:
        createCategoryButton.setBackground(Color.decode("#4A1948"));
        createCategoryButton.setBorderPainted(false);
        createCategoryButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_createCategoryButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel categoryDescError;
    private javax.swing.JTextArea categoryDescTA;
    private javax.swing.JLabel categoryNameError;
    private javax.swing.JTextField categoryNameTF;
    private javax.swing.JButton createCategoryButton;
    private javax.swing.JLabel createCategoryMsg;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}