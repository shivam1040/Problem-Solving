/*
Given the value of n, we need to find the sum of the series where i-th term is sum of first i natural numbers.

NOTE: Sum of the series 1 + (1+2) + (1+2+3) + (1+2+3+4) + …… + (1+2+3+4+…+n)

Example 1:

Input: n = 5
Output: 35 
Explanation: 1 + (1+2) + (1+2+3).. = 35
Hence sum of the series is 35.
Example 2:

Input: n = 10
Output: 220
Explanation: 1 + (1+2) + (1+2+3) +
(1+2+3+4) + (1+2+3+4+5)... = 210.
Hence sum of the series is 210.

Your Task:  
You dont need to read input or print anything. Complete the function sumOfTheSeries() which takes n as input parameter and returns the sum of the series of n terms.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1000
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

            System.out.println(ob.sumOfTheSeries(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long sumOfTheSeries(long n){
        // code here
        return (n*(n+1)*(n+2)/6);
    }
}
