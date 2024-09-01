/*
Consider the sequence of numbers 1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, ... In this sequence first we have the number 1, then the numbers from 1 to 2, then the numbers from 1 to 3 and so on. Your task is to find the N'th number in this sequence.
 

Example 1:

Input: N = 4
Output: 1
Explanation: 4'th number is 1. 
â€‹Example 2:

Input: N = 14
Output: 4
Explanation: 14'th number is 4.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function get() which takes N as input and returns the answer.

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 1010
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
            long n = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.get(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long get(long n){
        //complete the function here
        for(long i=1; i<n; i++)
            n-=i;
        return n;
    }
}
