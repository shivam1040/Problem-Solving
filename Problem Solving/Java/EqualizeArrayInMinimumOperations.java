/*
You are given an array of N integers A[0], A[1], …, A[N-1], and an integer k. Your task is to make all the elements of the given array equal in a minimum number of ‘moves’.  All the elements of the array are non-negative. In each ‘move,’ you may add or subtract k from any element of the array. Give the answer modulo 109+7.

Example 1:

Input: N = 4, k = 2
A = {7, 5, 21, 17}
Output: 13
Explaination: We can add k = 2 to A[1] 
once and subtract k = 2 from A[2] seven 
times and from A[3] five times.The 
resulting array would be- 7 7 7 7. 
Number of moves = 1 + 7 + 5 = 13.
Example 2:

Input: N = 4, k = 3
A = {7, 5, 21, 17}
Output: -1
Explaination: No matter how many moves 
are made, all the elements of the array 
cannot be made equal.
Your Task:
You do not need to read input or print anything. Your task is to complete the function equalizeArray() which takes N, k, and A as input parameters and returns the minimum number of moves to make all the elements of the array equal. Return -1 if it is not possible.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ k, A[i] ≤ 1000
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
            String a1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a1[0]);
            int k = Integer.parseInt(a1[1]);
            String a2[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for(int i = 0;i < N;i++)
                A[i] = Integer.parseInt(a2[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.equalizeArray(N, k, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int equalizeArray(int N, int k, int A[])
    {
        // code here
        int mod=(int)1e9+7, res=0, mid=N/2;;
        
        Arrays.sort(A);
        for(int i=0; i<N; i++){
            if((Math.abs(A[mid]-A[i])%k)!=0)
                return -1;
            res=(res+(Math.abs(A[mid]-A[i])/k))%mod;
        }
        return res;
    }
}

