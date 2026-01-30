/*
Create a program to find the power of a number.
Hint => 
Get integer input for two variables named number and power.
Create a result variable with an initial value of 1.
Run a for loop from i = 1 to i <= power.
In each iteration of the loop, multiply the result with the number and assign the value to the result.
Finally, print the result
*/
import java.util.Scanner;

class PowerOfNumber {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the base number
        int number = sc.nextInt();

        // Read the power value
        int power = sc.nextInt();

        // Variable to store the result
        int result = 1;

        // Calculate number raised to the given power
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        // Print the result
        System.out.println(result);
    }
}
