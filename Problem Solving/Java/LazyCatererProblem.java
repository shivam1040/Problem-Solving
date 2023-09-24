/*
Given an integer n, denoting the number of cuts that can be made on a pancake, find the maximum number of pieces that can be formed by making n cuts.
NOTE: Cuts can't be horizontal.
 

Example 1:

Input: N = 5
Output: 16
Explanation:  16 pieces can be formed by
making 5 cuts.
Example 2:

Input: N = 3
Output: 7
Explanation: 7 pieces can be formed by 
making 3 cuts.
 

Your Task: 
You don't need to read or print anything. Your task is to complete the function maximum_Cuts() which takes n as input parameter and returns the maximum number of pieces that can be formed by making n cuts.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 10000
*/
/*
Let f(n) denote the maximum number of pieces
that can be obtained by making n cuts.
Trivially,
f(0) = 1                                 
As there'd be only 1 piece without any cut.

Similarly,
f(1) = 2

Proceeding in similar fashion we can deduce 
the recursive nature of the function.
The function can be represented recursively as :
f(n) = n + f(n-1)

Hence a simple solution based on the above 
formula can run in O(n). 
We can optimize above formula. 
 

We now know ,
f(n) = n + f(n-1) 

Expanding f(n-1) and so on we have ,
f(n) = n + n-1 + n-2 + ...... + 1 + f(0)

which gives,
f(n) = (n*(n+1))/2 + 1
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
            int ans = ob.maximum_Cuts(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximum_Cuts(int n)
    {
        // code here
        return (n*(n+1))/2 + 1;
    }
}
