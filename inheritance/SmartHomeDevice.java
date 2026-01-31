/*
Description: Create a hierarchy for a smart home system where Device is the superclass and Thermostat is a subclass.
Tasks:
Define a superclass Device with attributes like deviceId and status.
Create a subclass Thermostat with additional attributes like temperatureSetting.
Implement a method displayStatus() to show each device's current settings.
Goal: Understand single inheritance by adding specific attributes to a subclass, keeping the superclass general.

 */
// Superclass
class Device {
    String deviceId; // device identifier
    String status; // device status (ON/OFF)

    Device(String deviceId, String status) {
        this.deviceId = deviceId; // initializing device id
        this.status = status; // initializing status
    }

    // method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    double temperatureSetting; // temperature value

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status); // calling superclass constructor
        this.temperatureSetting = temperatureSetting; // initializing temperature
    }

    // overriding displayStatus method
    @Override
    void displayStatus() {
        super.displayStatus(); // displaying device details
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class
public class SmartHomeDevice {
    public static void main(String[] args) {

        Thermostat thermostat = new Thermostat("TH-101", "ON", 24.5); // creating thermostat
        thermostat.displayStatus(); // displaying thermostat status
    }
}
