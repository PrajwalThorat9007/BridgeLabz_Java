/*Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to initialize the rental details and calculate total cost. */
class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;
    private double totalCost;

    CarRental() {
        this("Unknown", "Standard", 1, 1000);
    }

    CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        totalCost = rentalDays * dailyRate;
    }

    public void display() {
        System.out.println(customerName + "\t" + carModel + "\t" + rentalDays + "\t" + totalCost);
    }

    public static void main(String[] args) {

        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Akbar", "Sedan", 5, 1500);

        r1.display();
        r2.display();
    }
}
