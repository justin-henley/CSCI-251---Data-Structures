
/**
 * BinarySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 * 
 * @author Justin Henley, jahenley@mail.fhsu.edu, FHSU U2020_CSCI_251_VA
 * @version 2020/07/07
 */
public class BinarySearchTree<E extends Comparable<E> >
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
        // Set an iterator node to root for traversal
        TreeNode<E> cur = root;

        // Traverse tree towards target value
        while (cur != null){
            // Fix because E extends Comparable<E>
            int comparison = data.compareTo(cur.getData());
            if (comparison == 0)
                return cur;  // Found target
            else if (comparison < 0)
                cur = cur.getLeft(); // Search left subtree
            else
                cur = cur.getRight();  // Search right subtree
        }
        return null;  // Not found
    }
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
        // If the tree is empty, insert newNode as root
        if (root == null){
            root = newNode;
            return;  // Finished with insert
        }

        // If tree is not empty, find the insertion position
        // Create a traversal node, starting at the root of the tree
        TreeNode<E> cur = root;
        // While there is still tree to search, continue searching
        while (cur != null) {
            // If the newNode's data is less than the cur's data
            if (newNode.getData().compareTo(cur.getData()) < 0){
                // If the left child is empty, insert the new node here
                if (cur.getLeft() == null) {
                    cur.setLeft(newNode);
                    newNode.setParent(cur);
                    cur = null;  // Allows while loop to exit
                }
                // If the left child is not empty, continue traversal at left child
                else
                    cur = cur.getLeft();
            }
            // If the newNode's data is greater than cur's data
            else {
                // If the right child is empty, insert the new node here
                if (cur.getRight() == null) {
                    cur.setRight(newNode);
                    newNode.setParent(cur);
                    cur = null;  // Allows while loop to exit
                }
                // If the right child is not empty, continue traversal at right child
                else
                    cur = cur.getRight();
            }
        }
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
        // Create the new node
        TreeNode<E> newNode = new TreeNode<>(data);

        // Call insert(node) function with the new node
        insert(newNode);
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     * Requires private functions removeNode, replaceChild
     */
    public boolean remove(E data){
        // Find the target node containing the data
        TreeNode<E> node = search(data);
        // Remove the found node (If not found, removes null which does nothing)
        // If the node is removed successfully, removeNode returns true
        return removeNode(node);
    }

    /**
     * Recursively finds and removes the target node
     * Returns true if the node is removed successfully, false otherwise
     */
    private boolean removeNode(TreeNode<E> node) {
        // If node is null, return false (did not remove)
        if (node == null)
            return false;

        // Case 1: Internal node with 2 children
        if (node.getLeft() != null && node.getRight() != null){
            // Find successor
            TreeNode<E> succNode = node.getRight();
            while (succNode.getLeft() != null)
                succNode = succNode.getLeft();

            // Copy data from succNode to node
            node.setData(succNode.getData());

            // Recursively remove succNode
            return removeNode(succNode);  // Since succNode is known to not be null, will return true
        }

        // Case 2: Root node (with 1 or 0 children)
        else if (node == root){
            // If there is a left child, it becomes the root
            if (node.getLeft() != null)
                root = node.getLeft();
            // If there is a right child, it becomes the root, or if null root becomes null
            else
                root = node.getRight();

            // Make sure the new root, if non-null, has a null parent
            if (root != null)
                root.setParent(null);

            // Return true for completed removal
            return true;
        }

        // Case 3: Internal with left child only
        else if (node.getLeft() != null)
            // Returns true if successful
            return replaceChild(node.getParent(), node, node.getLeft());

        // Case 4: Internal with right child only OR leaf
        else
            // Returns true if successful
            return replaceChild(node.getParent(), node, node.getRight());
    }

    /**
     * Replaces the current child with the new child, removing the node
     * Returns true if successful, else false
     */
    private boolean replaceChild(TreeNode<E> parent, TreeNode<E> currentChild, TreeNode<E> newChild) {
        // If the parent does not match the children, return false
        if (parent.getLeft() != currentChild && parent.getRight() != currentChild)
            return false;

        // If currentChild is the left child of parent
        if (parent.getLeft() == currentChild)
            parent.setLeft(newChild);
        // If currentChild is the right child of parent
        else
            parent.setRight(newChild);

        // If newChild is not null, reset its parent
        if (newChild != null)
            newChild.setParent(parent);

        // Reutrn success
        return true;
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
        return (root == null);
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
