/*
Given a positive integer N denoting the length of a stick, return the number of ways to split a stick into four parts so that it's possible to form a rectangle using these parts, but is impossible to form a square.

Example 1:

Input: N = 10
Output: 2
Explanation: The 2 ways to split 
the stick are {1,1,4,4} , {2,2,3,3} 
â€‹Example 2:

Input: n = 20
Output: 4
Explanation: The 4 ways to split 
the stick are {1,1,9,9} , {2,2,8,8}, 
{3,3,7,7} and {4,4,6,6}. Note that 
{5,5,5,5} forms square so it is not 
considered.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function count() which takes N as input and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 109


*/

/*
Odd Length Stick: If the stick length 
�
N is odd, it cannot be split into four parts, so the function returns 0.

Even Length Stick:

Calculate 
�
=
�
/
2
n=N/2, which represents the length of the stick if it's divided into two equal parts.
If 
�
n is odd, there are 
�
/
2
n/2 ways to split the stick into four parts. This is because the two shorter parts can be either 
�
/
2
n/2 and 
�
/
2
−
1
n/2−1 or vice versa, resulting in two valid ways for each pair.
If 
�
n is even, there are 
�
/
2
−
1
n/2−1 ways to split the stick into four parts. This is because the two shorter parts must be 
�
/
2
n/2 and 
�
/
2
−
1
n/2−1 (or vice versa) to ensure that a square cannot be formed.
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
            System.out.println(ob.count(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long count(long N){
        //complete the function here
        //no even parts if odd
        if(N%2!=0)
            return 0;
        long n=N/2;
        
        if(n%2!=0)
            return n/2;
        return n/2-1;
    }
}
