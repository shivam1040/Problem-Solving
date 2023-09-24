/*
Given a non-negative number N and two values L and R. The problem is to set all the bits in the range L to R in the binary representation of N.

Example 1:

Input :
N = 17, L = 2, R = 3 
Output :
23
Explanation:
(17)10 = (10001)2
(23)10 = (10111)2
The bits in the range 2 to 3 in the binary
representation of 17 are set.
Example 2:

Input :
N = 8, L = 1, R = 2 
Output :
11
Explanation:
(8)10 = (1000)2
(11)10 = (1011)2
The bits in the range 2 to 3 in the binary
representation of 8 are set.
Your Task:
You don't need to read input or print anything. Your task is to complete the function setAllRangeBits() which takes an Integer N as input and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 108
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
            int L = Integer.parseInt(S[1]);
            int R = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.setAllRangeBits(N,L,R));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int setAllRangeBits(int N , int l , int r) {
        // code here
        //finding a range having set bits 1 and all other 0
        int range = (1<<r) - (1<<(l-1));
        //finally setting the bit in range l-r in n
        return N|range;
    }
};
