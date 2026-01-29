/*
An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
Hint => 
Take input for a number of persons
Create arrays to store the weight, height, BMI, and weight status of the persons
Take input for the weight and height of the persons
Calculate the BMI of all the persons and store them in an array and also find the weight status of the persons
Display the height, weight, BMI, and weight status of each person
Use the table to determine the weight status of the person
*/
import java.util.Scanner;

class BMI {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        
        int[][] BMI=new int[num][3];
        String[] BMIstatus=new String[num];
        for(int i=0;i<num;i++){
            BMI[i][0]=sc.nextInt();
            BMI[i][1]=sc.nextInt();
            
            BMI[i][2]=BMI[i][1]/(BMI[i][0]*BMI[i][0]);
            if(BMI[i][2]<=18){
                BMIstatus[i]="Underweight";
            }
            else if(BMI[i][2]>18 && BMI[i][2]<=25){
                BMIstatus[i]="Normal";
            }
            else if(BMI[i][2]>25 && BMI[i][2]<=40){
                BMIstatus[i]="Overwieght";
            }
            else{
                BMIstatus[i]="Obese";
            }
        }
        for(int i=0;i<num;i++){
            System.out.println(BMIstatus[i]);
        }
    }
}
