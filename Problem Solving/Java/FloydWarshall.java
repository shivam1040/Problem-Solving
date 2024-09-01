/*
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Note : Modify the distances for every pair in-place.

Examples :

Input: matrix = [[0, 25],[-1, 0]]

Output: [[0, 25],[-1, 0]]

Explanation: The shortest distance between every pair is already given(if it exists).
Input: matrix = [[0, 1, 43],[1, 0, 6],[-1, -1, 0]]

Output: [[0, 1, 7],[1, 0, 6],[-1, -1, 0]]

Explanation: We can reach 2 from 0 as 0->1->2 and the cost will be 1+6=7 which is less than 43.
Expected Time Complexity: O(n3)
Expected Space Complexity: O(1)

Constraints:
1 <= n <= 100
-1 <= matrix[ i ][ j ] <= 1000
*/

/*
Intuition
The Floyd-Warshall algorithm is used to find the shortest paths between all pairs of vertices in a weighted graph. It works for both directed and undirected graphs, with positive or negative edge weights (but no negative cycles).

The main idea behind the algorithm is to iteratively update the shortest distances between all pairs of vertices by considering intermediate vertices in each iteration. The algorithm uses a dynamic programming approach to build a 2D matrix dist, where dist[i][j] represents the shortest distance between vertex i and vertex j.

Implementation
Create a 2D matrix dist of size (n x n), where n is the number of vertices in the graph. Initialize dist[i][j] to a very large value (representing infinity) for all i ≠ j and dist[i][i] to 0, as the distance from a vertex to itself is 0.
For each edge (u, v) with weight w in the graph, update dist[u][v] to w. 
Use three nested loops to consider all vertices as intermediate vertices, and for each pair (i, j), check if the path through vertex k (where k ranges from 1 to n) is shorter than the direct path between i and j. If it is, update dist[i][j] to the shorter distance.
dist[i][j] =min(dist[i][j], dist[i ][k] + dist[k][j]), where i = source node, j = destination node and k = the intermediate node via which we are reaching from i to j.
After the algorithm finishes, dist[i][j] will represent the shortest distance from vertex i to vertex j for all i and j.
*/

//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] == -1)
                    matrix[i][j] = Integer.MAX_VALUE;
                    
        for(int k=0; k<matrix.length; k++)
            for(int i=0; i<matrix.length; i++)
                for(int j=0; j<matrix.length; j++)
                 if (matrix[i][k] < Integer.MAX_VALUE && matrix[k][j] < Integer.MAX_VALUE && matrix[i][k] + matrix[k][j] < Integer.MAX_VALUE)
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = -1;
}
}
