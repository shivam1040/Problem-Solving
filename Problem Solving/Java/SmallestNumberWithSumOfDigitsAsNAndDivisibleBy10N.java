/*
Find the smallest number such that the sum of its digits is N and it is divisible by 10N.

Example 1:

Input: N = 5
Outptut: 500000
Explanation: Sum of digits of 500000
is 5 and divisible by 105.
Example 2:

Input: N = 20
Output: 29900000000000000000000
Explanation: Sum of digits of 
29900000000000000000000 is 20 and
divisible by 1020.

Your Task:
You don't need to read or print anything. Your task is to complete the function digitsNum() which takes the input parameter N and returns the smallest number such that sum of its digits is N and divisible by 10N.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 10000
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String digitsNum(int N)
    {
        // Code here
        String res="";
        
        if(N==0)
            return "0";
        //append the remainder if not divisible by 9
        if(N%9!=0)
            res+=(N%9);
        //append as many times 9 given 9 can fit in the number final number
        for(int i=1; i<=N/9; i++)
            res+="9";
        //this takes care of adding zeroes as ques say 10^N, so n zeroes
        for(int i=1; i<=N; i++)
            res+="0";
        return res;
    }
}
