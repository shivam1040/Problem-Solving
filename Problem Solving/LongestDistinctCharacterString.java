/*
Given a string S, find length of the longest substring with all distinct characters. 

Example 1:

Input:
S = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest 
substring with all distinct characters.
â€‹Example 2:

Input: 
S = "aaa"
Output: 1
Explanation: "a" is the longest substring 
with all distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestSubstrDitinctChars() which takes the string S as input and returns the length of the longest substring with all distinct characters.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(K), where K is Constant.


Constraints:
1<=|S|<=105
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
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        String test="";
        int res=0;
        for(char c:S.toCharArray()){
            String current=String.valueOf(c);
               // If string already contains the character
            // Then substring after repeating character
            if(test.contains(current))
                test = test.substring(test.indexOf(current)+1);
            //adding the current character
            test=test+String.valueOf(c);
            res=Math.max(res, test.length());
        }
        return res;
    }
}
