/*
Given a value N, find out the largest palindrome number which is product of two N-digit numbers.
 

Example 1:

Input: N = 2
Output: 9009
Explanation: 9009 is the largest number 
which is product of two 2-digit numbers. 
9009 = 91*99.
Example 2:

Input: N = 1
Output: 9
Explanation: 9 is the largest number 
which is product of two 1-digit numbers. 
3 * 3 = 9.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function LargestProductPalin() which takes N as input parameter and returns largest palindromic product of 2 N-digit numbers.
 

Expected Time Complexity: O(10n+1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 6
*/

/*
Find a lower limit on n digit numbers. For example, for n = 2, lower_limit is 10.
Find an upper limit on n digit numbers. For example, for n = 2, upper_limit is 99.
Consider all pairs of numbers wherever number lies in range [lower_limit, upper_limit]
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
            int N = Integer.parseInt(s);
            Solution ob = new Solution();
            long ans = ob.LargestProductPalin(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long LargestProductPalin(int N)
    {
        // code here
        int u=(int)Math.pow(10, N)-1, l=1+u/10, res=0;
        
        for(int i=u; i>=l; i--)
            for(int j=i; j>=l; j--){
                int temp=i*j;
                
                if(temp<res)
                    break;
                
                int temp1=temp, temp2=0;
                
                while(temp1!=0){
                    temp2=temp2*10+temp1%10;
                    temp1/=10;
                }
                if(temp==temp2 && temp>res)
                    res=temp;
            }
        return res;
    }
}
