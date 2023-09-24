/*
Given a number N. You can perform an operation on it multiple times, in which you can change digit 5 to 6 and vice versa.
You have to return the sum of the maximum number and the minimum number which can be obtained by performing such operations.

Example 1:

Input: N = 35
Output: 71
Explanation: The maximum number which can be
formed is 36 and the minimum number which can
be formed is 35 itself. 
Example 2:

Input: N = 22
Output: 44
Explanation: The maximum number and minimum
number which can be formed is 22 itself.
Your Task:
You need not take any input or print anything. Your task is to complete the function performOperation() which takes a single Number as input and returns the sum of maximum and minimum number.

Expected Time Complexity: O(Log10N)
Expected Auxiliary Space: O(Log10N)

Constraints:
1 ≤ N ≤ 1018
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            long N=Long.parseLong(inp[0]);
            Solution ob = new Solution();
            System.out.println(ob.performOperation(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long performOperation(long N){
        // code here
        return rep(N, 5, 6)+rep(N, 6, 5);
    }
    
    static long rep(long N, long from, long to){
        long res=0;
        long multi=1;
        while(N>0){
            long rem = N%10;
            
            if(rem==from){
                res+=to*multi;
            }
            else
                res+=rem*multi;
            multi*=10;
            N/=10;
        }
        return res;
    }
}
