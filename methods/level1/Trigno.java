/*Write a program to calculate various trigonometric functions using Math class given an angle in degrees
Hint => 
Method to calculate various trigonometric functions, Firstly convert to radians and then use Math function to find sine, cosine and tangent.
public double[] calculateTrigonometricFunctions(double angle)
 */
import java.util.Scanner;

class Trigno {

    // Method to calculate sin, cos, and tan of an angle
    public double[] trignoFunction(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double tan = sin / cos;
        
        return new double[] { sin, cos, tan };
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read angle in degrees
        double num = sc.nextDouble();

        // Convert angle from degrees to radians
        double angle = num * (Math.PI / 180);
        
        // Create object of Trigno class
        Trigno obj = new Trigno();
        
        // Call trigonometric function method
        double[] ans = obj.trignoFunction(angle);
    
        // Display trigonometric values
        System.out.println("Sin= " + ans[0] + " Cos= " + ans[1] + " Tan= " + ans[2]);
    }
}
