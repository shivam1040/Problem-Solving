/*
Anuj has challenged Arun to climb N stairs but at only in powers of P and Q. Now Arun being a lazy guy wants to do this in minimum number of steps possible. So he has asked for your help to calculate the minimum number of steps he requires to take for climbing N stairs ( 1 step = some power of P or Q stairs (including zeroth power) ).


Example 1:

Input: 
N = 15, P = 2, Q = 3
Output:
3
Explanation:
We can make 15 by (8,4,3)
or (9,3,3) both takes 3 steps.
 

Example 2:

Input: 
N = 19, P = 4, Q = 3
Output:
2
Explanation:
In the second case, we can make
19 by (16,3) which is 2 steps.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function moves() which takes three integers N, P and Q as inputs and returns the number of steps that Arun needs to take to climb N stairs in powers of P & Q. If fit is not possible print -1.
 

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N. log(N))
 

Constraints:
1 ≤ N, P, Q ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long p = Long.parseLong(stt.nextToken());
            long q = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println(obj.moves(n, p, q));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public long moves(long n, long p, long q)
    {
        // Your code goes here
        long dp[]=new long[(int)n+1];
        
        //filling with max to ensure min calculation is easy
        Arrays.fill(dp, Long.MAX_VALUE);
        
        //0 number os stairs=no moves
        dp[0]=0;
        
        for(int i=1; i<=n; i++){
            //find min step for p at i
            long stepP=check(i, p, dp);
            long stepQ=check(i, q, dp);
            dp[i]=Math.min(stepP, stepQ);
        }
        return dp[(int)n];
    }
    
    private long check(long n, long pow, long dp[]){
        long a=1, res=Long.MAX_VALUE;
        //if pow is 1 then all amountt of powering it would give 1
        if(pow==1)
            return n;
            //until now finding the minimum possible move required by powering pow from dp to reach n, starting from begigining of dp
        while(n-a>=0){
            res=Math.min(res, dp[(int)(n-a)]);
            a*=pow;
        }
        //+1 means the addition of current move itself
        return res+1;
    }
}
