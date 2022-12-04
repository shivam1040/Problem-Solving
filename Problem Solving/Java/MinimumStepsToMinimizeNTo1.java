/*
Given a number N, the task is to count minimum steps to minimize it to 1 according to the following criteria:

If N is divisible by 2 then you may reduce N to N/2.
If N is divisible by 3 then you may reduce N to N/3.
Otherwise, Decrement N by 1.
Example 1:

Input: N = 10
Output: 3
Explanation: 10 - 1 = 9 / 3 = 3 / 3 = 1
Example 2:
Input: N = 1
Output: 0
Explanation: N is 1

Your Task:  
You don't need to read input or print anything. Complete the function minSteps() which takes N as input parameters and returns the integer value

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minSteps(int N) 
	{ 
	    // Your code goes here
	    int dp[]=new int[N+1];
	    
	    Arrays.fill(dp, -1);
	    //return cal(N, dp);
	    
	    //top down approach
	    for(int i=2; i<=N; i++){
	        int res=res=dp[i-1];
	        
	        //these blocks ensure that we go back to the previous number in minimum steps possible
	        if(i%3==0)
	            res=Math.min(res, dp[i/3]);
	        if(i%2==0)
	            res=Math.min(res, dp[i/2]);
	        dp[i]=1+res;
	    }
	    return dp[N]+1;
	}
	
	//bottom up approach
	private int cal(int n, int dp[]){
	    if(n==1)
	        return 0;
	    if(dp[n]!=-1)
	        return dp[n];
	        
	    int res=cal(n-1, dp);
	    
	    if(n%2==0)
	        res=Math.min(res, cal(n/2, dp));
	    if(n%3==0)
	        res=Math.min(res, cal(n/3, dp));
	        //this 1 is what adds value to res when going down the recursion tree, this 1 also means to account for the current itereation process
	    return dp[n]=1+res;
	}
}

