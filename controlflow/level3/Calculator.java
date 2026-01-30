/*Write a program to create a calculator using switch...case.
Hint => 
Create two double variables named first and second and a String variable named op.
Get input values for all variables.
The input for the operator can only be one of the four values: "+", "-", "*" or "/".
Run a for loop from i = 1 to i < number.
Based on the input value of the op, perform specific operations using the switch...case statement and print the result.
If op is +, perform addition between first and second; if it is -, perform subtraction and so on.
If op is neither of those 4 values, print Invalid Operator.
 */
import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read two numbers
        double first = sc.nextDouble();
        double second = sc.nextDouble();

        // Read the operator
        String op = sc.next();

        // Perform calculation based on operator
        switch (op) {
            case "+":
                System.out.println(first + second);
                break;

            case "-":
                System.out.println(first - second);
                break;

            case "*":
                System.out.println(first * second);
                break;

            case "/":
                // Check for division by zero
                if (second != 0) {
                    System.out.println(first / second);
                } else {
                    System.out.println("Division by zero not allowed");
                }
                break;

            // Handle invalid operator
            default:
                System.out.println("Invalid Operator");
        }

        // Close the Scanner
        sc.close();
    }
}
