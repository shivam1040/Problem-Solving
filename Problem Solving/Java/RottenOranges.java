/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
*/

/*
Intuition:
The idea is to use Breadth First Search. The condition of oranges getting rotten is when they come in contact with other rotten oranges. This is similar to breadth-first search where the graph is divided into layers or circles and the search is done from lower or closer layers to deeper or higher layers using multisource BFS.
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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int[][] ti=new int[grid.length][grid[0].length];
        boolean[][] v=new boolean[grid.length][grid[0].length];
        //directions
        int[] x={-1, 1, 0, 0};
        int[] y={0, 0, -1, 1};
        Queue<List<Integer>> q=new LinkedList<>();
        int ans=0;
        //filling the queue with rots so that we can bfs from rot cells
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j]==2){
                    v[i][j]=true;
                    
                    q.add(List.of(i, j));
                }
        while(!q.isEmpty()){
            int i=q.peek().get(0), j=q.peek().get(1);
            
            q.poll();
            //this ensures always the max time is taken into consideration
            if(grid[i][j]==1)
                ans=Math.max(ans, ti[i][j]);
            //rotting in all directions
            for(int k=0; k<x.length; k++){
              int l=i+x[k], m=j+y[k];
                
              if(l<grid.length && l>=0 && m<grid[0].length && m>=0 && grid[l][m]==1 && !v[l][m]){
                  v[l][m]=true;
                  ti[l][m]=1+ti[i][j];
                  
                  q.add(List.of(l, m));
              }
            }
        }
        //checking if any cell is fresh then rotting all hasn't beem possible eventually
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                if(!v[i][j] && grid[i][j]==1){
                    ans=-1;
                    break;
                }
        return ans;
    }
}
