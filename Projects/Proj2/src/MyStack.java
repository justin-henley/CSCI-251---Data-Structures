/** todo comments
 * class MyStack: A stack class implemented by using ArrayList
 * All stack elements are stored in an ArrayList. The top element
 * has index top
 * 
 * @author Your Name
 * @version Date
 */
import java.util.ArrayList;

public class MyStack<E>
{
    private ArrayList<E> list; // used to store elements in stack
    private int top; // the index of top element
    
    /** todo comments
     * constructor construct an empty stack
     */
    public MyStack()
    {
        top = 0;
    }
    
    /** todo comments
     * push push a given element on the top of the stack
     */
    public void push(E item)
    {
        // If list is empty, top should still be 0 after appending
        if (!list.isEmpty())
            top++;
        // Append the element to the end of the array
        list.add(item);
    }
    
    /** todo comments
     * isEmpty return true if the stack is empty; false otherwise
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    /** todo comments
     * peek Return the top element
     */
    public E peek()
    {
       return list.get(top);
    }
    
    /**  todo comments
     * pop Remove the top element from the stack. If the stack is empty,nothing happen
     */
    public void pop()
    {
        // If stack is empty, nothing happens
        if (isEmpty())
            return;
        // Otherwise, remove the top element
        list.remove(top);
        // Decrement top if list is not now empty
        if (top != 0)
            top--;
    }
    
    /** todo comments
     * size return the size of the stack
     * @return number of elements in stack
     */
    public int size()
    {
        return list.size();
    }
}
