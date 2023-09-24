/*
Given an array A[ ] of N numbers, your task is to find LCM of it modulo 1000000007

Example 1:

Input:
N = 4
A = {1 , 2 , 8 , 3}
Output:
24
Explanation:
LCM of the given array is 24.
24 % 1000000007 = 24
Example 2:

Input:
N = 2
A = {1 , 8}
Output:
8
Explanation:
LCM of the given array is 8.
Your Task:
You don't need to read input or print anything. Your task is to complete the function lcmOfArray() which takes an Integer N and an Array A as input and returns the answer.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
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
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int i = 0;i<n;i++){
                A[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.lcmOfArray(n,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long lcmOfArray(int N, int A[]){
        //complete the function here
        long res=1;
        
        for(int i:A)
            res=lcm(res, i)%1000000007;
        return res;
    }
    
    private static long lcm(long a, long b){
        return a*b/gcd(a, b);
    }
    
    private static long gcd(long a, long b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}

