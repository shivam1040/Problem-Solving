/*
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Example 2:

Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)


 

Constraints:
1 ≤ V, E ≤ 105
*/

/*
There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that indirectly joins a node to itself (self-loop) or one of its ancestors in the tree produced by DFS. To find the back edge to any of its ancestors keep a visited array and if there is a back edge to any visited node then there is a loop and return true.

Implementation
Run a dfs to all unvisited nodes.
Mark the current node as visited .
Find all the vertices which are not visited and are adjacent to the current node. Recursively call the function for those vertices, If the recursive function returns true return true.
If the adjacent node is not the parent and already visited (i.e back edge)then return true.
Else if for all vertices the function returns false return false.
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // boolean vis[]=new boolean[V];
        
        // for(int i=0; i<V; i++)
        //     if(vis[i]==false)
        //         if(checkForCycle(i, -1, vis, adj))
        //             return true;
        // return false;
        
                boolean vis[] = new boolean[V];
        
        // Iterate through all vertices of the graph
        for(int i = 0;i<V;i++) {
            // If a vertex is not visited, check for a cycle starting from that vertex
            if(vis[i] == false) {
                if(checkForCycle(i, -1, vis, adj))
                    return true; 
            }
        }
        
        // If no cycle is found in any vertex, return false
        return false; 
    }
    
    private boolean checkForCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        // vis[node]=true;
        
        // for(int i:adj.get(node))
        //     if(vis[i]==false)
        //         if(checkForCycle(i, node, vis, adj))
        //             return true;
        //     else if(i!=parent)
        //         return true;
        // return false;
                vis[node] = true; 
        
        // Traverse through all adjacent nodes
        for(Integer it: adj.get(node)) {
            // If the adjacent node is not visited, recursively check for a cycle
            if(vis[it] == false) {
                if(checkForCycle(it, node, vis, adj) == true) 
                    return true; 
            }
            // If the adjacent node is visited and not the parent of the current node, there is a cycle
            else if(it!=parent) 
                return true; 
        }
        
        // If no cycle is found, return false
        return false; 
    }
}
