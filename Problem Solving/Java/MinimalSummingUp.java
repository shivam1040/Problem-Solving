/*
For a positive, non-zero integer N, find the minimum count of numbers of the form X(i-1), where X is a given non-zero, non-negative integer raised to the power i-1 where (1 ≤ i ≤ 12), so that they sum up to form the number N exactly.

Example 1:

Input: N = 10, X = 2
Output: 2
Explaination: The minimal summing is 8 + 2. 
Here both 8 and 2 are obtained from 2 raising 
it to the power 3 and 1 respectively.
Example 2:

Input: N = 38, X = 3
Output: 4
Explaination: The minimal summing is 
27 + 9 + 1 + 1. Where all the numbers are 
powers of 3.
Your Task:
You do not need to read input or print anything. Your task is to complete the function minimalSum() which takes N and X as input parameters and returns the minimum number of values of some exponent of X required to make the number N.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 108
2 ≤ X ≤ 5  


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
            int X = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minimalSum(N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimalSum(int N, int X){
        // code here
        int count=0;
        
        while(N>0){
            for(int i=11; i>=0; i--){
                int p=(int)Math.pow(X, i);
                
                if(p<=N){
                    N-=p;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
