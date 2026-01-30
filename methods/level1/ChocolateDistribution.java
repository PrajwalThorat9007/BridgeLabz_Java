/*Create a program to divide N number of chocolates among M children. Print the number of chocolates each child will get and also the remaining chocolates
Hint => 
Get an integer value from user for the numberOfchocolates and numberOfChildren.
Write the method to find the number of chocolates each child gets and number of remaining chocolates
public static int[] findRemainderAndQuotient(int number, int divisor)  */
import java.util.Scanner;

class ChocolateDistribution {

    // Method to calculate quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of chocolates and number of children
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        // Call method to get quotient and remainder
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Display distribution result
        System.out.println("Chocolates each child gets: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);

        // Close the Scanner
        sc.close();
    }
}
