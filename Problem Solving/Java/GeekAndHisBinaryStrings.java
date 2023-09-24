/*
Given an integer N, the task is to find the number of binary strings of size 2*N in which each prefix of the string has more than or an equal number of 1's than 0's.

Note: The answer can be very large. So, output answer modulo 109+7

Example 1:

Input: N = 2
Output: 2
Explanation: 1100, 1010 are two 
such strings of size 4
Example 2:
Input: N = 3
Output: 5
Explanation: 111000 101100 101010 110010 
110100 are such 5 strings

Your Task:  
You don't need to read input or print anything. Complete the function prefixStrings() which takes N as input parameter and returns an integer value.

Expected Time Complexity: O(|N|)
Expected Auxiliary Space: O(|N|)

Constraints:
1 ≤ |N| ≤ 103

*/

/*
variation of catalan number so can use combination formula
*/

//{ Driver Code Starts
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
            int N = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            int ans = ob.prefixStrings(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int prefixStrings(int n)
    {
        // Code here
         // Code here
       long dp[]=new long[n+1];
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
           int l=0,r=i-1;
           while(l<i){
               dp[i]=(dp[i]+(dp[l]*dp[r]))%1000000007;
               l++;
               r--;
           }
       }
       return (int)dp[n]%1000000007;
    }
    
 
}
