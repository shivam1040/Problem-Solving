/*
Given an integer n, find the nth Pentagonal number. First three pentagonal numbers are 1, 5 and 12 (Please see below diagram).The n’th pentagonal number Pn is the number of distinct dots in a pattern of dots consisting of the outlines of regular pentagons with sides up to n dots, when the pentagons are overlaid so that they share one vertex.

Pentagonal Number



Example 1:

Input:
n = 1 
Output:
1 
Explanation:
See the diagram given above.
Example 2:

Input:
n = 2 
Output:
5
Explanation:
See the diagram given above.
Example 3:

Input:
n = 3
Output:
12
Explanation:
See the diagram given above.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getNthPentagonalNum() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <= 105
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
            Long n = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getNthPentagonalNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long getNthPentagonalNum(Long n) {
        // code here
        return n*(3*n-1)/2;
    }
};
