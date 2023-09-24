/*
Given N find all Sophie Germain Prime numbers less than N . A prime number p is called a sophie prime number if 2p+1 is also a prime number. The number 2p+1 is called a safe prime. 

Example 1:

Input: N = 5
Output: 2 3
Explanation: 2 and 3 are prime no. and 
2*2+1 = 5 and 3*2+1 = 7 are also prime
no.
Example 2:

Input: N = 3
Output: 2
Explanation: 2 is prime number and 2*2+1
= 5 is also a prime number.
 

Your Task:
You don't need to read or print anything your task is to complete the function sophie_primes() which takes N as input parameter and returns a list of all Sophie Germain Prime numbers in increasing order.
 

Expected Time Compelxity: O(N* log(N))
Expected Space Compelxity: O(N)

Constraints:
1 <= N <= 10000  
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
            int[] ans = ob.sophie_Primes(n);
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
    public int[] sophie_Primes(int n)
    {
        List<Integer> aux=new ArrayList<>();
        // code here
        for(int i=1; i<n; i++)
            if(isPrime(i) && isPrime(2*i+1))
                aux.add(i);
        return aux.stream().mapToInt(i->i).toArray();
                
    }
    
     private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
  
        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
}
