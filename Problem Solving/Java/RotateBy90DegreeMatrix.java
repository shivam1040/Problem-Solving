/*
Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space. 

Example 1:

Input:
N = 3 
matrix[][] = {{1, 2, 3},
              {4, 5, 6}
              {7, 8, 9}}
Output: 
Rotated Matrix:
3 6 9
2 5 8
1 4 7
Example 2:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 
Rotated Matrix:
2 4
1 3

Your Task:
You dont need to read input or print anything. Complete the function rotateby90() which takes the matrix as input parameter and rotates it by 90 degrees in anti-clockwise direction without using any extra space. You have to modify the input matrix in-place. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 100
1 <= matrix[][] <= 1000
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) 
    { 
        int mid=0;
        if(n%2==0)
            mid=(n/2)-1;
        else
            mid=n/2;
            
            /* We can start at the first 4 corners of the given matrix and then keep incrementing the row and column indices to moves around.

At any given moment we will have four corners lu (left-up),ld(left-down),ru(right-up),rd(right-down).

To left rotate we will first swap the ru and ld,  then lu and ld and lastly ru and rd.
*/
        
        for(int i=0, j=n-1; i<=mid; i++, j--)
            for(int k=0; k<j-i; k++){ //this loop ensures we cover all the elements for the current boundary and swap them
                matrix=swap(matrix, i, j-k, j, i+k); //left-down, right-up swap
                matrix=swap(matrix, i+k, i, j, i+k); //left-up, left down swap
                matrix=swap(matrix, i, j-k, j-k, j); //right-up, right down
            }
    }
    
    static int[][] swap(int mat[][], int i, int j, int k, int l){
        int temp=mat[i][j];
        mat[i][j]=mat[k][l];
        mat[k][l]=temp;
        return mat;
    }
}