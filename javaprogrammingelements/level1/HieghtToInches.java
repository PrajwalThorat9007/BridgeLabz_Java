/*
Write a program that takes your height in centimeters and converts it into feet and inches
Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
I/P => height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
*/
import java.util.Scanner;

class HieghtToInches {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read height in centimeters
        int Height = sc.nextInt();

        // Convert height from centimeters to inches
        double inch = Height / 2.54;

        // Convert height from inches to feet
        double feet = inch / 12;
        
        // Display height in centimeters, feet, and inches
        System.out.printf(
            "Your Height in cm is %d while in feet is %.2f and inches is %.2f",
            Height, feet, inch
        );
    }
}
