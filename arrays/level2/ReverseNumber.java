/*
Create a program to take a number as input and reverse the number. To do this, store the digits of the number in an array and display the array in reverse order
Hint => 
Take user input for a number. 
Find the count of digits in the number. 
Find the digits in the number and save them in an array
Create an array to store the elements of the digits array in reverse order
Finally, display the elements of the array in reverse order  

*/
import java.util.Scanner;

class ReverseNumber {
    public static void main(String[] args) {

        // Array to store digits of the number
        int[] digit = new int[10];

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Index to track number of digits
        int i = 0;
        
        // Read the number
        int number = sc.nextInt();

        // Extract digits from the number
        while (number != 0) {
            int dig = number % 10;
            number = number / 10;
            digit[i] = dig;
            i++;
        }

        // Print the number in reverse order
        for (int j = 0; j < i; j++) {
            System.out.print(digit[j]);
        }
    }
}

