/*Write a program to check whether a number is positive, negative, or zero.
Hint => Get integer input from the user. Write a Method to return -1 for negative number, 1 for positive number and 0 if number is zero */
import java.util.Scanner;

class Nature {

    // Method to check whether the number is positive, negative, or zero
    void Nature(int num) {
        if (num > 0) {
            System.out.println("Positive");
        } else if (num < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read the number
        int num = sc.nextInt();

        // Create object of Nature class
        Nature obj = new Nature();
        
        // Call method to check nature of the number
        obj.Nature(num);
    }
}
