package TestSystem;

import java.time.Duration;
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
    private UUID takerID;
    private int duration;
    private double testResult;
    private final static double passingScore = 60;
    private Question.dlevel difficulty;
    private ArrayList<Question> questions;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
//    private int noOfAttempts; //set for future updates
    private ArrayList<Integer> takerAnswers;

    public Test() {
    }

    public Test(Category category, LocalDate creationDate, UUID taker, Question.dlevel difficulty, ArrayList<Question> questions) {
        this.testID = UUID.randomUUID();
        this.category = category;
        this.creationDate = creationDate;
        this.takerID = taker;
        this.difficulty = difficulty;
        this.questions = questions;
        this.takerAnswers = new ArrayList<>();
    }

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

    public void setTakerID(UUID taker) {
        this.takerID = taker;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTestResult(double testResult) {
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

    public UUID getTakerID() {
        return takerID;
    }

    public int getDuration() {
        return duration;
    }

    public double getTestResult() {
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

    public ArrayList<Integer> getTakerAnswers() {
        return takerAnswers;
    }

    //methods
    public double timePerQuestion() {
        return 0;
    }

    /**
     * Retrieves a specified number of random questions from the available questions.
     *
     * This method first checks if the `questions` list is null or if it contains fewer questions than the requested number. If either condition is true, it returns an empty list.
     *
     * If the `questions` list is valid, it creates a copy of the list, shuffles it to randomize the order, and then returns a sublist containing the specified number of random questions.
     *
     * @param numQuestions The number of random questions to retrieve.
     * @return A list of randomly selected questions. If the requested number exceeds the available questions or if the questions list is null, an empty list is returned.
     */
    public List<Question> getRandomQuestions(int numQuestions) {
        if (questions == null || questions.size() < numQuestions) {
            return Collections.emptyList();
        }
        List<Question> shuffledQuestions = new ArrayList<>(questions);
        Collections.shuffle(shuffledQuestions);
        return shuffledQuestions.subList(0, numQuestions);
    }

    /**
     * Resets the state of the object to its initial values.
     *
     * This method resets the following attributes: - `testResult` is set to 0, indicating no results. - `noOfAttempts` is set to 0, indicating no attempts have been made. - `takerAnswers` is cleared, removing all previously recorded answers. - `startTime` and `endTime` are set to null, indicating that no timing information is currently available.
     *
     * This method is useful for reinitializing the object for a new test or session.
     */
    public void reset() {
        this.testResult = 0;
        this.takerAnswers.clear();
        this.startTime = null;
        this.endTime = null;
    }

    /**
     * Compares the answers provided by the test taker with the correct answers.
     *
     * This method checks if the number of answers submitted by the test taker matches the number of correct answers. If the sizes do not match, it returns false. If they do match, it iterates through both lists and compares each answer. If any answer does not match, it returns false. If all answers match, it returns true.
     *
     * @param correctAnswers A list of correct answers to compare against.
     * @return true if all answers from the test taker match the correct answers; false otherwise.
     */
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

    /**
     * Adds an answer to the list of answers.
     *
     * This method appends the specified answer to the `takerAnswers` list. It does not perform any checks to validate the answer before adding it. The answer is added to the end of the list.
     *
     * @param answer The answer to be added to the list.
     */
    public void addAnswer(int answer) {
        takerAnswers.add(answer);
    }

    /**
     * Removes an answer from the list of answers based on the specified index.
     *
     * This method checks if the provided index is within the valid range of the `takerAnswers` list. If the index is valid (i.e., it is non-negative and less than the size of the list), the answer at that index is removed from the list.
     *
     * If the index is out of bounds, no action is taken.
     *
     * @param index The index of the answer to be removed from the list.
     */
    public void removeAnswer(int index) {
        if (index >= 0 && index < takerAnswers.size()) {
            takerAnswers.remove(index);
        }
    }

    /**
     * Calculates the total time taken between the start and end times.
     *
     * This method computes the duration between the `startTime` and `endTime` attributes. If either `startTime` or `endTime` is null, the method returns 0, indicating that the time cannot be calculated.
     *
     * The duration is expressed in minutes, where the total minutes are calculated from the duration's minutes part and the seconds part is converted to minutes (by dividing by 60) and added to the total.
     *
     * @return The total time taken in minutes as a double. If either time is null, returns 0.
     */
    public double timeTaken() {
        if (startTime == null || endTime == null) {
            return 0;
        }
        Duration tDuration = Duration.between(startTime, endTime);
        return tDuration.toMinutes() + tDuration.toSecondsPart() / 60.0;
    }

    @Override
    public String toString() {
        return String.format("Test[Date=%s, Result=%.1f%%, Duration=%d min, Status=%s]",
                creationDate,
                testResult,
                duration,
                testResult >= passingScore ? "PASSED" : "FAILED");
    }

}
