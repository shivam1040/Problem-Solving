/*
Given an array arr[] of positive integers of size N and an integer target, replace each element in the array such that the difference between adjacent elements in the array is less than or equal to a given target. We need to minimize the adjustment cost, that is the sum of differences between new and old values. We basically need to minimize ∑|A[i] Anew[i]| where 0 <= i <= n-1, n is size of A[] and Anew[] is the array with adjacent difference less than or equal to target.Assume all elements of the array is less than constant M = 100.

 

Example 1:

Input: N = 4, target = 1
arr[] = { 1, 3, 0, 3 }
Output: 3
Explanation: One of the possible 
solutions is [2, 3, 2, 3].

Example 2:

Input: N = 4, target = 1
arr[] = {2, 3, 2, 3}
Output: 0
Explanation: All adjacent elements 
in the input array are already less 
than equal to given target.


Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function minAdjustmentCost() that takes array arr[] , integer n, and integer target as parameters and returns the minimum adjustment cost.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 102


*/

/*
In order to minimize the adjustment cost ?|A[i] – Anew[i]| for all index i in the array, |A[i] – Anew[i]| should be as close to zero as possible. Also, |A[i] – Anew[i+1] ]| ? Target.
This problem can be solved by dynamic programming.

Let dp[i][j] defines minimal adjustment cost on changing A[i] to j, then the DP relation is defined by – 

poster
dp[i][j] = min{dp[i - 1][k]} + |j - A[i]|
           for all k's such that |k - j| ? target
Here, 0 ? i ? n and 0 ? j ? M where n is the number of elements in the array and M = 100. We have to consider all k such that max(j – target, 0) ? k ? min(M, j + target)
Finally, the minimum adjustment cost of the array will be min{dp[n – 1][j]} for all 0 ? j ? M.

Algorithm:

Create a 2D array with the initializations dp[n][M+1] to record the least adjustment cost of changing A[i] to j, where n is the array’s length and M is its maximum value.
Calculate the smallest adjustment cost of changing A[0] to j for the first element of the array, dp[0][j], using the formula dp[0][j] = abs (j – A[0]).
Replace A[i] with j in the remaining array elements, dp[i][j], and use the formula dp[i][j] = min(dp[i-1][k] + abs(A[i] – j)), where k takes all feasible values between max(j-target,0) and min(M,j+target), to get the minimal adjustment cost.
As the minimum adjustment cost, give the lowest number from the last row of the dp table. 
*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class  Solution
{
    long minAdjustmentCost(long A[], int n,int target)
    {
        int M=100;
        long dp[]=new long[M+1];
        long res=Long.MAX_VALUE;
        
        for(int i=0; i<=M; i++)
            dp[i]=Math.abs(i-A[0]);
        for(int i=1; i<n; i++){
            long prev[]=Arrays.copyOf(dp, dp.length);
            
            for(int j=0; j<dp.length; j++){
                dp[j]=Long.MAX_VALUE;
                
                for(int k=Math.max(j-target, 0); k<=Math.min(M, j+target); k++)
                    dp[j]=Math.min(dp[j], prev[k]+Math.abs(A[i]-j));
            }
        }
        for(long i:dp)
            res=Math.min(i, res);
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
             Solution ob = new  Solution();
            long ans=ob.minAdjustmentCost(a,n,k);
           // System.out.println(ob.shuffleArray(a,n));
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
