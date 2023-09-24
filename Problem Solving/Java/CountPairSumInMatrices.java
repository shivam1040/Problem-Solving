/*
Given two sorted matrices mat1 and mat2 of size N x N of elements. Given a value x. The problem is to count all pairs from both matrices whose sum is equal to x.

Note: The pair has an element from each matrix. Matrices are strictly sorted which means that matrices are sorted in a way such that all elements in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, the first element of row 'i' is greater than the last element of row 'i-1'.

Example 1:

Input: 
N = 3, x = 21
mat1 = { {1 5 6}
         {8 10 11}
         {15 16 18} }
mat2 = { {2 4 7}
         {9 10 12}
         {13 16 20} }
OUTPUT: 4
Explanation: The pairs are (1, 20),
            (5, 16), (8, 13), (11, 10).
Example 2:

Input:
N = 2, x = 10
mat1 = { {1 2}
         {3 4} }
mat2 = { {4 5}
         {6 7}
Output: 2
Explanation: The pairs are (4, 6), (3, 7)
User Task:
Your task is to complete the function countPairs() which takes 4 arguments mat1, mat2, N, X, and returns the count of pairs. You don't need to take any input or print anything.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ X ≤ 105
1 ≤ mat1[i][j] , mat2[i][j] ≤ 105
*/
:wq
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int i=0, j=0, k=n-1, l=n-1, count=0;
        
        while(i<n && k>=0){
            int val=mat1[i][j]+mat2[k][l];
            
            if(val==x){
                count++;
                j++;
                l--;
            }
            else if(val<x){
                j++;
            }
            else
                l--;
            if(j==n){
                i++;
                j=0;
            }
            if(l==-1){
                k--;
                l=n-1;
            }
        }
        
        return count;
    }
}
