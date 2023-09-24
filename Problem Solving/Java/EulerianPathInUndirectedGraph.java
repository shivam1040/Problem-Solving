/*
Given an adjacency matrix representation of an unweighted undirected graph named graph, which has N vertices. You have to find out if there is an eulerian path present in the graph or not.
Note: The graph consists of a single component

Example 1:

Input: N = 5
graph = {{0, 1, 0, 0, 1}, 
         {1, 0, 1, 1, 0}, 
         {0, 1, 0, 1, 0}, 
         {0, 1, 1, 0, 0}, 
         {1, 0, 0, 0, 0}}
Output: 1
Explaination: There is an eulerian path. 
The path is 5->1->2->4->3->2.
Example 2:

Input: N = 5
graph = {{0, 1, 0, 1, 1}, 
         {1, 0, 1, 0, 1}, 
         {0, 1, 0, 1, 1}, 
         {1, 1, 1, 0, 0}, 
         {1, 0, 1, 0, 0}}
Output: 0
Explaination: There is no eulerian path in 
the graph.
Your Task:
You do not need to read input or print anything. Your task is to complete the function eulerPath() which takes N and graph as input parameters and returns 1 if there is an eulerian path. Otherwise returns 0.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ N ≤ 50 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        //simple principle is that for undirected graph total nodes haveing odd number of connections should be zero or two
        int degreeOfOddCountNodes=0;
        for(int i=0; i<N; i++){
            int nodeCount=0;
            for(int j=0; j<N; j++){
                if(graph[i][j]==1)
                    nodeCount++;
            }
            if(nodeCount%2!=0)
                degreeOfOddCountNodes++;
        }
        if(degreeOfOddCountNodes==0 || degreeOfOddCountNodes==2)
            return 1;
        return 0;
    }
}
