package TestSystem;

import EndUser.Admin;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author mohab
 */
public class Category {
    private UUID categoryID;
    private String name;
    private String description;
    private LocalDate creationDate;
    private Admin creator;
    private ArrayList<QuestionBank> questionBanks;
    
    //setters

    public void setCategoryId(UUID categoryId) {
        this.categoryID = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreator(Admin creator) {
        this.creator = creator;
    }

    public void setQuestionBanks(ArrayList<QuestionBank> questionBanks) {
        this.questionBanks = questionBanks;
    }

    //getters
    
    public UUID getCategoryId(){    
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Admin getCreator() {
        return creator;
    }

    
    public ArrayList<QuestionBank> getQuestionBanks() {    
        return questionBanks;
    }

    //methods
    public void addQuestionBank() {
        //the logic
    }
    public void removeQuestionBank(){
        //the logic
    }
}
