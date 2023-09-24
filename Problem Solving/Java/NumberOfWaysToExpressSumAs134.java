/*
Given N, count the number of ways to express N as sum of 1, 3 and 4 modulo (109+7).

 

Example 1:

Input:
N = 1
Output:
1
Explanation:
There is only one way to represent 1 as
sum of 1,3 and 4. 1 = {1}.
Example 2:

Input:
N = 3
Output:
2
Explanation:
There is 2 ways to represent 3 as sum
of 1,3 and 4. 3 = {1,1,1}, and 3 = {3}.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countWays() which takes a Integer N as input and returns the number of ways possible.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long countWays(int n) {
        // code here
        
        if(n<=2) return (long)1;
      if(n==3) return (long)2;
      if(n==4) return (long)4;
      
          long DP[] = new long[n + 1];
 
        // base cases
        DP[0] = DP[1] = DP[2] = 1;
        DP[3] = 2;
        
        long one=2, two=1, three=1, four=1;
        long ans=0;
        // iterate for all values from 4 to n
        
        // for (int i = 4; i <= n; i++)
        //     DP[i] = (DP[i - 1]%1000000007 + DP[i - 3]%1000000007
        //             + DP[i - 4]%1000000007)%1000000007;
        
        //using o(1) space
        for(int i=4; i<=n; i++){
            ans=(one%1000000007+three%1000000007+four%1000000007)%1000000007;
            four=three;
            three=two;
            two=one;
            one=ans;
        }
        return ans;
    }
};
