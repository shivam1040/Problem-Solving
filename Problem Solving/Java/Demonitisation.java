/*
Given 3 Strings S, M and N. Your task is to remove occurences of M and N completely from the given string S. After removing every occurence of M and N from the string S, if S becomes empty, then return -1.

Example 1:

Input:
S = abc
m = ab
n = bc
Output:
-1
Explanation: When we remove the two strings,
we get an empty string and thus the Output -1.
Example 2:

Input:
S =  abbbccab 
m = ab
n = bcc
Output:
b
Explanation: There are two instance of the String
"ab" in S and one occurence of "bcc". Removing
these from S we get "b".
Example 3:

Input:
S =  geeksforgks
m = for
n = gks
Output:
geeks
Explanation: After removing m and n from the String
S we get "geeks".
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function demonitize() which takes Strings S , m and n as input and returns the answer.

 

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|)

 

Constraints:
1 <= |S| <= 1000
1 <= |n| , |m| <= |S|
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String m = read.readLine();
            String n = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.demonitize(S, m, n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String demonitize(String S, String m, String n) {
        // code here
        S=S.replace(m, "");
        S=S.replace(n, "");
        
        if((m.length()+n.length()>=S.length() && S.length()<=1) || S.equals(""))
            return "-1";
        return S;
    }
};
