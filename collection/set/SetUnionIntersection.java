package collection.set;

/*
 * Question 2: Union and Intersection of Two Sets
 * Given two sets, compute their union and intersection.
 * Example: Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}
 */

import java.util.HashSet;
import java.util.Set;

public class SetUnionIntersection {
    
    // Find union of two sets (all elements from both sets)
    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); // Add all elements from set2
        return union;
    }
    
    // Find intersection of two sets (common elements)
    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Keep only common elements
        return intersection;
    }
    
    // Alternative manual intersection without retainAll
    public static Set<Integer> findIntersectionManual(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();
        
        // Iterate through smaller set for efficiency
        Set<Integer> smaller = set1.size() < set2.size() ? set1 : set2;
        Set<Integer> larger = set1.size() < set2.size() ? set2 : set1;
        
        for (Integer element : smaller) {
            if (larger.contains(element)) {
                intersection.add(element);
            }
        }
        
        return intersection;
    }
    
    public static void main(String[] args) {
        // Create test sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println();
        
        // Find and display union
        Set<Integer> union = findUnion(set1, set2);
        System.out.println("Union: " + union);
        
        // Find and display intersection
        Set<Integer> intersection = findIntersection(set1, set2);
        System.out.println("Intersection: " + intersection);
        
        System.out.println();
        
        // Test with different sets
        Set<Integer> set3 = new HashSet<>();
        set3.add(10);
        set3.add(20);
        set3.add(30);
        
        Set<Integer> set4 = new HashSet<>();
        set4.add(20);
        set4.add(30);
        set4.add(40);
        set4.add(50);
        
        System.out.println("Set3: " + set3);
        System.out.println("Set4: " + set4);
        System.out.println("Union: " + findUnion(set3, set4));
        System.out.println("Intersection (manual): " + findIntersectionManual(set3, set4));
    }
}
