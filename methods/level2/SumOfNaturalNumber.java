/*Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 
Hint => 
Take the user input number and check whether it's a Natural number, if not exit
Write a Method to find the sum of n natural numbers using recursion
Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2 
Compare the two results and print the result
 */
import java.util.Scanner;

class SumOfNaturalNumbers {

    // Recursive method to calculate sum of natural numbers
    public static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    // Method to calculate sum using mathematical formula
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int n = sc.nextInt();

        // Validate natural number
        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        // Calculate sum using recursion
        int sumUsingRecursion = recursiveSum(n);

        // Calculate sum using formula
        int sumUsingFormula = formulaSum(n);

        // Display both results
        System.out.println("Sum using recursion: " + sumUsingRecursion);
        System.out.println("Sum using formula: " + sumUsingFormula);

        // Compare both results
        if (sumUsingRecursion == sumUsingFormula) {
            System.out.println("Both results are correct and equal");
        } else {
            System.out.println("Results are not equal");
        }

        // Close the Scanner
        sc.close();
    }
}
