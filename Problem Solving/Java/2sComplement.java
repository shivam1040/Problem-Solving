/*
For a given string of binary number bi. Find the two’s complement of it.

Example 1:

Input: bi = 00000101
Output: 11111011
Explaination: 2's complement is reversing all 
the bits of the given number and then adding 
1 to it.
Example 2:

Input: bi = 101
Output: 011
Explaination: Follow the process of figuring 
out 2's complement. This will be the answer.
Your Task:
You do not need to read input or print anything. Your task is to complete the function complement() which takes bi as input parameter and returns the 2's complement of the number.

Expected Time Complexity: O(|bi|)
Expected Auxiliary Space: O(|bi|)

Constraints:
1 ≤ |bi| ≤ 10
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String bi = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.complement(bi));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String complement(String bi){
        // code here
        char ch[]=bi.toCharArray();
        
        for(int i=0; i<ch.length; i++){
            if(ch[i]=='0')
                ch[i]='1';
            else
                ch[i]='0';
        }
        
        for(int i=ch.length-1; i>=0; i--)
            if(ch[i]=='0'){
                ch[i]='1';
                break;
            }
            else
                ch[i]='0';
        return new String(ch);
    }
}
