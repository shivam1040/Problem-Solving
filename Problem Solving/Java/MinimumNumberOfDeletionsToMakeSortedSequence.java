/*
Given an array arr of size N, the task is to remove or delete the minimum number of elements from the array so that when the remaining elements are placed in the same sequence order form an increasing sorted sequence.

Example 1:

Input: N = 5, arr[] = {5, 6, 1, 7, 4}
Output: 2
Explanation: Removing 1 and 4
leaves the remaining sequence order as
5 6 7 which is a sorted sequence.
 
Example 2:
Input: N = 3, arr[] = {1, 1, 1}
Output: 2
Explanation: Remove 2 1's


Your Task:  
You don't need to read input or print anything. Complete the function minDeletions() which takes N and array arr as input parameters and returns the integer value

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDeletions(Arr,n));
                }
        }
}    
// } Driver Code Ends

/*
-->arr be the given array.
-->n number of elements in arr.
-->len be the length of longest
   increasing subsequence in arr.
-->// minimum number of deletions
   min = n - len
*/

//User function Template for Java
class Solution
{
	public int minDeletions(int arr[], int n) 
	{ 
	   //code here.
	   int dp[]=new int[n];
	   int res=Integer.MIN_VALUE;
	   
	   Arrays.fill(dp, 1);
	   
	   for(int i=1; i<n; i++){
	       for(int j=0; j<i; j++){
	           if(arr[i]>arr[j] && dp[i]<dp[j]+1)
	            dp[i]=dp[j]+1;
	           res=Math.max(res, dp[i]);
	       }
	   }
	   
	   return res==Integer.MIN_VALUE ? 0 : n-res;
	} 
}
