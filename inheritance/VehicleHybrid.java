/*
Description: Model a vehicle system where Vehicle is the superclass and ElectricVehicle and PetrolVehicle are subclasses. Additionally, create a Refuelable interface implemented by PetrolVehicle.
Tasks:
Define a superclass Vehicle with attributes like maxSpeed and model.
Create an interface Refuelable with a method refuel().
Define subclasses ElectricVehicle and PetrolVehicle. PetrolVehicle should implement Refuelable, while ElectricVehicle include a charge() method.
Goal: Use hybrid inheritance by having PetrolVehicle implement both Vehicle and Refuelable, demonstrating how Java interfaces allow adding multiple behaviors.
 */
// Interface defining refueling behavior
package inheritance;

interface Refuelable {
    void refuel(); // method to be implemented
}

// Superclass
class Vehicle {
    int maxSpeed; // maximum speed
    String model; // vehicle model

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed; // initializing max speed
        this.model = model; // initializing model
    }

    // method to display vehicle details
    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model); // calling parent constructor
    }

    // electric vehicle specific behavior
    void charge() {
        System.out.println("Electric vehicle is charging.");
    }
}

// PetrolVehicle subclass implementing interface
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model); // calling parent constructor
    }

    // implementing refuel method
    @Override
    public void refuel() {
        System.out.println("Petrol vehicle is refueling.");
    }
}

// Main class
public class VehicleHybrid {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3"); // creating electric vehicle
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City"); // creating petrol vehicle

        ev.displayDetails(); // displaying EV details
        ev.charge(); // charging EV
        System.out.println();

        pv.displayDetails(); // displaying petrol vehicle details
        pv.refuel(); // refueling petrol vehicle
    }
}
