/*
Create a program to find the total income of a person by taking salary and bonus from user
Hint => 
Create a variable named salary and take user input.
Create another variable bonus and take user input.
Compute income by adding salary and bonus and print the result
I/P => salary, bonus
O/P => The salary is INR ___ and bonus is INR ___. Hence Total Income is INR ___
*/
import java.util.Scanner;

class TotalIncome {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read salary amount
        double salary = sc.nextDouble();

        // Read bonus amount
        double bonus = sc.nextDouble();

        // Calculate total income
        double totalIncome = salary + bonus;

        // Display salary, bonus, and total income
        System.out.println(
            "The salary is INR " + salary +
            " and bonus is INR " + bonus +
            ". Hence Total Income is INR " + totalIncome
        );
    }
}
