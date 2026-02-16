package extras;

import java.util.*;

/**
 * Problem 2: Reverse a String
 * Write a Java program to reverse a given string without using any built-in reverse functions.
 */
public class StringReverser {
    
    /**
     * Reverse string using character array
     */
    public static String reverseUsingArray(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    /**
     * Reverse string using StringBuilder (manual append)
     */
    public static String reverseUsingStringBuilder(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        StringBuilder reversed = new StringBuilder();
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        
        return reversed.toString();
    }
    
    /**
     * Reverse string using recursion
     */
    public static String reverseUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Reverse string using stack
     */
    public static String reverseUsingStack(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Push all characters to stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop all characters and build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
    
    /**
     * Reverse words in a string (keep word order, reverse each word)
     */
    public static String reverseEachWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(reverseUsingArray(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * Reverse word order in a string
     */
    public static String reverseWordOrder(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * Visualize the reversal process
     */
    public static void visualizeReversal(String str) {
        System.out.println("\nReversal Process Visualization:");
        System.out.println("─".repeat(60));
        System.out.println("Original: " + str);
        
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        int step = 1;
        
        while (left < right) {
            System.out.printf("\nStep %d: Swap positions %d and %d%n", step, left, right);
            System.out.print("        ");
            
            for (int i = 0; i < chars.length; i++) {
                if (i == left || i == right) {
                    System.out.print("[" + chars[i] + "]");
                } else {
                    System.out.print(" " + chars[i] + " ");
                }
            }
            System.out.println();
            
            // Swap
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            System.out.print("        ");
            for (int i = 0; i < chars.length; i++) {
                if (i == left || i == right) {
                    System.out.print("[" + chars[i] + "]");
                } else {
                    System.out.print(" " + chars[i] + " ");
                }
            }
            System.out.println();
            
            left++;
            right--;
            step++;
        }
        
        System.out.println("\nReversed: " + new String(chars));
        System.out.println("─".repeat(60));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(19) + "STRING REVERSER" + " ".repeat(24) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        String[] testCases = {
            "Hello",
            "Java Programming",
            "A",
            "",
            "Madam",
            "12345"
        };
        
        System.out.println("\n--- Test Case 1: Different Reversal Methods ---");
        String test = "Hello World";
        System.out.println("Original: " + test);
        System.out.println("\nMethod 1 (Array):        " + reverseUsingArray(test));
        System.out.println("Method 2 (StringBuilder): " + reverseUsingStringBuilder(test));
        System.out.println("Method 3 (Recursion):    " + reverseUsingRecursion(test));
        System.out.println("Method 4 (Stack):        " + reverseUsingStack(test));
        
        System.out.println("\n\n--- Test Case 2: All Test Strings ---");
        System.out.println("┌────────────────────────┬────────────────────────┐");
        System.out.println("│       Original         │       Reversed         │");
        System.out.println("├────────────────────────┼────────────────────────┤");
        
        for (String str : testCases) {
            String reversed = reverseUsingArray(str);
            System.out.printf("│ %-22s │ %-22s │%n", 
                            str.isEmpty() ? "(empty)" : str, 
                            reversed.isEmpty() ? "(empty)" : reversed);
        }
        
        System.out.println("└────────────────────────┴────────────────────────┘");
        
        System.out.println("\n\n--- Test Case 3: Visualization ---");
        visualizeReversal("JAVA");
        
        System.out.println("\n\n--- Test Case 4: Special Reversals ---");
        String sentence = "Hello World from Java";
        System.out.println("Original sentence: " + sentence);
        System.out.println("Reversed:          " + reverseUsingArray(sentence));
        System.out.println("Each word reversed: " + reverseEachWord(sentence));
        System.out.println("Word order reversed: " + reverseWordOrder(sentence));
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        String longString = "a".repeat(10000);
        
        long start = System.nanoTime();
        reverseUsingArray(longString);
        long arrayTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        reverseUsingStringBuilder(longString);
        long sbTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        reverseUsingStack(longString);
        long stackTime = System.nanoTime() - start;
        
        System.out.println("String length: " + longString.length());
        System.out.printf("Array method:        %.3f ms%n", arrayTime / 1_000_000.0);
        System.out.printf("StringBuilder method: %.3f ms%n", sbTime / 1_000_000.0);
        System.out.printf("Stack method:        %.3f ms%n", stackTime / 1_000_000.0);
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.print("Enter a string to reverse (or 'exit' to quit): ");
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + reverseUsingArray(input));
            visualizeReversal(input);
            
            System.out.print("\nEnter another string (or 'exit' to quit): ");
            input = scanner.nextLine();
        }
        
        scanner.close();
    }
}
