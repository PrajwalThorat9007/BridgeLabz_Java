/*
Write a program to check for the natural number and write the sum of n natural numbers 
Hint => 
A Natural Number is a positive integer (1,2,3, etc) sometimes with the inclusion of 0
A sum of n natural numbers is n * (n+1) / 2 
I/P => number
O/P => If the number is a positive integer then the output is
The sum of ___ natural numbers is ___
Otherwise 
The number ___ is not a natural number
*/
import java.util.Scanner;

class NaturalNumberSum {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Check if the number is a natural number
        if (number >= 1) {

            // Calculate sum of first n natural numbers using formula
            int sum = number * (number + 1) / 2;

            // Display the result
            System.out.println(
                "The sum of " + number + " natural numbers is " + sum
            );
        } else {

            // Display error message for non-natural number
            System.out.println(
                "The number " + number + " is not a natural number"
            );
        }
    }
}
