package TestSystem;

import EndUser.Admin;
import java.io.IOException;
import java.util.Scanner;
import javax.mail.MessagingException;
/**
 * Git WorkFlow for The contributors
 * 1_make sure you cloned the repo correct(added remote or cloned directly ...etc).
 * 2_switch to your Branch which is the first or two characters of your name.
 * 3_command in terminal of the project Folder/app : "git pull origin main".
 * 4_make the required edits then commit your work (any number of commits you want).
 * 5_command : "git push origin [your branch name]".
 * 6_open github and make a pull request.
 * 7_wait for review to merge your code.
 * 8_you successfully contributed to your beloved project :) !
 */
/**
 *
 * @author mohab
 */

public class TestGeneratorApp {

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
                    case 6 -> {
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
