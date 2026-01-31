/*
Description: Create a multilevel hierarchy to manage orders, where Order is the base class, ShippedOrder is a subclass, and DeliveredOrder extends ShippedOrder.
Tasks:
Define a base class Order with common attributes like orderId and orderDate.
Create a subclass ShippedOrder with additional attributes like trackingNumber.
Create another subclass DeliveredOrder extending ShippedOrder, adding a deliveryDate attribute.
Implement a method getOrderStatus() to return the current order status based on the class level.
Goal: Explore multilevel inheritance, showing how attributes and methods can be added across a chain of classes.
 */
// Base class
class Order {
    int orderId; // order id
    String orderDate; // order date

    Order(int orderId, String orderDate) {
        this.orderId = orderId; // initializing order id
        this.orderDate = orderDate; // initializing order date
    }

    // method to return order status
    String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass extending Order
class ShippedOrder extends Order {
    String trackingNumber; // shipment tracking number

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate); // calling base class constructor
        this.trackingNumber = trackingNumber; // initializing tracking number
    }

    // overriding order status
    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

// Subclass extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate; // delivery date

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber); // calling parent constructor
        this.deliveryDate = deliveryDate; // initializing delivery date
    }

    // overriding order status
    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

// Main class
public class OrderMultilevelInheritanceDemo {
    public static void main(String[] args) {

        Order order1 = new Order(101, "2026-01-10"); // base order
        Order order2 = new ShippedOrder(102, "2026-01-11", "TRK123"); // shipped order
        Order order3 = new DeliveredOrder(103, "2026-01-12", "TRK456", "2026-01-15"); // delivered order

        System.out.println("Order 1 Status: " + order1.getOrderStatus());
        System.out.println("Order 2 Status: " + order2.getOrderStatus());
        System.out.println("Order 3 Status: " + order3.getOrderStatus());
    }
}
