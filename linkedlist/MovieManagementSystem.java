/*
Problem Statement:
Implement a movie management system using a doubly linked list.
Each node will represent a movie and contain Movie Title, Director,
Year of Release, and Rating.

Functionalities to implement:
1. Add a movie record at the beginning, end, or at a specific position.
2. Remove a movie record by Movie Title.
3. Search for a movie record by Director or Rating.
4. Display all movie records in both forward and reverse order.
5. Update a movie's Rating based on the Movie Title.

Hint:
Use a doubly linked list where each node has two pointers:
one pointing to the next node and the other to the previous node.
Maintain pointers to both the head and tail for easier insertion
and deletion at both ends.
For reverse display, start from the tail and traverse backward
using the prev pointers.
*/
package linkedlist;

class Movie {
    String title;
    String director;
    int releaseYear;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    Movie head;
    Movie tail;

    // Add at beginning
    void addAtBeginning(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);

        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    void addAtEnd(String title, String director, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, releaseYear, rating);

        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based)
    void addAtPosition(int position, String title, String director, int releaseYear, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, releaseYear, rating);
            return;
        }

        Movie current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        Movie newMovie = new Movie(title, director, releaseYear, rating);
        newMovie.next = current.next;
        newMovie.prev = current;

        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }

        current.next = newMovie;
    }

    // Remove by movie title
    void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {

                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                }
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                System.out.println("Movie removed successfully");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found");
    }

    // Search by director
    void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for this director");
        }
    }

    // Search by rating
    void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with this rating");
        }
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    void displayForward() {
        Movie current = head;

        if (current == null) {
            System.out.println("No movie records available");
            return;
        }

        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    // Display reverse
    void displayReverse() {
        Movie current = tail;

        if (current == null) {
            System.out.println("No movie records available");
            return;
        }

        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    void printMovie(Movie movie) {
        System.out.println(
            "Title: " + movie.title +
            ", Director: " + movie.director +
            ", Year: " + movie.releaseYear +
            ", Rating: " + movie.rating
        );
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition(2, "Avatar", "James Cameron", 2009, 7.8);

        System.out.println("Movies (Forward):");
        movieList.displayForward();

        System.out.println("\nMovies (Reverse):");
        movieList.displayReverse();

        System.out.println("\nSearch by Director:");
        movieList.searchByDirector("Christopher Nolan");

        System.out.println("\nUpdate Rating:");
        movieList.updateRating("Avatar", 8.0);

        System.out.println("\nRemove Movie:");
        movieList.removeByTitle("Inception");

        System.out.println("\nFinal Movie List:");
        movieList.displayForward();
    }
}
