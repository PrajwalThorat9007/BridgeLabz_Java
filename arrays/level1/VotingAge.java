/*
Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Define an array of 10 integer elements and take user input for the student's age. 
Loop through the array using the length property and for the element of the array check If the age is a negative number print an invalid age and if 18 or above, print The student with the age ___ can vote. Otherwise, print The student with the age ___ cannot vote.
*/

import java.util.Scanner;

class VotingAge{
    public static void main(String[] args){
    int[] Age=new int[10];
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<Age.length;i++){
        Age[i]=sc.nextInt();
    }
    for(int i=0;i<Age.length;i++){
        if(Age[i]>=18){
            System.out.println(Age[i]+" can vote");
        }
        else{
            System.out.println(Age[i]+" cannot vote");
        }
    }
    }
}
