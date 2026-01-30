/*Create a program to check if a number is Armstrong or not. Use the hints to show the steps clearly in the code
Hint => 
Armstrong Number is a number whose Sum of cubes of each digit results in the original number e.g. 153 = 1^3 + 5^3 + 3^3
Get an integer input and store it in the number variable define sum variable, initialize it to zero and originalNumber variable, and assign it to the input number variable
Use the while loop till the originalNumber is not equal to zero
In the while loop find the reminder number by using the modulus operator as in  number % 10. Find the cube of the number and add it to the sum variable
Again in while loop find the quotient of the number and assign it to the original number using number / 10 expression. This romoves the last digit of the original number.
Finally check if the number and the sum are the same, if same its an Armstrong number else not. So display accordingly
 */
import java.util.Scanner;

class ArmstrongNumber {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Prompt and read the number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Store original number for comparison
        int originalNumber = number;

        // Variable to store sum of cubes of digits
        int sum = 0;

        // Extract digits and calculate sum of their cubes
        while (originalNumber != 0) {

            int digit = originalNumber % 10;

            sum = sum + (digit * digit * digit);

            originalNumber = originalNumber / 10;
        }

        // Check whether the number is an Armstrong number
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }

        // Close the Scanner
        sc.close();
    }
}

