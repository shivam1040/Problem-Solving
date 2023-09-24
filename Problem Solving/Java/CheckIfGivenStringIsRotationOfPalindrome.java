/*
Given a string s, check if it can be rotated to form a palindrome.

Example 1:

Input:
s = aaaab
Output: 1 
Explanation: "aaaab" can be rotated to
form "aabaa" which is a palindrome.

Your Task:  
You dont need to read input or print anything. Complete the function isRotatedPalindrome() which takes a string s as input parameter and returns 1 if rotated palindrome is possible, otherwise 0.


Expected Time Complexity: O(N2) where N is length of s
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= s.length() <= 104
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
            
            String s = sc.next();
            
            int answer = new Solution().isRotatedPalindrome(s);
    		System.out.println(answer);
        }
        
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    int isRotatedPalindrome(String s)
    {
        // Your Code Here       
        for(int i=0; i<s.length(); i++){
            //tries every possible rotation to check if it is palindrome
            // aaaab rotation by one shift is aaab+a
            String rot=s.substring(i, s.length()) + s.substring(0, i);
            
            if(isPalindrome(rot))
                return 1;
        }
        return 0;
    }
    
        boolean isPalindrome(String str)

    {

        int i=0,j=str.length()-1;

        while(i<=j){

            if(str.charAt(i)!=str.charAt(j)){

                return false;

            }else{

                i++;

                j--;

            }

        }

        return true;

    }
}
