/*
Given a number 32 bit number N .Find the number you get by inverting bits in its binary representation (i.e. 1 is made 0 and 0 is made 1). In other words,Negate(~) the number.

Example 1:

Input:
N=4289384
Output:
4290677911
Explanation:
00000000010000010111001101101000
is the binary representation of 4289384.
Negating this in 32 bits, we get
11111111101111101000110010010111
which is the binary representation of
4290677911.
Example2:

Input:
N=1
Output:
4294967294
Explanation:
Binary representation of 1 is
00000000000000000000000000000001.
Negating this we get
11111111111111111111111111111110
which is the binary representation of
4294967294.

Your task:
You don't need to read input or print anything.Your task is to complete the function invertBits() which takes a number N as input parameter and returns the negation of the number.

Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)

Constraints:
1<=N<=108+9


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
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.invertBits(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long invertBits(long N){
        //code here
      long result = ~N & 0xFFFFFFFFL; // Ensure the result is treated as an unsigned 32-bit number
        return result;
    }
}
