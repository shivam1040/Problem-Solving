/*
Given a string S of opening and closing brackets '(' and ')' only. The task is to find an equal point. An equal point is an index such that the number of closing brackets on right from that point must be equal to number of opening brackets before that point.


Example 1:

Input: str = "(())))("
Output: 4
Explanation:
After index 4, string splits into (())
and ))(. Number of opening brackets in the
first part is equal to number of closing
brackets in the second part.
Example 2:
Input : str = "))"
Output: 2
Explanation:
As after 2nd position i.e. )) and "empty"
string will be split into these two parts:
So, in this number of opening brackets i.e.
0 in the first part is equal to number of
closing brackets in the second part i.e.
also 0.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findIndex() which takes the string S as inputs and returns the occurrence of the equal point in the string.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ S ≤ 106
String can be unbalanced
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public long countSub(String str) {
        // Your code goes here 
        int len = str.length();
        int cnt_close = 0;
        //as it is guaranteed there would always be a solution so answer from the max count of closing bracket should gove the result
        for (int i = 0; i < len; i++)
            if (str.charAt(i) == ')')
                cnt_close++;
        if(cnt_close>0 || str.length()==1)
            return cnt_close;
        return str.length();
    }
}
