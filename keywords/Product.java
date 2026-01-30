/*
Create a Product class to manage shopping cart items with the following features:
Static:
A static variable discount shared by all products.
A static method updateDiscount() to modify the discount percentage.
This:
Use this to initialize productName, price, and quantity in the constructor.
Final:
Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
Instanceof:
Validate whether an object is an instance of the Product class before processing its details. 
*/
class Product {

    static double discount = 10.0;
    private static int count = 0;

    private final int productID;
    private String name;
    private double price;
    private int qty;

    // Constructor to initialize product details
    Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.productID = ++count;
    }

    // Updates discount percentage for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Processes product details after checking object type
    public static void processProduct(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            double total = p.price * p.qty;
            double finalPrice = total - (total * discount / 100);

            System.out.println("Product ID   : " + p.productID);
            System.out.println("Name         : " + p.name);
            System.out.println("Price        : ₹" + p.price);
            System.out.println("Quantity     : " + p.qty);
            System.out.println("Discount     : " + discount + "%");
            System.out.println("Final Amount : ₹" + finalPrice);
        } else {
            System.out.println("Invalid product object");
        }
    }

    // Entry point of the program
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 60000, 1);
        Product p2 = new Product("Mouse", 500, 2);

        updateDiscount(15);

        processProduct(p1);
        System.out.println();
        processProduct(p2);
    }
}
