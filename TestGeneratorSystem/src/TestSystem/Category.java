package TestSystem;

import DataBaseManagment.CategoryDAO;
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

    // Default no-argument constructor required for deseriealization
    public Category() {
    }

    public Category(String name, String description, LocalDate creationDate, Admin creator) {
        this.categoryID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.creator = creator;
        this.questionBanks = new ArrayList<>();
    }

    // Setters
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

    // Getters
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

    // Methods
    public void addQuestionBank(QuestionBank questionBank) {        
        CategoryDAO CBD = new CategoryDAO();
        ArrayList<QuestionBank> currentQBs = this.getQuestionBanks();
        currentQBs.add(questionBank);
        this.setQuestionBanks(currentQBs);
        CBD.updateCategory(this);
    }

    public void removeQuestionBank(QuestionBank questionBank) {
        CategoryDAO CBD = new CategoryDAO();
        ArrayList<QuestionBank> currentQBs = this.getQuestionBanks();
        currentQBs.remove(questionBank);
        this.setQuestionBanks(currentQBs);
        CBD.updateCategory(this);
    }

    public boolean equals(Category obj) {
        return getCategoryId().equals(obj.getCategoryId());
    }
}
