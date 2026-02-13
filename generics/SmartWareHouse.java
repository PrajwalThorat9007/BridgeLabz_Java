package generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    private String name;
    private double price;

    public WarehouseItem(String name,double price){
        this.name=name;
        this.price=price;
    }

    public String getDetails(){
        return "Name: "+name+", Price: "+price;
    }
}
class Electronics extends WarehouseItem{
    private String brand;

    public Electronics(String name,double price,String brand){
        super(name,price);
        this.brand=brand;
    }

    @Override
    public String getDetails(){
        return super.getDetails()+", Brand: "+brand;
    }
}
class Groceries extends WarehouseItem{
    private String expiryDate;

    public Groceries(String name,double price,String expiryDate){
        super(name,price);
        this.expiryDate=expiryDate;
    }

    @Override
    public String getDetails(){
        return super.getDetails()+" ,Expiry Date: "+expiryDate;
    }
}
class Furniture extends WarehouseItem{
    private String materials;

    public Furniture(String name,double price,String materials){
        super(name,price);
        this.materials=materials;
    }

    @Override
    public String getDetails(){
        return super.getDetails()+" ,materials: "+materials;
    }
}
class Storage<T extends WarehouseItem>{
    private List<T> items=new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }
    public List<T> getItems(){
        return items;
    }
}
class WarehouseUtils{
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item:items){
            System.out.println(item.getDetails());
        }
    }
}


public class SmartWareHouse {
    public static void main(String[] args) {

        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop", 80000, "Dell"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Milk", 50, "10-02-2026"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 2000, "Wood"));

        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
