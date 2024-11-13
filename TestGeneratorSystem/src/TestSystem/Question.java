package TestSystem;
import DataBaseManagment.CategoryDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private UUID topic;
    private String statement;
    private int numberOfFavorites;
    private double totalTime;
    private dlevel difficulty;
    private int rightAnswer;
    private String[] choices;
    private int noOfAttemptsAtTests;

    public Question() {
    }
    
    
    public Question(UUID topic, String statement,dlevel difficulty, int rightAnswer, String[] choices) {
        
        this.questionID = UUID.randomUUID();
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

    public void setTopic(UUID topic) {
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

    public UUID getTopic() {
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

    @Override
    public String toString() {
        CategoryDAO CDB = new CategoryDAO();
        String[] c = getChoices();
        return "Q"+getQuestionID()
          +"\n Question : "+getStatement()
          +"\n Choices  : "
          +"A _ "+c[0]
          +"B _ "+c[1]
          +"C _ "+c[2]
          +"D _ "+c[3]
          +"Category : "+CDB.loadCategory(topic).getName()
          +"Average Time to solve : "+getAvgTime()
          +"\n Right Answer : "+c[getRightAnswer()];
          
    }
    
    /**
     * unique for each question and
     * useful in determining the difficulty of question
     * @return double : the average time per question approximated to minutes 
     */
    @JsonIgnore
    public double getAvgTime(){
        return (getTotalTime()/getNoOfAttemptsAtTests());
    }
}
