/*
Given an array arr[] of N integers. A subsequence of arr[] is called Bitonic if it is first increasing then decreasing. Print the max sum bitonic subsequence.

Example 1:

Input :
N = 9
arr[] = {1, 15, 51, 45, 33,
                   100, 12, 18, 9}
Output : 194
Explanation :
Bi-tonic Sub-sequence are :
{1, 51, 9} or {1, 51, 100, 18, 9} or
{1, 15, 51, 100, 18, 9}  or
{1, 15, 45, 100, 12, 9}  or
{1, 15, 45, 100, 18, 9} .. so on           
Maximum sum Bi-tonic sub-sequence is 1 +
15 + 51 + 100 + 18 + 9 = 194

Example 2:

Input :
N = 6
arr[] = {80, 60, 30, 40, 20, 10}
Output :
210
Explanation :
Here the sequence is strinctly decreasing.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function leftIndex() which takes the array arr[] and its size N as inputs and returns the maximum Bitonic sequence sum.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=103
1<=arr[]<=105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        //here we are basically finding lis from left and right
        int dpLeft[]=new int[n];
        int dpRight[]=new int[n];
        
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<i; j++){
                //performing check to to maintain increaing order
                if(arr[j]<arr[i])
                //this ensures that we have max values from the preceeding indexes
                    sum=Math.max(sum, dpLeft[j]);
            }
            //this updates new index with new sum
            //arr[i] is added to contribute to sum
            dpLeft[i]=arr[i]+sum;
        }
        
        for(int i=n-1; i>=0; i--){
            int sum=0;
            for(int j=n-1; j>i; j--){
                if(arr[i]>arr[j])
                    sum=Math.max(sum, dpRight[j]);
            }
            dpRight[i]=arr[i]+sum;
        }
        
        int res=0;
        
        for(int i=0; i<n; i++){
            //here arr[i] is being deleted because since we are finding longest bitonic from left to right at every index so we need to remove that common index for the sum
            res=Math.max(res, dpLeft[i]+dpRight[i]-arr[i]);
        }
        return res;
    }
}
