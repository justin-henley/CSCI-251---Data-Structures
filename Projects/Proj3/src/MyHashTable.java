
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
        // TODO: 2020-06-29
        table = new ArrayList<MyHashEntry<K, V>>(tableSize);
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
        // TODO: 2020-06-29
        table = new ArrayList<MyHashEntry<K, V>>(10);
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
        // TODO: 2020-06-29  
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
        // TODO: 2020-06-29  
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        // TODO: 2020-06-29  
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        // TODO: 2020-06-29  
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
        // TODO: 2020-06-29

        // A string to hold whole list, newline between entries
        String listString = "";

        // Loop over ArrayList
        for (MyHashEntry bucket : table) {
            // Check if bucket is empty

            // Loop over the linked list in each bucket

                // Check if empty, else return and step thru list until null

        }

        //return the string
        return listString;
    }
}
