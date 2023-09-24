/*
Given a point on x axis, (N,0), you are standing at origin and you can only move on x-axis. Lets say you are at (x,0), at each step you can either move one step forward ie (x+1,0) or one step backwards (x-1,0) or make a jump to double your current position (2*x,0). One step movement costs you A while a jump costs you B. If your initial position is (0,0) , find the minimum cost to reach (N,0) .


Example 1:

Input: N = 7, A = 1, B = 100
Output: 7
Explaination: Move forward to (N, 0) one 
unit at each step.

Example 2:

Input: N = 8, A = 2, B = 4
Output: 12
Explaination: The optimal movement is to 
1, 2, 3, 4, 8.

Your Task:
You do not need to read input or print anything. Your task is to complete the function optimalWalk() which takes N, A and B as input parameters and returns the minimum cost to go to (N, 0) from (0, 0).


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ A, B ≤ 109   


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            long N = Long.parseLong(arr[0]);
            long A = Long.parseLong(arr[1]);
            long B = Long.parseLong(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.optimalWalk(N, A, B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long optimalWalk(long Nn, long A, long B)
    {
        // code here
        int N=(int)Nn;
        long dp[]=new long[N+1];
        
        dp[0]=0;
        //initially we cannot jump, we can step forward
        dp[1]=A;
        
        for(int i=2; i<=N; i++)
        //cost for moving one step forward, or min from juming two blocks and moving backwards, i%2 ensures we do not move ba//kwards in negatives
        //i+1/2 ensures we jump from last jumped to postionon
            dp[i]=Math.min(dp[i-1]+A, (i%2)*A+dp[(i+1)/2]+B);
        
        return dp[N];
    }
}
