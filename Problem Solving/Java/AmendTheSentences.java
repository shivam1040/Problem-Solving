/*
Given a string which is basically a sentence without spaces between words. However the first letter of every word is in uppercase. You need to print this sentence after following amendments:
(i) Put a single space between these words
(ii) Convert the uppercase letters to lowercase.
Note: The first character of the string can be both uppercase/lowercase.

Example 1:

Input:
s = "BruceWayneIsBatman"
Output: bruce wayne is batman
Explanation: The words in the string are
"Bruce", "Wayne", "Is", "Batman".

â€‹Example 2:

Input: 
s = "You"
Output: you
Explanation: The only word in the string
is "You".

Your Task: 
You don't need to read input or print anything. Your task is to complete the function amendSentence() which takes the string s as input and returns a string with the stated amendments.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N) (for output string).


Constraints:
1<=Size of String <=106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
        StringBuilder res = new StringBuilder();
        res.append(Character.toLowerCase(s.charAt(0)));
        
        for(int i=1; i<s.length(); i++){
            char ch=s.charAt(i);
            if(Character.isUpperCase(ch))
                res.append(" "+Character.toLowerCase(ch));
            else
                res.append(ch);
        }
        
        //char ch=res.charAt(0);
        //ch=Character.toLowerCase(ch);
        //res=ch+res.substring(1, res.length());
        
        return res.toString();
    }
}


