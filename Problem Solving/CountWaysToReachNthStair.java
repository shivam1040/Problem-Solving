/*
There are N points on the road ,you can step ahead by 1 or 2 . Find the number of ways you can reach at point N. 

Example 1:

Input: N = 4
Output: 5
Explanation: Three ways to reach at 4th
point. They are {1, 1, 1, 1}, {1, 1, 2},
{1, 2, 1} {2, 1, 1}, {2, 2}.

Example 2:

Input: N = 5
Output: 8
Explanation: Three ways to reach at 5th
point. They are {1, 1, 1, 1, 1},
{1, 1, 1, 2}, {1, 1, 2, 1}, {1, 2, 1, 1},
{2, 1, 1, 1}{1, 2, 2}, {2, 1, 2}, {2, 2, 1}

Your Task:
You don't need to read or print anyhting. Your task is to complete the function nthPoint() which takes N as input parameter and returns the total number of ways modulo 109 + 7 to reach at Nth point.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 ≤ N ≤ 104
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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        int dp[]=new int[n+1]; //this extra 1 accounts for base case
        Arrays.fill(dp, -1);
        return check(n, dp);
    }
    
    private int check(int n, int dp[]){
        //base case
       if(n<=1)
        return dp[n]=1;
       if(dp[n]!=-1)
        return dp[n];
        //since question asks for all possibilities so just add all possiblitites, this is bottom up approach
       return dp[n]=(check(n-1, dp)%1000000007+check(n-2, dp)%1000000007)%1000000007;
    }
}
