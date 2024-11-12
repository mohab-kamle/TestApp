package DataBaseManagment;

import EndUser.Admin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AdminDAO {

    private static final String FILE_PATH = "database/admin.json";
    private final ObjectMapper mapper;

    public AdminDAO() {
        mapper = new ObjectMapper();

        // Configure Jackson for robust parsing
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

    public void saveAdmin(Admin admin) {
        try {
            List<Admin> admins = getAdminsList();

            // Validate admin
            if (admin == null) {
                return;
            }

            // Ensure UUID exists
            if (admin.getUserId() == null) {
                admin.setUserId(UUID.randomUUID());
            }

            // Ensure date appointed is set
            if (admin.getDateAppointed() == null) {
                admin.setDateAppointed(LocalDate.now());
            }

            // Check for existing admin
            boolean exists = admins.stream()
                    .anyMatch(a
                            -> (a.getUserName() != null && a.getUserName().equals(admin.getUserName()))
                    || (a.getEmail() != null && a.getEmail().equals(admin.getEmail()))
                    );

            if (!exists) {
                admins.add(admin);
                saveAdminsList(admins);
                System.out.println("Admin saved successfully.");
            } else {
                System.out.println("Admin already exists.");
            }
        } catch (Exception e) {
            System.err.println("Error saving admin: " + e.getMessage());
        }
    }

    public void updateAdmin(Admin updatedAdmin) {
        try {
            List<Admin> admins = getAdminsList();

            // Find and replace admin
            admins = admins.stream()
                    .map(admin
                            -> admin.getUserId().equals(updatedAdmin.getUserId()) ? updatedAdmin : admin)
                    .collect(Collectors.toList());

            saveAdminsList(admins);
            System.out.println("Admin updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating admin: " + e.getMessage());
        }
    }

    public void deleteAdmin(UUID adminId) {
        try {
            List<Admin> admins = getAdminsList();

            // Remove admin with matching ID
            int initialSize = admins.size();
            admins.removeIf(admin -> admin.getUserId().equals(adminId));

            if (admins.size() < initialSize) {
                saveAdminsList(admins);
                System.out.println("Admin deleted successfully.");
            } else {
                System.out.println("No admin found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting admin: " + e.getMessage());
        }
    }

    public List<Admin> getAdminsList() {
        try {
            Path path = Paths.get(FILE_PATH);

            // Validate file existence and content
            if (!Files.exists(path) || Files.size(path) == 0) {
                return new ArrayList<>();
            }

            // Read file content
            String content = new String(Files.readAllBytes(path));

            // Parse JSON
            List<Admin> admins = mapper.readValue(content,
                    new TypeReference<List<Admin>>() {
            });

            return admins != null ? admins : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading admins: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void saveAdminsList(List<Admin> admins) {
        try {
            // Validate input
            if (admins == null) {
                admins = new ArrayList<>();
            }

            // Write with pretty printing
            String jsonString = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(admins);

            Files.write(Paths.get(FILE_PATH),
                    jsonString.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error saving admins list: " + e.getMessage());
        }
    }

    public Admin searchAdmin(String username, String password) {
        return getAdminsList().stream()
                .filter(admin
                        -> admin.getUserName().equals(username)
                && admin.verifyPassword(password))
                .findFirst()
                .orElse(null);
    }

    public Admin searchAdmin(String username) {
        return getAdminsList().stream()
                .filter(admin -> admin.getUserName().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Admin searchAdminByEmail(String email) {
        return getAdminsList().stream()
                .filter(admin -> admin.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    // Additional methods specific to Admin functionality
    public List<Admin> searchAdminsByDepartment(String department) {
        return getAdminsList().stream()
                .filter(admin -> admin.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Admin> getAdminsAppointedBetween(LocalDate startDate, LocalDate endDate) {
        return getAdminsList().stream()
                .filter(admin
                        -> !admin.getDateAppointed().isBefore(startDate)
                && !admin.getDateAppointed().isAfter(endDate))
                .collect(Collectors.toList());
    }

    public void updateAdminDepartment(UUID adminId, String newDepartment) {
        List<Admin> admins = getAdminsList();

        admins = admins.stream()
                .map(admin -> {
                    if (admin.getUserId().equals(adminId)) {
                        admin.setDepartment(newDepartment);
                    }
                    return admin;
                })
                .collect(Collectors.toList());
        saveAdminsList(admins);
        System.out.println("Admin department updated successfully.");
    }

    // Optional: Debugging method
    public void validateJsonFile() {
        try {
            Path path = Paths.get(FILE_PATH);

            System.out.println("File path: " + path.toAbsolutePath());
            System.out.println("File exists: " + Files.exists(path));

            if (Files.exists(path)) {
                long fileSize = Files.size(path);
                System.out.println("File size: " + fileSize + " bytes");

                // Read and print file contents
                String content = new String(Files.readAllBytes(path));
                System.out.println("File contents:");
                System.out.println(content);
            }
        } catch (IOException e) {
            System.err.println("Error validating JSON file: " + e.getMessage());
        }
    }
}
