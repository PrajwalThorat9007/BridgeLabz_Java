package linkedlist;

/*
Problem Statement:
Design an online ticket reservation system using a circular linked list.
Each node represents a booked ticket with:
Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time.

Functionalities:
- Add a new ticket reservation at the end of the circular list.
- Remove a ticket by Ticket ID.
- Display current tickets.
- Search ticket by Customer Name or Movie Name.
- Calculate total number of booked tickets.
*/

class TicketReservationSystem {

    // Node representing each ticket
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }

    private Ticket tail = null;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (tail == null) {
            tail = newTicket;
            tail.next = tail;
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }

        System.out.println("Ticket booked successfully.");
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {

        if (tail == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = tail.next;
        Ticket prev = tail;

        do {
            if (current.ticketId == ticketId) {

                if (current == tail && current == tail.next) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail)
                        tail = prev;
                }

                System.out.println("Ticket removed successfully.");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != tail.next);

        System.out.println("Ticket not found.");
    }

    // Display all tickets
    public void displayTickets() {

        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = tail.next;

        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                    " | Customer: " + temp.customerName +
                    " | Movie: " + temp.movieName +
                    " | Seat: " + temp.seatNumber +
                    " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != tail.next);
    }

    // Search by customer or movie
    public void searchTicket(String keyword) {

        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = tail.next;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                    temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println("Found Ticket ID: " + temp.ticketId +
                        " | Customer: " + temp.customerName +
                        " | Movie: " + temp.movieName);
                found = true;
            }
            temp = temp.next;
        } while (temp != tail.next);

        if (!found)
            System.out.println("No matching ticket found.");
    }

    // Count total tickets
    public int countTickets() {

        if (tail == null)
            return 0;

        int count = 0;
        Ticket temp = tail.next;

        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Avengers", "B5", "10:05 AM");
        system.addTicket(103, "Charlie", "Inception", "C3", "10:10 AM");

        System.out.println("\nCurrent Tickets:");
        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());

        System.out.println("\nSearch by Movie:");
        system.searchTicket("Inception");

        System.out.println("\nRemoving Ticket 102:");
        system.removeTicket(102);

        System.out.println("\nUpdated Tickets:");
        system.displayTickets();
    }
}

