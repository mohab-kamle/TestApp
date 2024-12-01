package EndUser;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.CategoryDAO;
import DataBaseManagment.QuestionBankDAO;
import TestSystem.Category;
import TestSystem.Question;
import TestSystem.QuestionBank;
import static TestSystem.TestGeneratorApp.ifColorfullPrint;
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
     * GUI VERSION login method for admin as it uses its specialized DAO
     *
     * @param username
     * @param passsword
     * @return the logged in Admin object
     */
    public Admin login(String username , String passsword) {
        AdminDAO ADB = new AdminDAO();
        return ADB.searchAdmin(username, passsword);
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
            ifColorfullPrintln("|---> Update Profile Page",TerminalColors.BOLD_BLUE);
            ifColorfullPrintln("|---Select what you want to update",TerminalColors.YELLOW);
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
                "Enter department : ",
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

    /**
     * Creates a new category in the system.
     *
     * This method prompts the admin to enter a category name and description. It validates the input to ensure the category name is unique and follows the specified format. If the category name already exists, it informs the user and prompts for a new name. Once a valid category name and description are provided, the method creates a new Category object and saves it to the database.
     *
     * @return true if the category was successfully created and saved; false otherwise.
     */
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

    /**
     * Modifies an existing category in the system.
     *
     * This method allows the admin to modify the name and/or description of a category. It first checks if there are any categories available to modify. If not, it informs the user and returns false. If categories are available, it displays the list of categories and prompts the admin to select one to modify. The admin can choose to change the name, description, or both. The method validates the new name to ensure it does not already exist in the system before updating the category.
     *
     * @return true if the category was successfully modified; false if no categories exist or if the operation was canceled.
     */
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
        ifColorfullPrintln("All Categories:",TerminalColors.YELLOW);
        for (int i = 0; i < categories.size(); i++) {
            ifColorfullPrintln((i + 1) + "- " + categories.get(i).getName(),TerminalColors.YELLOW);
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

    /**
     * Deletes an existing category from the system.
     *
     * This method allows the admin to delete a category from the list of categories. It first checks if there are any categories available for deletion. If categories exist, it displays the list and prompts the admin to select one to delete. After deletion, the method asks if the admin wants to delete another category. The process continues until the admin chooses to stop or there are no more categories left.
     *
     * @return true if at least one category was deleted; false if there were no categories to delete.
     */
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

    /**
     * Adds a new question to a specified question bank.
     *
     * This method allows an admin to add a question to an existing question bank associated with a selected category. It involves several steps: 1. Selecting a category from which the question bank will be chosen. 2. Retrieving or creating a question bank for that category. 3. Creating a new question based on user input. 4. Adding the newly created question to the question bank and updating the database.
     *
     * If any step fails or is canceled by the user, the method will return false.
     *
     * @return true if the question was successfully added to the question bank; false otherwise.
     */
    public boolean addQuestionToQuestionBank() {
    Scanner scanner = new Scanner(System.in); // Assuming Scanner is used for user input

    try {
        while (true) {
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
            ArrayList<Question> currQuestions = questionBank.getQuestions();
            currQuestions.add(newQuestion);
            questionBank.setQuestions(currQuestions);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            AdminDAO ADB = new AdminDAO();
            ArrayList<QuestionBank> currentQBs = getOwnedBanks();
            currentQBs.removeIf(qb -> qb.getBankID().equals(questionBank.getBankID()));
            currentQBs.add(questionBank);
            this.setOwnedBanks(currentQBs);
            ADB.updateAdmin(this);
            boolean updated = QBDB.addQuestionToBank(questionBank.getBankID(), newQuestion);

            if (updated) {
                ifColorfullPrintln("Question successfully added to the question bank!",TerminalColors.BOLD_GREEN);
            } else {
                ifColorfullPrintln("Failed to update question bank in database.",TerminalColors.BOLD_RED);
                return false;
            }

            // Ask user if they want to add another question or exit
            System.out.print("Do you want to add another question? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        return true;
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        return false;
    }
}


    /**
     * Prompts the user to select a category from a list of available categories.
     *
     * This method retrieves the list of categories from the database and presents them to the user. The user can select a category by entering the corresponding number. If the user chooses to cancel the operation, they can enter 0. The method will continue prompting until a valid selection is made or the operation is canceled.
     *
     * @return the selected Category object if a valid category is chosen; null if the operation is canceled or no categories are available.
     */
    private Category selectCategory() {
        Scanner scanner = new Scanner(System.in);
        CategoryDAO CBD = new CategoryDAO();
        List<Category> categories = CBD.getCategoriesList();
        if (categories.isEmpty()) {
            System.out.println("No categories available.");
            return null;
        }

        while (true) {
            ifColorfullPrintln("\nAvailable Categories:",TerminalColors.YELLOW);
            for (int i = 0; i < categories.size(); i++) {
                Category category = categories.get(i);
                ifColorfullPrintln((i + 1) + " _ name : " + category.getName(),TerminalColors.YELLOW);
                System.out.println("Descrtiption : " + category.getDescription());
            }
            System.out.println("\n0 - Cancel operation");

            ifColorfullPrint("\nSelect category number: ",TerminalColors.CYAN);
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

    /**
     * Retrieves an existing question bank for a specified category and user, or creates a new one if none exists.
     *
     * This method checks if there is already a question bank associated with the given category and creator (user). If a question bank exists, it returns the first one found and displays its creation date. If no question bank exists, it calls the `createQuestionBank` method to create a new question bank.
     *
     * @param category the Category for which to retrieve or create a question bank.
     * @param userId the UUID of the user (creator) associated with the question bank.
     * @return the existing QuestionBank if found; otherwise, a new QuestionBank created by the `createQuestionBank` method.
     */
    private QuestionBank getOrCreateQuestionBank(Category category, UUID userId) {
        QuestionBankDAO QDBD = new QuestionBankDAO();
        List<QuestionBank> questionBanks = QDBD.searchByCategoryAndCreator(category, userId);
        if (!questionBanks.isEmpty()) {
            System.out.println("Exists Question Bank for " + category.getName() + ":");
            System.out.println("Date Created : " + questionBanks.get(0).getCreationDate());
            System.out.println("Number of Questions : " + questionBanks.get(0).getQuestionCount() + "\n");
            return questionBanks.get(0);
        }
        return createQuestionBank(this, category, LocalDate.now());
    }

    /**
     * Creates a new question based on user input and specified category.
     *
     * This method prompts the user to provide various details for a new question, including: 1. The question statement. 2. The difficulty level. 3. A set of answer choices. 4. The index of the correct answer.
     *
     * Each input is validated, and if any input is invalid or canceled, the method returns null. If all inputs are valid, a new Question object is created and returned.
     *
     * @param category the Category to which the new question will be associated.
     * @return a new Question object if all inputs are valid; null if any input is invalid or canceled.
     */
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

        return new Question(category.getCategoryId(), statement, difficulty, rightAnswer, choices);
    }

    /**
     * Prompts the user to enter a valid question statement.
     *
     * This method repeatedly asks the user for a question statement until a valid input is provided or the user chooses to cancel the operation. A valid statement must be at least 10 characters long. If the user enters "cancel", the method will return null to indicate that the operation was aborted.
     *
     * @return a valid question statement as a String if input is acceptable; null if the operation is canceled.
     */
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

    /**
     * Prompts the user to enter valid choices for a multiple-choice question.
     *
     * This method collects four choices labeled A, B, C, and D from the user. It validates the input to ensure that: 1. The choice is not empty. 2. The choice is unique among the previously entered choices.
     *
     * The user can cancel the operation at any time by entering "cancel", in which case the method will return null. Once all choices are entered and validated, the method displays the choices for verification and returns the array of choices.
     *
     * @return an array of valid choices as Strings if all inputs are acceptable; null if the operation is canceled.
     */
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
                        ifColorfullPrintln("This choice already exists. Please enter a unique choice.",TerminalColors.BOLD_RED);
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

    /**
     * Prompts the user to select a difficulty level for a question.
     *
     * This method presents the user with a menu to choose from three difficulty levels: Easy, Medium, and Hard, as well as an option to cancel the operation. The user must enter a corresponding number to make a selection. If the user enters "0", the method will return null, indicating that the operation was canceled. If the user enters an invalid choice or a non-numeric value, an error message will be displayed, and the user will be prompted to try again.
     *
     * @return the selected difficulty level as a Question.dlevel enum value; null if the operation is canceled.
     */
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
                        ifColorfullPrintln("Invalid choice. Please try again.",TerminalColors.BOLD_RED);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Prompts the user to enter the correct answer for a multiple-choice question.
     *
     * This method allows the user to input the correct answer as a single letter (A, B, C, or D). The user can also cancel the operation by entering "cancel", in which case the method will return null. The input is validated to ensure that it is a single character and falls within the valid options. If the input is valid, the method converts the letter to an index (A=0, B=1, C=2, D=3) and returns it.
     *
     * @return the index of the correct answer as an Integer (0 for A, 1 for B, 2 for C, 3 for D); null if the operation is canceled.
     */
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

    /**
     * Updates a question in the question bank based on user input.
     *
     * This method guides the user through a series of steps to update a specific question in a selected category's question bank. The process includes selecting a category, displaying existing questions, selecting a question to update, and entering new question details. The updated question is then saved back to the question bank and the changes are persisted in the database.
     *
     * If at any point the user cancels the operation, or if an error occurs, the method will return false.
     *
     * @return true if the question was successfully updated in the question bank; false if the operation was canceled or failed.
     */
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
            AdminDAO ADB = new AdminDAO();
            for (QuestionBank ownedBank : ownedBanks) {
                if (ownedBank.getBankID().equals(questionBank.getBankID())) {
                    ownedBank.setQuestions(questionBank.getQuestions());
                }
            }
            ADB.updateAdmin(this);
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

    /**
     * Prompts the user to select a question to update from the provided question bank.
     *
     * This method displays a prompt for the user to enter the number corresponding to the question they wish to update. The user can also enter '0' to cancel the operation. The method converts the user's input to a zero-based index for internal processing.
     *
     * @param questionBank the QuestionBank containing the questions from which the user can select.
     * @return the zero-based index of the selected question; -1 if the operation is canceled or if the input is invalid.
     */
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

    /**
     * Deletes a question from the question bank based on user input.
     *
     * This method guides the user through a series of steps to delete a specific question from a selected category's question bank. The process includes selecting a category, displaying existing questions, selecting a question to delete, and confirming the deletion. The question is then removed from the question bank, and the changes are persisted in the database.
     *
     * If at any point the user cancels the operation, or if an error occurs, the method will return false.
     *
     * @return true if the question was successfully deleted from the question bank; false if the operation was canceled or failed.
     */
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
            if (!displayQuestions(questionBank)) {
                System.out.println("Operation cancelled.");
                return false;
            }

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

            // 7. Update QuestionBank and admin in the database
            AdminDAO ADB = new AdminDAO();
            for (QuestionBank ownedBank : ownedBanks) {
                if (ownedBank.getBankID().equals(questionBank.getBankID())) {
                    ownedBank.setQuestions(questionBank.getQuestions());
                }
            }
            ADB.updateAdmin(this);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            boolean updated = QBDB.updateQuestionBank(questionBank);
            if (updated) {
//                System.out.println("Question successfully deleted from the question bank!");// for debugging
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

    /**
     * Displays the list of questions in the specified QuestionBank.
     *
     * This method checks if there are any questions in the provided QuestionBank. If questions are present, it prints them to the console with their corresponding index numbers. If the QuestionBank is empty, it informs the user that no questions are available to delete.
     *
     * @param questionBank the QuestionBank containing the questions to be displayed.
     * @return true if questions are displayed; false if the QuestionBank is empty.
     */
    private boolean displayQuestions(QuestionBank questionBank) {
        if (!questionBank.getQuestions().isEmpty()) {
            System.out.println("Current Questions in the selected Question Bank:");
            List<Question> questions = questionBank.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                System.out.println((i + 1) + ". " + questions.get(i));
            }
            return true;
        } else {
            ifColorfullPrintln("No Questions Are available to delete", TerminalColors.BOLD_RED);
            return false;
        }

    }

    /**
     * Prompts the user to select a question to delete from the specified QuestionBank.
     *
     * This method displays a prompt asking the user to enter the number corresponding to the question they wish to delete. The user can also enter '0' to cancel the operation. The method converts the user's input into a zero-based index for internal processing. It checks for valid input and returns the appropriate index or a cancellation signal.
     *
     * @param questionBank the QuestionBank containing the questions from which a question will be selected for deletion.
     * @return the zero-based index of the selected question to delete, or -1 if the operation is canceled or if the input is invalid.
     */
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

    /**
     * Retrieves a QuestionBank based on the specified category and user ID.
     *
     * This method interacts with the QuestionBankDAO to search for existing QuestionBanks that match the given category and were created by the specified user. If one or more QuestionBanks are found, the first one in the list is returned. If no QuestionBanks are found, a message is printed to inform the user, and the method returns null.
     *
     * @param category the Category for which to search for a QuestionBank.
     * @param userId the UUID of the user who created the QuestionBank.
     * @return the first QuestionBank found that matches the criteria, or null if no matching QuestionBank exists.
     */
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
    /**
     * Updates the department of the current admin and saves the changes to the database.
     *
     * This method prompts the user for a new department name, validates the input to ensure it contains only letters, and then updates the department of the current admin instance. After updating the department, it calls the AdminDAO to persist the changes and updates any equivalent categories and question banks associated with the admin. Finally, it confirms the successful update to the user.
     *
     * @param check the Checker instance used to validate the input.
     * @param sc the Scanner instance used for user input.
     */
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

    /**
     * Updates the contact number of the current admin and saves the changes to the database.
     *
     * This method prompts the user for a new contact number, validates the input to ensure it adheres to a specific phone number format, and then updates the contact number of the current admin instance. After updating the contact number, it calls the AdminDAO to persist the changes and updates any equivalent categories and question banks associated with the admin. Finally, it confirms the successful update to the user.
     *
     * @param check the Checker instance used to validate the input.
     * @param sc the Scanner instance used for user input.
     */
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
