/*
Given a number N, find whether N can be expressed as sum of two or more consecutive positive numbers.

 

Example 1:

Input:
N = 10
Output:
Yes
Explanation:
10 can be expressesd as 1+2+3+4.
Example 2:

Input:
N = 8
Output:
No
Explanation:
8 can't be expressesd sum of two or
more consecutive numbers.
Example 3:

Input:
N = 24
Output:
Yes
Explanation:
24 can be expressesd as 7+8+9.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isSumOfConsecutive() which takes an Integer N as input and returns "Yes" and "No" accordingly.

 

Expected Time Complexity: O(1)
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
            System.out.println(ob.isSumOfConsecutive(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String isSumOfConsecutive(int n) {
        // code here
        /*
        Just need to verify: "a number that is a power of 2 can never be expressed as sum of consecutive numbers, rest all are valid"
        */
        return (n&(n-1))!=0 ? "Yes" : "No";
    }
};
