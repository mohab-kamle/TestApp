package TestSystem;

import DataBaseManagment.QuestionBankDAO;
import EndUser.User;
import UserDefinedFunctionalities.CustomUUIDGenerator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author mohab
 */
public final class QuestionBank {

    private UUID bankID;
    private ArrayList<Question> questions;
    private User creator;
    private Category category;
    private LocalDate creationDate;

    public QuestionBank(User creator, Category category, LocalDate creationDate) {
        this.bankID = CustomUUIDGenerator.generateWithPrefix("QB");
        this.creator = creator;
        this.category = category;
        this.creationDate = creationDate;
    }

    public QuestionBank(User creator, Category category, LocalDate creationDate, ArrayList<Question> questions) {
        this(creator, category, creationDate);
        this.setQuestions(questions);
    }

    //setters
    public void setBankID(UUID bankID) {
        this.bankID = bankID;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    //getters
    public UUID getBankID() {
        return bankID;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public User getCreator() {
        return creator;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //methods
    public void addQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the statement of your question : ");
        String statement = sc.nextLine();

        int key;
        Question.dlevel levelInput = null;
        do {
            System.out.println("Enter the difficulty : ");
            System.out.println("1 _ EASY");
            System.out.println("2 _ MEDIUM");
            System.out.println("3 _ HARD");
            key = sc.nextInt();
            switch (key) {
                case 1 ->
                    levelInput = Question.dlevel.EASY;
                case 2 ->
                    levelInput = Question.dlevel.MEDIUM;
                case 3 ->
                    levelInput = Question.dlevel.HARD;
                default -> {
                    System.out.println("Wrong input try again");
                    key = -1;
                }
            }
        } while (key == -1);

        // Clear the buffer
        sc.nextLine();

        // Get the four choices
        String[] choices = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter choice " + (char) ('A' + i) + ": ");
            choices[i] = sc.nextLine();
        }

        // Get the correct answer as a letter and validate
        int correctAnswer;
        while (true) {
            System.out.println("Enter the correct answer (A/B/C/D): ");
            String answer = sc.nextLine().toUpperCase();

            if (answer.length() != 1 || answer.charAt(0) < 'A' || answer.charAt(0) > 'D') {
                System.out.println("Invalid input! Please enter A, B, C, or D.");
                continue;
            }

            // Convert letter to index (A=0, B=1, C=2, D=3)
            correctAnswer = answer.charAt(0) - 'A';
            break;
        }

        Question question = new Question(this.category, statement, levelInput, correctAnswer, choices);
        QuestionBankDAO QBDB = new QuestionBankDAO();
        QBDB.addQuestionToBank(getBankID(), question);
    }

    public boolean updateQuestion(Question oldQ, Question newQ) {

        return false;
    }

    public void removeQuestion(Question question) {
        try {
            QuestionBankDAO QBDB = new QuestionBankDAO();
            QBDB.removeQuestionFromBank(getBankID(), question.getQuestionID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the question is removed");
    }

    public ArrayList<Question> searchQuestionsByKeyword() {
        return null;
    }

    public void exportQuestions() {

    }

    public Question getQuestionByID() {
        return null;
    }

    public ArrayList<Question> getQuestionsByDifficulty() {
        return null;
    }

    public int getQuestionCount() {
        return 0;
    }
}