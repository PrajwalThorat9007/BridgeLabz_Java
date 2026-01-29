/*
Rewrite program 14 using for loop
Hint => 
Take the integer input, check for natural number and determine the factorial using for loop and finally print the result. 
Create a program to print odd and even numbers between 1 to the number entered by the 
*/
import java.util.Scanner;

class Factorial2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int mul=1;
        
        for(int i=num;i>0;i--){
            mul=mul*i;
            }
        System.out.println(mul);
    }
}