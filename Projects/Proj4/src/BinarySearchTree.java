
/**
 * BinearySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 * 
 * @author Your Name
 * @version Date Starts
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    TreeNode<E> root; // the root of the tree
    
    /**
     * constructor create a empty binary search tree by setting root to be null
     */
    public BinarySearchTree(){
    }
    
    /**
     * search the given data in this binary search tree
     * If the data is found, return a reference to the tree node
     * othewise, return null
     * @param data The target to search
     * @return a TreeNode reference to the node that contains the data
     *         if no node contains data, return null
     */
    public TreeNode<E> search(E data){
    }
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data){
    }
    
    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString(){
    }
    
    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false othewise
     */
    public boolean isEmpty(){
    }
    
    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height(){
    }
    
    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size(){
    }
}
