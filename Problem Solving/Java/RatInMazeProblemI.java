/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1


*/

/*
Intuition
We can use recursive backtracking to explore all possible paths in a grid from the top-left corner to the bottom-right corner.

Implementation
Declare a 2D array visited to keep track of visited cells and an ArrayList result to store the paths.
path Function:
If the current cell (x, y) is the bottom-right corner, add the dir to the result list and return.
If the current cell is blocked or already visited, return.
Mark the current cell as visited.
Recursively explore the cells above, left, below, and right if they are within bounds.
After exploration, mark the current cell as unvisited to backtrack
Initialize the visited array with zeros.
Clear the result list.
Check if the top-left or bottom-right cell is blocked. If blocked, returns an empty result.
Call the path function to start finding paths from the top-left corner.
Sort the result list lexicographically.
Return the sorted result list.

*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
        public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res=new ArrayList<>();
        boolean visited[][]=new boolean[n][n];
        
        if(m[0][0]==0 || m[n-1][n-1]==0)
            return res;
        path(m, 0, 0, "", n, visited, res);
        return res;
    }
    
    private static void path(int m[][], int x, int y, String dir, int n, boolean[][] visited, ArrayList<String> res){
        if(x==n-1 && y==n-1){
            res.add(dir);
            return;
        }
        if(m[x][y] == 0 || visited[x][y])
            return;
        visited[x][y]=true;
        
        if(x>0)
            path(m, x-1, y, dir + "U", n, visited, res);
        if(y>0)
            path(m, x, y-1, dir+"L", n, visited, res);
        if(x<n-1)
            path(m, x+1, y, dir+"D", n, visited, res);
        if(y<n-1)
            path(m, x, y+1, dir+"R", n, visited, res);
        visited[x][y]=false;
    }
}



