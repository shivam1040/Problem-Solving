/*
Given 5 integers K, L, R, X, Y. Find whether there exists two integers A and B such that A / B = K where L ≤ A ≤ R and X ≤ B ≤ Y.

Example 1:

Input: K = 1, L = 1, R = 10
       X = 1, Y = 10
Output: 1
Explanation:
A = 1 , B = 1 exists such that L ≤ A ≤ R,
X ≤ B ≤ Y and A / B = K.
Note,there are other pairs present
Like A = 2, B = 2 etc which also satisfy 
the conditions.
Example 2:

Input: K = 1, L = 1,  R = 5
       X = 6, Y = 10
Output: 0
Explanation:
No such A and B exist that  satisfy all 
the conditions.

Your Task:
You don't need to read input or print anything. Your Task is to complete the function easyProblem() which takes 5 integers K, L, R,  X, and Y as input parameters and returns 1 if there exists two numbers that follow the above-given conditions. Otherwise, return 0.


Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)


Constraints:
1≤ K, L, R, X, Y≤ 106
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int K = Integer.parseInt(S[0]);
            int L = Integer.parseInt(S[1]);
            int R = Integer.parseInt(S[2]);
            int X = Integer.parseInt(S[3]);
            int Y = Integer.parseInt(S[4]);
            Solution ob = new Solution();
            System.out.println(ob.easyProblem(K, L, R, X, Y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int easyProblem(int K, int L, int R, int X, int Y) {
        // code here
    //     int A=L, B=X;
        
    //     while(A<=R && B<=Y){
    //         if(A==K*B)
    //             return 1;
    //         else if(A<K*B)
    //             A++;
    //         else
    //             B++;
    //     }
    //     return 0;
    // }
    
        while (X <= Y) {
            //the basic idea is to start from RHS i.e X find if any number exists b/w range L-R which satisfies A=K*X
            //keep incrementing X to account for change in B
        int t = K * X;
        if (t > R)
            return 0;
        if (t >= L)
            return 1;
        X++;
    }
    return 0;
    }
    
}
