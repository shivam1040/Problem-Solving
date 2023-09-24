/*
Given an array arr of N elements. The task is to count all the subsets whose sum is even.

Example:

Input:N = 3arr[] = 1 2 3Output:3Explanation:Three subsets are there whose sum of elements is even. Subsets are (3, 2, 1), (1, 3), (2).
Your Task:
Your task is to complete the function countSumSubsets() which counts all the subsets in which sum of all the elements is even. Print the count of subsets whose sum of all elements is even.

Constraints:
1 <= N <= 10
1 <= arr[i] <= 10


*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.countSumSubsets(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countSumSubsets(int[] arr, int N)
    {
        // Code here
        int odd=0, even=0, a=0, b=0;
        
        for(int i=0; i<N; i++)
            if(arr[i]%2==0)
                even++;
            else
                odd++;
            
            a=(1<<even)-1;
            
            if(odd!=0)
                b=(1<<odd-1)-1;
            
            return a+b+a*b;
        }
    }
