package EndUser;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.CategoryDAO;
import DataBaseManagment.QuestionBankDAO;
import DataBaseManagment.StudentDAO;
import TestSystem.Category;
import TestSystem.QuestionBank;
import TestSystem.TestGeneratorApp;
import static TestSystem.TestGeneratorApp.ifColorfullPrintln;
import UserDefinedFunctionalities.Checker;
import UserDefinedFunctionalities.TerminalColors;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import javax.mail.MessagingException;

/**
 *
 * @author mohab
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Admin.class, name = "admin"),
    @JsonSubTypes.Type(value = Student.class, name = "student")
})
public abstract class User {

    protected UUID userId;
    protected String email;
    protected String userName;
    protected String password;
    protected String address;
    protected String firstName;
    protected String lastName;
    protected LocalDateTime lastLoginDate;

    public User(String email,
            String userName,
            String password,
            String address,
            String firstName,
            String lastName) {
        this.userId = UUID.randomUUID();
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = LocalDateTime.now();
    }

    //setters
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    //getters
    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty("password")
    protected String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    //methods
    /**
     * Facilitates user registration by collecting and validating user information.
     *
     * This method guides users through a comprehensive sign-up process, validating each input against specific criteria to ensure data integrity.
     *
     * @return ArrayList containing validated user registration details in the following order: [username, email, password, firstName, lastName, country, city, fullAddress]
     */
    public static ArrayList<String> signUp() {
        ArrayList<String> commonList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();

        // Username validation with unique username check
        String username = validateUniqueInput(
                scanner,
                check,
                "Enter Username: ",
                Checker.StringType.USERNAME,
                "Username must be 3-20 characters (letters, numbers, dots, underscores)",
                User::isUsernameTaken
        );
        commonList.add(username);

        // Email validation with unique email check
        String email = validateUniqueInput(
                scanner,
                check,
                "Enter Email: ",
                Checker.StringType.EMAIL,
                "Invalid email format",
                User::isEmailTaken
        );
        commonList.add(email);

        // Password validation with detailed requirements
        String password = validatePasswordInput(scanner, check);
        commonList.add(password);

        // Personal information validation
        String[] personalFields = {
            "First Name",
            "Last Name",
            "Country",
            "City",
            "Street Name"
        };

        for (String field : personalFields) {
            String input = validateInput(
                    scanner,
                    check,
                    "Enter " + field + ": ",
                    Checker.StringType.LETTERS_ONLY,
                    field + " must contain only letters"
            );
            commonList.add(input);
        }

        // Construct full address
        String fullAddress = String.format(
                "%s, %s, %s",
                commonList.get(commonList.size() - 1), // Street Name
                commonList.get(commonList.size() - 2), // City
                commonList.get(commonList.size() - 3) // Country
        );
        commonList.remove(commonList.size() - 1); // remove Street Name from common list
        commonList.remove(commonList.size() - 1); // remove City
        commonList.remove(commonList.size() - 1); // remove Country
        commonList.add(fullAddress);
        
        return commonList;
    }

    /**
     * Validates input with an additional unique check.
     *
     * @param scanner Input scanner
     * @param check Validation checker
     * @param prompt Prompt message
     * @param validationType Validation type
     * @param errorMessage Error message
     * @param uniquenessCheck Function to check uniqueness
     * @return Validated unique input
     */
    private static String validateUniqueInput(
            Scanner scanner,
            Checker check,
            String prompt,
            Checker.StringType validationType,
            String errorMessage,
            Predicate<String> uniquenessCheck
    ) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // Validate input format
            if (!check.isValid(validationType, input)) {
                ifColorfullPrintln(errorMessage,TerminalColors.BOLD_RED);
                continue;
            }

            // Check uniqueness
            if (!uniquenessCheck.test(input)) {
                ifColorfullPrintln("This "
                        + (validationType == Checker.StringType.USERNAME ? "username" : "email")
                        + " is already taken", TerminalColors.BOLD_RED);
                continue;
            }

            return input;
        }
    }

    /**
     * Validates password input with comprehensive security checks.
     *
     * @param scanner Input scanner
     * @param check Validation checker
     * @return Validated password
     */
    private static String validatePasswordInput(Scanner scanner, Checker check) {
        Console console = System.console();

        System.out.println("""
        Password Requirements:
        - 12-20 characters long
        - At least one uppercase letter
        - At least one lowercase letter
        - At least one special character
        - At least one digit
    """);

        while (true) {
            String passwordInput = console != null
                    ? new String(console.readPassword("Enter Password: "))
                    : getPasswordFallback(scanner);

            if (check.isValid(Checker.StringType.PASSWORD, passwordInput)) {
                return passwordInput;
            }
            ifColorfullPrintln("Password does not meet requirements. Please try again.", TerminalColors.BOLD_RED);

        }
    }

    /**
     * Fallback method for password input when console is not available.
     *
     * @param scanner Input scanner
     * @return Entered password
     */
    private static String getPasswordFallback(Scanner scanner) {
        System.out.println("Enter Password: ");
        return scanner.nextLine();
    }

    /**
     * Validates general input with specified validation rules.
     *
     * @param scanner Input scanner
     * @param check Validation checker
     * @param prompt Prompt message
     * @param validationType Validation type
     * @param errorMessage Error message
     * @return Validated input
     */
    protected static String validateInput(
            Scanner scanner,
            Checker check,
            String prompt,
            Checker.StringType validationType,
            String errorMessage
    ) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (check.isValid(validationType, input)) {
                return input;
            }

            ifColorfullPrintln(errorMessage, TerminalColors.BOLD_RED);
        }
    }

    public abstract User login();

    public abstract void removeAccount();

    public boolean changePassword() {
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        System.out.println("Enter the old password : ");
        String oldPass = sc.nextLine();
        while (!oldPass.equals(this.getPassword())) {
            System.out.println("Wrong Password , try again or type E to Exit : ");
            String middleman = sc.nextLine();
            if (middleman.equals("E")) {
                return false;
            }
            oldPass = middleman;
        }
        String newPass = null;
        String confirmNewPass;
        System.out.println("""
        Password Requirements:
        - 12-20 characters long
        - At least one uppercase letter
        - At least one lowercase letter
        - At least one special character
        - At least one digit
        """);
        do {
            do {
                Console console = System.console();
                if (console == null) {
                    System.out.println("No console available");
                    break;
                }
                char[] passwordArray = console.readPassword("\nEnter the new Password: ");
                newPass = new String(passwordArray);
                if (!check.isValid(Checker.StringType.PASSWORD, newPass)) {
                    System.out.println("Invalid password , please try again.");
                }
            } while (!check.isValid(Checker.StringType.PASSWORD, newPass));
            System.out.println("Confirm the new password : ");
            confirmNewPass = sc.nextLine();
            if (newPass.equals(confirmNewPass)) {
                break;
            } else {
                System.out.println("Please Try Again , the passwords don't match");
            }
        } while (!newPass.equals(confirmNewPass));
        //updating the object
        this.setPassword(newPass);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        System.out.println("The password has been changed successfully !");
        return true;
    }

    /**
     * It adds the ability for user to reset his password if it is forgotten through a code sent for his email to authenticate
     *
     * @return True if the reseting of the password done successfully
     * @throws MessagingException
     */
    public boolean resetPassword() throws MessagingException {
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        int keyI;
        String key;
        String codeCheck;
        String EmailInput;
        do {
            System.out.println("Enter your Email address : ");
            EmailInput = sc.nextLine();
            if (User.findEmail(EmailInput) == null) {
                System.out.println("There is no account with this email");
                System.out.println("Enter 1 to try again or -1 to exit : ");
                keyI = sc.nextInt();
                if (keyI == -1) {
                    return false;
                }
                sc.nextLine();
            }
        } while (User.findEmail(EmailInput) == null);
        System.out.println("Do you want to recieve a reset code on your email ? y/n ");
        key = sc.nextLine();
        OUTER:
        do {
            switch (key) {
                case "y" -> {
                    String to = EmailInput;
                    String subject = "Verification Code";
                    String verificationCode = EmailFunctionality.EmailUtil.generateVerificationCode();
                    String body = "Your verification code is: " + verificationCode;
                    EmailFunctionality.EmailUtil.sendEmail(to, subject, body);
                    System.out.println("Enter the sent Code or Type R to resend : ");
                    codeCheck = sc.nextLine();
                    if (codeCheck.equals("R")) {
                        continue;
                    }
                    while (!codeCheck.equals(verificationCode)) {
                        System.out.println("Wrong Code , try again or type E to Exit : ");
                        String middleman = sc.nextLine();
                        if (middleman.equals("E")) {
                            return false;
                        }
                        codeCheck = middleman;
                    }
                    String newPass = null;
                    String confirmNewPass;
                    System.out.println("""
                      Password Requirements:
                      - 12-20 characters long
                      - At least one uppercase letter
                      - At least one lowercase letter
                      - At least one special character
                      - At least one digit
                    """);
                    do {
                        do {
                            Console console = System.console();
                            if (console == null) {
                                System.out.println("No console available");
                                break;
                            }
                            char[] passwordArray = console.readPassword("\nEnter the new Password: ");
                            newPass = new String(passwordArray);
                            if (!check.isValid(Checker.StringType.PASSWORD, newPass)) {
                                System.out.println("Invalid password , please try again.");
                            }
                        } while (!check.isValid(Checker.StringType.PASSWORD, newPass));
                        System.out.println("Confirm the new password : ");
                        confirmNewPass = sc.nextLine();
                        if (newPass.equals(confirmNewPass)) {
                            break;
                        } else {
                            System.out.println("Please Try Again , the passwords don't match");
                        }
                    } while (!newPass.equals(confirmNewPass));
                    User userToBeUpdated = User.findEmail(EmailInput);
                    userToBeUpdated.setPassword(newPass);
                    //updating the equivalent JSON
                    if (userToBeUpdated instanceof Admin) {
                        AdminDAO ADB = new AdminDAO();
                        ADB.updateAdmin((Admin) userToBeUpdated);
                    }
                    if (userToBeUpdated instanceof Student) {
                        StudentDAO SDB = new StudentDAO();
                        SDB.updateStudent((Student) userToBeUpdated);
                    }
                    updateEquivalentCategoryAndQuestionBank(userToBeUpdated);
                    System.out.println("The password has been changed successfully !");
                    return true;
                }
                case "n" -> {
                    return false;
                }
                default ->
                    System.out.println("Wrong input , please try again");
            }
        } while (!key.equals("y") && !key.equals("n"));
        return false;
    }

    /**
     * Retrieves and optionally displays the user's profile information.
     *
     * This method generates a comprehensive string representation of the user's profile, with an option to print the profile details to the console.
     *
     * @param show A Boolean flag indicating whether to display the profile details - true: Prints profile details to the console - false: Only generates the profile string without printing
     *
     * @return A string containing the user's profile information, including: - Username - Email - First Name - Last Name - Address
     *
     * @implNote - Uses StringBuffer for efficient string concatenation - Provides flexibility in profile information display
     *
     * @example // Retrieve profile as a string without displaying String profileString = user.getProfile(false); // Retrieve and display profile user.getProfile(true);
     */
    public String getProfile(boolean show) {
        StringBuffer ProfileStr = new StringBuffer();
        ProfileStr.append("Username : ").append(getUserName());
        ProfileStr.append("\nEmail : ").append(getEmail());
        ProfileStr.append("\nFirst Name : ").append(getFirstName());
        ProfileStr.append("\nLast Name : ").append(getLastName());
        ProfileStr.append("\nAddress : ").append(getAddress());
        if (show) {
            System.out.println("Username : " + getUserName());
            System.out.println("\nEmail : " + getEmail());
            System.out.println("\nFirst Name : " + getFirstName());
            System.out.println("\nLast Name : " + getLastName());
            System.out.println("\nAddress : " + getAddress());
        }
        String Profile = new String(ProfileStr);
        return Profile;
    }

    public void updateProfile(int choice) throws IOException {
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        switch (choice) {
            case 1 ->
                updateUsername(check, sc);
            case 2 ->
                updateEmail(check, sc);
            case 3 ->
                updateName(check, sc);
            case 4 ->
                updateAddress(check, sc);
        }
    }

    public QuestionBank createQuestionBank() {
        Scanner sc = new Scanner(System.in);
        CategoryDAO CDB = new CategoryDAO();
        QuestionBankDAO QBDB = new QuestionBankDAO();
        List<Category> CategoryList = CDB.getCategoriesList();

        if (!CategoryList.isEmpty()) {
            System.out.println("The available Categories to Choose From: ");

            // Display all categories with proper numbering
            for (int i = 0; i < CategoryList.size(); i++) {
                System.out.println((i + 1) + " _ " + CategoryList.get(i).getName());
                System.out.println(CategoryList.get(i).getDescription());
                System.out.println("");
            }

            // Get and validate user input
            int key;
            Category selectedCategory = null;
            boolean validInput = false;

            do {
                try {
                    System.out.print("Enter the number of your chosen category (1-" + CategoryList.size() + "): ");
                    key = sc.nextInt();

                    // Check if the input is within valid range
                    if (key >= 1 && key <= CategoryList.size()) {
                        UUID userUuid = getUserId();
                        List<QuestionBank> currentQuestionBanks = QBDB.searchByCreator(userUuid);
                        boolean isQuestionBankInCategory = false;

                        for (QuestionBank qb : currentQuestionBanks) {
                            if (qb.getCategoryID().equals(CategoryList.get(key - 1).getCategoryId())) {
                                isQuestionBankInCategory = true;
                                break;
                            }
                        }

                        if (!isQuestionBankInCategory) {
                            selectedCategory = CategoryList.get(key - 1);
                            validInput = true;
                        } else {
                            ifColorfullPrintln("There Exists QuestionBank for this Category", TerminalColors.YELLOW);
                        }
                    } else {
                        ifColorfullPrintln("Invalid input! Please enter a number between 1 and " + CategoryList.size(), TerminalColors.BOLD_RED);
                    }
                } catch (InputMismatchException e) {
                    ifColorfullPrintln("Invalid input! Please enter a valid number.", TerminalColors.BOLD_RED);
                    sc.nextLine(); // Clear the invalid input
                }
            } while (!validInput);

            // Create the question bank with the selected category
            if (selectedCategory != null) {
                LocalDate creationDate = LocalDate.now();
                QuestionBank NewQB = createQuestionBank(this, selectedCategory, creationDate);
                return NewQB;
            }
        } else {
            TestGeneratorApp.ifColorfullPrintln("Sorry! There are no Categories available", TerminalColors.YELLOW);
            return null;
        }
        return null;
    }

    public QuestionBank createQuestionBank(User creator, Category category, LocalDate creationDate) {
        QuestionBank newBank;
        try {
            newBank = new QuestionBank(creator.getUserId(), category.getCategoryId(), creationDate);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            QBDB.saveQuestionBank(newBank);
        } catch (Exception e) {
            System.out.println("Error creating question bank: " + e.getMessage());
            return null;
        }
        return newBank;
    }

    public boolean deleteQuestionBank(QuestionBank questionBank) {
        try {
            QuestionBankDAO QBDB = new QuestionBankDAO();
            QBDB.deleteQuestionBank(questionBank.getBankID());
        } catch (Exception e) {
            System.out.println("Error deleting question bank: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Protected helper methods that can be used by subclasses
    protected void printUpdateMenu() {
        System.out.println("-1 --> Return to Previous Menu");
        System.out.println(" 1 --> Update Username");
        System.out.println(" 2 --> Update Email");
        System.out.println(" 3 --> Update Name");
        System.out.println(" 4 --> Update Address");

    }

    protected void updateUsername(Checker check, Scanner sc) {
        String newUsername = validateUniqueInput(sc, check, "Enter New UserName : ", Checker.StringType.USERNAME, "Invalid username. Please try again.", User::isUsernameTaken);
        //update the object
        this.setUserName(newUsername);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        ifColorfullPrintln("Username updated successfully!",TerminalColors.BOLD_GREEN);
    }

    protected void updateEmail(Checker check, Scanner sc) {
        String newEmail = validateUniqueInput(sc, check, "Enter New Email : ", Checker.StringType.EMAIL, "Invalid Email , please try again", User::isEmailTaken);
        //updating the object
        this.setEmail(newEmail);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        ifColorfullPrintln("Email updated successfully!",TerminalColors.BOLD_GREEN);
    }

    protected void updateName(Checker check, Scanner sc) throws IOException {
        // Update First Name
        String newFirstName;
        do {
            System.out.println("Enter new first name: ");
            newFirstName = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newFirstName)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newFirstName));
        //updating the object
        this.setFirstName(newFirstName);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        // Update Last Name
        String newLastName;
        do {
            System.out.println("Enter new last name: ");
            newLastName = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newLastName)) {
                System.out.println("Invalid last name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newLastName));
        //update the object
        this.setLastName(newLastName);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        System.out.println("Name updated successfully!");
    }

    protected void updateAddress(Checker check, Scanner sc) throws IOException {
        // Get Country
        String newCountry;
        do {
            System.out.println("Enter new country: ");
            newCountry = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newCountry)) {
                System.out.println("Invalid country name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newCountry));

        // Get City
        String newCity;
        do {
            System.out.println("Enter new city: ");
            newCity = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newCity)) {
                System.out.println("Invalid city name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newCity));

        // Get Street
        String newStreet;
        do {
            System.out.println("Enter new street name: ");
            newStreet = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newStreet)) {
                System.out.println("Invalid street name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newStreet));

        String newAddress = newStreet + " , " + newCity + " , " + newCountry;
        //update the object
        this.setAddress(newAddress);
        //updating the equivalent JSON
        if (this instanceof Admin admin) {
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        if (this instanceof Student student) {
            StudentDAO SDB = new StudentDAO();
            SDB.updateStudent(student);
        }
        updateEquivalentCategoryAndQuestionBank();
        System.out.println("Address updated successfully!");
    }

    private static User findEmail(String email) {
        AdminDAO ADB = new AdminDAO();
        StudentDAO SDB = new StudentDAO();
        if (ADB.searchAdminByEmail(email) != null) {
            return ADB.searchAdminByEmail(email);
        } else if (SDB.searchStudentByEmail(email) != null) {
            return SDB.searchStudentByEmail(email);
        } else {
            return null;
        }

    }

    private static User findUserName(String userName) {
        AdminDAO ADB = new AdminDAO();
        StudentDAO SDB = new StudentDAO();
        if (ADB.searchAdmin(userName) != null) {
            return ADB.searchAdmin(userName);
        } else if (SDB.searchStudent(userName) != null) {
            return SDB.searchStudent(userName);
        } else {
            return null;
        }
    }

    // Helper methods to check uniqueness
    private static boolean isUsernameTaken(String username) {
        return findUserName(username) == null;
    }

    private static boolean isEmailTaken(String email) {
        return findEmail(email) == null;
    }

    //database management
    public void updateEquivalentCategoryAndQuestionBank() {
        CategoryDAO C = new CategoryDAO();
        QuestionBankDAO Q = new QuestionBankDAO();
        if (this instanceof Admin) {
            for (Category category : C.getCategoriesList()) {
                if (category.getCreator().getUserId().equals(getUserId())) {
                    category.setCreator((Admin) this);
                    C.updateCategory(category);
                }
            }
        }
        for (QuestionBank questionBank : Q.getQuestionBanksList()) {
            if (questionBank.getCreatorID().equals(getUserId())) {
                questionBank.setCreatorID(getUserId());
                Q.updateQuestionBank(questionBank);
            }
        }
    }

    public void updateEquivalentCategoryAndQuestionBank(User user) {
        CategoryDAO C = new CategoryDAO();
        QuestionBankDAO Q = new QuestionBankDAO();
        if (user instanceof Admin) {
            for (Category category : C.getCategoriesList()) {
                if (category.getCreator().getUserId().equals(getUserId())) {
                    category.setCreator((Admin) user);
                    C.updateCategory(category);
                }
            }
        }
        for (QuestionBank questionBank : Q.getQuestionBanksList()) {
            if (questionBank.getCreatorID().equals(getUserId())) {
                questionBank.setCreatorID(user.getUserId());
                Q.updateQuestionBank(questionBank);
            }
        }
    }

    /**
     * checks if the given password is equal to the password of the admin ensures better security than accessing the * getpassword() directly from outside the class
     *
     * @return Boolean if equal or not
     */
    public boolean verifyPassword(String password) {
        return password != null && this.getPassword().equals(password);
    }
}
