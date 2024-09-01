/*
Find the number of days required to reach the top of the staircase of Q stairs if one moves R stairs upwards during daytime and S stairs downwards during night.

 

Example 1:

Input:
R = 5, S = 1, Q = 6
Output:
2
Explanation:
After end of whole first day he will
end up at Stair number 4. Then the next
day, he will reach the top by climbing 2
more stairs.
Example 2:

Input:
R = 2, S = 1, Q = 3
Output:
2
Explanation:
After end of whole first day he will
end up at Stair number 1. Then the next
day, he will reach the top by climbing 2
more stairs.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfDays() which takes 3 Integers R,S and Q as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= S < R <= Q <= 109
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
            String St[] = read.readLine().split(" ");
            
            Long R = Long.parseLong(St[0]);
            Long S = Long.parseLong(St[1]);
            Long Q = Long.parseLong(St[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfDays(R,S,Q));
        }
    }
}
// } Driver Code Ends




class Solution {
    static Long noOfDays(Long R, Long S, Long Q) {
        // code here
        //q-s gives net stair to be climbed, r-s gives net rate of ascend, 1.0 to ensure float operation, division to find the number of days required, ceil to get the max days to either be at top or beyond top
        return (long)Math.ceil(1.0*(Q-S)/(R-S));
    }
};
