/*
Create a program to find the BMI of a person
Hint => 
Take user input in double for the weight (in kg) of the person and height (in cm) for the person and store it in the corresponding variable.
Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Use the table to determine the weight status of the person
*/
import java.util.Scanner;

class BMI {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read weight in kilograms
        double weight = sc.nextDouble();   // in kg

        // Read height in centimeters
        double heightCm = sc.nextDouble(); // in cm

        // Convert height from centimeters to meters
        double heightMeter = heightCm / 100; 

        // Calculate BMI value
        double bmi = weight / (heightMeter * heightMeter);

        // Display BMI
        System.out.println("BMI is " + bmi);

        // Determine weight status based on BMI
        if (bmi < 18.5) {
            System.out.println("Weight Status: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Weight Status: Normal");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Weight Status: Overweight");
        } else {
            System.out.println("Weight Status: Obese");
        }
    }
}
