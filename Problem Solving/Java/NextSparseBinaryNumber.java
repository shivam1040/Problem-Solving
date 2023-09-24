/*
Given an integer n in the input, find its next sparse binary number.A sparse binary number is a number whose binary representation does not contain any consecutive 1s.

Example 1:

Input: n = 3
Output: 4
Explanation: Binary representation of 4
is 0100.
Example 2:

Input: n = 5
Output: 5
Explanation: Binary representation of 5
is 0101.

Your Task:  
You dont need to read input or print anything. Complete the function nextSparse() which takes n as input parameter and returns the next sparse binary number.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(logn)

Constraints:
1<= n <=105


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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nextSparse(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int nextSparse(int n){
        // code here
        while(true){
            if((n & (n<<1))!=0)
                n++;
            else
                return n;
        }
    }
}
