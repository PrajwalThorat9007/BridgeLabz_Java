/*
Write a Program to find the factorial of an integer entered by the user.
Hint => 
For example, the factorial of 4 is 1 * 2 * 3 * 4 which is 24.
Take an integer input from the user and assign it to the variable. Check the user has entered a positive integer.
Using a while loop, compute the factorial.
Print the factorial at the end.
*/
import java.util.Scanner;

class Factorial{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        //declaring variables
        int num=sc.nextInt();
        int mul=1;

        //finding factorial using while loop
        while(num!=0){
            mul=mul*num;
            num--;
        }
        System.out.println(mul);
    }
}
