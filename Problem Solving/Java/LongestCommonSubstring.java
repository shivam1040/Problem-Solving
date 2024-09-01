/*
You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

Examples:

Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" which has length 4.
Input: s1 = "ABC", s2 "ACB"
Output: 1
Explanation: The longest common substrings are "A", "B", "C" all having length 1.

Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).


Constraints:
1<= s1.size(), s2.size()<=1000
Both strings contain upper and lower case alphabets.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        int res=-1;
        
        for(int i=1; i<=s1.length(); i++)
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)!=s2.charAt(j-1))
                    dp[i][j]=0;
                else
                    dp[i][j]=1+dp[i-1][j-1];
                res=Math.max(res, dp[i][j]);
            }
        return res;
    }
}
