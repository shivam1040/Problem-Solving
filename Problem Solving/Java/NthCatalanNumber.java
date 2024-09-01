/*
Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …

Catalan Number for N is equal to the number of expressions containing N pairs of paranthesis that are correct matched, i.e., for each of the N '(' there exist N ')' on there right and vice versa.

Since answer can be huge return answer modulo 1e9+7.

Note: Positions start from 0 as shown above.

Example 1:

Input:
N = 3
Output: 5
Explanation:
((())),(()()),()(()),(())(),()()()

Example 2:

Input:
N = 4
Output: 14
Your Task:
Complete findCatalan() function that takes n as an argument and returns the Nth Catalan number. The output is printed by the driver code.

Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103


*/

/*
The idea is to use following formula:


 
Implementation
Base case, if n is 0 or n is 1, then return 1.
Create an array dp[] of size n+1 for storing ith Catalan number.
Initialize, dp[0] and dp[1] = 1
Loop through i = 2 to the given Catalan number n: 
   Nested loop through j = 0 to j < i and Keep adding value of dp[j] * dp[i – j – 1] into dp[i].
Finally, return dp[n].
Example
n=4
output= 14


 

*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        // code here
        long mod=1000000007;
        long [] catalan=new long[n+1];
        catalan[0]=1;
        
        for(int i=1; i<=n; i++)
            for(int j=0; j<i; j++){
                //finding number of pairs inside and number of pairs outside
                catalan[i]+=(catalan[j]*catalan[i-1-j])%mod;
                catalan[i]%=mod;
            }
        return (int)catalan[n];
    }
}
        

