package DataBaseManagment;

import EndUser.Student;
import TestSystem.Category;
import TestSystem.Question;
import TestSystem.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TestDAO {
    private static final String FILE_PATH = "database/tests.json";
    private final ObjectMapper mapper;

    public TestDAO() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // For handling LocalDate and LocalDateTime
        ensureFileStructure();
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
            System.err.println("Error ensuring file structure: " + e.getMessage());
        }
    }

    public void saveTest(Test test) {
        List<Test> tests = getTestsList();
        if (tests == null) {
            tests = new ArrayList<>();
        }
        tests.add(test);
        saveTestsList(tests);
    }

    public void updateTest(Test updatedTest) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            for (int i = 0; i < tests.size(); i++) {
                if (tests.get(i).getTestID().equals(updatedTest.getTestID())) {
                    tests.set(i, updatedTest);
                    break;
                }
            }
            saveTestsList(tests);
        }
    }

    public Test loadTest(UUID testId) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getTestID().equals(testId))
                .findFirst()
                .orElse(null);
        }
        return null;
    }

    public List<Test> getTestsList() {
        List<Test> tests = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            tests = mapper.readValue(content, new TypeReference<List<Test>>() {});
        } catch (IOException e) {
            System.err.println("Error reading tests: " + e.getMessage());
        }
        return tests;
    }

    private void saveTestsList(List<Test> tests) {
        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tests);
            Files.write(Paths.get(FILE_PATH), 
                jsonString.getBytes(), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error saving tests list: " + e.getMessage());
        }
    }

    public void deleteTest(UUID testId) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            tests.removeIf(test -> test.getTestID().equals(testId));
            saveTestsList(tests);
        }
    }

    // Search and filter methods
    public List<Test> searchTestsByStudent(Student student) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getTaker().equals(student))
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Test> searchTestsByCategory(Category category) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getCategory().equals(category))
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Test> searchTestsByDifficulty(Question.dlevel difficulty) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getDifficulty() == difficulty)
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Test> searchTestsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> 
                    !test.getCreationDate().isBefore(startDate) && 
                    !test.getCreationDate().isAfter(endDate))
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Test> getPassedTests() {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getTestResult() >= Test.getPassingScore())
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Test> getFailedTests() {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> test.getTestResult() < Test.getPassingScore())
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    // Advanced search methods
    public List<Test> searchTestsByStudentAndCategory(Student student, Category category) {
        List<Test> tests = getTestsList();
        if (tests != null) {
            return tests.stream()
                .filter(test -> 
                    test.getTaker().equals(student) && 
                    test.getCategory().equals(category))
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public Test getLatestTestByStudent(Student student) {
        List<Test> studentTests = searchTestsByStudent(student);
        return studentTests.stream()
            .max((t1, t2) -> t1.getCreationDate().compareTo(t2.getCreationDate()))
            .orElse(null);
    }
}