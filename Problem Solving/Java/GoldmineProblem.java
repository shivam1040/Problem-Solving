/*
Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner can start from any row in the first column. From a given cell, the miner can move

to the cell diagonally up towards the right 
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination: 
The path is {(1,0) -> (2,1) -> (2,2)}.

Example 2:

Input: n = 4, m = 4
M = {{1, 3, 1, 5},
     {2, 2, 4, 1},
     {5, 0, 2, 3},
     {0, 6, 1, 2}};
Output: 16
Explaination: 
The path is {(2,0) -> (3,1) -> (2,2) 
-> (2,3)} or {(2,0) -> (1,1) -> (1,2) 
-> (0,3)}.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxGold() which takes the values n, m and the mine M as input parameters and returns the maximum amount of gold that can be collected.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)


Constraints:
1 ≤ n, m ≤ 50
1 ≤ M[i][j] ≤ 100
*/


// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        
        int dp[][]=new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        int max=0;
        for(int i=0; i<n; i++){
            int temp=find(M, dp, n, m, i, 0);
            max=Math.max(temp, max);
        }
        return max;
        
        
    }
    
    static int find(int M[][], int dp[][], int n, int m, int nn, int mm){
        if(nn<0 || nn>=n || mm>=m)
            return 0;
        if(dp[nn][mm]!=-1)
            return dp[nn][mm];
        // Right upper diagonal
    int rightUpperDiagonal
      = find(M, dp, n, m, nn - 1, mm + 1);
  
    // right
    int right = find(M, dp, n, m, nn, mm + 1);
  
    // Lower right diagonal
    int rightLowerDiagonal
      = find(M, dp, n, m, nn + 1, mm + 1);
    
    dp[nn][mm]=M[nn][mm]+Math.max(Math.max(rightUpperDiagonal,
                          rightLowerDiagonal),
                 right);
    return dp[nn][mm];
    }
}