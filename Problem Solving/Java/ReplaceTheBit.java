/*
Given two numbers N and K, change the Kth (1-based indexing) bit from the left of the binary representation of the number N to '0' if it is  '1', else return the number N itself.

Example 1:

Input:
N = 13, K = 2
Output: 9
Explanation: Binary representation of 13 is
1101. The 2nd bit from left is 1, we make
it 0 and result is 1001 = 9 (decimal).
Example 2:

Input: 
N = 13, K = 6
Output: 13
Explanation: Binary representation of 13 is
1101. There's no 6th bit from left,
hence we return the number itself.

Your Task:
You don't need to read input or print anything. Your task is to complete the function replaceBit() which takes the integers N and K as inputs and returns the resultant number after the stated modifications.


Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).


Constraints:
1<=N<=106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String input[];
            input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            
            System.out.println(ob.replaceBit(n,k));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int replaceBit(int n, int k){
         int z=(int)(Math.log(n)/Math.log(2))+1;
        k=z-k;
        if(((n>>k)&1)!=0) 
            n=(n^(1<<k));
        return n;
    }
}
