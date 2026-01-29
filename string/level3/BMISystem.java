package level3;

// Question: Create a program to find BMI of 10 persons and display height, weight, BMI and status.

import java.util.Scanner;

class BMISystem {

    static String getStatus(double bmi){
        if(bmi < 18.5) return "Underweight";
        else if(bmi < 25) return "Normal";
        else if(bmi < 30) return "Overweight";
        else return "Obese";
    }

    static String[][] calculateBMI(double[][] hw){
        String[][] result = new String[hw.length][4];

        for(int i=0;i<hw.length;i++){
            double weight = hw[i][0];
            double heightCm = hw[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = getStatus(bmi);
        }
        return result;
    }

    static void display(String[][] data){
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("--------------------------------------------------");
        for(int i=0;i<data.length;i++){
            System.out.println(
                    data[i][0]+"\t\t"+
                            data[i][1]+"\t\t"+
                            data[i][2]+"\t"+
                            data[i][3]
            );
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double[][] hw = new double[10][2];

        for(int i=0;i<10;i++){
            System.out.println("Person " + (i+1));
            System.out.print("Enter weight (kg): ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            hw[i][1] = sc.nextDouble();
        }

        String[][] result = calculateBMI(hw);
        display(result);
    }
}

