/*
You are given a positive integer N and you have to find the number of non negative integral solutions to a+b+c=N.

 

Example 1:

Input:
N = 10
Output:
66
Explanation:
There are 66 possible solutions.
Example 2:

Input:
N = 20
Output:
231
Explanation:
There are 231 possible solutions.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfIntSols() which takes an Integer N as input and returns the number of integer solutions possible.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.noOfIntSols(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long noOfIntSols(Long n) {
        // code here
        return((n+1)*(n+2))/2;
    }
};
