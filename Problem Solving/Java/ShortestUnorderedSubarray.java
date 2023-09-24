/*
Given an array of n distinct elements. Find the length of shortest unordered (neither increasing nor decreasing) sub array in given array.

 

Example 1:

Input:
n = 5
a[] = {7, 9, 10, 8, 11}
Output:
3
Explanation:
Shortest unsorted subarray is 9, 10, 8
which is of 3 elements.
 

Example 2:

Input:
n = 4
a[] = {1, 2, 3, 5}
Output:
0
 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function shortestUnorderedSubarray() which takes the array a[] and its size n as inputs and returns the length of shortest unordered subarray.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <= 105
1 <= a[i] <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.shortestUnorderedSubarray(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long shortestUnorderedSubarray(long arr[], long n)
    {
        for(int i=0; i<n-2; i++){
            if(arr[i+1]<arr[i] && arr[i+1]<arr[i+2] || arr[i+1]>arr[i] && arr[i+1]>arr[i+2])
                return 3;
        }
        
        return 0;
        }
    }
