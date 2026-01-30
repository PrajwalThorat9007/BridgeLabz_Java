/*
Rewrite the Sample Program 2 with user inputs
Hint => 
Create variables and take user inputs for name, fromCity, viaCity, toCity
Create variables and take user inputs for distances fromToVia and viaToFinalCity in Miles
Create Variables and take time taken 
Finally, print the result and try to understand operator precedence.
I/P => fee, discountPrecent
O/P => The results of Int Operations are ___, ___, and ___
*/
import java.util.Scanner;

class SampleProgram2 {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read personal and travel details
        String name = sc.nextLine();
        String fromCity = sc.nextLine();
        String viaCity = sc.nextLine();
        String toCity = sc.nextLine();

        // Read distances between cities
        double fromToVia = sc.nextDouble();
        double viaToFinalCity = sc.nextDouble();

        // Read total time taken for the journey
        double timeTaken = sc.nextDouble();

        // Calculate total distance traveled
        double totalDistance = fromToVia + viaToFinalCity;

        // Calculate average speed
        double averageSpeed = totalDistance / timeTaken;

        // Display journey and speed details
        System.out.println(
            "Name: " + name +
            "\nFrom: " + fromCity +
            "\nVia: " + viaCity +
            "\nTo: " + toCity +
            "\nTotal Distance: " + totalDistance + " miles" +
            "\nTime Taken: " + timeTaken + " hours" +
            "\nAverage Speed: " + averageSpeed + " miles/hour"
        );
    }
}
