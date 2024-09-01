/*
Given the sum of length, breadth and height of a cuboid. The task is to find the maximum volume that can be achieved such that the sum of sides is S.

 

Example 1:

Input:
S = 8
Output:
18
Explanation:
All possible edge dimensions:
[1, 1, 6], volume = 6
[1, 2, 5], volume = 10
[1, 3, 4], volume = 12
[2, 2, 4], volume = 16
[2, 3, 3], volume = 18
So, Maximum possible Volume is 18.
Example 2:

Input:
S = 6
Output:
8
Explanation:
All possible edge dimensions:
[1, 1, 4], volume = 4
[1, 2, 3], volume = 6
[2, 2, 2], volume = 8
So, Maximum possible Volume is 8.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximizeVolume() which takes an Integer S as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
3 <= S <= 106


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
            Long S = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.maximizeVolume(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long maximizeVolume(Long S) {
        // code here
        long a=S/3;
        S-=a;
        long b=S/2;
        S-=b;
        long c=S;
        
        return a*b*c;
    }
};
