/*
Given a positive integer K. Find the number of ordered pairs of positive integers (a,b) where 1≤a<b<K such that a+b ≤ K.

 

Example 1:

Input:
K = 2
Output:
0
Explanation:
There are no solutions for K = 2.
Example 2:

Input:
K = 4
Output:
2
Explanation:
There are 2 solutions:- (1,2) and (1,3).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfWays() which takes an Integer K as input and returns the number of solutions for a and b (1≤a<b<K) such that a+b ≤ K.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= K <= 105
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
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numOfWays(K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long numOfWays(int K) {
        // code here
        return (long) (K/2)*(K%2+K-2)/2;
    }
};
