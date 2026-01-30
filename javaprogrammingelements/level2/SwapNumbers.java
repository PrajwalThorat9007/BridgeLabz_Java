/*
Create a program to swap two numbers 
Hint => 
Create a variable number1 and take user input.
Create a variable number2 and take user input.
Swap number1 and number2  and print the swapped output
I/P => number1, number2
O/P => The swapped numbers are  ___ and ___
*/

import java.util.Scanner;

class SwapNumbers {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read two numbers
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
		
        // Swap the two numbers using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Display the swapped numbers
        System.out.println(
            "The swapped numbers are " + number1 + " and " + number2
        );
    }
}
