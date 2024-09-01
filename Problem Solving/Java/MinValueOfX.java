/*
Given 4 integers a,b,c and k . Find the min(non-negative Integral) value of x such that ax2+bx+c >= k.

Example 1:

Input: a = 4, b = 6, c = 5, k = 5
Output: 0
Explanation: 4*(0)2+6*0+5 = 5 which is
>= 5.

â€‹Example 2:

Input: a = 1, b = 2, c = 3, k = 4 
Output: 1 
Explanation: 1*(1)2+2*1+3 = 6 which is
â€‹>= 4.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minX() which takes a, b, c and k as inputs and returns the answer.

Expected Time Complexity: O(log k)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ a, b, c ≤ 105
1 ≤ k ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long k = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.minX(a, b, c, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minX(int a, int b, int c, long k){
        //complete the function here
        int x=Integer.MAX_VALUE, l=0, h=(int)k-c;
        
        if(k<=c)
            return 0;
        while(l<=h){
            int m=(l+h)/2;
            
            if(a*m*m+b*m>k-c){
                x=Math.min(x, h);
                h=m-1;
            }
            else if(a*m*m+b*k<k-c)
                l=m+1;
            else
                return m;
        }
        return x;
    }
}
