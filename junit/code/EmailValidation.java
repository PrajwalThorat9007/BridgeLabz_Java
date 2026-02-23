package junit.code;

public class EmailValidation {

    public boolean isValidEmail(String email) {

        // check if email is null or empty
        if (email == null || email.isEmpty()) {
            return false;
        }

        // check email contains exactly one @ symbol
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        // split email into local part (before @) and domain part (after @)
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // check local part and domain part are not empty
        if (localPart.isEmpty() || domainPart.isEmpty()) {
            return false;
        }

        // check local part does not start or end with a dot
        if (localPart.startsWith(".") || localPart.endsWith(".")) {
            return false;
        }

        // split local part by dot to get mandatory abc and optional xyz
        String[] localParts = localPart.split("\\.");

        // local part must have either 1 part (abc) or 2 parts (abc.xyz)
        if (localParts.length < 1 || localParts.length > 2) {
            return false;
        }

        // check mandatory abc part is not empty
        if (localParts[0].isEmpty()) {
            return false;
        }

        // check optional xyz part is not empty if present
        if (localParts.length == 2 && localParts[1].isEmpty()) {
            return false;
        }

        // check domain part does not start or end with a dot
        if (domainPart.startsWith(".") || domainPart.endsWith(".")) {
            return false;
        }

        // split domain part by dot to get mandatory bl, mandatory co, optional in
        String[] domainParts = domainPart.split("\\.");

        // domain must have either 2 parts (bl.co) or 3 parts (bl.co.in)
        if (domainParts.length < 2 || domainParts.length > 3) {
            return false;
        }

        // check mandatory bl part is not empty
        if (domainParts[0].isEmpty()) {
            return false;
        }

        // check mandatory co part is not empty
        if (domainParts[1].isEmpty()) {
            return false;
        }

        // check optional in part is not empty if present
        if (domainParts.length == 3 && domainParts[2].isEmpty()) {
            return false;
        }

        return true;
    }
}