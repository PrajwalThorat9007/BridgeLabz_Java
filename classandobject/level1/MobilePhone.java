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