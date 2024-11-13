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
    public UUID getCategoryId() {
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
    /**
     * Adds a new question bank to the current object's list of question banks.
     *
     * This method takes a `QuestionBank` object and adds it to the existing list of question banks associated with the current object. After adding the new question bank, it updates the category in the database using the `CategoryDAO` class.
     *
     * @param questionBank the `QuestionBank` object to be added to the list of question banks.
     */
    public void addQuestionBank(QuestionBank questionBank) {
        CategoryDAO CBD = new CategoryDAO();
        ArrayList<QuestionBank> currentQBs = this.getQuestionBanks();
        currentQBs.add(questionBank);
        this.setQuestionBanks(currentQBs);
        CBD.updateCategory(this);
    }

    /**
     * Removes a specified question bank from the current object's list of question banks.
     *
     * This method takes a `QuestionBank` object and removes it from the existing list of question banks associated with the current object. After removing the question bank, it updates the category in the database using the `CategoryDAO` class.
     *
     * @param questionBank the `QuestionBank` object to be removed from the list of question banks.
     */
    public void removeQuestionBank(QuestionBank questionBank) {
        CategoryDAO CBD = new CategoryDAO();
        ArrayList<QuestionBank> currentQBs = this.getQuestionBanks();
        currentQBs.remove(questionBank);
        this.setQuestionBanks(currentQBs);
        CBD.updateCategory(this);
    }

    /**
     * Compares this category object with the specified category object for equality.
     *
     * This method checks if the provided `Category` object is equal to the current category instance by comparing their category IDs. If the category IDs are the same, the method returns true; otherwise, it returns false.
     *
     * @param obj the `Category` object to be compared with this category.
     * @return true if the category IDs are equal, false otherwise.
     * @throws NullPointerException if the provided category object is null.
     */
    public boolean equals(Category obj) {
        return getCategoryId().equals(obj.getCategoryId());
    }
}
