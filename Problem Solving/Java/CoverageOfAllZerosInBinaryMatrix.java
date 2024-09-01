/*
Given a binary matrix  having n rows and m columns, your task is to find the sum of coverage of all zeros in the matrix where coverage for a particular 0 is defined as total number of ones around a zero in left, right, up and bottom directions.
 

Example 1:

Input: matrix = {{0, 1, 0},
{0, 1, 1}, {0, 0, 0}}
Output: 6
Example 2:

Input: matrix = {{0, 1}}
Output: 1
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function FindCoverage() which takes the matrix as input parameter and returns sum of coverage of all zeros in the matrix.
 

Expected Time Complexity: O(n * m)
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
            int ans = ob.FindCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int FindCoverage(int[][] matrix)
    {
        // code here
        int m=matrix.length, n=matrix[0].length, res=0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    if(j<n-1 && matrix[i][j+1]==1)
                        res++;
                    if(j>0 && matrix[i][j-1]==1)
                        res++; 
                    if(i<m-1 && matrix[i+1][j]==1)
                        res++;
                    if(i>0 && matrix[i-1][j]==1)
                        res++;
                }
            }
        return res;
    }
}
