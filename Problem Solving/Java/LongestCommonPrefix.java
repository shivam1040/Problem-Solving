/*
Given two strings str1 and str2 of the same length. Find the longest prefix of str1 which is common in str2.


Example 1:

Input: 
str1 = "geeks"
str2 = "dgeek"
Output: 0 3
Explanation: 
Longest prefix from str1
present in str2 is "geek" 
starting at index 0 in str1
and ending at index 3.
Example 2:

Input:
str1 = "practicegeeks"
str2 = "coderpractice"
Output: 0 7
Explanation: 
Longest prefix from str1
present in str2 is "practice"
starting at index 0 and ending 
at index 7 in str1.
Your Task:
You don't need to read input or print anything. Complete the function longestCommonPrefix() which takes strings str1 and str2 as input parameters and returns a list of integers whose first two elements denote the start and end index of str1 at which the longest common prefix of str1 is found in str2. 
If there is no common prefix then the returning list should contain [-1,-1].

 

Expected Time Complexity: O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|)

 

Constraints:
1 <= |str1|, |str2| <= 1000
str1 and str2 contain only lowercase alphabets.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            int[] ans=obj.longestCommonPrefix(s1,s2);
            if(ans[0] == -1)
                System.out.println(ans[0]);
            else 
                System.out.println(ans[0]+" "+ans[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] longestCommonPrefix(String s1, String s2){
        //code here
        int res[]=new int[2];
        
        for(int i=1; i<s1.length(); i++){
            if(s2.contains(s1.substring(0, i)))
                res[1]=i-1;
        }
        return res;
    }
}
