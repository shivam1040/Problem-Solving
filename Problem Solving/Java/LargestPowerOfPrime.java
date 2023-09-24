/*
The number of multiples of prime p from 1 to N will be [N/p] where [x] is the greatest integer less than or equal to x.

The number of multiples of prime p^2 from 1 to N will be [N/p^2] where [x] is the greatest integer less than or equal to x.

the answer will thus be [N/p] + [N/p^2] + ...   and so on.
The summation is to be taken till [N/p^k] is not zero.
*/

/*
Given a positive integer N and a prime p, the task is to print the largest power of prime p that divides N!. Here N! means the factorial of N = 1 x 2 x 3 . . (N-1) x N.
Note that the largest power may be 0 too.

 

Example 1:

Input:
N = 5 , p = 2
Output:
3
Explanation:
5! = 120. The highest x for which 2x
divides 120 is 3, as 120%8 = 0.
So, the Output is 3.
Example 2:

Input:
N = 3 , p = 5
Output:
0
Explanation:
3! = 6. The highest x for which 5x
divides 6 is 0, as 6%1 = 0.
So, the Output is 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function largestPowerOfPrime() which takes 2 Integers N and p as input and returns the answer.

 

Expected Time Complexity: O(logp(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
2 <= p <= 5000
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
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int p = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.largestPowerOfPrime(N,p));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int largestPowerOfPrime(int N, int p) {
        // code here
        int res=0;
        
        while(N>0){
//basic idea is to count the occurence of the prime in N
            N/=p;
            res+=N;
        }
        return res;
    }
};
