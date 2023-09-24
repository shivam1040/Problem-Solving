/*
A matrix is constructed of size n*n. such that Mi,j= i+j. Count the number of cells having value q.
Note: Assume, the array is in 1-based indexing.

 

Example 1:

Input:
n = 4, q = 7
Output:
2
Explanation:
Matrix becomes
2 3 4 5 
3 4 5 6 
4 5 6 7
5 6 7 8
The count of 7 is 2.
Example 2:

Input:
n = 5, q = 4
Output:
3
Explanation:
Matrix becomes
2 3 4 5 6 
3 4 5 6 7 
4 5 6 7 8 
5 6 7 8 9 
6 7 8 9 10 
The count of 4 is 3.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function sumMatrix() which takes 2 Integers n, and q as input and returns the count of q in the n*n matrix.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ n,q ≤ 1018
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
            
            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n,q));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long sumMatrix(long n, long q) {
        // code here
        if(q<2 || q>(n+n))
            return 0;
        return n-Math.abs(n-q+1);
    }
};
