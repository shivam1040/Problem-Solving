/*
Given an integer N, the task is to find the number of ways we can choose 3 numbers from {1, 2, 3, …, N} such that their sum is even.

Note: Answer can be very large, output answer modulo 109+7

Example 1:

Input: N = 3
Output: 1
Explanation: Select {1, 2, 3}
Example 2:

Input: N = 4
Output: 2
Explanation: Either select {1, 2, 3} or 
{1, 3, 4}

Your Task:  
You don't need to read input or print anything. Complete the function countWays() which takes N as input parameter and returns the integer value.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
*/

/*
To get sum even there can be only 2 cases: 
 


Take 2 odd numbers and 1 even.
Take all even numbers.
 

If n is even,
  Count of odd numbers = n/2 and even = n/2.
Else
  Count odd numbers = n/2 +1 and even = n/2.
Case 1 – No. of ways will be : oddC2 * even. 
Case 2 – No. of ways will be : evenC3.
So, total ways will be Case_1_result + Case_2_result. 
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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            
            System.out.println(ob.countWays(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(int N) {
        // code here
        long res, odd=N/2, even=N/2, mod=1000000007;
        
        if((N&1)>0)
            odd++;
        
        res=(((odd*(odd-1))/2)*even)%mod;
        res=(res+((even*(even-1)*(even-2))/6))%mod;
        
        //         res = (((odd * (odd - 1)) / 2) 
        //                   * even) % mod; 
      
        // // Case 2: 3 evens 
        // res = (res + ((even * (even 
        //         - 1) * (even - 2)) / 6)) 
        //                           % mod; 
        
        return (int)(res%mod);
    }
};
