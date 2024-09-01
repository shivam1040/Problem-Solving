/*
Given a positive integer N, count the number of possible ways to represent N as the sum of four positive integers.
 

Example 1:

Input:
N = 5
Output:
1
Explanation:
We can represent 5 as
a sum of 4 positive integers,
only in 1 way as 1+1+1+2 = 5
Example 2:

Input:
N = 41
Output:
511
Explanation:
We can represent 41 as
sum of 4 positive integers
in 511 ways

Your Task:
You don't need to read input or print anything. Your task is to complete the function countWays() which takes an integer N as input parameter and returns an integer, the total count of the number of ways N can be represented as sum of 4 positive numbers.
 

Expected Time Complexity: O(N4)
Expected Space Complexity: O(1)
 

Constraints:
0 <= N <= 100


*/

//{ Driver Code Starts
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
            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long dp[][][]=new long[101][101][5];
    
    static long countWays(int N){
        // code here
        for(int i=0; i<101; i++)
            for(int j=0; j<101; j++)
                for(int k=0; k<5; k++)
                    dp[i][j][k]=-1;
        return count(N, 4, 1);
    }
    
    private static long count(int n, int parts, int nextPart){
        if(n==0 && parts==0)
            return 1;
        if(n<=0 || parts<=0)
            return 0;
        if(dp[n][nextPart][parts]!=-1)
            return dp[n][nextPart][parts];
            
        long ans=0;
        //basic idea is to recursively find if for number in rang n, is it possible to get till 0 for both n and parts which essentially means a way exist
        for(int i=nextPart; i<=n; i++)
            ans+=count(n-i, parts-1, i);
        return (dp[n][nextPart][parts]=ans);
    }
}
