/*
Given a polynomial represented as poly[] of size n and a value x, compute value of the polynomial for given x.  The result should be computed under modulo 109+7. 

Example 1:

Input: n = 4, x = 3
poly = {2, -6, 2, -1}
Output: 5
Explaination: Output is value of 2x3 - 6x2 + 
2x - 1 for x = 3.
Example 2:

Input: n = 4, x = 2
poly = {1, 2, 0, 4}
Output: 20
Explaination: Output is value of x3 + 2x2 + 4 
for x = 2.
Your Task:
You do not need to read input or print anything. Your task is to complete the function value() which takes n, poly and x as input parameters and returns the value of the polynomial modulo 109 + 7.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 2000
-1000 ≤ poly[i] ≤ 1000
1 ≤ x ≤ 1000 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(in.readLine());
        while(t-- > 0){
            long n = Long.parseLong(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            long poly[] = new long[(int)n];
            for(int i = 0;i < n;i++)
                poly[i] = Long.parseLong(a[i]);
            long x = Long.parseLong(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.value(n, poly, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //https://www.youtube.com/watch?v=Z393AcN_Gz0
    static int value(long n, long poly[], long x){
        // code here
        long res=poly[0], mod=1000000007;

        for(int i=1; i<n; i++)
            res=(res*x+poly[i])%mod;
        return (int)res%1000000007;
    }
}
