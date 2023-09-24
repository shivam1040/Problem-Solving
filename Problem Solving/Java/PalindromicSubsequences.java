/*
Given a Binary String S (the string that contains only 0's and 1's). Find the minimum number of palindromic subsequences that are needed to be removed such that string S becomes empty.

Example 1:

Input: N = 5, S = "10001"
Output: 1
Explanation: We can remove whole S, as
S is already a palindrome.
â€‹Example 2: 

Input: N = 8, S = "10001001"
Output: 2
Explanation: First we'll remove sub-
sequence "111" and then "00000".
Your Task:  
You don't need to read input or print anything. Your task is to complete the function MinRemove() which takes the length of string and the string as inputs and returns the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 108


*/

/*
If given string is palindrome, we need only one removal. 
Else we need two removals. Note that every binary string has all 1's as a subsequence and all 0's as another subsequence. We can remove any of the two subsequences to get a unary string. A unary string is always palindrome. 
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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.MinRemove(n, s));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinRemove(int n, String s)
    {
        //complete the function here
        //since it's only 0 & 1 so at most 2 removal is required if the string isn't palindrome, so removing either of 0 or 1 subsequence makes the string palindrome
        return isPalindrome(0, n-1, s) ? 1 : 2;
        
    }
    
        private boolean isPalindrome(int i, int j,
                                       String A)
    {
        // comparing the two pointers
        if (i >= j) {
            return true;
        }
 
        // comparing the characters on those pointers
        if (A.charAt(i) != A.charAt(j)) {
            return false;
        }
 
        // checking everything again recursively
        return isPalindrome(i + 1, j - 1, A);
    }
}
