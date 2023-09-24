/*
Given a number N, change all bits at even positions to 0.

Example 1:

Input: N = 30
Output: 10 
Explanation: Binary representation of 
11110. Bits at Even positions are 
highlighted. After making all of them 
0, we get 01010. Hence the answer is 10.
Example 2:

Input:  N = 10
Output: 10
Explanation: Binary representation of 
1010. Bits at Even positions are 
highlighted. After making all of them 
0, we get 1010. Hence the answer is 10.

Your Task:  
You dont need to read input or print anything. Complete the function convertEvenBitToZero() which takes n as input parameter and returns the value of N after changing bits at even positions.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= N <=(32-bit number)
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

            System.out.println(ob.convertEvenBitToZero(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long convertEvenBitToZero(long n) {
        // code here
        return (n & 0xaaaaaaaa);
    }
}
