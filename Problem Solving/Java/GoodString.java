/*
Given a string s of length N, you have to tell whether it is good or not. A good string is one where the distance between every two adjacent character is exactly 1. Here distance is defined by minimum distance between two character when alphabets from 'a' to 'z' are put in cyclic manner. For example distance between 'a' to 'c' is 2 and distance between 'a' to 'y' is also 2. The task is to print "YES" or "NO" (without quotes) depending on whether the given string is Good or not.

 

Example 1:

Input: s = "aaa"
Output: NO
Explanation: distance between 'a' and 'a' is not 1.
 

Example 2:

Input: s = "cbc"
Output: YES
Explanation: distance between 'b' and 'c' is 1.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isGoodString() which accepts a string as input parameter and returns "YES" or "NO" (without quotes) accordingly.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 

Constraints:
String contains only lower case english alphabets.

1 <= N <= 105
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
            String s = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.isGoodString(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String isGoodString(String s) 
    { 
        // code here
        for(int i=1; i<s.length(); i++){
            if(Math.abs(s.charAt(i)-s.charAt(i-1))!=1 && Math.abs(s.charAt(i)-s.charAt(i-1))!=25)
                return "NO";
        }
        return "YES";
    }
} 
