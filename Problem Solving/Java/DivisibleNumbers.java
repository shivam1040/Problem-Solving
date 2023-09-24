/*
Given two integers A and B. Find the smallest number X (greater than A) which is divisible by B.
 

Example 1:

Input:
A = 5
B = 3
Output:
6
Explanation:
6 is the smallest number
greater than 5 which is 
divisible by 3
Example 2:

Input:
A = 25
B = 13
Output:
26
Explanation:
26 is the smallest number
greater than 25 which is
divisible by 13

Your Task:
You don't need to read input or print anything. Your task is to complete the function find() which takes two integers A and B as input parameters and returns a smallest possible integer greater than A which is divisible by B.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
0 <= A,B <= 109
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            long A = Long.parseLong(S[0]);
            long B = Long.parseLong(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.find(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long find(long A,long B){  
        // code here
        //A/B to find nearest quotient, *B to get a multiple of B nearest to quotient and +B to ensure more than A
        return (A/B)*B+B;
    } 
}
