package TestSystem;

import EndUser.Student;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author mohab
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "@type"
)
public class Test {
    private UUID testID;
    private Category category;
    private LocalDate creationDate;
    private Student taker;
    private int duration; //in minutes
    private int testResult;//why int ?
    private final static double passingScore = 60;
    private Question.dlevel difficulty;
    private ArrayList<Question> questions;
    private LocalDateTime startTime;
    private LocalDateTime endTime;// need to be aware of the technique of calculating it
    private int noOfAttempts;
    private ArrayList<Integer> takerAnswers;


    public Test(Category category, LocalDate creationDate, Student taker, Question.dlevel difficulty, ArrayList<Question> questions) {
        this.testID = UUID.randomUUID();
        this.category = category;
        this.creationDate = creationDate;
        this.taker = taker;
        this.difficulty = difficulty;
        this.questions = questions;
        this.noOfAttempts = 0;
        this.takerAnswers = new ArrayList<>(); }
    
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

    public static double getPassingScore() {
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
        return 0;
    }
    
    public List<Question> getRandomQuestions(int numQuestions) {
    if (questions == null || questions.size() < numQuestions) {
        return Collections.emptyList();
    }
    List<Question> shuffledQuestions = new ArrayList<>(questions);
    Collections.shuffle(shuffledQuestions);
    return shuffledQuestions.subList(0, numQuestions);
    }
    
    public void reset(){
        this.testResult = 0;
        this.noOfAttempts = 0;
        this.takerAnswers.clear();
        this.startTime = null;
        this.endTime = null;
    }
    
    public boolean checkAnswers(List<Integer> correctAnswers) {
    if (takerAnswers.size() != correctAnswers.size()) {
        return false;
    }
    for (int i = 0; i < takerAnswers.size(); i++) {
        if (!takerAnswers.get(i).equals(correctAnswers.get(i))) {
            return false;
        }
    }
    return true;
    }
    
    public void addAnswer(int answer){
        takerAnswers.add(answer);
    }
    
    public void removeAnswer(int index){
        if (index >= 0 && index < takerAnswers.size()) {
            takerAnswers.remove(index);
        }
    }
    
    public double timeTaken(){
      if (startTime == null || endTime == null) {
          return 0;
      }
      Duration tDuration = Duration.between(startTime, endTime);
      return tDuration.toMinutes() + tDuration.toSecondsPart() / 60.0;
    }
    
}
