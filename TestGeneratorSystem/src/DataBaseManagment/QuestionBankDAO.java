package DataBaseManagment;

import EndUser.Admin;
import EndUser.Student;
import TestSystem.Category;
import TestSystem.Question;
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

/**
 *
 * @author mohab
 */

public class QuestionBankDAO {
    private static final String FILE_PATH = "database/questionbank.json";
    private final ObjectMapper mapper;

    public QuestionBankDAO() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // For handling LocalDate
        ensureFileStructure();
        // Optional: configure to include type information
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private void ensureFileStructure() {
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                Files.write(Paths.get(FILE_PATH), "[]".getBytes());
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

    public void saveQuestionBank(QuestionBank questionBank) {
        AdminDAO ADB = new AdminDAO();
        StudentDAO SDB = new StudentDAO();
        CategoryDAO CDB = new CategoryDAO();
        Category updateCategory = CDB.loadCategory(questionBank.getCategoryID());
        ArrayList<QuestionBank> currentQBs = updateCategory.getQuestionBanks();
        currentQBs.removeIf(q -> q.getBankID().equals(questionBank.getBankID()));
        currentQBs.add(questionBank);
        updateCategory.setQuestionBanks(currentQBs);
        if(ADB.IsThisIdForAdmin(questionBank.getCreatorID())){
            CDB.updateCategory(updateCategory);
            Admin updateadmin = ADB.loadAdmin(questionBank.getCreatorID());
            currentQBs = updateadmin.getOwnedBanks();
            currentQBs.removeIf(q -> q.getBankID().equals(questionBank.getBankID()));
            currentQBs.add(questionBank);
            updateadmin.setOwnedBanks(currentQBs);
        }else{
            Student updatestudent = SDB.loadStudent(questionBank.getCreatorID());
            currentQBs = updatestudent.getFavoriteQuestions();
            currentQBs.removeIf(q -> q.getBankID().equals(questionBank.getBankID()));
            currentQBs.add(questionBank);
            updatestudent.setFavoriteQuestions(currentQBs);
        }
        List<QuestionBank> banks = getQuestionBanksList();
        if (banks == null) {
            banks = new ArrayList<>();
        }
        for (QuestionBank bank : banks) {
            if(bank.getBankID().equals(questionBank.getBankID())){
                updateQuestionBank(questionBank);
                return;
            }
        }
        banks.add(questionBank);
        saveQuestionBanksList(banks);
    }

    public boolean updateQuestionBank(QuestionBank updatedBank) {
        CategoryDAO CDB = new CategoryDAO();
        Category updateCategory = CDB.loadCategory(updatedBank.getCategoryID());
        ArrayList<QuestionBank> currentQBs = updateCategory.getQuestionBanks();
        currentQBs.removeIf(q -> q.getBankID().equals(updatedBank.getBankID()));
        currentQBs.add(updatedBank);
        updateCategory.setQuestionBanks(currentQBs);
        AdminDAO ADB = new AdminDAO();
        StudentDAO SDB = new StudentDAO();
        if(ADB.IsThisIdForAdmin(updatedBank.getCreatorID())){        
            CDB.updateCategory(updateCategory);
            Admin updateadmin = ADB.loadAdmin(updatedBank.getCreatorID());
            currentQBs = updateadmin.getOwnedBanks();
            currentQBs.removeIf(q -> q.getBankID().equals(updatedBank.getBankID()));
            currentQBs.add(updatedBank);
            updateadmin.setOwnedBanks(currentQBs);
        }else{
            Student updatestudent = SDB.loadStudent(updatedBank.getCreatorID());
            currentQBs = updatestudent.getFavoriteQuestions();
            currentQBs.removeIf(q -> q.getBankID().equals(updatedBank.getBankID()));
            currentQBs.add(updatedBank);
            updatestudent.setFavoriteQuestions(currentQBs);
        }
        
        List<QuestionBank> banks = getQuestionBanksList();
        if (banks != null) {
            for (int i = 0; i < banks.size(); i++) {
                if (banks.get(i).getBankID().equals(updatedBank.getBankID())) {
                    banks.set(i, updatedBank);
                    break;
                }
            }
            saveQuestionBanksList(banks);
        }
        return true;
    }

    public QuestionBank loadQuestionBank(UUID bankId) {
        List<QuestionBank> banks = getQuestionBanksList();
        if (banks != null) {
            for (QuestionBank bank : banks) {
                if (bank.getBankID().equals(bankId)) {
                    return bank;
                }
            }
        }
        return null;
    }

    public List<QuestionBank> searchByCategory(Category category) {
        List<QuestionBank> banks = getQuestionBanksList();
        List<QuestionBank> matchingBanks = new ArrayList<>();
        if (banks != null) {
            for (QuestionBank bank : banks) {
                if (bank.getCategoryID().equals(category.getCategoryId())) {
                    matchingBanks.add(bank);
                }
            }
        }
        return matchingBanks;
    }
    public List<QuestionBank> searchByCategoryAndCreator(Category category,UUID creator) {
        List<QuestionBank> banks = getQuestionBanksList();
        List<QuestionBank> matchingBanks = new ArrayList<>();
        if (banks != null) {
            for (QuestionBank bank : banks) {
                if (bank.getCategoryID().equals(category.getCategoryId())&&bank.getCreatorID().equals(creator)) {
                    matchingBanks.add(bank);
                }
            }
        }
        return matchingBanks;
    }
    public List<QuestionBank> searchByCreator(UUID creatorId) {
        List<QuestionBank> banks = getQuestionBanksList();
        List<QuestionBank> matchingBanks = new ArrayList<>();
        if (banks != null) {
            for (QuestionBank bank : banks) {
                if (bank.getCreatorID().equals(creatorId)) {
                    matchingBanks.add(bank);
                }
            }
        }
        return matchingBanks;
    }

    public List<Question> getAllQuestionsFromBank(UUID bankId) {
        QuestionBank bank = loadQuestionBank(bankId);
        return bank != null ? bank.getQuestions() : new ArrayList<>();
    }

    public List<QuestionBank> getQuestionBanksList() {
        List<QuestionBank> banks = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            banks = mapper.readValue(content, new TypeReference<List<QuestionBank>>() {});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return banks;
    }

    public void deleteQuestionBank(UUID bankId) {
        List<QuestionBank> banks = getQuestionBanksList();
        AdminDAO ADB = new AdminDAO();
        Admin updateadmin= ADB.loadAdmin(loadQuestionBank(bankId).getCreatorID());
        ArrayList<QuestionBank> currentQBanks = updateadmin.getOwnedBanks();
        if (currentQBanks != null) {
            currentQBanks.removeIf(bank -> bank.getBankID().equals(bankId));
            updateadmin.setOwnedBanks(currentQBanks);
            ADB.updateAdmin(updateadmin);
            saveQuestionBanksList(banks);
        }
        if (banks != null) {
            banks.removeIf(bank -> bank.getBankID().equals(bankId));
            saveQuestionBanksList(banks);
        }
    }

    private void saveQuestionBanksList(List<QuestionBank> banks) {
        try {
            String jsonString = mapper.writeValueAsString(banks);
            Files.write(Paths.get(FILE_PATH), jsonString.getBytes(), 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Additional utility methods
    public boolean addQuestionToBank(UUID bankId, Question question) {
        QuestionBank bank = loadQuestionBank(bankId);
        if (bank != null) {
            ArrayList<Question> questions = bank.getQuestions();
            if (questions == null) {
                questions = new ArrayList<>();
            }
            questions.add(question);
            bank.setQuestions(questions);
            updateQuestionBank(bank);
        }
        return true;
    }

    public void removeQuestionFromBank(UUID bankId, UUID questionId) {
        QuestionBank bank = loadQuestionBank(bankId);
        if (bank != null && bank.getQuestions() != null) {
            bank.getQuestions().removeIf(q -> q.getQuestionID().equals(questionId));
            updateQuestionBank(bank);
        }
    }
}