/*
Given a series as shown below:

               1  2
            3  4  5  6
        7  8  9 10 11 12
 13 14 15 16 17 18 19 20
    ..........................
    ............................
             (so on)
Find the sum of Nth row.
 

Example 1:

Input: N = 2
Output: 18
Explanation: Sum of 2nd row is 3 + 4 + 
5 + 6 = 18.
Example 2:

Input: N = 4
Output: 132
Explanation: Sum of 4th row is 132.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function Nth_rowSum() which takes N as input parameter and returns sum of Nth row modulo 109  + 7.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 104
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
            int ans = ob.Nth_rowSum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int Nth_rowSum(int n)
    {
        // code here
        int left=n*(n-1)+1, right=n*(n-1)+1+n*2, sum=0;
        
        while(left<right)
            sum=(sum+left++)%1000000007;
        return sum;
    }
}
