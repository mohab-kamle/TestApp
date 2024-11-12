package TestSystem;

import EndUser.Admin;
import EndUser.Student;
import EndUser.User;
import UserDefinedFunctionalities.TerminalColors;
import java.io.IOException;
import java.util.Scanner;
import javax.mail.MessagingException;

/**
 * Git WorkFlow for The contributors 
 * //1_make sure you cloned the repo correct(added remote or cloned directly ...etc). 
 * //2_switch to your Branch which is the first or two characters of your name. 
 * //3_command in terminal of the project Folder/app : "git pull origin main". 
 * //4_make the required edits then commit your work (any number of commits you want). 
 * //5_command : "git push origin [your branch name]". 
 * //6_open github and make a pull request. 
 * //7_wait for review to merge your code. 
 * //8_you successfully contributed to your beloved project :) !
 */
/**
 * @version 1.0
 * @author mohab
 */
public class TestGeneratorApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;
    public static void main(String[] args) throws IOException {
        runMainApplication();
    }

    /**
     * Main application entry point and control flow
     */
    private static void runMainApplication() throws IOException {
        while (true) {
            try {
                displayMainMenu();
                int choice = getUserChoice();

                switch (choice) {
                    case 1 ->
                        handleAdminOperations();
                    case 2 ->
                        handleStudentOperations();
                    case 0 ->
                        exitApplication();
                    default ->
                        handleInvalidChoice();
                }
            } catch (MessagingException e) {
                handleException(e);
            }
        }
    }

    /**
     * Displays the main menu options
     */
    private static void displayMainMenu() {
        clearConsole();
        ifColorfullPrintln("===== Online Test Management System =====", TerminalColors.BOLD_BLUE);
        System.out.println("1. Admin Portal");
        System.out.println("2. Student Portal");
        System.out.println("0. Exit Application");  
        ifColorfullPrint("Enter your choice: ", TerminalColors.CYAN);}

    /**
     * Handles Admin-specific operations
     */
    private static void handleAdminOperations() throws MessagingException, IOException {
        while (true) {
            displayAdminMenu();
            int adminChoice = getUserChoice();

            switch (adminChoice) {
                case 1 ->
                    performAdminSignUp();
                case 2 ->
                    performAdminLogin();
                case 3 ->
                    performAdminPasswordReset();
                case 0 -> {
                    return;
                }
                default ->
                    handleInvalidChoice();
            }
        }
    }

    /**
     * Displays Admin portal menu
     */
    private static void displayAdminMenu() {
        clearConsole();
        ifColorfullPrintln("===== Admin Portal =====",TerminalColors.BOLD_BLUE);
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Reset Password");
        System.out.println("0. Back to Main Menu");
        ifColorfullPrint("Enter your choice: ", TerminalColors.CYAN);
    }

    /**
     * Performs Admin sign-up process
     */
    private static void performAdminSignUp() {
        clearConsole();
        System.out.println("===== Admin Sign Up =====");
        Admin.signUp();
        pressAnyKeyToContinue();
    }

    /**
     * Performs Admin login process
     */
    private static void performAdminLogin() throws IOException {
        clearConsole();
        ifColorfullPrintln("===== Admin Login =====", TerminalColors.BOLD_BLUE);
        
        Admin loggedAdmin = new Admin().login();
        
        if (loggedAdmin != null) {
            ifColorfullPrintln(
                "Login Successful!", 
                TerminalColors.BOLD_GREEN
            );
            currentUser = loggedAdmin;
            handleAdminDashboard(loggedAdmin);
        } else {
            ifColorfullPrintln(
                "Login Failed. Invalid Credentials.", 
                TerminalColors.BOLD_RED
            );
            pressAnyKeyToContinue();
        }
    }

    /**
     * Handles Admin dashboard and operations after login
     */
    private static void handleAdminDashboard(Admin admin) throws IOException {
        while (true) {
            displayAdminDashboardMenu();
            int dashboardChoice = getUserChoice();

            switch (dashboardChoice) {
                case 1 ->
                    admin.getProfile(true);
                case 2 ->
                    admin.updateProfile();
                case 3 -> {
                    if (admin.changePassword()) {
                        return;
                    }
                }
                case 4 -> {
                    if (confirmAccountRemoval()) {
                        admin.removeAccount();
                        return;
                    }
                }
                case 5 ->{
                    if (admin.createCategory()) {
                        ifColorfullPrintln("Category Created succesfully !!", TerminalColors.BOLD_GREEN);
                    }else{
                        ifColorfullPrintln("Category couldn't be created", TerminalColors.BOLD_RED);
                    }
                }
                case 6 ->{
                    if (admin.modifyCategory()) {
                        ifColorfullPrintln("Category has been updated succesfully !!", TerminalColors.BOLD_GREEN);
                    }else{
                        ifColorfullPrintln("Categories still the same..", TerminalColors.BOLD_RED);
                    }
                }
                case 7 ->{
                    if (admin.deleteCategory()) {
                        ifColorfullPrintln("Category has been deleted !!", TerminalColors.BOLD_GREEN);
                    }else{
                        ifColorfullPrintln("NoThing is Deleted..", TerminalColors.BOLD_RED);
                    }
                }
                case 8 -> {
                    if(admin.createQuestionBank()){
                        ifColorfullPrintln("Question Bank Created succesfully !!", TerminalColors.BOLD_GREEN);
                    }else{
                        ifColorfullPrintln("Question Bank couldn't be created", TerminalColors.BOLD_RED);
                    }
                }
                case 0 -> {
                    return;
                }
                default ->
                    handleInvalidChoice();
            }
            pressAnyKeyToContinue();
        }
    }

    /**
     * Displays Admin dashboard menu
     */
    private static void displayAdminDashboardMenu() {
        clearConsole();
        ifColorfullPrintln("===== Admin Dashboard =====",TerminalColors.PURPLE);
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Change Password");
        System.out.println("4. Remove Account");
        System.out.println("5. Create Category");
        System.out.println("6. modify Category");
        System.out.println("7. delete Category");
        System.out.println("8. Create Question Bank");
//        System.out.println("6. View My Question Banks");
//        System.out.println("7. delete Question Bank");
        System.out.println("0. Logout");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles Student-specific operations
     */
    private static void handleStudentOperations() throws MessagingException, IOException {
        while (true) {
            displayStudentMenu();
            int studentChoice = getUserChoice();

            switch (studentChoice) {
                case 1 ->
                    performStudentSignUp();
                case 2 ->
                    performStudentLogin();
                case 3 ->
                    performStudentPasswordReset();
                case 0 -> {
                    return;
                }
                default ->
                    handleInvalidChoice();
            }
        }
    }

    /**
     * Displays Student portal menu
     */
    private static void displayStudentMenu() {
        clearConsole();
        ifColorfullPrintln("===== Student Portal =====",TerminalColors.PURPLE);
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Reset Password");
        System.out.println("0. Back to Main Menu");
        ifColorfullPrint("Enter your choice: ",TerminalColors.CYAN);
    }

    /**
     * Performs Student sign-up process
     */
    private static void performStudentSignUp() {
        clearConsole();
        System.out.println("===== Student Sign Up =====");
        Student.signUp();
        pressAnyKeyToContinue();
    }

    /**
     * Performs Student login process
     */
    private static void performStudentLogin() throws IOException {
        clearConsole();
        System.out.println("===== Student Login =====");
        Student loggedStudent = new Student().login();

        if (loggedStudent != null) {
            handleStudentDashboard(loggedStudent);
        } else {
            System.out.println("Login Failed. Invalid Credentials.");
            pressAnyKeyToContinue();
        }
    }

    /**
     * Handles Student dashboard and operations after login
     */
    private static void handleStudentDashboard(Student student) throws IOException {
        while (true) {
            displayStudentDashboardMenu();
            int dashboardChoice = getUserChoice();

            switch (dashboardChoice) {
                case 1 ->
                    student.getProfile(true);
                case 2 ->
                    student.updateProfile();
                case 3 -> {
                    if (student.changePassword()) {
                        return;
                    }
                }
                case 4 -> {
                    if (confirmAccountRemoval()) {
                        student.removeAccount();
                        return;
                    }
                }
                case 5 -> {
                    student.takeTest();
                }
                case 0 -> {
                    return;
                }
                default ->
                    handleInvalidChoice();
            }
            pressAnyKeyToContinue();
        }
    }

    /**
     * Displays Student dashboard menu
     */
    private static void displayStudentDashboardMenu() {
        clearConsole();
        System.out.println("===== Student Dashboard =====");
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Change Password");
        System.out.println("4. Remove Account");
        System.out.println("5. Take Test");
        System.out.println("0. Logout");
        System.out.print("Enter your choice: ");
    }

    /**
     * Performs password reset for Admin
     */
    private static void performAdminPasswordReset() throws MessagingException {
        clearConsole();
        System.out.println("===== Admin Password Reset =====");
        new Admin().resetPassword();
        pressAnyKeyToContinue();
    }

    /**
     * Performs password reset for Student
     */
    private static void performStudentPasswordReset() throws MessagingException {
        clearConsole();
        System.out.println("===== Student Password Reset =====");
        new Student().resetPassword();
        pressAnyKeyToContinue();
    }

    /**
     * Confirms account removal
     *
     * @return true if the user confirms, false otherwise
     */
    private static boolean confirmAccountRemoval() {
        System.out.print("Are you sure you want to remove your account? (y/n): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("y");
    }

    /**
     * Gets user choice from input
     *
     * @return the integer choice made by the user
     */
    private static int getUserChoice() {
        return scanner.nextInt();
    }

    /**
     * Handles invalid user choices
     */
    private static void handleInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
        pressAnyKeyToContinue();
    }

    /**
     * Exits the application
     */
    private static void exitApplication() {
        System.out.println("Thank you for using the Online Test Management System. Goodbye!");
        System.exit(0);
    }

    /**
     * Handles exceptions
     *
     * @param e the exception to handle
     */
    private static void handleException(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        pressAnyKeyToContinue();
    }

    /**
     * Clears the console for better readability
     */
    private static void clearConsole() {
        // a way to clear the console, may not work on all systems
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prompts the user to press any key to continue
     */
    private static void pressAnyKeyToContinue() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Consume the newline
        scanner.nextLine(); // Wait for user input
    }
    
    //methods to check if it supports colors and prints
    public static void ifColorfullPrintln(String text,String color){
        if (TerminalColors.supportsAnsiColors()) {
            TerminalColors.printColored(text,color);
        } else {
            // Fallback to normal printing if ANSI colors not supported
            System.out.println(text);
        }
    }
    public static void ifColorfullPrint(String text,String color){
        if (TerminalColors.supportsAnsiColors()) {
            TerminalColors.printColoredNoNewLine(text,color);
        } else {
            // Fallback to normal printing if ANSI colors not supported
            System.out.print(text);
        }
    }
}
