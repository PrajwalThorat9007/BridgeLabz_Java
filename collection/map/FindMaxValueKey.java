package collection.map;

/*
 * Question 3: Find the Key with the Highest Value
 * Given a Map<String, Integer>, find the key with the maximum value.
 * Example: Input: {A=10, B=20, C=15} → Output: B
 */

import java.util.HashMap;
import java.util.Map;

public class FindMaxValueKey {
    
    // Find key with maximum value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        
        String maxKey = null;
        Integer maxValue = Integer.MIN_VALUE;
        
        // Iterate through map to find maximum value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }
    
    // Find key with maximum value using streams
    public static String findKeyWithMaxValueStream(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        
        return map.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }
    
    // Find key with minimum value
    public static String findKeyWithMinValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        
        String minKey = null;
        Integer minValue = Integer.MAX_VALUE;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                minKey = entry.getKey();
            }
        }
        
        return minKey;
    }
    
    // Find both key and value with maximum
    public static Map.Entry<String, Integer> findMaxEntry(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        
        Map.Entry<String, Integer> maxEntry = null;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        
        return maxEntry;
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 15);
        
        System.out.println("Map: " + map1);
        System.out.println("Key with max value: " + findKeyWithMaxValue(map1));
        System.out.println("Key with max value (stream): " + findKeyWithMaxValueStream(map1));
        
        System.out.println();
        
        // Test case 2: Map with negative values
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", -5);
        map2.put("Y", -10);
        map2.put("Z", -3);
        
        System.out.println("Map: " + map2);
        System.out.println("Key with max value: " + findKeyWithMaxValue(map2));
        System.out.println("Key with min value: " + findKeyWithMinValue(map2));
        
        System.out.println();
        
        // Test case 3: Map with duplicate values
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Apple", 100);
        map3.put("Banana", 150);
        map3.put("Cherry", 150);
        map3.put("Date", 120);
        
        System.out.println("Map: " + map3);
        System.out.println("Key with max value: " + findKeyWithMaxValue(map3));
        
        Map.Entry<String, Integer> maxEntry = findMaxEntry(map3);
        if (maxEntry != null) {
            System.out.println("Max entry: " + maxEntry.getKey() + " = " + maxEntry.getValue());
        }
        
        System.out.println();
        
        // Test case 4: Single entry map
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Only", 42);
        
        System.out.println("Map: " + map4);
        System.out.println("Key with max value: " + findKeyWithMaxValue(map4));
        
        System.out.println();
        
        // Test case 5: Score comparison
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);
        scores.put("Diana", 95);
        scores.put("Eve", 88);
        
        System.out.println("Student Scores: " + scores);
        String topStudent = findKeyWithMaxValue(scores);
        System.out.println("Top student: " + topStudent + " with score: " + scores.get(topStudent));
    }
}
