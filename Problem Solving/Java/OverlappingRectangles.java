/*
Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by providing the x and y coordinates of two points: the left top corner and the right bottom corner of the rectangle. Two rectangles sharing a side are considered overlapping. (L1 and R1 are the extreme points of the first rectangle and L2 and R2 are the extreme points of the second rectangle).

Note: It may be assumed that the rectangles are parallel to the coordinate axis.

rectanglesOverlap

Example 1:

Input:
L1=(0,10)
R1=(10,0)
L2=(5,5)
R2=(15,0)
Output:
1
Explanation:
The rectangles overlap.
Example 2:

Input:
L1=(0,2)
R1=(1,1)
L2=(-2,0)
R2=(0,-3)
Output:
0
Explanation:
The rectangles do not overlap.

Your Task:
You don't need to read input or print anything. Your task is to complete the function doOverlap() which takes the points L1, R1, L2, and R2 as input parameters and returns 1 if the rectangles overlap. Otherwise, it returns 0.


Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)


Constraints:
-109<=x-coordinate,y-coordinate<=109
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
            int p[] = new int[2];
            int q[] = new int[2];
            int r[] = new int[2];
            int s[] = new int[2];
            p[0] = Integer.parseInt(S[0]);
            p[1] = Integer.parseInt(S[1]);
            q[0] = Integer.parseInt(S[2]);
            q[1] = Integer.parseInt(S[3]);
            r[0] = Integer.parseInt(S[4]);
            r[1] = Integer.parseInt(S[5]);
            s[0] = Integer.parseInt(S[6]);
            s[1] = Integer.parseInt(S[7]);
            Solution ob = new Solution();
            int ans = ob.doOverlap(p, q, r, s);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        // code here
        int a1=l1[0];
        int b1=l1[1];
        int a2=r1[0];
        int b2=r1[1];
        
        int x1=l2[0];
        int y1=l2[1];
        int x2=r2[0];
        int y2=r2[1];
        
          //// there four posssible cndition in which 2 rectange does not overlap ...
          
        //// 1st one when lower index y of 2nd rectangle(y2)> upper index y of 1st
        //->y2>b1;
        
        ///if this the case then it must have its vice versa where ....
        ////b2>y1
        
        /// nxt we do the comparison of x coordinate.....
        /// if a1>x2 then not valid 
        
        /// and similar fashion if x1>a2 then not valid....
        
        /// and in rest cases rectangle will overlapp....
        
        if(b1<y2||a2<x1||x2<a1||y1<b2)
            return 0;
        return 1;
    }
}
