package GUI;

import EndUser.Admin;
import EndUser.Student;
import javax.swing.*;

public class ViewProfilePanel extends JFrame {

    private javax.swing.JLabel Address;
    private javax.swing.JTextField AdminAddressField;
    private javax.swing.JTextField AdminContactNumField;
    private javax.swing.JTextField AdminDepartmentField;
    private javax.swing.JTextField AdminEmailField;
    private javax.swing.JTextField AdminFnameField;
    private javax.swing.JTextField AdminJoinDateField;
    private javax.swing.JTextField AdminLnameField;
    private javax.swing.JTextField AdminUsernameField;
    private javax.swing.JLabel ContactNumber;
    private javax.swing.JLabel Department;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel JoinDate;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel Username;
    private javax.swing.JButton Backbutton;
    private javax.swing.JLabel AdminProfLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Fname;
    private javax.swing.JLabel Grade;
    private javax.swing.JLabel Institute;
    private javax.swing.JLabel Lname;
    private javax.swing.JTextField StudentAddressField;
    private javax.swing.JTextField StudentEmailField;
    private javax.swing.JTextField StudentFnameField;
    private javax.swing.JTextField StudentGradeField;
    private javax.swing.JTextField StudentInstituteField;
    private javax.swing.JTextField StudentLnameField;
    private javax.swing.JLabel StudentMenu;
    private javax.swing.JLabel StudentPassedTC;
    private javax.swing.JTextField StudentPassedTCField;
    private javax.swing.JTextArea StudentTakenTestsArea;
    private javax.swing.JLabel StudentTotalTOT;
    private javax.swing.JTextField StudentTotalTOTField;
    private javax.swing.JTextField StudentUsernameField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;

    public ViewProfilePanel(Object obj) {
        if (obj instanceof Admin) {
        Username = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        FirstName = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        JoinDate = new javax.swing.JLabel();
        ContactNumber = new javax.swing.JLabel();
        Backbutton = new javax.swing.JButton();
        AdminJoinDateField = new javax.swing.JTextField();
        AdminContactNumField = new javax.swing.JTextField();
        AdminDepartmentField = new javax.swing.JTextField();
        AdminAddressField = new javax.swing.JTextField();
        AdminLnameField = new javax.swing.JTextField();
        AdminFnameField = new javax.swing.JTextField();
        AdminEmailField = new javax.swing.JTextField();
        AdminUsernameField = new javax.swing.JTextField();
        AdminProfLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 242, 226));
        setForeground(new java.awt.Color(74, 25, 72));

        Username.setBackground(new java.awt.Color(74, 25, 72));
        Username.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(0, 0, 0));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Username.setText("Username");

        Email.setBackground(new java.awt.Color(74, 25, 72));
        Email.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 0));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Email");

        FirstName.setBackground(new java.awt.Color(74, 25, 72));
        FirstName.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        FirstName.setForeground(new java.awt.Color(0, 0, 0));
        FirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FirstName.setText("First Name");

        LastName.setBackground(new java.awt.Color(74, 25, 72));
        LastName.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        LastName.setForeground(new java.awt.Color(0, 0, 0));
        LastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LastName.setText("Last Name");

        Department.setBackground(new java.awt.Color(74, 25, 72));
        Department.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        Department.setForeground(new java.awt.Color(0, 0, 0));
        Department.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Department.setText("Department");

        Address.setBackground(new java.awt.Color(74, 25, 72));
        Address.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        Address.setForeground(new java.awt.Color(0, 0, 0));
        Address.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Address.setText("Address");

        JoinDate.setBackground(new java.awt.Color(74, 25, 72));
        JoinDate.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        JoinDate.setForeground(new java.awt.Color(0, 0, 0));
        JoinDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JoinDate.setText("Join Date");

        ContactNumber.setBackground(new java.awt.Color(74, 25, 72));
        ContactNumber.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        ContactNumber.setForeground(new java.awt.Color(0, 0, 0));
        ContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ContactNumber.setText("Contact Number");

        Backbutton.setBackground(new java.awt.Color(0, 0, 0));
        Backbutton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeyad\\myproject\\TestApp\\TestGeneratorSystem\\lib\\turnback-40.png")); // NOI18N

        AdminJoinDateField.setBackground(new java.awt.Color(255, 255, 255));
        AdminJoinDateField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminJoinDateField.setForeground(new java.awt.Color(0, 0, 0));
        AdminJoinDateField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminJoinDateField.setCaretColor(new java.awt.Color(0, 0, 0));
        AdminJoinDateField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminContactNumField.setBackground(new java.awt.Color(255, 255, 255));
        AdminContactNumField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminContactNumField.setForeground(new java.awt.Color(0, 0, 0));
        AdminContactNumField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminContactNumField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminDepartmentField.setBackground(new java.awt.Color(255, 255, 255));
        AdminDepartmentField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminDepartmentField.setForeground(new java.awt.Color(0, 0, 0));
        AdminDepartmentField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminDepartmentField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminAddressField.setBackground(new java.awt.Color(255, 255, 255));
        AdminAddressField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminAddressField.setForeground(new java.awt.Color(0, 0, 0));
        AdminAddressField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminAddressField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminLnameField.setBackground(new java.awt.Color(255, 255, 255));
        AdminLnameField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminLnameField.setForeground(new java.awt.Color(0, 0, 0));
        AdminLnameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminLnameField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminFnameField.setBackground(new java.awt.Color(255, 255, 255));
        AdminFnameField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminFnameField.setForeground(new java.awt.Color(0, 0, 0));
        AdminFnameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminFnameField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminEmailField.setBackground(new java.awt.Color(255, 255, 255));
        AdminEmailField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminEmailField.setForeground(new java.awt.Color(0, 0, 0));
        AdminEmailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminEmailField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminUsernameField.setBackground(new java.awt.Color(255, 255, 255));
        AdminUsernameField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AdminUsernameField.setForeground(new java.awt.Color(0, 0, 0));
        AdminUsernameField.setText("text");
        AdminUsernameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        AdminUsernameField.setSelectionColor(new java.awt.Color(51, 0, 51));

        AdminProfLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        AdminProfLabel.setForeground(new java.awt.Color(0, 0, 0));
        AdminProfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminProfLabel.setText("Admin Profile");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminProfLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(AdminContactNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdminDepartmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AdminEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AdminUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AdminAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AdminLnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AdminFnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AdminJoinDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminProfLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminFnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(FirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminLnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminDepartmentField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminContactNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminJoinDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(Backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
            // </editor-fold>                                                                                                                
            // Variables declaration - do not modify                     

            // End of variables declaration                   
        } else if (obj instanceof Student) {
            Username = new javax.swing.JLabel();
            Address = new javax.swing.JLabel();
            Email = new javax.swing.JLabel();
            Fname = new javax.swing.JLabel();
            Lname = new javax.swing.JLabel();
            Grade = new javax.swing.JLabel();
            StudentPassedTC = new javax.swing.JLabel();
            Institute = new javax.swing.JLabel();
            StudentTotalTOT = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            StudentTakenTestsArea = new javax.swing.JTextArea();
            BackButton = new javax.swing.JButton();
            StudentUsernameField = new javax.swing.JTextField();
            StudentEmailField = new javax.swing.JTextField();
            StudentFnameField = new javax.swing.JTextField();
            StudentAddressField = new javax.swing.JTextField();
            StudentInstituteField = new javax.swing.JTextField();
            StudentGradeField = new javax.swing.JTextField();
            StudentLnameField = new javax.swing.JTextField();
            StudentPassedTCField = new javax.swing.JTextField();
            StudentMenu = new javax.swing.JLabel();
            StudentTotalTOTField = new javax.swing.JTextField();

            setBackground(new java.awt.Color(244, 242, 226));
            setForeground(new java.awt.Color(244, 242, 226));

            Username.setBackground(new java.awt.Color(74, 25, 72));
            Username.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Username.setForeground(new java.awt.Color(74, 25, 72));
            Username.setText("Username");

            Address.setBackground(new java.awt.Color(74, 25, 72));
            Address.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Address.setForeground(new java.awt.Color(74, 25, 72));
            Address.setText("Address");

            Email.setBackground(new java.awt.Color(74, 25, 72));
            Email.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Email.setForeground(new java.awt.Color(74, 25, 72));
            Email.setText("Email");

            Fname.setBackground(new java.awt.Color(74, 25, 72));
            Fname.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Fname.setForeground(new java.awt.Color(74, 25, 72));
            Fname.setText("First Name");

            Lname.setBackground(new java.awt.Color(74, 25, 72));
            Lname.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Lname.setForeground(new java.awt.Color(74, 25, 72));
            Lname.setText("Last Name");

            Grade.setBackground(new java.awt.Color(74, 25, 72));
            Grade.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Grade.setForeground(new java.awt.Color(74, 25, 72));
            Grade.setText("Grade");

            StudentPassedTC.setBackground(new java.awt.Color(74, 25, 72));
            StudentPassedTC.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
            StudentPassedTC.setForeground(new java.awt.Color(74, 25, 72));
            StudentPassedTC.setText("Passed Tests Count");

            Institute.setBackground(new java.awt.Color(74, 25, 72));
            Institute.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            Institute.setForeground(new java.awt.Color(74, 25, 72));
            Institute.setText("Institute");

            StudentTotalTOT.setBackground(new java.awt.Color(74, 25, 72));
            StudentTotalTOT.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
            StudentTotalTOT.setForeground(new java.awt.Color(74, 25, 72));
            StudentTotalTOT.setText("Total Time Of All Tests");

            jLabel10.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(74, 25, 72));
            jLabel10.setText("Taken Tests:");

            StudentTakenTestsArea.setBackground(new java.awt.Color(74, 25, 72));
            StudentTakenTestsArea.setColumns(20);
            StudentTakenTestsArea.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
            StudentTakenTestsArea.setRows(5);
            jScrollPane1.setViewportView(StudentTakenTestsArea);

            BackButton.setBackground(new java.awt.Color(0, 0, 0));
            BackButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeyad\\myproject\\TestApp\\TestGeneratorSystem\\lib\\turnback-40.png")); // NOI18N
            BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    BackButtonMouseClicked(evt);
                }
            });

            StudentUsernameField.setBackground(new java.awt.Color(74, 25, 72));
            StudentUsernameField.setForeground(new java.awt.Color(244, 242, 226));

            StudentEmailField.setBackground(new java.awt.Color(74, 25, 72));

            StudentFnameField.setBackground(new java.awt.Color(74, 25, 72));
            StudentFnameField.setForeground(new java.awt.Color(244, 242, 226));

            StudentAddressField.setBackground(new java.awt.Color(74, 25, 72));
            StudentAddressField.setForeground(new java.awt.Color(244, 242, 226));

            StudentInstituteField.setBackground(new java.awt.Color(74, 25, 72));
            StudentInstituteField.setForeground(new java.awt.Color(244, 242, 226));

            StudentGradeField.setBackground(new java.awt.Color(74, 25, 72));

            StudentLnameField.setBackground(new java.awt.Color(74, 25, 72));
            StudentLnameField.setForeground(new java.awt.Color(244, 242, 226));

            StudentPassedTCField.setBackground(new java.awt.Color(74, 25, 72));
            StudentPassedTCField.setForeground(new java.awt.Color(244, 242, 226));

            StudentMenu.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
            StudentMenu.setForeground(new java.awt.Color(0, 0, 0));
            StudentMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            StudentMenu.setText("Student Menu");
            StudentMenu.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            StudentTotalTOTField.setBackground(new java.awt.Color(74, 25, 72));
            StudentTotalTOTField.setForeground(new java.awt.Color(244, 242, 226));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(Lname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Fname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Grade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Institute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(StudentPassedTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(StudentTotalTOT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(StudentUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(StudentPassedTCField)
                                                    .addComponent(StudentInstituteField)
                                                    .addComponent(StudentGradeField)
                                                    .addComponent(StudentFnameField)
                                                    .addComponent(StudentEmailField)
                                                    .addComponent(StudentLnameField)
                                                    .addComponent(StudentAddressField)
                                                    .addComponent(StudentTotalTOTField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StudentMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
                            .addComponent(jScrollPane1)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(StudentMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentUsernameField)
                                            .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentFnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentLnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Lname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Grade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentInstituteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Institute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentPassedTCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(StudentPassedTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StudentTotalTOTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(StudentTotalTOT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
        }// </editor-fold>                                                                        
        // Variables declaration - do not modify                     

    }

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }
}
