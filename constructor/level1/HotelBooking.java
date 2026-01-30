/*
Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. Use default, parameterized, and copy constructors to initialize bookings.
 */
// Class representing a hotel booking
class HotelBooking {

    // Private data members to ensure encapsulation
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor using constructor chaining
    HotelBooking() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor to initialize booking details
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor to create a new object from an existing one
    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    // Method to display booking details
    public void display() {
        System.out.println(guestName + "\t" + roomType + "\t" + nights);
    }

    public static void main(String[] args) {

        // Create booking using default constructor
        HotelBooking b1 = new HotelBooking();

        // Create booking using parameterized constructor
        HotelBooking b2 = new HotelBooking("Amar", "Deluxe", 3);

        // Create booking using copy constructor
        HotelBooking b3 = new HotelBooking(b2);

        // Display all booking details
        b1.display();
        b2.display();
        b3.display();
    }
}

