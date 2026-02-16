package stackandqueue;

import java.util.*;

/**
 * Problem 3: Stock Span Problem
 * For each day in a stock price array, calculate the span 
 * (number of consecutive days the price was less than or equal to the current day's price).
 */
public class StockSpanProblem {
    
    /**
     * Calculate span for each day using stack
     * Time Complexity: O(n) where n is number of days
     * Space Complexity: O(n) for stack
     * 
     * @param prices Array of stock prices for each day
     * @return Array of spans for each day
     */
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices
        
        for (int i = 0; i < n; i++) {
            // Pop elements while stack is not empty and 
            // current price is greater than or equal to stack top price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // If stack is empty, span is i+1 (all previous days)
            // Otherwise, span is difference between current index and stack top
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            
            // Push current index to stack
            stack.push(i);
        }
        
        return span;
    }
    
    /**
     * Calculate span using brute force approach (for comparison)
     * Time Complexity: O(n^2)
     */
    public static int[] calculateSpanBruteForce(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        
        for (int i = 0; i < n; i++) {
            span[i] = 1; // Current day is always included
            
            // Count consecutive previous days with price <= current price
            for (int j = i - 1; j >= 0 && prices[j] <= prices[i]; j--) {
                span[i]++;
            }
        }
        
        return span;
    }
    
    /**
     * Display stock prices and their spans in tabular format
     */
    public static void displaySpan(int[] prices, int[] span) {
        System.out.println("\n┌──────┬────────┬───────┐");
        System.out.println("│ Day  │ Price  │ Span  │");
        System.out.println("├──────┼────────┼───────┤");
        
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("│  %-3d │  %-5d │  %-4d │%n", (i + 1), prices[i], span[i]);
        }
        
        System.out.println("└──────┴────────┴───────┘");
    }
    
    /**
     * Display detailed explanation for each day
     */
    public static void displayDetailedExplanation(int[] prices, int[] span) {
        System.out.println("\nDetailed Explanation:");
        System.out.println("─".repeat(60));
        
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Day " + (i + 1) + " (Price: " + prices[i] + "):");
            System.out.print("  Span = " + span[i] + " → ");
            
            if (span[i] == 1) {
                System.out.println("Only current day (previous price was higher)");
            } else if (i - span[i] + 1 == 0) {
                System.out.println("All days from start (highest price so far)");
            } else {
                System.out.print("Days " + (i - span[i] + 2) + " to " + (i + 1));
                System.out.print(" (prices: ");
                for (int j = i - span[i] + 1; j <= i; j++) {
                    System.out.print(prices[j]);
                    if (j < i) System.out.print(", ");
                }
                System.out.println(")");
            }
        }
        System.out.println("─".repeat(60));
    }
    
    /**
     * Visualize price trend with spans
     */
    public static void visualizePriceTrend(int[] prices, int[] span) {
        System.out.println("\nPrice Trend Visualization:");
        System.out.println("─".repeat(60));
        
        int maxPrice = Arrays.stream(prices).max().getAsInt();
        int scale = Math.max(1, maxPrice / 20);
        
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("Day %2d [%3d] ", (i + 1), prices[i]);
            int bars = prices[i] / scale;
            for (int j = 0; j < bars; j++) {
                System.out.print("█");
            }
            System.out.println(" (Span: " + span[i] + ")");
        }
        System.out.println("─".repeat(60));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(18) + "STOCK SPAN PROBLEM" + " ".repeat(22) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Standard example
        System.out.println("\n--- Test Case 1: Standard Example ---");
        int[] prices1 = {100, 80, 60, 70, 60, 75, 85};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices1));
        
        int[] span1 = calculateSpan(prices1);
        displaySpan(prices1, span1);
        displayDetailedExplanation(prices1, span1);
        
        // Test Case 2: Increasing prices
        System.out.println("\n\n--- Test Case 2: Increasing Prices ---");
        int[] prices2 = {10, 20, 30, 40, 50};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices2));
        
        int[] span2 = calculateSpan(prices2);
        displaySpan(prices2, span2);
        System.out.println("Note: Each day has maximum span as prices are increasing!");
        
        // Test Case 3: Decreasing prices
        System.out.println("\n\n--- Test Case 3: Decreasing Prices ---");
        int[] prices3 = {50, 40, 30, 20, 10};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices3));
        
        int[] span3 = calculateSpan(prices3);
        displaySpan(prices3, span3);
        System.out.println("Note: Each day has span of 1 as prices are decreasing!");
        
        // Test Case 4: All same prices
        System.out.println("\n\n--- Test Case 4: All Same Prices ---");
        int[] prices4 = {50, 50, 50, 50, 50};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices4));
        
        int[] span4 = calculateSpan(prices4);
        displaySpan(prices4, span4);
        System.out.println("Note: Span increases each day as all prices are equal!");
        
        // Test Case 5: Complex pattern
        System.out.println("\n\n--- Test Case 5: Complex Pattern ---");
        int[] prices5 = {31, 27, 14, 21, 30, 22, 35, 44};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices5));
        
        int[] span5 = calculateSpan(prices5);
        displaySpan(prices5, span5);
        visualizePriceTrend(prices5, span5);
        
        // Test Case 6: Single day
        System.out.println("\n\n--- Test Case 6: Single Day ---");
        int[] prices6 = {100};
        System.out.print("Stock Prices: ");
        System.out.println(Arrays.toString(prices6));
        
        int[] span6 = calculateSpan(prices6);
        displaySpan(prices6, span6);
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largePrices = new int[10000];
        Random rand = new Random(42);
        for (int i = 0; i < largePrices.length; i++) {
            largePrices[i] = rand.nextInt(1000) + 1;
        }
        
        long startTime = System.nanoTime();
        int[] spanOptimized = calculateSpan(largePrices);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int[] spanBrute = calculateSpanBruteForce(largePrices);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largePrices.length + " elements");
        System.out.printf("Optimized approach (Stack): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute force approach: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
    }
}
