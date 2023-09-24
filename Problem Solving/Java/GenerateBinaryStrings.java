/*
Given a string containing of 0, 1 and ? - a wildcard character, generate all distinct binary strings that can be formed by replacing each wildcard character by either 0 or 1.

Example 1:

Input: 1??0?101
Output: 10000101 10001101 10100101 10101101 
11000101 11001101 11100101 11101101
Explanation:
There will be 8 such possible strings that 
can be formed, they are 10000101, 10001101, 
10100101, 10101101, 11000101, 11001101, 
11100101 and 11101101.
Example 2:

Input: 10?
Output: 100 101
Explanation: There are 2 such possible strings
and they are 100 and 101.
Your Task:
You don't need to read or print anything. Your task is to complete the function generate_binary_string() which takes the given string as input parameter and returns a vector of strings containing all the possible strings that can be formed.

Note : Strings should be printed in lexicographically increasing order.

Expected Time complexity: O(2n)
Expected Space complexity: O(n*2n)

Constraints:
1 ≤ length of string ≤ 30
Note: Number of '?' in any string does not exceed 15.
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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> res  = ob.generate_binary_string(s);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public List<String>generate_binary_string(String s)
    {
        // Code here
        List<String> res=new ArrayList<String>();
        
        gen(res, s);
        
        return res;
    }
    
    private void gen(List<String> res, String s){
        // we store processed strings in all (array)
  // we see if string as "?", if so, replace it with 0 and 1
  // and send it back to recursive func until base case is reached
  // which is no wildcard left
        if(s.indexOf('?')!=-1){
            String s1=s.replaceFirst("\\?", "0");
            gen(res, s1);
            String s2=s.replaceFirst("\\?", "1");
            gen(res, s2);
        }
        else
            res.add(s);
    }
}
