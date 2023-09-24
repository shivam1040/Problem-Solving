/*
Given a pattern string and a test string, If the pattern is preceded by a ^, the pattern(excluding the ^) will be matched with the starting position of the text string. Similarly, if it is preceded by a $, the pattern(excluding the ^) will be matched with the ending position of the text string. If no such markers are present, it will be checked whether pattern is a substring of test.

 

Example 1:

Input:
P = "^coal"
S = "coaltar"
Output:
1
Explanation:
The pattern "coal" is present at the
beginning of the string, so Output is 1.
Example 2:

Input:
P = "tar$"
S = "coaltar"
Output:
1
Explanation: 
The pattern "tar" is present at the
end of the string, so Output is 1.
Example 3:

Input:
P = "rat"
S = "algorate"
Output:
1
Explanation:
The pattern "rat" is present as a
substring of the string S,
so Output is 1.
Example 4:

Input:
P = "abcd"
S = "efgh"
Output:
0
Explanation:
There is no substring which is equal
to P in string S, so output is 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isPatternPresent() which takes Strings P and S as input and returns 0 or 1.

 

Expected Time Complexity: O(|P|*|S|)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |S| <= 105
1 <= |P| <= 10
String S may contain both Uppercase and Lowercase letters.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String P = read.readLine();
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isPatternPresent(S,P));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPatternPresent(String s, String p) {
        // code here
       boolean res=false;
        if(p.charAt(0)=='^') {
            String ss=s.substring(0, p.length() - 1);
            String pp =p.substring(1);
            res = ss.equals(pp);
        }
        else if(p.charAt(p.length()-1)=='$') {
            String ss=s.substring(s.length()-p.length()+1);
            String pp=p.substring(0, p.length() - 1);
            res = ss.equals(pp);
        }
        else{
            res=s.contains(p);
        }
        return res ? 1 : 0;
    }
};
