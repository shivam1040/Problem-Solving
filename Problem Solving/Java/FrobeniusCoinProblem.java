/*
Given two coins of denominations X and Y respectively, find the largest amount that cannot be obtained using these two coins (assuming infinite supply of coins) followed by the total number of such non obtainable amounts.
 

Example 1:

Input: X = 2, Y = 5
Output: 3 2
Explanation: 3 is the largest amount that
can not be formed using 2 and 5. And there 
are only 2 such non obtainable amounts and 
they are 1 and 3.
Example 2:

Input: 5 10
Output: -1
Explanation: Using 5 and 10 there can be 
infinite number of amounts that cannot be
formed.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function frobenius() which takes X and Y as input parameters and returns a list of two numbers in which first number should be maximum amount that cannot be obtained and the second number should be total number of non-obtainable amounts. If no such value exist then returns a list containing -1.
 

Expected Time Complexity: O(log2(max(X, Y)))
Expected Space Complexity: O(1)
 

Constraints:
2 <= X, Y <= 10000
*/

/*
To find the largest amount that cannot be obtained using two coins of denominations X and Y, and the total number of such non-obtainable amounts, we can use a mathematical approach based on the Frobenius number (also known as the coin problem or postage stamp problem).

The Frobenius number for two denominations (X, Y) is given by:

Frob
(
�
,
�
)
=
�
�
−
�
−
�
Frob(X,Y)=XY−X−Y

This is the largest amount that cannot be obtained using coins of denominations X and Y. To find the total number of non-obtainable amounts, we can calculate the number of integer points in the region 
0
≤
�
�
+
�
�
<
�
�
−
�
−
�
0≤ax+by<XY−X−Y, where 
�
a and 
�
b are non-negative integers. This region corresponds to the set of non-obtainable amounts.
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
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int X = Integer.parseInt(S[0]);
            int Y = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int[] ans = ob.frobenius(X, Y);
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
    public int[] frobenius(int X, int Y)
    {
        // Code here
        if(gcd(X, Y)>1)
            return new int[]{-1};
        return new int[]{X*Y-X-Y, --X*(--Y)/2};
    }
    
        public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    } 
}
