package extras;

import java.util.*;

/**
 * Problems 5-12: String Manipulation Problems
 * Combined file containing solutions for problems 5 through 12
 */

// Problem 5: Find the Longest Word in a Sentence
class LongestWordFinder {
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        
        String[] words = sentence.split("\\s+");
        String longest = "";
        
        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        
        return longest;
    }
    
    public static List<String> findAllLongestWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return new ArrayList<>();
        }
        
        String[] words = sentence.split("\\s+");
        int maxLength = 0;
        List<String> longestWords = new ArrayList<>();
        
        // Find max length
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            maxLength = Math.max(maxLength, word.length());
        }
        
        // Collect all words with max length
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() == maxLength) {
                longestWords.add(cleanWord);
            }
        }
        
        return longestWords;
    }
}

// Problem 6: Find Substring Occurrences
class SubstringCounter {
    public static int countOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        int index = 0;
        
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        
        return count;
    }
    
    public static List<Integer> findAllOccurrences(String str, String substring) {
        List<Integer> positions = new ArrayList<>();
        
        if (str == null || substring == null || substring.isEmpty()) {
            return positions;
        }
        
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            positions.add(index);
            index += substring.length();
        }
        
        return positions;
    }
}

// Problem 7: Toggle Case of Characters
class CaseToggler {
    public static String toggleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}

// Problem 8: Compare Two Strings Lexicographically
class StringComparator {
    public static int compareLexicographically(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 == null) return -1;
        if (str2 == null) return 1;
        
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);
        
        for (int i = 0; i < minLen; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        
        // If all characters match up to minLen, compare lengths
        return len1 - len2;
    }
    
    public static String getComparisonMessage(String str1, String str2) {
        int result = compareLexicographically(str1, str2);
        
        if (result < 0) {
            return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
        } else if (result > 0) {
            return "\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order";
        } else {
            return "\"" + str1 + "\" and \"" + str2 + "\" are equal";
        }
    }
}

// Problem 9: Find the Most Frequent Character
class MostFrequentChar {
    public static char findMostFrequent(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        char mostFrequent = '\0';
        int maxFreq = 0;
        
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        return mostFrequent;
    }
    
    public static Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        if (str != null) {
            for (char ch : str.toCharArray()) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }
        
        return freqMap;
    }
}

// Problem 10: Remove a Specific Character
class CharacterRemover {
    public static String removeCharacter(String str, char charToRemove) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (ch != charToRemove) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static String removeAllOccurrences(String str, String toRemove) {
        if (str == null || toRemove == null) {
            return str;
        }
        
        return str.replace(toRemove, "");
    }
}

// Problem 11: Check if Two Strings are Anagrams
class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Count character frequencies
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (char ch : str1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        return map1.equals(map2);
    }
    
    public static boolean areAnagramsSorting(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}

// Problem 12: Replace Word in Sentence
class WordReplacer {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        if (sentence == null || oldWord == null || newWord == null) {
            return sentence;
        }
        
        return sentence.replace(oldWord, newWord);
    }
    
    public static String replaceWordWholeOnly(String sentence, String oldWord, String newWord) {
        if (sentence == null || oldWord == null || newWord == null) {
            return sentence;
        }
        
        // Use word boundaries to replace whole words only
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }
    
    public static String replaceMultipleWords(String sentence, Map<String, String> replacements) {
        if (sentence == null || replacements == null) {
            return sentence;
        }
        
        String result = sentence;
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        
        return result;
    }
}

// Main class to test all problems
public class StringProblemsCollection {
    
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(10) + "STRING MANIPULATION PROBLEMS 5-12" + " ".repeat(15) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Problem 5: Longest Word
        System.out.println("\n=== Problem 5: Find Longest Word ===");
        String sentence1 = "The quick brown fox jumps over the lazy dog";
        System.out.println("Sentence: " + sentence1);
        System.out.println("Longest word: " + LongestWordFinder.findLongestWord(sentence1));
        System.out.println("All longest words: " + LongestWordFinder.findAllLongestWords(sentence1));
        
        // Problem 6: Substring Occurrences
        System.out.println("\n=== Problem 6: Substring Occurrences ===");
        String text = "ababcabcab";
        String substring = "ab";
        System.out.println("String: " + text);
        System.out.println("Substring: " + substring);
        System.out.println("Occurrences: " + SubstringCounter.countOccurrences(text, substring));
        System.out.println("Positions: " + SubstringCounter.findAllOccurrences(text, substring));
        
        // Problem 7: Toggle Case
        System.out.println("\n=== Problem 7: Toggle Case ===");
        String toggleTest = "Hello World 123";
        System.out.println("Original: " + toggleTest);
        System.out.println("Toggled:  " + CaseToggler.toggleCase(toggleTest));
        
        // Problem 8: Compare Strings
        System.out.println("\n=== Problem 8: Compare Strings ===");
        String str1 = "apple";
        String str2 = "banana";
        System.out.println(StringComparator.getComparisonMessage(str1, str2));
        System.out.println("Comparison value: " + StringComparator.compareLexicographically(str1, str2));
        
        // Problem 9: Most Frequent Character
        System.out.println("\n=== Problem 9: Most Frequent Character ===");
        String freqTest = "success";
        System.out.println("String: " + freqTest);
        System.out.println("Most Frequent Character: '" + MostFrequentChar.findMostFrequent(freqTest) + "'");
        System.out.println("Frequency Map: " + MostFrequentChar.getFrequencyMap(freqTest));
        
        // Problem 10: Remove Character
        System.out.println("\n=== Problem 10: Remove Specific Character ===");
        String removeTest = "Hello World";
        char charToRemove = 'l';
        System.out.println("String: " + removeTest);
        System.out.println("Character to Remove: '" + charToRemove + "'");
        System.out.println("Modified String: " + CharacterRemover.removeCharacter(removeTest, charToRemove));
        
        // Problem 11: Anagrams
        System.out.println("\n=== Problem 11: Check Anagrams ===");
        String anagram1 = "listen";
        String anagram2 = "silent";
        System.out.println("String 1: " + anagram1);
        System.out.println("String 2: " + anagram2);
        System.out.println("Are anagrams? " + AnagramChecker.areAnagrams(anagram1, anagram2));
        
        String notAnagram1 = "hello";
        String notAnagram2 = "world";
        System.out.println("\nString 1: " + notAnagram1);
        System.out.println("String 2: " + notAnagram2);
        System.out.println("Are anagrams? " + AnagramChecker.areAnagrams(notAnagram1, notAnagram2));
        
        // Problem 12: Replace Word
        System.out.println("\n=== Problem 12: Replace Word ===");
        String replaceSentence = "Java is great. I love Java programming.";
        String oldWord = "Java";
        String newWord = "Python";
        System.out.println("Original: " + replaceSentence);
        System.out.println("Replace '" + oldWord + "' with '" + newWord + "':");
        System.out.println("Result: " + WordReplacer.replaceWord(replaceSentence, oldWord, newWord));
        
        // Interactive demonstration
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n=== Interactive Menu ===");
        System.out.println("Choose a problem to test:");
        System.out.println("5. Find Longest Word");
        System.out.println("6. Count Substring Occurrences");
        System.out.println("7. Toggle Case");
        System.out.println("8. Compare Strings");
        System.out.println("9. Most Frequent Character");
        System.out.println("10. Remove Character");
        System.out.println("11. Check Anagrams");
        System.out.println("12. Replace Word");
        System.out.println("0. Exit");
        
        while (true) {
            System.out.print("\nEnter choice (0-12): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 0) break;
            
            switch (choice) {
                case 5:
                    System.out.print("Enter a sentence: ");
                    String sent = scanner.nextLine();
                    System.out.println("Longest word: " + LongestWordFinder.findLongestWord(sent));
                    break;
                    
                case 6:
                    System.out.print("Enter main string: ");
                    String main = scanner.nextLine();
                    System.out.print("Enter substring: ");
                    String sub = scanner.nextLine();
                    System.out.println("Count: " + SubstringCounter.countOccurrences(main, sub));
                    break;
                    
                case 7:
                    System.out.print("Enter string: ");
                    String tog = scanner.nextLine();
                    System.out.println("Toggled: " + CaseToggler.toggleCase(tog));
                    break;
                    
                case 8:
                    System.out.print("Enter first string: ");
                    String s1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = scanner.nextLine();
                    System.out.println(StringComparator.getComparisonMessage(s1, s2));
                    break;
                    
                case 9:
                    System.out.print("Enter string: ");
                    String freq = scanner.nextLine();
                    System.out.println("Most frequent: '" + MostFrequentChar.findMostFrequent(freq) + "'");
                    break;
                    
                case 10:
                    System.out.print("Enter string: ");
                    String rem = scanner.nextLine();
                    System.out.print("Enter character to remove: ");
                    char ch = scanner.nextLine().charAt(0);
                    System.out.println("Result: " + CharacterRemover.removeCharacter(rem, ch));
                    break;
                    
                case 11:
                    System.out.print("Enter first string: ");
                    String a1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String a2 = scanner.nextLine();
                    System.out.println("Are anagrams? " + AnagramChecker.areAnagrams(a1, a2));
                    break;
                    
                case 12:
                    System.out.print("Enter sentence: ");
                    String sent12 = scanner.nextLine();
                    System.out.print("Enter word to replace: ");
                    String old = scanner.nextLine();
                    System.out.print("Enter new word: ");
                    String newW = scanner.nextLine();
                    System.out.println("Result: " + WordReplacer.replaceWord(sent12, old, newW));
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
        System.out.println("\nThank you for using String Problems Collection!");
    }
}
