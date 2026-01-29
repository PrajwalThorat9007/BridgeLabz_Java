class Book{
    private String title;
    private String author;
    private int price;
    
    public void setData(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    
    public void getData(){
        System.out.println("Title is "+title+" author is "+author+" price is "+price);
    }
    
    public static void main(String[] args){
        Book bk1=new Book();
        bk1.setData("Wings","DaVinci",225);
        bk1.getData();
    }
}