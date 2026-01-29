/*Write a program to find the smallest and the largest of the 3 numbers.
Hint => 
Take user input for 3 numbers
Write a single method to find the smallest and largest of the three numbers
public static int[] findSmallestAndLargest(int number1, int number2, int number3)
 */
import java.util.Scanner;

class SmallestLargest{
    public static int[] findSmallestAndLargest(int number1,int number2,int number3){
        int smallest=number1;
        int largest=number1;
        
        if(number2<smallest){
            smallest=number2;
        }
        if(number3<smallest){
            smallest=number3;
        }
        if(number2>largest){
            largest=number2;
        }
        if(number3>largest){
            largest=number3;
        }
        return new int[] {smallest,largest};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        
        int[] result=findSmallestAndLargest(num1,num2,num3);
        
        System.out.println("Smallest number is "+ result[0]);
        System.out.println("Largest number is "+ result[1]);
    }
}