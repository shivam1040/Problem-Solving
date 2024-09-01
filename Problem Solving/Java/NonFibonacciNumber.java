/*
Given a positive integer N, your task is to print the Nth non Fibonacci number. The Fibonacci numbers are defined as:

Fib(0) = 0

Fib(1) = 1

for n >1, Fib(n) = Fib(n-1) + Fib(n-2)

Example 1:

Input: N = 5
Output: 10
Explaination: The first 5 non-fibonacci 
numbers are 4, 6, 7, 9, 10.
Example 2:

Input: N = 15
Output: 22
Explaination: The fibonacci numbers 
are 1, 2, 3, 5, 8, 13, 21, 34. Here 
22 becomes the 15th non-fibonacci 
number.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nonFibonacci() which takes the value N and returns the Nth non-fibonacci number.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105


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
            System.out.println(ob.nonFibonacci(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long nonFibonacci(int N){
        // code here
        int prevPrev=1, prev=2, cur=3;
        
        while(N>0){
            //finding fibs
            prevPrev=prev;
            prev=cur;
            cur=prevPrev+prev;
            //finding the gap b/w cur and prev which gives idea of how many non fibs b/w them
            N-=(cur-prev-1);
        }
        //ensures that negative N is taken into consideration by converting it to positive and considering its offset from prev to get n non fib num
        N+=(cur-prev-1);
        
        return prev+N;
    }
}
