/*
Given two numbers X and N, find the smallest value of (N*K) which is closest to X. Where K is any positive number greater than zero. If in case there are two numbers closer to N, then return the larger number.
 

Example 1:

Input: X = 9, N = 2
Output: 10
Expalantion: 8 and 10 both are multiple of 2 and 
closest to 9, in this case we return the larger 
number that is 10.
Example 2:

Input: X = 2855, N = 13
Output: 2860
Explanation: 2860 is multiple of 13 and 
closest to 13.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function closestNo() which takes X and N as input parameter and return the number which is multiple of N and closest to X. In case of multiple numbers return the bigger one.

Expected Time Compelxity: O(1)
Expected Space Complexity: O(1)

Constraints:
1 <= X, N <= 1000000
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
            String s1 = br.readLine().trim();
            String[] s2 = s1.split(" ");
            int x = Integer.parseInt(s2[0]);
            int n = Integer.parseInt(s2[1]);
            Solution ob = new Solution();
            int ans = ob.closestNo(x, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closestNo(int x, int n)
    {
        // code here
        int l=(x/n)*n, r=l+n;
        
        return (l!=0 && x-l < r-x) ? l : r;
    }
}
