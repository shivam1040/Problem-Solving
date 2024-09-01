/*
Given a number N, find the total number of possible X such that (N XOR X) == (N OR X), where 0<=X<=N.

Example 1:

Input: N = 5
Output: 2
Explanation:
5 XOR 2 == 5 OR 2 and 
5 XOR 0 == 5 OR 0
Example 2:

Input: N = 7
Output: 1
Explanation: 7 XOR 0 == 7 OR 0

Your Task:
You don't need to read or print anything. Your task is to complete the function total_count() which takes N as input parameter and returns total count of X. 
 

Expected Time Complexity: O(log(N))
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 1018 
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
            long n = Long.parseLong(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.total_count(n);
            System.out.println(ans);
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long total_count(long n)
    {
        // Code here
        long res=1;
        
        while(n>0){
            //get the last significatn bit, basically binary representation
            long temp=n%2;
            
            if(temp==0)
            //Check if temp is equal to 0. If it is, multiply the count by 2. This corresponds to the two possibilities for the next bit of X: it can be 0 or 1. Multiplying by 2 accounts for this doubling of possibilities.
           //checking on zero condition to ensure xor and or are same with X
		 res*=2;
            //move to right to remove last significant bit
            n/=2;
        }
        return res;
    }
}

