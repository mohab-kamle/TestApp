/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.AdminPanels;

import EndUser.Admin;
import TestSystem.Question;
import TestSystem.QuestionBank;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author karim mamdouh
 */
public class DeleteQuestionPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form DeleteCategoryPanel
     */
    private int currQuestionIdx;
    private QuestionBank questionBank;
    private CardLayout cardLayout;
    private JPanel container;
    private Admin admin;    
    private String[] navList;
    
    public DeleteQuestionPanel2(CardLayout cardLayout, JPanel container, QuestionBank questionBank, Admin admin, int currQuestionIdx, String[] navList) {
        this.cardLayout = cardLayout;
        this.container = container;
        this.questionBank = questionBank;
        this.admin = admin;
        this.currQuestionIdx = currQuestionIdx;
        this.navList  = navList;
        //Displaying Question's Statement, Choices, And which one is correct
        initComponents();
        questionNavList.setSelectedIndex(currQuestionIdx);
        Question currQuestion = questionBank.getQuestions().get(this.currQuestionIdx);
        questionStatementTA.setText(formatQuestionStatement(currQuestion.getStatement()));
        JRadioButton choicesButtons[] = {aButton, bButton, cButton, dButton};
        ButtonGroup choices = new ButtonGroup(); 
        for(int i=0 ; i<4 ; ++i){
            choicesButtons[i].setText(currQuestion.getChoices()[i]);
            choices.add(choicesButtons[i]);
        }
        choicesButtons[currQuestion.getRightAnswer()].setSelected(true);
        choicesButtons[currQuestion.getRightAnswer()].addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
            choicesButtons[currQuestion.getRightAnswer()].setSelected(true); // Force it to remain unselected
        }});
        if(currQuestionIdx == 0) previousButton.setVisible(false);
        if(currQuestionIdx == questionBank.getQuestions().size()-1)nextButton.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void setAdmin(Admin admin){this.admin = admin;}
    public Admin getAdmin() {return admin;}
    public void setQuestionBank(QuestionBank questionBank){this.questionBank = questionBank;}
    public QuestionBank getQuestionBank(){return questionBank;}
    public void setCurrQuestionIdx(int currQuestionIdx){this.currQuestionIdx = currQuestionIdx;}
    public int getCurrQuestionIdx(){return currQuestionIdx;}
    public String formatQuestionStatement(String statement) {
        StringBuilder formatted = new StringBuilder();
        int prev = 0;
        for (int i = 78; i < statement.length(); i += 78) {
            int j = i;
            while (j > prev && statement.charAt(j) != ' ') {
                j--;
            }
            if (j == prev) j = i; 
            formatted.append(statement, prev, j).append("\n");
            prev = j + 1;
        }
        if (prev < statement.length()) {
            formatted.append(statement.substring(prev));
        }
        return formatted.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        counter = new javax.swing.JLabel();
        aButton = new javax.swing.JRadioButton();
        cButton = new javax.swing.JRadioButton();
        bButton = new javax.swing.JRadioButton();
        dButton = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        questionStatementTA = new javax.swing.JTextArea();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 250), new java.awt.Dimension(0, 250), new java.awt.Dimension(32767, 250));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        questionNavList = new javax.swing.JComboBox<>();
        counter1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 250, 206));
        setPreferredSize(new java.awt.Dimension(800, 700));
        setLayout(new java.awt.GridBagLayout());

        counter.setBackground(new java.awt.Color(255, 250, 206));
        counter.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        counter.setForeground(new java.awt.Color(0, 0, 0));
        counter.setText("Question "+(currQuestionIdx+1)+":");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(counter, gridBagConstraints);

        aButton.setBackground(new java.awt.Color(255, 250, 206));
        aButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        aButton.setForeground(new java.awt.Color(0, 0, 0));
        aButton.setText("A. Choice A");
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(aButton, gridBagConstraints);

        cButton.setBackground(new java.awt.Color(255, 250, 206));
        cButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cButton.setForeground(new java.awt.Color(0, 0, 0));
        cButton.setText("A. Choice A");
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(cButton, gridBagConstraints);

        bButton.setBackground(new java.awt.Color(255, 250, 206));
        bButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        bButton.setForeground(new java.awt.Color(0, 0, 0));
        bButton.setText("A. Choice A");
        bButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(bButton, gridBagConstraints);

        dButton.setBackground(new java.awt.Color(255, 250, 206));
        dButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        dButton.setForeground(new java.awt.Color(0, 0, 0));
        dButton.setText("A. Choice A");
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(dButton, gridBagConstraints);

        nextButton.setBackground(new java.awt.Color(74, 25, 72));
        nextButton.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(244, 242, 226));
        nextButton.setText("Next  >");
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(nextButton, gridBagConstraints);

        previousButton.setBackground(new java.awt.Color(74, 25, 72));
        previousButton.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        previousButton.setForeground(new java.awt.Color(244, 242, 226));
        previousButton.setText("< Previous");
        previousButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previousButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previousButtonMouseExited(evt);
            }
        });
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(previousButton, gridBagConstraints);

        deleteButton.setBackground(new java.awt.Color(74, 25, 72));
        deleteButton.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(244, 242, 226));
        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 62;
        gridBagConstraints.ipady = 27;
        add(deleteButton, gridBagConstraints);

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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(backButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        add(filler12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        add(filler13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        add(filler14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        add(filler4, gridBagConstraints);

        jScrollPane1.setBackground(new java.awt.Color(255, 250, 206));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N

        questionStatementTA.setBackground(new java.awt.Color(74, 25, 72));
        questionStatementTA.setColumns(20);
        questionStatementTA.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        questionStatementTA.setForeground(new java.awt.Color(244, 242, 226));
        questionStatementTA.setRows(5);
        questionStatementTA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 5, true));
        jScrollPane1.setViewportView(questionStatementTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 0);
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(filler7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        add(filler5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        add(filler6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        add(filler8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        add(filler9, gridBagConstraints);

        questionNavList.setBackground(new java.awt.Color(255, 255, 255));
        questionNavList.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        questionNavList.setForeground(new java.awt.Color(0, 0, 0));
        questionNavList.setModel(new javax.swing.DefaultComboBoxModel<>(navList));
        questionNavList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 25, 72), 5, true));
        questionNavList.setRenderer(new javax.swing.DefaultListCellRenderer() {
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
    questionNavList.setRequestFocusEnabled(false);
    questionNavList.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            questionNavListItemStateChanged(evt);
        }
    });
    questionNavList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            questionNavListActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.ipadx = 311;
    gridBagConstraints.ipady = 13;
    add(questionNavList, gridBagConstraints);

    counter1.setBackground(new java.awt.Color(255, 250, 206));
    counter1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
    counter1.setForeground(new java.awt.Color(0, 0, 0));
    counter1.setText((currQuestionIdx+1)+"/"+(questionBank.getQuestions().size()));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.gridwidth = 6;
    add(counter1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bButtonActionPerformed

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseEntered
        // TODO add your handling code here:
        nextButton.setBackground(Color.decode("#F4F2E2"));
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        nextButton.setBorderPainted(true);
        nextButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_nextButtonMouseEntered

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseExited
        // TODO add your handling code here:
        nextButton.setBackground(Color.decode("#4A1948"));
        nextButton.setBorderPainted(false);
        nextButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_nextButtonMouseExited

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(container, "deleteQuestion2_Q"+(currQuestionIdx+2)); 
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(container, "deleteQuestion2_Q"+(currQuestionIdx)); 
    }//GEN-LAST:event_previousButtonActionPerformed

    private void previousButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousButtonMouseExited
        // TODO add your handling code here:
        previousButton.setBackground(Color.decode("#4A1948"));
        previousButton.setBorderPainted(false);
        previousButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_previousButtonMouseExited

    private void previousButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousButtonMouseEntered
        // TODO add your handling code here:
        previousButton.setBackground(Color.decode("#F4F2E2"));
        previousButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        previousButton.setBorderPainted(true);
        previousButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_previousButtonMouseEntered

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        // TODO add your handling code here:
        deleteButton.setBackground(Color.decode("#F4F2E2"));
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        deleteButton.setBorderPainted(true);
        deleteButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        // TODO add your handling code here:
        deleteButton.setBackground(Color.decode("#4A1948"));
        deleteButton.setBorderPainted(false);
        deleteButton.setForeground(Color.decode("#F4F2E2"));
    }//GEN-LAST:event_deleteButtonMouseExited

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
          container.add(new DeleteQuestionPanel3(cardLayout,container,questionBank,admin,currQuestionIdx), "deleteQuestion3");
          cardLayout.show(container, "deleteQuestion3"); 
    }//GEN-LAST:event_deleteButtonActionPerformed

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
        cardLayout.show(container, "deleteQuestion1");
    }//GEN-LAST:event_backButtonActionPerformed

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aButtonActionPerformed

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButtonActionPerformed

    private void questionNavListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionNavListActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_questionNavListActionPerformed

    private void questionNavListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_questionNavListItemStateChanged
        // TODO add your handling code here:
        cardLayout.show(container, "deleteQuestion2_Q"+(questionNavList.getSelectedIndex()+1));
    }//GEN-LAST:event_questionNavListItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aButton;
    private javax.swing.JRadioButton bButton;
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton cButton;
    private javax.swing.JLabel counter;
    private javax.swing.JLabel counter1;
    private javax.swing.JRadioButton dButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JComboBox<String> questionNavList;
    private javax.swing.JTextArea questionStatementTA;
    // End of variables declaration//GEN-END:variables
}
