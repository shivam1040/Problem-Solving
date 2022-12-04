/*
You are given N balls numbered from 1 to N and there are N baskets numbered from 1 to N in front of you, the ith basket is meant for the ith ball. Calculate the number of ways in which no ball goes into its respective basket.


Example 1:

Input: N = 2
Output: 1
Explanation: The balls are numbered 1 and 2. 
Then there is only one way to dearrange them. 
The (number-basket) pairs will be [(1-2),(2-1)].

Example 2:

Input: 3
Output: 2
Explanation: The (number-basket) pairs are 
[(1-3),(2-1),(3-2)] and [(1-2),(2-3),(3-2)].

Your Task:
You do not need to read input or print anything. Your task is to complete the function disarrange() , which takes the number N as input parameter and returns the number of ways to disarrange them. As the number can be very big return it modulo 109 + 7


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.disarrange(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static long disarrange(int n){
        // code here
        long dp[]=new long [n+1];
        
        dp[1]=0;
        dp[2]=1;
        
        for(int i=3; i<=n; i++){
            dp[i]=(i-1)*(dp[i-1]%1000000007+dp[i-2]%1000000007)%1000000007;
        }
        return dp[n];
    }
}
