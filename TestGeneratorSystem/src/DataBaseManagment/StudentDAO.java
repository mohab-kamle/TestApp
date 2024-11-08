package DataBaseManagment;

import EndUser.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentDAO {

    private static final String FILE_PATH = "database/student.json";
    private final ObjectMapper mapper;

    public StudentDAO() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        ensureFileStructure();
    }

    private void ensureFileStructure() {
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                Files.write(Paths.get(FILE_PATH), "[]".getBytes()); // Initialize with empty array
            } else {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                if (content.trim().isEmpty() || content.equals("null")) {
                    Files.write(Paths.get(FILE_PATH), "[]".getBytes()); // Initialize with empty array
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveStudent(Student student) {
        List<Student> students = getStudentsList();
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        saveStudentsList(students);
    }

    public void updateStudent(Student updatedStudent) {
        List<Student> students = getStudentsList();
        if (students != null) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getUserId().equals(updatedStudent.getUserId())) {
                    students.set(i, updatedStudent);
                    break;
                }
            }
            saveStudentsList(students);
        }
    }

    public Student loadStudent(UUID studentId) {
        List<Student> students = getStudentsList();
        if (students != null) {
            for (Student student : students) {
                if (student.getUserId().equals(studentId)) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student searchStudent(String username) {
        List<Student> students = getStudentsList();
        if (students != null) {
            for (Student student : students) {
                if (student.getUserName().equals(username)) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student searchStudent(String username, String password) {
        List<Student> students = getStudentsList();
        if (students != null) {
            for (Student student : students) {
                if (student.getUserName().equals(username) && student.getPassword().equals(password)) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student searchStudentByEmail(String email) {
        List<Student> students = getStudentsList();
        if (students != null) {
            for (Student student : students) {
                if (student.getEmail().equals(email)) {
                    return student;
                }
            }
        }
        return null;
    }

    public List<Student> getStudentsList() {
        List<Student> students = null;
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            students = mapper.readValue(content, new TypeReference<List<Student>>() {});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public void deleteStudent(UUID studentId) {
        List<Student> students = getStudentsList();
        if (students != null) {
            students.removeIf(student -> student.getUserId().equals(studentId));
            saveStudentsList(students);
        }
    }

    private void saveStudentsList(List<Student> students) {
        try {
            String jsonString = mapper.writeValueAsString(students);
            Files.write(Paths.get(FILE_PATH), jsonString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


