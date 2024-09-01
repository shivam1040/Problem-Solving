/*
Given two non-negative integers A, B. Find number of pairs of integers (a,b) such that:
a+b=A and a3+b3=B.

 

Example 1:

Input:
A = 3, B = 9
Output:
2
Explanation:
Only (1,2) and (2,1) are such pairs.
Example 2:

Input:
A = 2, B = 2
Output:
1
Explanation:
Only (1,1) is a possible pair.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPairs() which takes 2 Integers A and B as input and returns the count of pairs satisfying the given equations.

 

Expected Time Complexity: O(constant)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A,B <= 106


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

            Solution ob = new Solution();
            System.out.println(ob.countPairs(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countPairs(int A, int B) {
        // code here
        int res=0;
        
        for(int a=0; a<=A; a++){
            int b=A-a;
            
            if(a*a*a+b*b*b==B)
                res++;
        }
        return res;
    }
};
