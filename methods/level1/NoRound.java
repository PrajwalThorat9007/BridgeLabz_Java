/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;

class NoRound {

    // Method to calculate number of rounds based on track sides
    void Rounds(int side1, int side2, int side3) {

        // Calculate perimeter of the track
        int round = side1 + side2 + side3;

        // Calculate number of rounds for 5 km
        int noRound = round / 5;

        // Check if running is required
        if (noRound <= 0) {
            System.out.println("No need to Run");
        } else {
            System.out.println(noRound);
        }
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read lengths of three sides
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();

        // Create object of NoRound class
        NoRound obj = new NoRound();

        // Call method to calculate number of rounds
        obj.Rounds(side1, side2, side3);
    }
}
