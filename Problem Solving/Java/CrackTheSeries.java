/*
Given the series as follows 2 2 4 8 16 512....... Identify the Nth term of the series. Answers can be very large use BigInt in Java.

Example 1:

Input: N = 1
Output: 2 
Explanation: First term of the series is 2.
Example 2:

Input: N = 2
Output: 2
Explanation: Second term of the series is 2. 


Your Task:  
You dont need to read input or print anything. Complete the function NthTerm() which takes N as input parameter and returns the Nth term of the series.

Expected Time Complexity: O(logn*logn)
Expected Auxiliary Space: O(1)

Constraints:
1<= N <=12
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.NthTerm(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static BigInteger NthTerm(int N){
        // code here
        BigInteger num=new BigInteger("2");
        
        if(N==1 || N==2)
            return num;
        else if(N%2!=0)
            for(int i=3; i<=N; i=i+2)
                num=num.multiply(num);
        else
            for(int i=4; i<=N; i=i+2)
                num=num.pow(3);
                
        return num;
    }
}
