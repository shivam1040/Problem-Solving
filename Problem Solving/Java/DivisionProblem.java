/*
You will be given two positive integers A and B and you have to find the smallest positive integer x such that B divides Ax - 1.

Example 1:

Input: A = 8, B = 10
Output: -1
Explaination: There is no such x that 
8x - 1 is divisible by 10.
Example 2:

Input: A = 4, B = 9
Output: 7
Explaination: 7 is the least integer such 
that the conditioin satisfies.
Your Task:
You do not need to read input or print anything. Your task is to complete the function findX() which takes A and B as input parameter and return the least x such that Ax - 1 is divisible by B. Return -1 if no such x exists.

Expected Time Complexity: O(log(max(A, B)))
Expected Auxiliary Space: O(1) 

Constraints:
1 ≤ A, B ≤ 104


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findX(A, B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int findX(int A, int B){
        // code here
        for(int i=1; i<=Math.max(A, B); i++)
            if((A*i-1)%B==0)
                return i;
        return -1;
    }
};
