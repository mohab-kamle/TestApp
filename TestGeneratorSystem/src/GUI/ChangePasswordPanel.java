package GUI;

import EndUser.Admin;
import EndUser.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author mohab
 */
public class ChangePasswordPanel extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel container;
    private String verificationCode = "";
    private String EmailInput = "";
    private String newPass = "";
    private String confirmNewPass = "";

    /**
     * Creates new form ResetPasswordPanel
     */
    public ChangePasswordPanel(CardLayout cardLayout, JPanel container) {
        this.cardLayout = cardLayout;
        this.container = container;
        initComponents();
        PassChangeDontMatchLabel.setVisible(false);
        PassChangeWrongLabel.setVisible(false);
        PassChangeSuccessLabel.setVisible(false);
        GoToLoginPageBtn.setVisible(false);
    }

    public void setCodeEmailPassConfirm(String code, String email, String newpass, String confirmnewpass) {
        setEmailInput(email);
        setNewPass(newpass);
        setConfirmNewPass(confirmnewpass);
        setVerificationCode(code);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton3 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 32767));
        lengthLabel = new javax.swing.JLabel();
        PassChangeDontMatchLabel = new javax.swing.JLabel();
        PassChangeWrongLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jLabel4 = new javax.swing.JLabel();
        uppercaseLabel = new javax.swing.JLabel();
        lowercaseLabel = new javax.swing.JLabel();
        specialCharLabel = new javax.swing.JLabel();
        digitLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        PassChangeSuccessLabel = new javax.swing.JLabel();
        GoToLoginPageBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 250, 206));
        setMinimumSize(new java.awt.Dimension(860, 518));
        setLayout(new java.awt.GridBagLayout());

        jButton3.setBackground(new java.awt.Color(74, 25, 72));
        jButton3.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(244, 242, 226));
        jButton3.setText("Submit");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setPreferredSize(new java.awt.Dimension(200, 60));
        jButton3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton3MouseMoved(evt);
            }
        });
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(filler3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(filler5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        add(filler6, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(74, 25, 72));
        jButton1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/turnback-40.png"))); // NOI18N
        jButton1.setToolTipText("Click to go back");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(145, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(145, 60));
        jButton1.setPreferredSize(new java.awt.Dimension(145, 60));
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        add(jButton1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Change Password Page");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(60, 0, 0, 0);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        add(filler7, gridBagConstraints);

        lengthLabel.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lengthLabel.setForeground(new java.awt.Color(0, 0, 0));
        lengthLabel.setText("- 12-20 characters long");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(lengthLabel, gridBagConstraints);

        PassChangeDontMatchLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        PassChangeDontMatchLabel.setForeground(new java.awt.Color(204, 0, 0));
        PassChangeDontMatchLabel.setText("Passwords don't match , Please Try Again");
        PassChangeDontMatchLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(PassChangeDontMatchLabel, gridBagConstraints);

        PassChangeWrongLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        PassChangeWrongLabel.setForeground(new java.awt.Color(204, 0, 0));
        PassChangeWrongLabel.setText("Wrong Password , Please Follow the criteria");
        PassChangeWrongLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(PassChangeWrongLabel, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Confirm the password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        add(filler1, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("New password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 0, 0, 0);
        add(jLabel4, gridBagConstraints);

        uppercaseLabel.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        uppercaseLabel.setForeground(new java.awt.Color(0, 0, 0));
        uppercaseLabel.setText("- At least one uppercase letter ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(uppercaseLabel, gridBagConstraints);

        lowercaseLabel.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lowercaseLabel.setForeground(new java.awt.Color(0, 0, 0));
        lowercaseLabel.setText("- At least one lowercase letter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(lowercaseLabel, gridBagConstraints);

        specialCharLabel.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        specialCharLabel.setForeground(new java.awt.Color(0, 0, 0));
        specialCharLabel.setText("- At least one special character");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(specialCharLabel, gridBagConstraints);

        digitLabel.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        digitLabel.setForeground(new java.awt.Color(0, 0, 0));
        digitLabel.setText("- At least one digit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(digitLabel, gridBagConstraints);

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        jPasswordField1.setCaretColor(new java.awt.Color(0, 0, 0));
        jPasswordField1.setSelectionColor(new java.awt.Color(51, 0, 51));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 13, 0);
        add(jPasswordField1, gridBagConstraints);

        jPasswordField2.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        jPasswordField2.setCaretColor(new java.awt.Color(0, 0, 0));
        jPasswordField2.setSelectionColor(new java.awt.Color(51, 0, 51));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(jPasswordField2, gridBagConstraints);

        PassChangeSuccessLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        PassChangeSuccessLabel.setForeground(new java.awt.Color(0, 204, 0));
        PassChangeSuccessLabel.setText("Password Changed Successfully");
        PassChangeSuccessLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(PassChangeSuccessLabel, gridBagConstraints);

        GoToLoginPageBtn.setBackground(new java.awt.Color(74, 25, 72));
        GoToLoginPageBtn.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        GoToLoginPageBtn.setForeground(new java.awt.Color(244, 242, 226));
        GoToLoginPageBtn.setText("Login");
        GoToLoginPageBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GoToLoginPageBtn.setFocusPainted(false);
        GoToLoginPageBtn.setPreferredSize(new java.awt.Dimension(145, 60));
        GoToLoginPageBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                GoToLoginPageBtnMouseMoved(evt);
            }
        });
        GoToLoginPageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GoToLoginPageBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GoToLoginPageBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GoToLoginPageBtnMousePressed(evt);
            }
        });
        GoToLoginPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToLoginPageBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 227;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 0, 0, 0);
        add(GoToLoginPageBtn, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            newPass = new String(jPasswordField1.getPassword());
            confirmNewPass = new String(jPasswordField2.getPassword());
            if(new Admin().resetPassword(EmailInput, verificationCode, newPass, confirmNewPass)!=User.NewPass_ERROR){
                PassChangeWrongLabel.setVisible(false);
                if(new Admin().resetPassword(EmailInput, verificationCode, newPass, confirmNewPass)!=User.dontMatchPass_ERROR){
                    PassChangeDontMatchLabel.setVisible(false);
                    if(new Admin().resetPassword(EmailInput, verificationCode, newPass, confirmNewPass)==User.RESETPASS_SUCCESS){
                        PassChangeSuccessLabel.setVisible(true);
                        GoToLoginPageBtn.setVisible(true);
                    }else{
                        PassChangeSuccessLabel.setVisible(false);
                    }
                }else{
                    PassChangeDontMatchLabel.setVisible(true);
                }
            }else{
                PassChangeWrongLabel.setVisible(true);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(ChangePasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setBackground(Color.decode("#4A1948"));
        jButton3.setBorderPainted(false);
        jButton3.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setBackground(Color.decode("#F4F2E2"));
        jButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        jButton3.setBorderPainted(true);
        jButton3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseMoved

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        jLabel4.setVisible(false);
        cardLayout.show(container, "StudentMenu");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        URL iconURL = getClass().getResource("/lib/turn-back.png");
        if (iconURL != null) {
            jButton1.setIcon(new javax.swing.ImageIcon(iconURL));
        } else {
            // Handle the error, e.g., log it or show a default icon
            System.err.println("Resource not found: /lib/turn-back.png");
        }
        jButton1.setBackground(Color.decode("#F4F2E2"));
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        jButton1.setBorderPainted(true);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        URL iconURL = getClass().getResource("/lib/turnback-40.png");
        if (iconURL != null) {
            jButton1.setIcon(new javax.swing.ImageIcon(iconURL));
        } else {
            // Handle the error, e.g., log it or show a default icon
            System.err.println("Resource not found: /lib/turnback-40.png");
        }
        jButton1.setBackground(Color.decode("#4A1948"));
        jButton1.setBorderPainted(false);
        jButton1.setForeground(Color.decode("#F4F2E2"));

    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PassChangeDontMatchLabel.setVisible(false);
        PassChangeWrongLabel.setVisible(false);
        cardLayout.show(container, "ConfirmCode");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void GoToLoginPageBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLoginPageBtnMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_GoToLoginPageBtnMouseMoved

    private void GoToLoginPageBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLoginPageBtnMouseEntered
        // TODO add your handling code here:
        jButton3.setBackground(Color.decode("#F4F2E2"));
        jButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        jButton3.setBorderPainted(true);
        jButton3.setForeground(Color.BLACK);
    }//GEN-LAST:event_GoToLoginPageBtnMouseEntered

    private void GoToLoginPageBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLoginPageBtnMouseExited
        // TODO add your handling code here:
        jButton3.setBackground(Color.decode("#4A1948"));
        jButton3.setBorderPainted(false);
        jButton3.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_GoToLoginPageBtnMouseExited

    private void GoToLoginPageBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLoginPageBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoToLoginPageBtnMousePressed

    private void GoToLoginPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToLoginPageBtnActionPerformed
       cardLayout.show(container, "Login");
    }//GEN-LAST:event_GoToLoginPageBtnActionPerformed

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        // TODO add your handling code here:
        checkPasswordRequirements(new String(jPasswordField1.getPassword()));
    }//GEN-LAST:event_jPasswordField1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoToLoginPageBtn;
    private javax.swing.JLabel PassChangeDontMatchLabel;
    private javax.swing.JLabel PassChangeSuccessLabel;
    private javax.swing.JLabel PassChangeWrongLabel;
    private javax.swing.JLabel digitLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JLabel lowercaseLabel;
    private javax.swing.JLabel specialCharLabel;
    private javax.swing.JLabel uppercaseLabel;
    // End of variables declaration//GEN-END:variables
    public void checkPasswordRequirements(String password) {
        // Length check
        if (password.length() >= 12 && password.length() <= 20) {
            lengthLabel.setText("[√] Length is good");
            lengthLabel.setForeground(new Color(0, 150, 0));
        } else {
            lengthLabel.setText("[X] Must be 12-20 characters");
            lengthLabel.setForeground(Color.RED);
        }

        // Uppercase check
        if (password.matches(".*[A-Z].*")) {
            uppercaseLabel.setText("[√] Has uppercase");
            uppercaseLabel.setForeground(new Color(0, 150, 0));
        } else {
            uppercaseLabel.setText("[X] Need uppercase letter");
            uppercaseLabel.setForeground(Color.RED);
        }

        // Lowercase check
        if (password.matches(".*[a-z].*")) {
            lowercaseLabel.setText("[√] Has lowercase");
            lowercaseLabel.setForeground(new Color(0, 150, 0));
        } else {
            lowercaseLabel.setText("[X] Need lowercase letter");
            lowercaseLabel.setForeground(Color.RED);
        }

        // Special character check
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            specialCharLabel.setText("[√] Has special character");
            specialCharLabel.setForeground(new Color(0, 150, 0));
        } else {
            specialCharLabel.setText("[X] Need special character");
            specialCharLabel.setForeground(Color.RED);
        }

        // Digit check
        if (password.matches(".*\\d.*")) {
            digitLabel.setText("[√] Has number");
            digitLabel.setForeground(new Color(0, 150, 0));
        } else {
            digitLabel.setText("[X] Need a number");
            digitLabel.setForeground(Color.RED);
        }
    }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setEmailInput(String EmailInput) {
        this.EmailInput = EmailInput;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public void setConfirmNewPass(String confirmNewPass) {
        this.confirmNewPass = confirmNewPass;
    }
}
