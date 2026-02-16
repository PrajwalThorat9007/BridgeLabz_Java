package hashmap;

import java.util.*;

/**
 * Problem 5: Two Sum Problem
 * Given an array and a target sum, find two indices such that their values add up to the target.
 */
public class TwoSumProblem {
    
    /**
     * Class to represent a solution (pair of indices)
     */
    static class Solution {
        int index1;
        int index2;
        int value1;
        int value2;
        
        public Solution(int index1, int index2, int value1, int value2) {
            this.index1 = index1;
            this.index2 = index2;
            this.value1 = value1;
            this.value2 = value2;
        }
        
        @Override
        public String toString() {
            return String.format("indices [%d, %d] with values (%d, %d)", 
                               index1, index2, value1, value2);
        }
    }
    
    /**
     * Find two indices that sum to target using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Input array
     * @param target Target sum
     * @return Array of two indices, or null if not found
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return null; // No solution found
    }
    
    /**
     * Find two indices with detailed solution
     * 
     * @param nums Input array
     * @param target Target sum
     * @return Solution object or null
     */
    public static Solution twoSumDetailed(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                int j = map.get(complement);
                return new Solution(j, i, nums[j], nums[i]);
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
    
    /**
     * Find all pairs of indices that sum to target
     * 
     * @param nums Input array
     * @param target Target sum
     * @return List of all solutions
     */
    public static List<Solution> twoSumAll(int[] nums, int target) {
        List<Solution> solutions = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // value -> list of indices
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                // Found complement(s)
                for (int j : map.get(complement)) {
                    solutions.add(new Solution(j, i, nums[j], nums[i]));
                }
            }
            
            // Add current index to map
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        return solutions;
    }
    
    /**
     * Brute force approach for comparison
     * Time Complexity: O(n^2)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    /**
     * Display array with indices
     */
    public static void displayArray(int[] nums) {
        System.out.print("Index:  ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%4d ", i);
        }
        System.out.println();
        
        System.out.print("Value:  ");
        for (int num : nums) {
            System.out.printf("%4d ", num);
        }
        System.out.println();
    }
    
    /**
     * Display solution
     */
    public static void displaySolution(int[] nums, int[] result, int target) {
        if (result == null) {
            System.out.println("✗ No solution found!");
            return;
        }
        
        System.out.println("\n┌──────────────────────────────────────────────┐");
        System.out.println("│              SOLUTION FOUND                  │");
        System.out.println("├──────────────────────────────────────────────┤");
        System.out.printf("│ Index 1:  %-2d                                │%n", result[0]);
        System.out.printf("│ Index 2:  %-2d                                │%n", result[1]);
        System.out.printf("│ Value 1:  %-4d                              │%n", nums[result[0]]);
        System.out.printf("│ Value 2:  %-4d                              │%n", nums[result[1]]);
        System.out.printf("│ Sum:      %-4d (Target: %-4d)              │%n", 
                        nums[result[0]] + nums[result[1]], target);
        System.out.println("└──────────────────────────────────────────────┘");
    }
    
    /**
     * Display all solutions
     */
    public static void displayAllSolutions(List<Solution> solutions, int target) {
        if (solutions.isEmpty()) {
            System.out.println("No solutions found!");
            return;
        }
        
        System.out.println("\n┌────────┬──────────────┬─────────────────┬─────────┐");
        System.out.println("│   #    │   Indices    │     Values      │   Sum   │");
        System.out.println("├────────┼──────────────┼─────────────────┼─────────┤");
        
        for (int i = 0; i < solutions.size(); i++) {
            Solution sol = solutions.get(i);
            System.out.printf("│   %-4d │   [%2d, %2d]   │  (%3d, %3d)     │   %3d   │%n",
                            (i + 1), sol.index1, sol.index2, 
                            sol.value1, sol.value2, sol.value1 + sol.value2);
        }
        
        System.out.println("└────────┴──────────────┴─────────────────┴─────────┘");
    }
    
    /**
     * Visualize the search process
     */
    public static void visualizeSearch(int[] nums, int target) {
        System.out.println("\nSearch Process Visualization:");
        System.out.println("─".repeat(70));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        System.out.println("Step | Index | Value | Complement | In Map? | Map State");
        System.out.println("─".repeat(70));
        
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int complement = target - value;
            boolean found = map.containsKey(complement);
            
            System.out.printf(" %-3d |  %-4d |  %-4d |    %-4d    |   %s   | ",
                            i, i, value, complement, found ? "YES" : "NO ");
            
            if (found) {
                System.out.printf("✓ FOUND at index %d%n", map.get(complement));
                break;
            } else {
                System.out.print(map.toString());
                map.put(value, i);
                System.out.println();
            }
        }
        
        System.out.println("─".repeat(70));
    }
    
    /**
     * Analyze the problem
     */
    public static void analyzeProblem(int[] nums, int target) {
        System.out.println("\nProblem Analysis:");
        System.out.println("─".repeat(60));
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Array length: " + nums.length);
        
        // Calculate statistics
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        double avg = Arrays.stream(nums).average().getAsAsDouble();
        
        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
        System.out.printf("Average: %.2f%n", avg);
        
        // Check if solution is possible
        if (target < min + min || target > max + max) {
            System.out.println("⚠ Warning: Target may be out of achievable range!");
        }
        
        System.out.println("─".repeat(60));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(19) + "TWO SUM PROBLEM" + " ".repeat(24) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Standard example
        System.out.println("\n--- Test Case 1: Standard Example ---");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        
        System.out.println("Array: " + Arrays.toString(nums1));
        displayArray(nums1);
        System.out.println("Target: " + target1);
        
        int[] result1 = twoSum(nums1, target1);
        displaySolution(nums1, result1, target1);
        
        visualizeSearch(nums1, target1);
        
        // Test Case 2: Multiple solutions
        System.out.println("\n\n--- Test Case 2: Multiple Solutions ---");
        int[] nums2 = {3, 3, 6, 4, 2};
        int target2 = 6;
        
        System.out.println("Array: " + Arrays.toString(nums2));
        displayArray(nums2);
        System.out.println("Target: " + target2);
        
        Solution detailed2 = twoSumDetailed(nums2, target2);
        if (detailed2 != null) {
            System.out.println("\nFirst solution found: " + detailed2);
        }
        
        List<Solution> allSolutions2 = twoSumAll(nums2, target2);
        System.out.println("\nAll solutions:");
        displayAllSolutions(allSolutions2, target2);
        
        // Test Case 3: No solution
        System.out.println("\n\n--- Test Case 3: No Solution ---");
        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 100;
        
        System.out.println("Array: " + Arrays.toString(nums3));
        displayArray(nums3);
        System.out.println("Target: " + target3);
        
        analyzeProblem(nums3, target3);
        
        int[] result3 = twoSum(nums3, target3);
        displaySolution(nums3, result3, target3);
        
        // Test Case 4: Negative numbers
        System.out.println("\n\n--- Test Case 4: Negative Numbers ---");
        int[] nums4 = {-3, 4, 3, 90};
        int target4 = 0;
        
        System.out.println("Array: " + Arrays.toString(nums4));
        displayArray(nums4);
        System.out.println("Target: " + target4);
        
        int[] result4 = twoSum(nums4, target4);
        displaySolution(nums4, result4, target4);
        
        visualizeSearch(nums4, target4);
        
        // Test Case 5: Duplicates
        System.out.println("\n\n--- Test Case 5: Array with Duplicates ---");
        int[] nums5 = {3, 2, 4, 3};
        int target5 = 6;
        
        System.out.println("Array: " + Arrays.toString(nums5));
        displayArray(nums5);
        System.out.println("Target: " + target5);
        
        List<Solution> allSolutions5 = twoSumAll(nums5, target5);
        System.out.println("\nAll solutions:");
        displayAllSolutions(allSolutions5, target5);
        
        // Test Case 6: Same element twice
        System.out.println("\n\n--- Test Case 6: Same Element Used Twice ---");
        int[] nums6 = {5, 5, 10, 15};
        int target6 = 10;
        
        System.out.println("Array: " + Arrays.toString(nums6));
        displayArray(nums6);
        System.out.println("Target: " + target6);
        System.out.println("Note: Looking for two different indices with value 5");
        
        int[] result6 = twoSum(nums6, target6);
        displaySolution(nums6, result6, target6);
        
        // Test Case 7: Large array
        System.out.println("\n\n--- Test Case 7: Larger Array ---");
        int[] nums7 = {1, 4, 45, 6, 10, -8, 23, 56, 78, 34, 12};
        int target7 = 16;
        
        System.out.println("Array: " + Arrays.toString(nums7));
        displayArray(nums7);
        System.out.println("Target: " + target7);
        
        int[] result7 = twoSum(nums7, target7);
        displaySolution(nums7, result7, target7);
        
        // Test Case 8: Two elements only
        System.out.println("\n\n--- Test Case 8: Two Elements Only ---");
        int[] nums8 = {3, 3};
        int target8 = 6;
        
        System.out.println("Array: " + Arrays.toString(nums8));
        displayArray(nums8);
        System.out.println("Target: " + target8);
        
        int[] result8 = twoSum(nums8, target8);
        displaySolution(nums8, result8, target8);
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largeNums = new int[10000];
        Random rand = new Random(42);
        for (int i = 0; i < largeNums.length; i++) {
            largeNums[i] = rand.nextInt(20000) - 10000;
        }
        int largeTarget = rand.nextInt(1000);
        
        long startTime = System.nanoTime();
        int[] optimizedResult = twoSum(largeNums, largeTarget);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int[] bruteResult = twoSumBruteForce(largeNums, largeTarget);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largeNums.length);
        System.out.println("Target: " + largeTarget);
        System.out.println("Solution found: " + (optimizedResult != null));
        System.out.printf("Optimized (HashMap): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute Force: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
        
        boolean resultsMatch = (optimizedResult == null && bruteResult == null) ||
                               (optimizedResult != null && bruteResult != null &&
                                Arrays.equals(optimizedResult, bruteResult));
        System.out.println("Results match: " + resultsMatch);
    }
}
