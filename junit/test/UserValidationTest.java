import junit.code.UserValidation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First Name Validation Tests")
public class UserValidationTest {

    UserValidation validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidation();
        System.out.println("--- Test Started ---");
    }

    @AfterEach
    void tearDown() {
        System.out.println("--- Test Finished ---");
    }

    // ✅ VALID CASES

    @Test
    @DisplayName("Valid first name — starts with capital and has 3+ characters")
    void testValidFirstName() {
        assertTrue(validator.isValidFirstName("John"));
    }

    @Test
    @DisplayName("Valid first name — exactly 3 characters")
    void testMinimumThreeCharacters() {
        assertTrue(validator.isValidFirstName("Ann"));
    }

    // ❌ INVALID CASES

    @Test
    @DisplayName("Invalid — first name starts with lowercase")
    void testFirstNameStartsWithLowercase() {
        assertFalse(validator.isValidFirstName("john"));
    }

    @Test
    @DisplayName("Invalid — first name has less than 3 characters")
    void testFirstNameTooShort() {
        assertFalse(validator.isValidFirstName("Jo"));
    }

    @Test
    @DisplayName("Invalid — single character name")
    void testSingleCharacter() {
        assertFalse(validator.isValidFirstName("J"));
    }

    @Test
    @DisplayName("Invalid — empty first name")
    void testEmptyFirstName() {
        assertFalse(validator.isValidFirstName(""));
    }

    @Test
    @DisplayName("Invalid — null first name")
    void testNullFirstName() {
        assertFalse(validator.isValidFirstName(null));
    }
}
