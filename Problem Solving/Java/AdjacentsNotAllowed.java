/*
You have a rectangular grid mat of dimension 2 x N. You need to find out the maximum sum such that no two chosen numbers are adjacent, vertically, diagonally or horizontally.

Example 1:

Input: N = 3
mat = {{1, 4, 5}, 
       {2, 0, 0}}
Output: 7
Explaination: Optimal choice is (2, 5).
Example 2:

Input: N = 2
mat = {{1, 2}, 
       {3, 4}}
Output: 4
Explaination: Optimal choice is (4).
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSum() which takes the value N and grid mat as input parameters and returns the maximum sum.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 10000
1 ≤ mat[i][j] ≤ 70
*/

/*
This problem is an extension of Maximum sum such that no two elements are adjacent. The only thing to be changed is to take a maximum element of both rows of a particular column. We traverse column by column and maintain the maximum sum considering two cases. 
1) An element of the current column is included. In this case, we take a maximum of two elements in the current column. 
2) An element of the current column is excluded (or not included)
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
            String a[] = in.readLine().trim().split("\\s+");
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[2][N];
            for(int i = 0;i < N; i++)
                mat[0][i] = Integer.parseInt(a[i]);
            for(int i = 0;i < N; i++)
                mat[1][i] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSum(N, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSum(int N, int mat[][])
    {
        // code here
        
        // Sum including maximum element of first
        // column
        int incl=Math.max(mat[0][0], mat[1][0]);
        // Not including first column's element
        int excl=0, excl_new;
        
        for(int i=1; i<N; i++){
            // Update max_sum on including or
            // excluding of previous column
            excl_new=Math.max(excl, incl);
            // Include current column. Add maximum element
            // from both row of current column
            incl=excl+Math.max(mat[0][i], mat[1][i]);
            // If current column doesn't to be included
            excl=excl_new;
        }
        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);
    }
}
