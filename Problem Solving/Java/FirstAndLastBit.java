/*
Given a positive integer n. The problem is to check whether only the first and last bits are set in the binary representation of n. The answer is 1 if the first and last bit is set else 0.

Example 1:

Input: N = 9
Output: 1
Explanation: (9)10 = (1001)2, only 
the first and last bits are set.
â€‹Example 2:

Input: N = 15
Output: 0
Explanation: (15)10 = (1111)2, except 
first and last there are other bits also
which are set.
Your Task:  
Your task is to complete the function onlyFirstAndLastAreSet() which takes the N as inputs and returns the answer.


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 109
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
                    long n = sc.nextLong();
                    Solution ob = new Solution();
                    System.out.println(ob.onlyFirstAndLastAreSet(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int onlyFirstAndLastAreSet(long n)
    {
        //code here.
        return (n>2) && ((--n)&(--n))==0?1:0;
    }
}

