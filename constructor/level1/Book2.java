/*Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a book. */

class Book2 {

    private String title;
    private String author;
    private double price;
    private boolean available;

    Book2(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void display() {
        System.out.println(title + "\t" + author + "\t" + price + "\t" + available);
    }

    public static void main(String[] args) {

        Book2 b1 = new Book2("Java Basics", "James Gosling", 499.0);

        b1.display();
        b1.borrowBook();
        b1.borrowBook();
        b1.display();
    }
}
