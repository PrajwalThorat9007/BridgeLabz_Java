/*Write a program that takes a year as input and outputs the Year is a Leap Year or not 
Hint => 
The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar. 
Also Leap year is divisible by 4 and not divisible by 100 or divisible by 400
Write a method to check for Leap Year using the conditions a and b
 */
import java.util.Scanner;

class LeapYear {

    // Method to check whether a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the year
        int year = sc.nextInt();

        // Validate year based on Gregorian calendar
        if (year < 1582) {
            System.out.println("Year should be greater than or equal to 1582");
            return;
        }

        // Check and display leap year result
        if (isLeapYear(year)) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is NOT a Leap Year");
        }

        // Close the Scanner
        sc.close();
    }
}
