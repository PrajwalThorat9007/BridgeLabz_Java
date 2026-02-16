package hashmap;

import java.util.*;

/**
 * Problem 1: Find All Subarrays with Zero Sum
 * Given an array, find all subarrays whose elements sum up to zero.
 */
public class ZeroSumSubarrays {
    
    /**
     * Class to represent a subarray
     */
    static class Subarray {
        int start;
        int end;
        
        public Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    
    /**
     * Find all subarrays with zero sum using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param arr Input array
     * @return List of all subarrays with zero sum
     */
    public static List<Subarray> findZeroSumSubarrays(int[] arr) {
        List<Subarray> result = new ArrayList<>();
        
        // HashMap to store cumulative sum and list of indices where it occurs
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int cumulativeSum = 0;
        
        // Add initial sum 0 at index -1 (for subarrays starting from index 0)
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            // If this sum exists in map, we found zero-sum subarray(s)
            if (map.containsKey(cumulativeSum)) {
                // Get all previous indices where this sum occurred
                ArrayList<Integer> indices = map.get(cumulativeSum);
                
                // Create subarray from each previous index to current index
                for (int prevIndex : indices) {
                    result.add(new Subarray(prevIndex + 1, i));
                }
            }
            
            // Add current index to the list for this cumulative sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
        
        return result;
    }
    
    /**
     * Find all subarrays with zero sum using brute force
     * Time Complexity: O(n^2)
     */
    public static List<Subarray> findZeroSumSubarraysBruteForce(int[] arr) {
        List<Subarray> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    result.add(new Subarray(i, j));
                }
            }
        }
        
        return result;
    }
    
    /**
     * Display array with indices
     */
    public static void displayArray(int[] arr) {
        System.out.print("Index:    ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d ", i);
        }
        System.out.println();
        
        System.out.print("Value:    ");
        for (int val : arr) {
            System.out.printf("%4d ", val);
        }
        System.out.println();
    }
    
    /**
     * Display subarrays with their elements
     */
    public static void displaySubarrays(int[] arr, List<Subarray> subarrays) {
        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found!");
            return;
        }
        
        System.out.println("\n┌────────┬─────────────────┬─────────────────────────────┐");
        System.out.println("│   #    │     Indices     │          Elements           │");
        System.out.println("├────────┼─────────────────┼─────────────────────────────┤");
        
        for (int i = 0; i < subarrays.size(); i++) {
            Subarray sub = subarrays.get(i);
            StringBuilder elements = new StringBuilder("[");
            
            for (int j = sub.start; j <= sub.end; j++) {
                elements.append(arr[j]);
                if (j < sub.end) elements.append(", ");
            }
            elements.append("]");
            
            System.out.printf("│   %-4d │   [%2d, %2d]      │  %-26s │%n", 
                            (i + 1), sub.start, sub.end, elements.toString());
        }
        
        System.out.println("└────────┴─────────────────┴─────────────────────────────┘");
    }
    
    /**
     * Display cumulative sum analysis
     */
    public static void displayCumulativeSumAnalysis(int[] arr) {
        System.out.println("\nCumulative Sum Analysis:");
        System.out.println("─".repeat(60));
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        int cumulativeSum = 0;
        
        System.out.println("Index | Value | Cumulative Sum | Previous Occurrences");
        System.out.println("─".repeat(60));
        
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            System.out.printf("  %-3d |  %4d |      %4d      | ", i, arr[i], cumulativeSum);
            
            if (map.containsKey(cumulativeSum)) {
                System.out.print("Found at: " + map.get(cumulativeSum));
                System.out.print(" → Zero-sum subarray(s) detected!");
            } else {
                System.out.print("First occurrence");
            }
            System.out.println();
            
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
        
        System.out.println("─".repeat(60));
    }
    
    /**
     * Check if array has any zero-sum subarray
     */
    public static boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        int cumulativeSum = 0;
        
        for (int num : arr) {
            cumulativeSum += num;
            
            if (set.contains(cumulativeSum)) {
                return true;
            }
            
            set.add(cumulativeSum);
        }
        
        return false;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(13) + "FIND ZERO-SUM SUBARRAYS" + " ".repeat(22) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Multiple zero-sum subarrays
        System.out.println("\n--- Test Case 1: Multiple Zero-Sum Subarrays ---");
        int[] arr1 = {4, 2, -3, 1, 6};
        System.out.println("Array: " + Arrays.toString(arr1));
        displayArray(arr1);
        
        List<Subarray> result1 = findZeroSumSubarrays(arr1);
        System.out.println("\nFound " + result1.size() + " zero-sum subarray(s):");
        displaySubarrays(arr1, result1);
        displayCumulativeSumAnalysis(arr1);
        
        // Test Case 2: Array with zeros
        System.out.println("\n\n--- Test Case 2: Array Containing Zeros ---");
        int[] arr2 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println("Array: " + Arrays.toString(arr2));
        displayArray(arr2);
        
        List<Subarray> result2 = findZeroSumSubarrays(arr2);
        System.out.println("\nFound " + result2.size() + " zero-sum subarray(s):");
        displaySubarrays(arr2, result2);
        
        // Test Case 3: Array with single zero
        System.out.println("\n\n--- Test Case 3: Single Zero Element ---");
        int[] arr3 = {1, 2, 0, 3, 4};
        System.out.println("Array: " + Arrays.toString(arr3));
        displayArray(arr3);
        
        List<Subarray> result3 = findZeroSumSubarrays(arr3);
        System.out.println("\nFound " + result3.size() + " zero-sum subarray(s):");
        displaySubarrays(arr3, result3);
        
        // Test Case 4: No zero-sum subarrays
        System.out.println("\n\n--- Test Case 4: No Zero-Sum Subarrays ---");
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Array: " + Arrays.toString(arr4));
        displayArray(arr4);
        
        List<Subarray> result4 = findZeroSumSubarrays(arr4);
        System.out.println("\nFound " + result4.size() + " zero-sum subarray(s):");
        displaySubarrays(arr4, result4);
        
        // Test Case 5: Entire array sums to zero
        System.out.println("\n\n--- Test Case 5: Entire Array Sums to Zero ---");
        int[] arr5 = {1, -1, 2, -2, 3, -3};
        System.out.println("Array: " + Arrays.toString(arr5));
        displayArray(arr5);
        
        List<Subarray> result5 = findZeroSumSubarrays(arr5);
        System.out.println("\nFound " + result5.size() + " zero-sum subarray(s):");
        displaySubarrays(arr5, result5);
        
        // Test Case 6: All negative and positive pairs
        System.out.println("\n\n--- Test Case 6: Negative and Positive Pairs ---");
        int[] arr6 = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        System.out.println("Array: " + Arrays.toString(arr6));
        displayArray(arr6);
        
        List<Subarray> result6 = findZeroSumSubarrays(arr6);
        System.out.println("\nFound " + result6.size() + " zero-sum subarray(s):");
        displaySubarrays(arr6, result6);
        displayCumulativeSumAnalysis(arr6);
        
        // Test Case 7: Quick check function
        System.out.println("\n\n--- Test Case 7: Quick Zero-Sum Check ---");
        int[] arr7 = {1, 4, -2, -2, 5, -4, 3};
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Has zero-sum subarray? " + hasZeroSumSubarray(arr7));
        
        int[] arr8 = {1, 2, 3, 4, 5};
        System.out.println("\nArray: " + Arrays.toString(arr8));
        System.out.println("Has zero-sum subarray? " + hasZeroSumSubarray(arr8));
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largeArr = new int[5000];
        Random rand = new Random(42);
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = rand.nextInt(21) - 10; // Range: -10 to 10
        }
        
        long startTime = System.nanoTime();
        List<Subarray> optimizedResult = findZeroSumSubarrays(largeArr);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        List<Subarray> bruteResult = findZeroSumSubarraysBruteForce(largeArr);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largeArr.length);
        System.out.println("Zero-sum subarrays found: " + optimizedResult.size());
        System.out.printf("Optimized (HashMap): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute Force: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
        System.out.println("Results match: " + (optimizedResult.size() == bruteResult.size()));
    }
}
