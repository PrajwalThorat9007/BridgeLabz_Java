package extras;

import java.util.*;

/**
 * Problem 3: Palindrome String Check
 * Write a Java program to check if a given string is a palindrome 
 * (a string that reads the same forward and backward).
 */
public class PalindromeChecker {
    
    /**
     * Check if string is palindrome using two pointers
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Check palindrome ignoring case and spaces
     */
    public static boolean isPalindromeIgnoreCaseAndSpaces(String str) {
        if (str == null) {
            return true;
        }
        
        // Remove spaces and convert to lowercase
        str = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindrome(str);
    }
    
    /**
     * Check palindrome with only alphanumeric characters
     */
    public static boolean isPalindromeAlphanumeric(String str) {
        if (str == null) {
            return true;
        }
        
        // Keep only alphanumeric characters and convert to lowercase
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindrome(str);
    }
    
    /**
     * Check palindrome using recursion
     */
    public static boolean isPalindromeRecursive(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        
        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }
    
    /**
     * Check palindrome by reversing
     */
    public static boolean isPalindromeByReversing(String str) {
        if (str == null) {
            return true;
        }
        
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    /**
     * Find all palindromic substrings
     */
    public static List<String> findAllPalindromicSubstrings(String str) {
        List<String> palindromes = new ArrayList<>();
        
        if (str == null || str.isEmpty()) {
            return palindromes;
        }
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (substring.length() > 1 && isPalindrome(substring)) {
                    palindromes.add(substring);
                }
            }
        }
        
        return palindromes;
    }
    
    /**
     * Find longest palindromic substring
     */
    public static String findLongestPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        
        String longest = "";
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        
        return longest;
    }
    
    /**
     * Visualize palindrome check
     */
    public static void visualizePalindromeCheck(String str) {
        System.out.println("\nPalindrome Check Visualization:");
        System.out.println("─".repeat(60));
        System.out.println("String: " + str);
        
        if (str == null || str.isEmpty()) {
            System.out.println("Empty or null string - considered palindrome");
            return;
        }
        
        int left = 0;
        int right = str.length() - 1;
        int step = 1;
        boolean isPalin = true;
        
        while (left < right) {
            System.out.printf("\nStep %d: Compare positions %d and %d%n", step, left, right);
            System.out.print("        ");
            
            for (int i = 0; i < str.length(); i++) {
                if (i == left || i == right) {
                    System.out.print("[" + str.charAt(i) + "]");
                } else {
                    System.out.print(" " + str.charAt(i) + " ");
                }
            }
            
            System.out.printf("  →  '%c' %s '%c'%n", 
                            str.charAt(left), 
                            str.charAt(left) == str.charAt(right) ? "==" : "!=",
                            str.charAt(right));
            
            if (str.charAt(left) != str.charAt(right)) {
                System.out.println("        ✗ Mismatch found! Not a palindrome.");
                isPalin = false;
                break;
            }
            
            left++;
            right--;
            step++;
        }
        
        if (isPalin) {
            System.out.println("\n        ✓ All characters match! It's a palindrome.");
        }
        
        System.out.println("─".repeat(60));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(17) + "PALINDROME CHECKER" + " ".repeat(23) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Basic palindromes
        System.out.println("\n--- Test Case 1: Basic Palindrome Check ---");
        String[] testCases = {
            "madam",
            "racecar",
            "hello",
            "level",
            "noon",
            "java",
            "a",
            ""
        };
        
        System.out.println("┌─────────────────────┬────────────────┐");
        System.out.println("│       String        │   Palindrome?  │");
        System.out.println("├─────────────────────┼────────────────┤");
        
        for (String test : testCases) {
            boolean result = isPalindrome(test);
            System.out.printf("│ %-19s │      %s       │%n", 
                            test.isEmpty() ? "(empty)" : test, 
                            result ? "✓" : "✗");
        }
        
        System.out.println("└─────────────────────┴────────────────┘");
        
        // Test Case 2: Case-insensitive check
        System.out.println("\n\n--- Test Case 2: Case-Insensitive Check ---");
        String[] caseTests = {
            "Madam",
            "RaceCar",
            "A man a plan a canal Panama"
        };
        
        for (String test : caseTests) {
            System.out.println("\nString: \"" + test + "\"");
            System.out.println("  Case-sensitive:   " + (isPalindrome(test) ? "✓" : "✗"));
            System.out.println("  Ignore case/space: " + (isPalindromeIgnoreCaseAndSpaces(test) ? "✓" : "✗"));
        }
        
        // Test Case 3: Alphanumeric check
        System.out.println("\n\n--- Test Case 3: Alphanumeric Palindrome ---");
        String[] alphaTests = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?"
        };
        
        for (String test : alphaTests) {
            System.out.println("\nString: \"" + test + "\"");
            System.out.println("  Alphanumeric only: " + 
                             (isPalindromeAlphanumeric(test) ? "✓ Palindrome" : "✗ Not palindrome"));
        }
        
        // Test Case 4: Visualization
        System.out.println("\n\n--- Test Case 4: Visualization ---");
        visualizePalindromeCheck("radar");
        visualizePalindromeCheck("hello");
        
        // Test Case 5: Find palindromic substrings
        System.out.println("\n\n--- Test Case 5: Palindromic Substrings ---");
        String text = "abracadabra";
        System.out.println("String: " + text);
        
        List<String> palindromes = findAllPalindromicSubstrings(text);
        System.out.println("\nAll palindromic substrings:");
        System.out.println(palindromes);
        
        String longest = findLongestPalindrome(text);
        System.out.println("\nLongest palindromic substring: " + longest);
        
        // Test Case 6: Different methods comparison
        System.out.println("\n\n--- Test Case 6: Method Comparison ---");
        String compareStr = "racecar";
        System.out.println("String: " + compareStr);
        System.out.println("\nMethod 1 (Two Pointers): " + isPalindrome(compareStr));
        System.out.println("Method 2 (Recursive):    " + isPalindromeRecursive(compareStr));
        System.out.println("Method 3 (Reversing):    " + isPalindromeByReversing(compareStr));
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        String longPalindrome = "a".repeat(5000) + "b" + "a".repeat(5000);
        
        long start = System.nanoTime();
        isPalindrome(longPalindrome);
        long twoPointerTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        isPalindromeByReversing(longPalindrome);
        long reverseTime = System.nanoTime() - start;
        
        System.out.println("String length: " + longPalindrome.length());
        System.out.printf("Two Pointer method: %.3f ms%n", twoPointerTime / 1_000_000.0);
        System.out.printf("Reversing method:   %.3f ms%n", reverseTime / 1_000_000.0);
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.print("Enter a string to check (or 'exit' to quit): ");
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("\nString: \"" + input + "\"");
            System.out.println("Palindrome (exact):       " + isPalindrome(input));
            System.out.println("Palindrome (ignore case): " + isPalindromeIgnoreCaseAndSpaces(input));
            System.out.println("Palindrome (alphanumeric): " + isPalindromeAlphanumeric(input));
            
            visualizePalindromeCheck(input);
            
            System.out.print("\nEnter another string (or 'exit' to quit): ");
            input = scanner.nextLine();
        }
        
        scanner.close();
    }
}
