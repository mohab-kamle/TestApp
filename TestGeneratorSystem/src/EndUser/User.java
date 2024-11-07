package EndUser;

import DataBaseManagment.AdminDAO;
import DataBaseManagment.QuestionBankDAO;
import TestSystem.Category;
import TestSystem.QuestionBank;
import UserDefinedFunctionalities.Checker;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Console;
import java.time.LocalDate;
import java.util.*;
import javax.mail.MessagingException;

/**
 *
 * @author mohab
 */
public abstract class User {

    protected UUID userId;
    protected String email;
    protected String userName;
    protected String password;
    protected String address;
    protected String firstName;
    protected String lastName;
    protected Date lastLoginDate;

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
        this.lastLoginDate = new Date();
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

    public void setLastLoginDate(Date lastLoginDate) {
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

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    //methods
    /**
     * makes a new user sign up with the general data members
     * @return ArrayList of the common data members between the subclasses
     */
    public static ArrayList<String> signUp() {
        ArrayList<String> commonList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Checker check = new Checker();

        String userNameInput;
        do {
            System.out.println("Enter Username: ");
            userNameInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.USERNAME, userNameInput)) {
                System.out.println("Username must be 3 to 20 characters long and can only contain letters, numbers, dots, and underscores.");
            }
            if(findUserName(userNameInput)!=null){
                System.out.println("this username is already taken");
            }
        } while (!check.isValid(Checker.StringType.USERNAME, userNameInput)
                ||findUserName(userNameInput)!=null);
        commonList.add(userNameInput);

        String emailInput;
        do {
            System.out.println("\nEnter Email: ");
            emailInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.EMAIL, emailInput)) {
                System.out.println("Invalid email. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.EMAIL, emailInput));
        commonList.add(emailInput);

        String passwordInput = null;
        System.out.println("""
                                       the password must have the following specifications :
                                                           |-> length from 12 to 20
                                                           |-> at least one capital letter
                                                           |-> at least one small letter
                                                           |-> at least one special character
                                                           |-> at least one digit""");
        do {
            Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
                break;
            }

            char[] passwordArray = console.readPassword("\nEnter Password: ");
            passwordInput = new String(passwordArray);
            if (!check.isValid(Checker.StringType.PASSWORD, passwordInput)) {
                System.out.println("Invalid password. Please try again.");
            } else {
                System.out.println("Your password is securely read.");
            }
        } while (!check.isValid(Checker.StringType.PASSWORD, passwordInput));
        commonList.add(passwordInput);

        String firstNameInput;
        do {
            System.out.println("\nEnter First Name: ");
            firstNameInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, firstNameInput)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, firstNameInput));
        commonList.add(firstNameInput);

        String lastNameInput;
        do {
            System.out.println("\nEnter Last Name: ");
            lastNameInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, lastNameInput)) {
                System.out.println("Invalid last name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, lastNameInput));
        commonList.add(lastNameInput);

        String countryInput;
        do {
            System.out.println("\nEnter Country: ");
            countryInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, countryInput)) {
                System.out.println("Invalid country name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, countryInput));
        commonList.add(countryInput);

        String cityInput;
        do {
            System.out.println("\nEnter City: ");
            cityInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, cityInput)) {
                System.out.println("Invalid city name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, cityInput));
        commonList.add(cityInput);

        String streetNameInput;
        do {
            System.out.println("\nEnter Street name: ");
            streetNameInput = scanner.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, streetNameInput)) {
                System.out.println("Invalid street name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, streetNameInput));
        String address = streetNameInput + " , " + cityInput + " , " + countryInput;
        commonList.add(address);

        return commonList;
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
                                       
                           
                                       the password must have the following specifications :
                                       |-> length from 8 to 20
                                       |-> at least one capital letter
                                       |-> at least one small letter
                                       |-> at least one special character
                                       |-> at least one digit
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
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        System.out.println("The password has been changed successfully !");
        return true;
    }

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
                                       the password must have the following specifications :
                                                    |-> length from 12 to 20
                                                    |-> at least one capital letter
                                                    |-> at least one small letter
                                                    |-> at least one special character
                                                    |-> at least one digit""");
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
                    if(userToBeUpdated instanceof Admin admin){
                        AdminDAO ADB = new AdminDAO();
                        ADB.updateAdmin(admin);
                        }
                    System.out.println("The password has been changed successfully !");
                    return true;
                }
                case "n" -> {
                    return false;
                }
                default ->
                    System.out.println("Wrong input , please try again");
            }
        } while (!key.equals("y") || !key.equals("n"));
        return false;
    }

    public StringBuffer getProfile(boolean show) {
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
        return ProfileStr;
    }

    public void updateProfile(int choice) {
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

    public boolean createQuestionBank() {
        
    Scanner sc = new Scanner(System.in);
    ArrayList<Category> CategoryList = null; //placeholder for category array
    CategoryList.add(new Category());
    
    System.out.println("Enter the Category of The new Question Bank : ");
    
    // Display all categories with proper numbering
    for (int i = 0; i < CategoryList.size(); i++) {
        System.out.println((++i) + " _ " + CategoryList.get(i).getName());
        System.out.println(CategoryList.get(i).getDescription());
        System.out.println("");
    }
    
    // Get and validate user input
    int key;
    Category selectedCategory = null;
    boolean validInput = false;
    
    do {
        try {
            System.out.print("Enter the number of your chosen category (1-" + CategoryList.size() + "):");
            key = sc.nextInt();
            
            // Check if the input is within valid range
            if (key >= 1 && key <= CategoryList.size()) {
                selectedCategory = CategoryList.get(key - 1);
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and " + CategoryList.size());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.nextLine(); // Clear the invalid input
        }
    } while (!validInput);
    
    // Create the question bank with the selected category
    if (selectedCategory != null) {
        try {
            LocalDate creationDate = LocalDate.now();
            QuestionBank newBank = new QuestionBank(this,selectedCategory,creationDate);
            QuestionBankDAO QBDB = new QuestionBankDAO();
            QBDB.saveQuestionBank(newBank);
        } catch (Exception e) {
            System.out.println("Error creating question bank: " + e.getMessage());
            return false;
        }
    }
    
    return true;
}

    public boolean deleteQuestionBank() {
        return false;
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
        String newUsername;
        do {
            System.out.println("Enter new username: ");
            newUsername = sc.nextLine();
            if (!check.isValid(Checker.StringType.USERNAME, newUsername)) {
                System.out.println("Invalid username. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.USERNAME, newUsername));
        //update the object
        this.setUserName(newUsername);
        //updating the equivalent JSON
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        System.out.println("Username updated successfully!");
    }

    protected void updateEmail(Checker check, Scanner sc) {
        String newEmail;
        do {
            System.out.println("Enter new email: ");
            newEmail = sc.nextLine();
            if (!check.isValid(Checker.StringType.EMAIL, newEmail)) {
                System.out.println("Invalid email. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.EMAIL, newEmail));
        //updating the object
        this.setEmail(newEmail);
        //updating the equivalent JSON
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        System.out.println("Email updated successfully!");
    }

    protected void updateName(Checker check, Scanner sc) {
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
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
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
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        System.out.println("Name updated successfully!");
    }

    protected void updateAddress(Checker check, Scanner sc) {
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
        if(this instanceof Admin admin){
            AdminDAO ADB = new AdminDAO();
            ADB.updateAdmin(admin);
        }
        System.out.println("Address updated successfully!");
    }

    private static User findEmail(String email) {
        AdminDAO ADB = new AdminDAO();
        return ADB.searchAdminByEmail(email);
    }
    private static User findUserName(String userName) {
        AdminDAO ADB = new AdminDAO();
        return ADB.searchAdmin(userName);
    }
}