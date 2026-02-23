import junit.code.PasswordValidation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Password Validation Tests")
public class PasswordValidationTest {

    PasswordValidation validator;

    @BeforeEach
    void setUp() {
        // create fresh instance before each test
        validator = new PasswordValidation();
    }

    @AfterEach
    void tearDown() {
        // reset validator after each test
        validator = null;
    }

    // -------------------------------------------------------
    // RULE 1 - minimum 8 characters
    // -------------------------------------------------------

    // valid password with exactly 8 characters
    @Test
    @DisplayName("Rule1 - Valid password with exactly 8 characters")
    void testExactlyEightCharacters() {
        assertTrue(validator.isValidPasswordLength("Abcdefgh"));
    }

    // valid password with more than 8 characters
    @Test
    @DisplayName("Rule1 - Valid password with more than 8 characters")
    void testMoreThanEightCharacters() {
        assertTrue(validator.isValidPasswordLength("Abcdefghij"));
    }

    // invalid password with less than 8 characters
    @Test
    @DisplayName("Rule1 - Invalid password with less than 8 characters")
    void testLessThanEightCharacters() {
        assertFalse(validator.isValidPasswordLength("Abc123"));
    }

    // invalid password with exactly 7 characters
    @Test
    @DisplayName("Rule1 - Invalid password with exactly 7 characters")
    void testExactlySevenCharacters() {
        assertFalse(validator.isValidPasswordLength("Abcdefg"));
    }

    // invalid empty password for length rule
    @Test
    @DisplayName("Rule1 - Invalid empty password")
    void testEmptyPasswordLength() {
        assertFalse(validator.isValidPasswordLength(""));
    }

    // invalid null password for length rule
    @Test
    @DisplayName("Rule1 - Invalid null password")
    void testNullPasswordLength() {
        assertFalse(validator.isValidPasswordLength(null));
    }

    // -------------------------------------------------------
    // RULE 2 - at least one uppercase letter
    // -------------------------------------------------------

    // valid password with one uppercase letter
    @Test
    @DisplayName("Rule2 - Valid password with one uppercase letter")
    void testOneUpperCase() {
        assertTrue(validator.hasUpperCase("abcdefgH"));
    }

    // valid password with multiple uppercase letters
    @Test
    @DisplayName("Rule2 - Valid password with multiple uppercase letters")
    void testMultipleUpperCase() {
        assertTrue(validator.hasUpperCase("AbcDefgH"));
    }

    // valid password with uppercase at the start
    @Test
    @DisplayName("Rule2 - Valid password with uppercase at start")
    void testUpperCaseAtStart() {
        assertTrue(validator.hasUpperCase("Abcdefgh"));
    }

    // invalid password with no uppercase letter
    @Test
    @DisplayName("Rule2 - Invalid password with no uppercase letter")
    void testNoUpperCase() {
        assertFalse(validator.hasUpperCase("abcdefgh"));
    }

    // invalid password with all lowercase letters
    @Test
    @DisplayName("Rule2 - Invalid password with all lowercase")
    void testAllLowerCase() {
        assertFalse(validator.hasUpperCase("abcdefghij"));
    }

    // invalid null password for uppercase rule
    @Test
    @DisplayName("Rule2 - Invalid null password")
    void testNullPasswordUpperCase() {
        assertFalse(validator.hasUpperCase(null));
    }

    // -------------------------------------------------------
    // RULE 3 - at least one numeric digit
    // -------------------------------------------------------

    // valid password with one numeric digit
    @Test
    @DisplayName("Rule3 - Valid password with one numeric digit")
    void testOneNumericDigit() {
        assertTrue(validator.hasNumeric("Abcdefg1"));
    }

    // valid password with multiple numeric digits
    @Test
    @DisplayName("Rule3 - Valid password with multiple numeric digits")
    void testMultipleNumericDigits() {
        assertTrue(validator.hasNumeric("Abc12345"));
    }

    // valid password with numeric at the start
    @Test
    @DisplayName("Rule3 - Valid password with numeric at start")
    void testNumericAtStart() {
        assertTrue(validator.hasNumeric("1Abcdefg"));
    }

    // invalid password with no numeric digit
    @Test
    @DisplayName("Rule3 - Invalid password with no numeric digit")
    void testNoNumericDigit() {
        assertFalse(validator.hasNumeric("Abcdefgh"));
    }

    // invalid password with all letters and no digits
    @Test
    @DisplayName("Rule3 - Invalid password with only letters")
    void testOnlyLetters() {
        assertFalse(validator.hasNumeric("ABCDefgh"));
    }

    // invalid null password for numeric rule
    @Test
    @DisplayName("Rule3 - Invalid null password")
    void testNullPasswordNumeric() {
        assertFalse(validator.hasNumeric(null));
    }

    // -------------------------------------------------------
    // RULE 4 - exactly one special character
    // -------------------------------------------------------

    // valid password with exactly one special character
    @Test
    @DisplayName("Rule4 - Valid password with exactly one special character")
    void testExactlyOneSpecialCharacter() {
        assertTrue(validator.hasExactlyOneSpecialCharacter("Abcdefg@"));
    }

    // valid password with special character in the middle
    @Test
    @DisplayName("Rule4 - Valid password with special character in middle")
    void testSpecialCharacterInMiddle() {
        assertTrue(validator.hasExactlyOneSpecialCharacter("Abcd@efg"));
    }

    // invalid password with no special character
    @Test
    @DisplayName("Rule4 - Invalid password with no special character")
    void testNoSpecialCharacter() {
        assertFalse(validator.hasExactlyOneSpecialCharacter("Abcdefg1"));
    }

    // invalid password with more than one special character
    @Test
    @DisplayName("Rule4 - Invalid password with more than one special character")
    void testMoreThanOneSpecialCharacter() {
        assertFalse(validator.hasExactlyOneSpecialCharacter("Abc@def@"));
    }

    // invalid password with two special characters
    @Test
    @DisplayName("Rule4 - Invalid password with two special characters")
    void testTwoSpecialCharacters() {
        assertFalse(validator.hasExactlyOneSpecialCharacter("A@c#efgh"));
    }

    // invalid null password for special character rule
    @Test
    @DisplayName("Rule4 - Invalid null password")
    void testNullPasswordSpecialChar() {
        assertFalse(validator.hasExactlyOneSpecialCharacter(null));
    }

    // -------------------------------------------------------
    // ALL RULES COMBINED - all rules must pass together
    // -------------------------------------------------------

    // valid password passing all four rules
    @Test
    @DisplayName("All Rules - Valid password passing all rules")
    void testValidPasswordAllRules() {
        assertTrue(validator.isValidPassword("Abcdef1@"));
    }

    // invalid password failing rule 1 only - less than 8 characters
    @Test
    @DisplayName("All Rules - Invalid password failing rule 1 only")
    void testFailsRule1Only() {
        assertFalse(validator.isValidPassword("Ab1@"));
    }

    // invalid password failing rule 2 only - no uppercase
    @Test
    @DisplayName("All Rules - Invalid password failing rule 2 only")
    void testFailsRule2Only() {
        assertFalse(validator.isValidPassword("abcdef1@"));
    }

    // invalid password failing rule 3 only - no numeric digit
    @Test
    @DisplayName("All Rules - Invalid password failing rule 3 only")
    void testFailsRule3Only() {
        assertFalse(validator.isValidPassword("Abcdefg@"));
    }

    // invalid password failing rule 4 only - more than one special character
    @Test
    @DisplayName("All Rules - Invalid password failing rule 4 only")
    void testFailsRule4Only() {
        assertFalse(validator.isValidPassword("Abcde1@#"));
    }

    // invalid null password for all rules check
    @Test
    @DisplayName("All Rules - Invalid null password")
    void testNullPasswordAllRules() {
        assertFalse(validator.isValidPassword(null));
    }
}
