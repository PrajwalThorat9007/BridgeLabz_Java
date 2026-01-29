/*
Create a Book class with attributes title, author, and price. Provide both default and parameterized constructors.
 */
class Book {

    private String title;
    private String author;
    private double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Book b1 = new Book();
        Book b2 = new Book("Clean Code", "Robert C. Martin", 450.0);

        System.out.println("Default Constructor Output:");
        b1.displayBook();

        System.out.println("\nParameterized Constructor Output:");
        b2.displayBook();
    }
}
