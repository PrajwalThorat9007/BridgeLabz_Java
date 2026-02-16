package stackandqueue;

import java.util.*;

/**
 * Problem 2: Sort a Stack Using Recursion
 * Given a stack, sort its elements in ascending order using recursion.
 */
public class SortStackRecursion {
    
    /**
     * Main method to sort stack in ascending order (top = smallest)
     * Time Complexity: O(n^2) where n is number of elements
     * Space Complexity: O(n) for recursion stack
     */
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove top element
            int temp = stack.pop();
            
            // Sort remaining stack recursively
            sortStack(stack);
            
            // Insert the popped element back in sorted position
            insertSorted(stack, temp);
        }
    }
    
    /**
     * Helper method to insert element in sorted position
     * Maintains ascending order with smallest element at top
     */
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: if stack is empty or element is greater than top
        // (remember: we want smallest at top for ascending order)
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        
        // Remove top element
        int temp = stack.pop();
        
        // Recursively insert element
        insertSorted(stack, element);
        
        // Put back the removed element
        stack.push(temp);
    }
    
    /**
     * Display stack from top to bottom
     */
    public static void displayStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Stack<Integer> temp = new Stack<>();
        
        // Transfer to temp stack to preserve original
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        
        // Display and restore original stack
        while (!temp.isEmpty()) {
            int item = temp.pop();
            System.out.print(item + " ");
            stack.push(item);
        }
        System.out.println();
    }
    
    /**
     * Create a copy of stack
     */
    public static Stack<Integer> copyStack(Stack<Integer> original) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();
        
        while (!original.isEmpty()) {
            temp.push(original.pop());
        }
        
        while (!temp.isEmpty()) {
            int item = temp.pop();
            original.push(item);
            copy.push(item);
        }
        
        return copy;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Sort Stack Using Recursion ===\n");
        
        // Test Case 1: Random unsorted stack
        System.out.println("--- Test Case 1: Random Numbers ---");
        Stack<Integer> stack1 = new Stack<>();
        int[] values1 = {34, 3, 31, 98, 92, 23};
        
        System.out.print("Pushing elements: ");
        for (int val : values1) {
            stack1.push(val);
            System.out.print(val + " ");
        }
        System.out.println();
        
        System.out.println("\nBefore sorting:");
        displayStack(stack1);
        
        sortStack(stack1);
        
        System.out.println("\nAfter sorting (ascending - smallest at top):");
        displayStack(stack1);
        
        // Test Case 2: Already sorted stack
        System.out.println("\n\n--- Test Case 2: Already Sorted ---");
        Stack<Integer> stack2 = new Stack<>();
        int[] values2 = {5, 4, 3, 2, 1};
        
        for (int val : values2) {
            stack2.push(val);
        }
        
        System.out.println("Before sorting:");
        displayStack(stack2);
        
        sortStack(stack2);
        
        System.out.println("\nAfter sorting:");
        displayStack(stack2);
        
        // Test Case 3: Reverse sorted stack
        System.out.println("\n\n--- Test Case 3: Reverse Sorted ---");
        Stack<Integer> stack3 = new Stack<>();
        int[] values3 = {1, 2, 3, 4, 5};
        
        for (int val : values3) {
            stack3.push(val);
        }
        
        System.out.println("Before sorting:");
        displayStack(stack3);
        
        sortStack(stack3);
        
        System.out.println("\nAfter sorting:");
        displayStack(stack3);
        
        // Test Case 4: Stack with duplicates
        System.out.println("\n\n--- Test Case 4: With Duplicates ---");
        Stack<Integer> stack4 = new Stack<>();
        int[] values4 = {5, 3, 8, 3, 9, 1, 5};
        
        for (int val : values4) {
            stack4.push(val);
        }
        
        System.out.println("Before sorting:");
        displayStack(stack4);
        
        sortStack(stack4);
        
        System.out.println("\nAfter sorting:");
        displayStack(stack4);
        
        // Test Case 5: Single element
        System.out.println("\n\n--- Test Case 5: Single Element ---");
        Stack<Integer> stack5 = new Stack<>();
        stack5.push(42);
        
        System.out.println("Before sorting:");
        displayStack(stack5);
        
        sortStack(stack5);
        
        System.out.println("\nAfter sorting:");
        displayStack(stack5);
        
        // Test Case 6: Large stack
        System.out.println("\n\n--- Test Case 6: Larger Stack ---");
        Stack<Integer> stack6 = new Stack<>();
        int[] values6 = {100, 50, 75, 25, 90, 10, 60, 40, 80, 20};
        
        for (int val : values6) {
            stack6.push(val);
        }
        
        System.out.println("Before sorting:");
        displayStack(stack6);
        
        sortStack(stack6);
        
        System.out.println("\nAfter sorting:");
        displayStack(stack6);
    }
}
