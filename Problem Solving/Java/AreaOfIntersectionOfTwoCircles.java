/*
Given the coordinates of the centres of two circles (X1, Y1) and (X2, Y2) as well as the radii of the respective circles R1 and R2.Find the floor of the area of their intersection.
Note: Use the value of Pi as 3.14

Example 1:

Input:
X1=0,Y1=0,R1=4
X2=6,Y2=0,R2=4
Output:
7
Explanation:
The intersecting area equals 7.25298806.
So,Answer is 7.
Example 2:

Input:
X1=0,Y1=0,R1=5
X2=11,Y2=0,R2=5
Output:
0
Explanation:
The circles don't intersect.

Your Task:
You don't need to read input or print anything. Your task is to complete the function intersectionArea() which takes the coordinates of the centers as well as the radii(X1, Y1, R1, X2, Y2, R2) as input parameters and returns the area of intersection of the two circles.


Expected Time Complexity:O(LogN)
Expected Auxillary Space:O(1)


Constraints:
-109<=X1,Y1,X2,Y2<=109
1<=R1,R2<=109


*/

/*
Firstly calculate the euclidean distance between the two points and store it (say d).
If, d > R1 + R2, then the circle never insects, so, return 0.
Else if, d ? (R1 – R2) and R1 ? R2, then circle with radius R2 is inside the circle with radius R1, so, return floor(Pi * R2 * R2).
Else if, d ? (R2 – R1) and R2 ? R1, then circle with radius R1 is inside the circle with radius R2, so, return floor(Pi * R1 * R1).
Else, find:
alpha = acos((R1 * R1 + d * d – R2 * R2) / (2 * R1 * d)) * 2 [acos is inverse cosine]
beta = acos((R2 * R2 + d * d – R1 * R1) / (2 * R2 * d)) * 2
a1 = 0.5 * beta * R2 * R2 – 0.5 * R2 * R2 * sin(beta)
a2 = 0.5 * alpha * R1 * R1 – 0.5 * R1 * R1 * sin(alpha)
Return, the value of floor(a1+a2).
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
            String s[] = read.readLine().split(" ");
            double X1, Y1, R1, X2, Y2, R2;
            X1 = Double.parseDouble(s[0]);
            Y1 = Double.parseDouble(s[1]);
            R1 = Double.parseDouble(s[2]);
            X2 = Double.parseDouble(s[3]);
            Y2 = Double.parseDouble(s[4]);
            R2 = Double.parseDouble(s[5]);
            Solution ob = new Solution();
            long ans = ob.intersectionArea(X1, Y1, R1, X2, Y2, R2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long intersectionArea(double X1, double Y1, double R1, double X2, double Y2,
                          double R2) {
        // code here
        double pi=3.14;
        
        double d = Math.sqrt(Math.pow(X2 - X1, 2) + Math.pow(Y2 - Y1, 2));
        
        if(d>R1+R2)
            return 0;
        else if(d<=R1-R2 && R1>=R2)
            return (long)Math.floor(pi*R2*R2);
        else if(d<=R2-R1 && R2>=R1)
            return (long)Math.floor(pi*R1*R1);
        else{
            double alpha = Math.acos((R1 * R1 + d * d - R2 * R2)/ (2 * R1 * d))* 2;
            double beta = Math.acos((R2 * R2 + d * d - R1 * R1)/ (2 * R2 * d))* 2;
            double a1=.5*beta*R2*R2-.5*Math.sin(beta)*R2*R2;
            double a2=.5*alpha*R1*R1-.5*Math.sin(alpha)*R1*R1;
            return (long)Math.floor(a1+a2);
        }
    }
};
