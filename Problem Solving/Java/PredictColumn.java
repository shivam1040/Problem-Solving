/*
Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task is to find the column with maximum number of 0s.

Example:

Input:N = 3M[][] = {{1, 1, 0},        {1, 1, 0},        {1, 1, 0}}Output:2Explanation:2nd column (0-based indexing) is having 3 zeros which is maximum among all columns.
 

Your Task:
Your task is to complete the function columnWithMaxZero() which should return the column number with maximum number of zeros. If more than one column exists, print the one which comes first.

Constraints:
1 <= N <= 102
0 <= A[i][j] <= 1
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
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            
            for(int i = 0; i < N; i++)
            {
                int k = 0;
                String str[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < N; j++){
                  arr[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            
            System.out.println(new Solution().columnWithMaxZeros(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here 
        int zeroCurrentCount=0;
        int res=-1;
        int zeroMaxCount=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[j][i]==0)
                    zeroCurrentCount++;
            }
            if(zeroCurrentCount>zeroMaxCount){
                zeroMaxCount=zeroCurrentCount;
                res=i;
            }
            zeroCurrentCount=0;
        }
        return res;
    }
}
