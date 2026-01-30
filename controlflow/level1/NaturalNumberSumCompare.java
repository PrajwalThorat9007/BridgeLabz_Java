/*
Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 
Hint => 
Take the user input number and check whether it's a Natural number
If it's a natural number Compute using formulae as well as compute using while loop
Compare the two results and print the result
*/
import java.util.Scanner;

class NaturalNumberSumCompare {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the number
        int n = sc.nextInt();

        // Check if the number is a natural number
        if (n >= 1) {

            // Calculate sum using formula
            int sumUsingFormula = n * (n + 1) / 2;

            // Calculate sum using while loop
            int sumUsingLoop = 0;
            int i = 1;

            while (i <= n) {
                sumUsingLoop = sumUsingLoop + i;
                i++;
            }

            // Display both results
            System.out.println("Sum using formula is " + sumUsingFormula);
            System.out.println("Sum using while loop is " + sumUsingLoop);

            // Compare both results
            if (sumUsingFormula == sumUsingLoop) {
                System.out.println("Both results are correct");
            } else {
                System.out.println("Results are not matching");
            }

        } else {

            // Display error message for non-natural number
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
