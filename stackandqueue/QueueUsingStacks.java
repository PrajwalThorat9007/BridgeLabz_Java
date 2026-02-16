package stackandqueue;

import java.util.*;

/**
 * Problem 1: Implement a Queue Using Stacks
 * Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
 */
public class QueueUsingStacks<T> {
    private Stack<T> stack1; // For enqueue operations
    private Stack<T> stack2; // For dequeue operations
    
    // Constructor
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /**
     * Enqueue operation - Add element to rear of queue
     * Time Complexity: O(1)
     */
    public void enqueue(T data) {
        stack1.push(data);
        System.out.println("Enqueued: " + data);
    }
    
    /**
     * Dequeue operation - Remove element from front of queue
     * Time Complexity: Amortized O(1)
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty - cannot dequeue");
        }
        
        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        T data = stack2.pop();
        System.out.println("Dequeued: " + data);
        return data;
    }
    
    /**
     * Peek operation - Get front element without removing
     * Time Complexity: Amortized O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty - cannot peek");
        }
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    /**
     * Check if queue is empty
     */
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    /**
     * Get size of queue
     */
    public int size() {
        return stack1.size() + stack2.size();
    }
    
    /**
     * Display queue contents from front to rear
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        
        // Display stack2 elements (front of queue)
        Stack<T> temp2 = new Stack<>();
        while (!stack2.isEmpty()) {
            temp2.push(stack2.pop());
        }
        while (!temp2.isEmpty()) {
            T item = temp2.pop();
            System.out.print(item + " ");
            stack2.push(item);
        }
        
        // Display stack1 elements (rear of queue)
        Stack<T> temp1 = new Stack<>();
        while (!stack1.isEmpty()) {
            temp1.push(stack1.pop());
        }
        Stack<T> temp3 = new Stack<>();
        while (!temp1.isEmpty()) {
            T item = temp1.pop();
            temp3.push(item);
            stack1.push(item);
        }
        while (!temp3.isEmpty()) {
            System.out.print(temp3.pop() + " ");
        }
        
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Queue Using Two Stacks Implementation ===\n");
        
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        
        // Test enqueue operations
        System.out.println("--- Enqueue Operations ---");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        System.out.println("\nQueue size: " + queue.size());
        queue.display();
        
        // Test peek operation
        System.out.println("\n--- Peek Operation ---");
        System.out.println("Front element: " + queue.peek());
        
        // Test dequeue operations
        System.out.println("\n--- Dequeue Operations ---");
        queue.dequeue();
        queue.dequeue();
        
        queue.display();
        
        // Mix enqueue and dequeue
        System.out.println("\n--- Mixed Operations ---");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();
        
        queue.dequeue();
        queue.display();
        
        System.out.println("\nFinal queue size: " + queue.size());
        
        // Test with String type
        System.out.println("\n\n=== Testing with String Type ===");
        QueueUsingStacks<String> stringQueue = new QueueUsingStacks<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        stringQueue.enqueue("Java");
        stringQueue.display();
        
        stringQueue.dequeue();
        stringQueue.display();
    }
}
