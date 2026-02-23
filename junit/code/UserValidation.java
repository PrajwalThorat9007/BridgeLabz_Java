package junit.code;

public class UserValidation {
    public boolean isValidFirstName(String firstName) {

        // check if null or empty
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }

        // check minimum 3 characters
        if (firstName.length() < 3) {
            return false;
        }

        // check first letter is uppercase
        if (!Character.isUpperCase(firstName.charAt(0))) {
            return false;
        }

        return true;
    }
}
