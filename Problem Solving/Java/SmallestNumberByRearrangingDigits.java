/*
Given a number s(in string form). Find the Smallest number (Not leading Zeros) which can be obtained by rearranging the digits of given number.
 

Example 1:

Input: s = "846903"
Output: 304689
Explanation: 304689 is the smallest number
by rearranging the digits.
Example 2:

Input: s = "55010"
Output: 10055
Explanation: 10055 is the smallest number 
by rearranging the digts.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minimum_number() which takes the number as input parameter and returns the smallest number than can be formed without leading zeros by rearranging the digits of the number.
 

Expected Time Complexity: O(N * log(N)) where N is the number of digits of the given number
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 105
*/

/*
Another way to do this is to use counting sort
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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.minimum_Number(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String minimum_Number(String s)
    {
        // code here
        char ch[]=s.toCharArray();
        int in=0;
        StringBuffer res = new StringBuffer();
        
        Arrays.sort(ch);
        
        for(int i=0; i<ch.length; i++){
            if(ch[i]!='0'){
                in=i;
                break;
            }
        }
        char temp=ch[0];
        ch[0]=ch[in];
        ch[in]=temp;
        
        for(char chx:ch)
            res.append(chx);
        return res.toString();
    }
}
