/*
Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence. 

Example 1:

Input: 
N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 
106
Explanation:
The maximum sum of a increasing sequence is obtained from {1, 2, 3, 100},
Example 2:

Input: 
N = 4, arr[] = {4, 1, 2, 3}
Output: 
6
Explanation:
The maximum sum of a increasing sequence is obtained from {1, 2, 3}.
Your Task:  
You don't need to read input or print anything. Complete the function maxSumIS() which takes N and array arr as input parameters and returns the maximum value.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105
*/

/*
Intuition:
The memoization technique ensures that we do not recalculate the same subproblems multiple times, significantly reducing the time complexity of the solution.

Implementation:
A memoization table dp is created as a 2D vector of size n × n+1 and initialized with -1. The first dimension (n) represents the indices of the array, and the second dimension (n+1) represents the previous element index plus one. The additional "+1" is used to handle the case when prev is -1 (indicating no previous element).
Then, the solve function is called with the initial parameters: arr, index set to 0 (starting from the first element), prev set to -1 (no previous element), n, and the memoization table dp. This function is responsible for recursively calculating the maximum sum of a strictly increasing subsequence.
In the solve function:
If we have already calculated and stored the result for the current state (dp[index][prev+1]) in the memoization table, we return that result.
Otherwise, we calculate the maximum sum by considering two possibilities:
"not_take": We skip the current element and recursively call solve with the next index, prev, and other parameters.
"take": We include the current element in the subsequence only if it is strictly greater than the previous element (prev) or if there is no previous element (prev == -1). We recursively call solve with the next index, the current index as the new previous element, and other parameters. We add the current element to the result of the recursive call.
We store the maximum of the "take" and "not_take" values in the memoization table for the current state (dp[index][prev+1]).
Finally, we return the maximum sum for the current state.
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
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
        int res=arr[0];
        int dp[]=Arrays.copyOf(arr, n);
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i])
                    dp[i]=dp[j]+arr[i];
                
            }
            res=Math.max(res, dp[i]);
        }
        return res;
	}  
}
