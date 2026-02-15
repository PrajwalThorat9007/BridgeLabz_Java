package collection.queue;

/*
 * Question 2: Generate Binary Numbers Using a Queue
 * Generate the first N binary numbers (as strings) using a queue.
 * Example: N=5 → Output: ["1", "10", "11", "100", "101"]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryNumberGenerator {
    
    // Generate first N binary numbers using queue
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        
        if (n <= 0) {
            return result;
        }
        
        Queue<String> queue = new LinkedList<>();
        
        // Start with "1"
        queue.add("1");
        
        // Generate N binary numbers
        for (int i = 0; i < n; i++) {
            // Remove front of queue
            String current = queue.remove();
            result.add(current);
            
            // Append "0" and "1" to current and add back to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return result;
    }
    
    // Alternative approach with detailed explanation
    public static List<String> generateBinaryNumbersVerbose(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        // Enqueue the first binary number
        queue.add("1");
        
        while (result.size() < n) {
            // Dequeue and add to result
            String front = queue.remove();
            result.add(front);
            
            // Generate next two binary numbers by appending 0 and 1
            String n1 = front + "0";
            String n2 = front + "1";
            
            // Enqueue the generated numbers
            queue.add(n1);
            queue.add(n2);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int n1 = 5;
        System.out.println("First " + n1 + " binary numbers:");
        List<String> binary1 = generateBinaryNumbers(n1);
        System.out.println(binary1);
        
        System.out.println();
        
        // Test case 2
        int n2 = 10;
        System.out.println("First " + n2 + " binary numbers:");
        List<String> binary2 = generateBinaryNumbers(n2);
        System.out.println(binary2);
        
        System.out.println();
        
        // Test case 3: Show pattern
        int n3 = 15;
        System.out.println("First " + n3 + " binary numbers (verbose):");
        List<String> binary3 = generateBinaryNumbersVerbose(n3);
        for (int i = 0; i < binary3.size(); i++) {
            System.out.println((i + 1) + " in binary: " + binary3.get(i));
        }
    }
}
