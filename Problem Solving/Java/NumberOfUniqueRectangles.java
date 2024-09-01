/*
You are given N unit squares (squares with side length 1 unit), the task is to make rectangles using these squares and to count the number of rotationally unique rectangles. Two rectangles are rotationally unique if one can’t be rotated to become equivalent to the other one.

 

Example 1:

Input:
N = 4
Output:
5
Explanation:
Total rectangles we can make from 4
unit squares are: 1x1, 1x2, 1x3, 2x2,
1x4, 2x1, 3x1, and 4x1.
But we can get 2x1, 3x1, 4x1
by rotating 1x2, 1x3, 1x4.
So these five rectangles are rotationally unique.
1x1, 1x2, 2x2, 1x3 and 1x4.
Example 2:

Input:
N = 5
Output:
6
Explanation:
We can make only 6 rotationally unique
rectangles from 5 unit squares.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfUniqueRectangles() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(N*sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.noOfUniqueRectangles(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int noOfUniqueRectangles(int N) {
        // code here
        int res=0, k=(int)Math.sqrt(N);
        
        for(int i=2; i<=k; i++)
            res+=(N/i)-i+1;
        return res+N;
    }
};
/*
The given code calculates the number of rotationally unique rectangles that can be formed using N unit squares. Let's break down the logic:

The variable k is set to the square root of N. This is because the maximum possible side length of a rectangle that can be formed using N unit squares is sqrt(N).

The loop iterates from 2 to k. For each value of i, it calculates (N/i) - i + 1 and adds it to the result. This expression represents the number of rectangles that can be formed with a side length of i and a varying width, such that the total area is equal to N.

Finally, N is added to the result. This accounts for the rectangles that are square (i.e., have equal side lengths).

The result gives the total number of rotationally unique rectangles that can be formed using N unit squares.
*/
