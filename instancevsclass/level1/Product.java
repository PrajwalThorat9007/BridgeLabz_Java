/*
Create a Product class with:
Instance Variables: productName, price.
Class Variable: totalProducts (shared among all products).
Methods:
An instance method displayProductDetails() to display the details of a product.
A class method displayTotalProducts() to show the total number of products created.
 */
class Product {

    String productName;
    double price;

    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // count every product created
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}
