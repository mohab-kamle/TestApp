package EndUser;

/**
 *
 * @author Youssef
 */
import DataBaseManagment.CategoryDAO;
import DataBaseManagment.QuestionBankDAO;
import DataBaseManagment.StudentDAO;
import TestSystem.Category;
import TestSystem.Question;
import TestSystem.QuestionBank;
import TestSystem.Test;
import UserDefinedFunctionalities.Checker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Console;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Student extends User {

    private String grade;
    private int passedTestsCount;
    private double totalTimeOfAllTests;
    private String institute;
    private List<Question> favoriteQuestions;
    private List<Test> takenTests;

    public Student() {
        super(null, null, null, null, null, null);
    }

    public Student(
            String institute,
            ArrayList<String> commonList) {
        super(commonList.get(1),
                commonList.get(0),
                commonList.get(2),
                commonList.get(5),
                commonList.get(3),
                commonList.get(4));
        this.institute = institute;
        this.favoriteQuestions = new ArrayList<>();
        this.takenTests = new ArrayList<>();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(double avg) {
        if (avg >= 97 && avg <= 100) {
            this.grade = "A+";
        } else if (avg >= 93 && avg < 97) {
            this.grade = "A";
        } else if (avg >= 90 && avg < 93) {
            this.grade = "A-";
        } else if (avg >= 87 && avg < 90) {
            this.grade = "B+";
        } else if (avg >= 83 && avg < 87) {
            this.grade = "B";
        } else if (avg >= 80 && avg < 83) {
            this.grade = "B-";
        } else if (avg >= 77 && avg < 80) {
            this.grade = "C+";
        } else if (avg >= 73 && avg < 77) {
            this.grade = "C";
        } else if (avg >= 70 && avg < 73) {
            this.grade = "C-";
        } else if (avg >= 67 && avg < 70) {
            this.grade = "D+";
        } else if (avg >= 63 && avg < 67) {
            this.grade = "D";
        } else if (avg >= 60 && avg < 63) {
            this.grade = "D-";
        } else if (avg >= 0 && avg < 60) {
            this.grade = "F";
        } else {
            this.grade = "Invalid Grade";
        }
    }

    public int getPassedTestsCount() {
        return passedTestsCount;
    }

    public void setPassedTestsCount(int passedTestsCount) {
        this.passedTestsCount = passedTestsCount;
    }

    public double getTotalTimeOfAllTests() {
        return totalTimeOfAllTests;
    }

    public void setTotalTimeOfAllTests(double totalTimeOfAllTests) {
        this.totalTimeOfAllTests = totalTimeOfAllTests;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public List<Question> getFavoriteQuestions() {
        return favoriteQuestions;
    }

    public void setFavoriteQuestions(List<Question> favoriteQuestions) {
        this.favoriteQuestions = favoriteQuestions;
    }

    public List<Test> getTakenTests() {
        return takenTests;
    }

    public void setTakenTests(List<Test> takenTests) {
        this.takenTests = takenTests;
    }
//methods 

    /**
     * Facilitates the sign-up process for a new student by gathering user details and validating the input.
     *
     * This method prompts the user to enter their institute name after collecting common user details through the User class's sign-up method. It validates the institute name to ensure it contains only letters. Upon successful validation, it creates a new Student instance with the provided details and saves the student data to the database using the StudentDAO. Finally, it returns a list of common user details.
     *
     * @return an ArrayList containing common user details collected during the sign-up process.
     */
    public static ArrayList<String> signUp() {
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker(); // data validation object

        // Gather common user details
        ArrayList<String> commonList = User.signUp();

        // Validate and gather student-specific details
        String institute;
        do {
            System.out.println("\nEnter Institute: ");
            institute = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, institute)) {
                System.out.println("Invalid Institute name. It should contain letters only.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, institute));

        // Create the new student instance
        Student newStudent = new Student(institute, commonList);
        // Persist the student data
        StudentDAO SDB = new StudentDAO();
        SDB.saveStudent(newStudent);
        return commonList;
    }

    /**
     * Handles the login process for a student by collecting their username and password.
     *
     * This method prompts the user to enter their username and password. It uses the `Console` class to securely read the password input. If the console is not available, it notifies the user. After gathering the credentials, it calls the `searchStudent` method of the `StudentDAO` class to authenticate the student and retrieve their information. The method returns a `Student` object if the login is successful, or null if authentication fails.
     *
     * @return a Student object representing the authenticated student, or null if login fails.
     */
    @Override
    public Student login() {
        Scanner scan = new Scanner(System.in);
        StudentDAO SDB = new StudentDAO();
        System.out.print("\nEnter Username : ");
        String userNameInput = scan.nextLine();
        String passwordInput;
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
        }
        char[] passwordArray = console.readPassword("\nEnter Password: ");
        passwordInput = new String(passwordArray);
        return SDB.searchStudent(userNameInput, passwordInput);
    }

    /**
     * Removes the student's account from the system.
     *
     * This method attempts to delete the student's account by calling the `deleteStudent` method of the `StudentDAO` class, using the student's unique user ID. If an exception occurs during the deletion process, it catches the exception and prints the error message. Regardless of success or failure, it prints a confirmation message indicating that the account removal process has been initiated.
     *
     * Note: The actual deletion of the account may fail if there are issues with the database or if the user ID is invalid. The confirmation message does not guarantee that the account has been successfully removed.
     */
    @Override
    public void removeAccount() {
        try {
            StudentDAO SDB = new StudentDAO();
            SDB.deleteStudent(this.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the account is removed");
    }

    /**
     * Retrieves and optionally displays the student's extended profile information.
     *
     * This method extends the base user profile by adding student-specific details: - Academic grade - Institute - Test performance metrics - Favorite questions - Taken tests
     *
     * @param show A Boolean flag to control console output - true: Prints detailed profile to console - false: Generates profile string without displaying
     *
     * @return A comprehensive string representation of the student's profile
     *
     * @implNote - Inherits base profile information from parent class - Appends student-specific attributes - Supports conditional display of profile details
     */
    @Override
    public String getProfile(boolean show) {

        StringBuffer ProfileStr = new StringBuffer(super.getProfile(show));
        ProfileStr.append("\nGrade : ").append(getGrade());
        ProfileStr.append("\ninstitute : ").append(getInstitute());
        ProfileStr.append("\npassedTestsCount : ").append(getPassedTestsCount());
        ProfileStr.append("\ntotalTimeOfAllTests : ").append(getTotalTimeOfAllTests());
        ProfileStr.append("\nfavoriteQuestions : ");
        if (!getFavoriteQuestions().isEmpty()) {
            for (Question question : getFavoriteQuestions()) {
                ProfileStr.append("\n - ").append(question);
            }
        }
        if (!getTakenTests().isEmpty()) {
            for (Test test : getTakenTests()) {
                ProfileStr.append("\n - ").append(test);
            }
        }

        if (show) {
            System.out.println("\nGrade : " + getGrade());
            System.out.println("\ninstitute : " + getInstitute());
            System.out.println("\npassedTestsCount : " + getPassedTestsCount());
            System.out.println("\ntotalTimeOfAllTests : " + getTotalTimeOfAllTests());
            System.out.println("\nFavorite Questions: ");
            if (!getFavoriteQuestions().isEmpty()) {
                for (Question question : getFavoriteQuestions()) {
                    System.out.println(" - " + question);
                }
            }
            if (!getTakenTests().isEmpty()) {
                System.out.println("\ntakenTests: ");
                for (Test test : getTakenTests()) {
                    System.out.println(" - " + test);
                }
            }

        }
        String Profile = new String(ProfileStr);
        return Profile;
    }

    /**
     * Prints the update menu options for the student, including additional options specific to the student role.
     *
     * This method overrides the base class's `printUpdateMenu` method to extend the menu options available to the student. It first calls the superclass's implementation to display the standard update options, and then adds an additional option for updating the student's institute. This allows students to easily access the functionality to update their institute information.
     */
    @Override
    protected void printUpdateMenu() {
        super.printUpdateMenu(); // Print the basic menu options
        System.out.println(" 5 --> Update Institute");
    }

    /**
     * Allows the student to update their profile information.
     *
     * This method presents a menu to the student for updating various aspects of their profile, such as name, password, and institute. It uses a loop to continually prompt the user for their choice until they choose to return to the previous menu by entering -1. The method handles user input for updates and calls the appropriate methods based on the user's selection.
     *
     * The method includes error handling for invalid input types (e.g., non-integer values) and informs the user of any invalid choices. It also utilizes a `Checker` instance for validation purposes when updating the institute.
     *
     * @throws IOException if an input or output error occurs during the update process.
     */
    public void updateProfile() throws IOException {
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        int choice;
        do {
            System.out.println("|--->    Update Profile Page     <---|");
            System.out.println("|--- Select what you want to update ---|");
            printUpdateMenu();

            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1, 2, 3, 4 ->
                        super.updateProfile(choice); // Handle basic updates (e.g., name, password, etc.)
                    case 5 ->
                        updateInstitute(check, sc); // Handle student-specific update for institute
                    case -1 ->
                        System.out.println("Returning to previous menu...");
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }
        } while (choice != -1);
    }

    /**
     * Updates the student's institute information.
     *
     * This method prompts the user to enter a new institute name and validates the input to ensure it contains letters only. It utilizes a `Checker` instance to perform the validation. The method continues to prompt the user until a valid institute name is provided. Once a valid name is entered, it updates the student's institute and persists the change to the database using the `StudentDAO` class.
     *
     * After successfully updating the institute, it prints a confirmation message to the user.
     *
     * @param check an instance of the `Checker` class used for input validation.
     * @param sc an instance of `Scanner` for reading user input.
     */
    private void updateInstitute(Checker check, Scanner sc) {
        String newInstitute;
        StudentDAO SDB = new StudentDAO();
        do {
            System.out.println("Enter new Institute: ");
            newInstitute = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newInstitute)) {
                System.out.println("Invalid Institute name. It should contain letters only.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newInstitute));

        setInstitute(newInstitute);
        SDB.updateStudent(this);
        System.out.println("Institute updated successfully to: " + newInstitute);
    }

    /**
     * Facilitates the process of taking a test by the student.
     *
     * This method allows the student to select a category, difficulty level, and the number of questions for the test. It retrieves available questions from the database, shuffles them, and presents them to the student one by one. The method tracks the time taken for each question and updates the relevant statistics, including the student's score and average time per question.
     *
     * The process includes the following steps: 1. Fetches the list of available categories. If none are available, it exits the method. 2. Prompts the user to select a category and validates the selection. 3. Prompts the user to select a difficulty level and the number of questions. 4. Retrieves questions matching the selected category and difficulty. 5. Shuffles the available questions and selects the required number. 6. Initiates the test, displaying questions and collecting answers while tracking the time taken for each question. 7. Calculates the total score, percentage score, and average time taken per question. 8. Updates the student's grade and test statistics. 9. Displays the test results to the student.
     *
     * This method provides a comprehensive testing experience, including real-time feedback and performance metrics.
     */
    public void takeTest() {
        Scanner scanner = new Scanner(System.in);
        QuestionBankDAO questionBankDAO = new QuestionBankDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        // Category Selection
        List<Category> categories = categoryDAO.getCategoriesList();
        if (categories.isEmpty()) {
            System.out.println("No categories available. Cannot create a test.");
            return;
        }

        // Display and Select Category
        System.out.println("Select a Category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }

        Category selectedCategory = selectCategory(scanner, categories);
        if (selectedCategory == null) {
            return;
        }

        // Difficulty Selection
        Question.dlevel difficulty = selectDifficulty(scanner);

        // Number of Questions Selection
        int numQuestions = selectNumberOfQuestions(scanner);

        // Find questions matching category and difficulty
        List<Question> availableQuestions = findQuestionsForTest(questionBankDAO, selectedCategory, difficulty);

        if (availableQuestions.size() < numQuestions) {
            System.out.println("Not enough questions available. Available: " + availableQuestions.size());
            return;
        }

        // Shuffle and select questions
        Collections.shuffle(availableQuestions);
        List<Question> testQuestions = availableQuestions.subList(0, numQuestions);

        // Create Test
        Test test = new Test(
                selectedCategory,
                LocalDate.now(),
                this,
                difficulty,
                new ArrayList<>(testQuestions)
        );

        // Reset test
        test.reset();

        // Start Test
        System.out.println("--- Test Started ---");
        System.out.println("Category: " + selectedCategory.getName());
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Number of Questions: " + numQuestions);

        // Take the test with time tracking
        List<Integer> correctAnswers = new ArrayList<>();
        List<Double> questionTimes = new ArrayList<>();

        for (int i = 0; i < testQuestions.size(); i++) {
            Question currentQuestion = testQuestions.get(i);

            // Display question details
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(currentQuestion.getStatement());

            // Display choices
            String[] choices = currentQuestion.getChoices();
            for (int j = 0; j < choices.length; j++) {
                System.out.println((char) ('A' + j) + ". " + choices[j]);
            }

            // Start time for this question
            LocalDateTime questionStartTime = LocalDateTime.now();

            // Get student's answer
            int studentAnswer = getStudentAnswer(scanner, currentQuestion);

            // Calculate time taken for this question
            LocalDateTime questionEndTime = LocalDateTime.now();
            double questionTimeTaken = calculateQuestionTime(questionStartTime, questionEndTime);
            questionTimes.add(questionTimeTaken);

            // Update question's total time and attempts
            updateQuestionMetrics(currentQuestion, questionTimeTaken);

            // Add answer to test
            test.addAnswer(studentAnswer);
            correctAnswers.add(currentQuestion.getRightAnswer());
        }

        // Calculate total test metrics
        double totalTestTime = questionTimes.stream().mapToDouble(Double::doubleValue).sum();
        double averageTimePerQuestion = totalTestTime / numQuestions;

        // Calculate score
        int score = calculateScore(test.getTakerAnswers(), correctAnswers);
        double percentageScore = (double) score / numQuestions * 100;

        // Set grade based on score
        setGrade(percentageScore);

        // Update test and student statistics
        updateTestStatistics(test, score, totalTestTime);

        // Display results
        displayTestResults(score, numQuestions, percentageScore, totalTestTime, averageTimePerQuestion);
    }

    /**
     * Prompts the user to select a category from the provided list.
     *
     * This method displays the available categories and allows the user to input their choice by entering the corresponding category number. It validates the input to ensure it is a valid number within the range of available categories. If the input is invalid, it prompts the user to try again until a valid selection is made.
     *
     * @param scanner an instance of `Scanner` for reading user input.
     * @param categories a list of available categories to choose from.
     * @return the selected `Category` object if the input is valid; otherwise, the method continues to prompt the user until a valid selection is made.
     */
    private Category selectCategory(Scanner scanner, List<Category> categories) {
        while (true) {
            try {
                System.out.print("Enter category number: ");
                int categoryChoice = scanner.nextInt();
                if (categoryChoice > 0 && categoryChoice <= categories.size()) {
                    return categories.get(categoryChoice - 1);
                } else {
                    System.out.println("Invalid category number. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Prompts the user to select a difficulty level for the test.
     *
     * This method displays three difficulty levels (Easy, Medium, and Hard) and allows the user to input their choice by entering the corresponding number. It validates the input to ensure it is a valid number within the range of available difficulty levels. If the input is invalid, it prompts the user to try again until a valid selection is made.
     *
     * @param scanner an instance of `Scanner` for reading user input.
     * @return the selected `Question.dlevel` enum value representing the chosen difficulty level.
     */
    private Question.dlevel selectDifficulty(Scanner scanner) {
        System.out.println("Select Difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        while (true) {
            try {
                System.out.print("Enter difficulty number: ");
                int difficultyChoice = scanner.nextInt();
                if (difficultyChoice >= 1 && difficultyChoice <= 3) {
                    return Question.dlevel.values()[difficultyChoice - 1];
                } else {
                    System.out.println("Invalid difficulty. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Prompts the user to select the number of questions for the test.
     *
     * This method requests the user to input a number representing the desired number of questions for the test, which must be between 5 and 40. It validates the input to ensure that it falls within the specified range. If the input is invalid, the method prompts the user to try again until a valid number is provided.
     *
     * @param scanner an instance of `Scanner` for reading user input.
     * @return an integer representing the number of questions selected by the user, which will be between 5 and 40.
     */
    private int selectNumberOfQuestions(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter number of questions (5-40): ");
                int numQuestions = scanner.nextInt();
                if (numQuestions >= 5 && numQuestions <= 40) {
                    return numQuestions;
                } else {
                    System.out.println("Number of questions must be between 5 and 40.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Retrieves a list of questions for the test based on the specified category and difficulty level.
     *
     * This method searches through all question banks associated with the given category and compiles a list of questions that match the specified difficulty level. It utilizes the `QuestionBankDAO` to access the relevant question banks and aggregates the questions from each bank that meet the criteria.
     *
     * @param questionBankDAO an instance of `QuestionBankDAO` for accessing question banks.
     * @param category the `Category` object representing the category of questions to be retrieved.
     * @param difficulty the `Question.dlevel` enum value representing the desired difficulty level of the questions.
     * @return a list of `Question` objects that match the specified category and difficulty level. If no questions are found, an empty list is returned.
     */
    private List<Question> findQuestionsForTest(QuestionBankDAO questionBankDAO,
            Category category,
            Question.dlevel difficulty) {
        // Collect questions from all question banks for the given category and difficulty
        List<QuestionBank> categoryBanks = questionBankDAO.searchByCategory(category);
        List<Question> difficultQuestions = new ArrayList<>();

        for (QuestionBank bank : categoryBanks) {
            difficultQuestions.addAll(bank.getQuestionsByDifficulty(difficulty));
        }

        return difficultQuestions;
    }

    /**
     * Prompts the user to input their answer for the current question.
     *
     * This method requests the user to enter their answer as one of the options: A, B, C, or D. It validates the input to ensure that it consists of a single character within the specified range. If the input is invalid, the user is prompted to try again until a valid answer is provided.
     *
     * @param scanner an instance of `Scanner` for reading user input.
     * @param currentQuestion the `Question` object representing the current question being answered.
     * @return an integer representing the selected answer, where A is 0, B is 1, C is 2, and D is 3.
     */
    private int getStudentAnswer(Scanner scanner, Question currentQuestion) {
        while (true) {
            try {
                System.out.print("Your answer (A/B/C/D): ");
                String answerInput = scanner.next().toUpperCase();

                if (answerInput.length() == 1 && answerInput.charAt(0) >= 'A' && answerInput.charAt(0) <= 'D') {
                    return answerInput.charAt(0) - 'A';
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Calculates the time taken to answer a question based on the start and end timestamps.
     *
     * This method computes the duration between two `LocalDateTime` instances, representing the start and end times of answering a question. The duration is then converted from seconds to minutes and returned as a double value.
     *
     * @param startTime the `LocalDateTime` representing the time when the question was started.
     * @param endTime the `LocalDateTime` representing the time when the question was completed.
     * @return the time taken to answer the question in minutes, represented as a double.
     */

    private double calculateQuestionTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return duration.toSeconds() / 60.0; // Convert to minutes
    }

    /**
     * Updates the metrics for a given question based on the time taken to answer it.
     *
     * This method increments the number of attempts for the specified question and updates the total time spent on that question. It is used to track how many times the question has been attempted and the cumulative time taken to answer it, which can be useful for analyzing question difficulty and performance.
     *
     * @param question the `Question` object representing the question whose metrics are to be updated.
     * @param timeTaken the time taken to answer the question, in minutes, which will be added to the question's total time.
     */
    private void updateQuestionMetrics(Question question, double timeTaken) {
        // Increment number of attempts
        int currentAttempts = question.getNoOfAttemptsAtTests();
        question.setNoOfAttemptsAtTests(currentAttempts + 1);

        // Update total time
        double currentTotalTime = question.getTotalTime();
        question.setTotalTime(currentTotalTime + timeTaken); // Update average time per question
    }

    /**
     * Updates the statistics for a given test based on the score and total time taken.
     *
     * This method sets the result of the test, updates its duration, and tracks the test in a collection of taken tests. It also accumulates the total time of all tests taken and increments the count of passed tests if the score meets or exceeds the passing score defined for the test.
     *
     * @param test the `Test` object representing the test for which statistics are to be updated.
     * @param score the score achieved in the test, which will be recorded as the test result.
     * @param totalTestTime the total time taken to complete the test, which will be recorded as the duration of the test.
     */
    private void updateTestStatistics(Test test, int score, double totalTestTime) {
        test.setTestResult(score);
        test.setDuration((int) totalTestTime);
        takenTests.add(test);
        totalTimeOfAllTests += totalTestTime;

        if (score >= Test.getPassingScore()) {
            passedTestsCount++;
        }
    }

    /**
     * Displays the results of a test, including the score, percentage score, total time taken, average time per question, grade, and pass/fail status.
     *
     * This method formats and prints the test results to the console, providing a clear summary of the test performance. It includes the score achieved, the total number of questions, the percentage score, the total time taken to complete the test, and the average time spent per question.
     *
     * @param score the score achieved in the test, representing the number of correct answers.
     * @param numQuestions the total number of questions in the test.
     * @param percentageScore the score expressed as a percentage of the total possible score.
     * @param totalTestTime the total time taken to complete the test, in minutes.
     * @param averageTimePerQuestion the average time spent per question, in minutes.
     */
    private void displayTestResults(int score, int numQuestions, double percentageScore, double totalTestTime, double averageTimePerQuestion) {
        System.out.println("\n--- Test Results ---");
        System.out.println("Score: " + score + "/" + numQuestions);
        System.out.println("Percentage: " + String.format("%.2f", percentageScore) + "%");
        System.out.println("Total Time Taken: " + String.format("%.2f", totalTestTime) + " minutes");
        System.out.println("Average Time Per Question: " + String.format("%.2f", averageTimePerQuestion) + " minutes");
        System.out.println("Grade: " + getGrade());
        System.out.println("Status: " + (percentageScore >= Test.getPassingScore() ? "PASSED" : "FAILED"));
    }

    /**
     * Calculates the score for a student based on their answers compared to the correct answers.
     *
     * This method iterates through the list of student answers and the list of correct answers, incrementing the score for each correct match. The score is returned as the total number of correct answers.
     *
     * @param studentAnswers a list of integers representing the student's answers to the questions.
     * @param correctAnswers a list of integers representing the correct answers for the questions.
     * @return the total score, which is the count of correct answers provided by the student.
     * @throws IndexOutOfBoundsException if the lists of student answers and correct answers have different sizes.
     */

    private int calculateScore(List<Integer> studentAnswers, List<Integer> correctAnswers) {
        int score = 0;
        for (int i = 0; i < studentAnswers.size(); i++) {
            if (studentAnswers.get(i).equals(correctAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }

    /**
     * outputs all the taken tests till now
     */
    @JsonIgnore
    public void getTestHistory() {
        if (takenTests == null || takenTests.isEmpty()) {
            System.out.println("No test history available.");
            return;
        }

        // Sort tests from latest to oldest
        List<Test> sortedTests = new ArrayList<>(takenTests);
        sortedTests.sort((t1, t2) -> t2.getCreationDate().compareTo(t1.getCreationDate()));

        Scanner scanner = new Scanner(System.in);
        int currentIndex = 0;

        while (true) {
            // Display current test
            Test currentTest = sortedTests.get(currentIndex);
            displayTestDetails(currentTest, currentIndex, sortedTests.size());

            // Show navigation options
            System.out.println("\nNavigation:");
            System.out.println("P - Previous Test");
            System.out.println("N - Next Test");
            System.out.println("D - Detailed Question Breakdown");
            System.out.println("Q - Quit Test History");

            // Get user input
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "P":
                    // Move to previous test (wrap around if at first test)
                    currentIndex = (currentIndex - 1 + sortedTests.size()) % sortedTests.size();
                    break;
                case "N":
                    // Move to next test (wrap around if at last test)
                    currentIndex = (currentIndex + 1) % sortedTests.size();
                    break;
                case "D":
                    showDetailedQuestionBreakdown(currentTest);
                    break;
                case "Q":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays detailed information about a given test.
     *
     * This method prints out various details regarding the specified test, including: - Test ID - Creation date of the test - Category of the test - Difficulty level of the test - Score achieved by the user - Total number of questions in the test - Score percentage calculated based on the user's results - Duration of the test - Time taken to complete the test - Status indicating whether the user passed or failed the test - Current position in the test history (e.g., which test out of the total tests is being displayed)
     *
     * @param test The Test object containing details about the test to be displayed.
     * @param currentIndex The index of the current test in the history (0-based).
     * @param totalTests The total number of tests in the history.
     */
    private void displayTestDetails(Test test, int currentIndex, int totalTests) {
        System.out.println("\n--- Test Details ---");
        System.out.println("Test ID: " + test.getTestID());
        System.out.println("Date: " + test.getCreationDate());
        System.out.println("Category: " + test.getCategory().getName());
        System.out.println("Difficulty: " + test.getDifficulty());

        // Calculate score percentage
        int totalQuestions = test.getQuestions().size();
        double scorePercentage = (double) test.getTestResult() / totalQuestions * 100;

        System.out.println("Score: " + test.getTestResult() + "/" + totalQuestions);
        System.out.println("Percentage: " + String.format("%.2f", scorePercentage) + "%");
        System.out.println("Duration: " + test.getDuration() + " minutes");
        System.out.println("Time Taken: " + String.format("%.2f", test.timeTaken()) + " minutes");
        System.out.println("Status: "
                + (test.getTestResult() >= Test.getPassingScore() ? "PASSED" : "FAILED"));

        // Show current position in test history
        System.out.println("\nTest " + (currentIndex + 1) + " of " + totalTests);
    }

    /**
     * Displays a detailed breakdown of each question in a test, including the question statement, correct answer, the student's answer, and whether the student's answer was correct or incorrect.
     *
     * This method iterates through the questions of the provided test, printing out the details for each question along with the available answer choices. It provides a comprehensive view of the student's performance on each question, facilitating review and learning.
     *
     * @param test the `Test` object containing the questions and answers for which the breakdown is to be displayed.
     */
    private void showDetailedQuestionBreakdown(Test test) {
        System.out.println("\n--- Detailed Question Breakdown ---");

        List<Question> questions = test.getQuestions();
        List<Integer> takerAnswers = test.getTakerAnswers();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            int studentAnswer = takerAnswers.get(i);
            int correctAnswer = question.getRightAnswer();

            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println("Statement: " + question.getStatement());
            System.out.println("Correct Answer: " + (char) ('A' + correctAnswer));
            System.out.println("Your Answer: " + (char) ('A' + studentAnswer));
            System.out.println("Result: "
                    + (studentAnswer == correctAnswer ? "CORRECT" : "INCORRECT"));

            // Show choices for context
            String[] choices = question.getChoices();
            System.out.println("Choices:");
            for (int j = 0; j < choices.length; j++) {
                System.out.println((char) ('A' + j) + ". " + choices[j]);
            }
        }

        // Wait for user to continue
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

// Optional: Method to filter test history
    @JsonIgnore
    public List<Test> filterTestHistory(Predicate<Test> filterCriteria) {
        return takenTests.stream()
                .filter(filterCriteria)
                .collect(Collectors.toList());
    }

//filter methods (Extra features in the future)
    @JsonIgnore
    public List<Test> getTestsByCategory(Category category) {
        return filterTestHistory(test -> test.getCategory().equals(category));
    }

    /**
     * Retrieves a list of tests filtered by the specified difficulty level.
     *
     * This method uses a filtering mechanism to return only those tests from the test history that match the provided difficulty level. The difficulty level is specified using the `Question.dlevel` enumeration.
     *
     * @param difficulty the difficulty level of the tests to be retrieved, represented by the `Question.dlevel` enumeration.
     * @return a list of `Test` objects that match the specified difficulty level.
     */
    @JsonIgnore
    public List<Test> getTestsByDifficulty(Question.dlevel difficulty) {
        return filterTestHistory(test -> test.getDifficulty() == difficulty);
    }

    /**
     * Retrieves a list of tests that have been passed based on the defined passing score.
     *
     * This method filters the test history to return only those tests where the result meets or exceeds the passing score defined in the `Test` class. The method is annotated with `@JsonIgnore`, indicating that it should be ignored during JSON serialization.
     *
     * @return a list of `Test` objects that have been passed.
     */
    @JsonIgnore
    public List<Test> getPassedTests() {
        return filterTestHistory(test -> test.getTestResult() >= Test.getPassingScore());
    }

    /**
     * Calculates the average time taken for the tests that have been passed.
     *
     * This method returns the average time spent on tests that have been successfully passed. If no tests have been passed, the method returns 0. The average is calculated by dividing the total time of all passed tests by the count of passed tests.
     *
     * @return the average time taken for passed tests, or 0 if no tests have been passed.
     */
    @JsonIgnore

    public double getAvgTime() {
        if (passedTestsCount == 0) {
            return 0;
        }
        return totalTimeOfAllTests / passedTestsCount;
    }

    /**
     * Marks a specified question as a favorite.
     *
     * This method adds the provided question to the list of favorite questions, ensuring that duplicates are not added. If the question is already marked as a favorite, a message indicating that it is already a favorite will be printed.
     *
     * @param question the `Question` object to be marked as a favorite.
     */
    public void markFavouriteQuestion(Question question) {
        if (!favoriteQuestions.contains(question)) { // Avoid duplicates
            favoriteQuestions.add(question);
            System.out.println("Question marked as favorite: " + question);
        } else {
            System.out.println("Question is already marked as favorite.");
        }
    }

    /**
     * Calculates the average score of the tests that have been taken.
     *
     * This method iterates through the list of taken tests and sums their results. It then calculates the average score by dividing the total sum by the number of tests taken. If no tests have been taken, the method returns 0. The method is annotated with `@JsonIgnore`, indicating that it should be ignored during JSON serialization.
     *
     * @return the average score of the taken tests, or 0 if no tests have been taken.
     */
    @JsonIgnore
    public double getAverageScore() {
        double sum = 0;
        for (Test takenTest : getTakenTests()) {
            sum += takenTest.getTestResult();
        }
        if (!getTakenTests().isEmpty()) {
            return sum / getTakenTests().size();
        }

        return 0;
    }
}
