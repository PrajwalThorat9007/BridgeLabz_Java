package junit.code;

public class MobileValidation {
    private static final String MOBILE_PATTERN="^\\d+ \\d{10}$";

    public boolean validateMobile(String mobile){
        if(mobile == null || mobile.isEmpty()){
            return false;
        }

        return mobile.matches(MOBILE_PATTERN);
    }
}
