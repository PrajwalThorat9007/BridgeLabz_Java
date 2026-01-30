/*
Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators
*/

import java.util.Scanner;

class LeapYear2 {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the year
        int year = sc.nextInt();

        // Check if the year is a leap year (Gregorian calendar rules)
        if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
    }
}
