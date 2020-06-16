/**
 * class MyStack: A stack class implemented by using ArrayList
 * All stack elements are stored in an ArrayList. The top element
 * has index top
 * 
 * @author Justin Henley
 * @version 2020-06-16
 */
import java.util.ArrayList;

public class MyStack<E>
{
    private ArrayList<E> list; // used to store elements in stack
    private int top; // the index of top element
    
    /**
     * constructor construct an empty stack
     */
    public MyStack()
    {
        // List points to a new empty ArrayList of type E
        list = new ArrayList<>();
        // Top = -1 is an empty stack; all functions must check isEmpty() before using top index
        top = -1;
    }
    
    /**
     * push push a given element on the top of the stack
     */
    public void push(E item)
    {
        // Append the element to the end of the array
        list.add(item);
        // Increment top
        top++;
    }
    
    /**
     * isEmpty return true if the stack is empty; false otherwise
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    /**
     * peek Return the top element
     * Precondition: The stack is not empty
     * Should be checked with isEmpty() before calling peek(),
     * calling peek() on an empty stack will cause an error
     */
    public E peek()
    {
       return list.get(top);
    }
    
    /**
     * pop Remove the top element from the stack. If the stack is empty,nothing happen
     */
    public void pop()
    {
        // If stack is empty, nothing happens
        if (isEmpty())
            return;
        // Otherwise, remove the top element
        list.remove(top);
        // Decrement top
        top--;
    }
    
    /**
     * size return the size of the stack
     * @return number of elements in stack
     */
    public int size()
    {
        return list.size();
    }
}
