/*
Write a program to take 2 numbers and print their quotient and reminder
Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
I/P => number1, number2
O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
*/
import java.util.Scanner;

class QuotientReminder {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read two integers
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        // Calculate quotient of the division
        int quotient = number1 / number2;

        // Calculate remainder of the division
        int reminder = number1 % number2;

        // Display quotient and remainder
        System.out.println(
            "The Quotient is " + quotient +
            " and Reminder is " + reminder +
            " of two number " + number1 +
            " and " + number2
        );
    }
}
