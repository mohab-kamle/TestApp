package DataBaseManagment;

import TestSystem.Category;
import TestSystem.QuestionBank;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryDAO {
    private static final String FILE_PATH = "database/category.json";
    private final ObjectMapper mapper;

    public CategoryDAO() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // For handling LocalDate
        ensureFileStructure();
        // Optional: configure to include type information
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private void ensureFileStructure() {
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                Files.write(Paths.get(FILE_PATH), "[]".getBytes()); // Initialize with empty array
            } else {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                if (content.trim().isEmpty() || content.equals("null")) {
                    Files.write(Paths.get(FILE_PATH), "[]".getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveCategory(Category category) {
        List<Category> categories = getCategoriesList();
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(category);
        saveCategoriesList(categories);
    }

    public void updateCategory(Category updatedCategory) {
        List<Category> categories = getCategoriesList();
        if (categories != null) {
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getCategoryId().equals(updatedCategory.getCategoryId())) {
                    categories.set(i, updatedCategory);
                    break;
                }
            }
            saveCategoriesList(categories);
        }
    }

    public Category loadCategory(UUID categoryId) {
        List<Category> categories = getCategoriesList();
        if (categories != null) {
            for (Category category : categories) {
                if (category.getCategoryId().equals(categoryId)) {
                    return category;
                }
            }
        }
        return null;
    }

    public Category searchCategoryByName(String name) {
        List<Category> categories = getCategoriesList();
        if (categories != null) {
            for (Category category : categories) {
                if (category.getName().equalsIgnoreCase(name)) {
                    return category;
                }
            }
        }
        return null;
    }

    public List<Category> searchCategoriesByCreator(UUID creatorId) {
        List<Category> categories = getCategoriesList();
        List<Category> creatorCategories = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories) {
                if (category.getCreator().getUserId().equals(creatorId)) {
                    creatorCategories.add(category);
                }
            }
        }
        return creatorCategories;
    }

    public List<Category> getCategoriesList() {
        List<Category> categories = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            categories = mapper.readValue(content, new TypeReference<List<Category>>() {});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public void deleteCategory(UUID categoryId) {
        List<Category> categories = getCategoriesList();
        if (categories != null) {
            categories.removeIf(category -> category.getCategoryId().equals(categoryId));
            saveCategoriesList(categories);
        }
    }

    public List<QuestionBank> getCategoryQuestionBanks(UUID categoryId) {
        Category category = loadCategory(categoryId);
        return category != null ? category.getQuestionBanks() : new ArrayList<>();
    }

    public void addQuestionBankToCategory(UUID categoryId, QuestionBank questionBank) {
        Category category = loadCategory(categoryId);
        if (category != null) {
            ArrayList<QuestionBank> questionBanks = category.getQuestionBanks();
            if (questionBanks == null) {
                questionBanks = new ArrayList<>();
            }
            questionBanks.add(questionBank);
            category.setQuestionBanks(questionBanks);
            updateCategory(category);
        }
    }

    public void removeQuestionBankFromCategory(UUID categoryId, UUID questionBankId) {
        Category category = loadCategory(categoryId);
        if (category != null && category.getQuestionBanks() != null) {
            category.getQuestionBanks().removeIf(qb -> qb.getBankID().equals(questionBankId));
            updateCategory(category);
        }
    }

    private void saveCategoriesList(List<Category> categories) {
        try {
            String jsonString = mapper.writeValueAsString(categories);
            Files.write(Paths.get(FILE_PATH), jsonString.getBytes(), 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}