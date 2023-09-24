/*
Geek works at the post office and he writes the following types of letters.

Corporate Letters: 12 letters of this type can be written in an hour.
Informal Letters: 10 letters of this type can be written in an hour.
Given N number of letters, find the minimum number of hours he needs to generate a combination of both types without wasting any time.

 

Example 1:

Input: N = 33
Output: -1
Explaination: 33 letters can not be generated
without wasting any time.
 

Example 2:

Input: N = 36
Output: 3
Explaination: 36 corporate letters can 
be written in 3 hours.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function minHours() which takes the value N as input parameters and returns the minimum hours. Return -1 if N letters cannot be written without wasting any time.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minHours(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minHours(int N){
        // code here
        int dp[]=new int[N+1];
        
        dp[0]=0;
        
        for(int i=1; i<=N; i++){
            dp[i]=-1;
            
            if(i-10>=0 && dp[i-10]!=-1)
            //this increments count at every index reachable from 10 considering the previous value, to get most of the letters
            //doing dp[i-10]!=-1 ensures we also consider combination of 10 and 12hours when finding number of hours to be give at any range of number in N
                dp[i]=dp[i-10]+1;
            if(i-12>=0 && dp[i-12]!=-1)
                dp[i]=dp[i-12]+1;
        }
        return dp[N];
    }
}


