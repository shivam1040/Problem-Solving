/*
Given the maximum possible area of the right angle triangle for a fixed length of hypotenuse. The task is to find the length of hypotenuse.

Note: If the answer comes in Decimal, find it's Floor value.

Example 1:

Input:
N = 25
Output:
10
Explanation:
For a maximum area of 25 square Units
of a Right-angled Triangle,
the length of it's Hypotenuse is 10.
Example 2:

Input:
N = 21
Output:
9
Explanation:
For a maximum area of 21 square Units
of a Right-angled Triangle, the
length of it's Hypotenuse is 9.165 = 9.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getHypotenuse() which takes an Integer N as input and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 1010
*/

/*
Thale's theorem
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
            System.out.println(ob.getHypotenuse(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getHypotenuse(Long N) {
        // code here
        return (int)Math.floor(Math.sqrt(N*4));
    }
}
