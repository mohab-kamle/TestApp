/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.StudentDAO;
import EndUser.Admin;
import EndUser.Student;
import EndUser.User;
import GUI.AdminPanels.UpdateAdminprofileP;
import GUI.StudentPanels.UpdateStudentprofileP;
import UserDefinedFunctionalities.Checker;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Zeyad
 */
public class UpdatePanelP extends javax.swing.JPanel {

    private String type;
    private User user;
    private CardLayout cardLayout;
    private JPanel container;
    Checker check;
    AdminDAO ADB;
    Admin admin;
    Student student;
    StudentDAO SDB;
    boolean flagMoreField = true;
    boolean flagMoreField2 = true;
    boolean flagHolder = true;
    String country;
    String city;
    String street;

    /**
     * Creates new form UpdatePanelP
     */
    public UpdatePanelP(String type, User user, CardLayout cardLayout, JPanel container) {
        initComponents();
        this.type = type;
        this.user = user;
        this.check = new Checker();
        this.cardLayout = cardLayout;
        this.container = container;
        ADB = new AdminDAO();
        ErrorInput.setVisible(false);
        moreUpdateField.setVisible(false);
        moreUpdateFieldError.setVisible(false);
        Confirm.setVisible(false);
        moreUpdateField2.setVisible(false);
        ErrorInput2.setVisible(false);
        if (user instanceof Admin) {

            admin = (Admin) user;
            switch (type) {
                case "username" -> {
                    TitleHolder.setText("Update Unameame");
                    UpdateHolder.setText(admin.getUserName());
                }
                case "email" -> {
                    TitleHolder.setText("Update Email");
                    UpdateHolder.setText(admin.getEmail());
                }
                case "name" -> {
                    TitleHolder.setText("Update Name");
                    moreUpdateField.setText("First Name: " + admin.getFirstName());
                    moreUpdateField.setVisible(true);
                    UpdateHolder.setText("Last Name: " + admin.getLastName());
                }
                case "address" -> {
                    String address = admin.getAddress();
                    String[] parts = address.split(", ");
                    country = parts[0];
                    city = parts[1];
                    street = parts[2];
                    moreUpdateField.setText("Country: " + country);
                    UpdateHolder.setText("City: " + city);
                    moreUpdateField2.setText("Street: " + street);
                    moreUpdateField.setVisible(true);
                    moreUpdateField2.setVisible(true);
                    TitleHolder.setText("Update Address");
                }
                case "contectnumber" -> {
                    TitleHolder.setText("Update Contact Number");
                    UpdateHolder.setText(admin.getContactNumber());
                }
                case "contactnumber" -> {
                    TitleHolder.setText("Update Department");
                    UpdateHolder.setText(admin.getDepartment());
                }
            }
        } else if (user instanceof Student) {
            student = (Student) user;
            switch (type) {
                case "username" -> {
                    TitleHolder.setText("Update Unameame");
                    UpdateHolder.setText(student.getUserName());
                }
                case "email" -> {
                    TitleHolder.setText("Update Email");
                    UpdateHolder.setText(student.getEmail());
                }
                case "name" -> {
                    TitleHolder.setText("Update Name");
                    moreUpdateField.setText("First Name: " + student.getFirstName());
                    moreUpdateField.setVisible(true);
                    UpdateHolder.setText("Last Name: " + student.getLastName());
                }
                case "address" -> {
                    String address = student.getAddress();
                    String[] parts = address.split(", ");
                    country = parts[0];
                    city = parts[1];
                    street = parts[2];
                    moreUpdateField.setText("Country: " + country);
                    UpdateHolder.setText("City: " + city);
                    moreUpdateField2.setText("Street: " + street);
                    moreUpdateField.setVisible(true);
                    moreUpdateField2.setVisible(true);
                    TitleHolder.setText("Update Address");
                }
                case "Institute" -> {
                    TitleHolder.setText("Institute Unameame");
                    UpdateHolder.setText(student.getInstitute());
                }
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        TitleHolder = new javax.swing.JLabel();
        comfirmButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(3270067, 500000000));
        BackButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        UpdateHolder = new javax.swing.JTextField();
        ErrorInput = new javax.swing.JLabel();
        moreUpdateField = new javax.swing.JTextField();
        moreUpdateFieldError = new javax.swing.JLabel();
        Confirm = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        moreUpdateField2 = new javax.swing.JTextField();
        ErrorInput2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 242, 226));
        setForeground(new java.awt.Color(0, 0, 220));
        setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        TitleHolder.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        TitleHolder.setForeground(new java.awt.Color(0, 0, 0));
        TitleHolder.setText("\"UPDATETITLEHOLDER\"");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(TitleHolder, gridBagConstraints);

        comfirmButton.setBackground(new java.awt.Color(74, 25, 72));
        comfirmButton.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        comfirmButton.setForeground(new java.awt.Color(244, 242, 226));
        comfirmButton.setText("Done");
        comfirmButton.setBorderPainted(false);
        comfirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comfirmButton.setFocusPainted(false);
        comfirmButton.setPreferredSize(new java.awt.Dimension(145, 60));
        comfirmButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                comfirmButtonMouseMoved(evt);
            }
        });
        comfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comfirmButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comfirmButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comfirmButtonMousePressed(evt);
            }
        });
        comfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(comfirmButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler1, gridBagConstraints);

        filler2.setForeground(new java.awt.Color(0, 220, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler2, gridBagConstraints);

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
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(BackButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler3, gridBagConstraints);

        UpdateHolder.setBackground(new java.awt.Color(255, 255, 255));
        UpdateHolder.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UpdateHolder.setForeground(new java.awt.Color(0, 0, 0));
        UpdateHolder.setText("jTextField1");
        UpdateHolder.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        UpdateHolder.setMinimumSize(new java.awt.Dimension(200, 40));
        UpdateHolder.setPreferredSize(new java.awt.Dimension(200, 40));
        UpdateHolder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UpdateHolderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpdateHolderFocusLost(evt);
            }
        });
        UpdateHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateHolderActionPerformed(evt);
            }
        });
        UpdateHolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UpdateHolderKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UpdateHolder, gridBagConstraints);

        ErrorInput.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        ErrorInput.setForeground(new java.awt.Color(220, 0, 0));
        ErrorInput.setText("jLabel1");
        ErrorInput.setMaximumSize(new java.awt.Dimension(70000, 20002));
        ErrorInput.setPreferredSize(new java.awt.Dimension(250, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(ErrorInput, gridBagConstraints);

        moreUpdateField.setBackground(new java.awt.Color(255, 255, 255));
        moreUpdateField.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        moreUpdateField.setForeground(new java.awt.Color(0, 0, 0));
        moreUpdateField.setText("jTextField1");
        moreUpdateField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        moreUpdateField.setMinimumSize(new java.awt.Dimension(200, 40));
        moreUpdateField.setPreferredSize(new java.awt.Dimension(200, 40));
        moreUpdateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moreUpdateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moreUpdateFieldFocusLost(evt);
            }
        });
        moreUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreUpdateFieldActionPerformed(evt);
            }
        });
        moreUpdateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moreUpdateFieldKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(moreUpdateField, gridBagConstraints);

        moreUpdateFieldError.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        moreUpdateFieldError.setForeground(new java.awt.Color(220, 0, 0));
        moreUpdateFieldError.setText("jLabel1");
        moreUpdateFieldError.setMaximumSize(new java.awt.Dimension(70000, 20002));
        moreUpdateFieldError.setPreferredSize(new java.awt.Dimension(250, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(moreUpdateFieldError, gridBagConstraints);

        Confirm.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        Confirm.setForeground(new java.awt.Color(0, 220, 0));
        Confirm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Confirm.setText("jLabel1");
        Confirm.setMaximumSize(new java.awt.Dimension(70000, 20002));
        Confirm.setPreferredSize(new java.awt.Dimension(250, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Confirm, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler4, gridBagConstraints);

        moreUpdateField2.setBackground(new java.awt.Color(255, 255, 255));
        moreUpdateField2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        moreUpdateField2.setForeground(new java.awt.Color(0, 0, 0));
        moreUpdateField2.setText("jTextField1");
        moreUpdateField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));
        moreUpdateField2.setMinimumSize(new java.awt.Dimension(200, 40));
        moreUpdateField2.setPreferredSize(new java.awt.Dimension(200, 40));
        moreUpdateField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moreUpdateField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moreUpdateField2FocusLost(evt);
            }
        });
        moreUpdateField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreUpdateField2ActionPerformed(evt);
            }
        });
        moreUpdateField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moreUpdateField2KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(moreUpdateField2, gridBagConstraints);

        ErrorInput2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        ErrorInput2.setForeground(new java.awt.Color(220, 0, 0));
        ErrorInput2.setText("jLabel1");
        ErrorInput2.setMaximumSize(new java.awt.Dimension(70000, 20002));
        ErrorInput2.setPreferredSize(new java.awt.Dimension(250, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(ErrorInput2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void comfirmButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comfirmButtonMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_comfirmButtonMouseMoved

    private void comfirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comfirmButtonMouseEntered
        // TODO add your handling code here:
        comfirmButton.setBackground(Color.decode("#F4F2E2"));
        comfirmButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        comfirmButton.setBorderPainted(true);
        comfirmButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_comfirmButtonMouseEntered

    private void comfirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comfirmButtonMouseExited
        // TODO add your handling code here:
        comfirmButton.setBackground(Color.decode("#4A1948"));
        comfirmButton.setBorderPainted(false);
        comfirmButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_comfirmButtonMouseExited

    private void comfirmButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comfirmButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comfirmButtonMousePressed

    private void comfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfirmButtonActionPerformed
        // TODO add your handling code here:
        if ((type == "name" || type == "address") && (ErrorInput.isVisible() || ErrorInput2.isVisible() || moreUpdateFieldError.isVisible())) {
            Confirm.setForeground(new java.awt.Color(220, 0, 0));
            Confirm.setText("Make Sure All Input currect");
            Confirm.setVisible(true);
        } else if (ErrorInput.isVisible()) {
            Confirm.setForeground(new java.awt.Color(220, 0, 0));
            Confirm.setText("Make Sure All Input currect");
            Confirm.setVisible(true);
        } else if (moreUpdateField.getText().trim().isEmpty() || UpdateHolder.getText().trim().isEmpty() || moreUpdateField2.getText().trim().isEmpty()) {
            Confirm.setForeground(new java.awt.Color(220, 0, 0));
            Confirm.setText("Please, Fields cannot be empty!");
            Confirm.setVisible(true);
        } else {
            Confirm.setForeground(new java.awt.Color(0, 220, 0));
            Confirm.setText(type.toUpperCase() + " Changed " + "successfully");
            Confirm.setVisible(true);
            if (user instanceof Admin) {
                switch (type) {
                    case "username" -> {
                        if (check.isValid(Checker.StringType.USERNAME, UpdateHolder.getText())) {
                            admin.setUserName(UpdateHolder.getText());
                        }
                    }
                    case "email" -> {
                        if (check.isValid(Checker.StringType.EMAIL, UpdateHolder.getText())) {
                            admin.setEmail(UpdateHolder.getText());
                        }
                    }
                    case "name" -> {
                        if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText()) && check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                            admin.setFirstName(moreUpdateField.getText());
                            admin.setLastName(UpdateHolder.getText());
                        }
                    }
                    case "address" ->
                        admin.setAddress(moreUpdateField.getText() + " , " + UpdateHolder.getText() + " , " + moreUpdateField2.getText());
                    case "contactnumber" -> {
                        if (check.isValid(Checker.StringType.PHONE_NO, UpdateHolder.getText())) {
                            admin.setContactNumber(UpdateHolder.getText());
                        }
                    }
                    case "department" -> {
                        if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                            admin.setDepartment(UpdateHolder.getText());
                        }
                    }
                }
                ADB.updateAdmin(admin);
                user.updateEquivalentCategoryAndQuestionBank();
            } else if (user instanceof Student) {
                switch (type) {
                    case "username" -> {
                        if (check.isValid(Checker.StringType.USERNAME, UpdateHolder.getText())) {
                            student.setUserName(UpdateHolder.getText());
                        }
                    }
                    case "email" -> {
                        if (check.isValid(Checker.StringType.EMAIL, UpdateHolder.getText())) {
                            student.setEmail(UpdateHolder.getText());
                        }
                    }
                    case "name" -> {
                        if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText()) && check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                            student.setFirstName(moreUpdateField.getText());
                            student.setLastName(UpdateHolder.getText());
                        }
                    }
                    case "address" -> {
                        if (student == null || (check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText()) && check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText()) && check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField2.getText()))) {
                            student.setAddress(moreUpdateField.getText() + " , " + UpdateHolder.getText() + " , " + moreUpdateField2.getText());
                        }
                    }
                    case "Institute" -> {
                        if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                            student.setInstitute(UpdateHolder.getText());
                        }
                    }

                }
                SDB.updateStudent(student);
            }
        }
    }//GEN-LAST:event_comfirmButtonActionPerformed

    private void BackButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BackButtonFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BackButtonFocusGained

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
        Confirm.setVisible(false);
        ErrorInput.setVisible(false);
        ErrorInput2.setVisible(false);
        moreUpdateField.setVisible(false);
        moreUpdateField2.setVisible(false);
        moreUpdateFieldError.setVisible(false);
        cardLayout.show(container, "ResetPass");
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
        Confirm.setVisible(false);
        moreUpdateField.setVisible(false);
        moreUpdateField2.setVisible(false);
        moreUpdateFieldError.setVisible(false);
        ErrorInput.setVisible(false);
        ErrorInput2.setVisible(false);
        if (user instanceof Admin) {
            UpdateAdminprofileP UpdateAdminP = new UpdateAdminprofileP(admin, cardLayout, container);
            container.add(UpdateAdminP,"UpdateAdminP");
            cardLayout.show(container, "UpdateAdminP");
        } else if(user instanceof Student) {
            UpdateStudentprofileP UpdateStudentP = new UpdateStudentprofileP(student, cardLayout, container);
            container.add(UpdateStudentP,"UpdateStudentP");
            cardLayout.show(container, "UpdateStudentP");
        }
    }//GEN-LAST:event_BackButtonActionPerformed

    private void UpdateHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateHolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateHolderActionPerformed

    private void UpdateHolderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateHolderKeyReleased
        // TODO add your handling code here:
        if (user instanceof Admin) {
            switch (type) {
                case "username" -> {
                    if (check.isValid(Checker.StringType.USERNAME, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Username");
                        ErrorInput.setVisible(true);
                    }
                }
                case "email" -> {
                    if (check.isValid(Checker.StringType.EMAIL, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Email");
                        ErrorInput.setVisible(true);
                    }
                }
                case "name" -> {
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                        ErrorInput.setText("Please Enter Proper Name");
                        ErrorInput.setVisible(true);
                    } else {
                        ErrorInput.setVisible(false);
                    }
                    if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText()) && check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                    }
                }
                case "address" -> {
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                        moreUpdateFieldError.setText("Please Enter the right country name only");
                        moreUpdateFieldError.setVisible(true);
                    } else {
                        moreUpdateFieldError.setVisible(false);
                    }
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                        ErrorInput.setText("Please Enter the right country name only");
                        ErrorInput.setVisible(true);
                    } else {
                        ErrorInput.setVisible(false);
                    }
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField2.getText())) {
                        ErrorInput2.setText("Please Enter the right country name only");
                        ErrorInput2.setVisible(true);
                    } else {
                        ErrorInput2.setVisible(false);
                    }
                }
                case "contactnumber" -> {
                    if (check.isValid(Checker.StringType.PHONE_NO, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Phone Number");
                        ErrorInput.setVisible(true);
                    }
                }
                case "department" -> {
                    if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {;
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Department");
                        ErrorInput.setVisible(true);
                    }
                }
                default -> {
                }
            }
        } else if (user instanceof Student) {
            SDB = new StudentDAO();
            switch (type) {
                case "username" -> {
                    if (check.isValid(Checker.StringType.USERNAME, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Username");
                        ErrorInput.setVisible(true);
                    }
                }
                case "email" -> {
                    if (check.isValid(Checker.StringType.EMAIL, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Email");
                        ErrorInput.setVisible(true);
                    }
                }
                case "name" -> {
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                        ErrorInput.setText("Please Enter Proper Name");
                        ErrorInput.setVisible(true);
                    } else {
                        ErrorInput.setVisible(false);
                    }
                }
                case "address" -> {
                    if (!check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                        ErrorInput.setText("Please Enter the right country name only");
                        ErrorInput.setVisible(true);
                    } else {
                        ErrorInput.setVisible(false);
                    }
                }
                case "Institute" -> {
                    if (check.isValid(Checker.StringType.LETTERS_ONLY, UpdateHolder.getText())) {
                        ErrorInput.setVisible(false);
                    } else {
                        ErrorInput.setText("Invalide Institute");
                        ErrorInput.setVisible(true);
                    }
                }
            }
    }//GEN-LAST:event_UpdateHolderKeyReleased
    }
    private void moreUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moreUpdateFieldActionPerformed

    private void moreUpdateFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moreUpdateFieldKeyReleased
        // TODO add your handling code here:
        switch (type) {
            case "name" -> {
                if (!check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                    moreUpdateFieldError.setText("Please Enter Proper Name");
                    moreUpdateFieldError.setVisible(true);
                } else {
                    moreUpdateFieldError.setVisible(false);
                }
            }
            case "address" -> {
                if (!check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField.getText())) {
                    moreUpdateFieldError.setText("Please Enter the right country name only");
                    moreUpdateFieldError.setVisible(true);
                } else {
                    moreUpdateFieldError.setVisible(false);
                }
            }
        }

    }//GEN-LAST:event_moreUpdateFieldKeyReleased

    private void moreUpdateField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreUpdateField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moreUpdateField2ActionPerformed

    private void moreUpdateField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moreUpdateField2KeyReleased
        // TODO add your handling code here:
        if (!check.isValid(Checker.StringType.LETTERS_ONLY, moreUpdateField2.getText())) {
            ErrorInput2.setText("Please Enter the right country name only");
            ErrorInput2.setVisible(true);
        } else {
            ErrorInput2.setVisible(false);
        }
    }//GEN-LAST:event_moreUpdateField2KeyReleased

    private void moreUpdateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreUpdateFieldFocusGained
        // TODO add your handling code here:
        if (flagMoreField) {
            moreUpdateField.setText("");
            flagMoreField = false;
        }
    }//GEN-LAST:event_moreUpdateFieldFocusGained

    private void moreUpdateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreUpdateFieldFocusLost
        // TODO add your handling code here:
        if (moreUpdateField.getText().trim().isEmpty()) {
            if (user instanceof Admin) {
                switch (type) {
                    case "name" ->
                        moreUpdateField.setText("First name: " + admin.getFirstName());
                    case "address" ->
                        moreUpdateField.setText("Country: " + country);
                }
            } else if (user instanceof Student) {
                switch (type) {
                    case "name" ->
                        moreUpdateField.setText("First name: " + student.getFirstName());
                    case "address" ->
                        moreUpdateField.setText("Country: " + country);
                }
            }
            flagMoreField = true;
        }
    }//GEN-LAST:event_moreUpdateFieldFocusLost

    private void UpdateHolderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateHolderFocusGained
        // TODO add your handling code here:
        if (flagHolder) {
            UpdateHolder.setText("");
            flagHolder = false;
        }
    }//GEN-LAST:event_UpdateHolderFocusGained

    private void UpdateHolderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpdateHolderFocusLost
        // TODO add your handling code here:
        if (UpdateHolder.getText().trim().isEmpty()) {
            if (user instanceof Admin) {
                switch (type) {
                    case "username" -> {
                        UpdateHolder.setText(admin.getUserName());
                    }
                    case "email" -> {
                        UpdateHolder.setText(admin.getEmail());
                    }
                    case "name" -> {
                        UpdateHolder.setText("Last Name: " + admin.getLastName());
                    }
                    case "address" -> {
                        UpdateHolder.setText("Street: " + street);
                    }
                    case "contectnumber" -> {
                        UpdateHolder.setText(admin.getContactNumber());
                    }
                    case "contactnumber" -> {
                        UpdateHolder.setText(admin.getDepartment());
                    }
                }
            } else if (user instanceof Student) {
                switch (type) {
                    case "username" -> {
                        UpdateHolder.setText(student.getUserName());
                    }
                    case "email" -> {
                        UpdateHolder.setText(student.getEmail());
                    }
                    case "name" -> {
                        UpdateHolder.setText("Last Name: " + student.getLastName());
                    }
                    case "address" -> {
                        UpdateHolder.setText("City: " + city);
                    }
                    case "Institute" -> {
                        UpdateHolder.setText(student.getInstitute());
                    }
                }
            }
            flagHolder = true;
        }
    }//GEN-LAST:event_UpdateHolderFocusLost

    private void moreUpdateField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreUpdateField2FocusGained
        // TODO add your handling code here:
        if (flagMoreField2) {
            moreUpdateField2.setText("");
            flagMoreField2 = false;
        }
    }//GEN-LAST:event_moreUpdateField2FocusGained

    private void moreUpdateField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreUpdateField2FocusLost
        // TODO add your handling code here:
        if (moreUpdateField2.getText().trim().isEmpty()) {
            moreUpdateField2.setText("Street: " + street);
            flagMoreField2 = true;
        }
    }//GEN-LAST:event_moreUpdateField2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Confirm;
    private javax.swing.JLabel ErrorInput;
    private javax.swing.JLabel ErrorInput2;
    private javax.swing.JLabel TitleHolder;
    private javax.swing.JTextField UpdateHolder;
    private javax.swing.JButton comfirmButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JTextField moreUpdateField;
    private javax.swing.JTextField moreUpdateField2;
    private javax.swing.JLabel moreUpdateFieldError;
    // End of variables declaration//GEN-END:variables
}
