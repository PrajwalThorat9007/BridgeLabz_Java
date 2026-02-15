package collection.list;

/*
 * Question 1: Reverse a List
 * Write a program to reverse the elements of a given List without using built-in reverse methods.
 * Implement it for both ArrayList and LinkedList.
 * Example: Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    // Reverse ArrayList using two-pointer approach
    public static <T> void reverseArrayList(ArrayList<T> list) {
        int left = 0;
        int right = list.size() - 1;

        // Swap elements from both ends moving towards center
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Reverse LinkedList using iterative approach
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int size = list.size();

        // Remove from end and add to beginning
        for (int i = 0; i < size - 1; i++) {
            T element = list.removeLast();
            list.add(i, element);
        }
    }

    public static void main(String[] args) {
        // Test with ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        System.out.println();

        // Test with LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original LinkedList: " + linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}