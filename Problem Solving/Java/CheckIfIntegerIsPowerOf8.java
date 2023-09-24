/*
Given a positive integer N, The task is to find if it is a power of eight or not.

Example 1: 

Input: 64
Output: Yes
Explanation: 64 is power of 8.
Example 2:

Input: 75
Output: No
Explanation: 75 is not a power of 8.

Your Task:
You don't need to read or print anything. your task is to complete the function is_power_of_eight() which takes N as the input parameter and returns "Yes" if N is power of eight otherwise returns "No"(Wihtout quotes).

Expected Time Complexity: O(log(N))
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 1018
*/

/*
We calculate log8(n) of the number if it is an integer, then n is in the power of 8. We use trunc(n) function that finds the closest integer for a double value
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
            Long n = Long.parseLong(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.is_power_of_eight(n);
            System.out.println(ans);
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String is_power_of_eight(Long n)
    {
        // Code here
        int res=1;
        
        
        double i=Math.log(n)/Math.log(8);
        return (i-Math.floor(i)<0.000001) ? "Yes" : "No";
    }
}

