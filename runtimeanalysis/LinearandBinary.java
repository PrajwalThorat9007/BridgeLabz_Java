package runtimeanalysis;
import java.util.Random;
import java.util.Arrays;


public class LinearandBinary {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // Method to test performance
    public static void testPerformance(int size) {

        Random random = new Random();
        int[] arr = new int[size];

        // Fill array with random numbers
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }

        int target = arr[size - 1]; // Worst case for linear search

        System.out.println("\nDataset Size: " + size);

        // ---------------------------
        // Linear Search Timing
        // ---------------------------
        long startLinear = System.nanoTime();
        linearSearch(arr, target);
        long endLinear = System.nanoTime();

        double linearTime = (endLinear - startLinear) / 1_000_000.0;

        // ---------------------------
        // Sorting for Binary Search
        // ---------------------------
        long sortStart = System.nanoTime();
        Arrays.sort(arr);
        long sortEnd = System.nanoTime();

        double sortTime = (sortEnd - sortStart) / 1_000_000.0;

        // ---------------------------
        // Binary Search Timing
        // ---------------------------
        long startBinary = System.nanoTime();
        binarySearch(arr, target);
        long endBinary = System.nanoTime();

        double binaryTime = (endBinary - startBinary) / 1_000_000.0;

        System.out.println("Linear Search Time: " + linearTime + " ms");
        System.out.println("Sorting Time (O(N log N)): " + sortTime + " ms");
        System.out.println("Binary Search Time: " + binaryTime + " ms");
    }

    public static void main(String[] args) {

        testPerformance(1000);
        testPerformance(10000);
        testPerformance(1000000);
    }
}
