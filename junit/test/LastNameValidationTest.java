
import junit.code.LastNameValidation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Last Name Validation Tests")
public class LastNameValidationTest {

    LastNameValidation validator;

    @BeforeEach
    void setUp() {
        // create fresh instance before each test
        validator = new LastNameValidation();
    }

    @AfterEach
    void tearDown() {
        // reset validator after each test
        validator = null;
    }

    @Test
    @DisplayName("Valid last name with capital start and more than 3 characters")
    void testValidLastName() {
        // valid name with capital start and enough length
        assertTrue(validator.isValidLastName("Smith"));
    }

    @Test
    @DisplayName("Valid last name with exactly 3 characters")
    void testExactlyThreeCharacters() {
        // valid name with exactly minimum length
        assertTrue(validator.isValidLastName("Lee"));
    }

    @Test
    @DisplayName("Invalid last name starting with lowercase")
    void testLastNameStartsWithLowercase() {
        // name starting with lowercase should fail
        assertFalse(validator.isValidLastName("smith"));
    }

    @Test
    @DisplayName("Invalid last name with less than 3 characters")
    void testLastNameTooShort() {
        // name with only 2 characters should fail
        assertFalse(validator.isValidLastName("Li"));
    }

    @Test
    @DisplayName("Invalid last name with single character")
    void testSingleCharacter() {
        // single character name should fail
        assertFalse(validator.isValidLastName("S"));
    }

    @Test
    @DisplayName("Invalid empty last name")
    void testEmptyLastName() {
        // empty string should fail
        assertFalse(validator.isValidLastName(""));
    }

    @Test
    @DisplayName("Invalid null last name")
    void testNullLastName() {
        // null value should fail
        assertFalse(validator.isValidLastName(null));
    }
}
