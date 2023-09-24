/*
Given a number N. Find the product of the number of setbits and the number itself.


Example 1:

Input: N = 2
Output: 2
Explaination: 2 has one setbit. So, 2*1 = 2.

Example 2:

Input: N = 3
Output: 6
Explaination: 3 has 2 setbits. 3*2 = 6.

Your Task:
You do not need to read input or print anything. Your task is to complete the function bitMultiply() which takes the number N as input parameters and returns the product.


Expected Time Complexity: O(Log N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 106
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
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.bitMultiply(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int bitMultiply(int N){
        // coe here
        return Integer.bitCount(N)*N;
    }
}
