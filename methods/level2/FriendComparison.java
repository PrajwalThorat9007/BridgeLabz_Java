/*
Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it
Hint => 
Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
Write a Method to find the youngest of the 3 friends
Write a Method to find the tallest of the 3 friends

 */
import java.util.Scanner;

class FriendComparison {

    // Method to find the youngest friend based on ages
    public static String findYoungest(int[] ages, String[] names) {
        int minIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return names[minIndex];
    }

    // Method to find the tallest friend based on heights
    public static String findTallest(double[] heights, String[] names) {
        int maxIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return names[maxIndex];
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Names of the friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store ages and heights
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Read age and height for each friend
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        // Find youngest and tallest friend
        String youngest = findYoungest(ages, names);
        String tallest = findTallest(heights, names);

        // Display results
        System.out.println("Youngest friend is: " + youngest);
        System.out.println("Tallest friend is: " + tallest);

        // Close the Scanner
        sc.close();
    }
}

