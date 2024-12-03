/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Zeyad
 */
public class ChangePasswordPanel_P extends javax.swing.JPanel {

    /**
     * Creates new form ChangeAdminPasswordp
     */
    public ChangePasswordPanel_P() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        ChangePagetitle = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        ComfirmButton = new javax.swing.JButton();
        OldPasswordField = new javax.swing.JTextField();
        WrongOldPassword = new javax.swing.JLabel();
        OldPassword = new javax.swing.JLabel();
        PasswordReq = new javax.swing.JLabel();
        MatchingNewPasswordField = new javax.swing.JTextField();
        NewPasswordField = new javax.swing.JTextField();
        NewPassword = new javax.swing.JLabel();
        ReNewPassword = new javax.swing.JLabel();
        WrongNewPassword = new javax.swing.JLabel();
        WrongMatching = new javax.swing.JLabel();
        Comfirmed = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        setBackground(new java.awt.Color(244, 242, 226));
        setForeground(new java.awt.Color(244, 242, 226));

        ChangePagetitle.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        ChangePagetitle.setForeground(new java.awt.Color(0, 0, 0));
        ChangePagetitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChangePagetitle.setText("Change Password Page");

        BackButton.setBackground(new java.awt.Color(0, 0, 0));
        BackButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeyad\\myproject\\TestApp\\TestGeneratorSystem\\lib\\turnback-40.png")); // NOI18N
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });

        ComfirmButton.setBackground(new java.awt.Color(74, 25, 72));
        ComfirmButton.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        ComfirmButton.setText("Comfirm");
        ComfirmButton.setEnabled(false);
        ComfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComfirmButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ComfirmButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ComfirmButtonMouseExited(evt);
            }
        });
        ComfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComfirmButtonActionPerformed(evt);
            }
        });

        OldPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        OldPasswordField.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        OldPasswordField.setForeground(new java.awt.Color(0, 0, 0));
        OldPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 3, true));
        OldPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OldPasswordFieldKeyTyped(evt);
            }
        });

        WrongOldPassword.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        WrongOldPassword.setForeground(new java.awt.Color(255, 0, 0));
        WrongOldPassword.setText("Wrong Password. Please, try again");

        OldPassword.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        OldPassword.setForeground(new java.awt.Color(0, 0, 0));
        OldPassword.setText("Old Password");

        PasswordReq.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        PasswordReq.setForeground(new java.awt.Color(255, 153, 0));
        PasswordReq.setText("<html>\n<h3 style=\"color:Black;\">Password Requirements:</h3>\n      &nbsp; &nbsp;   - 12-20 characters long<br>\n       &nbsp; &nbsp;  - At least one uppercase letter<br>\n       &nbsp;  &nbsp; - At least one lowercase letter<br>\n        &nbsp; &nbsp; - At least one special character<br>\n        &nbsp; &nbsp; - At least one digit\n</html>");
        PasswordReq.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        MatchingNewPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        MatchingNewPasswordField.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        MatchingNewPasswordField.setForeground(new java.awt.Color(0, 0, 0));
        MatchingNewPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 3, true));
        MatchingNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MatchingNewPasswordFieldKeyTyped(evt);
            }
        });

        NewPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        NewPasswordField.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        NewPasswordField.setForeground(new java.awt.Color(0, 0, 0));
        NewPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 3, true));
        NewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NewPasswordFieldKeyTyped(evt);
            }
        });

        NewPassword.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        NewPassword.setForeground(new java.awt.Color(0, 0, 0));
        NewPassword.setText("New Password");

        ReNewPassword.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        ReNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        ReNewPassword.setText("Rewrite New Password");

        WrongNewPassword.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        WrongNewPassword.setForeground(new java.awt.Color(255, 0, 0));
        WrongNewPassword.setText("Wrong Password. Please follow the Required");

        WrongMatching.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        WrongMatching.setForeground(new java.awt.Color(255, 0, 0));
        WrongMatching.setText("The passwords do not match. Please check.");

        Comfirmed.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        Comfirmed.setForeground(new java.awt.Color(0, 170, 0));
        Comfirmed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Comfirmed.setText("Password Changed Successfully ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MatchingNewPasswordField)
                            .addComponent(NewPasswordField)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ComfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OldPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(WrongMatching))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(OldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(WrongOldPassword)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(ChangePagetitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(NewPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(WrongNewPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ReNewPassword))
                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordReq, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(Comfirmed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ChangePagetitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Comfirmed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WrongOldPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewPassword)
                .addGap(5, 5, 5)
                .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WrongNewPassword)
                .addGap(18, 18, 18)
                .addComponent(ReNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MatchingNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WrongMatching)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComfirmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComfirmButtonActionPerformed

    private void OldPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OldPasswordFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_OldPasswordFieldKeyTyped

    private void NewPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewPasswordFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NewPasswordFieldKeyTyped

    private void MatchingNewPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MatchingNewPasswordFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_MatchingNewPasswordFieldKeyTyped

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonMouseClicked

    private void ComfirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComfirmButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComfirmButtonMouseClicked

    private void ComfirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComfirmButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ComfirmButtonMouseEntered

    private void ComfirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComfirmButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ComfirmButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ChangePagetitle;
    private javax.swing.JButton ComfirmButton;
    private javax.swing.JLabel Comfirmed;
    private javax.swing.JTextField MatchingNewPasswordField;
    private javax.swing.JLabel NewPassword;
    private javax.swing.JTextField NewPasswordField;
    private javax.swing.JLabel OldPassword;
    private javax.swing.JTextField OldPasswordField;
    private javax.swing.JLabel PasswordReq;
    private javax.swing.JLabel ReNewPassword;
    private javax.swing.JLabel WrongMatching;
    private javax.swing.JLabel WrongNewPassword;
    private javax.swing.JLabel WrongOldPassword;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}