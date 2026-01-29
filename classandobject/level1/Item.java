class Item{
    private int itemCode;
    private String itemName;
    private int price;
    
    public void setData(int itemCode,String itemName,int price){
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.price=price;
    }
    
    public void getData(){
        System.out.println("itemCode is "+itemCode+" itemName is "+itemName+" and price is "+price);
    }
    
    public void cost(int quantity){
        System.out.println("Total cost is "+this.price*quantity);
    }
    
    public static void main(String[] args){
        Item obj1=new Item();
        obj1.setData(235,"Kurkure",10);
    
        obj1.getData();
    
        obj1.cost(5);
    }
}