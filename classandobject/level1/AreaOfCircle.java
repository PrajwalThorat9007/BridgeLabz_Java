/*
Program to Compute Area of a Circle
Problem Statement: Write a program to create a Circle class with an attribute radius. Add methods to calculate and display the area and circumference of the circle.
 */
import java.util.Scanner;

class AreaOfCircle {

    // Private data member for radius (not directly used)
    private int radius;
    
    // Method to calculate area of a circle
    public double Area(int radius){
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
    
    // Method to calculate circumference of a circle
    public double Circumference(int radius){
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }
    
    public static void main(String[] args){
        
        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read radius of the circle
        int radius = sc.nextInt();
        
        // Create object of AreaOfCircle class
        AreaOfCircle obj = new AreaOfCircle();

        // Calculate area and circumference
        double A = obj.Area(radius);
        double C = obj.Circumference(radius);
        
        // Display the results
        System.out.println("Area of Circle " + A + " and circumference is " + C);
    }
}
