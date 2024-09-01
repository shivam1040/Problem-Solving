/*
Given a string s, remove all its adjacent duplicate characters recursively. 

Note: For some test cases, the resultant string would be an empty string. In that case, the function should return the empty string only.

Example 1:

Input:
S = "geeksforgeek"
Output: "gksforgk"
Explanation: 
g(ee)ksforg(ee)k -> gksforgk

Example 2:

Input: 
S = "abccbccba"
Output: ""
Explanation: 
ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)

Your Task:
You don't need to read input or print anything. Your task is to complete the function rremove() which takes the string S as input parameter and returns the resultant string.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1<=|S|<=105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        StringBuilder res= new StringBuilder();
        int n=s.length();

        for(int i=0; i<n; i++){
            boolean repeated=false;

            while(i+1<n && s.charAt(i)==s.charAt(i+1)){
                repeated=true;
                i++;
            }
            if(!repeated)
                res.append(s.charAt(i));
        }
        if(n==res.length())
            return res.toString();
        else
            return rremove(res.toString());
    }
}
