/*
Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. Use default, parameterized, and copy constructors to initialize bookings.
 */

class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
        this("Unknown", "Standard", 1);
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    public void display() {
        System.out.println(guestName + "\t" + roomType + "\t" + nights);
    }

    public static void main(String[] args) {

        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Amar", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);

        b1.display();
        b2.display();
        b3.display();
    }
}
