package EndUser;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.CategoryDAO;
import DataBaseManagment.QuestionBankDAO;
import TestSystem.Category;
import TestSystem.Question;
import TestSystem.QuestionBank;
import static TestSystem.TestGeneratorApp.ifColorfullPrintln;
import UserDefinedFunctionalities.Checker;
import UserDefinedFunctionalities.TerminalColors;
import java.io.Console;
import java.io.IOException;
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

    public void updateProfile() throws IOException {
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
        String categoryName;
        do {
            categoryName = validateInput(scanner, check, "Enter Category Name : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Wrong name , try again");
            if (CDB.searchCategoryByName(categoryName) != null) {
                ifColorfullPrintln("This category already exists", TerminalColors.BOLD_RED);
            }
        } while (CDB.searchCategoryByName(categoryName) != null);

        String categoryDesc = validateInput(scanner, check, "Enter Description : ", Checker.StringType.LETTERS_NUMS_UNDERSCORE, "Invalid Characters Exist , try again");
        LocalDate creationDate = LocalDate.now();
        Category newCategory = new Category(categoryName, categoryDesc, creationDate, this);
        CDB.saveCategory(newCategory);
        return CDB.loadCategory(newCategory.getCategoryId()).equals(newCategory);
    }

    public boolean modifyCategory() {
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();
        CategoryDAO CDB = new CategoryDAO();

        // Check if categories exist
        List<Category> categories = CDB.getCategoriesList();
        if (categories.isEmpty()) {
            ifColorfullPrintln("No Categories to Modify", TerminalColors.RED);
            return false;
        }

        // Display categories
        System.out.println("All Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + "- " + categories.get(i).getName());
            System.out.println("Description : " + categories.get(i).getDescription());
        }

        // Select category to modify
        Category selectedCategory;
        while (true) {
            System.out.print("Enter the number of category you want to modify (or 0 to cancel): ");
            int label = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Allow cancellation
            if (label == 0) {
                return false;
            }

            // Validate category selection
            if (label > 0 && label <= categories.size()) {
                selectedCategory = categories.get(label - 1);
                ifColorfullPrintln("You have selected \"" + selectedCategory.getName() + "\"", TerminalColors.BOLD_GREEN);
                break;
            } else {
                ifColorfullPrintln("Invalid category number. Please try again.", TerminalColors.BOLD_RED);
            }
        }

        // Modification options
        while (true) {
            System.out.println("\nModification Options:");
            System.out.println("1- Modify Name");
            System.out.println("2- Modify Description");
            System.out.println("3- Modify Both");
            System.out.println("0- Cancel");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0 -> {
                    return false;
                }

                case 1 -> {
                    // Modify Name
                    String newName;
                    do {
                        newName = validateInput(
                                scanner,
                                check,
                                "Enter New Category Name: ",
                                Checker.StringType.LETTERS_NUMS_UNDERSCORE,
                                "Invalid name, try again"
                        );

                        // Check if new name already exists
                        if (CDB.searchCategoryByName(newName) != null) {
                            ifColorfullPrintln("This category name already exists", TerminalColors.BOLD_RED);
                        }
                    } while (CDB.searchCategoryByName(newName) != null);

                    selectedCategory.setName(newName);
                    ifColorfullPrintln("Name updated successfully to \"" + newName + "\"", TerminalColors.GREEN);
                }

                case 2 -> {
                    // Modify Description
                    String newDesc = validateInput(
                            scanner,
                            check,
                            "Enter New Description: ",
                            Checker.StringType.LETTERS_NUMS_UNDERSCORE,
                            "Invalid description, try again"
                    );

                    selectedCategory.setDescription(newDesc);
                    ifColorfullPrintln("Description updated successfully", TerminalColors.GREEN);
                }

                case 3 -> {
                    String newName;
                    // Modify Both
                    // Modify Name
                    do {
                        newName = validateInput(
                                scanner,
                                check,
                                "Enter New Category Name: ",
                                Checker.StringType.LETTERS_NUMS_UNDERSCORE,
                                "Invalid name, try again"
                        );

                        // Check if new name already exists
                        if (CDB.searchCategoryByName(newName) != null) {
                            ifColorfullPrintln("This category name already exists", TerminalColors.BOLD_RED);
                        }
                    } while (CDB.searchCategoryByName(newName) != null);
                    // Modify Description
                    String newDesc = validateInput(
                            scanner,
                            check,
                            "Enter New Description: ",
                            Checker.StringType.LETTERS_NUMS_UNDERSCORE,
                            "Invalid description, try again"
                    );
                    selectedCategory.setName(newName);
                    selectedCategory.setDescription(newDesc);
                    ifColorfullPrintln("Name and Description updated successfully", TerminalColors.GREEN);
                }

                default -> {
                    ifColorfullPrintln("Invalid choice. Please try again.", TerminalColors.BOLD_RED);
                    continue;
                }
            }

            // Update the category in the database
            CDB.updateCategory(selectedCategory);
            return true;
        }
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
        try {
            // 1. Select Category
            Category selectedCategory = selectCategory();
            if (selectedCategory == null) {
                System.out.println("Operation cancelled.");
                return false;
            }

            // 2. Get or Create QuestionBank
            QuestionBank questionBank = getOrCreateQuestionBank(selectedCategory, getUserId());
            if (questionBank == null) {
                System.out.println("Failed to get or create question bank.");
                return false;
            }

            // 3. Create Question
            Question newQuestion = createQuestion(selectedCategory);
            if (newQuestion == null) {
                System.out.println("Question creation cancelled.");
                return false;
            }

            // 4. Add question to bank and update
            questionBank.getQuestions().add(newQuestion);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            boolean updated = QBDB.addQuestionToBank(questionBank.getBankID(), newQuestion);

            if (updated) {
                System.out.println("Question successfully added to the question bank!");
                return true;
            } else {
                System.out.println("Failed to update question bank in database.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    private Category selectCategory() {
        Scanner scanner = new Scanner(System.in);
        CategoryDAO CBD = new CategoryDAO();
        List<Category> categories = CBD.getCategoriesList();
        if (categories.isEmpty()) {
            System.out.println("No categories available.");
            return null;
        }

        while (true) {
            System.out.println("\nAvailable Categories:");
            for (int i = 0; i < categories.size(); i++) {
                Category category = categories.get(i);
                System.out.println((i + 1) + " _ name : " + category.getName());
                System.out.println("|--> " + category.getDescription());
            }
            System.out.println("0 - Cancel operation");

            System.out.print("\nSelect category number: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) {
                    return null;
                }
                if (choice > 0 && choice <= categories.size()) {
                    return categories.get(choice - 1);
                }
                System.out.println("Invalid choice. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private QuestionBank getOrCreateQuestionBank(Category category, UUID userId) {
        QuestionBankDAO QDBD = new QuestionBankDAO();
        List<QuestionBank> questionBanks = QDBD.searchByCategoryAndCreator(category, userId);
        if (!questionBanks.isEmpty()) {
            System.out.println("\nExists Question Bank for " + category.getName() + ":");
            System.out.println("Date Created : " + questionBanks.get(0).getCreationDate());
            return questionBanks.get(0);
        }
        return createQuestionBank();
    }

    private Question createQuestion(Category category) {
        // Get and validate question statement
        String statement = getValidStatement();
        if (statement == null) {
            return null;
        }

        // Select difficulty level
        Question.dlevel difficulty = selectDifficultyLevel();
        if (difficulty == null) {
            return null;
        }

        // Get and validate choices
        String[] choices = getValidChoices();
        if (choices == null) {
            return null;
        }

        // Get and validate correct answer
        Integer rightAnswer = getValidRightAnswer();
        if (rightAnswer == null) {
            return null;
        }

        return new Question(category, statement, difficulty, rightAnswer, choices);
    }

    private String getValidStatement() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter question statement (or 'cancel' to abort): ");
            String statement = scanner.nextLine().trim();

            if (statement.equalsIgnoreCase("cancel")) {
                return null;
            }

            if (statement.length() < 10) {
                System.out.println("Statement must be at least 10 characters long.");
                continue;
            }

            return statement;
        }
    }

    private String[] getValidChoices() {
        Scanner scanner = new Scanner(System.in);
        String[] choices = new String[4];
        System.out.println("Enter choices for A, B, C, and D (or 'cancel' to abort):");

        char[] choiceLetters = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < choiceLetters.length; i++) {
            while (true) {
                System.out.print("Enter choice " + choiceLetters[i] + ": ");
                String choice = scanner.nextLine().trim();

                if (choice.equalsIgnoreCase("cancel")) {
                    return null;
                }

                if (choice.isEmpty()) {
                    System.out.println("Choice cannot be empty.");
                    continue;
                }

                // Check for duplicate choices
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (choice.equalsIgnoreCase(choices[j])) {
                        System.out.println("This choice already exists. Please enter a unique choice.");
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    choices[i] = choice;
                    break;
                }
            }
        }

        // Display all choices for verification
        System.out.println("\nEntered choices:");
        for (int i = 0; i < choices.length; i++) {
            System.out.println(choiceLetters[i] + ": " + choices[i]);
        }

        return choices;
    }

    private Question.dlevel selectDifficultyLevel() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select difficulty level:");
            System.out.println("1 - Easy");
            System.out.println("2 - Medium");
            System.out.println("3 - Hard");
            System.out.println("0 - Cancel");

            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 0:
                        return null;
                    case 1:
                        return Question.dlevel.EASY;
                    case 2:
                        return Question.dlevel.MEDIUM;
                    case 3:
                        return Question.dlevel.HARD;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private Integer getValidRightAnswer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter the correct answer (A, B, C, or D)");
            System.out.println("(or enter 'cancel' to abort)");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equalsIgnoreCase("cancel")) {
                return null;
            }

            if (input.length() != 1) {
                System.out.println("Please enter a single letter (A, B, C, or D)");
                continue;
            }

            char answer = input.charAt(0);
            if (answer >= 'A' && answer <= 'D') {
                return answer - 'A'; // Convert letter to index (A=0, B=1, C=2, D=3)
            }

            System.out.println("Please enter a valid choice (A, B, C, or D)");
        }
    }

    public boolean updateQuestionInQuestionBank() {
        try {
// 1. Select Category        
            Category selectedCategory = selectCategory();
            if (selectedCategory == null) {
                System.out.println("Operation cancelled.");
                return false;
            }        // 2. Get QuestionBank        
            QuestionBank questionBank = getQuestionBank(selectedCategory, getUserId());       
            if (questionBank == null) {
                System.out.println("No Question Bank found for the selected category.");
                return false;
            }
// 3. Display Questions        
            displayQuestions(questionBank);
// 4. Select Question to Update        
            int questionIndex = selectQuestionToUpdate(questionBank);
            if (questionIndex < 0) {
                System.out.println("Operation cancelled.");
                return false;
            }
// 5. Get New Question Details        
            Question updatedQuestion = createQuestion(selectedCategory);
            if (updatedQuestion == null) {
                System.out.println("Question update cancelled.");
                return false;
            }
// 6. Update the question in the QuestionBank        
            questionBank.getQuestions().set(questionIndex, updatedQuestion);
// 7. Update QuestionBank in the database        
            QuestionBankDAO QBDB = new QuestionBankDAO();
            boolean updated = QBDB.updateQuestionBank(questionBank);
            if (updated) {
                System.out.println("Question successfully updated in the question bank!");
                return true;
            } else {
                System.out.println("Failed to update question bank in database.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    private int selectQuestionToUpdate(QuestionBank questionBank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the question to update (or 0 to cancel): ");
        int questionIndex = scanner.nextInt() - 1;
// Convert to zero-based index    
        if (questionIndex == -1) {
            return -1;
        }
// Cancel operation  
    if (questionIndex < 0 || questionIndex >= questionBank.getQuestionCount()) {        
    System.out.println("Invalid question number.");
        return -1;
// Invalid selection    
}    
        return questionIndex;
    }


    public boolean deleteQuestionFromQuestionBank() {
        try {
            // 1. Select Category
            Category selectedCategory = selectCategory();
            if (selectedCategory == null) {
                System.out.println("Operation cancelled.");
                return false;
            }

            // 2. Get QuestionBank
            QuestionBank questionBank = getQuestionBank(selectedCategory, getUserId());
            if (questionBank == null) {
                System.out.println("No Question Bank found for the selected category.");
                return false;
            }

            // 3. Display Questions
            displayQuestions(questionBank);

            // 4. Select Question to Delete
            int questionIndex = selectQuestionToDelete(questionBank);
            if (questionIndex < 0) {
                System.out.println("Operation cancelled.");
                return false;
            }

            // 5. Confirm Deletion
            System.out.print("Are you sure you want to delete this question? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (!confirmation.equals("yes")) {
                System.out.println("Deletion cancelled.");
                return false;
            }

            // 6. Remove the question
            Question questionToDelete = questionBank.getQuestions().get(questionIndex);
            questionBank.removeQuestion(questionToDelete);

            // 7. Update QuestionBank in the database
            QuestionBankDAO QBDB = new QuestionBankDAO();
            boolean updated = QBDB.updateQuestionBank(questionBank);
            if (updated) {
                System.out.println("Question successfully deleted from the question bank!");
                return true;
            } else {
                System.out.println("Failed to update question bank in database.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    private void displayQuestions(QuestionBank questionBank) {
        System.out.println("Current Questions in the selected Question Bank:");
        List<Question> questions = questionBank.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
        }
    }

    private int selectQuestionToDelete(QuestionBank questionBank) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the question to delete (or 0 to cancel): ");
        int questionIndex = scanner.nextInt() - 1; // Convert to zero-based index

        if (questionIndex == -1) {
            return -1; // Cancel operation
        }

        if (questionIndex < 0 || questionIndex >= questionBank.getQuestions().size()) {
            System.out.println("Invalid question number.");
            return -1; // Invalid selection
        }

        return questionIndex;
    }

    private QuestionBank getQuestionBank(Category category, UUID userId) {
        QuestionBankDAO QDBD = new QuestionBankDAO();
        List<QuestionBank> questionBanks = QDBD.searchByCategoryAndCreator(category, userId);
        if (!questionBanks.isEmpty()) {
            return questionBanks.get(0);
        }
        System.out.println("No existing question bank found for this category.");
        return null;
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
                updateEquivalentCategoryAndQuestionBank();
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
                updateEquivalentCategoryAndQuestionBank();
        System.out.println("Contact Number updated successfully!");
    }

}
