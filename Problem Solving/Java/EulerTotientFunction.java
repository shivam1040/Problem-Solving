/*
Below is a Better Solution. The idea is based on Euler's product formula which states that the value of totient functions is below the product overall prime factors p of n. 

eulersproduct


The formula basically says that the value of Φ(n) is equal to n multiplied by-product of (1 - 1/p) for all prime factors p of n. For example value of Φ(6) = 6 * (1-1/2) * (1 - 1/3) = 2.
We can find all prime factors using the idea used in this post. 


*/

/*
Find the Euler Totient Function (ETF) Φ(N) for an input N. ETF is the count of numbers in {1, 2, 3, …, N} that are relatively prime to N, i.e., the numbers whose GCD (Greatest Common Divisor) with N is 1.
 

Example 1:

Input:
N = 11
Output:
10
Explanation:
From 1 to 11,
1,2,3,4,5,6,7,8,9,10
are relatively prime to 11.
Example 2:

Input:
N = 16
Output:
8
Explanation:
From 1 to 16
1,3,5,7,9,11,13,15 
are relatively prime
to 16.

Your Task:
You don't need to read input or print anything. Your task is to complete the function ETF() which takes one integer value N, as input parameter and return the value of Φ(N).
 

Expected Time Complexity: O(NLog N)
Expected Space Complexity: O(1)
 

Constraints:
1<=N<=105
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
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.ETF(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long ETF(long n) {
        // code here
              float result=1;
        for (long i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i) {
                    if (isPrime(i))
                        result *= (1 - (float) 1 / i);
                }

                else {
                        if (isPrime(i))
                            result *= (1 - (float) 1 / (i));
                        if(isPrime(n/i))
                            result*=(1- (float) 1 /((float) n /i));
                    }

            }
        }
        float v = n * result;
        return Math.round(v);
    }
    
     private static boolean isPrime(long n)
    {
        // Corner case
        if (n <= 1)
            return false;
 
        if (n == 2 || n == 3)
            return true;
 
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
}
