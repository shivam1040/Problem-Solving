/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

Example 1:

Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
Example 2:

Input:
N = 4, Sum = 10
coins = {2,5,3,6}
Output: 5
Explanation: Five Possible ways are: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which accepts an array coins its size N and sum as input parameters and returns the number of ways to make change for given sum of money. 

Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum)

Constraints:
1 <= sum, N, coins[i] <= 103
*/

/*
In the recursive approach, we had many of the overlapping subproblems (i.e. the sub-problem which were getting repeated again and again). To optimize the solution, we will use a 1D table to store intermediate results. 

Implementation:
Initialize a 1D table, of size (sum + 1).
Set the value in the table array equal to 0, which is a base case when the sum is equal to 0, and make the value of table[0] equal to 1.
Iterate over each value in the coin denomination array (i.e. 0 <= i < N) and for each value of i iterate over each value of sum. On each iteration,
Add table[j-coins[i]] to the table[j].
Return table[sum].
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        // long dp[][]=new long[N+1][sum+1];
        // //only 1 way to reach 0 i.e take nothing from coins
        // for(int i=0; i<=N; i++)
        //     dp[i][0]=1;
        // for(int i=1; i<=N; i++)
        //     for(int j=1; j<=sum; j++)
        //     //i th coin in coins will be at i-1 index in dp
        //         if(coins[i-1]<=j)
        //         //taking the coins infinitely and not taking the coin
        //             dp[i][j]=dp[i][j-coins[i-1]] + dp[i-1][j];
        //         else
        //         //if sum coin exceeds sum value then there's only i-1 way to reach j sum
        //             dp[i][j]=dp[i-1][j];
        // return dp[N][sum];
        
        //space optimized
        long dp[]=new long[sum+1];
        dp[0]=1;
        
        for(int i=0; i<N; i++)
            for(int j=1; j<=sum; j++)
                if(coins[i]<=j)
                    dp[j]+=dp[j-coins[i]];
        return dp[sum];
    }
}
