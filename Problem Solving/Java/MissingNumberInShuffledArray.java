Given an array A of size N. The contents of A are copied into another array B and numbers are shuffled. Also, one element is removed from B. The task is to find the missing element.

 
Example 1:
Input : 
A[] = {4, 8, 1, 3, 7}
B[] = {7, 4, 3, 1}
Output : 8
Explanation:
8 is the only element missing from B.
 
Example 2:
Input : 
A[] = {12, 10, 15, 23, 11, 30}
B[] = {15, 12, 23, 11, 30}
Output : 10
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMissing() which takes the array A[], B[] and its size N and N-1, respectively as inputs and returns the missing number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
2 <= N <= 106
1 <= A, B <= 1018
Array may also contain duplicates./*

*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            long b[] = new long[(int)(n)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n-1; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.findMissing(a, b, n));
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public long findMissing(long a[], long b[], int n) {
        long res=a[n-1];
        //we know that xor with same number is zero so here the idea is to xor with all and the missing number will come as res
        for(int i=0; i<n-1; i++)
            res^=a[i]^b[i];
        return res;
        
    }
}
