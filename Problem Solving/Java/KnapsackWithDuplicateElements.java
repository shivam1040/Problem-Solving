/*
Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

 

Example 1:

Input: N = 2, W = 3
val[] = {1, 1}
wt[] = {2, 1}
Output: 3
Explanation: 
1.Pick the 2nd element thrice.
2.Total profit = 1 + 1 + 1 = 3. Also the total 
  weight = 1 + 1 + 1  = 3 which is <= W.
 

Example 2:

Input: N = 4, W = 8
val[] = {1, 4, 5, 7}
wt[] = {1, 3, 4, 5}
Output: 11
Explanation: The optimal choice is to 
pick the 2nd and 4th element.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function knapSack() which takes the values N, W and the arrays val[] and wt[] as input parameters and returns the maximum possible value.

 

Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(W)

 

Constraints:
1 ≤ N, W ≤ 1000
1 ≤ val[i], wt[i] ≤ 100
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][]=new int[N+1][W+1]; //here N+1/W+1 is necessary because in top-down/bottom up approach recursion is completed into iteration to avoid stack overflow chances and base case of recursion is set at every elemtnt at 0 row and ever element at zero column
        /*
        for(int i=1; i<N+1; i++){ //starting from index 1, since 0 is for base case
            for(int j=1; j<W+1; j++){
                if(wt[i-1]<=j){ //checking if weight at current processing index is lesser than the limit 
                    dp[i][j]=Math.max((val[i-1]+dp[i][j-wt[i-1]]), dp[i-1][j]); //conversion from recursion to iteration
                    //above line also conveys that at given position in dp, the j value is weight, i is for elemnt until iTh posititon in array(when 1 based indexing is considred) so dp[i][j] will give maximum value that can be put in knapsack when weight is j
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        */
        rec(N, W, val, wt, dp);
        return dp[N][W];
    }


    static int rec(int N, int W, int val[], int wt[], int dp[][]){
        if(N==0 || W==0)
            return 0;
        if(dp[N][W]!=0) //memoization
            return dp[N][W];
        if(wt[N-1]<=W){ //in this type of knapsack problem, there are two choices one; we can take duplicates so that means one index can be processes over and over until weight goes zero, and second; not take the index and process other indexes, by making a recursive call for both these choices we can find max of both the choices and memoize it and return a final answer at N, W
            return dp[N][W]=Math.max((val[N-1]+rec(N, W-wt[N-1], val, wt, dp)), rec(N-1, W, val, wt, dp));
        }
        else if(wt[N-1]>W) //if weight goes above limit, then just process next element
            return dp[N][W]=rec(N-1, W, val, wt, dp);
        return dp[N][W];
    }
    }