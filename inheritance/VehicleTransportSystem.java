/*
Vehicle and Transport System
Description: Design a vehicle hierarchy where Vehicle is the superclass, and Car, Truck, and Motorcycle are subclasses with unique attributes.
Tasks:
Define a superclass Vehicle with maxSpeed and fuelType attributes and a method displayInfo().
Define subclasses Car, Truck, and Motorcycle, each with additional attributes, such as seatCapacity for Car.
Demonstrate polymorphism by storing objects of different subclasses in an array of Vehicle type and calling displayInfo() on each.
Goal: Understand how inheritance helps in organizing shared and unique features across subclasses and use polymorphism for dynamic method calls.
 */
// Superclass
class Vehicle {
    int maxSpeed; // maximum speed of vehicle
    String fuelType; // fuel type

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed; // initializing max speed
        this.fuelType = fuelType; // initializing fuel type
    }

    // method to display vehicle information
    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car subclass
class Car extends Vehicle {
    int seatCapacity; // number of seats

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType); // calling superclass constructor
        this.seatCapacity = seatCapacity; // initializing seat capacity
    }

    // overriding displayInfo
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass
class Truck extends Vehicle {
    double loadCapacity; // load capacity in tons

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType); // calling superclass constructor
        this.loadCapacity = loadCapacity; // initializing load capacity
    }

    // overriding displayInfo
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    boolean hasGear; // gear availability

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType); // calling superclass constructor
        this.hasGear = hasGear; // initializing gear information
    }

    // overriding displayInfo
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
    }
}

// Main class
public class VehicleTransportSystem {
    public static void main(String[] args) {

        // storing different subclass objects in Vehicle array
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10.5);
        vehicles[2] = new Motorcycle(140, "Petrol", true);

        // demonstrating runtime polymorphism
        for (Vehicle v : vehicles) {
            v.displayInfo(); // dynamic method call
            System.out.println();
        }
    }
}
