/*
Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
Hint => 
Take user input for the age and height of the 3 friends and store it in a variable
Find the smallest of the 3 ages to find the youngest friend and display it
Find the largest of the 3 heights to find the tallest friend and display it
*/
import java.util.Scanner;

class FriendsInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ages
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        // Heights (in cm)
        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();

        // Find youngest
        String youngest;
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            youngest = "Amar";
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        // Find tallest
        String tallest;
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            tallest = "Amar";
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is " + youngest);
        System.out.println("The tallest friend is " + tallest);
    }
}