/*
Create a program to divide N number of chocolates among M children.
Hint => 
Get an integer value from user for the numberOfchocolates and numberOfChildren.
Find the number of chocolates each child gets and number of remaining chocolates
Display the results
I/P => numberOfchocolates, numberOfChildren
O/P => The number of chocolates each child gets is ___ and the number of remaining chocolates are ___
*/
import java.util.Scanner;

class ChocolateDistribution {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read total number of chocolates
        int chocolates = sc.nextInt();

        // Read number of children
        int children = sc.nextInt();

        // Calculate chocolates each child gets
        int eachChildGets = chocolates / children;

        // Calculate remaining chocolates
        int remaining = chocolates % children;

        // Display distribution result
        System.out.println(
            "Each child gets " + eachChildGets +
            " chocolates and remaining chocolates are " + remaining
        );
    }
}
