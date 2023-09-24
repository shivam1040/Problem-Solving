/*
Given an array s containing n strings, find the length of the string obtained by combining the strings. Two strings can be only combined if the last character of the first string and the first character of the second string are the same.

Example 1:

Input:
n = 3
s[] = {"RBR", "BBR", "RRR"}
Output: 9
Explanation: Combined string can 
             be: BRR + RBR + RRR
Example 2:

Input:
n = 2
s[] = {"RRR", "BBB"}
Output: 0
Explanation: Since combining condition
             isn't fulfilled answer is 0.
Your Task:
Your task is to complete the function combine() which takes 2 arguments(integer n and array of n strings) and returns the maximum length of combined strings possible. If no 2 strings can be combined return 0. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
2<=n<=1000
1<=|si|<=1000, where 0<=i<n
s will only contain {R,B}
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
                    int n=sc.nextInt();
                    
                    String[] s=new String[n];
                    for(int i=0;i<n;i++)
                        s[i] = sc.next();
                    
                    Solution obj = new Solution();
                    System.out.println(obj.combine(n,s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int combine(int n, String s[])
    {
        //code here
        int ans=0, rr=0, bb=0, br=0, rb=0;
        
        for(String i: s){
            char f=i.charAt(0);
            char b=i.charAt(i.length()-1);
            
            if(f=='R' && b=='R')
                rr++;
            else if(f=='B' && b=='B')
                bb++;
            else if(f=='R' && b=='B')
                rb++;
            else if(f=='B' && b=='R')
                br++;
        }
        
       int min=Math.min(rb,br);
	    if(rb==0 && br==0)
	        ans=Math.max(rr,bb);
	    else if(rb==br)
	        ans=rr+bb+(2*min);
	    else
	        ans=rr+bb+(2*min)+1;
	        
	   ans*=s[0].length();
	   if(ans==s[0].length())
            return 0;
        else return ans;
    }
}
