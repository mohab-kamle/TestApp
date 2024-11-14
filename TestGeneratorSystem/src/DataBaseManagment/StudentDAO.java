package DataBaseManagment;

import EndUser.Student;
import TestSystem.QuestionBank;
import TestSystem.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentDAO {

    private static final String FILE_PATH = "database/student.json";
    private final ObjectMapper mapper;

    public StudentDAO() {
    mapper = new ObjectMapper();
    // Configure Jackson
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    // Ensure file structure
    ensureFileStructure();
    }

    private void ensureFileStructure() {
        try {
            Path path = Paths.get(FILE_PATH);

            // Create parent directories if they don't exist
            Files.createDirectories(path.getParent());

            // Create file with empty array if not exists
            if (!Files.exists(path) || Files.size(path) == 0) {
                Files.write(path, "[]".getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE);
            }
        } catch (IOException e) {
            System.err.println("Error ensuring file structure: " + e.getMessage());
        }
    }

    public void saveStudent(Student student) {
        try {
            List<Student> students = getStudentsList();

            // Validate student
            if (student == null) {
                return;
            }

            // Ensure UUID exists
            if (student.getUserId() == null) {
                student.setUserId(UUID.randomUUID());
            }

            // Check for existing student
            boolean exists = students.stream()
                    .anyMatch(s
                            -> (s.getUserName() != null && s.getUserName().equals(student.getUserName()))
                    || (s.getEmail() != null && s.getEmail().equals(student.getEmail()))
                    );

            if (!exists) {
                students.add(student);
                saveStudentsList(students);
                System.out.println("Student saved successfully.");
            } else {
                System.out.println("Student already exists.");
            }
        } catch (Exception e) {
            System.err.println("Error saving student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsList() {
        try {
            Path path = Paths.get(FILE_PATH);

            // Validate file existence and content
            if (!Files.exists(path) || Files.size(path) == 0) {
                return new ArrayList<>();
            }

            // Read file content
            String content = new String(Files.readAllBytes(path));

            // Parse JSON with custom type reference
             List<Student> students = mapper.readValue(content,
                    new TypeReference<List<Student>>() {
            });

            return students != null ? students : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading students: " + e.getMessage());
            e.printStackTrace(); // Add this to get more detailed error information
            return new ArrayList<>();
        }
    }

    private void saveStudentsList(List<Student> students) {
        try {
            // Validate input
            if (students == null) {
                students = new ArrayList<>();
            }

            // Write with pretty printing and type information
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter()
                                    .withType(new TypeReference<List<Student>>() {});
            String jsonString = writer.writeValueAsString(students);
            Files.write(Paths.get(FILE_PATH),
                    jsonString.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error saving students list: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Student searchStudent(String username, String password) {
        return getStudentsList().stream()
                .filter(student
                        -> student.getUserName().equals(username)
                && student.verifyPassword(password))
                .findFirst()
                .orElse(null);
    }

    public void updateStudent(Student updatedStudent) {
        try {
            List<Student> students = getStudentsList();
            QuestionBankDAO QBDB = new QuestionBankDAO();
            for (QuestionBank questionBank : QBDB.getQuestionBanksList()) {
                if(questionBank.getCreatorID().equals(updatedStudent.getUserId())){      for (QuestionBank  qbank : updatedStudent.getFavoriteQuestions()) {
                       if(questionBank.getCategoryID().equals(qbank.getCategoryID())){
                         QBDB.updateQuestionBank(qbank);  
                       }
                        
                    }
                    
                }
            }
            // Find and replace student
            students = students.stream()
                    .map(student
                            -> student.getUserId().equals(updatedStudent.getUserId()) ? updatedStudent : student)
                    .collect(Collectors.toList());

            saveStudentsList(students);
//            System.out.println("Student updated successfully."); //for debugging
        } catch (Exception e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStudent(UUID studentId) {
        try {
            List<Student> students = getStudentsList();
            TestDAO TDB = new TestDAO();
            for (Test test : TDB.getTestsList()) {
                if(test.getTakerID().equals(studentId)){
                    TDB.deleteTest(test.getTakerID());
                }
            }
            // Remove student with matching ID
            int initialSize = students.size();
            students.removeIf(student -> student.getUserId().equals(studentId));

            if (students.size() < initialSize) {
                saveStudentsList(students);
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Student searchStudent(String username) {
        return getStudentsList().stream()
                .filter(student -> student.getUserName().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Student searchStudentByEmail(String email) {
        return getStudentsList().stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    // Additional methods specific to Student functionality
    public List<Student> searchStudentsByInstitute(String institute) {
        return getStudentsList().stream()
                .filter(student -> student.getInstitute().equalsIgnoreCase(institute))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsWithPassedTestsCount(int minPassedTests) {
        return getStudentsList().stream()
                .filter(student -> student.getPassedTestsCount() >= minPassedTests)
                .collect(Collectors.toList());
    }

    public double calculateAverageScoreForInstitute(String institute) {
        List<Student> students = searchStudentsByInstitute(institute);
        if (students.isEmpty()) {
            return 0;
        }
        return students.stream()
                .mapToDouble(Student::getAverageScore)
                .average()
                .orElse(0);
    }

    public double calculateAverageTimeForInstitute(String institute) {
        List<Student> students = searchStudentsByInstitute(institute);
        if (students.isEmpty()) {
            return 0;
        }
        return students.stream()
                .mapToDouble(Student::getAvgTime)
                .average()
                .orElse(0);
    }

    public Student loadStudent(UUID creatorID) {
        return getStudentsList().stream()
                .filter(student -> student.getUserId().equals(creatorID))
                .findFirst()
                .orElse(null);
    }
}
