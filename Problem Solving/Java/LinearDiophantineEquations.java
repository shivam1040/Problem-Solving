/*
A Diophantine equation is a polynomial equation, usually in two or more unknowns, such that only the integral solutions are required. An Integral solution is a solution such that all the unknown variables take only integer values.

Given three integers A, B, C representing a linear equation of the form: Ax + By = C. Determine if the equation has a solution such that x and y are both integral values.
 

Example 1:

Input: 
A = 3
B = 6
C = 9 
Output: 
1 
Explanation:
It is possible to
write A, B, C in the
for 3 + 6 = 9
Example 2:

Input: 
A = 4
B = 2
C = 3
Output: 
0 
Explanation:
It is not possible to
represent A, B, C in 
Diophantine equation form.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isPossible() which takes three integer values A, B, C as input parameters and returns 1 if the solution for x and y exist otherwise return 0.
 

Expected Time Complexity: O(log N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= A,B,C <= 105


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
            String S[] = read.readLine().split(" ");
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);
            int N = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.isPossible(A,B,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isPossible(int A,int B, int C){
        // code here
        return C%gcd(A, B)==0 ? 1 : 0;
    }
    
        static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
}
