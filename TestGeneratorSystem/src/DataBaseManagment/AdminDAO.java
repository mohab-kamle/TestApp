package DataBaseManagment;

import EndUser.Admin;
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

public class AdminDAO {

    private static final String FILE_PATH = "database/admin.json";
    private final ObjectMapper mapper;

    public AdminDAO() {
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

    public void saveAdmin(Admin admin) {
        List<Admin> admins = getAdminsList();
        if (admins == null) {
            admins = new ArrayList<>();
        }
        admins.add(admin);
        saveAdminsList(admins);
    }

    public void updateAdmin(Admin updatedAdmin) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).getUserId().equals(updatedAdmin.getUserId())) {
                    admins.set(i, updatedAdmin);
                    break;
                }
            }
            saveAdminsList(admins);
        }
    }

    public Admin loadAdmin(UUID adminId) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getUserId().equals(adminId)) {
                    return admin;
                }
            }
        }
        return null;
    }

    public Admin searchAdmin(String username) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getUserName().equals(username)) {
                    return admin;
                }
            }
        }
        return null;
    }

    public Admin searchAdmin(String username, String password) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getUserName().equals(username) && admin.verifyPassword(password)) {
                    return admin;
                }
            }
        }
        return null;
    }

    public Admin searchAdminByEmail(String email) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            for (Admin admin : admins) {
                if (admin.getEmail().equals(email)) {
                    return admin;
                }
            }
        }
        return null;
    }

    public List<Admin> getAdminsList() {
        List<Admin> admins = null;
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            admins = mapper.readValue(content, new TypeReference<List<Admin>>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return admins;
    }

    public void deleteAdmin(UUID adminId) {
        List<Admin> admins = getAdminsList();
        if (admins != null) {
            admins.removeIf(admin -> admin.getUserId().equals(adminId));
            saveAdminsList(admins);
        }
    }

    private void saveAdminsList(List<Admin> admins) {
        try {
            String jsonString = mapper.writeValueAsString(admins);
            Files.write(Paths.get(FILE_PATH), jsonString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
