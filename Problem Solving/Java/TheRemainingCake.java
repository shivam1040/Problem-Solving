/*
Given a circle of radius R, divide it into N pieces such that every piece is 1/Mth of the original circle, where N and M are positive non-zero integers and M>=N. Find the arc length of the piece of the circle that is left over after the distribution.

Example 1:

Input:
R=7.50
N=4
M=7
Output:
20.19
Explanation:
3/7th of the circle is left which equals 
20.19 arc length.
Example 2:

Input:
R=6.66
N=3
M=4
Output:
10.46
Explanation:
1/4th of the circle is left which equals 
10.46 of arc length.

Your Task:
You don't need to read input or print anything. Your task is to complete the function remainingCircle() which takes R, N, M as input parameters and returns the arc length of the portion of the circle left after removing N portions of size 1/Mth each.


Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)


Constraints:
1<=R<=1000.0
1<=N<=M<=1000
Pi=3.14
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
            String S[] = read.readLine().split(" ");
            double R = Double.parseDouble(S[0]);
            int N = Integer.parseInt(S[1]);
            int M = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            double ans = ob.remainingCircle(R, N, M);
            System.out.println(String.format("%.2f", ans));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    double remainingCircle(double R, int N, int M) {
        // code here
        double circum = 2 * 3.14 * R;
        //finding leftover after division
        return (circum*(M-N))/M;
    }
};
