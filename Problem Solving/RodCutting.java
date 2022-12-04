/*
Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

 

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
*/

//{ Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[n+1][n+1];
        int length[]=new int[n];
        
        for (int i = 0; i < n; i++) //creating this array to imitiate all length from 1 ton n
            length[i] = i + 1;
        return rec(n, n, price, length, dp);
    }
    
       private int rec(int N, int L, int price[], int length[], int dp[][]){
        if(N==0 || L==0)
            return 0;
        if(dp[N][L]!=0) //memoization
            return dp[N][L];
        if(length[N-1]<=L){ //in this type of knapsack problem, there are two choices one; we can take duplicates so that means one index can be processes over and over until weight goes zero, and second; not take the index and process other indexes, by making a recursive call for both these choices we can find max of both the choices and memoize it and return a final answer at N, W
            return dp[N][L]=Math.max(price[N-1]+ rec(N, L-length[N-1], price, length, dp), rec(N-1, L, price, length, dp));
        }
        else if(length[N-1]>L) //if weight goes above limit, then just process next element
            return dp[N][L]=rec(N-1, L, price, length, dp);
        return dp[N][L];
    }
}
