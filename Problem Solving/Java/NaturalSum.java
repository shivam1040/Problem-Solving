/*
Given N, find s such that sum of first s natural number is N.
 

Example 1:

Input: N = 10
Output: 4
Explanation: Sum of first 4 natural
number is 1 + 2 + 3 + 4 = 10.     
Example 2:

Input: N = 17
Output: -1
Explanaion: There is no such number.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function find() which takes N as input parameter and returns s. If not possible return -1.
 

Expected Time Complexity: O(log(N))
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 109
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
            int ans = ob.find(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int find(int N)
    {
        // code here
        
        //quadratic eqn
        double a=(-1+Math.sqrt(1-(4*-2*N)))/2;
        
        //System.out.println(a+" "+b);
        int s=(int)a;
        int su=s*(s+1)/2;
        
        if(su!=N)
            return -1;
        return s;
    }
}
