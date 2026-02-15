package collection.set;

/*
 * Question 3: Symmetric Difference
 * Find the symmetric difference (elements present in either set but not in both) of two sets.
 * Example: Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}
 */

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    
    // Find symmetric difference using set operations
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        // Create copies to avoid modifying original sets
        Set<Integer> diff1 = new HashSet<>(set1);
        Set<Integer> diff2 = new HashSet<>(set2);
        
        // Remove common elements from both sets
        diff1.removeAll(set2); // Elements only in set1
        diff2.removeAll(set1); // Elements only in set2
        
        // Union of both differences
        diff1.addAll(diff2);
        
        return diff1;
    }
    
    // Alternative manual approach
    public static Set<Integer> findSymmetricDifferenceManual(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        
        // Add elements from set1 that are not in set2
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                result.add(element);
            }
        }
        
        // Add elements from set2 that are not in set1
        for (Integer element : set2) {
            if (!set1.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
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
        System.out.println("Symmetric Difference: " + findSymmetricDifference(set1, set2));
        
        System.out.println();
        
        // Test case 2
        Set<Integer> set3 = new HashSet<>();
        set3.add(10);
        set3.add(20);
        set3.add(30);
        set3.add(40);
        
        Set<Integer> set4 = new HashSet<>();
        set4.add(30);
        set4.add(40);
        set4.add(50);
        set4.add(60);
        
        System.out.println("Set3: " + set3);
        System.out.println("Set4: " + set4);
        System.out.println("Symmetric Difference (manual): " + findSymmetricDifferenceManual(set3, set4));
        
        System.out.println();
        
        // Test case 3: Disjoint sets (no common elements)
        Set<Integer> set5 = new HashSet<>();
        set5.add(1);
        set5.add(2);
        
        Set<Integer> set6 = new HashSet<>();
        set6.add(3);
        set6.add(4);
        
        System.out.println("Set5: " + set5);
        System.out.println("Set6: " + set6);
        System.out.println("Symmetric Difference: " + findSymmetricDifference(set5, set6));
    }
}
