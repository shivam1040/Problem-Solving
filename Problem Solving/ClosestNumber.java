/*
Given non-zero two integers N and M. The problem is to find the number closest to N and divisible by M. If there are more than one such number, then output the one having maximum absolute value.

 

Example 1:

Input:
N = 13 , M = 4
Output:
12
Explanation:
12 is the Closest Number to
13 which is divisible by 4.
Example 2:

Input:
N = -15 , M = 6
Output:
-18
Explanation:
-12 and -18 are both similarly close to
-15 and divisible by 6. but -18 has
the maximum absolute value.
So, Output is -18
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function closestNumber() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
-105 <= N <= 105
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
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int closestNumber(int n , int m) {
        // code here
        int quotient=n/m;
        int firstPossibleClosest=quotient*m;
        int secondPossibleClosest=n*m>0 ? m*(quotient+1) : m*(quotient-1);
        
        //comparing absolute differences to find closest
        if(Math.abs(n-firstPossibleClosest)<Math.abs(n-secondPossibleClosest))
            return firstPossibleClosest;
        return secondPossibleClosest;
    }
}
