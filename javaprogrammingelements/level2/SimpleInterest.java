/*
Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
Hint => Simple Interest = Principal * Rate * Time / 100
I/P => principal, rate, time
O/P => The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___
*/
import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read principal amount
        double principal = sc.nextDouble();

        // Read rate of interest
        double rate = sc.nextDouble();

        // Read time period
        double time = sc.nextDouble();

        // Calculate simple interest using formula
        double simpleInterest = (principal * rate * time) / 100;

        // Display the simple interest details
        System.out.println(
            "The Simple Interest is " + simpleInterest +
            " for Principal " + principal +
            ", Rate of Interest " + rate +
            " and Time " + time
        );
    }
}
