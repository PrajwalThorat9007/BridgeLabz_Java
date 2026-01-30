/*
Create a program to find the mean height of players present in a football team.
Hint => 
The formula to calculate the mean is: mean = sum of all elements / number of elements
Create a double array named heights of size 11 and get input values from the user.
Find the sum of all the elements present in the array.
Divide the sum by 11 to find the mean height and print the mean height of the football team
*/

import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of players
        int players = sc.nextInt();

        // Array to store height of each player
        double[] height = new double[players];

        // Variable to store total height
        double sum = 0;

        // Read heights and calculate total sum
        for (int i = 0; i < players; i++) {
            height[i] = sc.nextDouble();
            sum = sum + height[i];
        }

        // Calculate mean height
        double meanHeight = sum / players;

        // Display mean height of players
        System.out.println("The mean height of the players is " + meanHeight);
    }
}

