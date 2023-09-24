/*
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = "01212"
Output:
3
Explanation:
The substring 012 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = "12121"
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105
All the characters of String S lies in the set {'0', '1', '2'}
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int zero=-1, one=-1, two=-1;
        int res=Integer.MAX_VALUE, low=0, high=1;
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='0')
                zero=i;
            else if(S.charAt(i)=='1')
                one=i;
            else if(S.charAt(i)=='2')
                two=i;
            if(zero!=-1 && one!=-1 && two!=-1){
                int l=Math.min(two, Math.min(zero, one));
                int h=Math.max(two, Math.max(zero, one));
                res=Math.min(res, h-l);
            }
        }
        
        return res==Integer.MAX_VALUE ? -1 : res+1;
    }
};

