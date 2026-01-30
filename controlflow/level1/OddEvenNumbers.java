/*
Create a program to print odd and even numbers between 1 to the number entered by the user.
Hint => 
Get an integer input from the user, assign to a variable number and check for Natural Number
Using a for loop, iterate from 1 to the number
In each iteration of the loop, print the number is odd or even number
*/
import java.util.Scanner;

class OddEvenNumbers {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Check if the number is a natural number
        if (number >= 1) {

            // Check each number for odd or even
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even number");
                } else {
                    System.out.println(i + " is odd number");
                }
            }
        } else {

            // Display error message for non-natural number
            System.out.println("The number " + number + " is not a natural number");
        }
    }
}
