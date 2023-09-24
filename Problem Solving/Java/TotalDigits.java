/*
Given a number n, count the total number of digits required to write all numbers from 1 to n.

Example 1:

Input: n = 13
Output: 17 
Explanation: There are total 17 
digits required to write all 
numbers from 1 to 13.
Example 2:

Input: n = 4
Output: 4
Explanation: There are total 4 
digits required to write all
numbers from 1 to 4.

Your Task:  
You dont need to read input or print anything. Complete the function totalDigits() which takes n as input parameter and returns the total number of digits required to write all numbers from 1 to n.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=100000
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

            System.out.println(ob.totalDigits(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long totalDigits(long n){
        // code here
        long res=0;
        for(long i=1; i<=n; i++)
        //log ensures we count all the digits in number, 1 ensures all the single digits numbers are also accounted for because it returns zero for 1 digit
            res+=(Math.log10(i)+1);
        return res;
    }

    
}
