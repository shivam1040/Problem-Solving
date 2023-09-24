/*
Given a floor of size n x m and tiles of size 1 x m. The problem is to count the number of ways to tile the given floor using 1 x m tiles. A tile can either be placed horizontally or vertically.
Both n and m are positive integers and 2 < = m.
 

Example 1 :

Input: n = 2, m = 3
Output: 1
Expanation: There is only one way to tile the
given floor.
Example 2 :

Input: n = 4, m = 4
Output: 2
Explanation: There is two ways to tile the
given floor.One way is to place 1 x 4 size 
of tile vertically and another one is to 
place them horizontally.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function countWays() which takes n and m as input parameter and returns the total ways modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)
 

Constraints:
1 <= n <= 100000
2 <= m <= 100000
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
            String s = br.readLine().trim();
            String [] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.countWays(n, m);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWays(int n, int m)
    {
        // Code here
        int dp[]=new int[n+1];
        
        for(int i=1; i<=n; i++){
//when there is still n remaining to be tiled, two ways to tile it, either hori or vertic
            if(i>m)
                dp[i]=(dp[i-1]+dp[i-m])%1000000007;
//if n<m, then only horizonatlly tile possible
            else if(i<m || i==1)
                dp[i]=1;
            //i==m
//if equal then two ways, horizontally or vertically
            else
                dp[i]=2;
        }
        
        return dp[n];
    }
}
