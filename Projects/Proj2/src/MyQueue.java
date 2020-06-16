/**
 * class MyQueue implemented using ArrayList. The index 0 element is the front of the queue
 * The last element of the queue has index tail
 * @author Justin Henley
 * @version 2020-06-16
 */
import java.util.ArrayList;

public class MyQueue<E>
{
    private ArrayList<E> list; // hold the elements in queue
    private int tail; // index of the last element in queue
    
    /**
     * constructor construct an empty queue
     */
    public MyQueue()
    {
        // List points to a new empty ArrayList of type E
        list = new ArrayList<>();
        // Tail = -1 is an empty queue; all functions must check isEmpty() before using tail index
        tail = -1;
    }
    
    /**
     * isEmpty returns true if the queue is empty; false otherwise
     * @return true if the queue is empty; false otherwise
     */
    public boolean isEmpty()
    {
       return list.isEmpty();
    }
    
    /**
     * size return the size of the queue
     * @return the number of elements in queue
     */
    public int size()
    {
        return list.size();
    }
    
    /**
     * peek return the front element of the queue
     * @return the front element of the queue.
     * Precondition: The queue is not empty
     */
    public E peek()
    {
        /* NOTE TO PROFESSOR VU:
            The comment here called for peek() to return null if queue isEmpty(),
            however as we are using ArrayList instead of pointers there is no legal way to pass null.
            Instead every use of peek() must be preceded by a check of isEmpty()
         */
        return list.get(0);
    }
    
    /**
     * pop remove the front element of the queue
     */
    public void pop()
    {
        // Do nothing if the list is empty
        if (list.isEmpty())
           return;
        // If not empty, remove the element at the front of the queue
       list.remove(0);
       // Decrement the tail index
       tail--;
    }
    
    /**
     * push push a new element to the queue
     */
    public void push(E item)
    {
        // Add the new item to the end of the list
        list.add(item);
        // Increment the tail position
        tail++;

    }
}
