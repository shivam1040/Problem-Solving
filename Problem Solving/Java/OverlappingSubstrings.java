/*
Given a string S and you need to check whether S contains two non overlapping substrings "XY" and "YX" in any order or not.

Note : All letters of the String are Uppercased.

 

Example 1:

Input:
S = "XYYX"
Output:
YES
Explanation: 
From stated input string "XY"
substring(1,2) and "YX" substring(3,4)
can be easily separated without overlap.
So output is "YES".
Example 2:

Input:
S = "XYX"
Output:
NO
Explanation: 
"XY" and "YX" substrings are present.
But they overlap with each other.
So, Output is "NO".
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function overlapPresent() which takes a String S and returns the answer.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |S| <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.overlapPresent(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String overlapPresent(String S) {
        // code here
        int i=S.indexOf("XY");
        
        if(i==-1)
            return "NO";
        S=S.substring(0, i)+S.substring(i+2, S.length());
        
        return S.contains("YX") ? "YES" : "NO";
    }
};
