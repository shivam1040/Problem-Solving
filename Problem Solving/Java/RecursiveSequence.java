/*
A function f is defined as follows F(N)= (1) +(2*3) + (4*5*6) ... N. Given an integer N the task is to print the F(N)th term.

Example 1:

Input: N = 5
Output: 365527
Explaination: F(5) = 1 + 2*3 + 4*5*6 + 7*8*9*10 
+ 11*12*13*14*15 = 365227.
Your Task:
You do not need to readd input or print anything. Your task is to complete the function sequence() which takes N as input parameter and returns the value of F(N).

Expected Tiime Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10
*/
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Res{
    long res;
    long last;
}

class Solution{
    
    static long sequence(int N){
        // code here
        Res res=new Res();
        res.res=1;
        res.last=1;
        int i=1;
        long r=0;
        
        while(i<=N){
            seq(0, i, res);
            r+=res.res;
            res.res=1;
            i+=1;
        }
        return r;
    }
    
    static void seq(int i, int repeat, Res res){
        if(i==repeat)
            return;
        res.res*=res.last;
        res.last+=1;
        seq(i+1, repeat, res);
    }
}
