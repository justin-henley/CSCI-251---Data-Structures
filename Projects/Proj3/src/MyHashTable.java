
/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Hongbiao Zeng
 * @version Nov 27, 2015
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
        // Create the new table, set count to 0
        table = new ArrayList<MyHashEntry<K, V>>(tableSize);
        count = 0;

        // Each index gets a dummy node that points to null
        for (int i = 0; i < tableSize; i++) {
            MyHashEntry<K, V> newDummy = new MyHashEntry("dummy", "dummy");
            table.add(i, newDummy);
        }
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
        // Create a default 10-index table, set count to 0
        table = new ArrayList<MyHashEntry<K, V>>(10);
        count = 0;

        // Each index gets a dummy node that points to null
        for (int i = 0; i < 10; i++) {
            MyHashEntry<K, V> newDummy = new MyHashEntry("dummy", "dummy");
            table.add(i, newDummy);
        }
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return count;
    }
    
    /**
     * clear the table
     */
    public void clear(){
        // Repoint dummy nodes to null, emptying list
        for (MyHashEntry<K, V> node : table) {
            node.setNext(null);
        }
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
        // HASH PART
        int keyHash = stringHash(key, table.size());

        // Create a node to iterate through the key index
        MyHashEntry<K, V> currNode = table.get(keyHash);

        // SEARCH PART

        // Check that index for the key, iterating through until found or null
        while (currNode != null) {
            // If currNode matches the search key
            if (currNode.getKey().equals(key)) {
                return currNode.getValue();
            }
            else {
                currNode = currNode.getNext();
            }
        }
        // Dummy-only, or value not found
        return null;
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        // HASH PART
        int keyHash = stringHash(key, table.size());

        // Create a node to iterate through the key index
        MyHashEntry<K, V> currNode = table.get(keyHash);

        // INSERT PART
        // Note: all keys are unique, duplicate keys replace with new value
        // Demo program replaces duplicates this way

        // Iterate through list until null, attach new node at end
        while (currNode.getNext() != null) {
            // SPECIAL CASE:  Replaces the value of a duplicate key and returns early
            if (currNode.getNext().getKey().equals(key)) {
                // Replace the value at this key
                currNode.getNext().setValue(value);
                // Count does not change
                // Return early
                return;
            }

            // Regular case, iterates through the list until null or duplicate key
            currNode = currNode.getNext();
        }
        // If no duplicate found, attach node to end of list
        currNode.setNext(new MyHashEntry<>(key, value));

        // Increment count
        count++;
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        // HASH PART
        int keyHash = stringHash(key, table.size());

        // Create a node to iterate through the key index
        MyHashEntry<K, V> currNode = table.get(keyHash);

        // SEARCH AND REMOVAL

        // Check that index for the key, iterating through until found or null
        // Checking the node after currNode helps to ignore the dummy node, and
        //  is required to repoint previous node
        while (currNode.getNext() != null) {
            if (currNode.getNext().getKey().equals(key)) {
                // Save the node before removing
                MyHashEntry<K, V> foundNode = currNode.getNext();

                // Remove the node from the list by pointing current node to node-after-found
                currNode.setNext(foundNode.getNext());

                // Decrement count for removal
                count--;

                // Recast to V for compiler happiness and return found value
                return (V) foundNode.getValue();//foundValue;
            }
            else {
                currNode = currNode.getNext();
            }
        }
        // Dummy-only, or value not found
        return null;
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        if (count == 0)
            return true;
        else
            return false;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString(){
        // A string to hold whole list, newline between entries
        StringBuilder listString = new StringBuilder();

        // Loop over ArrayList
        for (int bucket = 0; bucket < table.size(); bucket++) {
            // Check if bucket is not empty
            MyHashEntry<K, V> currNode = table.get(bucket).next;

            // Begin line printing
            listString.append("Bucket " + bucket + " :");

            while (currNode != null) {
                // Loop over the linked list in each bucket, starting with node AFTER dummy
                // Store the entry as a formatted string
                String thisEntry = String.format(" %s", currNode.getValue());
                // Append the string to the StringBuilder
                listString.append(thisEntry);

                // Step to next node in list
                currNode = currNode.getNext();
            }

            // End line printing
            listString.append("\n");
        }

        //return the StringBuilder as a string
        return listString.toString();
    }

    /**
     * return a hash value for a given key and table size
     * Uses Multiplicative String Hash from book with Bernstein's hash function
     * @return a hash value for a given key and table size
     */
    private int stringHash(K key, int tableSize) {
        // cast key to string (should already be a string, but required for safety/ compiler happiness)
        String keyString = (String) key;
        // hash the key
        // Multiplicative String Hash
        long stringHash = 5381;
        int hashMultiplier = 33;

        for (char c : keyString.toCharArray()){
            stringHash = (stringHash * hashMultiplier) + c;
        }

        // table.size is safe to use because table is populated with dummy nodes, so table is never empty
        return (int) (stringHash % table.size());
    }
}