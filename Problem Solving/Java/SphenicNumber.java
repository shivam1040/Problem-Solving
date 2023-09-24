/*
A Sphenic Number is a positive integer N which is product of exactly three distinct primes. The first few sphenic numbers are 30, 42, 66, 70, 78, 102, 105, 110, 114, …
Given a number N, your task is to find whether it is a Sphenic Number or not.
 

Example 1:

Input: N = 30
Output: 1
Explanation: 30 = 2 * 3 * 5 so N is 
product of 3 distinct prime numbers.
Example 2:

Input: N = 60
Output: 0
Explanation: 60 = 2 * 2 * 3 * 5 so N is
product of 4 prime numbers.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function isSphenicNo() which takes N as input parameter and returns 1 if N is Sphenic Number otherwise returns 0.
 

Expected Time Complexity: O(N* log(N))
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 1000
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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.isSphenicNo(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isSphenicNo(int n)
    {
              Set<Integer> aux=new HashSet<Integer>();
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            if(aux.contains(2))
                return 0;
            aux.add(2);
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                if(aux.contains(i))
                    return 0;
                aux.add(i);
                n /= i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            if(aux.contains(n)){
                return 0;
            }
            else
                aux.add(n);
        return aux.size()==3 ? 1 : 0;
    }
}
