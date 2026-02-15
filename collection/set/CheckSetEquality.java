package collection.set;

/*
 * Question 1: Check if Two Sets Are Equal
 * Compare two sets and determine if they contain the same elements, regardless of order.
 * Example: Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true
 */

import java.util.HashSet;
import java.util.Set;

public class CheckSetEquality {
    
    // Check if two sets contain the same elements
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        // Sets are equal if they have same size and contain same elements
        return set1.equals(set2);
    }
    
    // Alternative manual check without using equals method
    public static boolean areSetsEqualManual(Set<Integer> set1, Set<Integer> set2) {
        // Check if sizes are different
        if (set1.size() != set2.size()) {
            return false;
        }
        
        // Check if all elements of set1 are in set2
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Test case 1: Equal sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are sets equal? " + areSetsEqual(set1, set2));
        System.out.println("Manual check: " + areSetsEqualManual(set1, set2));
        
        System.out.println();
        
        // Test case 2: Different sets
        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(2);
        set3.add(4);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set3: " + set3);
        System.out.println("Are sets equal? " + areSetsEqual(set1, set3));
        System.out.println("Manual check: " + areSetsEqualManual(set1, set3));
    }
}
