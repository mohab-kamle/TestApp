package EndUser;

/**
 *
 * @author Youssef
 */
import DataBaseManagment.StudentDAO;
import UserDefinedFunctionalities.Checker;
import java.util.*;

public class Student extends User {

    private String grade;
    private int passedTestsCount;
    private double totalTimeOfAllTests;
    private String institute;
    private List<String> favoriteQuestions;
    private List<String> takenTests;
    private static ArrayList<Student> listOfStudents = new ArrayList<>();

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
    }

    

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public List<String> getFavoriteQuestions() {
        return favoriteQuestions;
    }

    public void setFavoriteQuestions(List<String> favoriteQuestions) {
        this.favoriteQuestions = favoriteQuestions;
    }

    public List<String> getTakenTests() {
        return takenTests;
    }

    public void setTakenTests(List<String> takenTests) {
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

        // Add new student to the list of students
        listOfStudents.add(newStudent);

        // Persist the student data
        StudentDAO adminDB = new StudentDAO();
        adminDB.saveStudent(newStudent);

        return commonList;
    }

    @Override
    public Student login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine(); // Authenticate the user
        Student authenticatedStudent = Student.authenticate(username, password);
        if (authenticatedStudent != null) {
            System.out.println("Login successful!");
            return authenticatedStudent;
        } else {
            System.out.println("Login failed. Please check your username and password.");
            return null;
        }
    }

    public static Student authenticate(String username, String password) {
        for (Student student : listOfStudents) {
            if (student.getUserName().equals(username) && student.getPassword().equals(password)) {
                return student;
            }

        }
        return null;
    }

    @Override
    public void removeAccount() {
        try {
            listOfStudents.remove(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the account is removed");
    }

    /**
     * Retrieves and optionally displays the student's extended profile information.
     *
     * This method extends the base user profile by adding student-specific details: - Academic grade - Institute - Test               performance metrics - Favorite questions - Taken tests
     *
     * @param show A Boolean flag to control console output - true: Prints detailed profile to console - false: Generates              profile string without displaying
     *
     * @return A comprehensive string representation of the student's profile
     *
     * @implNote - Inherits base profile information from parent class - Appends student-specific attributes - Supports                conditional display of profile details
     */
    @Override
    public String getProfile(boolean show) {

        StringBuffer ProfileStr = new StringBuffer(super.getProfile(show));
        ProfileStr.append("\nGrade : ").append(getGrade());
        ProfileStr.append("\ninstitute : ").append(getInstitute());
        ProfileStr.append("\npassedTestsCount : ").append(getPassedTestsCount());
        ProfileStr.append("\ntotalTimeOfAllTests : ").append(getTotalTimeOfAllTests());
        ProfileStr.append("\nfavoriteQuestions : ");
        for (String question : getFavoriteQuestions()) {
            ProfileStr.append("\n - ").append(question);
        }
        for (String test : getTakenTests()) {
            ProfileStr.append("\n - ").append(test);
        }
        if (show) {
            System.out.println("\nGrade : " + getGrade());
            System.out.println("\ninstitute : " + getInstitute());
            System.out.println("\npassedTestsCount : " + getPassedTestsCount());
            System.out.println("\ntotalTimeOfAllTests : " + getTotalTimeOfAllTests());
            System.out.println("\nFavorite Questions: ");
            for (String question : getFavoriteQuestions()) {
                System.out.println(" - " + question);
            }
            System.out.println("\ntakenTests: ");
            for (String test : getTakenTests()) {
                System.out.println(" - " + test);
            }
        }
        String Profile = new String(ProfileStr);
        return Profile;
    }

    public void updateProfile() {
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
        do {
            System.out.println("Enter new Institute: ");
            newInstitute = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newInstitute)) {
                System.out.println("Invalid Institute name. It should contain letters only.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newInstitute));

        setInstitute(newInstitute);
        System.out.println("Institute updated successfully to: " + newInstitute);
    }

    public void takeTest() {
        // Implement logic for taking a test
    }

    public List<String> getTestHistory() {
        return takenTests;
    }

    public double getAvgTime() {
        if (passedTestsCount == 0) {
            return 0;
        }
        return totalTimeOfAllTests / passedTestsCount;
    }

    public void markFavouriteQuestion(String question) {
        if (!favoriteQuestions.contains(question)) { // Avoid duplicates
            favoriteQuestions.add(question);
            System.out.println("Question marked as favorite: " + question);
        } else {
            System.out.println("Question is already marked as favorite.");
        }
    }

    public double getAverageScore() {
        // Implement logic to calculate average score
        return 0.0; // Placeholder value
    }
}
