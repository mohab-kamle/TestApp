package UserDefinedFunctionalities;

/**
 *
 * @author mohab
 */
public class TerminalColors {
    // ANSI color codes
    public static final String RESET = "\033[0m";
    // Text Colors
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    
    // Bold Text Colors
    public static final String BOLD_BLACK = "\033[1;30m";
    public static final String BOLD_RED = "\033[1;31m";
    public static final String BOLD_GREEN = "\033[1;32m";
    public static final String BOLD_YELLOW = "\033[1;33m";
    public static final String BOLD_BLUE = "\033[1;34m";
    public static final String BOLD_PURPLE = "\033[1;35m";
    public static final String BOLD_CYAN = "\033[1;36m";
    public static final String BOLD_WHITE = "\033[1;37m";
    
    // Background Colors
    public static final String BG_BLACK = "\033[40m";
    public static final String BG_RED = "\033[41m";
    public static final String BG_GREEN = "\033[42m";
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";
    public static final String BG_PURPLE = "\033[45m";
    public static final String BG_CYAN = "\033[46m";
    public static final String BG_WHITE = "\033[47m";

    /**
     * Prints colored text to the console
     * 
     * @param text The text to print
     * @param color The color to apply
     */
    public static void printColored(String text, String color) {
        System.out.println(color + text + RESET);
    }

    /**
     * Prints colored text without a new line
     * 
     * @param text The text to print
     * @param color The color to apply
     */
    public static void printColoredNoNewLine(String text, String color) {
        System.out.print(color + text + RESET);
    }

    /**
     * Checks if the current terminal supports ANSI colors
     * 
     * @return true if ANSI colors are supported, false otherwise
     */
    public static boolean supportsAnsiColors() {
        String os = System.getProperty("os.name").toLowerCase();
        return !os.contains("win") || System.console() != null;
    }
}
