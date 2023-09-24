/*
Given a rope of length N meters, cut the rope into several ropes of varying lengths in a way that maximizes product of lengths of all resulting ropes. You must make at least one cut.

Example 1:

Input:
N = 2
Output: 1
Explanation: Since 1 cut is mandatory.
Maximum obtainable product is 1*1 = 1.

Example 2:

Input:
N = 5
Output: 6
Explanation: 
Maximum obtainable product is 2*3 = 6.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes n as input parameter and returns the maximum product.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 100
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().maxProduct(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    long maxProduct(int n) {
        // code here
//          if (n == 2 || n == 3 || n==1) 
//             return (n-1);
//         long res=1;
//         while (n > 4)
//   {
//       n -= 3;
//       res *= 3; // Keep multiplying 3 to res
//   }
//   return (n * res);
        long dp[]=new long[n+1];
        
        //base condition, 1 cut
        dp[0]=1;
        
        for(int i=0; i<=n; i++){
            for(int j=1; j<n; j++){
                if(i+j<=n)
                //dp[i] denotes max sum obtained when lhs has i in it with any cobination of j
                    dp[i+j]=Math.max(dp[i+j], dp[i]*j);
            }
        }
        return dp[n];
    }
}
