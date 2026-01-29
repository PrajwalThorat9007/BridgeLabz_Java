/*
Rewrite the above program using multi-dimensional array to store height, weight, and BMI in 2D array for all the persons
Hint => 
Take input for a number of persons
Create a multi-dimensional array to store weight, height and BMI. Also create an to store the weight status of the persons
       double[][] personData = new double[number][3];
       String[] weightStatus = new String[number];
Take input for weight and height of the persons and for negative values, ask the user to enter positive values
Calculate BMI of all the persons and store them in the personData array and also find the weight status and put them in the weightStatus array
Display the height, weight, BMI and status of each person
*/
import java.util.Scanner;

class BMIMultiPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt(); // number of persons

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];


        for (int i = 0; i < number; i++) {


            System.out.println("Enter weight (kg) for person " + (i + 1));
            personData[i][0] = sc.nextDouble();
            if (personData[i][0] <= 0) {
                System.out.println("Invalid weight. Enter again.");
                i--;
                continue;
            }

            // Height input with validation
            System.out.println("Enter height (cm) for person " + (i + 1));
            personData[i][1] = sc.nextDouble();
            if (personData[i][1] <= 0) {
                System.out.println("Invalid height. Enter again.");
                i--;
                continue;
            }
        }


        for (int i = 0; i < number; i++) {
            double heightMeter = personData[i][1] / 100;
            personData[i][2] = personData[i][0] / (heightMeter * heightMeter);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " cm");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
