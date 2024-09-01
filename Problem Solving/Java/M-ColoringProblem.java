/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
Example 2:

Input:
N = 3
M = 2
E = 3
Edges[] = {(0,1),(1,2),(0,2)}
Output: 0
Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 20
1 ≤ E ≤ (N*(N-1))/2
1 ≤ M ≤ N
*/

/*
Intuition
Assign color to different vertices one by one. Before marking any node with a color check if previous assigned colors are valid. If any color combination is valid then return true else backtrack and return false.

Implementation
Create a recursive function. The recursive function will take current index, number of vertices and the array marking colors of the nodes till now. Assign a color to a vertex. Check if the colors given till now are valid by checking if all the adjacent nodes have different color. Now recursively call the function with next index. If the configuration is correct then return true. If no recursive call returns true then backtrack and return false.

Let us understand it with the help of an example:
                                                 1 -- 2
                                                  |  \  |           m = 2
                                                 4 -- 3
step1. Initially node 1 is given color 1. And we check whether this configuration is valid till now.
step2. Now we give node 2 color 1 which is not valid since node 1 and node 2 are connected and have same color.
step3. So now node 2 is given color 2 and coloring till now is valid.
step4. Now we give node 3 color 1 which will not be valid since node 1 and 3 have same color and are connected.
step5. So now node 3 is given color 2 which is also not valid. Since we only had 2 colors so we will backtrack to node 2 and give it next color.
step6. Like this we backtrack to previous nodes whenever all colors are used up for that particular node.
If we checked all colors for a node and coloring still does not become valid we backtrack to previous node and take the next color for that node.
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        return color(graph, n, m, 0, new int[n]);
    }
    
    private boolean color(boolean[][] graph, int n, int m, int index, int[] color){
        //since we reached end
        if(index>=n)
            return true;
        //trying all color combination
        for(int col=1; col<=m; col++)
            if(possible(index, col, graph, n, color)){
                color[index]=col;
                //moving to next node
                if(color(graph, n, m, index+1, color))
                    return true;
                //since not possible so setting to default value;
                else
                    color[index]=0;
            }
        return false;
    }
    
    private boolean possible(int index, int col, boolean[][] graph, int n, int[] color){
        //checking for all connected nodes if color isn't matching for adjacent nodes
        for(int i=0; i<n; i++)
            if(graph[index][i]==true && color[i]==col)
                return false;
        return true;
    }
}
