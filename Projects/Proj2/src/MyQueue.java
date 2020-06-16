/**
 * class MyQueue implemented using ArrayList. The index 0 element is the front of the queue
 * The last element of the queue has index tail
 * @author Your Name
 * @version Date
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
        tail = 0;
    }
    
    /**
     * isEmpty return true if the queue is empty; false otherwise
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
     * @return the front element of the queue. If the queue is empty, return null
     */
    public E peek()
    {
        if (list.isEmpty())
            return null;
        return list.get(0);
    }
    
    /**
     * pop remove the front element of the queue
     */
    public void pop()
    {
       if (list.isEmpty())
           return;
       list.remove(0);
       tail--;
    }
    
    /**
     * push push a new element to the queue
     */
    public void push(E item)
    {
        // If the list is empty before pushing, tail should still point to 0
        if (!list.isEmpty())
            tail++;
        // Append the item at the back of the queue array
        list.add(item);

    }
}
