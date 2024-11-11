package TestSystem;

import EndUser.Student;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author mohab
 */
public class Test {
    private UUID testID;
    private Category category;
    private LocalDate creationDate;
    private Student taker;
    private int duration; //in minutes
    private int testResult;//why int ?
    private double passingScore;//why double ?
    private Question.dlevel difficulty;
    private ArrayList<Question> questions;
    private LocalDateTime startTime;
    private LocalDateTime endTime;// need to be aware of the technique of calculating it
    private int noOfAttempts;
    private ArrayList<Integer> takerAnswers;
    
    //setters

    public void setTestID(UUID testID) {
        this.testID = testID;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setTaker(Student taker) {
        this.taker = taker;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTestResult(int testResult) {
        this.testResult = testResult;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }

    public void setDifficulty(Question.dlevel difficulty) {
        this.difficulty = difficulty;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setNoOfAttempts(int noOfAttempts) {
        this.noOfAttempts = noOfAttempts;
    }

    public void setTakerAnswers(ArrayList<Integer> takerAnswers) {
        this.takerAnswers = takerAnswers;
    }
    
    //getters

    public UUID getTestID() {
        return testID;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Student getTaker() {
        return taker;
    }

    public int getDuration() {
        return duration;
    }

    public int getTestResult() {
        return testResult;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public Question.dlevel getDifficulty() {
        return difficulty;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getNoOfAttempts() {
        return noOfAttempts;
    }

    public ArrayList<Integer> getTakerAnswers() {
        return takerAnswers;
    }
    
    //methods
    
    public double timePerQuestion(){
        //implementation
        return 0;
    }
    
    public void getRandomQuestions(){
        
    }
    
    public void reset(){
        
    }
    
    public boolean checkAnswers(){
        //implementation
        return false;
    }
    
    public void addAnswer(){
        
    }
    
    public void removeAnswer(){
        
    }
    
    public double timeTaken(){
        //why return double ?
        //implementation
        return 0;
    }
    
}
