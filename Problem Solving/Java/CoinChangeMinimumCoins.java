/*
Given an array coins[] represent the coins of different denominations and a target value sum. You have an infinite supply of each of the valued coins{coins1, coins2, ..., coinsm}.  Find the minimum number of coins to make the change. If not possible to make a change then return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  
Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1
Input: coins[] = [5, 1], sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin
Input: coins[] = [4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.
Expected Time Complexity: O(n*sum)
Expected Auxiliary Space: O(sum)
 
Constraints:
1 ≤ sum*coins.size() ≤ 106
All array elements are distinct

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
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
        int[] dp=new int[sum+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int i=1; i<=sum; i++)
            for(int j=0; j<M; j++)
                if(coins[j]<=i){
                    int resSoFar=dp[i-coins[j]];
                    
                    if(resSoFar!=Integer.MAX_VALUE)
                        dp[i]=Math.min(dp[i], resSoFar+1);
                }
        return dp[sum]==Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
