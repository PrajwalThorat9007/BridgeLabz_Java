package collection.list;

/*
 * Question 4: Remove Duplicates While Preserving Order
 * Remove duplicate elements from a list while maintaining the original order of elements.
 * Example: Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    // Remove duplicates using LinkedHashSet (maintains insertion order)
    public static <T> List<T> removeDuplicates(List<T> list) {
        // LinkedHashSet maintains insertion order and removes duplicates
        Set<T> uniqueElements = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueElements);
    }

    // Remove duplicates in-place without extra collection
    public static <T> void removeDuplicatesInPlace(List<T> list) {
        Set<T> seen = new HashSet<>();

        // Iterate and remove duplicates
        for (int i = 0; i < list.size(); i++) {
            if (seen.contains(list.get(i))) {
                list.remove(i);
                i--; // Adjust index after removal
            } else {
                seen.add(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // Test with integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Original List: " + numbers);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("After removing duplicates: " + uniqueNumbers);

        System.out.println();

        // Test in-place removal
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("hello");
        words.add("java");
        words.add("world");
        words.add("java");
        words.add("code");

        System.out.println("Original List: " + words);
        removeDuplicatesInPlace(words);
        System.out.println("After in-place removal: " + words);
    }
}