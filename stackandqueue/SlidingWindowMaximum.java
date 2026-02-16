package stackandqueue;

import java.util.*;

/**
 * Problem 4: Sliding Window Maximum
 * Given an array and a window size k, find the maximum element in each sliding window of size k.
 */
public class SlidingWindowMaximum {
    
    /**
     * Find maximum in each sliding window using deque (optimized approach)
     * Time Complexity: O(n) where n is array length
     * Space Complexity: O(k) for deque
     * 
     * @param arr Input array
     * @param k Window size
     * @return Array of maximum values for each window
     */
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }
        
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Stores indices
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove indices of elements smaller than current element
            // (they won't be maximum for any future windows)
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            
            // Add current element index
            deque.offerLast(i);
            
            // The front of deque contains index of maximum for current window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * Brute force approach for comparison
     * Time Complexity: O(n*k)
     */
    public static int[] maxSlidingWindowBruteForce(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }
        
        int n = arr.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            result[i] = max;
        }
        
        return result;
    }
    
    /**
     * Display sliding windows with their maximum values
     */
    public static void displayWindows(int[] arr, int k, int[] result) {
        System.out.println("\n┌─────────┬─────────────────────────────┬─────────┐");
        System.out.println("│ Window  │         Elements            │   Max   │");
        System.out.println("├─────────┼─────────────────────────────┼─────────┤");
        
        for (int i = 0; i <= arr.length - k; i++) {
            System.out.printf("│   %-2d    │ [", (i + 1));
            for (int j = i; j < i + k; j++) {
                System.out.printf("%3d", arr[j]);
                if (j < i + k - 1) System.out.print(", ");
            }
            System.out.printf("]");
            int spaces = Math.max(0, 24 - (k * 5 - 1));
            System.out.print(" ".repeat(spaces));
            System.out.printf("│   %-5d │%n", result[i]);
        }
        
        System.out.println("└─────────┴─────────────────────────────┴─────────┘");
    }
    
    /**
     * Visualize sliding windows
     */
    public static void visualizeWindows(int[] arr, int k) {
        System.out.println("\nSliding Window Visualization:");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("─".repeat(60));
        
        for (int i = 0; i <= arr.length - k; i++) {
            System.out.print("Window " + (i + 1) + ": ");
            
            // Show position
            for (int j = 0; j < arr.length; j++) {
                if (j >= i && j < i + k) {
                    System.out.print("[" + arr[j] + "]");
                } else {
                    System.out.print(" " + arr[j] + " ");
                }
                if (j < arr.length - 1) System.out.print(" ");
            }
            
            // Find and display max
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.println(" → Max: " + max);
        }
        System.out.println("─".repeat(60));
    }
    
    /**
     * Display step-by-step deque operations
     */
    public static void displayDequeSteps(int[] arr, int k) {
        System.out.println("\nStep-by-Step Deque Operations:");
        System.out.println("─".repeat(70));
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nProcessing index " + i + " (value: " + arr[i] + ")");
            
            // Remove out of window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                int removed = deque.pollFirst();
                System.out.println("  → Removed index " + removed + " (out of window)");
            }
            
            // Remove smaller elements
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                int removed = deque.pollLast();
                System.out.println("  → Removed index " + removed + " (value " + arr[removed] + 
                                 " < " + arr[i] + ")");
            }
            
            // Add current
            deque.offerLast(i);
            System.out.println("  → Added index " + i);
            
            // Show deque state
            System.out.print("  → Deque: [");
            Iterator<Integer> it = deque.iterator();
            while (it.hasNext()) {
                int idx = it.next();
                System.out.print(idx + "→" + arr[idx]);
                if (it.hasNext()) System.out.print(", ");
            }
            System.out.println("]");
            
            // Show max if window is complete
            if (i >= k - 1) {
                System.out.println("  ✓ Window [" + (i - k + 1) + "-" + i + "] max: " + 
                                 arr[deque.peekFirst()]);
            }
        }
        System.out.println("─".repeat(70));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(15) + "SLIDING WINDOW MAXIMUM" + " ".repeat(21) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Standard example
        System.out.println("\n--- Test Case 1: Standard Example ---");
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Window size: " + k1);
        
        int[] result1 = maxSlidingWindow(arr1, k1);
        System.out.println("\nMaximums: " + Arrays.toString(result1));
        displayWindows(arr1, k1, result1);
        visualizeWindows(arr1, k1);
        
        // Test Case 2: Small window
        System.out.println("\n\n--- Test Case 2: Window Size 2 ---");
        int[] arr2 = {9, 7, 5, 3, 1, 8, 6, 4, 2};
        int k2 = 2;
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Window size: " + k2);
        
        int[] result2 = maxSlidingWindow(arr2, k2);
        System.out.println("\nMaximums: " + Arrays.toString(result2));
        displayWindows(arr2, k2, result2);
        
        // Test Case 3: Window size equals array length
        System.out.println("\n\n--- Test Case 3: Window = Array Length ---");
        int[] arr3 = {4, 2, 7, 1, 9, 3};
        int k3 = arr3.length;
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Window size: " + k3);
        
        int[] result3 = maxSlidingWindow(arr3, k3);
        System.out.println("\nMaximum: " + Arrays.toString(result3));
        System.out.println("Note: Only one window covering entire array!");
        
        // Test Case 4: Window size 1
        System.out.println("\n\n--- Test Case 4: Window Size 1 ---");
        int[] arr4 = {5, 3, 8, 2, 9};
        int k4 = 1;
        System.out.println("Array: " + Arrays.toString(arr4));
        System.out.println("Window size: " + k4);
        
        int[] result4 = maxSlidingWindow(arr4, k4);
        System.out.println("\nMaximums: " + Arrays.toString(result4));
        System.out.println("Note: Each element is its own window!");
        
        // Test Case 5: Increasing array
        System.out.println("\n\n--- Test Case 5: Increasing Array ---");
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        int k5 = 3;
        System.out.println("Array: " + Arrays.toString(arr5));
        System.out.println("Window size: " + k5);
        
        int[] result5 = maxSlidingWindow(arr5, k5);
        System.out.println("\nMaximums: " + Arrays.toString(result5));
        displayWindows(arr5, k5, result5);
        
        // Test Case 6: Decreasing array
        System.out.println("\n\n--- Test Case 6: Decreasing Array ---");
        int[] arr6 = {6, 5, 4, 3, 2, 1};
        int k6 = 3;
        System.out.println("Array: " + Arrays.toString(arr6));
        System.out.println("Window size: " + k6);
        
        int[] result6 = maxSlidingWindow(arr6, k6);
        System.out.println("\nMaximums: " + Arrays.toString(result6));
        displayWindows(arr6, k6, result6);
        
        // Test Case 7: Detailed step-by-step
        System.out.println("\n\n--- Test Case 7: Detailed Deque Operations ---");
        int[] arr7 = {4, 3, 5, 2, 6};
        int k7 = 3;
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Window size: " + k7);
        displayDequeSteps(arr7, k7);
        
        // Performance comparison
        System.out.println("\n\n--- Performance Comparison ---");
        int[] largeArr = new int[10000];
        Random rand = new Random(42);
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = rand.nextInt(10000);
        }
        int largeK = 100;
        
        long startTime = System.nanoTime();
        int[] resultOptimized = maxSlidingWindow(largeArr, largeK);
        long endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int[] resultBrute = maxSlidingWindowBruteForce(largeArr, largeK);
        endTime = System.nanoTime();
        long bruteTime = endTime - startTime;
        
        System.out.println("Array size: " + largeArr.length);
        System.out.println("Window size: " + largeK);
        System.out.printf("Optimized (Deque): %.3f ms%n", optimizedTime / 1_000_000.0);
        System.out.printf("Brute Force: %.3f ms%n", bruteTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / optimizedTime);
    }
}
