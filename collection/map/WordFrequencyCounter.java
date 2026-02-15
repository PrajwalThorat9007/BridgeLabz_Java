package collection.map;

/*
 * Question 1: Word Frequency Counter
 * Read a text file and count the frequency of each word using a HashMap. Ignore case and punctuation.
 * Example: Input: "Hello world, hello Java!" → Output: {hello=2, world=1, java=1}
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    
    // Count word frequency from a string
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        // Convert to lowercase and remove punctuation
        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        
        // Split into words
        String[] words = cleanedText.split("\\s+");
        
        // Count frequency of each word
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
    
    // Count word frequency from a file
    public static Map<String, Integer> countWordFrequencyFromFile(String fileName) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            // Read file line by line
            while ((line = reader.readLine()) != null) {
                Map<String, Integer> lineFrequency = countWordFrequency(line);
                
                // Merge with main frequency map
                for (Map.Entry<String, Integer> entry : lineFrequency.entrySet()) {
                    frequencyMap.put(entry.getKey(), 
                        frequencyMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return frequencyMap;
    }
    
    // Display frequency map in sorted order
    public static void displayFrequency(Map<String, Integer> frequencyMap) {
        System.out.println("Word Frequency:");
        frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple string
        String text1 = "Hello world, hello Java!";
        System.out.println("Input: \"" + text1 + "\"");
        Map<String, Integer> frequency1 = countWordFrequency(text1);
        System.out.println("Output: " + frequency1);
        
        System.out.println();
        
        // Test case 2: Longer text
        String text2 = "Java is great. Java is powerful. Java is everywhere!";
        System.out.println("Input: \"" + text2 + "\"");
        Map<String, Integer> frequency2 = countWordFrequency(text2);
        displayFrequency(frequency2);
        
        System.out.println();
        
        // Test case 3: Text with special characters
        String text3 = "Hello, World! Hello-World. Hello_World? HELLO!";
        System.out.println("Input: \"" + text3 + "\"");
        Map<String, Integer> frequency3 = countWordFrequency(text3);
        System.out.println("Output: " + frequency3);
        
        System.out.println();
        
        // Test case 4: Multiple sentences
        String text4 = "The quick brown fox jumps over the lazy dog. " +
                       "The dog was really lazy. The fox was quick.";
        System.out.println("Input: \"" + text4 + "\"");
        Map<String, Integer> frequency4 = countWordFrequency(text4);
        displayFrequency(frequency4);
    }
}
