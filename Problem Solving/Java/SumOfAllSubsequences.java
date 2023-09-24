/*
Given a number as integer s, find the sum of all the elements present in all possible subsequences of s.

Example 1:

Input:  S = "123" 
Output: 24
Explanation: {1}, {2}, {3}, {1, 2}, {2, 3}
{1, 3}, {1, 2, 3} are all possible sub-
sequences
Example 2:

Input:  S = "5"
Output: 5
Explanation: {5} is the only possible 
sub sequence

User Task:
Your task is to complete the function subsequnceSum() which takes a single string as inputs and returns the sum. You need not take any input or print anything.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |S| <= 20
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.subsequenceSum(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int subsequenceSum(String s) {
        // code here
        int su=0;
        
        for(char i:s.toCharArray())
            su+=i-'0';
        return su*(int)Math.pow(2, s.length()-1);
        
    }
} 
