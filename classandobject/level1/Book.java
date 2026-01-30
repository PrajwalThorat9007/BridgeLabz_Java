/*
Program to Handle Book Details
Problem Statement: Write a program to create a Book class with attributes title, author, and price. Add a method to display the book details.
 */
// Class representing a Book
class Book {

    // Private data members to ensure encapsulation
    private String title;
    private String author;
    private int price;
    
    // Method to set book details
    public void setData(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Method to display book details
    public void getData(){
        System.out.println("Title is " + title + " author is " + author + " price is " + price);
    }
    
    public static void main(String[] args){
        
        // Create a Book object
        Book bk1 = new Book();

        // Set book data
        bk1.setData("Wings", "DaVinci", 225);

        // Display book data
        bk1.getData();
    }
}
