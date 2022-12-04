/*
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.

Example 1:

Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number 
with sum of digits equals to 9.
Example 2:

Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number 
with sum of digits equals to 20.
Your Task:
You do not need to read input or print anything. Your task is to complete the function findLargest() which takes N and S as input parameters and returns the largest possible number. Return -1 if no such number is possible.

Expected Time Complexity: O(N)
Exepcted Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
0 ≤ S ≤ 105
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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        String res="";
        
        // If sum of digits is 0, then a number is possible
        // only if number of digits is 1
        if (S == 0)
        {
            
            return N==1 ? "0" : "-1";
        }
        // Sum greater than the maximum possible sum
        if (S > 9*N)
        {
            return "-1";
        }
        while(N>0){
            int temp=S/9;
	    //inserting 9 till we can
            if(temp>0){
                res+="9";
                S-=9;
                N--;
            }
	    //inserting reamining numbers followed by zero
            else if(temp==0){
                res+=S;
                S=S/9;
                N--;
            }
        }
        return res;
    }
}
