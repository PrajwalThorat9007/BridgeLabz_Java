/*Create a program to find the maximum number of handshakes among N number of students.
Hint => 
Get integer input for number of students
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
Write a method to use the combination formulae to calculate the number of handshakes
 */
import java.util.Scanner;

class NoHandshake {

    // Method to calculate number of handshakes
    void NoOfhandshake(int num) {
        int Handshake = (num * (num - 1)) / 2;
        System.out.println(Handshake);
    }

    public static void main(String[] args) {

        // Create object of NoHandshake class
        NoHandshake obj = new NoHandshake();

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of people
        int num = sc.nextInt();

        // Call method to calculate handshakes
        obj.NoOfhandshake(num);
    }
}
