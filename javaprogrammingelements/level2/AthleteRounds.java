/*
An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
I/P => side1, side2, side3
O/P => The total number of rounds the athlete will run is ___ to complete 5 km
Create a program to divide N number of chocolates among M children.
*/
import java.util.Scanner;

class AthleteRounds {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read lengths of three sides of the triangular track
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();

        // Calculate perimeter of the triangular track
        double perimeter = side1 + side2 + side3;

        // Total distance to be covered (5 km in meters)
        double totalDistance = 5000;

        // Calculate number of rounds required to complete 5 km
        double rounds = totalDistance / perimeter;

        // Display the number of rounds
        System.out.println(
            "The total number of rounds the athlete will run is " + rounds +
            " to complete 5 km"
        );
    }
}
