
/**
 * class MyGraph. Will use Matrix to represent a simple weighted directed graph. There is no loop at vertex.
 * No more than one edge from vertex i to another vertex j. The vertices are numbered as 1, 2, ..., n
 * The graph with n vertices is reprented by an (n+1) by (n+1) matrix with row 0 and column 0 unused.
 * If there is an edge from vertex i to vertex j (i != j), then entry on row i column j of the matrix will 
 * be 1. If there is no edge between vertex i to vertex j (i != j), then the entry on row i column j of the 
 * matrix will be Integer.MAX_VALUE
 * 
 * @author Hong Biao Zeng
 * @version Dec 12, 2015
 */
import java.util.*;
public class MyGraph
{
    private int[][] graph;
    private int numberOfVertices;
    
    /**
     * create a graph with given number of vertices with no edges
     * @param numberOfVertices number of vertices of the graph
     */
    public MyGraph(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
        graph = new int[numberOfVertices+1][numberOfVertices+1];
    }
    
    /**
     * create a graph with given matrix representation
     * @param graph The matrix representation on the given graph. Assume column 0 and row 0 are not used
     */
    public MyGraph(int [][] graph){
        this.graph = graph;
        // change any 0 to infinity if the 0 is not on diagonal
        for(int i = 1; i < graph.length; i++){
            for(int j = 1; j < graph.length; j++){
                if(i == j) graph[i][j] = 0;
                else if(i != j && graph[i][j] == 0)
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        numberOfVertices = graph.length - 1; 
    }
    
    /**
     * return a String that represent the vertices in order if the BFS algorithm is used to traversal the graph
     * starting from the given vertex. If the startVertex not exists, return an error message
     * @param startVertex The vertex where the traversal starts
     * @return A String that describes the vertices visited in order
     */
    public String bfs(int startVertex){
        // TODO student implement this

        // If startVertex does not exist, return an error message
        if (startVertex < 1 || startVertex > numberOfVertices)
            return "Error: start vertex does not exist.";

        // Create the data structures for BFS processing
        Queue<Integer> frontierQueue = new LinkedList<Integer>();
        Set<Integer> discoveredSet = new HashSet<Integer>();
        StringBuilder bfsResult = null;  // Builds the return string

        // Initialize the data structures before body
        frontierQueue.add(startVertex);
        discoveredSet.add(startVertex);

        // Iterate over the graph
        while (!frontierQueue.isEmpty()){
            int currentV = frontierQueue.poll();

            // Add currentV to the return string
            bfsResult.append(currentV + ", ");

            // TODO Visit currentV
            // TODO Visit each vertext adjV adjacent to currentV
                // TODO if ( adjV is not in discoveredSet )
                    // todo push adjV to frontierQueue
                    // todo add adjV to discoveredSet

        }

        // Return the string representing the BFS result
        return bfsResult.toString();
    }
    
    /**
     * return a String that represents the vertices in order if the DFS algorithm is used to traversal the graph
     * starting from the given vertex. If the startVertex not exist, return an error message
     * @param startVertex The vertex where the traversal starts
     * @return An ArrayList of Integer that represents the vertices visited in order
     */
    public String dfs(int startVertex){
        // If startVertex does not exist, return an error message
        if (startVertex < 1 || startVertex > numberOfVertices)
            return "Error: start vertex does not exist.";

        // Create the data structures for DFS processing
        Stack<Integer> dfsStack = new Stack<Integer>();
        Set<Integer> visitedSet = new HashSet<Integer>();
        StringBuilder dfsResult = new StringBuilder();  // Builds the return string

        // Initialize dfsStack before main loop
        dfsStack.push(startVertex);

        // While the stack is not empty, continue search
        while (!dfsStack.isEmpty()){
            int currentV = dfsStack.pop();

            // Check if currentV has been visited already, and visit if not
            if (!visitedSet.contains(currentV)){
                // Add currentV to the return string and visitedSet
                dfsResult.append(currentV + ", ");
                visitedSet.add(currentV);

                // Visit currentV
                // Iterate over each vertex in the row for currentV
                // NOTE: This implementation generates output that matches the provided example program
                for (int i = numberOfVertices; i >= 1; i--){
                    if (graph[currentV][i] == 1){
                        // For each vertex adjV adjacent to currentV, push adjV to dfsStack
                        dfsStack.push(i);
                    }
                }
            }
        }

        // Return the string representing the DFS result
        return dfsResult.toString();
    }
}
