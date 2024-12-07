/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Zeyad
 */
public class AdminDashboardMenuP extends javax.swing.JPanel {

    /**
     * Creates new form AdminDashboardMenuP
     */
    public AdminDashboardMenuP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        DeleteQuestion = new javax.swing.JButton();
        UpdateProfile = new javax.swing.JButton();
        RemoveAccount = new javax.swing.JButton();
        CreateCategory = new javax.swing.JButton();
        ModifyCategory = new javax.swing.JButton();
        AddQuestion = new javax.swing.JButton();
        DeleteCategory = new javax.swing.JButton();
        ViewProfile = new javax.swing.JButton();
        UpdateQuestion = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jTextPane1);

        setBackground(new java.awt.Color(244, 242, 226));
        setToolTipText("");
        setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        DeleteQuestion.setBackground(new java.awt.Color(74, 25, 72));
        DeleteQuestion.setForeground(new java.awt.Color(255, 250, 206));
        DeleteQuestion.setText("Delete Question");
        DeleteQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteQuestionMouseClicked(evt);
            }
        });

        UpdateProfile.setBackground(new java.awt.Color(74, 25, 72));
        UpdateProfile.setForeground(new java.awt.Color(255, 250, 206));
        UpdateProfile.setText("Update Profile");
        UpdateProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateProfileMouseClicked(evt);
            }
        });

        RemoveAccount.setBackground(new java.awt.Color(74, 25, 72));
        RemoveAccount.setForeground(new java.awt.Color(255, 250, 206));
        RemoveAccount.setText("Remove Account");
        RemoveAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveAccountMouseClicked(evt);
            }
        });

        CreateCategory.setBackground(new java.awt.Color(74, 25, 72));
        CreateCategory.setForeground(new java.awt.Color(255, 250, 206));
        CreateCategory.setText("Create Category");
        CreateCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateCategoryMouseClicked(evt);
            }
        });
        CreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCategoryActionPerformed(evt);
            }
        });

        ModifyCategory.setBackground(new java.awt.Color(74, 25, 72));
        ModifyCategory.setForeground(new java.awt.Color(255, 250, 206));
        ModifyCategory.setText("Modify Category");
        ModifyCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifyCategoryMouseClicked(evt);
            }
        });

        AddQuestion.setBackground(new java.awt.Color(74, 25, 72));
        AddQuestion.setForeground(new java.awt.Color(255, 250, 206));
        AddQuestion.setText("Add Question");
        AddQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddQuestionMouseClicked(evt);
            }
        });

        DeleteCategory.setBackground(new java.awt.Color(74, 25, 72));
        DeleteCategory.setForeground(new java.awt.Color(255, 250, 206));
        DeleteCategory.setText("Delete Category");
        DeleteCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteCategoryMouseClicked(evt);
            }
        });

        ViewProfile.setBackground(new java.awt.Color(74, 25, 72));
        ViewProfile.setForeground(new java.awt.Color(255, 250, 206));
        ViewProfile.setText("View Profile");
        ViewProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ViewProfile.setName(""); // NOI18N

        UpdateQuestion.setBackground(new java.awt.Color(74, 25, 72));
        UpdateQuestion.setForeground(new java.awt.Color(255, 250, 206));
        UpdateQuestion.setText("Update Question");
        UpdateQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateQuestionMouseClicked(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(0, 0, 0));
        Logout.setForeground(new java.awt.Color(255, 0, 0));
        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        ChangePassword.setBackground(new java.awt.Color(74, 25, 72));
        ChangePassword.setForeground(new java.awt.Color(255, 250, 206));
        ChangePassword.setText("Change Password");
        ChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePasswordMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModifyCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateProfile)
                    .addComponent(ViewProfile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModifyCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void CreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateCategoryActionPerformed

    private void UpdateProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateProfileMouseClicked

    private void ChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePasswordMouseClicked

    private void RemoveAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveAccountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveAccountMouseClicked

    private void CreateCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateCategoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateCategoryMouseClicked

    private void ModifyCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifyCategoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifyCategoryMouseClicked

    private void DeleteCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteCategoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteCategoryMouseClicked

    private void AddQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddQuestionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddQuestionMouseClicked

    private void UpdateQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateQuestionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateQuestionMouseClicked

    private void DeleteQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteQuestionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteQuestionMouseClicked

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddQuestion;
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton CreateCategory;
    private javax.swing.JButton DeleteCategory;
    private javax.swing.JButton DeleteQuestion;
    private javax.swing.JButton Logout;
    private javax.swing.JButton ModifyCategory;
    private javax.swing.JButton RemoveAccount;
    private javax.swing.JButton UpdateProfile;
    private javax.swing.JButton UpdateQuestion;
    private javax.swing.JButton ViewProfile;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
