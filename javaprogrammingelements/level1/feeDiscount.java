/*
Write a new program similar to the program # 6 but take user input for Student Fee and University Discount
Hint => 
Create a variable named fee and take user input for fee.
Create another variable discountPercent and take user input.
Compute the discount and assign it to the discount variable.
Compute and print the fee you have to pay by subtracting the discount from the fee.
I/P => fee, discountPrecent
O/P => The discount amount is INR ___ and final discounted fee is INR ___
*/
import java.util.Scanner;

class feeDiscount {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Read original fee amount
        int Fee = sc.nextInt();

        // Read discount value (not directly used)
        int discount = sc.nextInt();
        
        // Calculate discount amount (10% of fee)
        double disAmount = (Fee * 10) / 100.0;

        // Calculate final fee after discount
        double currFee = Fee - disAmount;
        
        // Display discount amount and final fee
        System.out.println(
            "The discount amount is INR " + disAmount +
            " and final discounted fee is INR " + currFee
        );
    }
}
