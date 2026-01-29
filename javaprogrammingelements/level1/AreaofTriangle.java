/*
Write a program that takes the base and height to find area of a triangle in square inches and square centimeters 
Hint => Area of a Triangle is ½ * base * height
I/P => base, height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
*/
import java.util.Scanner;

class AreaOfTriangle{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int height=sc.nextInt();
        int base=sc.nextInt();
        
        double Area=(height*base)/2.0;
        System.out.println(Area);
    }
}