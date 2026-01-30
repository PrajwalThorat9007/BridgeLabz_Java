/*
Create a program to find the maximum number of handshakes among N number of students.
Hint => 
Get integer input for numberOfStudents variable.
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
Display the number of possible handshakes.
*/

import java.util.Scanner;

class NoOfHandshake {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read number of students
        int student = sc.nextInt();
        
        // Calculate number of handshakes using combination formula
        int combination = (student * (student - 1)) / 2;

        // Display total number of handshakes
        System.out.println(combination);
    }
}
