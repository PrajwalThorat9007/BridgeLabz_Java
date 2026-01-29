/*
Program to Simulate a Shopping Cart
Problem Statement: Create a CartItem class with attributes itemName, price, and quantity. Add methods to:
Add an item to the cart.
Remove an item from the cart.
Display the total cost.
Explanation: The CartItem class models a shopping cart item. The methods handle cart operations like adding or removing items and calculating the total cost.
 */
import java.util.Scanner;

class CartItem{
    static int total=0;
    
    static void Kurkure(int quant){
        total=total+(5*quant);
        System.out.println("Kurkure added");
    }
    
    static void Chips(int quant){
        total=total+(5*quant);
        System.out.println("Chips added");
    }
    
    static void Cadbury(int quant){
        total=total+(10*quant);
        System.out.println("Cadbury added");
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        
        
        while(true){
        System.out.println("Choose item to add in cart");
        System.out.println("1.Kurkure 5Rs");
        System.out.println("2.Chips 5Rs");
        System.out.println("3.Cadbury 10Rs");
        System.out.println("4.Checkout");
        
        int choice=sc.nextInt();
        
        switch(choice){
            case 1:
                System.out.println("How many kurkure you want: ");
                int quant=sc.nextInt();
                Kurkure(quant);
                break;
            case 2:
                System.out.println("How many Chips you want: ");
                int quant1=sc.nextInt();
                Chips(quant1);
                break;
            case 3:
                System.out.println("How many Cadbury you want: ");
                int quant2=sc.nextInt();
                Cadbury(quant2);
                break;
            case 4:
                System.out.println("your total is"+ total);
                total=0;
                break;
        }
        }
    }
}