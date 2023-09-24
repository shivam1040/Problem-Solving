/*
Given a matrix of size n x m with 0’s and 1’s , you enter the matrix at cell (0,0) in left to right direction. whenever you encounter a 0 you retain in same direction , if you encounter a 1’s you have to change direction to right of current direction and change that 1 value to 0, you have to find out from which index you will leave the matrix at the end.
 

Example 1:

Input: matrix = {{0, 1, 0},
{0, 1, 1}, {0, 0, 0}}
Output: 1 0
Explanation: We enter at 0,0 then move towards 
0,1 and we encountered a 1 so we turned right 
and moved towards 1,1 and again we encountered 
a 1 so we turned right and moved towards 1,0 after
which we leave the matrix.
Example 2:

Input: matrix = {{0, 0}}
Output: 0 1
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function FindExitPoint() which takes the matrix as input parameter and returns a list containg the exit point.
 

Expected Time Complexity: O(n * m) where n is number of rows and m is number of columns.
Expected Space Complexity: O(1)
 

Constraints:
1 <= n, m <= 100
*/

//{ Driver Code Starts
//Initial Template for Java

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
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindExitPoint(int[][] matrix)
    {
        // code here
        int dir=0, i=0, j=0;
        
        while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
            if(matrix[i][j]==1){
                dir=(dir+1)%4;
                matrix[i][j]=0;
            }
            
            if(dir==0)
                j++;
            else if(dir==1)
                i++;
            else if(dir==2)
                j--;
            else if(dir==3)
                i--;
        }
        
        if(i<0)
            return new int[]{i+1, j};
        if(i==matrix.length)
            return new int[]{i-1, j};
        if(j<0)
            return new int[]{i, j+1};
        if(j==matrix[0].length)
            return new int[]{i, j-1};
        return new int[2];
    }
}
