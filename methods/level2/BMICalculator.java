/*
An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
Hint => 
Take user input in double for the weight (in kg) of the person and height (in cm) for the person and and store it in the corresponding 2D array of 10 rows and 3 columns. The First Column storing the weight, the second column storing the height in cm and the third column is the BMI
Create a Method to find the BMI of every person and populate the array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Create a Method to determine the BMI status using the logic shown in the figure below. and return the array of all the persons BMI Status.

 */
import java.util.Scanner;

class BMICalculator {

    // Method to calculate BMI for each person
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeter = heightCm / 100;
            data[i][2] = weight / (heightMeter * heightMeter);
        }
    }

    // Method to determine BMI status for each person
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // 2D array to store weight, height, and BMI
        double[][] data = new double[10][3];

        // Read weight and height for 10 persons
        for (int i = 0; i < 10; i++) {
            data[i][0] = sc.nextDouble();
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI values
        calculateBMI(data);

        // Get BMI status for each person
        String[] status = getBMIStatus(data);

        // Display table header
        System.out.println("Weight\tHeight(cm)\tBMI\t\tStatus");

        // Display BMI details for each person
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t%.2f\t\t%.2f\t\t%s\n",
                    data[i][0], data[i][1], data[i][2], status[i]);
        }

        // Close the Scanner
        sc.close();
    }
}

