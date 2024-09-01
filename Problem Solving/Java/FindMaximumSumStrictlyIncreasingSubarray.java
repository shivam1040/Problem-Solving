/*
Given an array of positive integers. Find the maximum sum of strictly increasing subarrays.
 

Example 1:

Input : 
arr[] = {1, 2, 3, 2, 5, 1, 7}
Output : 
8
Explanation :
Some Strictly increasing subarrays are -
{1, 2, 3} sum = 6,
{2, 5} sum = 7,
{1, 7} sum = 8,
maximum sum = 8
 

Example 2:

Input:
arr[] = {1, 2, 2, 4}
Output:
6


Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxsum_SIS() which takes the array arr[] and its size N as inputs and returns the required result.

 

Expected Time Complexty: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 1000
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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println( obj.maxsum_SIS(arr, n) );
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution { 

// Return maximum sum of strictly increasing 
// subarrays 
	static int maxsum_SIS(int arr[], int n) 
	{
	    // Your code goes here
	            int max=Integer.MIN_VALUE, len=arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1])
                len+=arr[i];
            else if(max<len){
                max=len;
                len=arr[i];
            }
            else
                len=arr[i];
        }
        
        if(max<len)
            return len;
        return max;
	}
}  
