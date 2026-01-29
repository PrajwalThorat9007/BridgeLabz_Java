/*
Write a program that takes your height in centimeters and converts it into feet and inches
Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
I/P => height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
*/
import java.util.Scanner;

class HieghtToInches{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int Height=sc.nextInt();
        double inch=Height/2.54;
        double feet=inch/12;
        
        System.out.printf("Your Height in cm is %d while in feet is %.2f and inches is %.2f",Height,feet,inch);
    }
}