/*
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and E  edges, your task is to find any valid topological sorting of the graph.

 

In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.

 

Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.
Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then the console output will be 1 else 0.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2
*/

/*
Intuition
The main idea is to deal with indegree as we know in topological sort vertex with less indegree comes first which means indegree with zero is the first element in topo sort, so we can apply the below idea to get topo sort:

We will print the node which has indegree 0(They have no dependency) first. 
Then remove their adjacent edges and update the indegree of adjacent nodes which are connected with previous nodes with indegree zero. 
Repeat Steps 1 and 2 until we have a node with indegree 0.
Why there always be a node with indegree 0?
As we are working with D.A.G So there must have always a starting point of a graph and that have indegree=0

Implementation
Compute the in-degree of every node and Put the nodes in a queue that have indegree=0.
Remove a Node from the queue (Dequeue operation) and then add it to the answer. 
Decrease in-degree by 1 for all its neighboring nodes. If the in-degree of neighboring nodes is reduced to zero, then add it to the queue.
Repeat Steps 2 and 3 until the queue is empty.
Return the answer.

 

*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
                // Array to store in-degrees of all vertices
        int[] inDegree = new int[V];
        
        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }
        
        // Queue to store vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // List to store the topological order
        List<Integer> topologicalOrder = new ArrayList<>();
        
        // Process vertices in the queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topologicalOrder.add(current);
            
            // Reduce the in-degree of neighboring vertices
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return topologicalOrder.stream().mapToInt(i -> i).toArray();
    }
}

