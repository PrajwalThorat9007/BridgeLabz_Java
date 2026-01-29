/*
Write a program to take user input for 5 numbers and check whether a number is positive,  negative, or zero. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less
Hint => 
Define an integer array of 5 elements and get user input to store in the array.
Loop through the array using the length If the number is positive, check for even or odd numbers and print accordingly
If the number is negative, print negative. Else if the number is zero, print zero. 
Finally compare the first and last element of the array and display if they equal, greater or less
*/

import java.util.Scanner;

class NumberComparision{
    public static void main(String[] args){
    int[] num=new int[5];
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<num.length;i++){
        num[i]=sc.nextInt();
    }
    for(int i=0;i<num.length;i++){
        if(num[i]>=1){
            if(num[i]%2==0){
                System.out.println("Even");
            }
            else{
                System.out.println("Odd");
            }
        }
        else if(num[i]<0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Zero");
        }
    }
    if(num[0]>num[num.length-1]){
        System.out.println("Greater");
    }
    else if(num[0]<num[num.length-1]){
        System.out.println("smaller");
    }
    else{
        System.out.println("Equal");
    }
    }
}
