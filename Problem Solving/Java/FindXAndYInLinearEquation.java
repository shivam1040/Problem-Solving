/*
Given A, B and N. Find x and y that satisfies equation Ax + By = N. If there's no solution print -1 in place of both x and y.
Note: There are Multiple solutions possible. Find the solution where x is minimum. x and y should both be non-negative.

 

Example 1:

Input:
A = 2, B = 3, N = 7
Output:
2 1
Explanation:
2*2 + 3*1 = 7.
Example 2:

Input:
A = 4, B = 2, N = 7
Output:
-1 -1
Explanation:
There's no solution for x and y the equation.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findXandY() which takes 3 Integers A,B and N as input and returns a list of 2 integers with the first integer x and the second being y.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A,B <= 105
0 <= N <= 105


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);
            int N = Integer.parseInt(S[2]);
            
            Solution ob = new Solution();
            int[] ptr = ob.findXandY(A,B,N);
            System.out.println(ptr[0]+" "+ptr[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] findXandY(int a, int b , int n) {
        // code here
        ax+by=n
        (n-ax)/b=y
        for(int i=0; i*a<=n; i++)
        //using  Linear Diophantine Equations
        //also we know the x and y can't exceed n
            if((n-(i*a))%b==0)
                return new int[]{i, (n-(i*a))/b};
        return new int[]{-1, -1};
    }
};
