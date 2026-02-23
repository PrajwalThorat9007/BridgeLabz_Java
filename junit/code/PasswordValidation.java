package junit.code;

public class PasswordValidation {

    // rule 1 - password must have minimum 8 characters
    public boolean isValidPasswordLength(String password) {

        // check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // check password has minimum 8 characters
        return password.length() >= 8;
    }

    // rule 2 - password must have at least one uppercase letter
    public boolean hasUpperCase(String password) {

        // check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // check each character for uppercase letter
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    // rule 3 - password must have at least one numeric digit
    public boolean hasNumeric(String password) {

        // check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // check each character for a digit
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    // rule 4 - password must have exactly one special character
    public boolean hasExactlyOneSpecialCharacter(String password) {

        // check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // count special characters in password
        int specialCharCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialCharCount++;
            }
        }

        // return true only if exactly one special character found
        return specialCharCount == 1;
    }

    // check all rules together - all rules must pass
    public boolean isValidPassword(String password) {

        // check all four rules must pass together
        return isValidPasswordLength(password)
                && hasUpperCase(password)
                && hasNumeric(password)
                && hasExactlyOneSpecialCharacter(password);
    }
}