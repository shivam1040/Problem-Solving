/*
Given a binary matrix of dimensions M * N. One can perform the given operation in the matrix.

If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction from up, right, down, or left to the directions right, down, left, and up respectively.
Initially you start from cell(0, 0), moving in right direction.

The task is to find the first cell of the matrix  which leads to outside the matrix from the traversal of the given matrix from the cell (0, 0) by performing the operations.

Example 1:

Input:
matrix[][] = {{0,1},
              {1,0}}

Output: (1,1)
Explanation:




Example 2:

Input: 
matrix[][] = {{0, 1, 1, 1, 0},
                   {1, 0, 1, 0, 1},
              {1, 1, 1, 0, 0}}

Output: (2,0)
Your Task:
You don't need to read input or print anything. Complete the function endPoints() that take the matrix as input parameter and output the last cell before the pointer gets outside of the matrix.

Constrains:
1<= M, N <=1000
0<= matrix[i][j] <=1
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int i=0, j=0;
        boolean l=false, r=true, d=false, u=false;
        
        while(i>=0 && j>=0 && i<m && j<n){
            if(arr[i][j]==0){
                if(l==true)
                    j--;
                else if(r==true)
                    j++;
                else if(u==true)
                    i--;
                else
                    i++;
            }
            else{
                arr[i][j]=0;
                //if left then move up for right
                if(l==true){
                    l=false;
                    u=true;
                    i--;
                }
                else if(u==true){
                    u=false;
                    r=true;
                    j++;
                }
                //similarly if right then just move down for right again
                else if(r==true){
                    r=false;
                    d=true;
                    i++;
                }
                else{
                    d=false;
                    l=true;
                    j--;
                }
            }
        }
        
        if(i<0)
            i++;
        else if(j<0)
            j++;
        else if(i==m)
            i--;
        else
            j--;
        
        return new int[]{i, j};
    }
}
