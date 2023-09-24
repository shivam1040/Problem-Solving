/*
Given a matrix M of n*n size, the task is to complete the function which prints its elements in a diagonal pattern as depicted below.
 


 

Example 1:

Input:
N = 3
mat[][] = {{1 2 3},{4 5 6},{7 8 9}}
Output: 1 2 4 7 5 3 6 8 9
Example 2:

Input:
N = 2
mat[][] = {{1 2},{3 4}}
Output: 1 2 3 4

Your Task:
You only need to implement the given function matrixDiagonally() which returns a list containing the matrix diagonally. Do not read input, instead use the arguments given in the function. Print the elements in Matrix in a diagonal pattern.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
Constraints:
1<=N<=100
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        //the basic idea is to traverse up an down direction diagonally
        boolean isUp=true, isDown=false;
        int i=0, j=0;
        int length=mat[0].length;
        int[] res =new int[length*length];
        int index=0;

        while(i<length && j<length){
            if(isUp){
                while(i>0 && j<length-1){
                    res[index++]=mat[i][j];
                    j++;
                    i--;
                }
                //takes care of adding the ele for indexes which broke the avobe condition
                res[index++]=mat[i][j];

                if(j==length-1)
                    i++;
                else
                    j++;
            }
            else {
                while(i<length-1 && j>0){
                    res[index++]=mat[i][j];
                    j--;
                    i++;
                }
                res[index++]=mat[i][j];
                if(i==length-1)
                    j++;
                else
                    i++;
            }
            isUp=!isUp;
        }
        return res;
    }
}
