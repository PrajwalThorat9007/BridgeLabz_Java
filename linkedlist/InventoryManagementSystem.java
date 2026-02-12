/*
Problem Statement:
Design an inventory management system using a singly linked list
where each node stores information about an item such as
Item Name, Item ID, Quantity, and Price.

Implement the following functionalities:
1. Add an item at the beginning, end, or at a specific position.
2. Remove an item based on Item ID.
3. Update the quantity of an item by Item ID.
4. Search for an item based on Item ID or Item Name.
5. Calculate and display the total value of inventory
   (Sum of Price * Quantity for each item).
6. Sort the inventory based on Item Name or Price
   in ascending or descending order.
*/
package linkedlist;

class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    Item head;

    // Add at beginning
    void addAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    void addAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add at specific position (1-based)
    void addAtPosition(int position, int itemId, String itemName, int quantity, double price) {
        if (position == 1) {
            addAtBeginning(itemId, itemName, quantity, price);
            return;
        }

        Item newItem = new Item(itemId, itemName, quantity, price);
        Item temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove item by ID
    void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    // Update quantity by ID
    void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by Item ID
    void searchByItemId(int itemId) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == itemId) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by Item Name
    void searchByItemName(String itemName) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    // Calculate total inventory value
    void calculateTotalValue() {
        Item temp = head;
        double totalValue = 0;

        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort by Item Name (ascending or descending)
    void sortByItemName(boolean ascending) {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }

    // Sort by Price (ascending or descending)
    void sortByPrice(boolean ascending) {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }

    // Swap item data
    void swapData(Item a, Item b) {
        int tempId = a.itemId;
        String tempName = a.itemName;
        int tempQty = a.quantity;
        double tempPrice = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = tempId;
        b.itemName = tempName;
        b.quantity = tempQty;
        b.price = tempPrice;
    }

    // Display all items
    void displayAll() {
        Item temp = head;

        if (temp == null) {
            System.out.println("No items in inventory");
            return;
        }

        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    void printItem(Item item) {
        System.out.println(
            "ID: " + item.itemId +
            ", Name: " + item.itemName +
            ", Quantity: " + item.quantity +
            ", Price: " + item.price
        );
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtBeginning(1, "Laptop", 5, 50000);
        inventory.addAtEnd(2, "Mouse", 20, 500);
        inventory.addAtPosition(2, 3, "Keyboard", 10, 1500);

        System.out.println("Inventory Items:");
        inventory.displayAll();

        System.out.println("\nSearch by Item ID:");
        inventory.searchByItemId(2);

        System.out.println("\nUpdate Quantity:");
        inventory.updateQuantity(3, 15);

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSort by Price (Ascending):");
        inventory.sortByPrice(true);
        inventory.displayAll();
    }
}
