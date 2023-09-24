/*
Given three integers N, M, and K. Lets Sum(N) be a function that calculates twice the sum of first N natural numbers. Calculate Sum(K+Sum(K+Sum(K+....+Sum(N+K) up to M terms.

Example 1:

Input:
N=1, M=2, K=3
Output:
552
Explanation:
Sum(3+Sum(3+1))=Sum(3+Sum(4)) 
=Sum(3+20)=Sum(23)=Sum(552)
Example 2:

Input:
N=2, M=2, K=2
Output:
506
Explanation:
Sum(2+Sum(2+2))=Sum(2+Sum(4))
Sum(2+20)=506

Your Task:
You don't need to read input or print anything. Your task is to complete the function modifiedSum() which takes three integers N, M, and K as input parameters and returns the required sum. 

Note: Since the answer can be very large, return the answer modulo 10^9 + 7.


Expected Time Complexity:O(M)
Expected Auxillary Space:O(1)


Constraints:
1<=N,M,K<=106
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int K = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.modifiedSum(N, M, K));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long modifiedSum(int N, int M, int K) {
        // code here
        for(int i=0; i<M; i++)
        //as per the series sum(K+N) until M and using previous value for next calcu
            N=(int)sum(K+N);
        return N%1000000007;
    }
    
    private long sum(long N){
        return (N*(N+1))%1000000007;
    }
}
