package TestSystem;
import UserDefinedFunctionalities.CustomUUIDGenerator;
import java.util.UUID;
/**
 *
 * @author mohab
 */
public class Question {
    /**
     * the enumeration specifying the difficulty of the question upon certain criteria
     * determined by the creator or the individual responsible for adding question
     */
    public enum dlevel {
        EASY,MEDIUM,HARD;
    }
    private UUID questionID;
    private Category topic;
    private String statement;
    private int numberOfFavorites;
    private double totalTime;
    private dlevel difficulty;
    private int rightAnswer;
    private String[] choices;
    private int noOfAttemptsAtTests;
    
    public Question(Category topic, String statement,dlevel difficulty, int rightAnswer, String[] choices) {
        
        this.questionID = CustomUUIDGenerator.generateWithPrefix("Q");
        this.topic = topic;
        this.statement = statement;
        this.difficulty = difficulty;
        this.rightAnswer = rightAnswer;
        this.choices = choices;
        this.totalTime = 0;
        this.numberOfFavorites = 0;
        this.noOfAttemptsAtTests = 0;
    }
    
    
    //setters
    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    public void setTopic(Category topic) {
        this.topic = topic;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setNumberOfFavorites(int numberOfFavorites) {
        this.numberOfFavorites = numberOfFavorites;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public void setDifficulty(dlevel difficulty) {
        this.difficulty = difficulty;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public void setNoOfAttemptsAtTests(int noOfAttemptsAtTests) {
        this.noOfAttemptsAtTests = noOfAttemptsAtTests;
    }
    
    //getters
    public UUID getQuestionID() {
        return questionID;
    }

    public Category getTopic() {
        return topic;
    }

    public String getStatement() {
        return statement;
    }

    public int getNumberOfFavorites() {
        return numberOfFavorites;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public dlevel getDifficulty() {
        return difficulty;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getNoOfAttemptsAtTests() {
        return noOfAttemptsAtTests;
    }
    //methods
    /**
     * unique for each question and
     * useful in determining the difficulty of question
     * @return double : the average time per question approximated to minutes 
     */
    public double getAvgTime(){
        return (getTotalTime()/getNoOfAttemptsAtTests());
    }
}