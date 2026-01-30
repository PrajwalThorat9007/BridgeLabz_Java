/*Write a program FizzBuzz, take a number as user input, and if it is a positive integer loop from 0 to the number and print the number, but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz".
Hint => 
Write the program and use for loop
*/
import java.util.Scanner;

class FizzBuzz {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Check if the number is positive
        if (number > 0) {

            // Apply FizzBuzz logic from 1 to the given number
            for (int i = 1; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        } else {

            // Display error message for invalid input
            System.out.println("Please enter a positive integer");
        }
    }
}
