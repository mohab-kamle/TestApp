package testgeneratorsystem;

import UserDefinedFunctionalities.Checker;
import java.io.Console;
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
        this.setPassword(newPass);
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
                    User.findEmail(EmailInput).setPassword(newPass);
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
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 ->
                        updateUsername(check, sc);
                    case 2 ->
                        updateEmail(check, sc);
                    case 3 ->
                        updateName(check, sc);
                    case 4 ->
                        updateAddress(check, sc);
                    case -1 ->
                        System.out.println("Returning to previous menu...");
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // clear the invalid input
                choice = 0;
            }
        } while (choice != -1);
    }

    public boolean createQuestionBank() {
        return false;
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
        this.setUserName(newUsername);
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
        this.setEmail(newEmail);
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
        this.setFirstName(newFirstName);

        // Update Last Name
        String newLastName;
        do {
            System.out.println("Enter new last name: ");
            newLastName = sc.nextLine();
            if (!check.isValid(Checker.StringType.LETTERS_ONLY, newLastName)) {
                System.out.println("Invalid last name. Please try again.");
            }
        } while (!check.isValid(Checker.StringType.LETTERS_ONLY, newLastName));
        this.setLastName(newLastName);

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
        this.setAddress(newAddress);
        System.out.println("Address updated successfully!");
    }

    private static User findEmail(String email) {
        for (Admin admin : Admin.getListOfAdmins()) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }
    private static User findUserName(String userName) {
        for (Admin admin : Admin.getListOfAdmins()) {
            if (admin.getUserName().equals(userName)) {
                return admin;
            }
        }
        return null;
    }
}
