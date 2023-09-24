/*
You are given a decimal number n. You need to find the gray code of the number n and convert it into decimal.

Gray code is a binary numeral system where two successive values differ in only one bit.
For example, the sequence of Gray codes for 3-bit numbers is: 000, 001, 011, 010, 110, 111, 101, 100, so G(4)=6.

Example 1:

Input:
n  = 7
Output:
4
Explanation:
7 is represented as 111 in binary form.
The gray code of 111 is 100, in the binary
form whose decimal equivalent is 4.
Example 2:

Input:
n  = 10
Output:
15
Explanation:
10 is represented as 1010 in binary form.
The gray code of 1010 is 1111, in the binary
form whose decimal equivalent is 15.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getGray() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= n <= 108
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getGray(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int getGray(int n) {
        // code here
        //good topic youtube it
        return n^(n>>1);
    }
};
