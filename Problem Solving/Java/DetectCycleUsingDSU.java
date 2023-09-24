/*
Given an undirected graph with V nodes and E edges. The task is to check if there is any cycle in undirected graph.
Note: Solve the problem using disjoint set union(dsu).
 

Example 1:

Input: 

Output: 1
Explanation: There is a cycle between 0->2->4->0
Example 2:

Input: 

Output: 0
Explanation: The graph doesn't contain any cycle
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function detectCycle() which takes number of vertices in the graph denoting as V and adjacency list denoting as adj and returns 1 if graph contains any cycle otherwise returns 0.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 ≤ V, E ≤ 104
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    //using dfs
    /*
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
          int vis[]=new int[V];
          Arrays.fill(vis, -1);

        for(int i=0; i<V; i++){

            if(vis[i]==-1){

                if(dfs(vis, i, -1, adj)){

                   return 1;

                }

            }

        }

        return 0;
    }
    
       boolean dfs(int[]visited,int node,int prev,ArrayList<ArrayList<Integer>>adj)
    {
        visited[node]=1;
        for(int i: adj.get(node))
        {
          if(visited[i]==-1)
          {
              return dfs(visited, i,node,adj);
          }
          else if(visited[i]==1&& prev!=i)
          {
             return true; 
          }
        }
        return false;
    }
    */
    
    
    //using disjoint set
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
          int parent[]=new int[V];
          
          for(int i=0; i<V; i++)
            parent[i]=i;

        for(int i=0; i<V; i++){
            for(int j:adj.get(i)){
                if(j>i){
                int x=find(parent, i);
                int y=find(parent, j);
                if(x==y)
                    return 1;
                union(parent, x, y);
            }
            }
        }
        return 0;
        }
        
        private int find(int parent[], int i){
            if(parent[i]==i)
                return i;
           return find(parent, parent[i]);
        }
        
        private void union(int parent[], int i, int j){
            int x=find(parent, i);
            int y=find(parent, j);
            parent[x]=y;
        }
}
