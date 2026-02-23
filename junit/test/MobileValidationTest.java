import junit.code.MobileValidation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Mobile Number Validation Tests")
public class MobileValidationTest {
    MobileValidation validator;

    @BeforeEach
    void setUP(){
        validator=new MobileValidation();
    }

    @AfterEach
    void tearDown(){
        validator=null;
    }

    @Test
    @DisplayName("Valid mobile number- 91 9919819801")
    void testValidMobileNumber(){
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    @Test
    @DisplayName("Valid Number with three digit code")
    void testThreeDigitCountryCode(){
        assertTrue(validator.validateMobile("001 9919819801"));
    }

    @Test
    @DisplayName("Invalid Space")
    void testNoSpace(){
        assertFalse(validator.validateMobile("919919819801"));
    }

    // invalid mobile with double space between country code and number
    @Test
    @DisplayName("Invalid mobile with double space - 91  9919819801")
    void testDoubleSpace() {
        assertFalse(validator.validateMobile("91  9919819801"));
    }

    // invalid mobile with special characters in number
    @Test
    @DisplayName("Invalid mobile with special characters - 91 9919@19801")
    void testSpecialCharactersInNumber() {
        assertFalse(validator.validateMobile("91 9919@19801"));
    }

    // invalid mobile with null value
    @Test
    @DisplayName("Invalid null mobile number")
    void testNullMobile() {
        assertFalse(validator.validateMobile(null));
    }

    // invalid mobile with empty string
    @Test
    @DisplayName("Invalid empty mobile number")
    void testEmptyMobile() {
        assertFalse(validator.validateMobile(""));
    }


}
