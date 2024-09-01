/*
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.
Note : If r is greater than n, return 0.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 
Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.
Your Task:
You do not need to take input or print anything. Your task is to complete the function nCr() which takes n and r as input parameters and returns nCr modulo 109+7..

Expected Time Complexity: O(n*r)
Expected Auxiliary Space: O(r)

Constraints:
1 ≤ n ≤ 1000
1 ≤ r ≤ 800
*/

/*
Intuition
Computing nCr and then using modular operator is not a good idea as there will be overflow even for slightly larger values of n and r. The idea is to compute nCr using below formula which is similar to the Pascale's triangle formula:
    =>  C(n, r) = C(n-1, r-1) + C(n-1, r)
    =>  C(n, 0) = C(n, n) = 1
We can use distributive property of modular operator to find nCr % p using above formula.
    =>  C(n, r)%p = [ C(n-1, r-1)%p + C(n-1, r)%p ] % p
    =>  C(n, 0) = C(n, n) = 1

Here we are using the Pascale's triangle to find the value of nCr: The idea is to store Pascal’s triangle in a matrix then the value of nCr will be the value of the cell at nth row and rth column, The advantage of this method is that it saves time on calculating factorials by reusing previously computed values.

To create the Pascal triangle use these two formulas:

nC0 = 1 , the number of ways to select 0 elements from a set of n elements is 0
nCr = n-1Cr-1 + n-1Cr, the number of ways to select r elements from a set of n elements is the summation of ways to select r-1 elements from n-1 elements and ways to select r elements from n-1 elements.
let's take an example for better understanding:
Input: n=4, r=3

Pascal's triangle for n=4 is as:
             1
          1    1`
       1    2   1
    1    3    3    1
 1     4   6    4   1

=> As we know value of nCr is present in nth row and rth column in pascles triangle.

=> we just need to look for the last(nth) row that is 1,4,6,4,1 and store them in an array. The answer will be stored at the 3rd index that is 4.

Output: 4


*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        int C[]=new int[r+1];
        C[0]=1;
        
        for(int i=0; i<=n; i++)
            for(int j=Math.min(i, r); j>0; j--)
            // nCj = (n-1)Cj + (n-1)C(j-1);
                C[j]=(C[j]+C[j-1])%1000000007;
        return C[r]%1000000007;
    }
}

