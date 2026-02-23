package junit.code;

public class LastNameValidation {

    public boolean isValidLastName(String lastName) {

        // check if last name is null or empty
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }

        // check last name has minimum 3 characters
        if (lastName.length() < 3) {
            return false;
        }

        // check first letter is uppercase
        if (!Character.isUpperCase(lastName.charAt(0))) {
            return false;
        }

        return true;
    }
}