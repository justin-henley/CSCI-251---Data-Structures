
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
        root = null;
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
        // TODO: 2020-07-07  
    }
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
        // TODO: 2020-07-07  
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
        // TODO: 2020-07-07  
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data){
        // TODO: 2020-07-07  
    }
    
    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString(){
        return "(" + nodeTraversal(root) + ")";
    }

    /**
     * Traverses the subtree beginning from treeNode
     * @return A string representing the subtree rooted at treeNode
     */
    private String nodeTraversal(TreeNode<E> treeNode){
        // Base Case:  If the node is empty, return a blank character
        if(treeNode == null)
            return "-";
        // Else build the string recursively
        return treeNode.getData().toString() 
                + "(" + nodeTraversal(treeNode.getLeft())
                + ", " + nodeTraversal(treeNode.getRight()) + ")";
    }
    
    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false othewise
     */
    public boolean isEmpty(){
        // Tree is empty if root is null
        if (root == null)
            return true;
        else
            return false;
    }
    
    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height(){
        return getHeight(root);
    }

    /**
     *  recursively calculates the height of the subtree from the given node
     * @return the height of the subtree of the given node
     */
    private int getHeight(TreeNode<E> treeNode){
        // If treeNode is null, has reached beyond a leaf node. Returns -1
        if (treeNode == null)
            return -1;
        // Recursive calls to get left and right subtree heights
        int leftHeight = getHeight(treeNode.left);
        int rightHeight = getHeight(treeNode.right);
        // Returns the greater of the subtree heights + 1 for this level
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size(){
        return getSize(root);
    }

    /**
     * recursively traverse the tree and return the subtree size (number of nodes)
     * @return number of nodes in the subtree rooted at treeNode
     */
    private int getSize(TreeNode<E> treeNode){
        // If node is null, return 0
        if (treeNode == null)
            return 0;
        // Recursively visit each subtree
        int leftSize = getSize(treeNode.left);
        int rightSize = getSize(treeNode.right);
        // Return total size + current node
        return 1 + leftSize + rightSize;
    }
}
