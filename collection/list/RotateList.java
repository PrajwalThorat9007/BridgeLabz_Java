package collection.list;

/*
 * Question 3: Rotate Elements in a List
 * Rotate the elements of a list by a given number of positions.
 * Example: Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20]
 */

import java.util.ArrayList;
import java.util.List;

public class RotateList {

    // Rotate list elements to the left by k positions
    public static <T> void rotateLeft(List<T> list, int k) {
        int size = list.size();

        // Handle edge cases
        if (size == 0 || k == 0) {
            return;
        }

        // Normalize k to be within list size
        k = k % size;

        // Rotate by removing first k elements and adding them to the end
        for (int i = 0; i < k; i++) {
            T element = list.remove(0);
            list.add(element);
        }
    }

    // Alternative efficient approach using reversal algorithm
    public static <T> void rotateLeftEfficient(ArrayList<T> list, int k) {
        int size = list.size();

        // Handle edge cases
        if (size == 0 || k == 0) {
            return;
        }

        // Normalize k
        k = k % size;

        // Reverse first k elements
        reverse(list, 0, k - 1);
        // Reverse remaining elements
        reverse(list, k, size - 1);
        // Reverse entire list
        reverse(list, 0, size - 1);
    }

    // Helper method to reverse a portion of the list
    private static <T> void reverse(ArrayList<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test rotation
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original List: " + numbers);
        rotateLeft(numbers, 2);
        System.out.println("After rotating by 2 positions: " + numbers);

        System.out.println();

        // Test with different rotation
        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        System.out.println("Original List: " + letters);
        rotateLeftEfficient(letters, 3);
        System.out.println("After rotating by 3 positions: " + letters);
    }
}