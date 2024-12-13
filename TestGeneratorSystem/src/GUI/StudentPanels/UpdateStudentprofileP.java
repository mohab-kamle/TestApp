/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StudentPanels;

import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;

/**
 *
 * @author Zeyad
 */
public class UpdateStudentprofileP extends javax.swing.JPanel {

    /**
     * Creates new form UpdateStudentprofileP
     */
    public UpdateStudentprofileP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        UpdateStudentprofile = new javax.swing.JLabel();
        UpdateUsername = new javax.swing.JButton();
        UpdateEmail = new javax.swing.JButton();
        UpdateName = new javax.swing.JButton();
        UpdateAddress = new javax.swing.JButton();
        UpdateInstitute = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 242, 226));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setLayout(new java.awt.GridBagLayout());

        UpdateStudentprofile.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        UpdateStudentprofile.setForeground(new java.awt.Color(0, 0, 0));
        UpdateStudentprofile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateStudentprofile.setText("Update Profile");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateStudentprofile, gridBagConstraints);

        UpdateUsername.setBackground(new java.awt.Color(74, 25, 72));
        UpdateUsername.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateUsername.setForeground(new java.awt.Color(244, 242, 226));
        UpdateUsername.setText("Update Username");
        UpdateUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateUsername.setFocusPainted(false);
        UpdateUsername.setPreferredSize(new java.awt.Dimension(145, 60));
        UpdateUsername.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateUsernameMouseMoved(evt);
            }
        });
        UpdateUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateUsernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateUsernameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateUsernameMousePressed(evt);
            }
        });
        UpdateUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUsernameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = -28;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateUsername, gridBagConstraints);

        UpdateEmail.setBackground(new java.awt.Color(74, 25, 72));
        UpdateEmail.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateEmail.setForeground(new java.awt.Color(244, 242, 226));
        UpdateEmail.setText("Update Email");
        UpdateEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateEmail.setFocusPainted(false);
        UpdateEmail.setPreferredSize(new java.awt.Dimension(145, 60));
        UpdateEmail.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateEmailMouseMoved(evt);
            }
        });
        UpdateEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateEmailMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateEmailMousePressed(evt);
            }
        });
        UpdateEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = -28;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateEmail, gridBagConstraints);

        UpdateName.setBackground(new java.awt.Color(74, 25, 72));
        UpdateName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateName.setForeground(new java.awt.Color(244, 242, 226));
        UpdateName.setText("Update Name");
        UpdateName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateName.setFocusPainted(false);
        UpdateName.setPreferredSize(new java.awt.Dimension(145, 60));
        UpdateName.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateNameMouseMoved(evt);
            }
        });
        UpdateName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateNameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateNameMousePressed(evt);
            }
        });
        UpdateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = -28;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateName, gridBagConstraints);

        UpdateAddress.setBackground(new java.awt.Color(74, 25, 72));
        UpdateAddress.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateAddress.setForeground(new java.awt.Color(244, 242, 226));
        UpdateAddress.setText("Update Address");
        UpdateAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateAddress.setFocusPainted(false);
        UpdateAddress.setPreferredSize(new java.awt.Dimension(145, 60));
        UpdateAddress.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateAddressMouseMoved(evt);
            }
        });
        UpdateAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateAddressMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateAddressMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateAddressMousePressed(evt);
            }
        });
        UpdateAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAddressActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = -28;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateAddress, gridBagConstraints);

        UpdateInstitute.setBackground(new java.awt.Color(74, 25, 72));
        UpdateInstitute.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateInstitute.setForeground(new java.awt.Color(244, 242, 226));
        UpdateInstitute.setText("Update Institute");
        UpdateInstitute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateInstitute.setFocusPainted(false);
        UpdateInstitute.setPreferredSize(new java.awt.Dimension(145, 60));
        UpdateInstitute.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateInstituteMouseMoved(evt);
            }
        });
        UpdateInstitute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateInstituteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateInstituteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateInstituteMousePressed(evt);
            }
        });
        UpdateInstitute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInstituteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = -28;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateInstitute, gridBagConstraints);

        BackButton.setBackground(new java.awt.Color(74, 25, 72));
        BackButton.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        BackButton.setToolTipText("Click to go back");
        BackButton.setBorderPainted(false);
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.setFocusPainted(false);
        BackButton.setFocusable(false);
        BackButton.setMaximumSize(new java.awt.Dimension(145, 60));
        BackButton.setMinimumSize(new java.awt.Dimension(145, 60));
        BackButton.setPreferredSize(new java.awt.Dimension(145, 60));
        BackButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BackButtonFocusGained(evt);
            }
        });
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackButtonMouseExited(evt);
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(BackButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateUsernameMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateUsernameMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateUsernameMouseMoved

    private void UpdateUsernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateUsernameMouseEntered
        // TODO add your handling code here:
        UpdateUsername.setBackground(Color.decode("#F4F2E2"));
        UpdateUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        UpdateUsername.setBorderPainted(true);
        UpdateUsername.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateUsernameMouseEntered

    private void UpdateUsernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateUsernameMouseExited
        // TODO add your handling code here:
        UpdateUsername.setBackground(Color.decode("#4A1948"));
        UpdateUsername.setBorderPainted(false);
        UpdateUsername.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_UpdateUsernameMouseExited

    private void UpdateUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateUsernameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateUsernameMousePressed

    private void UpdateUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUsernameActionPerformed
        
    }//GEN-LAST:event_UpdateUsernameActionPerformed

    private void UpdateEmailMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEmailMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailMouseMoved

    private void UpdateEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEmailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailMouseEntered

    private void UpdateEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEmailMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailMouseExited

    private void UpdateEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEmailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailMousePressed

    private void UpdateEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateEmailActionPerformed

    private void UpdateNameMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNameMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameMouseMoved

    private void UpdateNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameMouseEntered

    private void UpdateNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameMouseExited

    private void UpdateNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameMousePressed

    private void UpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNameActionPerformed

    private void UpdateAddressMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAddressMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateAddressMouseMoved

    private void UpdateAddressMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAddressMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateAddressMouseEntered

    private void UpdateAddressMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAddressMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateAddressMouseExited

    private void UpdateAddressMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAddressMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateAddressMousePressed

    private void UpdateAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateAddressActionPerformed

    private void UpdateInstituteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateInstituteMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateInstituteMouseMoved

    private void UpdateInstituteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateInstituteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateInstituteMouseEntered

    private void UpdateInstituteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateInstituteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateInstituteMouseExited

    private void UpdateInstituteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateInstituteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateInstituteMousePressed

    private void UpdateInstituteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInstituteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateInstituteActionPerformed

    private void BackButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BackButtonFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonFocusGained

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
        /*jLabel4.setVisible(false);
        cardLayout.show(container, "StudentMenu");*/
    }//GEN-LAST:event_BackButtonMouseClicked

    private void BackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseEntered
        // TODO add your handling code here:
        URL iconURL = getClass().getResource("/lib/turn-back.png");
        if (iconURL != null) {
            BackButton.setIcon(new javax.swing.ImageIcon(iconURL));
        } else {
            // Handle the error, e.g., log it or show a default icon
            System.err.println("Resource not found: /lib/turn-back.png");
        }
        BackButton.setBackground(Color.decode("#F4F2E2"));
        BackButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        BackButton.setBorderPainted(true);
    }//GEN-LAST:event_BackButtonMouseEntered

    private void BackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseExited
        // TODO add your handling code here:
        URL iconURL = getClass().getResource("/lib/turnback-40.png");
        if (iconURL != null) {
            BackButton.setIcon(new javax.swing.ImageIcon(iconURL));
        } else {
            // Handle the error, e.g., log it or show a default icon
            System.err.println("Resource not found: /lib/turnback-40.png");
        }
        BackButton.setBackground(Color.decode("#4A1948"));
        BackButton.setBorderPainted(false);
        BackButton.setForeground(Color.decode("#F4F2E2"));

    }//GEN-LAST:event_BackButtonMouseExited

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton UpdateAddress;
    private javax.swing.JButton UpdateEmail;
    private javax.swing.JButton UpdateInstitute;
    private javax.swing.JButton UpdateName;
    private javax.swing.JLabel UpdateStudentprofile;
    private javax.swing.JButton UpdateUsername;
    // End of variables declaration//GEN-END:variables
}
