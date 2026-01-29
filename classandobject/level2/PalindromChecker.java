/*
Program to Check Palindrome String
Problem Statement: 	Create a PalindromeChecker class with an attribute text. Add methods to:
Check if the text is a palindrome.
Display the result.
Explanation: The PalindromeChecker class holds the text attribute. The methods operate on this attribute to verify its palindrome status and display the result.
 */
import java.util.Scanner;
class PalindromeChecker{
    static String text;
    
    static void palindrome(String text){
        int right=text.length()-1;
        int left=0;
        boolean pal=true;
        while(left<right){
            if(text.charAt(left)!=text.charAt(right)){
                pal=false;
                break;
            }
            left++;
            right--;
        }
        if(pal){
            System.out.println("String is Palindrome");
        }
        else{
            System.out.println("String is not Palindrome");
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter your string: ");
        text=sc.next();
        
        palindrome(text);
        
    }
}