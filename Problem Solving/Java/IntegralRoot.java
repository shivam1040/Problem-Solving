/*
You are given a integer N and another integer K. You have to find how many integers (n) are possible such that N is the integeral part of Kth root of the integer (n).

Example 1:

Input: N = 3, K = 2
Output: 7
Explaination: 9, 10, 11, 12, 13, 14, 15 
have 3 as integral part of there square root.
Example 2:

Input: N = 2, K = 3
Output: 19
Explaination: 8, 9, 10, 11, 12, 13, 14, 15, 
16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
26 have 2 as integral part of there cube root.
Your Task:
You do not need to read input or print anything. Your task is to complete the function integralRoot() which takes N and K as input parameters and returns the number of possible integers which have N as Kth root of the integer.

Expected Time Complexity: O(LogK)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 100
1 ≤ K ≤ 8
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int K = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.integralRoot(N, K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long integralRoot(int N, int K){
        // code here
        //notice the pattern, 
        return (long)(Math.pow(N+1, K)-Math.pow(N, K));
    }
}
