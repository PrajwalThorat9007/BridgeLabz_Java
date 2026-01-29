/*
Write a program to check if a number is divisible by 5
I/P => number
O/P => Is the number ___ divisible by 5? ___
*/
import java.util.Scanner;

class DivisibleByFive{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num%5==0){
            System.out.println("Divisible By Five");
        }
        else{
            System.out.println("Not Divisible By Five");
        }
    }
}