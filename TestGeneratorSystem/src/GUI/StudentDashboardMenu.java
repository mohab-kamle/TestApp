/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Zeyad
 */
public class StudentDashboardMenu extends javax.swing.JPanel {

    /**
     * Creates new form StudentDashboardMenuP
     */
    public StudentDashboardMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        TakeTest = new javax.swing.JButton();
        ViewFavoriteQuestions = new javax.swing.JButton();
        ViewTestHistory = new javax.swing.JButton();
        UpdateProfile = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        RemoveAccount = new javax.swing.JButton();
        ViewProfile = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 242, 226));
        setPreferredSize(new java.awt.Dimension(555, 474));

        TakeTest.setBackground(new java.awt.Color(74, 25, 72));
        TakeTest.setForeground(new java.awt.Color(255, 250, 206));
        TakeTest.setText("Take test");
        TakeTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TakeTestMouseClicked(evt);
            }
        });
        TakeTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeTestActionPerformed(evt);
            }
        });

        ViewFavoriteQuestions.setBackground(new java.awt.Color(74, 25, 72));
        ViewFavoriteQuestions.setForeground(new java.awt.Color(255, 250, 206));
        ViewFavoriteQuestions.setText("View Favorite Questions");
        ViewFavoriteQuestions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewFavoriteQuestionsMouseClicked(evt);
            }
        });

        ViewTestHistory.setBackground(new java.awt.Color(74, 25, 72));
        ViewTestHistory.setForeground(new java.awt.Color(255, 250, 206));
        ViewTestHistory.setText("View Test History");
        ViewTestHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTestHistoryMouseClicked(evt);
            }
        });
        ViewTestHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewTestHistoryActionPerformed(evt);
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
        UpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProfileActionPerformed(evt);
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

        RemoveAccount.setBackground(new java.awt.Color(74, 25, 72));
        RemoveAccount.setForeground(new java.awt.Color(255, 250, 206));
        RemoveAccount.setText("Remove Account");
        RemoveAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveAccountMouseClicked(evt);
            }
        });

        ViewProfile.setBackground(new java.awt.Color(74, 25, 72));
        ViewProfile.setForeground(new java.awt.Color(255, 250, 206));
        ViewProfile.setText("View Profile");
        ViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewProfileMouseClicked(evt);
            }
        });
        ViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewProfileActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ViewFavoriteQuestions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewTestHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TakeTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UpdateProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(ViewProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TakeTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewTestHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewFavoriteQuestions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void UpdateProfileMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void UpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void ChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void RemoveAccountMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void ViewProfileMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void ViewProfileActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void TakeTestActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void ViewTestHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void ViewFavoriteQuestionsMouseClicked(java.awt.event.MouseEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void ViewTestHistoryMouseClicked(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void TakeTestMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    }                                     


    // Variables declaration - do not modify                     
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton Logout;
    private javax.swing.JButton RemoveAccount;
    private javax.swing.JButton TakeTest;
    private javax.swing.JButton UpdateProfile;
    private javax.swing.JButton ViewFavoriteQuestions;
    private javax.swing.JButton ViewProfile;
    private javax.swing.JButton ViewTestHistory;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
