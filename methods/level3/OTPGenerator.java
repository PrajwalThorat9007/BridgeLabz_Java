/*
Write a program to generate a six-digit OTP number using Math.random() method. Validate the numbers are unique by generating the OTP number 10 times and ensuring all the 10 OTPs are not the same
Hint => 
Write a method to Generate a 6-digit OTP number using Math.random() 
Create an array to save the OTP numbers generated 10 times
Write a method to ensure that the OTP numbers generated are unique. If unique return true else return false
 */
class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Array to store generated OTPs
        int[] otps = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (int i = 0; i < otps.length; i++) {
            System.out.println(otps[i]);
        }

        // Check whether all OTPs are unique
        boolean unique = areOTPsUnique(otps);

        // Display uniqueness result
        if (unique) {
            System.out.println("All 10 OTPs are unique");
        } else {
            System.out.println("Duplicate OTPs found");
        }
    }
}
