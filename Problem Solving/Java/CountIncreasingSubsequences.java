/*
Given an array of digits (values lie in range from 0 to 9). The task is to count all the sub sequences possible in array such that in each subsequence every digit is greater than its previous digits in the subsequence.

 

Example 1:

Input : 
a[] = {1, 2, 3, 4}
Output: 
15
Explanation :
There are total increasing subsequences
{1}, {2}, {3}, {4}, {1,2}, {1,3}, {1,4},
{2,3}, {2,4}, {3,4}, {1,2,3}, {1,2,4},
{1,3,4}, {2,3,4}, {1,2,3,4}
 

Example 2:

Input : 
a[] = {4, 3, 6, 5}
Output:
8
Explanation :
Sub-sequences are {4}, {3}, {6}, {5},
{4,6}, {4,5}, {3,6}, {3,5}
 

Example 3:

Input : 
a[] = {3, 2, 4, 5, 4}
Output : 
14
Explanation :
Sub-sequences are {3}, {2}, {4}, {3,4},
{2,4}, {5}, {3,5}, {2,5}, {4,5}, {3,2,5}
{3,4,5}, {4}, {3,4}, {2,4}


Your Task:
You don't have to print anything, printing is done by the driver function. You have to complete the function countSub() which takes the array a[] and its size N as inputs and returns the count of all increasing subsequences in given array of digits.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O( max(a[i]) ) = O(10)


Constraints:
1 ≤ N ≤ 500
1 ≤ a[i] ≤ 9
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
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long countSub(int arr[], int n)
    {
        // Your code goes here
        long dp[]=new long[n];
        
        //dp[0]=1;
        
        Arrays.fill(dp, 1);
        
        long sum=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                        dp[i]+=dp[j];
                }
            }
            sum+=dp[i];
        }
        return sum;
    }
}

