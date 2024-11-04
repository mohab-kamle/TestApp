package testgeneratorsystem;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;

/**
 *
 * @author mohab
 *
 */
public class TestGeneratorSystem {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._]{3,20}$";
    private static final String PASS_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$";
    private static final String LETTERSONLY_REGEX = "^[A-Za-z]+$";
    private static final String PHONE_REGEX = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    public enum StringType {
        EMAIL, USERNAME, PASSWORD, LETTERS_ONLY, PHONE_NO;
    }

    public boolean isValid(StringType type, String CheckString) {
        Pattern p;
        Matcher m;
        switch (type) {
            case EMAIL -> {
                p = Pattern.compile(EMAIL_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }

            case USERNAME -> {
                p = Pattern.compile(USERNAME_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }
            case PASSWORD -> {
                p = Pattern.compile(PASS_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }
            case LETTERS_ONLY -> {
                p = Pattern.compile(LETTERSONLY_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }
            case PHONE_NO -> {
                p = Pattern.compile(PHONE_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }
            default ->
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) throws MessagingException, IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printWelcomeMessage();
            int key = sc.nextInt();
            Admin loggedAdmin = null; // Dummy
            while (key != -1) {
                switch (key) {
                    case 0 -> {
                        Admin.signUp();
                        System.out.println("Enter 1 to login or -1 to main menu");
                        key = sc.nextInt();
                    }
                    case 1 -> {
                        if (loggedAdmin != null) {
                            printMyAccountMenu();
                            key = sc.nextInt();
                        } else {
                            System.out.println("\n-- Login Page --");
                            loggedAdmin = new Admin().login();
                            if (loggedAdmin == null) {
                                System.out.println("The credentials are not correct");
                                printLoginActionsMenu();
                                key = sc.nextInt();
                            }
                        }
                    }
                    case 2 -> {
                        if (loggedAdmin != null) {
                            loggedAdmin.getProfile(true);
                            key = 1;
                        } else {
                            System.out.println("You need to log in first!");
                            key = 1; // Redirect to login
                        }
                    }
                    case 3 -> {
                        if (loggedAdmin != null) {
                            System.out.println("Are you sure you want to remove your account? y/n");
                            sc.nextLine();
                            String keyString = sc.nextLine();
                            switch (keyString) {
                                case "y" -> {
                                    loggedAdmin.removeAccount();
                                    System.out.println("We are looking forward to meeting you again \\^-^/\n");
                                    key = -1;
                                }
                                case "n" ->
                                    key = 2;
                                default ->
                                    System.out.println("This is a wrong input, please try again");
                            }
                        } else {
                            System.out.println("You need to log in first!");
                            key = 1; // Redirect to login
                        }
                    }
                    case 4 -> {
                        if (loggedAdmin != null) {
                            if (loggedAdmin.changePassword()) {
                                loggedAdmin = null;
                                key = 1;
                            } else {
                                key = 1;
                            }
                        } else {
                            System.out.println("You need to log in first!");
                            key = 1; // Redirect to login
                        }
                    }
                    case 5 -> {
                        if (new Admin().resetPassword()) {
                            key = 1;
                        } else {
                            key = -1;
                        }
                    }
                    case 6->{
                        if (loggedAdmin != null) {
                            loggedAdmin.updateProfile();
                            key = 1;
                        } else {
                            System.out.println("You need to log in first!");
                            key = 1; // Redirect to login
                        }
                    }
                    default -> {
                        System.out.println("Please enter a correct input");
                        printMainMenu();
                        key = sc.nextInt();
                    }
                }
            }
        }
    }

    private static void printWelcomeMessage() throws IOException, InterruptedException {
        System.out.println("***********************************");
        System.out.println("*   Welcome to our test System   *");
        System.out.println("***********************************");
        printMainMenu();

    }

    private static void printMainMenu() {
        System.out.println("|---> Main Menu <---|");
        System.out.println(" 0 --> Sign Up");
        System.out.println(" 1 --> Login");
        System.out.println("-1 --> Exit");
    }

    private static void printMyAccountMenu() {
        System.out.println("|---> My Account <---|");
        System.out.println(" 2 --> Show Profile");
        System.out.println(" 3 --> Remove Account");
        System.out.println(" 4 --> Change Password");
        System.out.println(" 6 --> Update Profile");
        System.out.println("-1 --> Main Menu");
    }

    private static void printLoginActionsMenu() {
        System.out.println("|---> Actions <---|");
        System.out.println(" 1 --> Try to Login Again");
        System.out.println(" 5 --> Reset Password");
        System.out.println("-1 --> Main Menu");
    }

}
//          //test signUp and login
//          Admin DummyAdmin = new Admin();
//          Admin.signUp();
//          ArrayList<Admin> AllAdmins = Admin.getListOfAdmins();
//          if(DummyAdmin.login()!=null){
//              DummyAdmin = DummyAdmin.login();
//              System.out.println("Welcome onboard");
//          }
//          else{
//              System.out.println("please Sign Up first");
//          }
//          System.out.println("Do you want to delete your account ? y/n");
//          Scanner sc = new Scanner(System.in);
//          String answer = sc.nextLine();
//          if(answer.equals("y")){
//              DummyAdmin.removeAccount();
//          }else{
//              System.out.println("ok you can live");
//          }
//          DummyAdmin.getProfile(true);
//        //test email
//        String email1 = "example123@domain.com";
//        String email2 = "invalid/email@domain";
//        System.out.println(email1 + " is valid: " + isValid(StringType.EMAIL,email1)); // true
//        System.out.println(email2 + " is valid: " + isValid(StringType.EMAIL, email2)); // false

