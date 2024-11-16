package TestSystem;

import DataBaseManagment.QuestionBankDAO;
import static TestSystem.TestGeneratorApp.ifColorfullPrintln;
import UserDefinedFunctionalities.TerminalColors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private UUID creatorID;
    private UUID categoryID;
    private LocalDate creationDate;

    public QuestionBank() {
    }

    public QuestionBank(UUID creator, UUID category, LocalDate creationDate) {
        this.bankID = UUID.randomUUID();
        this.creatorID = creator;
        this.categoryID = category;
        this.creationDate = creationDate;
        this.questions = new ArrayList<>();
    }

    public QuestionBank(UUID creator, UUID category, LocalDate creationDate, ArrayList<Question> questions) {
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

    public void setCreatorID(UUID creatorID) {
        this.creatorID = creatorID;
    }

    public void setCategory(UUID category) {
        this.categoryID = category;
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

    public UUID getCreatorID() {
        return creatorID;
    }

    public UUID getCategoryID() {
        return categoryID;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //methods
    /**
     * Adds a new question to the question bank.
     *
     * This method prompts the user to enter the statement of a question, select its difficulty level, provide four answer choices, and specify the correct answer. The question is then created and added to the question bank.
     *
     * The difficulty level can be selected from the following options: 1 - EASY 2 - MEDIUM 3 - HARD
     *
     * The user must also provide four choices (A, B, C, D) for the question and specify which one is the correct answer. The input is validated to ensure that the correct answer is one of the provided choices.
     *
     * The method utilizes the Scanner class to read user input from the console. It handles invalid inputs by prompting the user to re-enter values until valid inputs are provided.
     *
     * After gathering all necessary information, the method creates a new Question object and adds it to the question bank using the QuestionBankDAO class.
     *
     * Note: This method assumes that the categoryID and getBankID() methods/fields are defined elsewhere in the class.
     */
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

        Question question = new Question(this.categoryID, statement, levelInput, correctAnswer, choices);
        QuestionBankDAO QBDB = new QuestionBankDAO();
        QBDB.addQuestionToBank(getBankID(), question);
    }

    /**
     * Removes a specified question from the question bank.
     *
     * This method takes a Question object as an argument and attempts to remove it from the current list of questions. It retrieves the current list of questions, removes the specified question, and then updates the question list accordingly.
     *
     * After removing the question from the local list, the method also calls the QuestionBankDAO to remove the question from the persistent storage (database or file) using the question's unique identifier (questionID).
     *
     * If an error occurs during the removal process (e.g., the question is not found), the method catches the exception and prints the error message to the console.
     *
     * A confirmation message is printed to the console indicating that the question has been successfully removed, regardless of whether an exception was thrown or not.
     *
     * @param question The Question object to be removed from the question bank.
     */
    public void removeQuestion(Question question) {
        try {
            ArrayList<Question> currentQs = this.getQuestions();
            currentQs.remove(question);
            this.setQuestions(currentQs);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            QBDB.removeQuestionFromBank(getBankID(), question.getQuestionID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the question is removed");
    }
    // search by keyword at specific QeustionBank then back all question contain this word
    public ArrayList<Question> searchQuestionsByKeyword(String string) {
        ArrayList<Question> SearchedQ = this.getQuestions();
        for (Question question : questions) {
        if (question.getStatement().toLowerCase().contains(string.toLowerCase())) {
            SearchedQ.add(question);
        }
    }
        return SearchedQ;
    }


    /**
     * Exports the list of questions to a specified file.
     *
     * This method prompts the user to enter a file path where the questions will be exported. It checks if the provided path is valid and if the user has the necessary permissions to write to that location. If the path is valid, it proceeds to create a new file (or overwrite an existing one) and writes the list of questions to it.
     *
     * The questions are written in a structured format, with a header ("=== Start of List ===") at the beginning and a footer ("=== End of List ===") at the end. If there are no questions to export, a message is displayed to inform the user.
     *
     * In case of any I/O exceptions during the file writing process, the method catches the exception and prints the error message to the console.
     *
     * If the provided path is invalid or the user lacks sufficient permissions, an error message is displayed in red.
     *
     */
    public void exportQuestions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String userInputPath = scanner.nextLine();
        Path path = Paths.get(userInputPath);
        if (isValidPath(path)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(userInputPath))) {
                if (getQuestionCount() == 0) {
                    ifColorfullPrintln("There are no questions to Export", TerminalColors.BOLD_RED);
                    return;
                }
                writer.println("=== Start of List ===");
                for (Question q : getQuestions()) {
                    writer.println(q);
                }
                writer.println("=== End of List ===");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            ifColorfullPrintln("Questions got exported to " + userInputPath, TerminalColors.BOLD_GREEN);
        } else {
            ifColorfullPrintln("Invalid path or insufficient permissions.", TerminalColors.BOLD_RED);
        }

    }

    /**
     * Retrieves a question from the question bank by its unique identifier.
     *
     * This method takes a UUID as an argument and searches through the current list of questions to find a match. If a question with the specified ID is found, it is returned. If no matching question is found, the method returns null.
     *
     * This method is useful for locating a specific question when its ID is known, allowing for operations such as updating, removing, or displaying the question.
     *
     * @param qUuid The unique identifier of the question to retrieve.
     * @return The Question object if found, or null if no question with the specified ID exists.
     */
    public Question getQuestionByID(UUID qUuid) {
        for (Question question : getQuestions()) {
            if (question.getQuestionID().equals(qUuid)) {
                return question;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of questions that match a specified difficulty level.
     *
     * This method takes a difficulty level (of type Question.dlevel) as an argument and iterates through the current list of questions. For each question, it checks if the difficulty level matches the specified difficulty. If a match is found, the question is added to a new list.
     *
     * The method returns an ArrayList containing all questions that have the specified difficulty level. If no questions match the difficulty, an empty list is returned.
     *
     * @param difficulty The difficulty level to filter questions by.
     * @return An ArrayList of Question objects that match the specified difficulty level.
     */
    public ArrayList<Question> getQuestionsByDifficulty(Question.dlevel difficulty) {
        ArrayList<Question> questionsWithCertainDifficulty = new ArrayList<>();
        for (Question question : getQuestions()) {
            if (question.getDifficulty().equals(difficulty)) {
                questionsWithCertainDifficulty.add(question);
            }
        }
        return questionsWithCertainDifficulty;
    }

    @JsonIgnore
    public int getQuestionCount() {
        return getQuestions().size();
    }

    /**
     * Checks whether a given path is valid for writing.
     *
     * This method verifies if the specified path exists and is a directory. It also checks whether the directory is writable by the current user.
     *
     * The method returns true if the path exists, is a directory, and is writable; otherwise, it returns false.
     *
     * @param path The Path object representing the directory to validate.
     * @return true if the path is valid (exists, is a directory, and writable), false otherwise.
     */
    private static boolean isValidPath(Path path) {
        // Check if the path exists and is a directory 
        if (Files.exists(path) && Files.isDirectory(path)) {
            // Check if the directory is writable 
            File file = path.toFile();
            return file.canWrite();
        }
        return false;
    }
}
