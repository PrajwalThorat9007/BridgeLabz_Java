package collection.set;

/*
 * Question 4: Convert a Set to a Sorted List
 * Convert a HashSet of integers into a sorted list in ascending order.
 * Example: Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetToSortedList {
    
    // Convert HashSet to sorted ArrayList using Collections.sort
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); // Sort in ascending order
        return list;
    }
    
    // Convert using TreeSet (automatically sorted)
    public static List<Integer> convertUsingTreeSet(Set<Integer> set) {
        // TreeSet maintains natural ordering
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        return new ArrayList<>(treeSet);
    }
    
    // Manual sorting using bubble sort algorithm
    public static List<Integer> convertWithManualSort(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        
        // Bubble sort implementation
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        // Test case 1
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(3);
        set1.add(9);
        set1.add(1);
        
        System.out.println("Original HashSet: " + set1);
        System.out.println("Sorted List: " + convertToSortedList(set1));
        
        System.out.println();
        
        // Test case 2: Using TreeSet
        Set<Integer> set2 = new HashSet<>();
        set2.add(45);
        set2.add(12);
        set2.add(78);
        set2.add(23);
        set2.add(56);
        
        System.out.println("Original HashSet: " + set2);
        System.out.println("Sorted List (TreeSet): " + convertUsingTreeSet(set2));
        
        System.out.println();
        
        // Test case 3: Manual sorting
        Set<Integer> set3 = new HashSet<>();
        set3.add(100);
        set3.add(25);
        set3.add(75);
        set3.add(50);
        
        System.out.println("Original HashSet: " + set3);
        System.out.println("Sorted List (Manual): " + convertWithManualSort(set3));
        
        System.out.println();
        
        // Test case 4: Descending order
        Set<Integer> set4 = new HashSet<>();
        set4.add(8);
        set4.add(3);
        set4.add(15);
        set4.add(1);
        
        List<Integer> sortedDesc = convertToSortedList(set4);
        Collections.reverse(sortedDesc); // Reverse for descending order
        
        System.out.println("Original HashSet: " + set4);
        System.out.println("Sorted List (Descending): " + sortedDesc);
    }
}
