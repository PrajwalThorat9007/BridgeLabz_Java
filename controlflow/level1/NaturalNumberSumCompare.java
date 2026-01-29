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
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1) {
            int sumUsingFormula = n * (n + 1) / 2;

            int sumUsingLoop = 0;
            int i = 1;

            while (i <= n) {
                sumUsingLoop = sumUsingLoop + i;
                i++;
            }

            System.out.println("Sum using formula is " + sumUsingFormula);
            System.out.println("Sum using while loop is " + sumUsingLoop);

            if (sumUsingFormula == sumUsingLoop) {
                System.out.println("Both results are correct");
            } else {
                System.out.println("Results are not matching");
            }

        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}