package GUI.AdminPanels;

import EndUser.Admin;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Zeyad
 */
public class ViewProfilePanelAdminP extends javax.swing.JPanel {
    
    private CardLayout cardLayout;
    private JPanel container;
    protected Admin admin ;
    /**
     * Creates new form ViewProfilePanelP
     * @param admin
     * @param cardLayout
     * @param container
     */
    public ViewProfilePanelAdminP(Admin admin, CardLayout cardLayout, JPanel container) {
        initComponents();
        this.admin = admin;
        this.cardLayout = cardLayout;
        this.container = container;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        UsernameHolder.setText(admin.getUserName());
        EmailHolder.setText(admin.getEmail());
        FnameHolder.setText(admin.getFirstName());
        LnameHolder.setText(admin.getLastName());
        AddressHolder.setText(admin.getAddress());
        DepartHolder.setText(admin.getDepartment());
        ContNumHolder.setText(admin.getContactNumber());
        if (admin.getDateAppointed() == null) 
            JoinDHolder.setText("dd/MM/yyyy");
        else 
            JoinDHolder.setText(admin.getDateAppointed().format(formatter));
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        FirstName = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        ContactNumber = new javax.swing.JLabel();
        JoinDate = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        AdminProfLabel = new javax.swing.JLabel();
        UsernameHolder = new javax.swing.JLabel();
        EmailHolder = new javax.swing.JLabel();
        LnameHolder = new javax.swing.JLabel();
        FnameHolder = new javax.swing.JLabel();
        AddressHolder = new javax.swing.JLabel();
        DepartHolder = new javax.swing.JLabel();
        ContNumHolder = new javax.swing.JLabel();
        JoinDHolder = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 100), new java.awt.Dimension(150, 100), new java.awt.Dimension(150, 100));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 100), new java.awt.Dimension(150, 100), new java.awt.Dimension(150, 100));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("jLabel1");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("jLabel1");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("jLabel1");
        jLabel5.setOpaque(true);

        setBackground(new java.awt.Color(255, 250, 206));
        setForeground(new java.awt.Color(74, 25, 72));
        setAutoscrolls(true);
        setLayout(new java.awt.GridBagLayout());

        Username.setBackground(new java.awt.Color(74, 25, 72));
        Username.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Username.setForeground(new java.awt.Color(0, 0, 0));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Username.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 137;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Username, gridBagConstraints);

        Email.setBackground(new java.awt.Color(74, 25, 72));
        Email.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 0));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Email, gridBagConstraints);

        FirstName.setBackground(new java.awt.Color(74, 25, 72));
        FirstName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        FirstName.setForeground(new java.awt.Color(0, 0, 0));
        FirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FirstName.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FirstName, gridBagConstraints);

        LastName.setBackground(new java.awt.Color(74, 25, 72));
        LastName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        LastName.setForeground(new java.awt.Color(0, 0, 0));
        LastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LastName.setText("Last Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(LastName, gridBagConstraints);

        Department.setBackground(new java.awt.Color(74, 25, 72));
        Department.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Department.setForeground(new java.awt.Color(0, 0, 0));
        Department.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Department.setText("Department:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 123;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Department, gridBagConstraints);

        ContactNumber.setBackground(new java.awt.Color(74, 25, 72));
        ContactNumber.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        ContactNumber.setForeground(new java.awt.Color(0, 0, 0));
        ContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ContactNumber.setText("Contact Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(ContactNumber, gridBagConstraints);

        JoinDate.setBackground(new java.awt.Color(74, 25, 72));
        JoinDate.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        JoinDate.setForeground(new java.awt.Color(0, 0, 0));
        JoinDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JoinDate.setText("Join Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(JoinDate, gridBagConstraints);

        Address.setBackground(new java.awt.Color(74, 25, 72));
        Address.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Address.setForeground(new java.awt.Color(0, 0, 0));
        Address.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Address.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Address, gridBagConstraints);

        AdminProfLabel.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        AdminProfLabel.setForeground(new java.awt.Color(0, 0, 0));
        AdminProfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminProfLabel.setText("Admin Profile");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 370;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(AdminProfLabel, gridBagConstraints);

        UsernameHolder.setBackground(new java.awt.Color(255, 255, 255));
        UsernameHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        UsernameHolder.setForeground(new java.awt.Color(1, 1, 1));
        UsernameHolder.setText("\"HOLDER\"");
        UsernameHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UsernameHolder, gridBagConstraints);

        EmailHolder.setBackground(new java.awt.Color(255, 255, 255));
        EmailHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        EmailHolder.setForeground(new java.awt.Color(1, 1, 1));
        EmailHolder.setText("\"HOLDER\"");
        EmailHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(EmailHolder, gridBagConstraints);

        LnameHolder.setBackground(new java.awt.Color(255, 255, 255));
        LnameHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        LnameHolder.setForeground(new java.awt.Color(1, 1, 1));
        LnameHolder.setText("\"HOLDER\"");
        LnameHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(LnameHolder, gridBagConstraints);

        FnameHolder.setBackground(new java.awt.Color(255, 255, 255));
        FnameHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        FnameHolder.setForeground(new java.awt.Color(1, 1, 1));
        FnameHolder.setText("\"HOLDER\"");
        FnameHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FnameHolder, gridBagConstraints);

        AddressHolder.setBackground(new java.awt.Color(255, 255, 255));
        AddressHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        AddressHolder.setForeground(new java.awt.Color(1, 1, 1));
        AddressHolder.setText("\"HOLDER\"");
        AddressHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(AddressHolder, gridBagConstraints);

        DepartHolder.setBackground(new java.awt.Color(255, 255, 255));
        DepartHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        DepartHolder.setForeground(new java.awt.Color(1, 1, 1));
        DepartHolder.setText("\"HOLDER\"");
        DepartHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(DepartHolder, gridBagConstraints);

        ContNumHolder.setBackground(new java.awt.Color(255, 255, 255));
        ContNumHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        ContNumHolder.setForeground(new java.awt.Color(1, 1, 1));
        ContNumHolder.setText("\"HOLDER\"");
        ContNumHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(ContNumHolder, gridBagConstraints);

        JoinDHolder.setBackground(new java.awt.Color(255, 255, 255));
        JoinDHolder.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        JoinDHolder.setForeground(new java.awt.Color(1, 1, 1));
        JoinDHolder.setText("\"HOLDER\"");
        JoinDHolder.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(JoinDHolder, gridBagConstraints);

        BackButton.setBackground(new java.awt.Color(74, 25, 72));
        BackButton.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/turnback-40.png"))); // NOI18N
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
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(BackButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 10;
        add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 10;
        add(filler2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BackButtonFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonFocusGained

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
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
        cardLayout.show(container, "adminDashboard");
    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel AddressHolder;
    private javax.swing.JLabel AdminProfLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ContNumHolder;
    private javax.swing.JLabel ContactNumber;
    private javax.swing.JLabel DepartHolder;
    private javax.swing.JLabel Department;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EmailHolder;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel FnameHolder;
    private javax.swing.JLabel JoinDHolder;
    private javax.swing.JLabel JoinDate;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel LnameHolder;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel UsernameHolder;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
