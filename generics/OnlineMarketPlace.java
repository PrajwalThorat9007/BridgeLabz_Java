package generics;

import java.util.ArrayList;
import java.util.List;

interface Category{
    String getCategoryName();
}
class BookCategory implements Category{
    private String genre;
    public BookCategory(String genre){
        this.genre=genre;
    }
    public String getCategoryName(){
        return "Book: "+genre;
    }
}
class ClothingCategory implements Category{
    private String type;

    public ClothingCategory(String type){
        this.type=type;
    }
    public String getCategoryName(){
        return "Clothing: "+type;
    }
}
class Product<T extends Category>{
    private String name;
    private double price;
    private T category;

    public Product(String name,double price,T category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public String getDetails(){
        return "Name: " + name +
                ", Price: " + price +
                ", Category: " + category.getCategoryName();
    }
}
class DiscountService{
    public static <T extends Product<?>>
    void applyDiscount(T product,double percentage){
        double newPrice=product.getPrice()-(product.getPrice()*percentage/100);
        product.setPrice(newPrice);
    }
}
class Marketplace{
    private List<Product<?>> catalog=new ArrayList<>();
    public void addProduct(Product<?> product){
        catalog.add(product);
    }

    public void displayProducts(){
        for(Product<?> product: catalog){
            System.out.println(product.getDetails());
        }
    }

}

public class OnlineMarketPlace {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 500,
                        new BookCategory("Education"));

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1200,
                        new ClothingCategory("Men"));


        Marketplace marketplace = new Marketplace();

        marketplace.addProduct(book);
        marketplace.addProduct(shirt);


        // Apply discount
        DiscountService.applyDiscount(book, 10);

        marketplace.displayProducts();
    }
}
