package hashmap;

import java.util.*;

/**
 * Problem 4: Implement a Custom Hash Map
 * Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
 * Uses separate chaining for collision handling.
 */
public class CustomHashMap<K, V> {
    
    /**
     * Entry class to store key-value pairs
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // For chaining
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    
    private Entry<K, V>[] buckets;
    private int size;
    private int capacity;
    
    /**
     * Constructor with default capacity
     */
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }
    
    /**
     * Constructor with custom capacity
     */
    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }
    
    /**
     * Hash function to get bucket index
     */
    private int getBucketIndex(K key) {
        if (key == null) {
            return 0; // Store null keys at index 0
        }
        
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }
    
    /**
     * Put key-value pair into the map
     * Time Complexity: O(1) average, O(n) worst case
     */
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = buckets[bucketIndex];
        
        // Check if key already exists
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.key == null) || 
                (key != null && key.equals(current.key))) {
                // Key exists, update value
                current.value = value;
                return;
            }
            current = current.next;
        }
        
        // Key doesn't exist, add new entry at the beginning
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        buckets[bucketIndex] = newEntry;
        size++;
        
        // Check if rehashing is needed
        if ((double) size / capacity >= LOAD_FACTOR) {
            rehash();
        }
    }
    
    /**
     * Get value associated with key
     * Time Complexity: O(1) average, O(n) worst case
     */
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = buckets[bucketIndex];
        
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.key == null) || 
                (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        
        return null; // Key not found
    }
    
    /**
     * Remove key-value pair from map
     * Time Complexity: O(1) average, O(n) worst case
     */
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = buckets[bucketIndex];
        
        if (head == null) {
            return null; // Empty bucket
        }
        
        // Check if head needs to be removed
        if ((key == null && head.key == null) || 
            (key != null && key.equals(head.key))) {
            buckets[bucketIndex] = head.next;
            size--;
            return head.value;
        }
        
        // Search in the chain
        Entry<K, V> prev = head;
        Entry<K, V> current = head.next;
        
        while (current != null) {
            if ((key == null && current.key == null) || 
                (key != null && key.equals(current.key))) {
                prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        
        return null; // Key not found
    }
    
    /**
     * Check if key exists in map
     */
    public boolean containsKey(K key) {
        return get(key) != null || (get(key) == null && keyExistsWithNullValue(key));
    }
    
    /**
     * Helper method to check if key exists with null value
     */
    private boolean keyExistsWithNullValue(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> current = buckets[bucketIndex];
        
        while (current != null) {
            if ((key == null && current.key == null) || 
                (key != null && key.equals(current.key))) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Check if value exists in map
     */
    public boolean containsValue(V value) {
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                if ((value == null && current.value == null) || 
                    (value != null && value.equals(current.value))) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    
    /**
     * Get current size of map
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if map is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Clear all entries from map
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Entry[capacity];
        size = 0;
    }
    
    /**
     * Get all keys in the map
     */
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        
        return keys;
    }
    
    /**
     * Get all values in the map
     */
    public List<V> values() {
        List<V> valuesList = new ArrayList<>();
        
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                valuesList.add(current.value);
                current = current.next;
            }
        }
        
        return valuesList;
    }
    
    /**
     * Get all entries in the map
     */
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                entries.add(new AbstractMap.SimpleEntry<>(current.key, current.value));
                current = current.next;
            }
        }
        
        return entries;
    }
    
    /**
     * Rehash the map when load factor is exceeded
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        System.out.println("Rehashing... Old capacity: " + capacity + ", New capacity: " + (capacity * 2));
        
        Entry<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Entry[capacity];
        size = 0;
        
        // Reinsert all entries
        for (Entry<K, V> head : oldBuckets) {
            Entry<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    /**
     * Display the internal structure of the hash map
     */
    public void displayStructure() {
        System.out.println("\n=== Hash Map Structure ===");
        System.out.println("Capacity: " + capacity);
        System.out.println("Size: " + size);
        System.out.println("Load Factor: " + String.format("%.2f", (double) size / capacity));
        System.out.println("\nBucket Distribution:");
        System.out.println("─".repeat(60));
        
        int emptyBuckets = 0;
        int maxChainLength = 0;
        
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> head = buckets[i];
            
            if (head == null) {
                emptyBuckets++;
                continue;
            }
            
            System.out.printf("Bucket %3d: ", i);
            
            Entry<K, V> current = head;
            int chainLength = 0;
            
            while (current != null) {
                System.out.print("[" + current + "]");
                if (current.next != null) {
                    System.out.print(" → ");
                }
                current = current.next;
                chainLength++;
            }
            
            maxChainLength = Math.max(maxChainLength, chainLength);
            System.out.println();
        }
        
        System.out.println("─".repeat(60));
        System.out.println("Statistics:");
        System.out.println("  Empty buckets: " + emptyBuckets);
        System.out.println("  Used buckets: " + (capacity - emptyBuckets));
        System.out.println("  Max chain length: " + maxChainLength);
        System.out.println("  Average chain length: " + 
                         String.format("%.2f", (double) size / (capacity - emptyBuckets)));
    }
    
    /**
     * Display all key-value pairs
     */
    public void displayAll() {
        System.out.println("\nAll Key-Value Pairs:");
        System.out.println("─".repeat(40));
        
        if (isEmpty()) {
            System.out.println("Map is empty!");
            return;
        }
        
        for (Map.Entry<K, V> entry : entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
        
        System.out.println("─".repeat(40));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        
        sb.append("}");
        return sb.toString();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(15) + "CUSTOM HASH MAP" + " ".repeat(28) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        
        // Test Case 1: Basic operations
        System.out.println("\n--- Test Case 1: Basic Put and Get Operations ---");
        CustomHashMap<String, Integer> map1 = new CustomHashMap<>(8);
        
        System.out.println("\nAdding entries:");
        map1.put("apple", 5);
        System.out.println("put('apple', 5)");
        map1.put("banana", 3);
        System.out.println("put('banana', 3)");
        map1.put("orange", 7);
        System.out.println("put('orange', 7)");
        map1.put("grape", 2);
        System.out.println("put('grape', 2)");
        
        System.out.println("\nMap: " + map1);
        System.out.println("Size: " + map1.size());
        
        System.out.println("\nRetrieving values:");
        System.out.println("get('apple') = " + map1.get("apple"));
        System.out.println("get('banana') = " + map1.get("banana"));
        System.out.println("get('mango') = " + map1.get("mango"));
        
        map1.displayStructure();
        
        // Test Case 2: Update existing key
        System.out.println("\n\n--- Test Case 2: Update Existing Key ---");
        System.out.println("Current value of 'apple': " + map1.get("apple"));
        map1.put("apple", 10);
        System.out.println("After put('apple', 10): " + map1.get("apple"));
        System.out.println("Size (should remain same): " + map1.size());
        
        // Test Case 3: Remove operations
        System.out.println("\n\n--- Test Case 3: Remove Operations ---");
        System.out.println("Before removal: " + map1);
        
        Integer removed = map1.remove("banana");
        System.out.println("\nRemoved 'banana': " + removed);
        System.out.println("After removal: " + map1);
        System.out.println("Size: " + map1.size());
        
        System.out.println("\nTrying to get removed key:");
        System.out.println("get('banana') = " + map1.get("banana"));
        
        // Test Case 4: ContainsKey and ContainsValue
        System.out.println("\n\n--- Test Case 4: Contains Operations ---");
        System.out.println("containsKey('apple'): " + map1.containsKey("apple"));
        System.out.println("containsKey('banana'): " + map1.containsKey("banana"));
        System.out.println("containsValue(7): " + map1.containsValue(7));
        System.out.println("containsValue(100): " + map1.containsValue(100));
        
        // Test Case 5: KeySet, Values, EntrySet
        System.out.println("\n\n--- Test Case 5: Collection Views ---");
        System.out.println("Keys: " + map1.keySet());
        System.out.println("Values: " + map1.values());
        System.out.println("Entries: " + map1.entrySet());
        
        // Test Case 6: Rehashing
        System.out.println("\n\n--- Test Case 6: Rehashing Demonstration ---");
        CustomHashMap<Integer, String> map2 = new CustomHashMap<>(4);
        
        System.out.println("Adding entries to trigger rehashing:");
        for (int i = 1; i <= 10; i++) {
            map2.put(i, "Value" + i);
            System.out.println("Added: " + i + " → Value" + i + 
                             " (Size: " + map2.size() + ")");
        }
        
        map2.displayStructure();
        
        // Test Case 7: Null key and value
        System.out.println("\n\n--- Test Case 7: Null Key and Value ---");
        CustomHashMap<String, String> map3 = new CustomHashMap<>();
        
        map3.put(null, "nullValue");
        map3.put("key1", null);
        map3.put("key2", "value2");
        
        System.out.println("Map: " + map3);
        System.out.println("get(null) = " + map3.get(null));
        System.out.println("get('key1') = " + map3.get("key1"));
        System.out.println("containsKey(null): " + map3.containsKey(null));
        
        // Test Case 8: Clear operation
        System.out.println("\n\n--- Test Case 8: Clear Operation ---");
        System.out.println("Before clear - Size: " + map1.size());
        System.out.println("Before clear - isEmpty: " + map1.isEmpty());
        
        map1.clear();
        
        System.out.println("After clear - Size: " + map1.size());
        System.out.println("After clear - isEmpty: " + map1.isEmpty());
        System.out.println("After clear - Map: " + map1);
        
        // Test Case 9: Collision handling
        System.out.println("\n\n--- Test Case 9: Collision Handling ---");
        CustomHashMap<CollisionKey, String> map4 = new CustomHashMap<>(4);
        
        // Create keys that will collide
        CollisionKey key1 = new CollisionKey(1);
        CollisionKey key2 = new CollisionKey(5); // Same hash as key1 (mod 4)
        CollisionKey key3 = new CollisionKey(9); // Same hash as key1 (mod 4)
        
        map4.put(key1, "First");
        map4.put(key2, "Second");
        map4.put(key3, "Third");
        
        System.out.println("Added 3 keys with same bucket index:");
        map4.displayStructure();
        map4.displayAll();
    }
    
    /**
     * Helper class for collision testing
     */
    static class CollisionKey {
        int value;
        
        CollisionKey(int value) {
            this.value = value;
        }
        
        @Override
        public int hashCode() {
            return value;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            CollisionKey other = (CollisionKey) obj;
            return value == other.value;
        }
        
        @Override
        public String toString() {
            return "Key(" + value + ")";
        }
    }
}
