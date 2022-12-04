/*
Given two arrays of equal size N and an integer K. The task is to check if after permuting both arrays, we get sum of their corresponding element greater than or equal to k i.e Ai + Bi >= K for all i (from 0 to N-1). Return true if possible, else false.
 

Example 1:

Input : 
a[] = {2, 1, 3}, 
b[] = { 7, 8, 9 }, 
k = 10. 
Output : 
True
Explanation:
Permutation  a[] = { 1, 2, 3 } 
and b[] = { 9, 8, 7 } 
satisfied the condition a[i] + b[i] >= K.


 

Example 2:

Input : 
a[] = {1, 2, 2, 1}, b[] = { 3, 3, 3, 4 }, k = 5.
Output : 
False
Explanation:
Since any permutation won't give the answer.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isPossible() which takes the array A[], B[], its size N and an integer K as inputs and returns the answer.

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(1)
 

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ 1018
1 ≤ Ai, Bi ≤ 1017
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            long a[] = new long[n];
            long b[] = new long[n];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.isPossible(a, b, n, k) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int i=0, j=n-1; i<n && j>=0; i++, j-- ){
            if(a[i]+b[j]<k)
                return false;
        }
        return true;
    }
}
