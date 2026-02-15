package collection.map;

/*
 * Question 4: Merge Two Maps
 * Merge two maps such that if a key exists in both, sum their values.
 * Example: Map1: {A=1, B=2}, Map2: {B=3, C=4} → Output: {A=1, B=5, C=4}
 */

import java.util.HashMap;
import java.util.Map;

public class MergeMaps {
    
    // Merge two maps by summing values for duplicate keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        
        // Add entries from map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            // If key exists, sum the values; otherwise, just add it
            result.put(key, result.getOrDefault(key, 0) + value);
        }
        
        return result;
    }
    
    // Merge maps using merge() method
    public static Map<String, Integer> mergeMapsWithMerge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        
        // Use merge method to combine values
        map2.forEach((key, value) -> result.merge(key, value, Integer::sum));
        
        return result;
    }
    
    // Merge multiple maps
    public static Map<String, Integer> mergeMultipleMaps(Map<String, Integer>... maps) {
        Map<String, Integer> result = new HashMap<>();
        
        for (Map<String, Integer> map : maps) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        
        return result;
    }
    
    // Merge maps without modifying originals
    public static Map<String, Integer> mergeImmutable(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        
        // Add all from map1
        result.putAll(map1);
        
        // Add and sum from map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic merge
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        
        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        Map<String, Integer> merged1 = mergeMaps(map1, map2);
        System.out.println("Merged: " + merged1);
        
        System.out.println();
        
        // Test case 2: Using merge method
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("X", 10);
        map3.put("Y", 20);
        
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Y", 30);
        map4.put("Z", 40);
        
        System.out.println("Map3: " + map3);
        System.out.println("Map4: " + map4);
        Map<String, Integer> merged2 = mergeMapsWithMerge(map3, map4);
        System.out.println("Merged (with merge): " + merged2);
        
        System.out.println();
        
        // Test case 3: No overlapping keys
        Map<String, Integer> map5 = new HashMap<>();
        map5.put("P", 5);
        map5.put("Q", 6);
        
        Map<String, Integer> map6 = new HashMap<>();
        map6.put("R", 7);
        map6.put("S", 8);
        
        System.out.println("Map5: " + map5);
        System.out.println("Map6: " + map6);
        Map<String, Integer> merged3 = mergeMaps(map5, map6);
        System.out.println("Merged (no overlap): " + merged3);
        
        System.out.println();
        
        // Test case 4: Merge multiple maps
        Map<String, Integer> mapA = new HashMap<>();
        mapA.put("item1", 5);
        mapA.put("item2", 10);
        
        Map<String, Integer> mapB = new HashMap<>();
        mapB.put("item2", 15);
        mapB.put("item3", 20);
        
        Map<String, Integer> mapC = new HashMap<>();
        mapC.put("item1", 5);
        mapC.put("item3", 10);
        mapC.put("item4", 25);
        
        System.out.println("MapA: " + mapA);
        System.out.println("MapB: " + mapB);
        System.out.println("MapC: " + mapC);
        Map<String, Integer> mergedMultiple = mergeMultipleMaps(mapA, mapB, mapC);
        System.out.println("Merged (multiple): " + mergedMultiple);
        
        System.out.println();
        
        // Test case 5: Inventory example
        Map<String, Integer> warehouse1 = new HashMap<>();
        warehouse1.put("Laptop", 50);
        warehouse1.put("Mouse", 200);
        warehouse1.put("Keyboard", 150);
        
        Map<String, Integer> warehouse2 = new HashMap<>();
        warehouse2.put("Laptop", 30);
        warehouse2.put("Monitor", 75);
        warehouse2.put("Keyboard", 100);
        
        System.out.println("Warehouse 1 Inventory: " + warehouse1);
        System.out.println("Warehouse 2 Inventory: " + warehouse2);
        Map<String, Integer> totalInventory = mergeMaps(warehouse1, warehouse2);
        System.out.println("Total Inventory: " + totalInventory);
    }
}
