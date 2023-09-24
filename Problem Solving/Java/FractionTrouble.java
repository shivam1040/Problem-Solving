/*
Consider the set of irreducible fractions A = {n/d | n≤d and d ≤ 10000 and gcd(n,d) = 1}.You are given a member of this set and your task is to find the largest fraction in this set less than the given fraction.
Note: The fraction that is given to you may or may not be irreducible.

Example 1:

Input: n = 1, d = 4
Output: {2499, 9997}  
Explanation: 2499/9997 is the largest fraction.

Example 2:

Input: n = 2, d = 4
Output: {4999, 9999}
Explanation: 4999/9999 is the largest fraction. 

Your Task:  
You dont need to read input or print anything. Complete the function numAndDen() which takes n and d as input parameter and returns the numerator and the denominator of the required irreducible fraction.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= d <=1000
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
            int n = Integer.parseInt(input[0]); 
            int d = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            int[] ans = ob.numAndDen(n,d);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] numAndDen(int n, int d)
    {
        // code here
        int cn=10_000, cd=10_000, bn=cn, bd=cd;
        double rr=(double)n/d, cr=(double) cn/cd, max_error=10_000;
        
        while(cn>=1 && cd>=1){
            // this to get cn near the rr
            while(cr>=rr){
                cn--;
                cr=(double) cn/cd;
            }
            
            //this to get cd near rr
            while(cr<rr){
                cd--;
                cr=(double)cn/cd;
            }
            
            //this +1 ensure no same cn and cd or rr values
            if(rr - (double)cn/(cd+1) < max_error){
                bn=cn;
                bd=cd+1;
                max_error=rr-(double) cn/(cd+1);
            }
        }
        int gcd=gcd(bn, bd);
        
        return new int[]{bn/gcd, bd/gcd};
    }
    
     static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
}
