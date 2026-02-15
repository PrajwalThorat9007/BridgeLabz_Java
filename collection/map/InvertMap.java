package collection.map;

/*
 * Question 2: Invert a Map
 * Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing them in a list.
 * Example: Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {
    
    // Invert map with duplicate value handling
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> originalMap) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        
        // Iterate through original map entries
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            // If value doesn't exist as key in inverted map, create new list
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }
            
            // Add original key to the list
            invertedMap.get(value).add(key);
        }
        
        return invertedMap;
    }
    
    // Generic version for any types
    public static <K, V> Map<V, List<K>> invertMapGeneric(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            
            // Add key to list for this value
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        
        return invertedMap;
    }
    
    // Invert map assuming unique values (one-to-one mapping)
    public static Map<Integer, String> invertMapSimple(Map<String, Integer> originalMap) {
        Map<Integer, String> invertedMap = new HashMap<>();
        
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        
        return invertedMap;
    }
    
    public static void main(String[] args) {
        // Test case 1: Map with duplicate values
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 1);
        
        System.out.println("Original Map: " + map1);
        Map<Integer, List<String>> inverted1 = invertMap(map1);
        System.out.println("Inverted Map: " + inverted1);
        
        System.out.println();
        
        // Test case 2: Map with all unique values
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", 10);
        map2.put("Y", 20);
        map2.put("Z", 30);
        
        System.out.println("Original Map: " + map2);
        Map<Integer, String> inverted2 = invertMapSimple(map2);
        System.out.println("Inverted Map (Simple): " + inverted2);
        
        System.out.println();
        
        // Test case 3: Map with multiple duplicate values
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Apple", 5);
        map3.put("Banana", 3);
        map3.put("Cherry", 5);
        map3.put("Date", 3);
        map3.put("Elderberry", 7);
        
        System.out.println("Original Map: " + map3);
        Map<Integer, List<String>> inverted3 = invertMap(map3);
        System.out.println("Inverted Map: " + inverted3);
        
        System.out.println();
        
        // Test case 4: Using generic version
        Map<String, String> map4 = new HashMap<>();
        map4.put("John", "HR");
        map4.put("Alice", "IT");
        map4.put("Bob", "HR");
        map4.put("Carol", "IT");
        
        System.out.println("Original Map (String-String): " + map4);
        Map<String, List<String>> inverted4 = invertMapGeneric(map4);
        System.out.println("Inverted Map: " + inverted4);
    }
}
