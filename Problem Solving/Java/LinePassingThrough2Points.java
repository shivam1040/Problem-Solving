/*
Given two points P(a, b) and Q(c, d) in the coordinate plane, find the equation of the line passing through both the points.

Example 1:

Input: P = (3, 2)
Q = (2, 6)
Output: 4x+1y=14
Explaination: Using the formula to get
line equation from two points we can
get it.
Example 2:

Input: P = (3, 2)
Q = (5, 7)
Output: 5x-2y=11
Explaination: If we use the formula to
get line equation from two points we
get this equation.
Your Task:
You do not need to read input or print anything. Your task is to complete the function getLine() which takes the values a, b, c and d as input parameters and returns a string which represents the equation.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ a, b, c, d ≤ 105


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            String arr1[] = in.readLine().trim().split("\\s+");
            int c = Integer.parseInt(arr1[0]);
            int d = Integer.parseInt(arr1[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.getLine(a, b, c, d));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String getLine(int a, int b, int c, int d)
    {
        // code here
        int x = d - b;
    int y = a - c;
    return x + (y >= 0 ? "x+" : "x") + y + "y=" + (a * x + b * y);
    }
}
