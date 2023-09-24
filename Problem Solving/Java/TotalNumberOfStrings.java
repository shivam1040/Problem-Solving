/*
Given 3 characters 'a', 'b', 'c'. Find the number of strings of length n that can be formed from these 3 characters. Given that : we can use ‘a’ as many times as we want, ‘b’ maximum once, and ‘c’ maximum twice.
 

Example 1:

Input: n = 2
Output: 8
Expalantion: There are total 8 possible
strings and these are: {aa, ab, ba, ac,
ca, bc, cb, cc}.
Example 2:

Input: n = 3
Output: 19
Explanation: There are total 19 possible
strings.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function no_ofString() which takes n as input parameter ans returns the no. of total possible strings than can be formed using characters 'a', 'b' and 'c' modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Compelxity: O(n)
 

Constraints:
1 <= n <= 100000


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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.no_ofString(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int no_ofString(int n)
    {
        // code here
        //
         long m= 1000000007;
         
         //number of arrangements that can be made for this condition 
         long Ans=1+2*(n%m)+((n%m)*((n%m)-1)*((n%m)+1)/2);

         long h=Ans%m;

         return (int)h;
    }
}
