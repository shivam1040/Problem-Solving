/*
Given a string S, the task is to check if a string is a non-repetitive or not.  A non-repetitive string is defined as a string that does not contain any different character between two same characters

Example 1:

Input: S = "AABBCCCCC"
Output: 1
Explanation: No different character is 
placed between the two same characters.
Example 2:

Input: S = "ABA"
Output: 0
Explanation: B is in between two A's
Your Task:
You don't need to read input or print anything. Your task is to complete the function nonRepetitive() which takes a string S as input and returns the boolean value.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(constant).


Constraints:
1 <= |S| <= 105
S contains upper case English alphabets
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String S = br.readLine();
                    Solution ob = new Solution();
                    if(ob.nonRepetitive(S)==true)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean nonRepetitive(String S)
    {
        // Your code goes here
        Set<Character> aux=new HashSet<>();
        
        for(int i=0; i<S.length(); i++){
            //keeps track of the last char so that we can ensure all the characters if repeated then they are together
            if(!aux.contains(S.charAt(i)))
                aux.add(S.charAt(i));
            else if(S.charAt(i)!=S.charAt(i-1))
                    return false;
        }
        return true;
    }
}
