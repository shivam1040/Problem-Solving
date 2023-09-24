/*
A Lucas Number is a number which is represented by the following recurrence
Ln = Ln-1 + Ln-2 for n>1
L0 = 2
L1 = 1

Given a number N, find the Nth lucas number.

Note: Since the output may be very large calculate the answer modulus 10^9+7.


Example 1:

Input:
N = 5
Output: 11
Explanation: L3 + L4 = L5
L3 = 4 and L4 = 7

â€‹Example 2:

Input: 
N = 7
Output: 29
Explanation: L5 + L6 = L7
L5 = 11 and L6 = 18

Your Task:
You don't need to read input or print anything. Your task is to complete the function lucas() which takes integer N  as input parameter and return Nth  Lucas number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.lucas(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long lucas(int n)
        {
            //code here.
            long a=2, b=1, mod=1000000007, c;
            
            for(long i=2; i<=n; i++){
                c=a%mod+b%mod;
                a=b;
                b=c%mod;
            }
            
            return b%mod;
        }
        
};

