/*
Write a program to find the 3 points that are collinear using the slope formulae and area of triangle formulae. check  A (2, 4), B (4, 6) and C (6, 8) are Collinear for sampling. 
Hint => 
Take inputs for 3 points x1, y1, x2, y2, and x3, y3
Write a Method to find the 3 points that are collinear using the slope formula. The 3 points A(x1,y1), b(x2,y2), and c(x3,y3) are collinear if the slopes formed by 3 points ab, bc, and cd are equal. 
slope AB = (y2 - y1)/(x2 - x1), slope BC = (y3 - y2)/(x3 - x3)
slope AC = (y3 - y1)/(x3 - x1) Points are collinear if
slope AB = slope BC = slope Ac
The method to find the three points is collinear using the area of the triangle formula. The Three points are collinear if the area of the triangle formed by three points is 0. The area of a triangle is

 */
import java.util.Scanner;

class CollinearPoints {

    // Method to check collinearity using slope comparison
    public static boolean checkCollinearUsingSlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // Method to check collinearity using area of triangle
    public static boolean checkCollinearUsingArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );

        return area == 0;
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read coordinates of three points
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        // Check collinearity using slope method
        boolean slopeResult = checkCollinearUsingSlope(x1, y1, x2, y2, x3, y3);

        // Check collinearity using area method
        boolean areaResult = checkCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        // Display final result
        if (slopeResult && areaResult) {
            System.out.println("The given points are Collinear");
        } else {
            System.out.println("The given points are NOT Collinear");
        }

        // Close the Scanner
        sc.close();
    }
}
