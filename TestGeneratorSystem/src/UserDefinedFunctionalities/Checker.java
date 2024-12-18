package UserDefinedFunctionalities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mohab
 *
 */
public class Checker {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._]{3,20}$";
    private static final String PASS_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$";
    private static final String LETTERSONLY_REGEX = "^[A-Za-z]+$";
    private static final String LETTERS_NUMS_UNDERSCORE_REGEX = "^[A-Za-z0-9_ ]+$";
    private static final String PHONE_REGEX = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    public enum StringType {
        EMAIL, USERNAME, PASSWORD, LETTERS_ONLY, PHONE_NO , LETTERS_NUMS_UNDERSCORE;
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

            case USERNAME-> {
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
            case LETTERS_NUMS_UNDERSCORE -> {
                p = Pattern.compile(LETTERS_NUMS_UNDERSCORE_REGEX);
                m = p.matcher(CheckString);
                return m.matches();
            }
            default ->
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
    

}