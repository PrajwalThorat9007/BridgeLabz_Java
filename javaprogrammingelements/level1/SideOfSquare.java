/*
Write a program to find the side of the square whose parameter you read from user 
Hint => Perimeter of Square is 4 times side
I/P => perimeter
O/P => The length of the side is ___ whose perimeter is ____
*/
import java.util.Scanner;

class SideOfSquare{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int parameter=sc.nextInt();
        
        int side=parameter/4;
        System.out.printf("The length of the side is %d whose perimeter is %d",side,parameter);
    }
}