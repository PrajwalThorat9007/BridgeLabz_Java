/*
Description: Model a Book system where Book is the superclass, and Author is a subclass.
Tasks:
Define a superclass Book with attributes like title and publicationYear.
Define a subclass Author with additional attributes like name and bio.
Create a method displayInfo() to show details of the book and its author.
Goal: Practice single inheritance by extending the base class and adding more specific details in the subclass.
 */
// Superclass
class Book {
    String title; // book title
    int publicationYear; // year of publication

    Book(String title, int publicationYear) {
        this.title = title; // initializing title
        this.publicationYear = publicationYear; // initializing year
    }

    // method to display book information
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String authorName; // author name
    String bio; // author biography

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear); // calling superclass constructor
        this.authorName = authorName; // initializing author name
        this.bio = bio; // initializing bio
    }

    // overriding displayInfo method
    @Override
    void displayInfo() {
        super.displayInfo(); // displaying book details
        System.out.println("Author Name: " + authorName);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class
public class BookAuthorInheritanceDemo {
    public static void main(String[] args) {

        Author book1 = new Author(
                "Clean Code",
                2008,
                "Robert C. Martin",
                "Software engineer and author focused on clean coding practices"
        );

        book1.displayInfo(); // displaying complete details
    }
}
