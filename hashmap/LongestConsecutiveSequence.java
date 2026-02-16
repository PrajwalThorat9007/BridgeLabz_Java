package hashmap;

import java.util.*;

/**
 * Problem 3: Longest Consecutive Sequence
 * Given an unsorted array, find the length of the longest consecutive elements sequence.
 */
public class LongestConsecutiveSequence {
    
    /**
     * Find length of longest consecutive sequence using HashMap/HashSet
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param arr Input array
     * @return Length of longest consecutive sequence
     */
    public static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements to set
        for (int num : arr) {
            set.add(num);
        }
        
        int maxLength = 0;
        
        // Check each element
        for (int num : set) {
            // Only start counting if num is the start of a sequence
            // (i.e., num-1 is not in set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
    
    /**
     * Find the actual longest consecutive sequence
     * 
     * @param arr Input array
     * @return List containing the longest sequence
     */
    public static List<Integer> findLongestConsecutiveSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int maxLength = 0;
        int bestStart = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    bestStart = num;
                }
            }
        }
        
        // Build the sequence
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            result.add(bestStart + i);
        }
        
        return result;
    }
    
    /**
     * Find all consecutive sequences
     * 
     * @param arr Input array
     * @return List of all consecutive sequences
     */
    public static List<List<Integer>> findAllConsecutiveSequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (arr == null || arr.length == 0) {
            return result;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        for (int num : set) {
            if (!visited.contains(num) && !set.contains(num - 1)) {
                List<Integer> sequence = new ArrayList<>();
                int currentNum = num;
                
                while (set.contains(currentNum)) {
                    sequence.add(currentNum);
                    visited.add(currentNum);
                    currentNum++;
                }
                
                if (sequence.size() > 1) { // Only add sequences with 2+ elements
                    result.add(sequence);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Brute force approach for comparison
     * Time Complexity: O(n^3)
     */
    public static int longestConsecutiveBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int maxLength = 1;
        
        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            int currentLength = 1;
            
            // Check for consecutive numbers
            while (contains(arr, currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
    
    private static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
    
    /**
     * Display array with indices
     */
    public static void displayArray(int[] arr) {
        System.out.print("Index:  ");
        for (int i = 0; i < Math.min(arr.length, 20); i++) {
            System.out.printf("%4d ", i);
        }
        if (arr.length > 20) System.out.print("...");
        System.out.println();
        
        System.out.print("Value:  ");
        for (int i = 0; i < Math.min(arr.length, 20); i++) {
            System.out.printf("%4d ", arr[i]);
        }
        if (arr.length > 20) System.out.print("...");
        System.out.println();
    }
    
    /**
     * Display all consecutive sequences
     */
    public static void displaySequences(List<List<Integer>> sequences) {
        if (sequences.isEmpty()) {
            System.out.println("No consecutive sequences found!");
            return;
        }
        
        System.out.println("\n┌────────┬──────────────┬─────────────────────────────────┐");
        System.out.println("│   #    │   Length     │          Sequence               │");
        System.out.println("├────────┼──────────────┼─────────────────────────────────┤");
        
        for (int i = 0; i < sequences.size(); i++) {
            List<Integer> seq = sequences.get(i);
            StringBuilder seqStr = new StringBuilder("[");
            
            for (int j = 0; j < Math.min(seq.size(), 10); j++) {
                seqStr.append(seq.get(j));
                if (j < seq.size() - 1) seqStr.append(", ");
            }
            if (seq.size() > 10) seqStr.append("...");
            seqStr.append("]");
            
            System.out.printf("│   %-4d │     %-4d     │  %-30s │%n",
                            (i + 1), seq.size(), seqStr.toString());
        }
        
        System.out.println("└────────┴──────────────┴─────────────────────────────────┘");
    }
    
    /**
     * Visualize the search process
     */
    public static void visualizeSearch(int[] arr) {
        System.out.println("\nSearch Process Visualization:");
        System.out.println("─".repeat(70));
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        System.out.println("Unique elements in set: " + set);
        System.out.println("─".repeat(70));
        
        System.out.println("\nSearching for sequences:");
        System.out.println("─".repeat(70));
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                System.out.printf("\nStarting from %d (no %d in set):%n", num, num - 1);
                
                int currentNum = num;
                int length = 1;
                System.out.print("  Sequence: " + currentNum);
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                    System.out.print(" → " + currentNum);
                }
                
                System.out.println("\n  Length: " + length);
            }
        }
        
        System.out.println("─".repeat(70));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(10) + "LONGEST CONSECUTIVE SEQUENCE" + " ".repeat(20) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Standard example
        System.out.println("\n--- Test Case 1: Standard Example ---");
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Array: " + Arrays.toString(arr1));
        displayArray(arr1);
        
        int length1 = longestConsecutive(arr1);
        System.out.println("\nLongest consecutive sequence length: " + length1);
        
        List<Integer> sequence1 = findLongestConsecutiveSequence(arr1);
        System.out.println("Longest sequence: " + sequence1);
        
        List<List<Integer>> allSeq1 = findAllConsecutiveSequences(arr1);
        System.out.println("\nAll consecutive sequences:");
        displaySequences(allSeq1);
        
        visualizeSearch(arr1);
        
        // Test Case 2: No consecutive sequence
        System.out.println("\n\n--- Test Case 2: No Consecutive Sequence ---");
        int[] arr2 = {10, 20, 30, 40, 50};
        System.out.println("Array: " + Arrays.toString(arr2));
        displayArray(arr2);
        
        int length2 = longestConsecutive(arr2);
        System.out.println("\nLongest consecutive sequence length: " + length2);
        
        // Test Case 3: Multiple consecutive sequences
        System.out.println("\n\n--- Test Case 3: Multiple Sequences ---");
        int[] arr3 = {1, 2, 3, 5, 6, 7, 8, 10, 11};
        System.out.println("Array: " + Arrays.toString(arr3));
        displayArray(arr3);
        
        int length3 = longestConsecutive(arr3);
        System.out.println("\nLongest consecutive sequence length: " + length3);
        
        List<Integer> sequence3 = findLongestConsecutiveSequence(arr3);
        System.out.println("Longest sequence: " + sequence3);
        
        List<List<Integer>> allSeq3 = findAllConsecutiveSequences(arr3);
        System.out.println("\nAll consecutive sequences:");
        displaySequences(allSeq3);
        
        // Test Case 4: Entire array is consecutive
        System.out.println("\n\n--- Test Case 4: Entire Array Consecutive ---");
        int[] arr4 = {5, 2, 3, 4, 1, 6};
        System.out.println("Array: " + Arrays.toString(arr4));
        displayArray(arr4);
        
        int length4 = longestConsecutive(arr4);
        System.out.println("\nLongest consecutive sequence length: " + length4);
        
        List<Integer> sequence4 = findLongestConsecutiveSequence(arr4);
        System.out.println("Longest sequence: " + sequence4);
        
        visualizeSearch(arr4);
        
        // Test Case 5: Array with duplicates
        System.out.println("\n\n--- Test Case 5: Array with Duplicates ---");
        int[] arr5 = {1, 2, 0, 1, 2, 3, 4};
        System.out.println("Array: " + Arrays.toString(arr5));
        displayArray(arr5);
        
        int length5 = longestConsecutive(arr5);
        System.out.println("\nLongest consecutive sequence length: " + length5);
        
        List<Integer> sequence5 = findLongestConsecutiveSequence(arr5);
        System.out.println("Longest sequence: " + sequence5);
        
        // Test Case 6: Negative numbers
        System.out.println("\n\n--- Test Case 6: Negative Numbers ---");
        int[] arr6 = {-3, -2, -1, 0, 1, 2, 10, 11, 12};
        System.out.println("Array: " + Arrays.toString(arr6));
        displayArray(arr6);
        
        int length6 = longestConsecutive(arr6);
        System.out.println("\nLongest consecutive sequence length: " + length6);
        
        List<Integer> sequence6 = findLongestConsecutiveSequence(arr6);
        System.out.println("Longest sequence: " + sequence6);
        
        List<List<Integer>> allSeq6 = findAllConsecutiveSequences(arr6);
        System.out.println("\nAll consecutive sequences:");
        displaySequences(allSeq6);
        
        // Test Case 7: Single element
        System.out.println("\n\n--- Test Case 7: Single Element ---");
        int[] arr7 = {42};
        System.out.println("Array: " + Arrays.toString(arr7));
        
        int length7 = longestConsecutive(arr7);
        System.out.println("Longest consecutive sequence length: " + length7);
        
        // Test Case 8: Empty array
        System.out.println("\n\n--- Test Case 8: Empty Array ---");
        int[] arr8 = {};
        System.out.println("Array: " + Arrays.toString(arr8));
        
        int length8 = longestConsecutive(arr8);
        System.out.println("Longest consecutive sequence length: " + length8);
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largeArr = new int[10000];
        Random rand = new Random(42);
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = rand.nextInt(20000);
        }
        
        long startTime = System.nanoTime();
        int optimizedResult = longestConsecutive(largeArr);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int bruteResult = longestConsecutiveBruteForce(largeArr);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largeArr.length);
        System.out.println("Longest sequence length: " + optimizedResult);
        System.out.printf("Optimized (HashSet): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute Force: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
        System.out.println("Results match: " + (optimizedResult == bruteResult));
    }
}
