/*
Given a positive integer N, find the number of factors in N! ( N factorial).

Example :

Input:
N = 5
Output:
16
Explanation:
5! is 120 and the number of factors of
120 are 1 2 3 4 5 6 8 10 12 15 20 24 30
40 60 120 So the number of factors are 16.
Example 2:

Input:
N = 4
Output:
8
Explanation:
4! is 24 and the number of factors of
24 are 1 2 3 4 6 8 12 24
So the number of factors are 8.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function factorsOfFactorial() which takes an integer N as an input parameter and return the number of factors of N factorial.

Expected Time Complexity: O(NLogLogN)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 100
*/

/*
The idea is based on Legendre’s formula. 
Any positive integer can be expressed as product of power of its prime factors. Suppose a number n = p1a1 x p2a2 x p3a3, …., pkak where p1, p2, p3, …., pk are distinct primes and a1, a2, a3,………….., ak are their respective exponents. 
Then the no of divisors of n = (a1+1) x (a2+1) x (a3+1)…x (ak+1)
Thus, no. of factors of n! can now be easily computed by first finding the prime factors till n and then calculating their respective exponents. 
The main steps of our algorithm are: 
 

Iterate from p = 1 to p = n and at each iteration check if p is prime.
If p is prime then it means it is prime factor of n! so we find exponent of p in n! which is
After finding the respective exponents of all prime factors let’s say they are a1, a2 , a3, …., ak then the factors of n! = (a1+1) x (a2+1) x (a3+1)……………(ak+1)
 


Here is an illustration on how the algorithm works 
for finding factors of 16!:

All prime less than 16 will be the prime factors of 16!. 
so instead of finding all the prime factor of 16!.
we just need to find the primes less than 16 that will 
automatically be the prime factors of 16!

Prime factors of 16! are: 2,3,5,7,11,13

Now to the exponent of 2 in 16!  
              = ?16/2?+ ?16/4?+ ?16/8? + ?16/16? 
              = 8 + 4 + 2 + 1
              = 15

Similarly, 
   exponent of 3 in 16! =  ?16/3? + ?16/9? = 6
   exponent of 5 in 16! = 3 
   exponent of 7 in 16! = 2
   exponent of 11 in 16! = 1
   exponent of 13 in 16! = 1

So, the no of factors of 16! 
         = (15+1) * (6+1) * (3+1) *(2+1)* (1+1) * (1+1)
         = 5376 
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            long ans  = ob.factorsOfFactorial(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long factorsOfFactorial(int N){
        // code here
        long ans=1;
        if(N==0)
            return ans;
        int prime[]=new int[N+1];
        
        sieve(N, prime);
        for(int p=2; p<=N; p++)
            if(prime[p]==1)
                ans*=(exp(N, p)+1);
        return ans;
    }
    
    private static void sieve(int n, int prime[])
    {
        // Initialize all numbers as prime
        for (int i = 1; i <= n; i++)
            prime[i] = 1;
 
        // Mark composites
        prime[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = 0;
            }
        }
    }
    
    private static int exp(int n, int p){
        int x=p;
        int exp=0;
        
        while((n/x)>0){
            exp+=(n/x);
            x*=p;
        }
        return exp;
    }
}
