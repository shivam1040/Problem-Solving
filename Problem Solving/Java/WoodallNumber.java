/*
Given a number N. The task is to check if N is woodall number or not. A Woodall Number is of the form:

Wn = n.2n – 1

The first few Woodall numbers are: 1, 7, 23, 63, 159, 383, 895……

Example 1:

Input: N = 383
Output: 1
Explaination: 6*26 - 1 = 383.
Example 2:

Input: N = 200
Output: 0
Explaination: This is not a Woodall number.
Your task:
You do not need to read input or print anything. Your task is to complete the function isWoodall() which takes N as input parameter and returns 1 if it is a Woodall number, else returns 0.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106  
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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.isWoodall(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isWoodall(int N){
        // code here
        int res=0, count=1;
        
        while(res<=N){
            res=count*(int)Math.pow(2, count)-1;
            count++;
            
            if(res==N)
                return 1;
        }
        return 0;
    }
}
