package testgeneratorsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author mohab
 */
public class QuestionBank {
    private UUID bankID;
    private ArrayList<Question> questions;
    private User creator;
    private Category category;
    private LocalDate creationDate;
    
    //setters

    public void setBankID(UUID bankID) {
        this.bankID = bankID;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    
    //getters

    public UUID getBankID() {
        return bankID;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public User getCreator() {
        return creator;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
    
    //methods

    public void addQuestion(){
        
    }
    
    public boolean updateQuestion(){
        return false;
    }
    
    public void removeQuestion(){
        
    }
    
    public ArrayList<Question> searchQuestionsByKeyword(){
    return null;    
    }
    
    public void exportQuestions(){
        
    }
    
    public Question getQuestionByID(){
        return null;
    }
    
    public ArrayList<Question> getQuestionsByDifficulty(){
        return null;
    }
    
    public int getQuestionCount(){
        return 0;
    }
}
