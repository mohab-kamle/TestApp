package EndUser;

import DataBaseManagment.AdminDAO;
import TestSystem.QuestionBank;
import UserDefinedFunctionalities.Checker;
import java.io.Console;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author mohab 
 */
public class Admin extends User {

    private LocalDate dateAppointed;
    private String contactNumber;
    private String department;
    private ArrayList<QuestionBank> ownedBanks;
    
    public Admin() {
        super(null, null, null, null, null, null);
    }

    public Admin(LocalDate dateAppointed,
            String contactNumber,
            String department,
            ArrayList<String> commonList) {
        super(commonList.get(1),
                commonList.get(0),
                commonList.get(2),
                commonList.get(5),
                commonList.get(3),
                commonList.get(4));
        this.dateAppointed = dateAppointed;
        this.contactNumber = contactNumber;
        this.department = department;
        this.ownedBanks = new ArrayList<>();
    }
    //setters
    public void setDateAppointed(LocalDate dateAppointed) {
        this.dateAppointed = dateAppointed;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOwnedBanks(ArrayList<QuestionBank> ownedBanks) {
        this.ownedBanks = ownedBanks;
    }
    //getters
    public LocalDate getDateAppointed() {
        return dateAppointed;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<QuestionBank> getOwnedBanks() {
        return ownedBanks;
    }
    //methods
    
   /**
    * checks if the given password is equal to the password of the admin
    * ensures better security than accessing the getpassword directly from outside
    * the class
    * @param password String of the given password
    * @return boolean if equal or not
    */
    public boolean verifyPassword(String password) {
        return password!=null&&this.getPassword().equals(password);
    }
    
    //return null if not found in the database
    //reads the password securely
    @Override
    public Admin login(){
        Scanner scan = new Scanner(System.in);
        AdminDAO ADB = new AdminDAO();
        System.out.println("\nEnter Username : ");
        String userNameInput = scan.nextLine();
        String passwordInput;
        Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
            }
            char[] passwordArray = console.readPassword("\nEnter Password: ");
            passwordInput = new String(passwordArray);
        return ADB.searchAdmin(userNameInput, passwordInput);
    }

    @Override
    public StringBuffer getProfile(boolean show) {

        StringBuffer ProfileStr = super.getProfile(show);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ProfileStr.append("\nDepartment : ").append(getDepartment());
        ProfileStr.append("\nContact Number : ").append(getContactNumber());
        ProfileStr.append("\nJoin Date : ").append(getDateAppointed().format(formatter));
        if (show) {
            System.out.println("\nDepartment : " + getDepartment());
            System.out.println("\nContact Number : " + getContactNumber());
            System.out.println("\nJoin Date : " + getDateAppointed().format(formatter));
        }
        return ProfileStr;
    }

    @Override
    protected void printUpdateMenu() {
        super.printUpdateMenu(); // Print the basic menu options
        System.out.println(" 5 --> Update Contact Number");
        System.out.println(" 6 --> Update Department");
    }

    public void updateProfile() {
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        int choice;
        do {
            System.out.println("|--->    Update Profile Page     <---|");
            System.out.println("|---Select what you want to update---|");
            printUpdateMenu();
            
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1, 2, 3, 4 -> super.updateProfile(choice); // Handle basic updates
                    case 5 -> updateContactNumber(check, sc); // Handle admin-specific updates
                    case 6 -> updateDepartment(check, sc); // Handle admin-specific updates
                    case -1 -> System.out.println("Returning to previous menu...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }
        } while (choice != -1);
    }
    
    @Override
    public void removeAccount(){
        try {
            AdminDAO ADB = new AdminDAO();
            ADB.deleteAdmin(this.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the account is removed");
    }
    /**
     * sign up method for the admin to add the specific fields
     * @return ArrayList for all the data stored during the signup process 
     */
    public static ArrayList signUp() {
        ArrayList commonList = User.signUp();
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();//data validation object
        AdminDAO AdminDB = new AdminDAO();//database accessor object
        String ContactNumber;
        do {
            System.out.println("\nEnter Contact Number : ");
            ContactNumber = scanner.nextLine();
            if (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber)) {
                System.out.println("Invalid Phone Number\ntry again with this format +Countrycode 123456789");
            }
        } while (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber));
        String Department;
        do {
            System.out.println("\nEnter department : ");
            Department = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, Department)) {
                System.out.println("Invalid Department name.Should contain letters only");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, Department));
        LocalDate accountCreationDate = LocalDate.now();
        Admin CreatedAdmin = new Admin(
                accountCreationDate,
                ContactNumber,
                Department,
                commonList);
        AdminDB.saveAdmin(CreatedAdmin);
        return commonList;
    }
    
    
            
    public boolean createCategory() {
        return false;
    }

    public boolean modifyCategory() {
        return false;
    }

    public boolean deleteCategory() {
        return false;
    }

    public boolean addQuestionToQuestionBank() {
        return false;
    }

    public boolean updateQuestioninQuestionBank() {
        return false;
    }

    public boolean deleteQuestionFromQuestionBank() {
        return false;
    }
    // Private helper methods
    private void updateDepartment(Checker check, Scanner sc) {
        AdminDAO ADB = new AdminDAO();
        String Department;
        do {
            System.out.println("\nEnter department : ");
            Department = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, Department)) {
                System.out.println("Invalid Department name.Should contain letters only");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, Department));
        this.setDepartment(Department);
        ADB.updateAdmin(this);
        System.out.println("Department updated successfully!");
    }
    
    private void updateContactNumber(Checker check, Scanner sc) {
        AdminDAO ADB = new AdminDAO();
        String ContactNumber;
        do {
            System.out.println("\nEnter Contact Number : ");
            ContactNumber = sc.nextLine();
            if (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber)) {
                System.out.println("Invalid Phone Number\ntry again with this format +Countrycode 123456789");
            }
        } while (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber));
        this.setContactNumber(ContactNumber);
        ADB.updateAdmin(this);
        System.out.println("Contact Number updated successfully!");
    }

    
}
