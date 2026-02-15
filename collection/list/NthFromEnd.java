package collection.list;

/*
 * Question 5: Find the Nth Element from the End
 * Given a singly linked list (use LinkedList), find the Nth element from the end
 * without calculating its size.
 * Example: Input: [A, B, C, D, E], N=2 → Output: D
 */

import java.util.LinkedList;

public class NthFromEnd {

    // Find Nth element from end using two-pointer technique
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        // Handle edge cases
        if (list.isEmpty() || n <= 0) {
            return null;
        }

        // Use two pointers with gap of n
        int index1 = 0;
        int index2 = 0;

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            index2++;
            if (index2 >= list.size()) {
                return null; // N is greater than list size
            }
        }

        // Move both pointers until second reaches end
        while (index2 < list.size()) {
            index1++;
            index2++;
        }

        return list.get(index1);
    }

    // Alternative approach using iterator-based two-pointer
    public static <T> T findNthFromEndIterator(LinkedList<T> list, int n) {
        if (list.isEmpty() || n <= 0) {
            return null;
        }

        // Create two references
        T result = null;
        int count = 0;

        // Single pass through the list
        for (T element : list) {
            count++;

            // Start tracking result after n elements
            if (count > n) {
                if (result == null) {
                    result = list.get(count - n - 1);
                } else {
                    result = list.get(count - n - 1);
                }
            }
        }

        // Check if n is valid
        if (count < n) {
            return null;
        }

        return list.get(count - n);
    }

    public static void main(String[] args) {
        // Test with character list
        LinkedList<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        System.out.println("LinkedList: " + letters);
        System.out.println("2nd element from end: " + findNthFromEnd(letters, 2));
        System.out.println("1st element from end: " + findNthFromEnd(letters, 1));
        System.out.println("5th element from end: " + findNthFromEnd(letters, 5));

        System.out.println();

        // Test with numbers
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);

        System.out.println("LinkedList: " + numbers);
        System.out.println("3rd element from end: " + findNthFromEndIterator(numbers, 3));
        System.out.println("6th element from end: " + findNthFromEndIterator(numbers, 6));

        // Test edge cases
        System.out.println("\nEdge cases:");
        System.out.println("7th element from end (invalid): " + findNthFromEnd(numbers, 7));
        System.out.println("0th element from end (invalid): " + findNthFromEnd(numbers, 0));
    }
}