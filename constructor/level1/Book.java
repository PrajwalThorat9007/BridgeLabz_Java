/*
Create a Book class with attributes title, author, and price. Provide both default and parameterized constructors.
 */
// Class representing a Book
class Book {

    // Private data members to ensure encapsulation
    private String title;
    private String author;
    private double price;

    // Default constructor initializing default values
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor to initialize book details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book information
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        // Create Book object using default constructor
        Book b1 = new Book();

        // Create Book object using parameterized constructor
        Book b2 = new Book("Clean Code", "Robert C. Martin", 450.0);

        // Display details of default constructor object
        System.out.println("Default Constructor Output:");
        b1.displayBook();

        // Display details of parameterized constructor object
        System.out.println("\nParameterized Constructor Output:");
        b2.displayBook();
    }
}
