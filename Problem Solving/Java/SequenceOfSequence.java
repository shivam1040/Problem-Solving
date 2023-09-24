/*
Given two integers m & n, find the number of possible sequences of length n such that each of the next element is greater than or equal to twice of the previous element but less than or equal to m.


Example 1:

Input: m = 10, n = 4
Output: 4
Explaination: There should be n elements and 
value of last element should be at-most m. 
The sequences are {1, 2, 4, 8}, {1, 2, 4, 9}, 
{1, 2, 4, 10}, {1, 2, 5, 10}.

Example 2:

Input: m = 5, n = 2
Output: 6
Explaination: The sequences are {1, 2}, 
{1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}.

Your Task:
You do not need to read input or print anything. Your task is to complete the function numberSequence() which takes the number m and n as input parameters and returns the number of sequences.


Expected Time Complexity: O(m*n)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ m, n ≤ 100
*/

/*
As per the given condition, the n-th value of the sequence can be at most m. There can be two cases for the n-th element:  

If it is m, then the (n-1)th element is at most m/2. We recur for m/2 and n-1.
If it is not m, then it is at most is m-1. We recur for (m-1) and n.
The total number of sequences is the sum of the number of sequences including m and the number of sequences where m is not included. Thus the original problem of finding number of sequences of length n with max value m can be subdivided into independent subproblems of finding number of sequences of length n with max value m-1 and number of sequences of length n-1 with max value m/2.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        int dp[][]=new int[m+1][n+1];
        
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return solve(m, n, dp);
        
    }
    
    private static int solve(int m, int n, int dp[][]){
        if(m<n)
            return 0;
        if(n==0)
            return 1;
        if(dp[m][n]!=-1)
            return dp[m][n];
        return dp[m][n]=solve(m/2, n-1, dp)+solve(m-1, n, dp);
    }
}
