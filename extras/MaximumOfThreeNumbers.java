package extras;

import java.util.*;

/**
 * Problem 2: Maximum of Three Numbers
 * Find the maximum of three integer inputs using modular functions
 */
public class MaximumOfThreeNumbers {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Take integer input from user with validation
     */
    public static int takeIntegerInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
    
    /**
     * Take three integer inputs from user
     */
    public static int[] takeThreeInputs() {
        System.out.println("\nEnter three numbers:");
        int num1 = takeIntegerInput("  Number 1: ");
        int num2 = takeIntegerInput("  Number 2: ");
        int num3 = takeIntegerInput("  Number 3: ");
        
        return new int[]{num1, num2, num3};
    }
    
    /**
     * Find maximum of three numbers using if-else
     */
    public static int findMaximumUsingIfElse(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }
    
    /**
     * Find maximum of three numbers using Math.max
     */
    public static int findMaximumUsingMathMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
    
    /**
     * Find maximum of three numbers using ternary operator
     */
    public static int findMaximumUsingTernary(int num1, int num2, int num3) {
        return (num1 >= num2) ? ((num1 >= num3) ? num1 : num3) : ((num2 >= num3) ? num2 : num3);
    }
    
    /**
     * Find maximum of three numbers using array approach
     */
    public static int findMaximumUsingArray(int num1, int num2, int num3) {
        int[] numbers = {num1, num2, num3};
        int max = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        return max;
    }
    
    /**
     * Find maximum using Arrays.stream (Java 8+)
     */
    public static int findMaximumUsingStream(int num1, int num2, int num3) {
        return Arrays.stream(new int[]{num1, num2, num3}).max().getAsInt();
    }
    
    /**
     * Display the result with detailed information
     */
    public static void displayResult(int num1, int num2, int num3, int maximum) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("RESULT");
        System.out.println("═".repeat(70));
        
        System.out.println("\nInput Numbers:");
        System.out.println("  Number 1: " + num1);
        System.out.println("  Number 2: " + num2);
        System.out.println("  Number 3: " + num3);
        
        System.out.println("\n✓ Maximum: " + maximum);
        
        // Find minimum for comparison
        int minimum = Math.min(num1, Math.min(num2, num3));
        int middle = num1 + num2 + num3 - maximum - minimum;
        
        System.out.println("\nAdditional Information:");
        System.out.println("  Minimum: " + minimum);
        System.out.println("  Middle:  " + middle);
        System.out.println("  Sum:     " + (num1 + num2 + num3));
        System.out.println("  Average: " + String.format("%.2f", (num1 + num2 + num3) / 3.0));
        System.out.println("  Range:   " + (maximum - minimum));
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Display visual comparison
     */
    public static void displayVisualComparison(int num1, int num2, int num3) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("VISUAL COMPARISON");
        System.out.println("═".repeat(70));
        
        int max = Math.max(num1, Math.max(num2, num3));
        int scale = max > 0 ? Math.max(1, max / 40) : 1;
        
        System.out.println("\nNumber 1 (" + num1 + "): " + "█".repeat(Math.abs(num1) / scale));
        System.out.println("Number 2 (" + num2 + "): " + "█".repeat(Math.abs(num2) / scale));
        System.out.println("Number 3 (" + num3 + "): " + "█".repeat(Math.abs(num3) / scale));
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Compare all methods
     */
    public static void compareAllMethods(int num1, int num2, int num3) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("COMPARING DIFFERENT METHODS");
        System.out.println("═".repeat(70));
        
        System.out.println("\nInput: " + num1 + ", " + num2 + ", " + num3);
        System.out.println();
        
        System.out.println("┌──────────────────────────┬──────────┐");
        System.out.println("│         Method           │  Result  │");
        System.out.println("├──────────────────────────┼──────────┤");
        
        int result1 = findMaximumUsingIfElse(num1, num2, num3);
        System.out.printf("│ If-Else                  │   %4d   │%n", result1);
        
        int result2 = findMaximumUsingMathMax(num1, num2, num3);
        System.out.printf("│ Math.max                 │   %4d   │%n", result2);
        
        int result3 = findMaximumUsingTernary(num1, num2, num3);
        System.out.printf("│ Ternary Operator         │   %4d   │%n", result3);
        
        int result4 = findMaximumUsingArray(num1, num2, num3);
        System.out.printf("│ Array Approach           │   %4d   │%n", result4);
        
        int result5 = findMaximumUsingStream(num1, num2, num3);
        System.out.printf("│ Stream API               │   %4d   │%n", result5);
        
        System.out.println("└──────────────────────────┴──────────┘");
        
        // Verify all methods return same result
        boolean allSame = (result1 == result2 && result2 == result3 && 
                          result3 == result4 && result4 == result5);
        
        System.out.println("\n✓ All methods return the same result: " + allSame);
        System.out.println("═".repeat(70));
    }
    
    /**
     * Find maximum with step-by-step explanation
     */
    public static void findMaximumWithExplanation(int num1, int num2, int num3) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("STEP-BY-STEP EXPLANATION");
        System.out.println("═".repeat(70));
        
        System.out.println("\nNumbers: " + num1 + ", " + num2 + ", " + num3);
        System.out.println("\nComparison Process:");
        
        System.out.println("\nStep 1: Compare " + num1 + " and " + num2);
        int temp = Math.max(num1, num2);
        System.out.println("  → Larger: " + temp);
        
        System.out.println("\nStep 2: Compare " + temp + " and " + num3);
        int maximum = Math.max(temp, num3);
        System.out.println("  → Larger: " + maximum);
        
        System.out.println("\n✓ Maximum: " + maximum);
        System.out.println("═".repeat(70));
    }
    
    /**
     * Performance test
     */
    public static void performanceTest() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("PERFORMANCE TEST");
        System.out.println("═".repeat(70));
        
        Random random = new Random();
        int iterations = 1_000_000;
        
        System.out.println("\nRunning " + iterations + " iterations...\n");
        
        // Generate random numbers
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000);
        int num3 = random.nextInt(1000);
        
        // Test if-else method
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            findMaximumUsingIfElse(num1, num2, num3);
        }
        long ifElseTime = System.nanoTime() - start;
        
        // Test Math.max method
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            findMaximumUsingMathMax(num1, num2, num3);
        }
        long mathMaxTime = System.nanoTime() - start;
        
        // Test ternary method
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            findMaximumUsingTernary(num1, num2, num3);
        }
        long ternaryTime = System.nanoTime() - start;
        
        // Display results
        System.out.println("┌──────────────────────────┬──────────────┐");
        System.out.println("│         Method           │  Time (ms)   │");
        System.out.println("├──────────────────────────┼──────────────┤");
        System.out.printf("│ If-Else                  │    %6.2f    │%n", ifElseTime / 1_000_000.0);
        System.out.printf("│ Math.max                 │    %6.2f    │%n", mathMaxTime / 1_000_000.0);
        System.out.printf("│ Ternary Operator         │    %6.2f    │%n", ternaryTime / 1_000_000.0);
        System.out.println("└──────────────────────────┴──────────────┘");
        
        System.out.println("═".repeat(70));
    }
    
    /**
     * Test with various number combinations
     */
    public static void testVariousCombinations() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("TEST VARIOUS COMBINATIONS");
        System.out.println("═".repeat(70));
        
        int[][] testCases = {
            {5, 10, 3},
            {-5, -10, -3},
            {0, 0, 0},
            {100, 50, 75},
            {1, 2, 3},
            {3, 2, 1},
            {5, 5, 5},
            {Integer.MAX_VALUE, 0, Integer.MIN_VALUE}
        };
        
        System.out.println("\n┌─────────────────────┬────────────────┐");
        System.out.println("│    Input Numbers    │    Maximum     │");
        System.out.println("├─────────────────────┼────────────────┤");
        
        for (int[] test : testCases) {
            int max = findMaximumUsingIfElse(test[0], test[1], test[2]);
            System.out.printf("│ %5d, %5d, %5d │    %10d  │%n", 
                            test[0], test[1], test[2], max);
        }
        
        System.out.println("└─────────────────────┴────────────────┘");
        System.out.println("═".repeat(70));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(19) + "MAXIMUM OF THREE NUMBERS" + " ".repeat(25) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");
        
        while (true) {
            System.out.println("\n" + "═".repeat(70));
            System.out.println("MAIN MENU");
            System.out.println("═".repeat(70));
            System.out.println("\n1. Find Maximum (Interactive)");
            System.out.println("2. Find Maximum with Explanation");
            System.out.println("3. Compare All Methods");
            System.out.println("4. Visual Comparison");
            System.out.println("5. Test Various Combinations");
            System.out.println("6. Performance Test");
            System.out.println("0. Exit");
            
            System.out.print("\nEnter your choice (0-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) {
                System.out.println("\nThank you!");
                scanner.close();
                return;
            }
            
            if (choice >= 1 && choice <= 4) {
                int[] numbers = takeThreeInputs();
                int num1 = numbers[0];
                int num2 = numbers[1];
                int num3 = numbers[2];
                
                switch (choice) {
                    case 1:
                        int maximum = findMaximumUsingIfElse(num1, num2, num3);
                        displayResult(num1, num2, num3, maximum);
                        break;
                        
                    case 2:
                        findMaximumWithExplanation(num1, num2, num3);
                        break;
                        
                    case 3:
                        compareAllMethods(num1, num2, num3);
                        break;
                        
                    case 4:
                        displayVisualComparison(num1, num2, num3);
                        int max = findMaximumUsingIfElse(num1, num2, num3);
                        System.out.println("\n✓ Maximum: " + max);
                        break;
                }
            } else {
                switch (choice) {
                    case 5:
                        testVariousCombinations();
                        break;
                        
                    case 6:
                        performanceTest();
                        break;
                        
                    default:
                        System.out.println("\nInvalid choice! Please enter 0-6.");
                }
            }
        }
    }
}
