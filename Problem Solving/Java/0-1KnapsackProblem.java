/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
*/

/*
Re-computation of same problem can be avoided by using Dynamic programming . We can keep a temporary array  K[][] . We can construct the array in bottom-up manner . 

Implementation
In this approach we will work on the same cases as mentioned in recursive approach . K[i][j]
denotes maximum value we can get "J weight considering all the values from 1 to ith".
If  weight left >= wi  , for the current element ,we have to choice 
we can add the current element
we don't add the current element
then we take maximum of this two choices .
 if(wt[i-1] <= w)  K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
if weight of the current element greater than  weight left in the knapsack we don't add the current element to knapsack 
K[i][w] = K[i-1][w];
at last return the value stored at K[n][W] .
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int[n+1][W+1];
         
         for(int i=1; i<=n; i++)
            for(int j=1; j<=W; j++)
                if(wt[i-1]<=j)
                //considering the current i since weight is less than a part of W
                //taking the value as well
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1]);
                //if not then take the last max value
                else
                    dp[i][j]=dp[i-1][j];
        return dp[n][W];
    } 
}

