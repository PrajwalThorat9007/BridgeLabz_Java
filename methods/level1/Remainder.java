/*Write a program to take 2 numbers and print their quotient and reminder
Hint => 
Take user input as integer
Use division operator (/) for quotient and moduli operator (%) for reminder
Write Method to find the reminder and the quotient of a number 
public static int[] findRemainderAndQuotient(int number, int divisor)  */

import java.util.Scanner;

class Remainder {

    // Method to calculate quotient and remainder
    public static int[] QuotientRemainder(int num1, int num2) {
        int quotient = num1 / num2;
        int Remainder = num1 % num2;
        
        return new int[] { quotient, Remainder };
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read two integers
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        // Call method to get quotient and remainder
        int[] result = QuotientRemainder(num1, num2);

        // Display quotient and remainder
        System.out.println(result[0] + " " + result[1]);
    }
}
