/*
You are given a string ‘str’, the task is to check that reverses of all possible substrings of ‘str’ are present in ‘str’. If yes then the answer is 1, otherwise, the answer will be 0.

Example 1:

Input: n = 2, str = "ab"
Output: 0
Explanation: All substrings are "a",
"b","ab" but reverse of "ab" is not 
present in str.
â€‹Example 2:

Input: n = 3, str = "aba"
Output: 1
Explanation: Reverse of all possible 
substring is present in str.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isReversibleâ€‹() which takes the string str and n (the length of str) as inputs and returns the answer.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 2 * 105
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
                    Solution ob = new Solution();
                    System.out.println(ob.isReversible(s, n));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //idea is that if string is palindrome then all reverse substring would also be there
    public int isReversible(String str, int n) 
    { 
     //complete the function here
     int i = 0, j = str.length() - 1;
 
    // iterate from
    // left and right
    while (i < j)
    {
        if (str.charAt(i) != str.charAt(j))
            return 0;
        i++;
        j--;
    }
    return 1;
    } 
}
