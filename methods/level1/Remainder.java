/*Write a program to take 2 numbers and print their quotient and reminder
Hint => 
Take user input as integer
Use division operator (/) for quotient and moduli operator (%) for reminder
Write Method to find the reminder and the quotient of a number 
public static int[] findRemainderAndQuotient(int number, int divisor)  */

import java.util.Scanner;

class Remainder{
    public static int[] QuotientRemainder(int num1,int num2){
        int quotient=num1/num2;
        int Remainder=num1%num2;
        
        return new int[] {quotient,Remainder};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        
        int[] result=QuotientRemainder(num1,num2);
        System.out.println(result[0]+" "+result[1]);
    }
}