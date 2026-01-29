/*
Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
Hint => 
Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
Loop through the array and find the youngest of the 3 friends and the tallest of the 3 friends
Finally display the youngest and tallest of the 3 friends
*/
import java.util.Scanner;

class YoungestFriend {
    public static void main(String[] args){
        int[] age=new int[3];
        int[] height=new int[3];
        int youngInd=0;
        int young=100;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++){
            age[i]=sc.nextInt();
            if(age[i]<young){
                young=age[i];
                youngInd=i;
            }
        }
        int maxHeight=0;
        int maxInd=0;
        for(int i=0;i<3;i++){
            height[i]=sc.nextInt();
            if(height[i]>maxHeight){
                maxHeight=height[i];
                maxInd=i;
            }
        }
        
        System.out.println("youngest among them "+age[youngInd]+" tallest among them "+height[maxInd]);
        
    }
}
