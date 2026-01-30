/*
Rewrite program 8 to do the countdown using the for-loop
*/
import java.util.Scanner;

class RocketLaunch2 {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the starting counter value
        int counter = sc.nextInt();

        // Countdown using for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
