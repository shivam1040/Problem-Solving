/*
You are given a string s of x and y. You need to verify whether the string follows the pattern xnyn. That is the string is valid only if equal number of ys follow equal number of xs.
As an example: xxyyxxyy is valid. xy is valid. xxyyx is invalid. xxxyyyxxyyxy is valid.

Example 1:

Input:s = xxyyOutput:1
Example 2:

Input:s = xyxOutput:0
Your Task:
Since this is a function problem, you don't need to take any input. Just complete the function follPatt(string s) that outputs 1 if string is valid, else it outputs 0. In a new line, print 1 if the string is valid else print 0.

Expected Time Complexity:O(|s|)
Expected Auxilary Space:O(1)

Constraints:
1 <= |s| <=100
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            obj.follPatt(str);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void follPatt(String s)
    {
        // Code here
        int count=0, i=0, res=1;
        
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)=='x'){
                count++;
                i++;
            }
            while(i<s.length() && s.charAt(i)=='y'){
                count--;
                i++;
            }
            if(count!=0){
                res=0;
                break;
            }
        }
        System.out.println(res);
        }
    }
