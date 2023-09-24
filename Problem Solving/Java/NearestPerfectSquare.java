/*
Given a number N. Find out the nearest number which is a perfect square and also the absolute difference between them.

Example 1:

Input:
N = 25
Output:
25 0
Explanation:
Since 25 is a perfect square, it is the 
closest perfect square to itself and 
absolute difference is 25-25=0.
Example 2:

Input:
N = 1500
Output:
1521 21
Explanation:
Two of the closest perfect squares to 
1521 are 1444.Thus, 1521 is the closest 
perfect square to 1500 and the absolute 
difference  between them is 1521-1500=21.

Your Task:
You don't need to read input or print anything.Your Task is to complete the function nearestPerfectSquare() which takes the number N as input parameters and returns the nearest perfect square as well as the absolute difference between them.


Expected Time Complexity:O(sqrt(N))
Expected Space Auxillary:O(1)


Constraints:
1<=N<=109
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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans[] = ob.nearestPerfectSquare(N);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] nearestPerfectSquare(int N) {
        // code here
        int x=(int)Math.sqrt(N), y=x+1;
        
        if(Math.abs(x*x-N) < Math.abs(y*y-N))
            return new int[]{x*x, Math.abs(x*x-N)};
        return new int[]{y*y, Math.abs(y*y-N)};    
    }
}
