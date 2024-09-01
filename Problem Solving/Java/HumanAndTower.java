/*
You are standing at a distance d from a tower of height h. Given either the distance to the tower or height of the tower and the angle of elevation to the top of the tower from the point where you are standing (in degrees), find the rounded down value of the missing variable, i.e if the height is given, you need to find the distance or vice-versa.
Character ' d ' is given if distance is given otherwise character ' h ' is given in input.

Example 1:

Input:
Type = 'd'
Value = 12
Angle of elevation = 67
Output:
28
Explanation:
The height is 28 (rounded down) if the 
distance is 12 and the angle of elevation 
is 67 i.e Tan(67o) ≈ 28 / 12.
Example 2:

Input:
Type = 'h'
Value = 100
Angle of elevation = 66
Output:
44
Explanation:
The distance is 44 (rounded down) when the
height is 100 and the angle of elevation 
is 66 i.e Tan(66o) ≈ 100 / 44.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findHeightOrDistance() which takes a character called type and two numbers value and angle as input parameters and returns the value of the missing variable (rounded down). 

Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)

Constraints:
Type = 'h' or 'd'
1 ≤ value(height or distance) ≤ 1000
4 ≤ angle ≤ 89
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
            char ch = S[0].charAt(0);
            double a = Double.parseDouble(S[1]);
            double b = Double.parseDouble(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.findHeightOrDistance(ch, a, b));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findHeightOrDistance(char type, double value, double angle) {
        // code here
        if(type=='h')
            return (int)Math.floor(value/Math.tan(angle*3.14/180.0));
        return (int)Math.floor(value*Math.tan(angle*3.14/180.0));
    }
};
