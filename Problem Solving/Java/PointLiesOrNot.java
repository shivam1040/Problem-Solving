/*
Given three corner points of a triangle(with coordinates (x1,y1), (x2,y2), and (x3,y3)), and one more point P. Write a function to check whether P lies within the triangle or not.

 

Example 1:

Input:
x1 = 0, y1 = 0, x2 = 20, y2 = 0, 
x3 = 10, y3 = 30, x = 10, y = 15
Output:
Yes
Explanation:
The point (x,y) lies within the 
Triangle.
Example 2:

Input:
x1 = 0, y1 = 0, x2 = 20, y2 = 20, 
x3 = 20, y3 = 0, x = 30, y = 0
Output:
No
Explanation:
The point (x,y) doesn't lie within the Triangle.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isInsideTri() which takes eight Integers x1,x2,x3,y1,y2,y3,x, and y as input and returns "Yes" if the Point lies inside the Triangle else returns "No".

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ x1,x2,x3,y1,y2,y3 ≤ 104
1 ≤ x,y ≤ 104
*/

/*
Let the coordinates of three corners be (x1, y1), (x2, y2) and (x3, y3). And coordinates of the given point P be (x, y)

Calculate area of the given triangle, i.e., area of the triangle ABC in the above diagram. 
Area A = [ x1(y2 - y3) + x2(y3 - y1) + x3(y1-y2)]/2 
Calculate area of the triangle PAB. We can use the same formula for this. Let this area be A1. 
Calculate area of the triangle PBC. Let this area be A2. 
Calculate area of the triangle PAC. Let this area be A3. 
If P lies inside the triangle, then A1 + A2 + A3 must be equal to A. 
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
            String S1[] = read.readLine().split(" ");
            
            int x1 = Integer.parseInt(S[0]);
            int y1 = Integer.parseInt(S[1]);
            int x2 = Integer.parseInt(S[2]);
            int y2 = Integer.parseInt(S[3]);
            int x3 = Integer.parseInt(S[4]);
            int y3 = Integer.parseInt(S[5]);
            
            int x = Integer.parseInt(S1[0]);
            int y = Integer.parseInt(S1[1]);

            Solution ob = new Solution();
            System.out.println(ob.isInsideTri(x1,y1,x2,y2,x3,y3,x,y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String isInsideTri(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        // code here
        //area of abc where a = x1,y1 and so on
        double abc=area(x1,y1,x2,y2,x3,y3);
        //area of pbc where p=x, y
        double pbc=area(x,y,x2,y2,x3,y3);
        double apc=area(x1,y1,x,y,x3,y3);
        double abp=area(x1,y1,x2,y2,x,y);
        
        return abc==pbc+apc+abp ? "Yes" : "No";
    }
    
    private static double area(int x1, int y1, int x2, int y2, int x3, int y3){
        return Math.abs(
            (
                x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)
                )/2.0
            );
    }
};
