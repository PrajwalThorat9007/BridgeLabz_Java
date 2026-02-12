package runtimeanalysis;

import java.util.*;

public class SearchComparison {
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static void testSearch(int size) {

        System.out.println("\nDataset Size: " + size);

        int[] arr = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill data
        for (int i = 0; i < size; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = size - 1; // worst-case for array

        // Array Search (O(N))
        long startArray = System.nanoTime();
        arraySearch(arr, target);
        long endArray = System.nanoTime();

        double arrayTime = (endArray - startArray) / 1_000_000.0;
        System.out.println("Array Search Time: " + arrayTime + " ms");

        // HashSet Search (O(1))
        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();

        double hashTime = (endHash - startHash) / 1_000_000.0;
        System.out.println("HashSet Search Time: " + hashTime + " ms");

        // TreeSet Search (O(log N))
        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();

        double treeTime = (endTree - startTree) / 1_000_000.0;
        System.out.println("TreeSet Search Time: " + treeTime + " ms");
    }

    public static void main(String[] args) {

        testSearch(1000);
        testSearch(100000);
        testSearch(1000000);
    }
}
