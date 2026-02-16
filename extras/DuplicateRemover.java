package extras;

import java.util.*;

/**
 * Problem 4: Remove Duplicates from a String
 * Write a Java program to remove all duplicate characters from a given string 
 * and return the modified string.
 */
public class DuplicateRemover {
    
    /**
     * Remove duplicates maintaining first occurrence order
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }
        
        return result.toString();
    }
    
    /**
     * Remove duplicates case-insensitive
     */
    public static String removeDuplicatesCaseInsensitive(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        LinkedHashSet<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            char lower = Character.toLowerCase(ch);
            if (!seen.contains(lower)) {
                seen.add(lower);
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Remove duplicates keeping only unique characters
     */
    public static String keepOnlyUnique(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        
        // Count frequencies
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Keep only characters with frequency 1
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Remove consecutive duplicates only
     */
    public static String removeConsecutiveDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                result.append(str.charAt(i));
            }
        }
        
        return result.toString();
    }
    
    /**
     * Visualize duplicate removal process
     */
    public static void visualizeRemoval(String str) {
        System.out.println("\nDuplicate Removal Visualization:");
        System.out.println("─".repeat(60));
        System.out.println("Original: " + str);
        
        LinkedHashSet<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        
        System.out.println("\nProcessing:");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isDuplicate = seen.contains(ch);
            
            System.out.printf("  Position %d: '%c' - %s%n", 
                            i, ch, isDuplicate ? "Duplicate (skip)" : "New (keep)");
            
            if (!isDuplicate) {
                seen.add(ch);
                result.append(ch);
            }
        }
        
        System.out.println("\nResult: " + result.toString());
        System.out.println("─".repeat(60));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(17) + "DUPLICATE REMOVER" + " ".repeat(24) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test cases
        String[] testCases = {
            "programming",
            "hello",
            "aabbcc",
            "abcabc",
            "java",
            "aaa"
        };
        
        System.out.println("\n--- Test Case 1: Remove All Duplicates ---");
        System.out.println("┌──────────────────┬──────────────────┐");
        System.out.println("│     Original     │   No Duplicates  │");
        System.out.println("├──────────────────┼──────────────────┤");
        
        for (String test : testCases) {
            String result = removeDuplicates(test);
            System.out.printf("│ %-16s │ %-16s │%n", test, result);
        }
        
        System.out.println("└──────────────────┴──────────────────┘");
        
        System.out.println("\n\n--- Test Case 2: Case Insensitive ---");
        String[] caseTests = {"Programming", "AaBbCc", "HeLLo"};
        for (String test : caseTests) {
            System.out.println("\nOriginal: " + test);
            System.out.println("  Case sensitive:   " + removeDuplicates(test));
            System.out.println("  Case insensitive: " + removeDuplicatesCaseInsensitive(test));
        }
        
        System.out.println("\n\n--- Test Case 3: Keep Only Unique ---");
        String test = "aabbccdde";
        System.out.println("Original: " + test);
        System.out.println("Remove duplicates:  " + removeDuplicates(test));
        System.out.println("Keep only unique:   " + keepOnlyUnique(test));
        
        System.out.println("\n\n--- Test Case 4: Consecutive Duplicates ---");
        String[] consTests = {"aaabbcccc", "bookkeeper", "hellllo"};
        for (String str : consTests) {
            System.out.println("\nOriginal:             " + str);
            System.out.println("  All duplicates:     " + removeDuplicates(str));
            System.out.println("  Consecutive only:   " + removeConsecutiveDuplicates(str));
        }
        
        System.out.println("\n\n--- Test Case 5: Visualization ---");
        visualizeRemoval("programming");
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.print("Enter a string (or 'exit' to quit): ");
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("\nOriginal: " + input);
            System.out.println("No duplicates: " + removeDuplicates(input));
            visualizeRemoval(input);
            
            System.out.print("\nEnter another string (or 'exit' to quit): ");
            input = scanner.nextLine();
        }
        
        scanner.close();
    }
}
