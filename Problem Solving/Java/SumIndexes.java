/*
You are given 3 different arrays A, B, and C of the same size N. Find the number of indexes i such that:
Ai = Bi + Ck 
where k lies between [1, N].

 

Example 1:

Input: N = 3
A = {1, 2, 3}
B = {3, 2, 4}
C = {0, 5, -2}
Output: 2
Explaination: The possible i's are 0 and 1. 
1 = 3 + (-2) and 2 = 2 + 0.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function pairCount() which takes the value N and the arrays A, B, and C as input parameters and returns the number of possible indices.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 104
1 ≤ A[i], B[i] ≤ 100
-100 ≤ C[i] ≤ 100


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
            int N = Integer.parseInt(in.readLine());
            int A[] = new int[N];
            int B[] = new int[N];
            int C[] = new int[N];
            String a1[] = in.readLine().trim().split("\\s+");
            String a2[] = in.readLine().trim().split("\\s+");
            String a3[] = in.readLine().trim().split("\\s+");
            for(int i = 0;i < N;i++){
                A[i] = Integer.parseInt(a1[i]);
                B[i] = Integer.parseInt(a2[i]);
                C[i] = Integer.parseInt(a3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.pairCount(N, A, B, C));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int pairCount(int N, int A[], int B[], int C[])
    {
        // code here
        Map<Integer, Integer> aux=new HashMap<>();
        int res=0;
        
        for(int i=0; i<N; i++)
            aux.put(C[i], i);
        for(int i=0; i<N; i++)
            if(aux.containsKey(A[i]-B[i]))
                    res++;
        return res;
    }
}
