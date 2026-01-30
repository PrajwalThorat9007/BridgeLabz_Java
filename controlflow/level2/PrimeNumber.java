/*
Write a Program to check if the given number is a prime number or not
Hint => 
A number that can be divided exactly only by itself and 1 are Prime Numbers,
Prime Numbers checks are done for numbers greater than 1
Loop through all the numbers from 2 to the user input number and check if the reminder is zero. If the reminder is zero break out from the loop as the number is divisible by some other number and is not a prime number. 
Use isPrime boolean variable to store the result
*/
import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Flag to determine whether the number is prime
        boolean isPrime = true;

        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            isPrime = false;
        } else {

            // Check divisibility from 2 to number-1
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Display result
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }
}
