/*
Write a Circle class with a radius attribute. Use constructor chaining to initialize radius with default and user-provided values.
 */

class Circle {

    private double radius;

    // Default constructor
    Circle() {
        this(1.0);   // constructor chaining
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to display radius and area
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);

        System.out.println("Default Circle:");
        c1.display();

        System.out.println("\nUser-defined Circle:");
        c2.display();
    }
}
