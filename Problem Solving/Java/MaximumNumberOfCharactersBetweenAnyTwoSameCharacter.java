/*
Given a string containing lower and uppercase alphabets, the task is to find the maximum number of characters between any two same character in the string.

Example 1:

Input:
S = "socks"
Output: 3
Explanation: There are 3 characters between
the two occurrences of 's'.
â€‹Example 2:

Input: 
S = "FoR"
Output: -1
Explanation: No repeating character present.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxChars() which takes the string S as input and returns the maximum number of characters between any two same characters in the string.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.maxChars(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxChars(String s)
    {
        //code here
        Map<Character, Integer> aux=new HashMap<>();
        int res=0;
        
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(aux.containsKey(c)){
                int index=aux.get(c);
                if(i-index>res)
                    res=i-index;
            }
            else
                aux.put(c, i);
        }
        return res-1;
    }
}
