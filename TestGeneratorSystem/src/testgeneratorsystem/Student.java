package testgeneratorsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
import java.util.List;

public class Student {
    
    private String grade;
    private int passedTestsCount;
    private double totalTimeOfAllTests;
    private String institute;
    private List<String> favoriteQuestions;
    private List<String> takenTests;

    
    public Student(String grade, int passedTestsCount, double totalTimeOfAllTests, String institute, List<String> favoriteQuestions, List<String> takenTests) {
        this.grade = grade;
        this.passedTestsCount = passedTestsCount;
        this.totalTimeOfAllTests = totalTimeOfAllTests;
        this.institute = institute;
        this.favoriteQuestions = favoriteQuestions;
        this.takenTests = takenTests;
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
}

    

