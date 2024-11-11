package EndUser;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.CategoryDAO;
import TestSystem.Category;
import TestSystem.QuestionBank;
import static TestSystem.TestGeneratorApp.ifColorfullPrintln;
import UserDefinedFunctionalities.Checker;
import UserDefinedFunctionalities.TerminalColors;
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
     * login method for admin as it uses its specialized DAO
     *
     * @return the logged in Admin object
     */
    @Override
    public Admin login() {
        Scanner scan = new Scanner(System.in);
        AdminDAO ADB = new AdminDAO();
        System.out.print("\nEnter Username : ");
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

    /**
     * Retrieves and optionally displays the admin's extended profile information.
     *
     * This method extends the base user profile by adding admin-specific details: - Department - Contact Number - Join Date (formatted)
     *
     * @param show A Boolean flag to control console output - true: Prints detailed profile to console - false: Generates profile string without displaying
     *
     * @return A comprehensive string representation of the admin's profile
     *
     * @implNote - Inherits base profile information from parent class - Appends admin-specific attributes - Uses date formatting for join date
     */
    @Override
    public String getProfile(boolean show) {

        StringBuffer ProfileStr = new StringBuffer(super.getProfile(show));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ProfileStr.append("\nDepartment : ").append(getDepartment());
        ProfileStr.append("\nContact Number : ").append(getContactNumber());
        ProfileStr.append("\nJoin Date : ").append(getDateAppointed().format(formatter));
        if (show) {
            System.out.println("\nDepartment : " + getDepartment());
            System.out.println("\nContact Number : " + getContactNumber());
            System.out.println("\nJoin Date : " + getDateAppointed().format(formatter));
        }
        String Profile = new String(ProfileStr);
        return Profile;
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
                    case 1, 2, 3, 4 ->
                        super.updateProfile(choice); // Handle basic updates
                    case 5 ->
                        updateContactNumber(check, sc); // Handle admin-specific updates
                    case 6 ->
                        updateDepartment(check, sc); // Handle admin-specific updates
                    case -1 ->
                        System.out.println("Returning to previous menu...");
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }
        } while (choice != -1);
    }

    @Override
    public void removeAccount() {
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
     *
     * @return ArrayList for all the data stored during the signup process
     */
    public static ArrayList signUp() {
        ArrayList commonList = User.signUp();
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();//data validation object
        AdminDAO AdminDB = new AdminDAO();//database accessor object
        String ContactNumber = validateInput(scanner,
                check,
                "Enter Contact Number : ",
                Checker.StringType.PHONE_NO,
                "Invalid Phone Number\ntry again with this format +Countrycode 123456789");
        String Department = validateInput(scanner,
                check,
                "\nEnter department : ",
                Checker.StringType.LETTERS_ONLY,
                "Invalid Department name.Should contain letters only");
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
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();
        CategoryDAO CDB = new CategoryDAO();
        String categoryName = validateInput(scanner, check, "Enter Category Name : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Wrong name , try again");
        String categoryDesc = validateInput(scanner, check, "Enter Description : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Invalid Characters Exist , try again");
        LocalDate creationDate = LocalDate.now();
        Category newCategory = new Category(categoryName, categoryDesc, creationDate, this);
        CDB.saveCategory(newCategory);
        return CDB.loadCategory(newCategory.getCategoryId()).equals(newCategory);
    }

    public boolean modifyCategory() {
        Scanner scanner = new Scanner(System.in);
        CategoryDAO CDB = new CategoryDAO();
        Checker check = new Checker() ;
        int i = 1 ;
        for (Category category : CDB.getCategoriesList()){
            ifColorfullPrintln("All Categories:", TerminalColors.BOLD_BLUE);
            System.out.println(i++ +"- "+ category.getName());
        }
        ifColorfullPrintln("Enter The number of category you want to modify or 0 for Exit: ", TerminalColors.CYAN);
        int label = scanner.nextInt() ;
        if (label > 0 && label <= CDB.getCategoriesList().size()){
            Category selectedCategory = CDB.getCategoriesList().get(label - 1);
            ifColorfullPrintln("You have selected \""+selectedCategory.getName()+"\"", TerminalColors.GREEN);
            ifColorfullPrintln("2 option:", TerminalColors.BOLD_BLUE);
            System.out.println("\t1- Name");
            System.out.println("\t2- Description");
            ifColorfullPrintln("Enter the item number or 0 to Exit: ", TerminalColors.CYAN);
            int selected = scanner.nextInt(); 
            while (selected != 1 && selected != 2 && selected != 0) {
                ifColorfullPrintln("Wrong input", TerminalColors.BOLD_RED);
                ifColorfullPrintln("Please enter right input", TerminalColors.CYAN);
                selected = scanner.nextInt();
            }
            if (selected == 0) {
                ifColorfullPrintln("EXIT...",TerminalColors.GREEN );
                return false ;
            }
            else if (selected == 1){
                ifColorfullPrintln("Please Enter New Name: ", TerminalColors.CYAN);
                String Name = validateInput(scanner, check, "Enter Category New Name : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Wrong name , try again");
                selectedCategory.setName(Name);
                ifColorfullPrintln("Done. The new name is \""+Name+"\"", TerminalColors.GREEN);
                ifColorfullPrintln("Enter 2 if you want to modify the description also or 0 to Exit", TerminalColors.CYAN);
                int selected2 = scanner.nextInt();
                while (selected2 != 0 && selected2 != 2) {
                    ifColorfullPrintln("Wrong input", TerminalColors.BOLD_RED);
                    ifColorfullPrintln("Please enter right input", TerminalColors.CYAN);
                    selected2 = scanner.nextInt();
                }
                if (selected2 == 2) {
                    ifColorfullPrintln("Please Enter New Description: ", TerminalColors.CYAN);
                    String description = validateInput(scanner, check, "Enter Description : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Invalid Characters Exist , try again");
                    selectedCategory.setDescription(description);
                    ifColorfullPrintln("Done. You have a new description: ", TerminalColors.GREEN);
                    System.out.println("\t \t" + description);
                }
                else if (selected2 == 0) {
                    ifColorfullPrintln("EXIT...",TerminalColors.GREEN );
                    CDB.updateCategory(selectedCategory);
                    return true ;
                }
            }
            else {
                ifColorfullPrintln("Please Enter New Description: ", TerminalColors.CYAN);
                String description = scanner.nextLine();
                selectedCategory.setDescription(description);
                ifColorfullPrintln("Done. You have a new description: ", TerminalColors.GREEN);
                System.out.println("\t \t" + description);
                ifColorfullPrintln("Enter 1 if you want to modify the name also or any number to finish", TerminalColors.CYAN);
                int selected2 = scanner.nextInt();
                if (selected2 == 1) {
                    ifColorfullPrintln("Please Enter New Name: ", TerminalColors.CYAN);
                    String Name = scanner.nextLine();
                    selectedCategory.setName(Name);
                    ifColorfullPrintln("Done. The new name is \""+Name+"\"", TerminalColors.GREEN);
                }
            }
            CDB.updateCategory(selectedCategory);
        }
        else if (label == 0){
            ifColorfullPrintln("EXIT...",TerminalColors.GREEN ); 
        }
        else {
        ifColorfullPrintln("You have Entered wrong number", TerminalColors.BOLD_RED);
        ifColorfullPrintln("Please enter 0 to Exit or any number to retry", TerminalColors.CYAN);
        int num = scanner.nextInt();
        if (num == 0){
            ifColorfullPrintln("EXIT...",TerminalColors.GREEN ); 
        }
        else modifyCategory() ;
        }
         return false ;   
        }
    

    public boolean deleteCategory() {
        CategoryDAO CDB = new CategoryDAO();
        Scanner scanner = new Scanner(System.in);
        int oldSize = CDB.getCategoriesList().size();
        while (true) {
            int i = 1;
            if (!CDB.getCategoriesList().isEmpty()) {
                for (Category category : CDB.getCategoriesList()) {
                    System.out.println((i++) + " _ name : " + category.getName());
                    System.out.println("|--> " + category.getDescription());
                }

                System.out.println("Enter The number of category you want to delete : ");
                int key = scanner.nextInt();
                OUTER:
                while (true) {
                    if (key >= 1 && key <= CDB.getCategoriesList().size()) {
                        CDB.deleteCategory(CDB.getCategoriesList().get(key - 1).getCategoryId());
                        if (!CDB.getCategoriesList().isEmpty()) {
                            while (true) {
                                System.out.println("Do you want to delete another one ? y/n");
                                scanner.nextLine();
                                String keyS = scanner.nextLine();
                                switch (keyS.toLowerCase()) {
                                    case "y" -> {
                                        break OUTER;
                                    }
                                    case "n" -> {
                                        return true;
                                    }
                                    default -> {
                                        ifColorfullPrintln("Wrong Input , try again", TerminalColors.BOLD_RED);
                                    }
                                }
                            }

                        } else {
                            ifColorfullPrintln("No Other Categories to Delete", TerminalColors.RED);
                            return true;
                        }
                    } else {
                        System.out.println("Wrong Input , try again or Enter 0 to return : ");
                        key = scanner.nextInt();
                        if (key == 0) {
                            return oldSize > CDB.getCategoriesList().size();
                        }
                    }
                }
            } else {
                ifColorfullPrintln("No Categories to Delete", TerminalColors.RED);
                break;
            }

        }
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
        String Department = validateInput(sc,
                check,
                "\nEnter department : ",
                Checker.StringType.LETTERS_ONLY,
                "Invalid Department name.Should contain letters only");
        this.setDepartment(Department);
        ADB.updateAdmin(this);
        System.out.println("Department updated successfully!");
    }

    private void updateContactNumber(Checker check, Scanner sc) {
        AdminDAO ADB = new AdminDAO();
        String ContactNumber = validateInput(sc,
                check,
                "Enter Contact Number : ",
                Checker.StringType.PHONE_NO,
                "Invalid Phone Number\ntry again with this format +Countrycode 123456789");
        this.setContactNumber(ContactNumber);
        ADB.updateAdmin(this);
        System.out.println("Contact Number updated successfully!");
    }

}
