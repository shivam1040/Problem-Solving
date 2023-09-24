/*
Given a string S, check whether it can be converted into the string "hello" by deleting some characters from it.
Note : S can have both uppercase and lowercase letters.

Example 1:

Input:
S = "bbbbbxxhhelllllooudd"
Output: 1
Explanation: The string hello is marked
in bold: bbbbbxxhhelllllooudd

â€‹Example 2:

Input: 
S = "hlelo"
Output: 0
Explanation: It's impossible to convert
the given string into "hello".

Your Task:
You don't need to read input or print anything. Your task is to complete the function decode() which takes the string S as input and returns the true if the string can be converted to "hello", else return false.


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
                    if(obj.decode(s))
                        System.out.println("1");
                        
                    else
                        System.out.println("0");
                        
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean decode(String S)
    {
        //code here
        String aux="hello";
        int temp=0;
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)==aux.charAt(temp)){
                temp++;
                if(temp==aux.length())
                    break;
            }
        }
        return temp==aux.length();
    }
}
