/*
Given two non-negative integers a and b. The problem is to check whether the two numbers differ at one-bit position only or not. If yes then the answer is 1, otherwise 0.


Example 1:

Input: a = 13, b = 9
Output: 1
Explanation: (13)10 = (1101)2
(9)10 = (1001)2
Both the numbers differ at one bit 
position only, i.e, differ at the 
3rd bit from the right.

Example 2:

Input: a = 15, b = 8
Output: 0
Explanation: (15)10 = (1111)2 
(8)10 = (1000)2 
Both the numbers differ at 3 bit
positions.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function DifferOne() which takes a, b as inputs and returns the answer.

Expected Time Complexity: O(max(log a, log b))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ a, b ≤ 109
*/

/*
Calculate num = a ^ b.
Check whether num is a power of 2 or not
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
            long a = sc.nextLong();
            long b = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.DifferOne(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long DifferOne(long a, long b){
        //complete the function here
        a^=b;
        
        return a!=0 && (a & (a- 1)) ==0 ? 1 : 0;
    }
}
