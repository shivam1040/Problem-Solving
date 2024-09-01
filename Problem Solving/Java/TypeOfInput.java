/*
Given an input A , print the data type of the input A.
eg:-Sequence of digits -- int
      Sequence of digits with a dot -- float
      Sequence of chars  -- string
      Single non-digit char --- char
 

Example 1:

Input: A = "12"
Output: "int"
Explanation: The input consists only of
digits.
Example 2:

Input: A = "gfg"
Output: "string"
Explanation: The input consists only of
characters.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FindInputType() which takes A as input parameter and returns data type of A.
 

Expected Time Complexity: O(|A|)
Expected Space Complexity: O(1)
 

Constraints:
1 <= |A| <= 1000
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FindInputType(str);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String FindInputType(String str)
    {
        // code here
        if(str.length()==1)
            if(str.charAt(0)>='0' && str.charAt(0)<='9')
                return "int";
            else
                return "char";
        int dot=0;
        
        for(char i:str.toCharArray()){
            if(!(i>='0' && i<='9') || i=='.')
                return "string";
            if(i=='.')
                dot++;
        }
        if(dot==1)
            return "float";
        if(dot>1)
            return "string";
        return "int";
    }
}
