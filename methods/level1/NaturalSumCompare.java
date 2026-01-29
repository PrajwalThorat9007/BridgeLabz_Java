/*Write a program to find the sum of n natural numbers using loop
Hint => Get integer input from the user. Write a Method to find the sum of n natural numbers using loop  
*/
import java.util.Scanner;

class NaturalSumCompare {

    // Recursive method
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    // Formula method
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Check for natural number
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
            return;
        }

        int recursiveSum = sumUsingRecursion(n);
        int formulaSum = sumUsingFormula(n);

        System.out.println("Sum using recursion = " + recursiveSum);
        System.out.println("Sum using formula = " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both results are correct");
        } else {
            System.out.println("Results are not matching");
        }
    }
}
