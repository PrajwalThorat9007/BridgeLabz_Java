/*
Rewrite the program number 12 with the for loop instead of a while loop to find the sum of n Natural Numbers. 
Hint => 
Take the user input number and check whether it's a Natural number
If it's a natural number Compute using formulae as well as compute using for loop
Compare the two results and print the result
*/
import java.util.Scanner;

class NaturalNumberSumCompareFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1) {
            int sumUsingFormula = n * (n + 1) / 2;

            int sumUsingLoop = 0;

            for (int i = 1; i <= n; i++) {
                sumUsingLoop = sumUsingLoop + i;
            }

            System.out.println("Sum using formula is " + sumUsingFormula);
            System.out.println("Sum using for loop is " + sumUsingLoop);

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