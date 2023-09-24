/*
Consider the set of irreducible fractions A = {n/d | n≤d and d ≤ 10000 and gcd(n,d) = 1}.You are given a member of this set and your task is to find the largest fraction in this set less than the given fraction.
Note : this is a set and so all the members are unique.

Example 1:

Input: n = 1, d = 8
Output: 1249 9993
Explanation: 1/8 >= 1249/9993 and this 
is the largest fraction. 
Example 2:

Input: n = 2, d = 53
Output: 377 9991
Explanation: 2/53 >= 377/9991 and this is 
the largest fraction.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LargestFraction() which takes n and d as input parameter and returns the largest irreducible fraction in a list where the first element denotes the numerator and second elements denotes the denominator of the fraction.

Expected Time Complexity: O(K) where K <= 10000
Expected Space Complexity: O(1)

Constraints: 
1 <= n <= d <= 10000


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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int d  =Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int[] ans = ob.LargestFraction(n, d);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[]  LargestFraction(int n, int d)
    {
        // code here
        int num=0, den=1;
        
        for(int y=10_000; y>=1; y--){
            //-1 is done to ensure that find another fraction which is near to the given fraction
            int x=(n*y-1)/d;
            //relative comparison x/y>=num/den
            if(gcd(x, y)==1 && x*den>=y*num){
                num=x;
                den=y;
            }
        }
        return new int[]{num, den};
    }
    
    private int gcd(int n1, int n2)
{
    if(n2 == 0)
        return n1;
        
    return gcd(n2, n1 % n2);
}
}
