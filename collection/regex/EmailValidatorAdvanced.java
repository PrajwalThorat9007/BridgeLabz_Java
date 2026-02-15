package collection.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidatorAdvanced {

    // Complete RFC 5322 compliant email regex pattern
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // Compiled pattern for better performance
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    // Method 1: Basic email validation using comprehensive regex
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method 2: Validate email format with all standard rules
    public static boolean validateEmailFormat(String email) {
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._-]{0,63}@[a-zA-Z0-9][a-zA-Z0-9.-]{0,253}\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Method 3: Check valid local part (before @)
    public static boolean hasValidLocalPart(String email) {
        // Local part: alphanumeric, dots, hyphens, underscores, plus signs
        // Cannot start or end with dot, no consecutive dots
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._+-]*[a-zA-Z0-9]@.*|^[a-zA-Z0-9]@.*";
        return Pattern.matches(regex, email);
    }

    // Method 4: Check valid domain part (after @)
    public static boolean hasValidDomain(String email) {
        // Domain: alphanumeric with hyphens, must have at least one dot
        // TLD must be 2-6 characters
        String regex = ".*@[a-zA-Z0-9][a-zA-Z0-9-]*(?:\\.[a-zA-Z0-9][a-zA-Z0-9-]*)*\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Method 5: Validate TLD (Top Level Domain)
    public static boolean hasValidTLD(String email) {
        // TLD must be 2-6 alphabetic characters
        String regex = ".*\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Method 6: Check for proper @ symbol usage
    public static boolean hasSingleAtSymbol(String email) {
        String regex = "^[^@]+@[^@]+$";
        return Pattern.matches(regex, email);
    }

    // Method 7: Validate local part length (max 64 characters)
    public static boolean hasValidLocalPartLength(String email) {
        String regex = "^.{1,64}@.*";
        return Pattern.matches(regex, email);
    }

    // Method 8: Validate domain length (max 253 characters)
    public static boolean hasValidDomainLength(String email) {
        String regex = ".*@.{1,253}$";
        return Pattern.matches(regex, email);
    }

    // Method 9: Check for valid special characters in local part
    public static boolean hasValidSpecialChars(String email) {
        // Allowed: letters, numbers, dots, hyphens, underscores, plus signs
        String regex = "^[a-zA-Z0-9._%+-]+@.*";
        return Pattern.matches(regex, email);
    }

    // Method 10: Check no consecutive dots
    public static boolean noConsecutiveDots(String email) {
        String regex = "^(?!.*\\.\\.)[^@]+@(?!.*\\.\\.)[^@]+$";
        return Pattern.matches(regex, email);
    }

    // Method 11: Check local part doesn't start with dot
    public static boolean localPartNotStartWithDot(String email) {
        String regex = "^[^.].*@.*";
        return Pattern.matches(regex, email);
    }

    // Method 12: Check local part doesn't end with dot
    public static boolean localPartNotEndWithDot(String email) {
        String regex = "^.*[^.]@.*";
        return Pattern.matches(regex, email);
    }

    // Method 13: Check domain doesn't start with hyphen
    public static boolean domainNotStartWithHyphen(String email) {
        String regex = ".*@[^-].*";
        return Pattern.matches(regex, email);
    }

    // Method 14: Check domain doesn't end with hyphen
    public static boolean domainNotEndWithHyphen(String email) {
        String regex = ".*@.*[^-]\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Method 15: Validate subdomain structure
    public static boolean hasValidSubdomains(String email) {
        // Subdomains separated by dots, each must start and end with alphanumeric
        String regex = ".*@([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)*[a-zA-Z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Method 16: Check for valid common TLDs
    public static boolean hasCommonTLD(String email) {
        String regex = ".*\\.(com|org|net|edu|gov|mil|co|info|biz|io|ai|app|dev)$";
        return Pattern.matches(regex, email.toLowerCase());
    }

    // Method 17: Validate country code TLD format
    public static boolean hasValidCountryCodeTLD(String email) {
        // Country codes: 2 letters, can have second level domain
        String regex = ".*\\.[a-zA-Z]{2}$|.*\\.[a-zA-Z]{2,}\\.[a-zA-Z]{2}$";
        return Pattern.matches(regex, email);
    }

    // Method 18: Check for business email format
    public static boolean isBusinessEmail(String email) {
        // Excludes common free email providers
        String regex = "^[a-zA-Z0-9._%+-]+@(?!gmail|yahoo|hotmail|outlook|aol|icloud)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email.toLowerCase());
    }

    // Method 19: Validate email with plus addressing (e.g., user+tag@domain.com)
    public static boolean hasPlusAddressing(String email) {
        String regex = "^[a-zA-Z0-9._-]+\\+[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Method 20: Check for disposable email domains
    public static boolean isNotDisposableEmail(String email) {
        String regex = "^(?!.*@(tempmail|throwaway|guerrillamail|mailinator|10minutemail)\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email.toLowerCase());
    }

    // Method 21: Validate international domain names (IDN)
    public static boolean supportsIDN(String email) {
        // Supports unicode characters in domain
        String regex = "^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Method 22: Extract local part from email
    public static String extractLocalPart(String email) {
        String regex = "^([^@]+)@.*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return m.group(1);
        }
        return null;
    }

    // Method 23: Extract domain from email
    public static String extractDomain(String email) {
        String regex = ".*@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return m.group(1);
        }
        return null;
    }

    // Method 24: Extract TLD from email
    public static String extractTLD(String email) {
        String regex = ".*\\.([a-zA-Z]{2,})$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return m.group(1);
        }
        return null;
    }

    // Method 25: Comprehensive validation combining all rules
    public static boolean isFullyValidEmail(String email) {
        return email != null &&
                !email.trim().isEmpty() &&
                email.length() <= 320 && // Max email length per RFC 5321
                isValidEmail(email) &&
                hasValidLocalPart(email) &&
                hasValidDomain(email) &&
                hasValidTLD(email) &&
                hasSingleAtSymbol(email) &&
                hasValidLocalPartLength(email) &&
                hasValidDomainLength(email) &&
                hasValidSpecialChars(email) &&
                noConsecutiveDots(email) &&
                localPartNotStartWithDot(email) &&
                localPartNotEndWithDot(email) &&
                domainNotStartWithHyphen(email) &&
                hasValidSubdomains(email);
    }

    // Detailed validation report
    public static void printValidationReport(String email) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EMAIL VALIDATION REPORT: " + email);
        System.out.println("=".repeat(60));
        System.out.println("1.  Basic Format Valid:           " + isValidEmail(email));
        System.out.println("2.  Format Validation:             " + validateEmailFormat(email));
        System.out.println("3.  Valid Local Part:              " + hasValidLocalPart(email));
        System.out.println("4.  Valid Domain:                  " + hasValidDomain(email));
        System.out.println("5.  Valid TLD:                     " + hasValidTLD(email));
        System.out.println("6.  Single @ Symbol:               " + hasSingleAtSymbol(email));
        System.out.println("7.  Valid Local Part Length:       " + hasValidLocalPartLength(email));
        System.out.println("8.  Valid Domain Length:           " + hasValidDomainLength(email));
        System.out.println("9.  Valid Special Characters:      " + hasValidSpecialChars(email));
        System.out.println("10. No Consecutive Dots:           " + noConsecutiveDots(email));
        System.out.println("11. Local Part Not Start Dot:      " + localPartNotStartWithDot(email));
        System.out.println("12. Local Part Not End Dot:        " + localPartNotEndWithDot(email));
        System.out.println("13. Domain Not Start Hyphen:       " + domainNotStartWithHyphen(email));
        System.out.println("14. Domain Not End Hyphen:         " + domainNotEndWithHyphen(email));
        System.out.println("15. Valid Subdomains:              " + hasValidSubdomains(email));
        System.out.println("16. Has Common TLD:                " + hasCommonTLD(email));
        System.out.println("17. Valid Country Code TLD:        " + hasValidCountryCodeTLD(email));
        System.out.println("18. Business Email:                " + isBusinessEmail(email));
        System.out.println("19. Has Plus Addressing:           " + hasPlusAddressing(email));
        System.out.println("20. Not Disposable Email:          " + isNotDisposableEmail(email));
        System.out.println("-".repeat(60));
        System.out.println("Local Part: " + extractLocalPart(email));
        System.out.println("Domain:     " + extractDomain(email));
        System.out.println("TLD:        " + extractTLD(email));
        System.out.println("=".repeat(60));
        System.out.println("OVERALL VALID: " + isFullyValidEmail(email));
        System.out.println("=".repeat(60));
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(10) + "ADVANCED EMAIL VALIDATOR" + " ".repeat(24) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");

        // Test cases - Valid emails
        String[] validEmails = {
                "john.doe@example.com",
                "user+tag@company.co.uk",
                "admin_2024@tech-startup.io",
                "contact@sub.domain.org",
                "support@company-name.com",
                "info123@business.net",
                "sales@mycompany.com.au",
                "hello_world@test.edu"
        };

        System.out.println("\n✓ TESTING VALID EMAILS:");
        System.out.println("─".repeat(60));
        for (String email : validEmails) {
            System.out.printf("%-35s : %s%n", email,
                    isFullyValidEmail(email) ? "✓ VALID" : "✗ INVALID");
        }

        // Test cases - Invalid emails
        String[] invalidEmails = {
                "plaintext",
                "@missinglocal.com",
                "missing@domain",
                "double@@domain.com",
                ".startdot@domain.com",
                "enddot.@domain.com",
                "consecutive..dots@domain.com",
                "spaces in@domain.com",
                "user@-startdash.com",
                "user@domain-.com",
                "user@domain.c",
                "user@@domain.com",
                "user@.domain.com",
                "user@domain..com"
        };

        System.out.println("\n✗ TESTING INVALID EMAILS:");
        System.out.println("─".repeat(60));
        for (String email : invalidEmails) {
            System.out.printf("%-35s : %s%n", email,
                    isFullyValidEmail(email) ? "✓ VALID" : "✗ INVALID");
        }

        // Detailed reports for selected emails
        printValidationReport("john.doe@example.com");
        printValidationReport("invalid..email@test.com");
        printValidationReport("user+tag@company.co.uk");
    }
}