/*
We are given a N*M grid, print the number of rectangles in it modulo (109+7).

 

Example 1:

Input:
N = 2, M = 2
Output:
9
Explanation:
There are 4 rectangles of size 1 x 1
There are 2 rectangles of size 1 x 2
There are 2 rectangles of size 2 x 1
There is  1 rectangle of size 2 X 2.
Example 2:

Input:
N = 5, M = 4
Output:
150
Explanation:
There are a total of 150 rectangles.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function rectNum() which takes 2 Integers N and M as input and returns the number of rectangles in a N*M grid modulo (109+7).

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N,M <= 104
*/

/*
Let us derive a formula for number of rectangles. If the grid is 1×1, there is 1 rectangle. If the grid is 2×1, there will be 2 + 1 = 3 rectangles If it grid is 3×1, there will be 3 + 2 + 1 = 6 rectangles. we can say that for N*1 there will be N + (N-1) + (n-2) … + 1 = (N)(N+1)/2 rectangles.
If we add one more column to N×1, firstly we will have as many rectangles in the 2nd column as the first, and then we have that same number of 2×M rectangles. So N×2 = 3 (N)(N+1)/2.
After deducing this we can say For N*M we’ll have (M)(M+1)/2 (N)(N+1)/2 = M(M+1)(N)(N+1)/4.
So the formula for total rectangles will be M(M+1)(N)(N+1)/4
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
            
            long N = Long.parseLong(S[0]);
            long M = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.rectNum(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long rectNum(long N, long M) {
        // code here
        return ((M*N*(M+1)*(N+1))/4)%1000000007;
    }
};
