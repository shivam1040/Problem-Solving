/*
A prime number is a Circular Prime Number if all of its possible rotations are itself prime numbers. Now given a number N check if it is Circular Prime or Not.
 

Example 1:

Input: N = 197
Output: 1
Explanation: 197 is a Circular Prime because
all rotations of 197 are 197, 719, 971 all of 
the 3 are prime number's hence 197 is a 
circular prime.
Example 2:

Input: N = 101
Output: 0
Explanation: 101 and 11 is prime but 110 is
not a prime number.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCircularPrime() which takes N as input parameter and returns 1 if it is Circular Prime otherwise returns 0.
 

Expected Time Complexity: O(Nlog(log(N))
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 105
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
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            Solution ob = new Solution();
            int ans = ob.isCircularPrime(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isCircularPrime(int n)
    {
        // code here
        String s=String.valueOf(n);
        
        if(isPrime(n)==false)
            return 0;
        
        for(int i=1; i<s.length(); i++){
            String temp=s.substring(i)+s.substring(0, i);
                if(!temp.equals("0") && isPrime(Integer.parseInt(temp))==false)
                    return 0;
        }
        return 1;
        //another way
    //     if(n <= 1) return 0;
    // int digitCount = ceil(log10(n));
    // int p = digitCount-1;
    // while(digitCount--) {
    //     if(!isPrime(n)) return 0;
    //     n = (n%10*pow(10,p)) + n/10;
    // }
    // return 1;
    }
    
    private boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
 
        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;
 
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
}
