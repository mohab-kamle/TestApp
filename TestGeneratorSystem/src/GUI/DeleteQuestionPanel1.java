/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.CategoryDAO;
import EndUser.Admin;
import TestSystem.Category;
import TestSystem.QuestionBank;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author karim mamdouh
 */
public class DeleteQuestionPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form DeleteCategoryPanel
     */
    private String[] categories;
    private CategoryDAO CDB;
    private CardLayout cardLayout;
    private JPanel container;
    private Admin admin;    
    
    public DeleteQuestionPanel1(CardLayout cardLayout, JPanel container, Admin admin) {
        this.cardLayout = cardLayout;
        this.container = container;
        this.admin = admin;
        CDB = new CategoryDAO();
        categories = new String[CDB.getCategoriesList().size()+1];
        categories[0] = "None";
        for(int i=1 ; i<categories.length ; ++i){
            categories[i] = CDB.getCategoriesList().get(i-1).getName();
        }
        
        initComponents();
        
        categoryError.setVisible(false);
    }
    public void setAdmin(Admin admin){this.admin = admin;}
    public Admin getAdmin() {return admin;}
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
        backButton = new javax.swing.JButton();
        categoryError = new javax.swing.JLabel();
        categoryList = new javax.swing.JComboBox<>(categories);
        jLabel3 = new javax.swing.JLabel();
        viewQuestionsButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 32767));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));

        setBackground(new java.awt.Color(255, 250, 206));
        setPreferredSize(new java.awt.Dimension(800, 700));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(255, 250, 206));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Delete Question Portal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        add(jLabel1, gridBagConstraints);

        backButton.setBackground(new java.awt.Color(74, 25, 72));
        backButton.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(backButton, gridBagConstraints);

        categoryError.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        categoryError.setForeground(new java.awt.Color(255, 0, 0));
        categoryError.setText("Wrong Password. Please, try again");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        add(categoryError, gridBagConstraints);

        categoryList.setBackground(new java.awt.Color(255, 255, 255));
        categoryList.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        categoryList.setForeground(new java.awt.Color(0, 0, 0));
        categoryList.setModel(new javax.swing.DefaultComboBoxModel<>(categories));
        categoryList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 5, true));
        categoryList.setRenderer(new javax.swing.DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Custom colors for selected and unselected items
                if (isSelected) {
                    label.setBackground(new java.awt.Color(74, 25, 72)); // Custom selected background
                    label.setForeground(java.awt.Color.WHITE); // Custom selected foreground
                } else {
                    label.setBackground(java.awt.Color.WHITE); // Default unselected background
                    label.setForeground(java.awt.Color.BLACK); // Default unselected foreground
                }

                return label;
            }
        }
    );
    categoryList.setRequestFocusEnabled(false);
    categoryList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryListActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.ipadx = 311;
    gridBagConstraints.ipady = 13;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    add(categoryList, gridBagConstraints);

    jLabel3.setBackground(new java.awt.Color(255, 250, 206));
    jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Select a Category");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    add(jLabel3, gridBagConstraints);

    viewQuestionsButton.setBackground(new java.awt.Color(74, 25, 72));
    viewQuestionsButton.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
    viewQuestionsButton.setForeground(new java.awt.Color(244, 242, 226));
    viewQuestionsButton.setText("View Questions");
    viewQuestionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            viewQuestionsButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            viewQuestionsButtonMouseExited(evt);
        }
    });
    viewQuestionsButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewQuestionsButtonActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.ipadx = 96;
    add(viewQuestionsButton, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    add(filler4, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 2;
    add(filler5, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 3;
    add(filler2, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    add(filler1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backButtonFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonFocusGained

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
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

    private void categoryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryListActionPerformed

    private void viewQuestionsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewQuestionsButtonMouseEntered
        // TODO add your handling code here:
        viewQuestionsButton.setBackground(Color.decode("#F4F2E2"));
        viewQuestionsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        viewQuestionsButton.setBorderPainted(true);
        viewQuestionsButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_viewQuestionsButtonMouseEntered

    private void viewQuestionsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewQuestionsButtonMouseExited
        // TODO add your handling code here:
        viewQuestionsButton.setBackground(Color.decode("#4A1948"));
        viewQuestionsButton.setBorderPainted(false);
        viewQuestionsButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_viewQuestionsButtonMouseExited

    private void viewQuestionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewQuestionsButtonActionPerformed
        // TODO add your handling code here:
        boolean errorFound = false;
        Category selectedCategory = admin.selectCategory(categoryList,  CDB,  categoryError);
        if (selectedCategory == null) {
                errorFound = true;
        }
        QuestionBank questionBank = admin.getQuestionBank(selectedCategory, admin.getUserId(), categoryError);
        if (questionBank == null || questionBank.getQuestions().isEmpty()) {
            errorFound = true;
        }
        if(!errorFound){
            categoryList.setSelectedIndex(0);
            String[] navList = new String[questionBank.getQuestions().size()];
            for(int i=0 ; i<navList.length ; ++i){
                navList[i] = "Question "+(i+1);
            }
            for(int i=0 ; i<questionBank.getQuestions().size() ; ++i){
                container.add(new DeleteQuestionPanel2(cardLayout,container,questionBank,admin,i,navList), "deleteQuestion2_Q"+(i+1));
            }

            cardLayout.show(container, "deleteQuestion2_Q1"); 
           }
    }//GEN-LAST:event_viewQuestionsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel categoryError;
    private javax.swing.JComboBox<String> categoryList;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton viewQuestionsButton;
    // End of variables declaration//GEN-END:variables
}
