/*
Given a matrix of  size n x m. Your task is to make Zeroes, that means in whole matrix when you find a zero, convert its upper, lower, left, and right value to zero and make that element the sum of the upper, lower, left and right value. Do the following tasks according to the initial matrix.
 

Example 1:

Input: matrix = {{1, 2, 3, 4},
                 {5, 6, 0, 7}, 
                 {8, 9, 4, 6},
                 {8, 4, 5, 2}}
Output: {{1, 2, 0, 4}, 
         {5, 0, 20, 0},
         {8, 9, 0, 6}, 
         {8, 4, 5, 2}}
Explanation: As matrix[1][2] = 0, we will
perform the operation here. Then matrix[1][2]
= matrix[0][2] + matrix[2][2] + matrix[1][1] 
+ matrix[1][3] and matrix[0][2] = matrix[2][2] 
= matrix[1][1] = matrix[1][3] = 0.
Example 2:

Input: matrix = {{1, 2}, 
                 {3, 4}}
output: {{1, 2}, 
         {3, 4}}

Your Task:
You don't need to read or print anything. Your task is to complete the function MakeZeros() which takes the matrix as input parameter and does the given task according to initial matrix. You don't need to return anything. The driver code prints the modified matrix itself in the output.
 

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)
 

Constraints:
1 ≤ n, m ≤ 100
0 ≤ matrix[i][j] ≤ 100, where 0 ≤ i ≤ n and 0 ≤ j ≤ m
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
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.MakeZeros(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        // code here
       int n = matrix.length;
        int m = matrix[0].length;
        int mat[][] = new int[n][m];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m; j++){
                mat[i][j] = matrix[i][j];
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0; j<m; j++){
               if(mat[i][j] == 0){
                    int sum = 0;
                   if(i-1>=0){
                       sum += mat[i-1][j];
                       matrix[i-1][j] = 0;
                   }
                   if(j+1<m){
                       sum += mat[i][j+1];
                       matrix[i][j+1] = 0;
                   }
                   if(i+1<n){
                       sum += mat[i+1][j];
                       matrix[i+1][j] = 0;
                   }
                   if(j-1>=0){
                       sum += mat[i][j-1];
                       matrix[i][j-1] = 0;
                   }
                   matrix[i][j] = sum;
               }
            }
        }
    }
}
