/*

*/
import java.util.Scanner;

class DoubleOpt {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read three double values
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Perform different double arithmetic operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        // Display results of all operations
        System.out.println(
            "The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " +
            result4
        );
    }
}
