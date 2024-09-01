/*
Given Two integers L and R find the total number of distinct pairs (p,q)  between L and R ( both inclusive ) satisfying the given relationship. p! * q!=k^2 (a perfect square) where p,q,k is any integer and '!' denotes factorial.

Example 1:

Input: L = 0, R = 1
Output: 1
Explanation: 1 is the only perfect square
between 0 and 1; 

Example 2:

Input: L = 9, R = 25
Output: 3
Explanation: 9, 16 and 25 are the perfect 
squares between 9 and 25. 

Your Task:  
You don't need to read input or print anything. Complete the function countPerfectSquares() which takes L and R as an input parameter and returns the total number of perfect squares.

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

Constraints:
0<= L <= R <=1018
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            long L = Integer.parseInt(input[0]); 
            long R = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.countPerfectSquares(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static long countPerfectSquares(long L, long R)
    {
        // code here
        if(isPerfectSquare(L))
            return (long)(Math.floor(Math.sqrt(R))-Math.floor(Math.sqrt(L))+1);
        else
            return (long)(Math.floor(Math.sqrt(R))-Math.floor(Math.sqrt(L)));
    }
    
        static boolean isPerfectSquare(long x) {
        if (x >= 0) {
            long sr = (long)Math.floor(Math.sqrt(x));
            return sr * sr == x;
        }
        return false;
    }
}
