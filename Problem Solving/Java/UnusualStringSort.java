/*
Given a string composed of both lowercase and uppercase letters. Sort it in such a manner such that the uppercase and lowercase letter comes in an alternate manner but in sorted way.

Example 1:

Input:
S = bAwutndekWEdkd
Output: AbEdWddekkntuw
Explanation: letters A,E,W are sorted 
as well as letters b,d,d,d,e,k,k,n,t,u,w are 
sorted and both appears alternately in the 
string as far as possible.
â€‹Example 2:

Input: 
S = AiBFR
Output: AiBFR
Explanation: letters A,B,F,R and sorted 
as well as letter i. 

User Task:
You don't need to read input or print anything. You just have to complete the function stringSort () which takes a string as input and returns the sorted string as described in the problem description.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1). 


Constraints:
1<=|S|<=1000


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().stringSort (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static String stringSort (String s)
    {
        // your code here
        int l[]=new int[26], u[]=new int[26];
        int k=0, i=0, j=0, size=s.length();
        
        for(char c:s.toCharArray())
            if(Character.isUpperCase(c))
                u[c-'A']++;
            else
                l[c-'a']++;
        s="";
             
             //idead is to traverse one after another starting from u to l   
        while(k<size){
             while (i < u.length && u[i] == 0)
                i++;
             if(i<u.length){
                s+=(char) ('A'+i);
                u[i]--;
                k++;
             }
             while (j < l.length && l[j] == 0)
                j++;
            if(j<l.length){
                s+=(char) ('a'+j);
                l[j]--;
                k++;
            }
        }
        return s;
    }
}
