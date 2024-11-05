package testgeneratorsystem;

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
    private ArrayList<Integer> ownedBanks;
    private static ArrayList<Admin> listOfAdmins = new ArrayList<>();

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

    public void setOwnedBanks(ArrayList<Integer> ownedBanks) {
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

    public ArrayList<Integer> getOwnedBanks() {
        return ownedBanks;
    }

    public static ArrayList<Admin> getListOfAdmins() {
        return listOfAdmins;
    }
    
    //methods
    @Override
    public Admin login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Username : ");
        String userNameInput = scan.nextLine();
        String passwordInput;
        Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
            }
            char[] passwordArray = console.readPassword("\nEnter Password: ");
            passwordInput = new String(passwordArray);
        for(Admin A : listOfAdmins){
            if(userNameInput.equals(A.getUserName())&&
               passwordInput.equals(A.getPassword())){
                return A;
            }
        }
        return null;
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

    @Override
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
                    case 1, 2, 3, 4 -> super.updateProfile(); // Handle basic updates
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
           listOfAdmins.remove(this); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("the account is removed");
    }
    public static ArrayList signUp() {
        ArrayList commonList = User.signUp();
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();
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
        listOfAdmins.add(CreatedAdmin);
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
        String Department;
        do {
            System.out.println("\nEnter department : ");
            Department = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, Department)) {
                System.out.println("Invalid Department name.Should contain letters only");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, Department));
        this.setDepartment(Department);
        System.out.println("Department updated successfully!");
    }
    
    private void updateContactNumber(Checker check, Scanner sc) {
        String ContactNumber;
        do {
            System.out.println("\nEnter Contact Number : ");
            ContactNumber = sc.nextLine();
            if (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber)) {
                System.out.println("Invalid Phone Number\ntry again with this format +Countrycode 123456789");
            }
        } while (!check.isValid(Checker.StringType.PHONE_NO, ContactNumber));
        this.setContactNumber(ContactNumber);
        System.out.println("Contact Number updated successfully!");
    }
}
