/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
 

Example 1:

Input: 

Output: 0
Explanation: According to the given edges, all 
nodes can be reaced from nodes from 0, 1 and 2. 
But, since 0 is minimum among 0,1 and 3, so 0 
is the output.
Example 2:

Input: 

Output: -1
Explanation: According to the given edges, 
no vertices are there from where we can 
reach all vertices. So, output is -1.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function findMotherVertex() which takes V denoting the number of vertices and adjacency list as imput parameter and returns the verticex from through which we can traverse all other vertices of the graph. If there is more than one possible nodes then returns the node with minimum value.If not possible returns -1.
 

Expected Time Complexity: O(V + E)
Expected Space Compelxity: O(V)
 

Constraints:
1 ≤ V ≤ 500
DFS
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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    int count;
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> aux=new Stack<Integer>();
        boolean visited[]=new boolean[V];
        
        for(int i=0; i<V; i++)
            if(visited[i]==false)
                firstDFS(adj, i, visited, aux);
        
        int potentialAnswer=aux.pop();
        visited=new boolean[V];
        
        checkPotentialAns(adj, visited, potentialAnswer);
        return count==V ? potentialAnswer : -1;
    }
    
    //this method marks for visited elements and stores the potential answer at top of stock, the logic is that mother vertex will travel every element and then get stored at last
    private void firstDFS(ArrayList<ArrayList<Integer>>adj, int current, boolean visited[], Stack<Integer> aux){
        visited[current]=true;
        
        for(int connected:adj.get(current))
            if(visited[connected]==false)
                firstDFS(adj, connected, visited, aux);
        aux.push(current);
    }
    
    //this block is for verification if stack top is actually the answer, logic is that ans should be used as starting point to traverse through graph and element count should be same as Vertex count
    private void checkPotentialAns(ArrayList<ArrayList<Integer>>adj, boolean visited[], int current){
        visited[current]=true;
        count++;
        
        for(int connected:adj.get(current))
            if(visited[connected]==false)
                checkPotentialAns(adj, visited, connected);
    }
}
