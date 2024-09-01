/*
Given two integers n and k, count the number of binary strings of length n where adjacent 1 appear k times. Since the answer can be huge, print it modulo 109+7.


Example 1:

Input:
n = 3 , k = 2
Output: 1
Explanation: Possible string is "111".

Example 2:

Input:
n = 5 , k = 2
Output: 6
Explanation: Possible strings are:
"00111" , "10111" , "01110"
"11100" , "11101" , "11011".
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countStrings() which accepts integers n and k as input parameter and returns the number of binary strings that satisfy the given condition.


Expected Time Complexity: O(n*k).
Expected Auxiliary Space: O(n*k). 


Constraints:
1 <= n, k <= 103

 
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int k = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countStrings(n,k));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countStrings(int n, int k) 
    {
        //code here.
        //https://www.youtube.com/watch?v=nqrXHJWMeBc
                int dp[][][] = new int[n + 1][k + 1][2];
 
        // If n = 1 and k = 0.
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        int mod=1000000007;
 
        for (int i = 2; i <= n; i++) {
 
            // number of adjacent 1's can not exceed i-1
            for (int j = 0; j < i && j < k + 1; j++) {
                //to make adjacent 1 shouldn't be consecutive so we can always latch behind 0's
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1])%mod;
                //behind 1 only zero can be added
                dp[i][j][1] = dp[i - 1][j][0]%mod;
 //If there is room (i.e., j - 1 >= 0), it adds the count of binary strings of length i - 1 with j - 1 consecutive 1s, ending in 1, to the count of binary strings of length i with j consecutive 1s, ending in 1. This accounts for the possibility of extending a string with j-1 consecutive 1s by adding one more 1 at the end.
 //if adding 1 to the end from state where there are current x-1 adjacent 1's
                if (j - 1 >= 0) {
                    dp[i][j][1]= (dp[i][j][1]+dp[i - 1][j - 1][1])%mod;
                }
            }
        }
 
        return (dp[n][k][0] + dp[n][k][1])%mod;
    }
}
