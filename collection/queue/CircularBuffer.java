package collection.queue;

/*
 * Question 5: Circular Buffer Simulation
 * Implement a circular buffer (fixed-size queue) using an array-based queue.
 * When full, overwrite the oldest element.
 * Example: Buffer size=3: Insert 1, 2, 3 → Insert 4 → Buffer: [2, 3, 4]
 */

public class CircularBuffer {
    
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    // Constructor to initialize circular buffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    // Insert element into buffer (overwrites oldest if full)
    public void insert(int value) {
        if (isFull()) {
            // Overwrite oldest element
            front = (front + 1) % capacity;
            size--;
        }
        
        // Add new element
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        size++;
        
        System.out.println("Inserted: " + value);
        displayBuffer();
    }
    
    // Remove and return front element
    public Integer remove() {
        if (isEmpty()) {
            System.out.println("Buffer is empty!");
            return null;
        }
        
        int value = buffer[front];
        front = (front + 1) % capacity;
        size--;
        
        return value;
    }
    
    // Peek at front element without removing
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Buffer is empty!");
            return null;
        }
        return buffer[front];
    }
    
    // Check if buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if buffer is full
    public boolean isFull() {
        return size == capacity;
    }
    
    // Get current size
    public int getSize() {
        return size;
    }
    
    // Display current buffer contents
    public void displayBuffer() {
        if (isEmpty()) {
            System.out.println("Buffer: []");
            return;
        }
        
        System.out.print("Buffer: [");
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
            index = (index + 1) % capacity;
        }
        System.out.println("]");
    }
    
    // Get all elements as array
    public int[] toArray() {
        int[] result = new int[size];
        int index = front;
        for (int i = 0; i < size; i++) {
            result[i] = buffer[index];
            index = (index + 1) % capacity;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Circular Buffer Simulation ===\n");
        
        // Create circular buffer with capacity 3
        CircularBuffer buffer = new CircularBuffer(3);
        
        System.out.println("Buffer capacity: 3\n");
        
        // Insert elements
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        
        System.out.println("\nBuffer is full: " + buffer.isFull());
        
        // Insert when full (overwrites oldest)
        System.out.println("\nInserting 4 (buffer full, oldest will be overwritten):");
        buffer.insert(4);
        
        System.out.println("\nInserting 5:");
        buffer.insert(5);
        
        System.out.println("\n=== Remove Operations ===\n");
        
        // Remove elements
        System.out.println("Removed: " + buffer.remove());
        buffer.displayBuffer();
        
        System.out.println("Removed: " + buffer.remove());
        buffer.displayBuffer();
        
        // Insert more elements
        System.out.println("\nInserting 6 and 7:");
        buffer.insert(6);
        buffer.insert(7);
        
        System.out.println("\n=== Final State ===");
        System.out.println("Front element: " + buffer.peek());
        System.out.println("Buffer size: " + buffer.getSize());
        buffer.displayBuffer();
        
        // Test with larger buffer
        System.out.println("\n=== Test with Capacity 5 ===\n");
        CircularBuffer buffer2 = new CircularBuffer(5);
        
        for (int i = 1; i <= 7; i++) {
            buffer2.insert(i * 10);
        }
    }
}
