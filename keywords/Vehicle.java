/*
Create a Vehicle class with the following features:
Static:
A static variable registrationFee common for all vehicles.
A static method updateRegistrationFee() to modify the fee.
This:
Use this to initialize ownerName, vehicleType, and registrationNumber in the constructor.
Final:
Use a final variable registrationNumber to uniquely identify each vehicle.
Instanceof:
Check if an object belongs to the Vehicle class before displaying its registration details.
*/
class Vehicle {

    static double regFee = 1500.0;

    private final String regNo;
    private String owner;
    private String type;

    // Constructor to initialize vehicle details
    Vehicle(String owner, String type, String regNo) {
        this.owner = owner;
        this.type = type;
        this.regNo = regNo;
    }

    // Updates the registration fee for all vehicles
    public static void updateRegistrationFee(double newFee) {
        regFee = newFee;
    }

    // Displays vehicle registration details after checking object type
    public static void showDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            System.out.println("Owner Name        : " + v.owner);
            System.out.println("Vehicle Type      : " + v.type);
            System.out.println("Registration No   : " + v.regNo);
            System.out.println("Registration Fee  : ₹" + regFee);
        } else {
            System.out.println("Object is not a Vehicle");
        }
    }

    // Entry point of the program
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Prajwal", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Rahul", "Bike", "MH14CD5678");

        updateRegistrationFee(2000);

        showDetails(v1);
        System.out.println();
        showDetails(v2);
    }
}
