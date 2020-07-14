
/**
 * class MyGraph. Will use Matrix to represent a simple weighted directed graph. There is no loop at vertex.
 * No more than one edge from vertex i to another vertex j. The vertices are numbered as 1, 2, ..., n
 * The graph with n vertices is reprented by an (n+1) by (n+1) matrix with row 0 and column 0 unused.
 * If there is an edge from vertex i to vertex j (i != j), then entry on row i column j of the matrix will 
 * be 1. If there is no edge between vertex i to vertex j (i != j), then the entry on row i column j of the 
 * matrix will be Integer.MAX_VALUE
 * 
 * @author Justin Henley, jahenley@mail.fhsu.edu, FHSU U2020_CSCI_251_VA
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
        // If startVertex does not exist, return an error message
        if (startVertex < 1 || startVertex > numberOfVertices)
            return "Error: start vertex does not exist.";

        // Create the data structures for BFS processing
        Queue<Integer> frontierQueue = new LinkedList<>();
        Set<Integer> discoveredSet = new HashSet<>();
        StringBuilder bfsResult = new StringBuilder();  // Builds the return string

        // Initialize the data structures before body
        frontierQueue.add(startVertex);
        discoveredSet.add(startVertex);

        // Iterate over the graph
        while (!frontierQueue.isEmpty()){
            int currentV = frontierQueue.poll();

            // Add currentV to the return string
            bfsResult.append(currentV).append(", ");

            // Visit each vertex adjV adjacent to currentV
            for (int adjV = 1; adjV <= numberOfVertices; adjV++) {
                if (graph[currentV][adjV] == 1 && !discoveredSet.contains(adjV)) {
                    // Add adjV to both frontierQueue and discoveredSet
                    frontierQueue.add(adjV);
                    discoveredSet.add(adjV);
                }
            }
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
        Stack<Integer> dfsStack = new Stack<>();
        Set<Integer> visitedSet = new HashSet<>();
        StringBuilder dfsResult = new StringBuilder();  // Builds the return string

        // Initialize dfsStack before main loop
        dfsStack.push(startVertex);

        // While the stack is not empty, continue search
        while (!dfsStack.isEmpty()){
            int currentV = dfsStack.pop();

            // Check if currentV has been visited already, and visit if not
            if (!visitedSet.contains(currentV)){
                // Add currentV to the return string and visitedSet
                dfsResult.append(currentV).append(", ");
                visitedSet.add(currentV);

                // Visit currentV
                // Iterate over each vertex in the row for currentV
                // NOTE: This reversed iteration generates output that matches the provided example program
                for (int adjV = numberOfVertices; adjV >= 1; adjV--){
                    if (graph[currentV][adjV] == 1){
                        // For each vertex adjV adjacent to currentV, push adjV to dfsStack
                        dfsStack.push(adjV);
                    }
                }
            }
        }

        // Return the string representing the DFS result
        return dfsResult.toString();
    }
}


// Sample output for program
/*
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 1
 Enter an graph.
 First enter the number of vertices: 6
 Enter the matrx reprentation of the graph.
 If no edge between two vertices, enter 0
 0 1 0 0 1 0
 1 0 1 0 1 0
 0 1 0 1 0 0
 0 0 1 0 1 1
 1 1 0 1 0 0
 0 0 0 1 0 0
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 2
 Enter the start vertex: 6
 The result for BFS is: 6, 4, 3, 5, 2, 1,
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 3
 Enter the start vertex: 6
 The result for DFS is: 6, 4, 3, 2, 1, 5,
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 2
 Enter the start vertex: 3
 The result for BFS is: 3, 2, 4, 1, 5, 6,
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 3
 Enter the start vertex: 3
 The result for DFS is: 3, 2, 1, 5, 4, 6,
 *********************************
 *              MENU             *
 * 1. Enter a graph              *
 * 2. Breadth First Search       *
 * 3. Depth First Search         *
 * 4. Quit                       *
 ********************************
 Enter your choice: 4
 Make sure you run enough test before you turn it in

 Process finished with exit code 0
*/