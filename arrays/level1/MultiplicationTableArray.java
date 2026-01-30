/*
Create a program to print a multiplication table of a number.
Hint => 
Get an integer input and store it in the number variable. Also, define a integer array to store the results of multiplication from 1 to 1
Run a loop from 1 to 10 and store the results in the multiplication table array
Finally, display the result from the array in the format number * i = ___
*/
import java.util.Scanner;

class MultiplicationTableArray {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number for multiplication table
        int number = sc.nextInt();

        // Array to store multiplication table results
        int[] table = new int[10];

        // Store multiplication results in array
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Print the multiplication table using array values
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }
}
