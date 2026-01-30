/*
Problem 2: Book Library System
Design a Book class with:
ISBN (public).
title (protected).
author (private).
Write methods to:
Set and get the author name.
Create a subclass EBook to access ISBN and title and demonstrate access modifiers.
 */

// Base class representing a book
class Book {

    // Public ISBN accessible everywhere
    public String ISBN;

    // Protected title accessible to subclasses
    protected String title;

    // Private author to ensure encapsulation
    private String author;

    // Constructor to initialize book details
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter method to update author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method to access author name
    public String getAuthor() {
        return author;
    }
}

// Derived class representing an electronic book
class EBook extends Book {

    // File format of the eBook
    String format;

    // Constructor to initialize eBook details
    EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    // Method to display eBook details
    void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("Format: " + format);
    }
}

// Main class to test Book and EBook functionality
public class Main {
    public static void main(String[] args) {

        // Create an EBook object
        EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", "PDF");

        // Display initial eBook details
        ebook.displayDetails();

        // Update author name and display updated value
        ebook.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}

