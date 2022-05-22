/*
Given the adjacency list of a bidirectional graph. Your task is to copy/clone the adjacency list for each vertex and return a new list.


Example 1:

Input:

Output: 
0-> 1-> 4 
1-> 0-> 2-> 3-> 4 
2-> 1-> 3 
3-> 1-> 2-> 4 
4-> 0-> 1-> 3
Explanation:
As 0,1 and 3 is connected to 4 so 4th row
of the list containing 4 and its connected
nodes 0,1 and 3 and we have to add those in
sorted order and same for every row.


Example 2:

Input:


Output: 
0-> 2-> 3 
1-> 2 
2-> 0-> 1 
3-> 0
Explanation:
As 2 and 3 is connected to 0 so 0th row
of the list containing 0 and its connected 
nodes 2 and 3 and we have to add those in
sorted order and same for every row. 


Your task:
You dont need to read input or print anything. Your task is to complete the function printGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns the list of list  contains the node itself with its connected nodes(as same as it is given in input adjacency  list).The returned list is a copy/clone of the actual list.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V + E)


Constraints:
1 ≤ V, E ≤ 104
*/

// { Driver Code Starts
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
                ArrayList<ArrayList<Integer>> ans = obj.printGraph(V, adj);
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size() - 1; j++) {
                        System.out.print(ans.get(i).get(j) + "-> ");
                    }
                    System.out.print(ans.get(i).get(ans.get(i).size() - 1));
                    System.out.println();
                }
            }
        }
    }// } Driver Code Ends
    
    
    class Solution {
        // Function to return the adjacency list for each vertex.
        public ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(V);
            for(int i=0; i<adj.size(); i++){
                ArrayList<Integer> tmp = adj.get(i); //getting list starting from vertex zero
                tmp.add(0, i); //storing vertex at start of list
                res.add(tmp); //storing in res list
            }
            return res;
        }
    }