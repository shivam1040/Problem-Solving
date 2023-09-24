/*
Given a series with starting 6 members of the series. Given an integer n find the nth term of this series modulo 109+7.
Series: 7, 15, 32, 67, 138, 281, ............

Example 1:

Input: n = 2
Output: 15
Explaination: The value is given in 
the series in question.
Your Task:
You do not need to read input or print anything.Your task is to complete the function nthTerm() which takes n as input parameter and returns the value of the nth term modulo 109+7.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 120  


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
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.nthTerm(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int nthTerm(int n){
        // code here
        int res=7;
        for(int i=1; i<n ;i++){
            res=((res*2)+i)%1000000007;
        }
        return res;
    }
}
