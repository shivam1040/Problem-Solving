/*
Given an integer N. FInd an integer K for which N%K is the largest ( 1 <= K < N).

 

Example 1:

Input:
N = 3
Output:
2
Explanation:
3%1 = 0
3%2 = 1
So, the modulo is highest for 2.
Example 2:

Input:
N = 4
Output:
3
Explanation:
4%1 = 0
4%2 = 0
4%3 = 1
So, the modulo is highest for 3.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function modTask() which takes a Integer N as input and returns an integer K(1 <= K < N) for which N%K is largest.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1018
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
            System.out.println(ob.modTask(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long modTask(Long N) {
        // code here
        //there is a pattern in this question 1+N/2 is the greatest modula
        
        return N/2+1;
    }
}
