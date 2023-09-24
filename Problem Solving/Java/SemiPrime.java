/*
Given a positive integer n. Find whether a number is a semiprime or not.
 Note: A semiprime is a natural number that is a product of two prime numbers .


Example 1:

Input:
N=35
Output:
1
Explanation:
35=7x5.So 35 is a semi-prime.

Example 2:

Input:
8
Output:
0
Explanation:
8 is not a semi prime.

Your Task:
You don't need to read input or print anything.Your Task is to complete the function checkSemiprime() which takes a number N as input parameter and returns 1 if it is a semi prime number.Otherwise, it returns 0.


Expected Time Complexity:O(Sqrt(N))
Expected Auxillary Space:O(1)


Constraints:
1<=N<=109
*/

/*
The approach is simple, factorize the given number by dividing it with the divisor of a number to remove the composite number. Meanwhile, keep updating the count variable of the prime number.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.checkSemiprime(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int checkSemiprime(int N) {
        // code here
        int temp=0;
        
        //the idea is to remove composites or divisiors to have only primes count
        for(int i=2; temp<2 && i<=Math.sqrt(N); i++)
            while(N%i==0){
                N/=i;
                temp++;
            }
        //if N is not 1 then that means it couldn't get divided by anyone so it's in itself a prime
        if(N>1)
            temp++;
        return temp==2 ? 1 : 0;
    }
}
