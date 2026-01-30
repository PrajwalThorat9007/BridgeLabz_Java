/*
Create a program to find the multiplication table of a number entered by the user from 6 to 9 and display the result
Hint => 
Take integer input and store it in the variable number as well as define an integer array to store the multiplication result in the variable multiplicationResult
Using a for loop, find the multiplication table of numbers from 6 to 9 and save the result in the array
Finally, display the result from the array in the format number * i = ___
Create a program to find the mean height of players present in a football team.
*/
import java.util.Scanner;

class MultiplicationTable6to9 {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number for multiplication table
        int number = sc.nextInt();

        // Array to store multiplication results for 6 to 9
        int[] multiplicationResult = new int[4]; // for 6,7,8,9

        // Index to store results in array
        int index = 0;

        // Calculate multiplication results from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        // Reset index for printing results
        index = 0;

        // Print multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }
    }
}

