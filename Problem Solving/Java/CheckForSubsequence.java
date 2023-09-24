    /*
Given two strings A and B, find if A is a subsequence of B.

Example 1:

Input:
A = AXY 
B = YADXCP
Output: 0 
Explanation: A is not a subsequence of B
as 'Y' appears before 'A'.
 

Example 2:

Input:
A = gksrek
B = geeksforgeeks
Output: 1
Explanation: A is a subsequence of B.
 

Your Task:  
You dont need to read input or print anything. Complete the function isSubSequence() which takes A and B as input parameters and returns a boolean value denoting if A is a subsequence of B or not. 

 

Expected Time Complexity: O(N) where N is length of string B.
Expected Auxiliary Space: O(1)


Constraints:
1<= |A|,|B| <=104
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
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isSubSequence(String A, String B){
        int j=0;
        
        // Traverse str2 and str1, and compare
        // current character of str2 with first
        // unmatched char of str1, if matched
        // then move ahead in str1
        //basically every char of A should fall before/in same order in B, no matter of the position
        for(int i=0; i<B.length() && j<A.length(); i++){
            if(A.charAt(j)==B.charAt(i))
                j++;
        }
        return j==A.length();
    }
}
