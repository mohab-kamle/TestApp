package TestSystem;
import java.util.UUID;
/**
 *
 * @author mohab
 */
public class Question {
    public enum dlevel {
        EASY,MEDIUM,Hard;
    }
    private UUID questionID;
    private Category topic;
    private String statement;
    private int numberOfFavorites;//which is as number of likes on social media
    private double totalTime;
    private dlevel difficulty;
    private int rightAnswer;
    private String[] choices;
    private int noOfAttemptsAtTests;
    
    //setters
    public void setQuestionId(UUID questionId) {
        this.questionID = questionId;
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
    public UUID getQuestionId() {
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
    public double getAvgTime(){
        //implement the function
        return 0;
    }
}
