/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StudentPanels;

import TestSystem.Question;
import TestSystem.Test;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;

/**
 *
 * @author Zeyad
 */
public class QuesitionsFullDetailsPanelP extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private Container container;
    protected Test test; 
    protected int takerAnswer ; 
    protected static int Index ;
    List<Question> questions;
    List<Integer> takerAnswers;
    /**
     * Creates new form QuesitionsFullDetailsPanelP
     */
    public QuesitionsFullDetailsPanelP(Test test, CardLayout cardLayout, Container container) {
        initComponents();
        this.test = test ; 
        this.cardLayout = cardLayout;
        this.container = container;
        Index = 0;
        questions = test.getQuestions();
        takerAnswers = test.getTakerAnswers();
        Question question = questions.get(Index);
        int studentAnswer = takerAnswers.get(Index);
        int correctAnswer = question.getRightAnswer();
        String Result = studentAnswer == correctAnswer ? "CORRECT" : "INCORRECT" ;
        QuesitionHolder.setText(question.getStatement());
        CorrectA.setText("Correct Answer: "+ String.valueOf('A' + correctAnswer));
        UserA.setText("YourAnswer: " + String.valueOf(('A' + studentAnswer)));
        QuesitionHolder.setText("Result: " + Result);
        String[] choices = question.getChoices();
        AHOLDER.setText("A" + choices[1]);
        BHOLDER.setText("B" + choices[2]);
        CHOLDER.setText("C" + choices[3]);
        DHOLDER.setText("D" + choices[4]); 
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        UserA = new javax.swing.JLabel();
        Choices = new javax.swing.JLabel();
        Result = new javax.swing.JLabel();
        CorrectA = new javax.swing.JLabel();
        QuesitionHolder = new javax.swing.JLabel();
        AHOLDER = new javax.swing.JLabel();
        BHOLDER = new javax.swing.JLabel();
        CHOLDER = new javax.swing.JLabel();
        DHOLDER = new javax.swing.JLabel();
        QuesitionDetailsTitle = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        PrevButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 242, 226));
        setForeground(new java.awt.Color(244, 242, 226));
        setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(74, 25, 72));
        jButton1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jButton1, gridBagConstraints);

        UserA.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        UserA.setForeground(new java.awt.Color(0, 0, 0));
        UserA.setText("YourAnswer: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(UserA, gridBagConstraints);

        Choices.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Choices.setForeground(new java.awt.Color(0, 0, 0));
        Choices.setText("Choices:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Choices, gridBagConstraints);

        Result.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        Result.setForeground(new java.awt.Color(0, 0, 0));
        Result.setText("Result: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(Result, gridBagConstraints);

        CorrectA.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        CorrectA.setForeground(new java.awt.Color(0, 0, 0));
        CorrectA.setText("Correct Answer: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(CorrectA, gridBagConstraints);

        QuesitionHolder.setBackground(new java.awt.Color(255, 255, 255));
        QuesitionHolder.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        QuesitionHolder.setForeground(new java.awt.Color(0, 0, 0));
        QuesitionHolder.setText("\"Quesition HOLDER\"");
        QuesitionHolder.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 556;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(QuesitionHolder, gridBagConstraints);

        AHOLDER.setBackground(new java.awt.Color(255, 255, 255));
        AHOLDER.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        AHOLDER.setForeground(new java.awt.Color(0, 0, 0));
        AHOLDER.setText("\"AHOLDER\"");
        AHOLDER.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(AHOLDER, gridBagConstraints);

        BHOLDER.setBackground(new java.awt.Color(255, 255, 255));
        BHOLDER.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        BHOLDER.setForeground(new java.awt.Color(0, 0, 0));
        BHOLDER.setText("\"BHOLDER\"");
        BHOLDER.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(BHOLDER, gridBagConstraints);

        CHOLDER.setBackground(new java.awt.Color(255, 255, 255));
        CHOLDER.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        CHOLDER.setForeground(new java.awt.Color(0, 0, 0));
        CHOLDER.setText("\"CHOLDER\"");
        CHOLDER.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(CHOLDER, gridBagConstraints);

        DHOLDER.setBackground(new java.awt.Color(255, 255, 255));
        DHOLDER.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        DHOLDER.setForeground(new java.awt.Color(0, 0, 0));
        DHOLDER.setText("\"DHOLDER\"");
        DHOLDER.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(DHOLDER, gridBagConstraints);

        QuesitionDetailsTitle.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        QuesitionDetailsTitle.setForeground(new java.awt.Color(0, 0, 0));
        QuesitionDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuesitionDetailsTitle.setText("Quesition Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(QuesitionDetailsTitle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(filler1, gridBagConstraints);

        PrevButton.setBackground(new java.awt.Color(74, 25, 72));
        PrevButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        PrevButton.setForeground(new java.awt.Color(244, 242, 226));
        PrevButton.setText("Previus");
        PrevButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrevButton.setFocusPainted(false);
        PrevButton.setPreferredSize(new java.awt.Dimension(105, 35));
        PrevButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PrevButtonMouseMoved(evt);
            }
        });
        PrevButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrevButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrevButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrevButtonMousePressed(evt);
            }
        });
        PrevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(PrevButton, gridBagConstraints);

        NextButton.setBackground(new java.awt.Color(74, 25, 72));
        NextButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        NextButton.setForeground(new java.awt.Color(244, 242, 226));
        NextButton.setText("Next");
        NextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NextButton.setFocusPainted(false);
        NextButton.setPreferredSize(new java.awt.Dimension(145, 35));
        NextButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NextButtonMouseMoved(evt);
            }
        });
        NextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButtonMousePressed(evt);
            }
        });
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(NextButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        cardLayout.show(container, "TestHView");
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PrevButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevButtonMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_PrevButtonMouseMoved

    private void PrevButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevButtonMouseEntered
        // TODO add your handling code here:
        PrevButton.setBackground(Color.decode("#F4F2E2"));
        PrevButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        PrevButton.setBorderPainted(true);
        PrevButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_PrevButtonMouseEntered

    private void PrevButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevButtonMouseExited
        // TODO add your handling code here:
        PrevButton.setBackground(Color.decode("#4A1948"));
        PrevButton.setBorderPainted(false);
        PrevButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_PrevButtonMouseExited

    private void PrevButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrevButtonMousePressed

    private void PrevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevButtonActionPerformed
        // TODO add your handling code here:
        Index = (Index - 1 + questions.size()) % questions.size();
    }//GEN-LAST:event_PrevButtonActionPerformed

    private void NextButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_NextButtonMouseMoved

    private void NextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseEntered
        // TODO add your handling code here:
        NextButton.setBackground(Color.decode("#F4F2E2"));
        NextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        NextButton.setBorderPainted(true);
        NextButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_NextButtonMouseEntered

    private void NextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseExited
        // TODO add your handling code here:
        NextButton.setBackground(Color.decode("#4A1948"));
        NextButton.setBorderPainted(false);
        NextButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_NextButtonMouseExited

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NextButtonMousePressed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        Index = ( Index + 1 ) % questions.size();
    }//GEN-LAST:event_NextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AHOLDER;
    private javax.swing.JLabel BHOLDER;
    private javax.swing.JLabel CHOLDER;
    private javax.swing.JLabel Choices;
    private javax.swing.JLabel CorrectA;
    private javax.swing.JLabel DHOLDER;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PrevButton;
    private javax.swing.JLabel QuesitionDetailsTitle;
    private javax.swing.JLabel QuesitionHolder;
    private javax.swing.JLabel Result;
    private javax.swing.JLabel UserA;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
