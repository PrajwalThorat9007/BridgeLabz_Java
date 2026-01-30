/*
Create a Product class with:
Instance Variables: productName, price.
Class Variable: totalProducts (shared among all products).
Methods:
An instance method displayProductDetails() to display the details of a product.
A class method displayTotalProducts() to show the total number of products created.
 */
// Class representing a Product
class Product {

    // Instance variables for product details
    String productName;
    double price;

    // Static variable to keep track of total products created
    static int totalProducts = 0;

    // Constructor to initialize product details
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment count when a product is created
    }

    // Method to display individual product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Static method to display total number of products
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

