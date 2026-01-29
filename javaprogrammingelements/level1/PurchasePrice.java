/*
Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.
Hint => NA
I/P => unitPrice, quantity
O/P => The total purchase price is INR ___ if the quantity ___ and unit price is INR ___
*/


import java.util.Scanner;

class puchasePrice{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int unitPrice=sc.nextInt();
        int quantity=sc.nextInt();
        
        int total=unitPrice*quantity;
        System.out.printf("The total purchase price is INR %d if the quantity %d and unit price is INR %d",total,quantity,unitPrice);
        }
}