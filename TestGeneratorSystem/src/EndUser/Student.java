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

    @Override
    protected void printUpdateMenu() {
        super.printUpdateMenu(); // Print the basic menu options
        System.out.println(" 5 --> Update Institute");
    }

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

    private double calculateQuestionTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return duration.toSeconds() / 60.0; // Convert to minutes
    }

    private void updateQuestionMetrics(Question question, double timeTaken) {
        // Increment number of attempts
        int currentAttempts = question.getNoOfAttemptsAtTests();
        question.setNoOfAttemptsAtTests(currentAttempts + 1);

        // Update total time
        double currentTotalTime = question.getTotalTime();
        question.setTotalTime(currentTotalTime + timeTaken); // Update average time per question
    }

    private void updateTestStatistics(Test test, int score, double totalTestTime) {
        test.setTestResult(score);
        test.setDuration((int) totalTestTime);
        takenTests.add(test);
        totalTimeOfAllTests += totalTestTime;

        if (score >= Test.getPassingScore()) {
            passedTestsCount++;
        }
    }

    private void displayTestResults(int score, int numQuestions, double percentageScore, double totalTestTime, double averageTimePerQuestion) {
        System.out.println("\n--- Test Results ---");
        System.out.println("Score: " + score + "/" + numQuestions);
        System.out.println("Percentage: " + String.format("%.2f", percentageScore) + "%");
        System.out.println("Total Time Taken: " + String.format("%.2f", totalTestTime) + " minutes");
        System.out.println("Average Time Per Question: " + String.format("%.2f", averageTimePerQuestion) + " minutes");
        System.out.println("Grade: " + getGrade());
        System.out.println("Status: " + (percentageScore >= Test.getPassingScore() ? "PASSED" : "FAILED"));
    }

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

    @JsonIgnore
    public List<Test> getTestsByDifficulty(Question.dlevel difficulty) {
        return filterTestHistory(test -> test.getDifficulty() == difficulty);
    }

    @JsonIgnore
    public List<Test> getPassedTests() {
        return filterTestHistory(test -> test.getTestResult() >= Test.getPassingScore());
    }

    @JsonIgnore
    public double getAvgTime() {
        if (passedTestsCount == 0) {
            return 0;
        }
        return totalTimeOfAllTests / passedTestsCount;
    }

    public void markFavouriteQuestion(Question question) {
        if (!favoriteQuestions.contains(question)) { // Avoid duplicates
            favoriteQuestions.add(question);
            System.out.println("Question marked as favorite: " + question);
        } else {
            System.out.println("Question is already marked as favorite.");
        }
    }

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
