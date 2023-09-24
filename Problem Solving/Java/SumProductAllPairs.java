/*
Given an integer N and an array of N integers. Calculate the sum of products of all pairs of integers of the array.
Note: Since the answer can be large, return the answer modulo 109+7.

Example 1:

Input:
N=3
A=[1,2,3]
Output:
11
Explanation:
1x2+2x3+1x3=11
So, the answer is 11.
Example 2:

Input:
N=3
A=[2,2,3]
Output:
16
Explanation:
2x2+2x3+3x2=16.
So, the answer is 16.

Your Task:
You don't need to read input or print anything. Your task is to complete the function productOfPairs() which takes the integer N and array A as input parameters and returns the sum of the product of all pairs of integers from the array.


Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)
 

Constraints:
1<=N,A[i]<=106
*/

/*
We know that
(a + b + c)2 = a2 + b2 + c2 + 2*(a*b + b*c + c*a)
Let required sum be P
Let E = (a1 + a2 + a3 + a4 ... + an)^2 
=> E = a12 + a22 + ... + an2 + 2*(a1*a2 + a1*a3 + ....)
=> E = a12 + a22 + ... + an2 + 2*(P)
=> P = ( E - (a12 + a22 + .... + an2) ) / 2
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
            int N = Integer.parseInt(read.readLine());
            int A[] = new int[N];
            String S[] = read.readLine().split(" ");
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.productOfPairs(N, A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int productOfPairs(int n, int A[]) {
        // code here
        long ans=0, sum=0, mod=1000000007;
        
        for(int i:A){
            ans+=(sum*i)%mod;
            ans%=mod;
            sum+=i;
            sum%=mod;
        }
        return (int) ans;
    }
};
