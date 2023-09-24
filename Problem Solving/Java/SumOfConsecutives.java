/*
Given a number n, the task is to check whether it can be expressed as a sum of two or more consecutive numbers or not.
NOTE: Return "1" if number can be expressed as sum of consecutives else "0". (Without the double quotes)

Example 1:

Input: n = 10
Output: 1 
Explanation: It can be expressed as sum of 
two or more consecutive numbers 1+2+3+4.
Example 2:

Input: n = 16
Output: 0
Explanation: It cannot be expressed as 
sum of two or more consecutive numbers.
Your Task:  
You dont need to read input or print anything. Complete the function canBeSumofConsec() which takes n as input parameter and returns  1 if number can be expressed as sum of consecutives else 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1018


*/


/*
(n & (n - 1)) != 0 checks if n and n - 1 have any common set bits. If there are common set bits, it means n is not a power of 2. If there are no common set bits, it means n is a power of 2.
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
            long n = Long.parseLong(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.canBeSumofConsec(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long canBeSumofConsec(long n) { 
        // code here
        //idea here is to check if n can be represented as power of 2
        return (((n&(n-1))!=0 && (n!=0))) ? 1: 0;
    }
}

