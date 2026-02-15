package collection.regex;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {

    // Condition 1: Must contain "@" symbol
    public static boolean hasAtSymbol(String email) {
        String regex = ".*@.*";
        return Pattern.matches(regex, email);
    }

    // Condition 2: TLD (domain after @) cannot start with dot "."
    public static boolean tldNotStartWithDot(String email) {
        String regex = "^[^@]+@[^.].*";
        return Pattern.matches(regex, email);
    }

    // Condition 3: TLD must contain at least two characters after last dot
    public static boolean tldHasMinTwoChars(String email) {
        String regex = ".*@.*\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Condition 4: Domain (after @) cannot start with dot "."
    public static boolean domainNotStartWithDot(String email) {
        String regex = "^[^@]+@[^.].*";
        return Pattern.matches(regex, email);
    }

    // Condition 5: Domain must contain at least one dot "."
    public static boolean domainContainsDot(String email) {
        String regex = ".*@.*\\..*";
        return Pattern.matches(regex, email);
    }

    // Condition 6: Email's first character cannot be special character
    public static boolean firstCharNotSpecial(String email) {
        String regex = "^[a-zA-Z0-9].*";
        return Pattern.matches(regex, email);
    }

    // Condition 7: Local part (before @) only allows alphanumeric, underscore, and dash
    public static boolean localPartValidCharacters(String email) {
        String regex = "^[a-zA-Z0-9._-]+@.*";
        return Pattern.matches(regex, email);
    }

    // Condition 8: TLD only allows alphanumeric characters
    public static boolean tldOnlyAlphanumeric(String email) {
        String regex = ".*@.*\\.[a-zA-Z0-9]+$";
        return Pattern.matches(regex, email);
    }

    // Condition 9: Double dots ".." are not allowed
    public static boolean noDoubleDots(String email) {
        String regex = "^(?!.*\\.\\.).*$";
        return Pattern.matches(regex, email);
    }

    // Condition 10: Local part's (before @) last character cannot be dot
    public static boolean localPartNotEndWithDot(String email) {
        String regex = "^[^@]+[^.]@.*";
        return Pattern.matches(regex, email);
    }

    // Condition 11: Double "@" is not allowed (must have exactly one @)
    public static boolean noDoubleAtSymbol(String email) {
        String regex = "^[^@]+@[^@]+$";
        return Pattern.matches(regex, email);
    }

    // Condition 12: TLD with two characters cannot contain digits
    public static boolean tldNoDigitsInExtension(String email) {
        // Check if the TLD parts (after domain name) don't contain digits
        String regex = ".*@[a-zA-Z0-9-]+\\.[a-zA-Z]+(?:\\.[a-zA-Z]+)?$";
        return Pattern.matches(regex, email);
    }

    // Condition 13: Cannot have multiple @ symbols (duplicate of condition 11)
    public static boolean singleAtSymbol(String email) {
        return noDoubleAtSymbol(email);
    }

    // Additional: Local part cannot start with dot
    public static boolean localPartNotStartWithDot(String email) {
        String regex = "^[^.].*@.*";
        return Pattern.matches(regex, email);
    }

    // Additional: Local part cannot have consecutive dots
    public static boolean noConsecutiveDotsInLocalPart(String email) {
        if (!email.contains("@")) return false;
        String localPart = email.split("@")[0];
        return !localPart.contains("..");
    }

    // Additional: Domain cannot end with dot
    public static boolean domainNotEndWithDot(String email) {
        String regex = ".*@.*[^.]$";
        return Pattern.matches(regex, email);
    }

    // Comprehensive validation using complete regex pattern
    public static boolean isValidEmailRegex(String email) {
        // Complete regex pattern covering all conditions
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._-]*[a-zA-Z0-9]@[a-zA-Z0-9]+([.-][a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Validate all conditions individually
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return hasAtSymbol(email) &&
                tldNotStartWithDot(email) &&
                tldHasMinTwoChars(email) &&
                domainNotStartWithDot(email) &&
                domainContainsDot(email) &&
                firstCharNotSpecial(email) &&
                localPartValidCharacters(email) &&
                tldOnlyAlphanumeric(email) &&
                noDoubleDots(email) &&
                localPartNotEndWithDot(email) &&
                noDoubleAtSymbol(email) &&
                tldNoDigitsInExtension(email) &&
                localPartNotStartWithDot(email) &&
                domainNotEndWithDot(email);
    }

    // Detailed validation with error messages
    public static void validateEmailWithDetails(String email) {
        System.out.println("\n=== Validating: " + email + " ===");
        System.out.println("1. Has @ symbol: " + hasAtSymbol(email));
        System.out.println("2. TLD not start with dot: " + tldNotStartWithDot(email));
        System.out.println("3. TLD has min 2 chars: " + tldHasMinTwoChars(email));
        System.out.println("4. Domain not start with dot: " + domainNotStartWithDot(email));
        System.out.println("5. Domain contains dot: " + domainContainsDot(email));
        System.out.println("6. First char not special: " + firstCharNotSpecial(email));
        System.out.println("7. Local part valid chars: " + localPartValidCharacters(email));
        System.out.println("8. TLD only alphanumeric: " + tldOnlyAlphanumeric(email));
        System.out.println("9. No double dots: " + noDoubleDots(email));
        System.out.println("10. Local part not end with dot: " + localPartNotEndWithDot(email));
        System.out.println("11. No double @ symbol: " + noDoubleAtSymbol(email));
        System.out.println("12. TLD no digits in extension: " + tldNoDigitsInExtension(email));
        System.out.println("13. Local part not start with dot: " + localPartNotStartWithDot(email));
        System.out.println("14. Domain not end with dot: " + domainNotEndWithDot(email));
        System.out.println("==> OVERALL VALID: " + isValidEmail(email));
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("========== VALID EMAILS ==========");
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        for (String email : validEmails) {
            System.out.println(email + " : " + isValidEmail(email));
        }

        System.out.println("\n========== INVALID EMAILS ==========");
        String[] invalidEmails = {
                "abc",                      // 1. Must contain @ symbol
                "abc@.com.my",              // 2. TLD cannot start with dot
                "abc123@gmail.a",           // 3. TLD must have at least 2 chars
                "abc123@.com",              // 4. Domain cannot start with dot
                "abc123@.com.com",          // 5. Domain cannot start with dot
                ".abc@abc.com",             // 6. First char cannot be special
                "abc()*@gmail.com",         // 7. Local part invalid characters
                "abc@%*.com",               // 8. TLD only alphanumeric
                "abc..2002@gmail.com",      // 9. No double dots
                "abc.@gmail.com",           // 10. Local part cannot end with dot
                "abc@abc@gmail.com",        // 11. Double @ not allowed
                "abc@gmail.com.1a",         // 12. TLD cannot contain digits
                "abc@gmail.com.aa.au"       // 13. Multiple TLD parts
        };

        for (String email : invalidEmails) {
            System.out.println(email + " : " + isValidEmail(email));
        }

        // Detailed validation examples
        System.out.println("\n========== DETAILED VALIDATION ==========");
        validateEmailWithDetails("abc@yahoo.com");
        validateEmailWithDetails("abc@.com.my");
        validateEmailWithDetails("abc..2002@gmail.com");
        validateEmailWithDetails("abc@abc@gmail.com");
    }
}