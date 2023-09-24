/*
How many non-attacking knights K(n) can be placed on an n x n chessboard. 
Recall that a knight can attack another knight if their vertical distance on the chessboard is 2 and their horizontal distance is 1, or if their vertical distance is 1 and their horizontal distance is 2. Only one knight may be placed on each square of the chessboard.

 

Example 1:

Input:
n = 3
Output:
5
Explanation:
We can place 5 non-attacking knights
on a 3*3 chessboard.
Example 2:

Input:
n = 1
Output:
1
Explanation:
There is only one cell available and
we can place a knight on it.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function saveKnights() which takes an Integer n as input and returns the maximum number of non-attacking Knights thatr can be placed on a n*n chessboard.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <= 108
*/

/*
The problem of placing non-attacking knights on an n x n chessboard involves determining the maximum number of knights that can be placed on the board such that no two knights attack each other. Knights move in an L-shape: they move two squares vertically and one square horizontally or two squares horizontally and one square vertically. Therefore, two knights attack each other when their positions are such that their relative vertical distance is 2 and their relative horizontal distance is 1, or vice versa.

To solve this problem, we use a formula based on the parity (even or odd) of n, the size of the chessboard:

If n is even:

In an n x n chessboard, there are n^2 total squares.
Since knights occupy squares in an alternating pattern (like a checkerboard), half of the squares can be occupied by knights without any attacks.
So, K(n) = n^2 / 2, where K(n) is the maximum number of non-attacking knights.
If n is odd:

Similarly, there are n^2 total squares on the board.
In this case, the pattern does not start and end on the same color square, so there will be one more square of one color than the other.
Therefore, we calculate K(n) as (n^2 + 1) / 2, which accounts for the extra square of one color.
The provided code snippet implements this formula to calculate the maximum number of non-attacking knights for a given n x n chessboard. It checks the parity of n and calculates K(n) accordingly. This solution ensures that no two knights on the chessboard can attack each other, meeting the problem's criteria.






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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.saveKnights(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long saveKnights(int n) {
        // code here
        return n==2 ? 4 : (n%2==0 ? (long)Math.pow(n, 2)/2 : ((long)Math.pow(n, 2)+1)/2);
    }
};
