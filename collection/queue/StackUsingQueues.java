package collection.queue;

/*
 * Question 4: Implement a Stack Using Queues
 * Implement a stack data structure using two queues and support push, pop, and top operations.
 * Example: Push 1, 2, 3 → Pop → Output: 3
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    
    // Stack implementation using two queues
    static class StackWithTwoQueues {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        
        public StackWithTwoQueues() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }
        
        // Push element onto stack (O(1))
        public void push(int value) {
            queue1.add(value);
            System.out.println("Pushed: " + value);
        }
        
        // Pop element from stack (O(n))
        public Integer pop() {
            if (queue1.isEmpty()) {
                System.out.println("Stack is empty!");
                return null;
            }
            
            // Move all elements except last to queue2
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            
            // Remove and return the last element
            int popped = queue1.remove();
            
            // Swap queue1 and queue2
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            
            return popped;
        }
        
        // Get top element without removing (O(n))
        public Integer top() {
            if (queue1.isEmpty()) {
                System.out.println("Stack is empty!");
                return null;
            }
            
            // Move all elements except last to queue2
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            
            // Peek the last element
            int topElement = queue1.peek();
            
            // Move the last element to queue2
            queue2.add(queue1.remove());
            
            // Swap queue1 and queue2
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            
            return topElement;
        }
        
        // Check if stack is empty
        public boolean isEmpty() {
            return queue1.isEmpty();
        }
        
        // Get size of stack
        public int size() {
            return queue1.size();
        }
    }
    
    // Alternative: Stack using single queue (push is O(n), pop is O(1))
    static class StackWithOneQueue {
        private Queue<Integer> queue;
        
        public StackWithOneQueue() {
            queue = new LinkedList<>();
        }
        
        // Push element and rotate queue (O(n))
        public void push(int value) {
            int size = queue.size();
            queue.add(value);
            
            // Rotate the queue to make new element at front
            for (int i = 0; i < size; i++) {
                queue.add(queue.remove());
            }
            
            System.out.println("Pushed: " + value);
        }
        
        // Pop element from front (O(1))
        public Integer pop() {
            if (queue.isEmpty()) {
                System.out.println("Stack is empty!");
                return null;
            }
            return queue.remove();
        }
        
        // Get top element (O(1))
        public Integer top() {
            if (queue.isEmpty()) {
                System.out.println("Stack is empty!");
                return null;
            }
            return queue.peek();
        }
        
        // Check if stack is empty
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Stack Using Two Queues ===\n");
        
        StackWithTwoQueues stack1 = new StackWithTwoQueues();
        
        // Push elements
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        
        System.out.println("\nTop element: " + stack1.top());
        System.out.println("Stack size: " + stack1.size());
        
        // Pop elements
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stack1.pop());
        System.out.println("Popped: " + stack1.pop());
        
        System.out.println("\nTop element: " + stack1.top());
        
        stack1.push(4);
        System.out.println("Top element: " + stack1.top());
        
        System.out.println("\n=== Stack Using One Queue ===\n");
        
        StackWithOneQueue stack2 = new StackWithOneQueue();
        
        // Push elements
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        
        System.out.println("\nTop element: " + stack2.top());
        
        // Pop elements
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stack2.pop());
        System.out.println("Popped: " + stack2.pop());
        System.out.println("Popped: " + stack2.pop());
        System.out.println("Is empty: " + stack2.isEmpty());
    }
}
