/*
You are given N identical eggs and you have access to a K-floored building from 1 to K.

There exists a floor f where 0 <= f <= K such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break.
There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

For more description on this problem see wiki page

Example 1:

Input:
N = 1, K = 2
Output: 2
Explanation: 
1. Drop the egg from floor 1. If it 
   breaks, we know that f = 0.
2. Otherwise, drop the egg from floor 2.
   If it breaks, we know that f = 1.
3. If it does not break, then we know f = 2.
4. Hence, we need at minimum 2 moves to
   determine with certainty what the value of f is.
Example 2:

Input:
N = 2, K = 10
Output: 4
Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*(K^2))
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=200
1<=K<=200
*/

/*
Intuition
In this approach, we work on the same idea as described above neglecting the case of calculating the answers to sub-problems again and again. The approach will be to make a table that will store the results of sub-problems so that solving a sub-problem, would only require a look-up from the table which will take constant time, which earlier took exponential time.

Implementation
We make DP table that will store the minimum number of moves that you need to determine with certainty what the value of f is.
Let DP[i][j] will give the answer when we have i eggs and j floors. So our final answer will be DP[n][k].

Now we have to try to throw eggs from each of the floors and find the minimum value among those states.

DP[i][j] = min ( DP[i][j], 1+max( DP[i-1][f-1] , DP[i][j-f] ); for each floor f from 1 to j.

Below is the illustration of the above approach:

i => Number of eggs 
j => Number of floors

Look up find maximum 
Lets fill the table for the following case: 
Floors = ‘4’ 
Eggs = ‘2’

1 2 3 4
1 2 3 4 => 1 
1 2 2 3 => 2

For ‘egg-1’ each case is the base case so the 
number of attempts is equal to floor number.
For ‘egg-2’ it will take ‘1’ attempt for 1st 
floor which is base case.

For floor-2 => 
Taking 1st floor 1 + max(0, DP[1][1]) 
Taking 2nd floor 1 + max(DP[1][1], 0) 
DP[2][2] = min(1 + max(0, DP[1][1]), 1 + max(DP[1][1], 0))

For floor-3 => 
Taking 1st floor 1 + max(0, DP[2][2]) 
Taking 2nd floor 1 + max(DP[1][1], DP[2][1]) 
Taking 3rd floor 1 + max(0, DP[2][2]) 
DP[2][3]= min(‘all three floors’) = 2

For floor-4 => 
Taking 1st floor 1 + max(0, DP[2][3]) 
Taking 2nd floor 1 + max(DP[1][1], DP[2][2]) 
Taking 3rd floor 1 + max(DP[1][2], DP[2][1]) 
Taking 4th floor 1 + max(0, DP[2][3]) 
DP[2][4]= min(‘all four floors’) = 3 


*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int[][] dp=new int[k+1][n+1];
	    
	    //when egg is 1 and floor is i then number of attempts to find min floor is i
	    for(int i=1; i<=k; i++)
	        dp[i][1]=i;
	    for(int i=1; i<=k; i++)
	    //starting from egg 2 since 1 is already taken care
	        for(int j=2; j<=n; j++)
	        //if num eggs is greater than floor than that's same as floor, egg-1
	            if(j>i)
	                dp[i][j]=dp[i][j-1];
	            else{
	                //considering one possibility where all floors are used to find min floor
	                dp[i][j]=k+1;
	                //for all floors finding what's min number of egg drops required
	                for(int l=1; l<=i; l++)
	                //getting max of drops required whne both floors and eggs are used for one attempt and another case for egg is dropped from a floor but egg doesn't break
	                    dp[i][j]=Math.min(dp[i][j], 1+Math.max(dp[l-1][j-1], dp[i-l][j]));
	            }
	    return dp[k][n];
	}
}
