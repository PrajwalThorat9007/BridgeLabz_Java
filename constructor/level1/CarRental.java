/*Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to initialize the rental details and calculate total cost. */
// Class representing a car rental system
class CarRental {

    // Private data members to ensure encapsulation
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;
    private double totalCost;

    // Default constructor using constructor chaining
    CarRental() {
        this("Unknown", "Standard", 1, 1000);
    }

    // Parameterized constructor to initialize rental details
    CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
        calculateTotalCost();
    }

    // Method to calculate total rental cost
    private void calculateTotalCost() {
        totalCost = rentalDays * dailyRate;
    }

    // Method to display rental details
    public void display() {
        System.out.println(customerName + "\t" + carModel + "\t" + rentalDays + "\t" + totalCost);
    }

    public static void main(String[] args) {

        // Create CarRental object using default constructor
        CarRental r1 = new CarRental();

        // Create CarRental object using parameterized constructor
        CarRental r2 = new CarRental("Akbar", "Sedan", 5, 1500);

        // Display rental details
        r1.display();
        r2.display();
    }
}
