/*
Given a number N. The task is to check whether there is pair of adjacent set bit or not in the binary representation of number.
NOTE: If the number has pair of adjacent set bits return "Yes" else return "No".

Example 1:

Input: n = 1
Output: "No" 
Explanation: There is no pair of adjacent 
set bit in the binary representation of 1.

Example 2:

Input: n = 3
Output: "Yes"
Explanation: There is pair of adjacent
set bit present in the binary 
representation of 3(0011).

Your Task:  
You dont need to read input or print anything. Complete the function isAdjacentSetBits() which takes n as input parameter and returns "Yes" If the number has pair of adjacent set bits else "No".

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1011
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

            System.out.println(ob.isAdjacentSetBits(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isAdjacentSetBits(long n) {
        // code here
        return (n&n>>1) !=0 ? "Yes" : "No";
    }
}
