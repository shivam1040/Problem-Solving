/*
Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. If a vertices can't be reach from the S then mark the distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Example 1:

Input:

E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
Example 2:

Input:

E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2
Output:
1 6 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-0. This has a distance of 1.
For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function bellman_ford( ) which takes a number of vertices V and an E-sized list of lists of three integers where the three integers are u,v, and w; denoting there's an edge from u to v, which has a weight of w and source node S as input parameters and returns a list of integers where the ith integer denotes the distance of an ith node from the source node.

If some node isn't possible to visit, then its distance should be 100000000(1e8). Also, If the Graph contains a negative cycle then return an array consisting of a single -1.

 

Expected Time Complexity: O(V*E).
Expected Auxiliary Space: O(V).

 

Constraints:
1 ≤ V ≤ 500
1 ≤ E ≤ V*(V-1)
-1000 ≤ adj[i][j] ≤ 1000
0 ≤ S < V
*/

/*
Intuition
By using Bellman-Ford Algorithm we will be able to solve this problem.

Implementation
We need to find out the shortest distance from the source assuming there is no negative weight cycle.

Step 1: Initialises distances from the source to all vertices as infinite and distance to the source itself as 0. Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex. Initialise the dist[src] = 0;
Step 2: This step calculates shortest distances. Do following |V|-1 times where |V| is the number of vertices in given graph. 
a) Do following for each edge u-v .
If dist[v] > dist[u] + weight of edge uv, then update dist[v] 
dist[v] = dist[u] + weight of edge uv
Step 3 : This step reports if there is a negative weight cycle in graph. Do following for each edge u-v .
If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle” 
The idea of step 3 is, step 2 guarantees the shortest distances if the graph doesn’t contain a negative weight cycle. If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight cycle.
NOTE : After V-1 iterations the minimum distance from the source won't change.

Example : 
Edges : [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
Source : 2
 


 


Step 1 : As per the implementation we will define dist[2] = 0 as its source and other node distances will be initialised by infinity.
Step 2 : Now we the distance array will look like this
dist = [ inf, inf, 0 ]
Step 3 :  Now we will iterate V-1 times where V are the vertices are given the graph. In each iteration while we iterate we check all the edges and let the edge be u->v and we will check if the dist[u] != inf as we need to first reach the u node such that we can move to v node and if the dist[u]!=inf then we will check if the sum of dist[u]+cost[u->v] is less than the value of dist[v]. 
Step 4 : After doing the first iteration we will get the minimum distance from the source to the nodes but if there are negative edges then after the 2nd iteration we will get less than distance from the source. After 1st iteration the dist array looks like this.
dist = [ 1, inf, 0]    
Step 5 : In the second iteration the dist[0] has been calculated so we will be able to now calculate the dist[1] and we can find the remaining distances. After 2nd iteration
dist = [ 1, 6, 0].
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dis=new int[V];
        
        Arrays.fill(dis, 100000000);
        dis[S]=0;
        //finding shortest path for v-1 cycle
        for(int i=0; i<V-1; i++)
            for(ArrayList<Integer> j: edges){
                int u=j.get(0);
                int v=j.get(1);
                int w=j.get(2);
                
                if(dis[u]!=100000000 && dis[u]+w < dis[v])
                    dis[v]=dis[u]+w;
            }
        //finding negative cycle
        for(ArrayList<Integer> i: edges){
                int u=i.get(0);
                int v=i.get(1);
                int w=i.get(2);
                
                if(dis[u]!=100000000 && dis[u]+w<dis[v])
                    return new int[]{-1};
        }
        return dis;
    }
}

