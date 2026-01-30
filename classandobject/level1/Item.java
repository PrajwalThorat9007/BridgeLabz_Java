/*
Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, itemName, and price. Add a method to display item details and calculate the total cost for a given quantity.
 */
// Class representing an Item
class Item {

    // Private data members to ensure encapsulation
    private int itemCode;
    private String itemName;
    private int price;
    
    // Method to set item details
    public void setData(int itemCode, String itemName, int price){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    
    // Method to display item details
    public void getData(){
        System.out.println("itemCode is " + itemCode + " itemName is " + itemName + " and price is " + price);
    }
    
    // Method to calculate and display total cost based on quantity
    public void cost(int quantity){
        System.out.println("Total cost is " + this.price * quantity);
    }
    
    public static void main(String[] args){

        // Create Item object
        Item obj1 = new Item();

        // Set item data
        obj1.setData(235, "Kurkure", 10);
    
        // Display item data
        obj1.getData();
    
        // Calculate total cost for given quantity
        obj1.cost(5);
    }
}
