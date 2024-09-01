/*
Given two strings str1 & str 2 of length n & m respectively, return the length of their longest common subsequence. If there is no common subsequence then, return 0. 

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "abe" is a subsequence of "abcde".

Example 1:

Input: n = 6, str1 = ABCDGH and m = 6, str2 = AEDFHR
Output: 3
Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
Example 2:

Input: n = 3, str1 = ABC and m = 2, str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
Example 3:

Input: n = 4, str1 = XYZW and m = 4, str2 = XYWZ
Output: 3
Explanation: There are two common subsequences of length 3 “XYZ”, and”XYW”, and no common subsequence. of length more than 3.
Your Task:
You do not need to read input or print anything. Complete the function lcs() which takes the two strings and their lengths as input parameters and returns the length of the Longest Common Subsequence. 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1<= n, m <=103
str1 and str2 are in uppercase alphabet
*/

/*
Intuition:
The intuition behind the tabulation approach is to break down the problem into smaller subproblems and solve them in a specific order, typically starting from the smallest subproblems and gradually solving larger subproblems. By following this iterative approach, we avoid the overhead of multiple recursive calls elimination the need of O(n) auxiliary space.

Implementation:
A 2D vector dp of size (n+1) x (m+1) is created to store the results of subproblems. dp[i][j] represents the length of the longest common subsequence for the substrings str1[0...i-1] and str2[0...j-1].
The first row and first column of the DP table (dp) are initialized to 0 since the LCS of any string with an empty string is always 0.
The nested loops iterate over all possible substrings of str1 and str2 to fill the DP table.
The main logic inside the nested loops:
If the characters at the current indices (ind1 and ind2) of str1 and str2 are the same, it means we have found a common character in the subsequences. In this case, we increment the LCS length by 1, and we look for the LCS of the remaining substrings, i.e., dp[ind1-1][ind2-1]. Thus, dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1].
If the characters are different, we have two options to consider: either the LCS comes from excluding the current character from str1 or from str2. We take the maximum of these two options to find the LCS of the current substrings. Thus, dp[ind1][ind2] = max(dp[ind1-1][ind2], dp[ind1][ind2-1]).
After filling the entire DP table, dp[n][m] will contain the length of the longest common subsequence of str1 and str2, and we return it as the final result.
Example:

Let's take two example strings:
str1 = "ABCD"
str2 = "FACD"

Initialize dp table of length 5*5 and fill it with the implementation provided:

dp[1][1] - Both characters are 'A', so dp[1][1] = 1 + dp[0][0] = 1 + 0 = 1.
dp[1][2] - Characters are different ('A' and 'C'). dp[1][2] = max(dp[0][2], dp[1][1]) = max(0, 1) = 1.
dp[1][3] - Characters are different ('A' and 'D'). dp[1][3] = max(dp[0][3], dp[1][2]) = max(0, 1) = 1.
dp[1][4] - Characters are different ('A' and 'F'). dp[1][4] = max(dp[0][4], dp[1][3]) = max(0, 1) = 1.
dp[2][1] - Characters are different ('B' and 'A'). dp[2][1] = max(dp[1][1], dp[2][0]) = max(1, 0) = 1.
dp[2][2] - Characters are different ('B' and 'C'). dp[2][2] = max(dp[1][2], dp[2][1]) = max(1, 1) = 1.
dp[2][3] - Characters are different ('B' and 'D'). dp[2][3] = max(dp[1][3], dp[2][2]) = max(1, 1) = 1.
dp[2][4] - Characters are different ('B' and 'F'). dp[2][4] = max(dp[1][4], dp[2][3]) = max(1, 1) = 1.
dp[3][1] - Characters are different ('C' and 'A'). dp[3][1] = max(dp[2][1], dp[3][0]) = max(1, 0) = 1.
dp[3][2] - Both characters are 'C', so dp[3][2] = 1 + dp[2][1] = 1 + 1 = 2.
dp[3][3] - Characters are different ('C' and 'D'). dp[3][3] = max(dp[2][3], dp[3][2]) = max(1, 2) = 2.
dp[3][4] - Characters are different ('C' and 'F'). dp[3][4] = max(dp[2][4], dp[3][3]) = max(1, 2) = 2.
dp[4][1] - Characters are different ('D' and 'A'). dp[4][1] = max(dp[3][1], dp[4][0]) = max(1, 0) = 1.
dp[4][2] - Characters are different ('D' and 'C'). dp[4][2] = max(dp[3][2], dp[4][1]) = max(2, 1) = 2.
dp[4][3] - Both characters are 'D', so dp[4][3] = 1 + dp[3][2] = 1 + 2 = 3.
dp[4][4] - Characters are different ('D' and 'F'). dp[4][4] = max(dp[3][4], dp[4][3]) = max(2, 3) = 3.
 

 	 	A	C	D	F
 	0	0	0	0	0
A	0	1	1	1	1
B	0	1	1	1	1
C	0	1	2	2	2
D	0	1	2	3	3
The answer is dp[4][4] = 3, which is the length of 'ACD'


*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(); // Take size of both the strings as input
            int m = sc.nextInt();

            String str1 = sc.next(); // Take both the string as input
            String str2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(n, m, str1, str2));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        // your code here
                int dp[][]=new int[n+1][m+1];
        
        for(int i=1; i<=n; i++)
            for(int j=1; j<=m; j++)
                if(i==0 || j==0)
                    dp[i][j]=0;
                    //if same then take last value and increment
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                //considering one index of s1 and then not considering one index of s2
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[n][m];
    }
}
