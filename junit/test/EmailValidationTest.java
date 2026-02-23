import junit.code.EmailValidation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Email Validation Tests")
public class EmailValidationTest {

    EmailValidation validator;

    @BeforeEach
    void setUp() {
        // create fresh instance before each test
        validator = new EmailValidation();
    }

    @AfterEach
    void tearDown() {
        // reset validator after each test
        validator = null;
    }

    // valid email with all parts including both optional parts
    @Test
    @DisplayName("Valid email with all parts abc.xyz@bl.co.in")
    void testFullValidEmail() {
        assertTrue(validator.isValidEmail("abc.xyz@bl.co.in"));
    }

    // valid email with only mandatory parts
    @Test
    @DisplayName("Valid email with mandatory parts only abc@bl.co")
    void testMandatoryPartsOnly() {
        assertTrue(validator.isValidEmail("abc@bl.co"));
    }

    // valid email with optional xyz before @ but no optional in after co
    @Test
    @DisplayName("Valid email with optional xyz but no in - abc.xyz@bl.co")
    void testWithOptionalXyzOnly() {
        assertTrue(validator.isValidEmail("abc.xyz@bl.co"));
    }

    // valid email with optional in after co but no optional xyz
    @Test
    @DisplayName("Valid email with optional in but no xyz - abc@bl.co.in")
    void testWithOptionalInOnly() {
        assertTrue(validator.isValidEmail("abc@bl.co.in"));
    }

    // invalid email with missing mandatory abc part before @
    @Test
    @DisplayName("Invalid email with missing abc part - @bl.co.in")
    void testMissingAbcPart() {
        assertFalse(validator.isValidEmail("@bl.co.in"));
    }

    // invalid email with missing mandatory bl part after @
    @Test
    @DisplayName("Invalid email with missing bl part - abc@.co.in")
    void testMissingBlPart() {
        assertFalse(validator.isValidEmail("abc@.co.in"));
    }

    // invalid email with missing mandatory co part
    @Test
    @DisplayName("Invalid email with missing co part - abc@bl")
    void testMissingCoPart() {
        assertFalse(validator.isValidEmail("abc@bl"));
    }

    // invalid email with no @ symbol
    @Test
    @DisplayName("Invalid email with no @ symbol - abcbl.co.in")
    void testMissingAtSymbol() {
        assertFalse(validator.isValidEmail("abcbl.co.in"));
    }

    // invalid email with more than one @ symbol
    @Test
    @DisplayName("Invalid email with multiple @ symbols - abc@@bl.co.in")
    void testMultipleAtSymbols() {
        assertFalse(validator.isValidEmail("abc@@bl.co.in"));
    }

    // invalid email with dot immediately before @ symbol
    @Test
    @DisplayName("Invalid email with dot before @ - abc.@bl.co.in")
    void testDotBeforeAt() {
        assertFalse(validator.isValidEmail("abc.@bl.co.in"));
    }

    // invalid email with dot immediately after @ symbol
    @Test
    @DisplayName("Invalid email with dot after @ - abc@.bl.co.in")
    void testDotAfterAt() {
        assertFalse(validator.isValidEmail("abc@.bl.co.in"));
    }

    // invalid email ending with a dot after optional in
    @Test
    @DisplayName("Invalid email with trailing dot - abc.xyz@bl.co.in.")
    void testTrailingDot() {
        assertFalse(validator.isValidEmail("abc.xyz@bl.co.in."));
    }

    // invalid email with null value
    @Test
    @DisplayName("Invalid null email")
    void testNullEmail() {
        assertFalse(validator.isValidEmail(null));
    }

    // invalid email with empty string
    @Test
    @DisplayName("Invalid empty email")
    void testEmptyEmail() {
        assertFalse(validator.isValidEmail(""));
    }
}
