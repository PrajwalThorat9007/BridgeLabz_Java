/*
Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
Hint => 
Use infinite while loop as in while (true)
Take the user entry and check if the user entered 0 or a negative number to break the loop using break;
*/
import java.util.Scanner;

class DivisibleByFive {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Variable to store total sum
        double total = 0;

        // Continuously read numbers until 0 is entered
        while (true) {
            double num = sc.nextDouble();

            // Stop input when 0 is entered
            if (num == 0)
                break;
            else {
                // Add number to total
                total = total + num;
            }
        }

        // Print the total sum
        System.out.println(total);
    }
}
