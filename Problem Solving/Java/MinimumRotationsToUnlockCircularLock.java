/*
Given a lock made up of N different circular rings. Each ring has 0-9 digit printed on it. There is only one particular code which can open the lock. You can rotate each ring any number of times in either direction. Given the random sequence R and the desired sequence D, find the minimum number of rotations required to open the lock. 

 

Example 1:

Input: R = 222, D = 333
Output: 3
Explaination: Optimal number of rotations for 
getting 3 from 2 is 1. There are three 2 to 3 
transformations. So answer is 1+1+1 = 3.
 

Example 2:

Input: R = 2345, D = 5432
Output: 8
Explaination: The optimal shifts for pairs are: 
(2, 5) = 3, (3, 4) = 1, (4,3) = 1, (5,2) = 3. 
So total shifts = 3+1+1+3 = 8.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function rotationCount() which takes R and D as input parameters and return the minimum number of rotations required to make R = D.

 

Expected Time Complexity: O(logR)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ R, D < 1018
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
            String a[] = in.readLine().trim().split("\\s+");
            long R = Long.parseLong(a[0]);
            long D = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.rotationCount(R, D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int rotationCount(long R, long D){
        // code here
        int res=0;
        
        while(R>0){
            long temp=Math.abs(R%10-D%10);
            //subtraction with 10 ensures if by circular subtraction the number of turns are less
            res+=Math.min(temp, 10-temp);
            R/=10;
            D/=10;
        }
        return res;
    }
}
