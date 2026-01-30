/*Create a program to count the number of digits in an integer.
Hint => 
Get an integer input for the number variable.
Create an integer variable count with value 0.
Use a loop to iterate until number is not equal to 0.
Remove the last digit from number in each iteration
Increase count by 1 in each iteration.
Finally display the count to show the number of digits
 */
import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int number = sc.nextInt();

        // Variable to count digits
        int count = 0;

        // Count number of digits in the number
        while (number != 0) {
            number = number / 10;
            count++;
        }

        // Print the digit count
        System.out.println(count);

        // Close the Scanner
        sc.close();
    }
}
