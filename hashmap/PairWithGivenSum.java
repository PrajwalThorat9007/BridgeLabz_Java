package hashmap;

import java.util.*;

/**
 * Problem 2: Check for a Pair with Given Sum in an Array
 * Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
 */
public class PairWithGivenSum {
    
    /**
     * Class to represent a pair of elements
     */
    static class Pair {
        int first;
        int second;
        int index1;
        int index2;
        
        public Pair(int first, int second, int index1, int index2) {
            this.first = first;
            this.second = second;
            this.index1 = index1;
            this.index2 = index2;
        }
        
        @Override
        public String toString() {
            return String.format("(%d, %d) at indices [%d, %d]", first, second, index1, index2);
        }
    }
    
    /**
     * Check if pair exists with given sum using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param arr Input array
     * @param target Target sum
     * @return true if pair exists, false otherwise
     */
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            int complement = target - num;
            
            if (seen.contains(complement)) {
                return true;
            }
            
            seen.add(num);
        }
        
        return false;
    }
    
    /**
     * Find first pair with given sum
     * 
     * @param arr Input array
     * @param target Target sum
     * @return Pair object or null if not found
     */
    public static Pair findPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index
        
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (map.containsKey(complement)) {
                return new Pair(complement, arr[i], map.get(complement), i);
            }
            
            map.put(arr[i], i);
        }
        
        return null;
    }
    
    /**
     * Find all pairs with given sum
     * 
     * @param arr Input array
     * @param target Target sum
     * @return List of all pairs
     */
    public static List<Pair> findAllPairsWithSum(int[] arr, int target) {
        List<Pair> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // value -> list of indices
        
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (map.containsKey(complement)) {
                // Found pair(s) with this complement
                for (int prevIndex : map.get(complement)) {
                    result.add(new Pair(complement, arr[i], prevIndex, i));
                }
            }
            
            // Add current element to map
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        return result;
    }
    
    /**
     * Find all unique pairs (avoiding duplicates)
     * 
     * @param arr Input array
     * @param target Target sum
     * @return List of unique pairs
     */
    public static List<Pair> findUniquePairsWithSum(int[] arr, int target) {
        List<Pair> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> usedPairs = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (seen.contains(complement)) {
                // Create sorted pair key to avoid duplicates
                int min = Math.min(arr[i], complement);
                int max = Math.max(arr[i], complement);
                String pairKey = min + "," + max;
                
                if (!usedPairs.contains(pairKey)) {
                    result.add(new Pair(complement, arr[i], -1, i));
                    usedPairs.add(pairKey);
                }
            }
            
            seen.add(arr[i]);
        }
        
        return result;
    }
    
    /**
     * Brute force approach for comparison
     * Time Complexity: O(n^2)
     */
    public static boolean hasPairWithSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Display array with indices
     */
    public static void displayArray(int[] arr) {
        System.out.print("Index:  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d ", i);
        }
        System.out.println();
        
        System.out.print("Value:  ");
        for (int val : arr) {
            System.out.printf("%4d ", val);
        }
        System.out.println();
    }
    
    /**
     * Display all found pairs
     */
    public static void displayPairs(List<Pair> pairs, int target) {
        if (pairs.isEmpty()) {
            System.out.println("No pairs found with sum = " + target);
            return;
        }
        
        System.out.println("\n┌────────┬─────────────────┬──────────────┬─────────┐");
        System.out.println("│   #    │      Pair       │   Indices    │   Sum   │");
        System.out.println("├────────┼─────────────────┼──────────────┼─────────┤");
        
        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            System.out.printf("│   %-4d │  (%3d, %3d)     │   [%2d, %2d]   │   %3d   │%n",
                            (i + 1), p.first, p.second, p.index1, p.index2, p.first + p.second);
        }
        
        System.out.println("└────────┴─────────────────┴──────────────┴─────────┘");
    }
    
    /**
     * Visualize the search process
     */
    public static void visualizeSearch(int[] arr, int target) {
        System.out.println("\nSearch Process Visualization:");
        System.out.println("─".repeat(70));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        System.out.println("Step | Current | Complement | In Map? | Action");
        System.out.println("─".repeat(70));
        
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int complement = target - current;
            boolean inMap = map.containsKey(complement);
            
            System.out.printf(" %-3d |   %3d   |    %3d     |   %s   | ",
                            i, current, complement, inMap ? "YES" : "NO ");
            
            if (inMap) {
                System.out.printf("✓ FOUND pair (%d, %d) at indices [%d, %d]%n",
                                complement, current, map.get(complement), i);
            } else {
                System.out.printf("Add %d to map%n", current);
            }
            
            map.put(current, i);
        }
        
        System.out.println("─".repeat(70));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(13) + "PAIR WITH GIVEN SUM" + " ".repeat(26) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Pair exists
        System.out.println("\n--- Test Case 1: Pair Exists ---");
        int[] arr1 = {8, 7, 2, 5, 3, 1};
        int target1 = 10;
        System.out.println("Array: " + Arrays.toString(arr1));
        displayArray(arr1);
        System.out.println("Target Sum: " + target1);
        
        System.out.println("\nHas pair with sum " + target1 + "? " + hasPairWithSum(arr1, target1));
        
        Pair pair1 = findPairWithSum(arr1, target1);
        if (pair1 != null) {
            System.out.println("Found pair: " + pair1);
        }
        
        List<Pair> allPairs1 = findAllPairsWithSum(arr1, target1);
        System.out.println("\nAll pairs with sum " + target1 + ":");
        displayPairs(allPairs1, target1);
        
        visualizeSearch(arr1, target1);
        
        // Test Case 2: No pair exists
        System.out.println("\n\n--- Test Case 2: No Pair Exists ---");
        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 20;
        System.out.println("Array: " + Arrays.toString(arr2));
        displayArray(arr2);
        System.out.println("Target Sum: " + target2);
        
        System.out.println("\nHas pair with sum " + target2 + "? " + hasPairWithSum(arr2, target2));
        
        Pair pair2 = findPairWithSum(arr2, target2);
        if (pair2 == null) {
            System.out.println("No pair found with sum " + target2);
        }
        
        // Test Case 3: Multiple pairs
        System.out.println("\n\n--- Test Case 3: Multiple Pairs ---");
        int[] arr3 = {1, 5, 7, -1, 5, 3, 2, 8};
        int target3 = 6;
        System.out.println("Array: " + Arrays.toString(arr3));
        displayArray(arr3);
        System.out.println("Target Sum: " + target3);
        
        List<Pair> allPairs3 = findAllPairsWithSum(arr3, target3);
        System.out.println("\nAll pairs with sum " + target3 + ":");
        displayPairs(allPairs3, target3);
        
        // Test Case 4: Array with duplicates
        System.out.println("\n\n--- Test Case 4: Array with Duplicates ---");
        int[] arr4 = {4, 3, 4, 3, 5, 1};
        int target4 = 7;
        System.out.println("Array: " + Arrays.toString(arr4));
        displayArray(arr4);
        System.out.println("Target Sum: " + target4);
        
        List<Pair> allPairs4 = findAllPairsWithSum(arr4, target4);
        System.out.println("\nAll pairs with sum " + target4 + ":");
        displayPairs(allPairs4, target4);
        
        System.out.println("\nUnique pairs (avoiding duplicates):");
        List<Pair> uniquePairs4 = findUniquePairsWithSum(arr4, target4);
        displayPairs(uniquePairs4, target4);
        
        // Test Case 5: Negative numbers
        System.out.println("\n\n--- Test Case 5: Array with Negative Numbers ---");
        int[] arr5 = {-4, -1, 0, 3, 5, 9};
        int target5 = 5;
        System.out.println("Array: " + Arrays.toString(arr5));
        displayArray(arr5);
        System.out.println("Target Sum: " + target5);
        
        List<Pair> allPairs5 = findAllPairsWithSum(arr5, target5);
        System.out.println("\nAll pairs with sum " + target5 + ":");
        displayPairs(allPairs5, target5);
        
        // Test Case 6: Zero sum
        System.out.println("\n\n--- Test Case 6: Zero Sum Target ---");
        int[] arr6 = {-3, 2, -1, 3, 1, -2};
        int target6 = 0;
        System.out.println("Array: " + Arrays.toString(arr6));
        displayArray(arr6);
        System.out.println("Target Sum: " + target6);
        
        List<Pair> allPairs6 = findAllPairsWithSum(arr6, target6);
        System.out.println("\nAll pairs with sum " + target6 + ":");
        displayPairs(allPairs6, target6);
        
        // Test Case 7: Single element
        System.out.println("\n\n--- Test Case 7: Single Element Array ---");
        int[] arr7 = {5};
        int target7 = 10;
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Target Sum: " + target7);
        System.out.println("Has pair? " + hasPairWithSum(arr7, target7));
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largeArr = new int[10000];
        Random rand = new Random(42);
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = rand.nextInt(20000) - 10000;
        }
        int largeTarget = 1000;
        
        long startTime = System.nanoTime();
        boolean optimizedResult = hasPairWithSum(largeArr, largeTarget);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        boolean bruteResult = hasPairWithSumBruteForce(largeArr, largeTarget);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largeArr.length);
        System.out.println("Target: " + largeTarget);
        System.out.println("Pair exists: " + optimizedResult);
        System.out.printf("Optimized (HashMap): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute Force: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
        System.out.println("Results match: " + (optimizedResult == bruteResult));
    }
}
