/*
Write a program to find the side of the square whose parameter you read from user 
Hint => Perimeter of Square is 4 times side
I/P => perimeter
O/P => The length of the side is ___ whose perimeter is ____
*/
import java.util.Scanner;

class SideOfSquare {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read the perimeter of the square
        int parameter = sc.nextInt();
        
        // Calculate side length of the square
        int side = parameter / 4;

        // Display the side length and given perimeter
        System.out.printf(
            "The length of the side is %d whose perimeter is %d",
            side, parameter
        );
    }
}
