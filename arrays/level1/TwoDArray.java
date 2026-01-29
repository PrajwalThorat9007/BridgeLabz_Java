/*
Working with Multi-Dimensional Arrays. Write a Java program to create a 2D Array and Copy the 2D Array into a single dimension array
Hint => 
Take user input for rows and columns, create a 2D array (Matrix), and take the user input 
Copy the elements of the matrix to a 1D array. For this create a 1D array of size rows*columns as in int[] array = new int[rows * columns];
Define the index variable and Loop through the 2D array. Copy every element of the 2D array into the 1D array and increment the index
Note: For looping through the 2D array, you will need Nested for loop, Outer for loop for rows, and the inner for loops to access each element
*/
import java.util.Scanner;

class TwoDArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int row=sc.nextInt();
        int col=sc.nextInt();
        
        int[][] arr2D=new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr2D[i][j]=sc.nextInt();
            }
        }
        int[] arr=new int[row*col];
        int index=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[index]=arr2D[i][j];
                index++;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
