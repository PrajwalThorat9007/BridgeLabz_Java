/*
Write a program to create a basic calculator that can perform addition, subtraction, multiplication, and division. The program should ask for two numbers (floating point) and perform all the operations
Hint => 
Create a variable number1 and number 2 and take user inputs.
Perform Arithmetic Operations of addition, subtraction, multiplication and division and assign the result to a variable and finally print the result
*/
import java.util.Scanner;

class Calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number1=sc.nextInt();
        int number2=sc.nextInt();
        
        int addition=number1+number2;
        int subtraction=number1-number2;
        
        int multiplication=number1*number2;
        int division=number1/number2;
        
        System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %d and %d is %d, %d, %d, and %d",number1,number2,addition,subtraction,multiplication,division);
    }
}