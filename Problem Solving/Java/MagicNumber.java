/*
A magic number is defined as a number that can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
Given the value of n, find the n'th Magic number modulo 109+7.

Example 1:

Input: n = 1
Output: 5
Explanation: 1'st Magic number is 5.
â€‹Example 2:

Input: n = 2
Output: 25
Explanation: 2'nd Magic number is 25. 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function nthMagicNo() which takes n input and returns the answer.

Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 105


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
            int n = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.nthMagicNo(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long nthMagicNo(int n){
        //complete the function here
        long pow=1, ans=0;
        
        while(n!=0){
            pow*=5;
            
            //checking if set bit then just add powers of 5 else go to the next bit
            if((n&1)==1)
                ans=(ans+pow)%1000000007;
            n>>=1;
            //basically the idea is to find powers at set bit of the binary representation of n and power should be of the position  set bit are at in the binary representation
        }
        
        return ans%1000000007;
    }
}

