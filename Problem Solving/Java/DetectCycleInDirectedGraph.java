/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.
In the adjacency list adj, element adj[i][j] represents an edge from i to j.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105


*/

/*
Intuition:
To detect cycle, check for a cycle in individual trees by checking back edges. To detect a back edge, keep track of vertices currently in the recursion stack of function for DFS traversal. If a vertex is reached that is already in the recursion stack, then there is a cycle in the tree. The edge that connects the current vertex to the vertex in the recursion stack is a back edge. Use recStack[] array to keep track of vertices in the recursion stack.

Dry Run :

 
Implementation
Run a dfs to all unvisited node
Create a recursive dfs function that initializes the current index or vertex, visited, and recursion stack.
Mark the current node as visited and also mark the index in recursion stack.
Find all the vertices which are not visited and are adjacent to the current node. Recursively call the function for those vertices, If the recursive function returns true, return true.
If the adjacent vertices are already marked in the recursion stack then return true.
Create a wrapper class, that calls the recursive function for all the vertices and if any function returns true return true. Else if for all vertices the function returns false return false.
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean[V];
        boolean currStack[]=new boolean[V];
        
        for(int i=0; i<V; i++)
            if(isCyclicUtil(i, vis, currStack, adj))
                return true;
        return false;
    }
    
    // //DFS
    // private boolean isCyclicUtil(int i, boolean vis[], boolean currStack[], ArrayList<ArrayList<Integer>> adj){
    //     if(currStack[i])
    //         return true;
    //     if(vis[i])
    //         return true;
    //     vis[i]=true;
    //     currStack[i]=true;
        
    //     for(int j:adj.get(i))
    //         if(isCyclicUtil(j, vis, currStack, adj))
    //             return true;
    //     currStack[i]=false;
    //     return false;
    // }
    
        boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack,
                         ArrayList<ArrayList<Integer>> adj) {

        // marking the current node as visited and part of recursion stack.
        if (recStack[i]) return true;

        if (visited[i]) return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        // calling function recursively for all the vertices
        // adjacent to this vertex.
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack, adj)) return true;

        // removing the vertex from recursion stack.
        recStack[i] = false;

        return false;
    }
}
