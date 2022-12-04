/*
Given coordinates of four points in a plane. Find if the four points form a square or not.

Example 1:

Input:
points=(0,0),(0,1),(1,0),(1,1)
Output:
1
Explanation:
These points form a square.
Example 2:

Input:
points=(0,0),(1,1),(1,0),(0,2)
Output:
0
Explanation:
These four points do not form a square.

Your Task:
You don't need to read input or print anything.Your Task is to complete the function fourPointSquare() which takes a 2D array of dimensions 4x2 which contains the cordinates of the four points and returns 1 if they form a square.Otherwise it returns 0.

 

Expected Time Complexity:O(1)
Expected Space Complexity:O(1)

 

Constraints:
0<=X-cordinate,Y-cordinate<=105
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
            int points[][] = new int[4][2];
            for (int i = 0; i < 4; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    points[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.fourPointSquare(points);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int fourPointSquare(int points[][]) {
        // code here
        //finding distances b/w points
        int a=Math.abs(points[0][0]-points[0][1]);
        int b=Math.abs(points[1][0]-points[1][1]);
        int c=Math.abs(points[2][0]-points[2][1]);
        int d=Math.abs(points[3][0]-points[3][1]);
        
        if(a==0 && a==b && b==c && c==d && d==a)
            return 0;
        if(a+c == b+d)
            return 1;
        return 0;
    }
};
