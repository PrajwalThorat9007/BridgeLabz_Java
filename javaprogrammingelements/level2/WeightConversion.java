/*
Create a program to convert weight in pounds to kilograms.
Hint => 1 pound = 2.2 kg
I/P => weight
O/P => The weight of the person in pound is ___ and in kg is ___
*/
import java.util.Scanner;

class WeightConversion {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read weight in pounds
        double pound = sc.nextDouble();

        // Convert weight from pounds to kilograms
        double kilogram = pound / 2.2;

        // Display weight in pounds and kilograms
        System.out.println(
            "The weight of the person in pound is " + pound +
            " and in kg is " + kilogram
        );
    }
}

