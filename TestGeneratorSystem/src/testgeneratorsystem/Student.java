package testgeneratorsystem;
/**
 *
 * @author Youssef
 */
import java.util.*;


public class Student extends User{
    
    private String grade;
    private int passedTestsCount;
    private double totalTimeOfAllTests;
    private String institute;
    private List<String> favoriteQuestions;
    private List<String> takenTests;
    private static ArrayList<Student> listOfStudents = new ArrayList<>();

    public Student(
            String institute,
            String email,
            String userName,
            String password,
            String address,
            String firstName,
            String lastName,
            ArrayList<String> studentuser) {
        super(studentuser.get(1),
                studentuser.get(0),
                studentuser.get(2),
                studentuser.get(5),
                studentuser.get(3),
                studentuser.get(4));
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

    
    public void takeTest() {
        // Implement logic for taking a test
    }

    public List<String> getTestHistory() {
        return takenTests;
    }

    public double getAvgTime() {
        if (passedTestsCount == 0) return 0;
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
    @Override
    public void removeAccount(){
        try {
           listOfStudents.remove(this); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the account is removed");
    }
    @Override
    public Student login(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter username:");
    String username = scanner.nextLine();
    System.out.println("Enter password:");
    String password = scanner.nextLine(); // Authenticate the user
    Student authenticatedStudent = Student.authenticate(username, password);
    if (authenticatedStudent != null){
        System.out.println("Login successful!");
        return authenticatedStudent;
    }
    else
    { 
        System.out.println("Login failed. Please check your username and password.");
        return null;
    }
    }
    public static Student authenticate(String username, String password) {
        for (Student student : listOfStudents)
        { 
            if (student.getUserName().equals(username) && student.getPassword().equals(password))
            { return student;
        }

    }
        return null;
}
    public StringBuffer getProfile(boolean show) {

        StringBuffer ProfileStr = super.getProfile(show);
        ProfileStr.append("\nGrade : ").append(getGrade());
        ProfileStr.append("\ninstitute : ").append(getInstitute());
        ProfileStr.append("\npassedTestsCount : ").append(getPassedTestsCount());
        ProfileStr.append("\ntotalTimeOfAllTests : ").append(getTotalTimeOfAllTests());
        ProfileStr.append("\nfavoriteQuestions : ");
        for (String question : getFavoriteQuestions()) {
        ProfileStr.append("\n - ").append(question);}
        for (String test : getTakenTests()) {
        ProfileStr.append("\n - ").append(test);}
        if (show) {
            System.out.println("\nGrade : " + getGrade());
            System.out.println("\ninstitute : " + getInstitute());
            System.out.println("\npassedTestsCount : " + getPassedTestsCount());
            System.out.println("\ntotalTimeOfAllTests : " + getTotalTimeOfAllTests());
            System.out.println("\nFavorite Questions: ");
            for (String question : getFavoriteQuestions()) {
            System.out.println(" - " + question);}
            System.out.println("\ntakenTests: ");
            for (String test : getTakenTests()) {
            System.out.println(" - " + test);}
        }
        return ProfileStr;
    }
}

    

