/*Write a program to find the smallest and the largest of the 3 numbers.
Hint => 
Take user input for 3 numbers
Write a single method to find the smallest and largest of the three numbers
public static int[] findSmallestAndLargest(int number1, int number2, int number3)
 */
import java.util.Scanner;

class SmallestLargest {

    // Method to find smallest and largest among three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;
        
        // Compare to find smallest number
        if (number2 < smallest) {
            smallest = number2;
        }
        if (number3 < smallest) {
            smallest = number3;
        }

        // Compare to find largest number
        if (number2 > largest) {
            largest = number2;
        }
        if (number3 > largest) {
            largest = number3;
        }

        return new int[] { smallest, largest };
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read three integers
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        
        // Call method to find smallest and largest
        int[] result = findSmallestAndLargest(num1, num2, num3);
        
        // Display smallest and largest values
        System.out.println("Smallest number is " + result[0]);
        System.out.println("Largest number is " + result[1]);
    }
}
