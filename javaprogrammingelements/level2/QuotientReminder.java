/*
Write a program to take 2 numbers and print their quotient and reminder
Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
I/P => number1, number2
O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
*/
import java.util.Scanner;

class QuotientReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        int quotient = number1 / number2;
        int reminder = number1 % number2;

        System.out.println(
            "The Quotient is " + quotient +
            " and Reminder is " + reminder +
            " of two number " + number1 +
            " and " + number2
        );
    }
}