/*
Create a program to calculate the profit and loss in number and percentage based on the cost price of INR 129 and the selling price of INR 191. 
Hint => 
Use a single print statement to display multiline text and variables.
Profit = selling price - cost price
Profit Percentage = profit / cost price * 100
I/P => NONE
O/P => 
The Cost Price is INR ___ and Selling Price is INR ___
The Profit is INR ___ and the Profit Percentage is ___
*/
class ProfitPercentage {
    public static void main(String[] args) {

        // Cost price of the item
        int costPrice = 129;

        // Selling price of the item
        int sellPrice = 191;

        // Calculate profit
        int profit = sellPrice - costPrice;
        
        // Calculate profit percentage
        int profitPercent = (profit * 100) / costPrice;

        // Display cost price and selling price
        System.out.println(
            "The Cost Price is INR " + costPrice +
            " and Selling Price is INR " + sellPrice
        );

        // Display profit and profit percentage
        System.out.println(
            "The Profit is INR " + profit +
            "and the Profit Percentage is " + profitPercent
        );
    }
}
