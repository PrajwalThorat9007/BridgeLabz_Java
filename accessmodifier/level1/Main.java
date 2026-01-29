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

class Book {

    public String ISBN;
    protected String title;
    private String author;

    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
class EBook extends Book {

    String format;

    EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("Format: " + format);
    }
}
public class Main {
    public static void main(String[] args) {

        EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", "PDF");
        ebook.displayDetails();

        ebook.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
