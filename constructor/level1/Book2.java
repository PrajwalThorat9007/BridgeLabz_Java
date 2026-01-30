/*Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a book. */

// Class representing a Book with availability status
class Book2 {

    // Private data members to ensure encapsulation
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Constructor to initialize book details and set availability to true
    Book2(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    // Method to borrow the book if it is available
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    // Method to display book details and availability status
    public void display() {
        System.out.println(title + "\t" + author + "\t" + price + "\t" + available);
    }

    public static void main(String[] args) {

        // Create a Book2 object
        Book2 b1 = new Book2("Java Basics", "James Gosling", 499.0);

        // Display initial book details
        b1.display();

        // Attempt to borrow the book twice
        b1.borrowBook();
        b1.borrowBook();

        // Display updated book details
        b1.display();
    }
}
