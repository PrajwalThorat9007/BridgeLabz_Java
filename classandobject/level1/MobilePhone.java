/*
Program to Handle Mobile Phone Details
Problem Statement: Create a MobilePhone class with attributes brand, model, and price. Add a method to display all the details of the phone. The MobilePhone class uses attributes to store the phone's characteristics. The method is used to retrieve and display this information for each object.
 */
class MobilePhone{
    private String brand;
    private String model;
    private int price;
    
    public void setData(String brand,String model,int price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }
    public void getData(){
        System.out.println("Brand Name: "+brand);
        System.out.println("Model Name: "+model);
        System.out.println("Price is: "+price);
    }
    
    public static void main(String[] args){
      MobilePhone ph1=new MobilePhone();
      ph1.setData("iPhone","14 pro max",100000);
    
        ph1.getData();  
    }
    
}