/*
You are given an integer n, find the smallest positive integer root of equation x, or else print -1 if no roots are found.
Equation: x^2+s(x)*x-n=0
where x, n are positive integers, s(x) is the function, equal to the sum of digits of number x in the decimal number system.
 

Example 1:

Input: n = 110
Output: 10
Explanation: x=10 is the minimum root. 
As s(10)=1+0=1 and 102+1*10-110=0.
Example 2:

Input: n = 5
Output: -1
Explanation: There is no x possible which
satisfy the above equation.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function Root() which takes n as input parameter and retuns the minimum root of the given equation. If not possible returns -1.
 

Expected Time Complexity: O(k) where k is constant
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 1018
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
            String[] S1 = s.split(" ");
            long n = Long.parseLong(S1[0]);
            Solution ob = new Solution();
            long ans = ob.Root(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long Root(long n)
    {
        boolean found=false;
        long max=Integer.MAX_VALUE;
        
        for(long i=0; i<=90; i++){
            long s=i*i+4*n;
            long sq=(long)Math.sqrt(s);
            
            if(sq*sq==s && check((sq-i)/2, i)){
                found=true;
                max=Math.min(max, (sq-i)/2);
            }
        }
        if(found)
            return max;
        return -1;
    }
    
    boolean check(long a,long b)
{
long c = 0;
 
// calculate the sum of digit 
while(a != 0)
{
c = c+ a%10;
a = a/10;
}
// if yes 
if(c == b)return true;
//if no 
return false;
}
}
