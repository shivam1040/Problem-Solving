/*
Mersenne Prime is a prime number that is one less than a power of two. In other words, any prime is Mersenne Prime if it is of the form 2k-1 where k is an integer greater than or equal to 2. First few Mersenne Primes are 3, 7, 31 and 127.
The task is to find all Mersenne Primes smaller than equal to an input positive integer n.
 

Example 1:

Input: n = 10
Output: 3 7
Explanation:3 and 7 are only prime numbers
which are less than equal to 10 and in the
form of 2k - 1. 
Example 2:

Input: n = 100
Output: 3 7 31
Explanation: 3, 7 and 31 are only prime
numbers which are less than equal to 100
and in the form of 2k - 1.
Your Task:
You don't need to read or print anything. Your task is to complete the function AllMersennePrimeNo() which takes n as input parameter and returns a list of all Mersenne Primes less than or equal to n in sorted order.

Expected Time Complexity: O(n * log(log(n))
Expected Space Complexity: O(n)

Constraints: 
1 <= n <= 100000 
*/

/*
The idea is to generate all the primes less than or equal to the given number n using Sieve of Eratosthenes. Once we have generated all such primes, we iterate through all numbers of the form 2k-1 and check if they are primes or not.
Below is the implementation of the idea.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllMersennePrimeNo(n);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] AllMersennePrimeNo(int n)
    {
        // Code here
        boolean prime[]=new boolean[n+1];
        List<Integer> res=new ArrayList<>();
        
        SieveOfEratosthenes(n, prime);
        // 1<<k is a way to find power of 2 of k basically 2^k
        for(int k=2; (1<<k)-1<=n; k++){
            int num=(1<<k)-1;
            
            if(prime[num])
                res.add(num);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
        // Generate all prime numbers
    // less than n.
    private void SieveOfEratosthenes(int n,
                          boolean prime[])
    {
        // Initialize all entries of 
        // boolean array as true. A 
        // value in prime[i] will finally
        // be false if i is Not a prime, 
        // else true bool prime[n+1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
     
        for (int p = 2; p * p <= n; p++)
        {
            // If prime[p] is not changed
            // , then it is a prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }
}

