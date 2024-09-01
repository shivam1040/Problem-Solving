/*
Given three  integers N, x and y, a number A is formed by repeating N x times and another number B is formed by repeating N y times. You need to find the GCD(A,B). 

 

Example 1:

Input: N = 1, x = 1, y = 1
Output: 1
Explanation: A = 1, B = 1, GCD(1, 1)  = 1

Example 2:

Input: N = 2, x = 2, y = 2
Output: 2
Explanation: A = 22, B = 222, GCD(22, 222) = 2
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FindGcd() which takes N, x and y as input parameter and returns GCD(A, B) in string form.
 

Expected Time Complexity: O(Log10(N) * GCD(x, y))
Expected Space Complexity: O(Log10(N) * GCD(x, y))
 

Constraints:
1 <= x, y <= 100000
1 <= N <= 1018
*/

/*
The idea is based on Euclidean algorithm to compute GCD of two number. 
Let f(n, x) be a function which gives a number n repeated x times. So, we need to find GCD(f(n, x), f(n, y)).
Let n = 123, x = 3, y = 2. 
So, first number A is f(123, 3) = 123123123 and second number B is f(123, 2) = 123123. We know, GCD(A,B) = GCD(A – B, B), using this property we can subtract any multiple of B, say B’ from first A as long as B’ is smaller than A. 
So, A = 123123123 and B’ can be 123123000. On subtracting A will became 123 and B remains same. 
Therefore, A = A – B’ = f(n, x – y). 
So, GCD(f(n, x), f(n, y)) = GCD(f(n, x – y), f(n, y))
We can conclude following, 

GCD(f(n, x), f(n, y)) = f(n, GCD(x, y)
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
            String[] s1 = s.split(" ");
            long N = Long.parseLong(s1[0]);
            int x = Integer.parseInt(s1[1]);
            int y = Integer.parseInt(s1[2]);
            Solution ob = new Solution();
            String ans = ob.FindGcd(N, x, y);
            System.out.println(ans);           
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String FindGcd(long N, int x, int y)
    {
        // Code here
        StringBuilder res=new StringBuilder();
        int gcd=gcd(x, y);
        
        for(int i=0; i<gcd; i++)
            res.append(N);
        return res.toString();
    }
    
    private int gcd(int a, int b) { 
          
        if (a == 0) 
            return b; 
              
        return gcd(b % a, a); 
    } 
}
