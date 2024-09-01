/*
Given a Geometric Progression with first term as 1, common ratio as 2 and a number N. Find out the sum of all the terms of this geometric progression if there are total 2N terms in GP.
Note: Since the answer can be very large, print the answer modulo 109+7.

 

Example 1:

Input:
N = 1
Output:
3
Explanation:
The series = 1,2. Sum = 1+2 = 3.
Example 2:

Input:
N = 2
Output:
15
Explanation:
The series = 1,2,4,8. Sum = 1+2+4+8 = 15.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function geoProg() which takes a Integer N as input and returns the sum of all the terms of this geometric progression if there are total 2N terms in GP modulo (109+7).

 

Expected Time Complexity: O((log(N))2)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1018
*/

/*
We can use the formula to calculate the Sum of n terms of Geometric Progression.

Implementation:
The formula says,
The Sum of n terms of Geometric Progression Sn = a[(rn – 1)/(r – 1)] if r ≠ 1 and r > 1  where a = 1st term and r = the common ratio.

Here in this problem,
n = 2N, r = 2, a = 1
So, Sn = 1*(22^N-1)/(2-1)
We have to calculate the answer modulo M (M=109+7)

According to Fermat's little theorem,
if p is a prime number, then for any integer a, the number ap - a is an integer multiple of p.

In the notation of modular arithmetic, this is expressed as ap ≡ a (mod p)
For example, if a = 2 and p = 7, then 27 = 128, and 128 − 2 = 126 = 7 × 18 is an integer multiple of 7.

If a is not divisible by p, that is if a is coprime to p,
ap-1 - 1 is an integer multiple of p

So, ap-1 ≡ 1 (mod p)

For example, if a = 2 and p = 7, then 26 = 64, and 64 − 1 = 63 = 7 × 9 is thus a multiple of 7.

22^N mod M=22^N mod M-1 mod M
*/

//{ Driver Code Starts
//Initial Template for Java

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
            System.out.println(ob.geoProg(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long geoProg(Long N) {
        // code here
        long M=1000000007;
        
        return geoProg(2, geoProg(2, N, M-1), M)-1;
    }
    
    private static long geoProg(long a, long b, long m){
        long ans = 1;
        
        while(b>0) {
            if ((b&1)==1) ans = (ans * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return ans;
    }
};
