/*
Consider Ø(n) as the Euler Totient Function for n. You will be given a positive integer N and you have to find the smallest positive integer n, n <= N for which the ratio n/Ø(n) is maximized.

 

Example 1:

Input:
N = 6
Output:
6
Explanation:
For n = 1, 2, 3, 4, 5 and 6 the values of
the ratio are 1, 2, 1.5, 2, 1.25 and 3
respectively. The maximum is obtained at 6.
Example 2:

Input:
N = 50
Output:
30
Explanation:
For n = 1 to 50, the maximum value of the
ratio is 3.75 which is obtained at n = 30.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximizeEulerRatio() which takes an Integer N as input and returns the smallest positive integer (<= N) which maximizes the ratio n/Ø(n) is maximized.

 

Expected Time Complexity: O(constant)
Expected Auxiliary Space: O(constant)

 

Constraints:
1 <= N <= 1012
*/

/*
If we look at the ratio n/Ø(n) by using the formula for Ø(n):


we see that this ratio depends only on the number of distinct prime factors of n and not on their powers that divide n.

Hence to maximise the ratio, all we have to do is: maximise the number of distinct prime factors that divide n. Since we need the minimum n, we take the power of each prime factor that divides n to be unity.

The answer say for N = 100 will be then n = 2*3*5 = 30. Because 2*3*5*7 > 100.

N = 1012 will require the first 11 prime numbers only.
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
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.maximizeEulerRatio(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static int[] P=new int[101];
    
    static long maximizeEulerRatio(long N) {
        // code here
           Sieve();
        
        long res = 1 , i = 2;
        
        while(res * i <= N)
        {
            if(P[(int)i]==1)
            res *= i;
            
            i++;
        }
        
        return res;
    }
    
   static void Sieve()
{
    Arrays.fill(P, 1);
    
    for(int i = 2 ; i * i <101 ; i++)
    if(P[i]==1)
    {
        for(int j = i * i ; j <101 ; j += i)
        P[j] = 0;
    }
}
};
