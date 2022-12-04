/*
Given two strings consisting of lowercase english alphabets, the task is to check whether these strings are meta strings or not. Meta strings are the strings which can be made equal by exactly one swap in any of the strings. Equal string are not considered here as Meta strings.

Example 1:

Input:
S1 = "geeks", S2 = "keegs"
Output: 1
Explanation: We can swap the 0th and 3rd
character of S2 to make it equal to S1.
â€‹Example 2:

Input: 
S1 = "geeks", S2 = "geeks"
Output: 0
Explanation: Equal strings are not considered
Meta strings.

Your Task:
You don't need to read input or print anything. Your task is to complete the function metaStrings() which takes the strings S1 and S2 as input and returns true if both the strings are meta strings, else it returns false.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105


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
            String S1 = read.readLine().trim(); 
            String S2 = read.readLine().trim(); 
            Solution obj = new Solution();
            if(obj.metaStrings(S1, S2))
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
    boolean metaStrings(String S1, String S2) 
    { 
        // code here
        char s1[]=S1.toCharArray();
        char s2[]=S2.toCharArray();
        
        if(S1.equals(S2))
            return false;
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0; i<s1.length || i<s2.length; i++){
            if(s1[i]!=s2[i])
                return false;
        }
        return true;
    }
} 



