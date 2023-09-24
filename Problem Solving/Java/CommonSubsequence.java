/*
Given two strings a and b. Check whether they contain any common subsequence (non empty) or not.

Example 1:

Input:
a = "ABEF" b = "CADE"
Output: 1
Explanation: Subsequence "AE" occurs
in both the strings.

â€‹Example 2:

Input: 
a = "ABCD", b = "EFGH"
Output: 0
Explanation: There's no common subsequence
in both the strings.

Your Task:
You don't need to read input or print anything. Your task is to complete the function commonSubseq() which takes the string a and string b as inputs and returns true if there's a common subsequence in both the strings. Else, it returns false.


Expected Time Complexity: O(|a| + |b|).
Expected Auxiliary Space: O(1).


Constraints:
2 <= |a|, |b| <=105
*/

//{ Driver Code Starts

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
            String a = sc.next ();
            String b = sc.next ();
            
            if (new Sol().commonSubseq(a, b))
                System.out.println (1);
                
            else
                System.out.println (0);
    		   
        }
        
    }
}

// Contributed By: Pranay Bansal


// } Driver Code Ends



class Sol
{
    Boolean commonSubseq (String a, String b)
    {
        // your code here      
        int j=0;
        
        for(int i=0; i<a.length(); i++){
            String temp=a.charAt(i)+"";
            if(b.contains(temp))
                return true;
        }
        
        return false;
    }
}
