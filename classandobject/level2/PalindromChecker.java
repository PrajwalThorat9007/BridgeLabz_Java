/*
Program to Check Palindrome String
Problem Statement: 	Create a PalindromeChecker class with an attribute text. Add methods to:
Check if the text is a palindrome.
Display the result.
Explanation: The PalindromeChecker class holds the text attribute. The methods operate on this attribute to verify its palindrome status and display the result.
 */
import java.util.Scanner;

class PalindromeChecker {

    // Static variable to store input text
    static String text;
    
    // Method to check whether a string is a palindrome
    static void palindrome(String text){
        int right = text.length() - 1;
        int left = 0;
        boolean pal = true;

        // Compare characters from both ends
        while(left < right){
            if(text.charAt(left) != text.charAt(right)){
                pal = false;
                break;
            }
            left++;
            right--;
        }

        // Display result
        if(pal){
            System.out.println("String is Palindrome");
        }
        else{
            System.out.println("String is not Palindrome");
        }
    }
    
    public static void main(String[] args){

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read input string
        System.out.println("Enter your string: ");
        text = sc.next();
        
        // Check palindrome
        palindrome(text);
    }
}
