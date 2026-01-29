/*
Write a program to check if the first, second, or third number is the largest of the three.
I/P => number1, number2, number3
O/P => 
Is the first number the largest? ____
Is the second number the largest? ___
Is the third number the largest? ___
*/
import java.util.Scanner;

class LargestNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        
        boolean numlar1=(num1>num2)&&(num1>num3);
        boolean numlar2=(num2>num1)&&(num2>num3);
        boolean numlar3=(num3>num1)&&(num3>num1);
        
        System.out.println("Is the first number the largest? "+numlar1);
        System.out.println("Is the second number the largest? "+numlar2);
        System.out.println("Is the third number the largest? "+numlar3);
    }
}