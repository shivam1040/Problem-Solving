/*
Given two numbers n and k, find the kth prime factor of n. 

Example 1:

Input: n = 225, k = 2
Output: 3
Explaination: The prime factors 3, 3, 5 
and 5. So 3 is the 2nd one.

Example 2:

Input: n = 81, k = 5
Output: -1
Explaination: The 4 prime factors are 
3, 3, 3, 3. So there is no 5th one.

Your Task:
You do not need to read input or print anything. Your task is to complete the function kthPrime() which takes the value n and k as input parameters and return the kth prime number. If k is greater than total number of primes then return -1.


Expected Time Complexity: O(n*log(log n))
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 104
1 ≤ k ≤ 50
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.kthPrime(n, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int kthPrime(int n, int k){
        // code here
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                //System.out.print(c + " ");
                n /= c;
                k--;
                if(k==0)
                    return c;
            }
            else
                c++;
        }
        return -1;
    }
}
