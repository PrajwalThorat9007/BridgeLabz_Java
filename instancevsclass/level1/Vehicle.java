/*
write code to initialise object for class vehicle with variables ownerName and vehicleType
*/
// Class representing a Vehicle
class Vehicle {

    // Instance variables for vehicle details
    String ownerName;
    String vehicleType;

    // Static variable shared by all Vehicle objects
    static double registrationFee = 1500;

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Method to display vehicle and registration details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Static method to update registration fee for all vehicles
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

