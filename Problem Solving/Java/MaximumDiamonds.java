/*
There are N bags with diamonds in them. The i'th of these bags contains Ai diamonds. If you drop a bag with P diamonds, it changes to [P/2] diamonds, and you gain P diamonds, where [p] is the greatest integer less than p. Dropping a bag takes 1 minute. Find the maximum number of diamonds that you can take if you are given K minutes.

 

Example 1:

Input:
N = 5, K = 3
A[] = {2, 1, 7, 4, 2}
Output:
14
Explanation:
The state of bags is:
2 1 7 4 2
You take all diamonds from Third bag (7).
The state of bags becomes: 2 1 3 4 2 
Take all diamonds from Fourth bag (4).
The state of bags becomes: 2 1 3 2 2
Take all diamonds from Third bag (3).
The state of bags becomes: 2 1 1 2 2 
Hence, number of Diamonds = 7+4+3 = 14.
Example 2:

Input:
N = 3, K = 2
A[] = {7, 1, 2}
Output:
10
Explanation:
You can take a maximum of 10 diamonds.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxDiamonds() which takes 2 Integers N, and K and an integer and an array A[] of N integers as input and returns the maximum number of diamonds you can take in K minutes.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
0 <= K,A[i] <= 105


*/

//{ Driver Code Starts
//Initial Template for Java

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
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxDiamonds(int[] A, int N, int K) {
        // code here
        PriorityQueue<Integer> aux
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        int res=0;
        
        for(int i:A)
            aux.add(i);
        
        while(K>0){
            res+=aux.peek();
            int temp=aux.poll()/2;
            aux.add(temp);
            K--;
        }
        
        return res;
    }
};
