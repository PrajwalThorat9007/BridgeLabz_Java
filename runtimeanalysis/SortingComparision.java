package runtimeanalysis;
import java.util.Random;

public class SortingComparision {
    // ==============================
    // Bubble Sort
    // ==============================
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // ==============================
    // Merge Sort
    // ==============================
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        while (i < n1)
            arr[k++] = leftArr[i++];

        while (j < n2)
            arr[k++] = rightArr[j++];
    }

    // ==============================
    // Quick Sort
    // ==============================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ==============================
    // Performance Test
    // ==============================
    public static void testSorting(int size) {

        Random random = new Random();
        int[] original = new int[size];

        for (int i = 0; i < size; i++) {
            original[i] = random.nextInt(size);
        }

        System.out.println("\nDataset Size: " + size);

        // Bubble Sort (only for small sizes)
        if (size <= 10000) {
            int[] bubbleArr = original.clone();
            long start = System.nanoTime();
            bubbleSort(bubbleArr);
            long end = System.nanoTime();
            System.out.println("Bubble Sort: " +
                    (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (Too Slow)");
        }

        // Merge Sort
        int[] mergeArr = original.clone();
        long startMerge = System.nanoTime();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort: " +
                (endMerge - startMerge) / 1_000_000.0 + " ms");

        // Quick Sort
        int[] quickArr = original.clone();
        long startQuick = System.nanoTime();
        quickSort(quickArr, 0, quickArr.length - 1);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort: " +
                (endQuick - startQuick) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {

        testSorting(1000);
        testSorting(10000);
        testSorting(1000000);
    }
}
