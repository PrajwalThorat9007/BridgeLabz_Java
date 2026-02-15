package collection.queue;

/*
 * Question 1: Reverse a Queue
 * Reverse the elements of a queue using only queue operations (e.g., add, remove, isEmpty).
 * Example: Input: [10, 20, 30] → Output: [30, 20, 10]
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    
    // Reverse queue using a stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Remove all elements from queue and push to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        
        // Pop all elements from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    
    // Reverse queue using recursion (only queue operations)
    public static void reverseQueueRecursive(Queue<Integer> queue) {
        // Base case: if queue is empty, return
        if (queue.isEmpty()) {
            return;
        }
        
        // Remove front element
        int front = queue.remove();
        
        // Reverse remaining queue
        reverseQueueRecursive(queue);
        
        // Add front element to back
        queue.add(front);
    }
    
    // Display queue contents without modifying it
    public static void displayQueue(Queue<Integer> queue) {
        System.out.print("[");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int element = queue.remove();
            System.out.print(element);
            if (i < size - 1) {
                System.out.print(", ");
            }
            queue.add(element);
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Test case 1: Using stack
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(10);
        queue1.add(20);
        queue1.add(30);
        
        System.out.println("Original Queue:");
        displayQueue(queue1);
        
        reverseQueue(queue1);
        
        System.out.println("Reversed Queue (using stack):");
        displayQueue(queue1);
        
        System.out.println();
        
        // Test case 2: Using recursion
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(100);
        queue2.add(200);
        queue2.add(300);
        queue2.add(400);
        
        System.out.println("Original Queue:");
        displayQueue(queue2);
        
        reverseQueueRecursive(queue2);
        
        System.out.println("Reversed Queue (recursive):");
        displayQueue(queue2);
    }
}
