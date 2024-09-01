/*
Consider a rectangle ABCD. Given the co-ordinates of the mid points of side AD and BC (p and q respectively) along with their length L (AD = BC = L). Find the co-ordinates of the 4 points A, B, C and D.

Example 1:

Input: L = 2, points = {{1,0},{1,2}}
Output: {{0,0},{0,2},{2,0},{2,2}}
Explanation: 

Example 2:

Input: L = 2.8284, points: {{1,1}, {-1,-1}}
Output: {{-2,0},{0,-2},{0,2},{2,0}}
Explanation: 

Your Task:
You don't need to read or print anything. Your task is to compelete the function findCornerPoints() which takes a vector of two points (p and q), and length l as input parameters and returns a vector containing the floor value of the corner points of the rectangle in sorted order.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= L <= 105
1 <= p, q <= L


*/
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            float[][] points = new float[2][2];
            for(int i = 0; i < 2; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    points[i][j] = Float.parseFloat(S[j]);
                }
            }
            float L = Float.parseFloat(br.readLine().trim());
            Solution obj = new Solution();
            float[][] ans = obj.findCornerPoints(L, points);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(String.format("%4f", ans[i][j]) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public float[][] findCornerPoints(float L, float[][] points)
    {
        // Code here 
        float res[][]=new float[4][2];
        float dx=points[1][0]-points[0][0], dy=points[1][1]-points[0][1], nx=-dy, ny=dx, t= (float) Math.hypot(nx, ny);
        nx=nx/t;
        ny=ny/t;
        L=L/2;
        res[0][0]=points[0][0]+nx*L;
        res[0][1]=points[0][1]+ny*L;
        res[1][0]=points[0][0]-nx*L;
        res[1][1]=points[0][1]-ny*L;
        res[2][0]=points[1][0]+nx*L;
        res[2][1]=points[1][1]+ny*L;
        res[3][0]=points[1][0]-nx*L;
        res[3][1]=points[1][1]-ny*L;

        for(int i=0; i<4; i++){
            res[i][0]= (float) Math.floor(res[i][0]);
            res[i][1]= (float) Math.floor(res[i][1]);
        }
        Arrays.sort(res, Comparator.comparingDouble(value -> value[0]));
        return res;
    }
}
