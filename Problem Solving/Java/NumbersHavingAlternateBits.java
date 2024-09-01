/*
Given a positive integer n. The task is to check whether this integer has an alternate pattern of 0 and 1 in its binary representation or not.
NOTE: Return 1 if the integer has alternate 0 and 1 in its binary representation else return 0. 

Example 1:

Input: n = 12
Output: 0 
Explanation: n = 12 = "1100" 
Hence there is no alternate pattern.
Example 2:

Input: n = 10
Output: 1
Explanation: n = 10 = "1010".
Hence n has an alternate pattern.

Your Task:  
You dont need to read input or print anything. Complete the function bitsAreInAltOrder() which takes n as input parameter and returns 1 if the integer has alternate 0 and 1 in its binary representation else return 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1015
*/

/*
Calculate num = n ^ (n >> 1). If n has an alternate pattern, then n ^ (n >> 1) operation will produce a number having set bits only. ‘^’ is a bitwise XOR operation.
Check whether all the bits in num are set or not.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.bitsAreInAltOrder(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long bitsAreInAltOrder(long n){
        // code here
        return ((n^(n>>1)+1)&n)==0 ? 1 : 0;
    }
}
