package extras;

import java.util.*;

/**
 * Problem 1: Count Vowels and Consonants
 * Write a Java program to count the number of vowels and consonants in a given string.
 */
public class VowelConsonantCounter {
    
    /**
     * Count vowels and consonants in a string
     * 
     * @param str Input string
     * @return Array [vowels, consonants]
     */
    public static int[] countVowelsAndConsonants(String str) {
        if (str == null || str.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int vowels = 0;
        int consonants = 0;
        
        String vowelChars = "aeiouAEIOU";
        
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vowelChars.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        return new int[]{vowels, consonants};
    }
    
    /**
     * Get detailed count of each vowel and consonant
     */
    public static Map<String, Integer> getDetailedCount(String str) {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("vowels", 0);
        counts.put("consonants", 0);
        counts.put("digits", 0);
        counts.put("spaces", 0);
        counts.put("special", 0);
        
        if (str == null) return counts;
        
        String vowelChars = "aeiouAEIOU";
        
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vowelChars.indexOf(ch) != -1) {
                    counts.put("vowels", counts.get("vowels") + 1);
                } else {
                    counts.put("consonants", counts.get("consonants") + 1);
                }
            } else if (Character.isDigit(ch)) {
                counts.put("digits", counts.get("digits") + 1);
            } else if (Character.isWhitespace(ch)) {
                counts.put("spaces", counts.get("spaces") + 1);
            } else {
                counts.put("special", counts.get("special") + 1);
            }
        }
        
        return counts;
    }
    
    /**
     * Count individual vowels
     */
    public static Map<Character, Integer> countIndividualVowels(String str) {
        Map<Character, Integer> vowelCount = new HashMap<>();
        vowelCount.put('a', 0);
        vowelCount.put('e', 0);
        vowelCount.put('i', 0);
        vowelCount.put('o', 0);
        vowelCount.put('u', 0);
        
        if (str == null) return vowelCount;
        
        for (char ch : str.toLowerCase().toCharArray()) {
            if (vowelCount.containsKey(ch)) {
                vowelCount.put(ch, vowelCount.get(ch) + 1);
            }
        }
        
        return vowelCount;
    }
    
    /**
     * Display detailed statistics
     */
    public static void displayStatistics(String str) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("STRING ANALYSIS: \"" + str + "\"");
        System.out.println("═".repeat(60));
        
        int[] counts = countVowelsAndConsonants(str);
        Map<String, Integer> detailed = getDetailedCount(str);
        Map<Character, Integer> vowelBreakdown = countIndividualVowels(str);
        
        System.out.println("\nBasic Counts:");
        System.out.println("  Vowels:     " + counts[0]);
        System.out.println("  Consonants: " + counts[1]);
        
        System.out.println("\nDetailed Breakdown:");
        System.out.println("  Letters:    " + (detailed.get("vowels") + detailed.get("consonants")));
        System.out.println("    └─ Vowels:     " + detailed.get("vowels"));
        System.out.println("    └─ Consonants: " + detailed.get("consonants"));
        System.out.println("  Digits:     " + detailed.get("digits"));
        System.out.println("  Spaces:     " + detailed.get("spaces"));
        System.out.println("  Special:    " + detailed.get("special"));
        
        System.out.println("\nVowel Breakdown:");
        for (char vowel : "aeiou".toCharArray()) {
            int count = vowelBreakdown.get(vowel);
            System.out.printf("  %c: %d %s%n", vowel, count, "█".repeat(count));
        }
        
        System.out.println("═".repeat(60));
    }
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(14) + "VOWEL & CONSONANT COUNTER" + " ".repeat(19) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test cases
        String[] testCases = {
            "Hello World",
            "Programming in Java",
            "AEIOU",
            "bcdfg",
            "The quick brown fox jumps over the lazy dog",
            "Java123!@#",
            ""
        };
        
        for (String test : testCases) {
            displayStatistics(test);
        }
        
        // Interactive mode
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n--- Interactive Mode ---");
        System.out.print("Enter a string (or 'exit' to quit): ");
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("exit")) {
            displayStatistics(input);
            System.out.print("\nEnter another string (or 'exit' to quit): ");
            input = scanner.nextLine();
        }
        
        scanner.close();
    }
}
