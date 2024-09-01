/*
Find max number of squares (S) of side 2 units that can fit in an Isosceles triangle with a right angle and its shortest side equal to "B" units.
Note: The squares don't have to fit completely inside the Triangle.

 

Example 1:

Input:
B = 1
Output:
0
Explanation:
We can't fit any squares.
Example 2:

Input:
B = 10
Output:
10
Explanation:
We can fit 10 squares of 2 unit sides
in an Isosceles Right Traingle with
the shortest side being 10 unit length.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSquares() which takes an Integer B as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= B <= 109
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
            Long B = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.maxSquares(B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long maxSquares(Long B) {
        // code here
        long temp=(B/2)-1;
        
        return (temp*(temp+1))/2;
    }
};

/*
The function first calculates a temporary value temp which represents the number of full rows of squares that can fit in the triangle, excluding the base row. It then uses the formula (temp * (temp + 1)) / 2 to calculate the total number of squares that can fit in these rows, as this formula represents the sum of the first temp natural numbers, which corresponds to the number of squares in the rows.

The intuition behind this approach is that each row of squares in the triangle contains one less square than the row below it. Therefore, the number of squares in each row forms an arithmetic sequence, and the total number of squares that can fit in the triangle is the sum of the squares in these rows.
*/
