/*
Problem 4: E-commerce Platform with Orders, Customers, and Products
Description: Design an e-commerce platform with Order, Customer, and Product classes. Model relationships where a Customer places an Order, and each Order contains multiple Product objects.
Goal: Show communication and object relationships by designing a system where customers communicate through orders, and orders aggregate products.
 */
import java.util.ArrayList;

// Product can exist independently (Aggregation)
class Product {
    private String productName; // product name
    private double price; // product price

    public Product(String productName, double price) {
        this.productName = productName; // initializing product name
        this.price = price; // initializing product price
    }

    public String getProductName() {
        return productName; // returning product name
    }

    public double getPrice() {
        return price; // returning product price
    }
}

// Order aggregates multiple products
class Order {
    private int orderId; // order id
    private ArrayList<Product> products; // aggregated products

    public Order(int orderId) {
        this.orderId = orderId; // initializing order id
        this.products = new ArrayList<>(); // initializing product list
    }

    // communication: adding product to order
    public void addProduct(Product product) {
        products.add(product); // adding product
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;

        for (Product p : products) {
            System.out.println("  Product: " + p.getProductName() + " | Price: ₹" + p.getPrice());
            total += p.getPrice(); // calculating total
        }

        System.out.println("  Total Amount: ₹" + total);
    }
}

// Customer places orders (Association)
class Customer {
    private String customerName; // customer name
    private ArrayList<Order> orders; // associated orders

    public Customer(String customerName) {
        this.customerName = customerName; // initializing customer name
        this.orders = new ArrayList<>(); // initializing order list
    }

    // communication between customer and order
    public void placeOrder(Order order) {
        orders.add(order); // associating order with customer
        System.out.println(customerName + " placed an order.");
    }

    public void viewOrders() {
        System.out.println("Orders placed by " + customerName + ":");
        for (Order o : orders) {
            o.showOrderDetails(); // displaying order details
        }
    }
}

// Main class
public class EcommerceOrderCustomerProductDemo {
    public static void main(String[] args) {

        Customer customer = new Customer("Prajwal"); // creating customer

        Product p1 = new Product("Laptop", 55000); // creating product
        Product p2 = new Product("Mouse", 800); // creating product
        Product p3 = new Product("Keyboard", 1500); // creating product

        Order order1 = new Order(101); // creating order

        order1.addProduct(p1); // adding product to order
        order1.addProduct(p2);
        order1.addProduct(p3);

        customer.placeOrder(order1); // customer places order
        customer.viewOrders(); // viewing customer orders
    }
}
