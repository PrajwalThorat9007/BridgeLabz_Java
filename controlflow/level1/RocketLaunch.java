/*
Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch
Hint => 
Create a variable counter to take user inputted value for the countdown.
Use the while loop to check if the counter is 1
Inside a while loop, print the value of the counter and decrement the counter.
*/
import java.util.Scanner;

class RocketLaunch {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the starting counter value
        int counter = sc.nextInt();

        // Countdown until launch
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
