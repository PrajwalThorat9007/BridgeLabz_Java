package collection.list;

/*
 * Question 2: Find Frequency of Elements
 * Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
 * Example: Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFrequency {

    // Count frequency of each element in the list
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Iterate through list and update frequency count
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        // Test with sample input
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");

        System.out.println("Input List: " + fruits);

        Map<String, Integer> frequency = findFrequency(fruits);
        System.out.println("Frequency Map: " + frequency);

        System.out.println();

        // Test with more examples
        List<String> items = new ArrayList<>();
        items.add("cat");
        items.add("dog");
        items.add("cat");
        items.add("bird");
        items.add("dog");
        items.add("cat");

        System.out.println("Input List: " + items);
        frequency = findFrequency(items);
        System.out.println("Frequency Map: " + frequency);
    }
}