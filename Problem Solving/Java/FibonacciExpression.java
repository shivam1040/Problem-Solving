/*
Given a number N, evaluate the following expression. 
f(n-1)*f(n+1) - f(n)*f(n) where f(n) is the n-th Fibonacci number with n >= 1.
Fibonacci Sequence is 0, 1, 1, 2, 3, 5, 8, 13,… (here 0 is the 0th Fibonacci number)


Example 1:

Input: N = 1
Output: 1
Explaination: f(n+1)*f(n-1) - f(n)*f(n) 
= 1*0 - 1*1 = -1.

Example 2:

Input: N = 2
Output: 1
Explaination: f(n+1)*f(n-1) - f(n)*f(n) 
= 2*1 - 1*1 = 1.

Your Task:
You do not need to read input or print anything. Your Task is to complete the function fibExpresssion() which takes the value N as input parameters and returns the required difference.


Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.fibExpression(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int fibExpression(int N){
        // code here
        return N%2==0 ? 1 : -1;
    }
}
