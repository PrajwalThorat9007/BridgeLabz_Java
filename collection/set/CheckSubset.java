package collection.set;

/*
 * Question 5: Find Subsets
 * Check if one set is a subset of another.
 * Example: Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true
 */

import java.util.HashSet;
import java.util.Set;

public class CheckSubset {
    
    // Check if set1 is a subset of set2 using containsAll
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        // set1 is subset of set2 if all elements of set1 are in set2
        return set2.containsAll(set1);
    }
    
    // Manual check without using containsAll
    public static boolean isSubsetManual(Set<Integer> set1, Set<Integer> set2) {
        // Empty set is subset of any set
        if (set1.isEmpty()) {
            return true;
        }
        
        // If set1 is larger than set2, it cannot be a subset
        if (set1.size() > set2.size()) {
            return false;
        }
        
        // Check if all elements of set1 exist in set2
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }
        
        return true;
    }
    
    // Check if set1 is a proper subset of set2 (subset but not equal)
    public static boolean isProperSubset(Set<Integer> set1, Set<Integer> set2) {
        return isSubset(set1, set2) && !set1.equals(set2);
    }
    
    public static void main(String[] args) {
        // Test case 1: set1 is subset of set2
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 subset of Set2? " + isSubset(set1, set2));
        System.out.println("Manual check: " + isSubsetManual(set1, set2));
        
        System.out.println();
        
        // Test case 2: set3 is NOT subset of set4
        Set<Integer> set3 = new HashSet<>();
        set3.add(5);
        set3.add(6);
        
        Set<Integer> set4 = new HashSet<>();
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);
        
        System.out.println("Set3: " + set3);
        System.out.println("Set4: " + set4);
        System.out.println("Is Set3 subset of Set4? " + isSubset(set3, set4));
        
        System.out.println();
        
        // Test case 3: Equal sets
        Set<Integer> set5 = new HashSet<>();
        set5.add(1);
        set5.add(2);
        set5.add(3);
        
        Set<Integer> set6 = new HashSet<>();
        set6.add(1);
        set6.add(2);
        set6.add(3);
        
        System.out.println("Set5: " + set5);
        System.out.println("Set6: " + set6);
        System.out.println("Is Set5 subset of Set6? " + isSubset(set5, set6));
        System.out.println("Is Set5 proper subset of Set6? " + isProperSubset(set5, set6));
        
        System.out.println();
        
        // Test case 4: Empty set
        Set<Integer> emptySet = new HashSet<>();
        Set<Integer> set7 = new HashSet<>();
        set7.add(10);
        set7.add(20);
        
        System.out.println("Empty Set: " + emptySet);
        System.out.println("Set7: " + set7);
        System.out.println("Is empty set subset of Set7? " + isSubset(emptySet, set7));
    }
}
