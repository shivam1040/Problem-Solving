/*
Given a number N, find the product of all the divisors of N (including N).

 

Example 1:

Input : 
N = 6
Output:
36
Explanation:
Divisors of 6 : 1, 2, 3, 6
Product = 1*2*3*6 = 36 

Example 2:

Input : 
N = 5
Output:
5
Explanation:
Divisors of 5 : 1, 5
Product = 1*5 = 5 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function divisorProduct() which takes integer N as input parameter and returns the product. Since the products may be very large, compute the answer modulo (109+ 7).

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.divisorProduct(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long divisorProduct(Long N) {
        // code here
        long res=1, mod=1000000007;
        
        for(long i=1; i<=Math.sqrt(N); i++)
            if(N%i==0){
                res=(res*i)%mod;
                //to ensure that we don't miss divisiors or duplicate them
                /*
                For example, let's say you're finding the divisors of 12:

When i = 1, N/i = 12, so both 1 and 12 are divisors.
When i = 2, N/i = 6, so both 2 and 6 are divisors.
When i = 3, N/i = 4, so both 3 and 4 are divisors.
                */
                if(N/i!=i)
                    res=(res*(N/i))%mod;
            }
        return res;
};
}
