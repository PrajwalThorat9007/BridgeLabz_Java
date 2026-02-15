package collection.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserRegistrationValidator {

    // UC1: Validate First Name - starts with capital letter, minimum 3 characters
    public static boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    // UC2: Validate Last Name - starts with capital letter, minimum 3 characters
    public static boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    // UC3: Validate Email - format: abc.xyz@bl.co.in
    // 3 mandatory parts (abc, bl, co) and 2 optional (xyz, in)
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // UC4: Validate Mobile Number - country code followed by space and 10-digit number
    // Format: 91 9919819801
    public static boolean validateMobileNumber(String mobile) {
        String regex = "^[0-9]{1,3}\\s[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    // UC5: Validate Password Rule 1 - minimum 8 characters
    public static boolean validatePasswordRule1(String password) {
        return password.length() >= 8;
    }

    // UC6: Validate Password Rule 2 - at least 1 uppercase letter
    public static boolean validatePasswordRule2(String password) {
        String regex = ".*[A-Z].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // UC7: Validate Password Rule 3 - at least 1 numeric digit
    public static boolean validatePasswordRule3(String password) {
        String regex = ".*[0-9].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // UC8: Validate Password Rule 4 - exactly 1 special character
    public static boolean validatePasswordRule4(String password) {
        String regex = "^[^!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?]*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?][^!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Combined Password Validation - All rules must pass
    public static boolean validatePassword(String password) {
        return validatePasswordRule1(password) &&
                validatePasswordRule2(password) &&
                validatePasswordRule3(password) &&
                validatePasswordRule4(password);
    }

    // UC9: Comprehensive Email Validation (stricter version)
    public static boolean validateEmailStrict(String email) {
        // More strict email validation
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test First Name
        System.out.println("=== Testing First Name ===");
        System.out.println("John: " + validateFirstName("John")); // true
        System.out.println("jo: " + validateFirstName("jo")); // false
        System.out.println("john: " + validateFirstName("john")); // false

        // Test Last Name
        System.out.println("\n=== Testing Last Name ===");
        System.out.println("Smith: " + validateLastName("Smith")); // true
        System.out.println("sm: " + validateLastName("sm")); // false

        // Test Email
        System.out.println("\n=== Testing Email ===");
        System.out.println("abc.xyz@bl.co.in: " + validateEmail("abc.xyz@bl.co.in")); // true
        System.out.println("abc@bl.co: " + validateEmail("abc@bl.co")); // true
        System.out.println("abc@.co.in: " + validateEmail("abc@.co.in")); // false

        // Test Mobile Number
        System.out.println("\n=== Testing Mobile Number ===");
        System.out.println("91 9919819801: " + validateMobileNumber("91 9919819801")); // true
        System.out.println("919919819801: " + validateMobileNumber("919919819801")); // false

        // Test Password Rules
        System.out.println("\n=== Testing Password ===");
        String validPassword = "Password1@";
        System.out.println("Password1@");
        System.out.println("  Rule 1 (min 8 chars): " + validatePasswordRule1(validPassword));
        System.out.println("  Rule 2 (1 uppercase): " + validatePasswordRule2(validPassword));
        System.out.println("  Rule 3 (1 numeric): " + validatePasswordRule3(validPassword));
        System.out.println("  Rule 4 (exactly 1 special): " + validatePasswordRule4(validPassword));
        System.out.println("  Overall: " + validatePassword(validPassword));

        String invalidPassword = "pass";
        System.out.println("\npass");
        System.out.println("  Overall: " + validatePassword(invalidPassword));
    }
}