/*
You are given three points a(a1, a2), b(b1, b2) and c(c1, c2) on a page. Find if it’s possible to rotate the page in any direction by any angle, such that the new position of a is same as the old position of b, and the new position of b is same as the old position of c. 

Example 1:

Input: 
a1 = 1, a2 = 1
b1 = 1, b2 = 1
c1 = 1, c2 = 0
Output: 0
Explanation: Not possible.
Example 2:

Input: 
a1 = 0, a2 = 1
b1 = 1, b2 = 1
c1 = 1, c2 = 0
Output: 1
Explanation: Rotate the page by 90 degree.
Your Task:  
You dont need to read input or print anything. Complete the function possibleOrNot() which takes a1, a2, b1, b2, c1 and c2 as input parameters and returns 1 if it is possible to rotate the page or 0 otherwise. 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ a1, a2, b1, b2, c1, c2 ≤ 100


*/

/*
Rotation of page by some angle is only possible if the distance between points ‘a’ and ‘b’ is equal to distance between points ‘b’ and ‘c’. But if the points are on same line, there is no rotation at point ‘b’. The problem has no solution when ‘a’, ‘b’, ‘c’ are in the same line or dis(a, b) != dis(b, c) 
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
            String[] input = new String[6]; 
            input = br.readLine().split(" "); 
            int a1 = Integer.parseInt(input[0]); 
            int a2 = Integer.parseInt(input[1]); 
            int b1 = Integer.parseInt(input[2]); 
            int b2 = Integer.parseInt(input[3]); 
            int c1 = Integer.parseInt(input[4]);
            int c2 = Integer.parseInt(input[5]);
            Solution ob = new Solution();
            System.out.println(ob.possibleOrNot(a1,a2,b1,b2,c1,c2));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int possibleOrNot(int a1, int a2, int b1, int b2, int c1, int c2)
    {
        // code here
            double dist1 = Math.hypot(a1 - b1, a2 - b2);
    double dist2 = Math.hypot(c1 - b1, c2 - b2);
    return dist1 == dist2 ? 1 : 0;
    }
}
