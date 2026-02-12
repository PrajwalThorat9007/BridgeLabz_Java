package linkedlist;

/*
Problem Statement:
Design a library management system using a doubly linked list. Each node represents a book and contains:
Book Title, Author, Genre, Book ID, and Availability Status.

Functionalities:
- Add a new book at the beginning, end, or at a specific position.
- Remove a book by Book ID.
- Search for a book by Book Title or Author.
- Update a book’s Availability Status.
- Display all books in forward and reverse order.
- Count total number of books.
*/

class LibraryManagementSystem {

    // Node class representing a Book
    static class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Book next;
        Book prev;

        Book(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
        }
    }

    private Book head;
    private Book tail;

    // Add book at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add book at specific position (1-based index)
    public void addAtPosition(String title, String author, String genre, int bookId, boolean available, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, available);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, available);
        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, available);
            return;
        }

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    // Remove book by Book ID
    public void removeById(int bookId) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Book removed successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Search by title or author
    public void search(String keyword) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) ||
                    temp.author.equalsIgnoreCase(keyword)) {

                System.out.println("Found: " + temp.title + " | " + temp.author);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Display books forward
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author +
                    " | " + temp.genre + " | Available: " + temp.available);
            temp = temp.next;
        }
    }

    // Display books in reverse
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author +
                    " | " + temp.genre + " | Available: " + temp.available);
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {

        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addAtEnd("Java Basics", "James Gosling", "Programming", 101, true);
        library.addAtEnd("Data Structures", "Mark Allen", "Computer Science", 102, true);
        library.addAtBeginning("Algorithms", "CLRS", "Computer Science", 100, true);

        library.displayForward();
        System.out.println("Total Books: " + library.countBooks());

        library.search("Java Basics");

        library.updateAvailability(101, false);

        library.removeById(102);

        System.out.println("Reverse Order:");
        library.displayReverse();
    }
}

