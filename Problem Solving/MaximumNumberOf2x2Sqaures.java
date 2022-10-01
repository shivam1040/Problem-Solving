/*
Given the base (in units) of a right-angled isoceles traingle, find the maximum number of 2X2 squares that can fit in the triangle with given base.

Example 1:

Input: 8
Output: 6
Explanation:
Please refer below diagram for explanation.
squares-in-triangle

Example 2:

Input : 7
Output : 3
Explanation : In the base we can keep 2 squares
and above the two squares we can only keep 1 square.  
So the total number of squares are equal to 3.
 
Your task :
You don't need to read input or print anything. Your task is to complete the function numberOfSquares() which takes the base of the triangle as input and returns the maximum number of squares that can be fit into the triangle with given base.
 
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
 
Constraints :
1 <= N <= 10^9
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases
        
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());//input n
            
            Solution ob= new Solution();
            System.out.println(ob.numberOfSquares(n));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long numberOfSquares(long base)
    {
        //code here
        /*
        long res=0;
    
        while(base>0){
            base-=2;
            res+=base/2;
        }
        return res;
        */
        return num(base);
    }
    
    //another way
    private static long num(long base){
        //this means we are eliminating the last base of size 2 which can only form triangle
        base-=2;
        //fingding number of suqares each
        base=base/2;
        //as we do this step repeatedly so this forms AP
        return base*(base+1)/2;
    }
}
