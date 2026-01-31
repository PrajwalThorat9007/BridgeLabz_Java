/*
Object modeling: Object relationships and communication
Assisted Problems
Problem 1: Library and Books (Aggregation)
Description: Create a Library class that contains multiple Book objects. Model the relationship such that a library can have many books, but a book can exist independently (outside of a specific library).
Tasks:
Define a Library class with an ArrayList of Book objects.
Define a Book class with attributes such as title and author.
Demonstrate the aggregation relationship by creating books and adding them to different libraries.
Goal: Understand aggregation by modeling a real-world relationship where the Library aggregates Book objects.
 */
import java.util.ArrayList;

// Book class definition
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("Book Title: " + title + ", Author: " + author);
    }
}
// Library class definition
class Library {
    private String libraryName;
    private ArrayList<Book> books;

    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in library
    public void displayLibraryBooks() {
        System.out.println("\nLibrary: " + libraryName);
        for (Book book : books) {
            book.displayBook();
        }
    }
}

// Main class to demonstrate aggregation
public class LibraryManagement {
    public static void main(String[] args) {

        // Independent book objects
        Book book1 = new Book("Clean Code", "Robert C. Martin");
        Book book2 = new Book("Effective Java", "Joshua Bloch");
        Book book3 = new Book("Design Patterns", "Erich Gamma");

        // Library objects
        Library centralLibrary = new Library("Central Library");
        Library collegeLibrary = new Library("College Library");

        // Adding books to libraries
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        collegeLibrary.addBook(book2);
        collegeLibrary.addBook(book3);

        // Display libraries
        centralLibrary.displayLibraryBooks();
        collegeLibrary.displayLibraryBooks();
    }
}
