/*
John was given a task to make a rectangular box during his innovation competition. He was given with
the A cm of wire and B cm2 of special paper. He had to use all the wire (for the 12 edges) and paper (for the 6 sides) to make the box. So what will be the maximum volume of that box?

 

Example 1:

Input:
A = 20, B = 14
Output:
3
Explanation:
The maximum volumed Rectangular
Box we can get is 3cm3.
Example 2:

Input:
A = 20, B = 16
Output:
4
Explanation:
The maximum volumed Rectangular
Box we can get is 4cm3.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getVol() which takes 2 Integers A, and B as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A,B <= 106
*/

/*
For a given perimeter of cuboid we have P = 4(l+b+h) —(i), 
for given area of cuboid we have A = 2 (lb+bh+lh) —(ii). 
Volume of cuboid is V = lbh
Volume is dependent on 3 variables l, b, h. Lets make it dependent on only length.

as V = lbh, 
=> V = l (A/2-(lb+lh)) {from equation (ii)} 
=> V = lA/2 – l2(b+h) 
=> V = lA/2 – l2(P/4-l) {from equation (i)} 
=> V = lA/2 – l2P/4 + l3 —-(iii)
Now differentiate V w.r.t l for finding maximum of volume. 
dV/dl = A/2 – lP/2 + 3l2 
After solving the quadratic in l we have l = (P – (P2-24A)1/2) / 12 
Substituting value of l in (iii), we can easily find the maximum volume.
*/

//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getVol(A,B));
        }
    }
}
// } Driver Code Ends




class Solution {
    static long getVol(int A, int B) {
        // code here
        
          // calculate length
          
        float l
            = (float) (A - Math.sqrt(A * A - 24 * B)) / 12;
        // calculate volume
        float V
            = (float) (l*(B/2.0) - l*l*(A/4.0) + (l*l*l));
            
            
 
        // return result
        return (long) V;
    }
};
