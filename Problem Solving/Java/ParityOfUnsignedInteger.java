/*
Given an integer N, find it's parity. 
Parity of a number refers to the number of 1 bits it contains. The number has “odd parity”, if it contains odd number of 1-bits and is “even parity” if it contains even number of 1-bits.

Example 1:

Input:
N = 13
Output: odd
Explanation:
(13)10 = (1101)2  The binary representation
has three 1-bits. So, it's parity is odd.

Example 2:

Input:
N = 9
Output: even
Explanation:
(9)10 = (1001)2  The binary representation
has two 1-bits. So, it's parity is even.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function computeParity() which takes an Integer N as input parameter and returns string "odd" or "even".

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.computeParity(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static String computeParity(int N) {
        // code here
        int setBit=0;
        
        while(N>0){
            if((N&1)==1)
                setBit++;
            N>>=1;
        }
        return (setBit&1)==1 ? "odd" : "even";
    }
};
