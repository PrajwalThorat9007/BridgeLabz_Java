/*Write a program to check whether a number is positive, negative, or zero.
Hint => Get integer input from the user. Write a Method to return -1 for negative number, 1 for positive number and 0 if number is zero */
import java.util.Scanner;

class Nature{
    void Nature(int num){
        if(num>0){
            System.out.println("Positive");
        }
        else if(num<0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Zero");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int num=sc.nextInt();
        Nature obj=new Nature();
        
        obj.Nature(num);
    }
}