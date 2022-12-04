/*
Given a directed acyclic graph(DAG) with n nodes labeled from 0 to n-1. Given edges, s and d ,count the number of ways to reach from s to d.There is a directed Edge from vertex edges[i][0] to the vertex edges[i][1].

 

Example:

Input: edges = {{0,1},{0,3},{1,2},{3,2}}, 
n = 4, s = 0, d = 2
Output: 2
Explanation: There are two ways to reach at 
2 from 0. These are-
1. 0->1->2
2. 0->3->2
 

Your Task:
You don't need to read or print anything. Your task is to complete the function possible_paths() which takes edges, n, s and d as input parameter and returns the number of ways to reach from s to d.

 

Expected Time Compelxity: O(2n)
Expected Space Complexity: O(n+e)

where e is the number of edges in the graph.
 

Constraints:
1 <= n <= 15
0 <= s, d <= n-1
*/

//{ Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int res;
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        ArrayList<ArrayList<Integer>> adjency=new ArrayList<ArrayList<Integer>>(n);
        
        //initiallizing adj list
        for(int i=0; i<n; i++){
            adjency.add(new ArrayList<Integer>());
        }
        
        //creating adj list
        for(int i=0; i<edges.length; i++)
            adjency.get(edges[i][0]).add(edges[i][1]);
        path(s, d, adjency);
        return res;
    }
    
    private void path(int s, int d, ArrayList<ArrayList<Integer>> adjency){
        if(s==d){
            res+=1;
            return;
        }
        //so here we are we are checking if elements which can be reached using s, can reach d or not
        for(int i:adjency.get(s))
        //we check it for all the elements connected to s and then again updating s to current i, again checking all the elements connected to new source if it can be reched or not
            path(i, d, adjency);
    }
}
