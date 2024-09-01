/*
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 

Note: The Graph doesn't contain any negative weight cycle.

 

Example 1:

Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:

The source vertex is 0. Hence, the shortest 
distance of node 0 is 0 and the shortest 
distance from node 1 is 9.
 

Example 2:

Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation:

For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes the number of vertices V and an adjacency list adj as input parameters and Source vertex S returns a list of integers, where ith integer denotes the shortest distance of the ith node from the Source node. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and the second integer w denotes that the weight between edge i and j is w.

 

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
0 ≤ S < V
*/

/*
Using MinHeap or Priority queue: For Dijkstra’s algorithm, it is always recommended to use minHeap (or priority queue) as the required operations (extract minimum and decrease key) match with the specialty of the heap (or priority queue). However, the problem is, that priority_queue doesn’t support the decrease key. To resolve this problem, do not update a key, but insert one more copy of it. So we allow multiple instances of the same vertex in the priority queue. This approach doesn’t require decreasing key operations.

In the above approach, we loop through all elements to find the minimum distance in every iteration but here we use priority queue to optimize this.

Implementation:
Set all vertices' distances = infinity except for the source vertex, set the source distance = 0.
Create a min priority_queue PQ. Every item of PQ is a pair (weight, vertex). Weight (or distance) is used as the first item of pair as the first item is by default used to compare two pairs.
Insert the source vertex into PQ and make its distance = 0.
Run a loop till the priority queue is not empty
Extract the minimum distance vertex from PQ and let it be u.
Loop through all adjacent of u and do the following for every vertex v.
If distance of ( v) > distance of (u) + weight from u to v
Update distance of v, i.e:- dist[v] = dist[u] + weight(u, v)
Insert v into the pq (Even if v is already there)
Return distance vector which stored shortest path of all vertices from the source node.

*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.distance, p2.distance);
            }
        };
        PriorityQueue<Pair> q = new PriorityQueue<>(comparator);
        int[] dis=new int[V];
        boolean[] vis=new boolean[V];
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        q.add(new Pair(0, S));
        dis[S]=0;
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int d=temp.distance;
            int i=temp.vertex;
            
            if(vis[i])
                continue;
            vis[i]=true;
            
            for(ArrayList<Integer> j:adj.get(i))
                if(dis[j.get(0)] > (dis[i]+j.get(1))){
                   dis[j.get(0)] = dis[i]+j.get(1);
                   
                   q.add(new Pair(dis[j.get(0)], j.get(0)));
                }
        }
        return dis;
    }
    
    private static class Pair {
        int distance;
        int vertex;

        public Pair(int distance, int vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
    }
}


