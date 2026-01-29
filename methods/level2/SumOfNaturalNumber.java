/*Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 
Hint => 
Take the user input number and check whether it's a Natural number, if not exit
Write a Method to find the sum of n natural numbers using recursion
Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2 
Compare the two results and print the result
 */
import java.util.Scanner;

class SumOfNaturalNumbers {

    public static int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int sumUsingRecursion = recursiveSum(n);
        int sumUsingFormula = formulaSum(n);

        System.out.println("Sum using recursion: " + sumUsingRecursion);
        System.out.println("Sum using formula: " + sumUsingFormula);

        if (sumUsingRecursion == sumUsingFormula) {
            System.out.println("Both results are correct and equal");
        } else {
            System.out.println("Results are not equal");
        }

        sc.close();
    }
}
