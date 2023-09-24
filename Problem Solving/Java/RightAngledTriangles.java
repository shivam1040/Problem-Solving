/*
Given three integers a, b and c. The task is to check if it is possible to make right angled triangle with sides of length a, b and c.

 

Example 1:

Input:
a = 3, b = 4, c = 5
Output:
Yes
Explanation:
We can form a right angled triangle
with sides of length 3, 4 and 5.
Example 2:

Input:
a = 2, b = 5, c = 8
Output:
No
Explanation:
We can't form a right angled triangle
with sides of length 2, 5 and 8.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function rightAngTri() which takes 3 Integers a,b and c as input and returns "Yes" if it is possible to form a right angled triangle with sides of length a, b, and c, else return "No".

 

Expected Time Complexity: O(log(max(a,b,c)))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= a,b,c <= 108


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
            
            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.rightAngTri(a,b,c));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String rightAngTri(long a, long b, long c) {
        // code here
        long x=a*a, y=b*b, z=c*c;
        //simple pythagoras
        if(x+y==z || y+z==x || z+x==y)
            return "Yes";
        return "No";
    }
};
