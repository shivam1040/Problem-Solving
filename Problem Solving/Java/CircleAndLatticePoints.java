/*
Given an integer R which represents the radius of a circle that has (0,0) as its centre, find the total number of lattice points on the circumference. Lattice Points are points with coordinates as integers in 2-D space.

Example 1:

Input: R = 5
Output: 12
Explanation: (0,5), (0,-5), (5,0), 
(-5,0), (3,4), (-3,4), (-3,-4), (3,-4), 
(4,3), (-4,3), (-4,-3), (4,-3).

Example 2:

Input: R = 88
Output: 4
Explanation: (0,88), (88,0), (0,-88), 
(-88,0)

Your Task:  
You don't need to read input or print anything. Your task is to complete the function latticePoints() which takes R as input and returns the number of lattice points.

Expected Time Complexity: O(RsqrtR)
Expected Auxiliary Space: O(1)


Constraints:
0 ≤ R ≤ 104
*/

/*

 

To find lattice points, we basically need to find values of (x, y) which satisfy the equation x2 + y2 = r2. 
For any value of (x, y) that satisfies the above equation we actually have total 4 different combination which that satisfy the equation. For example if r = 5 and (3, 4) is a pair which satisfies the equation, there are actually 4 combinations (3, 4) , (-3,4) , (-3,-4) , (3,-4). There is an exception though, in case of (0, r) or (r, 0) there are actually 2 points as there is no negative 0.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int r = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.latticePoints(r));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int latticePoints(int r) 
    { 
       //code here.
       if(r<=0)
        return 0;
        
       int res=4;
       
       for(int i=1; i<r; i++){
           int y=r*r-i*i;
           int square=(int)Math.sqrt(y);
           
           if(square*square==y)
            res+=4;
       }
       return res;
    } 
}
